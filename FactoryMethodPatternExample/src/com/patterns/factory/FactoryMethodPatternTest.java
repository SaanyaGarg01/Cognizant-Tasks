package com.patterns.factory;

/**
 * Test class to verify the Factory Method pattern implementation.
 */
public class FactoryMethodPatternTest {

    public static void main(String[] args) {
        System.out.println("=== Starting Factory Method Pattern Verification ===\n");

        // 1. Process a Word Document using WordDocumentFactory
        DocumentFactory wordFactory = new WordDocumentFactory();
        System.out.println("Client: Requesting a Word document via WordDocumentFactory.");
        wordFactory.processDocument();

        // 2. Process a PDF Document using PdfDocumentFactory
        DocumentFactory pdfFactory = new PdfDocumentFactory();
        System.out.println("Client: Requesting a PDF document via PdfDocumentFactory.");
        pdfFactory.processDocument();

        // 3. Process an Excel Document using ExcelDocumentFactory
        DocumentFactory excelFactory = new ExcelDocumentFactory();
        System.out.println("Client: Requesting an Excel document via ExcelDocumentFactory.");
        excelFactory.processDocument();
        
        // 4. Directly test document creation without high-level factory helper methods
        System.out.println("Client: Direct creation of documents:");
        Document doc = excelFactory.createDocument();
        System.out.println("Created document type: " + doc.getClass().getSimpleName());
    }
}
