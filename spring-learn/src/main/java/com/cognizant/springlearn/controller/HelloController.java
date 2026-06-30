package com.cognizant.springlearn.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller exposing the Hello REST endpoint.
 */
@RestController
public class HelloController {

    private static final Logger LOGGER = LoggerFactory.getLogger(HelloController.class);

    /**
     * Responds with a hardcoded greeting text.
     * @return String greeting.
     */
    @GetMapping("/hello")
    public String sayHello() {
        LOGGER.info("Start sayHello");
        String greeting = "Hello World!!";
        LOGGER.info("End sayHello");
        return greeting;
    }
}
