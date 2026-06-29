package com.patterns.factory;

/**
 * Abstract Creator class defining the Factory Method.
 */
public abstract class DocumentFactory {

    // The Factory Method
    public abstract Document createDocument();

    // An operation that uses the created document
    public void processDocument() {
        System.out.println("--- Processing Document ---");
        Document doc = createDocument();
        doc.open();
        doc.save();
        doc.close();
        System.out.println("--- Process Completed ---\n");
    }
}
