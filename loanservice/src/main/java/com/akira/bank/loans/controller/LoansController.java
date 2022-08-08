package com.akira.bank.loans.controller;

/*
*  @author by Akira Nadhira
* */

import com.akira.bank.loans.config.LoansServiceConfig;
import com.akira.bank.loans.model.Loans;
import com.akira.bank.loans.model.Customer;
import com.akira.bank.loans.model.Properties;
import com.akira.bank.loans.repository.LoansRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LoansController {

    @Autowired
    private LoansRepository loansRepository;

    @Autowired
    LoansServiceConfig loansServiceConfig;

    @PostMapping("/myLoans")
    public List<Loans> getLoansDetails(@RequestBody Customer customer) {
        List<Loans> loans = loansRepository.findByCustomerIdOrderByStartDateDesc(customer.getCustomerId());
        if (loans != null) {
            return loans;
        } else {
            return null;
        }
    }

    @GetMapping("loans/properties")
    public String getPropertyDetails() throws JsonProcessingException {
        ObjectWriter objectWriter = new ObjectMapper().writer().withDefaultPrettyPrinter();
        Properties properties = new Properties(loansServiceConfig.getMessage(), loansServiceConfig.getBuildVersion(), loansServiceConfig.getMailDetails(),
                loansServiceConfig.getActiveBranches());
        String jsonString = objectWriter.writeValueAsString(properties);

        return jsonString;

    }
}
