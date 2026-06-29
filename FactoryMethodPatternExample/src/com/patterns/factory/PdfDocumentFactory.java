package com.patterns.factory;

/**
 * Concrete Creator for PDF Documents.
 */
public class PdfDocumentFactory extends DocumentFactory {
    @Override
    public Document createDocument() {
        return new PdfDocument();
    }
}
