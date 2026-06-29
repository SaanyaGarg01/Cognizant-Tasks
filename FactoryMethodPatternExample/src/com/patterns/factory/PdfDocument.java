package com.patterns.factory;

/**
 * Concrete Product representing a PDF Document.
 */
public class PdfDocument implements Document {
    @Override
    public void open() {
        System.out.println("Opening PDF document (.pdf) in reader mode...");
    }

    @Override
    public void save() {
        System.out.println("Exporting PDF document...");
    }

    @Override
    public void close() {
        System.out.println("Closing PDF document.");
    }
}
