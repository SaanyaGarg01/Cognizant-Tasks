package com.patterns.factory;

/**
 * Concrete Creator for Excel Documents.
 */
public class ExcelDocumentFactory extends DocumentFactory {
    @Override
    public Document createDocument() {
        return new ExcelDocument();
    }
}
