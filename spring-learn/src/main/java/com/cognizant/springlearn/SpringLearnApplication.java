package com.cognizant.springlearn;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
        
        displayDate();
    }

    /**
     * Loads date-format.xml from classpath, retrieves the SimpleDateFormat bean,
     * parses a date string, and logs the output.
     */
    private static void displayDate() {
        LOGGER.info("Start displayDate");
        try {
            ApplicationContext context = new ClassPathXmlApplicationContext("date-format.xml");
            SimpleDateFormat format = context.getBean("dateFormat", SimpleDateFormat.class);
            Date date = format.parse("31/12/2018");
            System.out.println("Parsed Date Result: " + date);
        } catch (Exception e) {
            LOGGER.error("Failed to load or parse date from Spring XML Configuration", e);
        }
        LOGGER.info("End displayDate");
    }
}
