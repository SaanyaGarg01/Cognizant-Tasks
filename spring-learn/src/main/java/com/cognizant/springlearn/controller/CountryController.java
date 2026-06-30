package com.cognizant.springlearn.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.cognizant.springlearn.model.Country;
import com.cognizant.springlearn.service.CountryService;

/**
 * Controller exposing Country REST API endpoints.
 */
@RestController
public class CountryController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CountryController.class);

    @Autowired
    private CountryService countryService;

    /**
     * Responds with India country details by loading the 'in' bean from country.xml.
     * @return Country object representing India.
     */
    @RequestMapping(value = "/country", method = RequestMethod.GET)
    public Country getCountryIndia() {
        LOGGER.info("Start getCountryIndia");
        
        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
        Country india = context.getBean("in", Country.class);
        
        LOGGER.info("End getCountryIndia");
        return india;
    }

    /**
     * Responds with list of all countries loaded from countryList bean in country.xml.
     * @return List of Country objects.
     */
    @SuppressWarnings("unchecked")
    @GetMapping("/countries")
    public List<Country> getAllCountries() {
        LOGGER.info("Start getAllCountries");
        
        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
        List<Country> countries = context.getBean("countryList", List.class);
        
        LOGGER.info("End getAllCountries");
        return countries;
    }

    /**
     * Retrieves country data filtering by country code path variable (case-insensitive).
     * Maps both /countries/{code} and /country/{code} to support sample requests.
     * @param code String country code.
     * @return Country object.
     */
    @GetMapping({"/countries/{code}", "/country/{code}"})
    public Country getCountry(@PathVariable("code") String code) {
        LOGGER.info("Start getCountry controller for code: " + code);
        Country country = countryService.getCountry(code);
        LOGGER.info("End getCountry controller");
        return country;
    }
}
