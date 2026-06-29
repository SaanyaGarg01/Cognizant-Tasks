package com.patterns.factory;

/**
 * Concrete Product representing a Word Document.
 */
public class WordDocument implements Document {
    @Override
    public void open() {
        System.out.println("Opening Word document (.docx)...");
    }

    @Override
    public void save() {
        System.out.println("Saving Word document to disk...");
    }

    @Override
    public void close() {
        System.out.println("Closing Word document.");
    }
}
