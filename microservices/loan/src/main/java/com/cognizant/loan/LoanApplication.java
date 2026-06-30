package com.cognizant.loan;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main application entry to start the Loan microservice.
 */
@SpringBootApplication
public class LoanApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoanApplication.class);

    public static void main(String[] args) {
        LOGGER.info("Inside main of LoanApplication");
        SpringApplication.run(LoanApplication.class, args);
        LOGGER.info("LoanApplication started successfully");
    }
}
