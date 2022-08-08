package com.akira.bank.cards.config;

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
@ConfigurationProperties(prefix = "loanservice")
@Getter
@Setter
@ToString
public class CardsServiceConfig {

    private String message;
    private String buildVersion;
    private Map<String, String> mailDetails;
    private List<String> activeBranches;

}
