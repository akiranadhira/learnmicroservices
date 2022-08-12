package com.akira.bank.accounts.controller;

/*
*  @author by Akira Nadhira
* */

import com.akira.bank.accounts.config.AccountsServiceConfig;
import com.akira.bank.accounts.model.*;
import com.akira.bank.accounts.repository.AccountsRepository;
import com.akira.bank.accounts.service.clients.CardsFeignClient;
import com.akira.bank.accounts.service.clients.LoansFeignClient;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AccountsController {

    @Autowired
    private AccountsRepository accountsRepository;

    @Autowired
    AccountsServiceConfig accountsServiceConfig;

    @Autowired
    CardsFeignClient cardsFeignClient;

    @Autowired
    LoansFeignClient loansFeignClient;

    @PostMapping("/myAccount")
    public Accounts getAccountDetails(@RequestBody Customer customer) {
        Accounts accounts = accountsRepository.findByCustomerId(customer.getCustomerId());
        if (accounts != null) {
            return accounts;
        } else {
            return null;
        }
    }

    @GetMapping("account/properties")
    public String getPropertyDetails() throws JsonProcessingException {
        ObjectWriter objectWriter = new ObjectMapper().writer().withDefaultPrettyPrinter();
        Properties properties = new Properties(accountsServiceConfig.getMessage(), accountsServiceConfig.getBuildVersion(), accountsServiceConfig.getMailDetails(),
                accountsServiceConfig.getActiveBranches());
        String jsonString = objectWriter.writeValueAsString(properties);

        return jsonString;

    }

    @PostMapping("myCustomerDetails")
//    @CircuitBreaker(name = "detailsForCustomerSupportApp", fallbackMethod = "myCustomerDetailsFallBack")
    @Retry(name = "retryForCustomerDetails", fallbackMethod = "myCustomerDetailsFallBack")
    public CustomerDetails myCustomerDetails(@RequestBody Customer customer) {
        Accounts accounts = accountsRepository.findByCustomerId(customer.getCustomerId());
        List<Loans> loans = loansFeignClient.getLoansDetails(customer);
        List<Cards> cards = cardsFeignClient.getCardDetails(customer);

        CustomerDetails customerDetails = new CustomerDetails();
        customerDetails.setAccounts(accounts);
        customerDetails.setLoans(loans);
        customerDetails.setCards(cards);

        return customerDetails;

    }

    private CustomerDetails myCustomerDetailsFallBack (Customer customer, Throwable throwable) {
        Accounts accounts = accountsRepository.findByCustomerId(customer.getCustomerId());
        List<Loans> loans = loansFeignClient.getLoansDetails(customer);
        CustomerDetails customerDetails = new CustomerDetails();
        customerDetails.setAccounts(accounts);
        customerDetails.setLoans(loans);

        return customerDetails;

    }

    @GetMapping("/sayHello")
    @RateLimiter(name= "sayHello", fallbackMethod = "sayHelloFallback")
    public String sayHello() {
        return "Hello, Welcome to Akira Bank";

    }

    private String sayHelloFallback (Throwable throwable) {
        return "Hi this is Fallback, Welcome to Akira Bank";

    }
}
