package com.ecommerce.search;

import java.util.Arrays;

public class SearchTest {

    public static void main(String[] args) {
        // Create an array of mock products (unsorted)
        Product[] products = {
            new Product("P1005", "Wireless Mouse", "Electronics"),
            new Product("P1001", "Mechanical Keyboard", "Electronics"),
            new Product("P1009", "USB-C Adapter", "Accessories"),
            new Product("P1003", "Gaming Monitor", "Electronics"),
            new Product("P1007", "Leather Wallet", "Accessories"),
            new Product("P1002", "Noise-Cancelling Headphones", "Electronics"),
            new Product("P1008", "Water Bottle", "Home & Kitchen"),
            new Product("P1004", "Desk Lamp", "Home & Kitchen"),
            new Product("P1006", "Running Shoes", "Apparel")
        };

        System.out.println("=== E-Commerce Search Platform Demonstration ===\n");

        // 1. Linear Search Test (works on unsorted arrays)
        System.out.println("--- 1. Testing Linear Search ---");
        String targetId1 = "P1002";
        System.out.println("Searching for product: " + targetId1);
        Product result1 = SearchAlgorithms.linearSearch(products, targetId1);
        System.out.println("Result: " + result1);
        System.out.println();

        // 2. Binary Search Test (requires sorted arrays)
        System.out.println("--- 2. Testing Binary Search ---");
        // Sort the array first for binary search
        Product[] sortedProducts = Arrays.copyOf(products, products.length);
        Arrays.sort(sortedProducts);

        System.out.println("Sorted products list (by productId):");
        for (Product p : sortedProducts) {
            System.out.println("  " + p.getProductId() + " : " + p.getProductName());
        }
        System.out.println();

        String targetId2 = "P1002";
        System.out.println("Searching for product: " + targetId2);
        Product result2 = SearchAlgorithms.binarySearch(sortedProducts, targetId2);
        System.out.println("Result: " + result2);
        System.out.println();

        // 3. Testing "Not Found" scenario
        System.out.println("--- 3. Testing Non-Existent Product Search ---");
        String missingId = "P9999";
        System.out.println("Searching for missing product: " + missingId);
        System.out.print("Linear Search: ");
        SearchAlgorithms.linearSearch(products, missingId);
        System.out.print("Binary Search: ");
        SearchAlgorithms.binarySearch(sortedProducts, missingId);
        System.out.println();

        // 4. Large Dataset Performance Simulation
        simulateLargeDataset();
    }

    private static void simulateLargeDataset() {
        System.out.println("--- 4. Large Dataset Simulation (1,000,000 Products) ---");
        int size = 1000000;
        Product[] largeArray = new Product[size];
        
        // Populate array with sequential IDs (already sorted)
        for (int i = 0; i < size; i++) {
            // IDs look like P000000, P000001, etc.
            String id = String.format("P%06d", i);
            largeArray[i] = new Product(id, "Product " + i, "Category");
        }

        // Search for a product near the end to demonstrate worst-case scenario
        String targetId = String.format("P%06d", size - 10);
        System.out.println("Searching for product near the end (" + targetId + ") out of " + size + " items:");

        System.out.print("Linear Search: ");
        SearchAlgorithms.linearSearch(largeArray, targetId);

        System.out.print("Binary Search: ");
        SearchAlgorithms.binarySearch(largeArray, targetId);
    }
}
