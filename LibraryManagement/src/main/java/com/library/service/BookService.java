package com.library.service;

import com.library.repository.BookRepository;

/**
 * Service class performing business operations on Books.
 */
public class BookService {
    private BookRepository bookRepository;

    // Setter for dependency injection
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void manageBooks() {
        System.out.println("BookService: Managing book catalog...");
        bookRepository.printRepositoryAction();
    }
}
