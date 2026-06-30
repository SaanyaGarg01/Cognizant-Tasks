package com.cognizant.account.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.cognizant.account.model.Account;

/**
 * Controller exposing Account REST API endpoints.
 */
@RestController
public class AccountController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AccountController.class);

    /**
     * Retrieves account details based on account number parameter.
     * @param number String account number path variable.
     * @return Account details object.
     */
    @GetMapping("/accounts/{number}")
    public Account getAccount(@PathVariable String number) {
        LOGGER.info("Start getAccount for number: {}", number);
        
        // Return dummy data as per specifications
        Account account = new Account(number, "savings", 234343.0);
        
        LOGGER.info("End getAccount. Returned: {}", account);
        return account;
    }
}
