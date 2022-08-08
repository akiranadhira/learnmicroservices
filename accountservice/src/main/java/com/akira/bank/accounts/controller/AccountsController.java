package com.akira.bank.accounts.controller;

/*
*  @author by Akira Nadhira
* */

import com.akira.bank.accounts.config.AccountsServiceConfig;
import com.akira.bank.accounts.model.Accounts;
import com.akira.bank.accounts.model.Customer;
import com.akira.bank.accounts.model.Properties;
import com.akira.bank.accounts.repository.AccountsRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountsController {

    @Autowired
    private AccountsRepository accountsRepository;

    @Autowired
    AccountsServiceConfig accountsServiceConfig;

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
}
