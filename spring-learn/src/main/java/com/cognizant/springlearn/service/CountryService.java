package com.cognizant.springlearn.service;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import com.cognizant.springlearn.model.Country;

/**
 * Service class performing country-related queries.
 */
@Service
public class CountryService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CountryService.class);

    /**
     * Filters the country list from XML to find a match by code (case-insensitive).
     * @param code String country code.
     * @return Country object or null if not found.
     */
    public Country getCountry(String code) {
        LOGGER.info("Start getCountry service for code: " + code);
        
        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
        @SuppressWarnings("unchecked")
        List<Country> countries = context.getBean("countryList", List.class);
        
        // Match country code case-insensitively using streams
        Country match = countries.stream()
                .filter(c -> c.getCode().equalsIgnoreCase(code))
                .findFirst()
                .orElse(null);
        
        LOGGER.info("End getCountry service. Match found: " + match);
        return match;
    }
}
