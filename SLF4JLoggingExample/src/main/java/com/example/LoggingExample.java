package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Demonstrates logging error messages and warning levels using SLF4J and Logback.
 */
public class LoggingExample {
    
    // Create the logger instance associated with this class
    private static final Logger logger = LoggerFactory.getLogger(LoggingExample.class);

    public static void main(String[] args) {
        System.out.println("=== SLF4J Logging Demonstration ===");
        
        // Log an info message (standard level)
        logger.info("Application starting up...");

        // Log a warning message
        logger.warn("This is a warning message - indicating a potential issue that doesn't stop the application.");

        // Log an error message
        logger.error("This is an error message - indicating a serious failure occurred.");

        System.out.println("=== Execution Completed ===");
    }
}
