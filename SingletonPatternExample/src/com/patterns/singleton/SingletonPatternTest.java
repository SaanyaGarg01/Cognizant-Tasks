package com.patterns.singleton;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Test class to verify the Singleton implementation of the Logger class.
 */
public class SingletonPatternTest {

    public static void main(String[] args) {
        System.out.println("=== Starting Singleton Pattern Verification ===");

        // Test 1: Verify single instance in a single-threaded environment
        testSingleThreadedAccess();

        System.out.println();

        // Test 2: Verify thread safety in a multi-threaded environment
        testMultiThreadedAccess();
    }

    /**
     * Verifies that multiple calls to getInstance() in the same thread
     * return the exact same object reference.
     */
    private static void testSingleThreadedAccess() {
        System.out.println("[Test 1] Single-Threaded Access Test");

        // Get two instances of Logger
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        // Use the logger instances to log messages
        logger1.log("This is a log message using logger1 reference.");
        logger2.log("This is a log message using logger2 reference.");

        // Check if both references point to the same object
        boolean isSameInstance = (logger1 == logger2);

        System.out.println("logger1 hashcode: " + logger1.hashCode());
        System.out.println("logger2 hashcode: " + logger2.hashCode());
        System.out.println("Are both references identical? " + isSameInstance);

        if (isSameInstance) {
            System.out.println("SUCCESS: Both references point to the same Logger instance.");
        } else {
            System.out.println("FAILURE: Logger is not a Singleton! Multiple instances were found.");
        }
    }

    /**
     * Verifies that even with concurrent access from multiple threads,
     * only a single instance of Logger is created, and all threads receive
     * the exact same instance.
     */
    private static void testMultiThreadedAccess() {
        System.out.println("[Test 2] Multi-Threaded Concurrent Access Test");

        int threadCount = 10;
        ExecutorService executor = Executors.newFixedThreadPool(threadCount);
        
        // Thread-safe list to collect logger instances from different threads
        List<Logger> loggers = Collections.synchronizedList(new ArrayList<>());

        // Submit tasks to execute concurrently
        for (int i = 0; i < threadCount; i++) {
            final int threadId = i;
            executor.submit(() -> {
                Logger logger = Logger.getInstance();
                loggers.add(logger);
                logger.log("DEBUG", "Logged from concurrent Thread " + threadId);
            });
        }

        // Shutdown executor and wait for tasks to finish
        executor.shutdown();
        try {
            if (!executor.awaitTermination(5, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }

        // Verify that all retrieved instances are identical
        boolean allIdentical = true;
        Logger primaryInstance = Logger.getInstance();

        for (Logger logger : loggers) {
            if (logger != primaryInstance) {
                allIdentical = false;
                break;
            }
        }

        System.out.println("Total logger references retrieved from threads: " + loggers.size());
        System.out.println("Are all retrieved instances identical? " + allIdentical);

        if (allIdentical && loggers.size() == threadCount) {
            System.out.println("SUCCESS: Thread safety verified. Only one instance of Logger was created and shared across all threads.");
        } else {
            System.out.println("FAILURE: Multiple Logger instances were created across threads!");
        }
    }
}
