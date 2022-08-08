package com.akira.bank.loans.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter
@Setter
public class Properties {

    private String message;
    private String buildVersion;
    private Map<String, String> mailDetails;
    private List<String> activeBranches;

    public Properties(String message, String buildVersion, Map<String, String> mailDetails, List<String> activeBranches) {
        this.message = message;
        this.buildVersion = buildVersion;
        this.mailDetails = mailDetails;
        this.activeBranches = activeBranches;

    }
}
