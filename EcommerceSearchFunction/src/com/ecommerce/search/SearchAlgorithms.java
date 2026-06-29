package com.ecommerce.search;

public class SearchAlgorithms {

    /**
     * Performs a linear search on an array of Products to find a product by ID.
     * Time Complexity: O(n)
     * 
     * @param products The array of products to search.
     * @param targetId The product ID to search for.
     * @return The Product if found, otherwise null.
     */
    public static Product linearSearch(Product[] products, String targetId) {
        int steps = 0;
        for (Product product : products) {
            steps++;
            if (product.getProductId().equals(targetId)) {
                System.out.println("Steps taken = " + steps);
                return product;
            }
        }
        System.out.println("Steps taken = " + steps + " (Not Found)");
        return null;
    }

    /**
     * Performs a binary search on a sorted array of Products to find a product by ID.
     * Time Complexity: O(log n)
     * 
     * @param products The sorted array of products to search.
     * @param targetId The product ID to search for.
     * @return The Product if found, otherwise null.
     */
    public static Product binarySearch(Product[] products, String targetId) {
        int steps = 0;
        int low = 0;
        int high = products.length - 1;

        while (low <= high) {
            steps++;
            int mid = low + (high - low) / 2;
            int comparison = products[mid].getProductId().compareTo(targetId);

            if (comparison == 0) {
                System.out.println("Steps taken = " + steps);
                return products[mid];
            } else if (comparison < 0) {
                low = mid + 1; // target is in the right half
            } else {
                high = mid - 1; // target is in the left half
            }
        }
        System.out.println("Steps taken = " + steps + " (Not Found)");
        return null;
    }
}
