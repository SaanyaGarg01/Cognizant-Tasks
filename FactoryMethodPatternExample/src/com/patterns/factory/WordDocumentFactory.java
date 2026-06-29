package com.patterns.factory;

/**
 * Concrete Creator for Word Documents.
 */
public class WordDocumentFactory extends DocumentFactory {
    @Override
    public Document createDocument() {
        return new WordDocument();
    }
}
