package com.akira.bank.accounts.config;

/*
* @author Akira Nadhira
* */

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Map;

@Configuration
@ConfigurationProperties(prefix = "accountservice")
@Getter
@Setter
@ToString
public class AccountsServiceConfig {

    private String message;
    private String buildVersion;
    private Map<String, String> mailDetails;
    private List<String> activeBranches;

}
