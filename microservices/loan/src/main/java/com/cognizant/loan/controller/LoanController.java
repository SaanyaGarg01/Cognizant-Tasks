package com.cognizant.loan.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.cognizant.loan.model.Loan;

/**
 * Controller exposing Loan REST API endpoints.
 */
@RestController
public class LoanController {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoanController.class);

    /**
     * Retrieves loan account details based on loan number parameter.
     * @param number String loan number path variable.
     * @return Loan details object.
     */
    @GetMapping("/loans/{number}")
    public Loan getLoan(@PathVariable String number) {
        LOGGER.info("Start getLoan for number: {}", number);
        
        // Return dummy data as per specifications
        Loan loan = new Loan(number, "car", 400000.0, 3258.0, 18);
        
        LOGGER.info("End getLoan. Returned: {}", loan);
        return loan;
    }
}
