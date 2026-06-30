package com.cognizant.ormlearn;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.service.CountryService;

/**
 * Main bootstrap class for the Spring Boot JPA example.
 */
@SpringBootApplication
public class OrmLearnApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);
    
    private static CountryService countryService;

    public static void main(String[] args) {
        LOGGER.info("Inside main");
        
        // Load the context and bind the application instance variables
        ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
        
        countryService = context.getBean(CountryService.class);

        // Run verification test
        testGetAllCountries();
    }

    /**
     * Test execution helper to get all country data and print via logger.
     */
    private static void testGetAllCountries() {
        LOGGER.info("Start testGetAllCountries");
        
        try {
            List<Country> countries = countryService.getAllCountries();
            LOGGER.debug("countries={}", countries);
        } catch (Exception e) {
            LOGGER.error("Failed to fetch country records. Please verify MySQL server connectivity.", e);
        }
        
        LOGGER.info("End testGetAllCountries");
    }
}
