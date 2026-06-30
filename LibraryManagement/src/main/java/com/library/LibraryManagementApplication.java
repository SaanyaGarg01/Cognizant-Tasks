package com.library;

import com.library.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Entry point to bootstrap the Spring context and test bean loading and dependency injection.
 */
public class LibraryManagementApplication {
    public static void main(String[] args) {
        System.out.println("=== Initializing Spring Application Context ===");
        
        // 1. Load application context XML file
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        
        System.out.println("=== Context Loaded Successfully ===\n");

        // 2. Retrieve BookService bean
        BookService bookService = (BookService) context.getBean("bookService");

        // 3. Test configuration and verify dependency injection by invoking method
        bookService.manageBooks();
    }
}
