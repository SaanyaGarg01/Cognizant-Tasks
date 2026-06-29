package com.patterns.singleton;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Logger class implementing the Singleton design pattern.
 * This class ensures that only one instance of the Logger exists
 * throughout the application lifecycle.
 */
public class Logger {

    // 1. Private static instance of the class (volatile for thread safety)
    private static volatile Logger instance;

    // A formatter for date and time in log messages
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");

    // 2. Private constructor to prevent instantiation from outside the class
    private Logger() {
        // Prevent instantiation via reflection
        if (instance != null) {
            throw new IllegalStateException("Logger instance already created. Use getInstance() method.");
        }
        System.out.println("[System] Logger initialized.");
    }

    // 3. Public static method to get the single instance of the class
    // Implements double-checked locking for thread-safety and performance
    public static Logger getInstance() {
        if (instance == null) {
            synchronized (Logger.class) {
                if (instance == null) {
                    instance = new Logger();
                }
            }
        }
        return instance;
    }

    /**
     * Logs a message with an INFO prefix and a timestamp.
     * @param message The message to log.
     */
    public void log(String message) {
        log("INFO", message);
    }

    /**
     * Logs a message with a custom level and a timestamp.
     * @param level The log level (e.g., INFO, WARNING, ERROR).
     * @param message The message to log.
     */
    public void log(String level, String message) {
        String timestamp = LocalDateTime.now().format(formatter);
        System.out.printf("[%s] [%s] %s%n", timestamp, level.toUpperCase(), message);
    }
}
