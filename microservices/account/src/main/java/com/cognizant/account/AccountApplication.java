package com.cognizant.account;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main application entry to start the Account microservice.
 */
@SpringBootApplication
public class AccountApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(AccountApplication.class);

    public static void main(String[] args) {
        LOGGER.info("Inside main of AccountApplication");
        SpringApplication.run(AccountApplication.class, args);
        LOGGER.info("AccountApplication started successfully");
    }
}
