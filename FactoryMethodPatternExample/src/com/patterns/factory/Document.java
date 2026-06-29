package com.patterns.factory;

/**
 * Product interface for documents.
 */
public interface Document {
    void open();
    void save();
    void close();
}
