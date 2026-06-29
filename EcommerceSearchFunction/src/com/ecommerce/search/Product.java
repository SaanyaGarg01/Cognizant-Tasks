package com.ecommerce.search;

/**
 * Represents a product in the e-commerce platform.
 * Implements Comparable to allow sorting by productId.
 */
public class Product implements Comparable<Product> {
    private String productId;
    private String productName;
    private String category;

    public Product(String productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    public String getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return String.format("Product[ID=%s, Name='%s', Category='%s']", productId, productName, category);
    }

    // Comparable implementation based on productId
    @Override
    public int compareTo(Product other) {
        return this.productId.compareTo(other.productId);
    }
}
