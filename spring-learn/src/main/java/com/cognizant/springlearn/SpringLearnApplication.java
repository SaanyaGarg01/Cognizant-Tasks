package com.cognizant.springlearn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main bootstrap class for the Spring Web MVC example.
 */
@SpringBootApplication
public class SpringLearnApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);

    public static void main(String[] args) {
        LOGGER.info("Inside main - starting SpringLearnApplication");
        SpringApplication.run(SpringLearnApplication.class, args);
        LOGGER.info("Inside main - SpringLearnApplication successfully started");
    }
}
