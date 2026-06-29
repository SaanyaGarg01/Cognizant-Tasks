package com.financial.forecasting;

import java.util.HashMap;
import java.util.Map;

/**
 * Service to predict future financial values using recursive models.
 */
public class FinancialForecasting {

    // Memoization cache to optimize the recursive AR(2) model
    private static final Map<Integer, Double> arCache = new HashMap<>();
    
    // Counter to track number of operations/calls (for analysis)
    public static int recursiveCallCount = 0;

    /**
     * 1. Simple Linear Recursive Future Value calculation.
     * Formula: FV = FV(n-1) * (1 + rate)
     * Time Complexity: O(n)
     * Space Complexity: O(n) (due to call stack)
     * 
     * @param presentValue The starting principal.
     * @param growthRate The constant annual growth rate.
     * @param periods The number of periods (years).
     * @return The future value.
     */
    public static double calculateFutureValue(double presentValue, double growthRate, int periods) {
        // Base case: Year 0
        if (periods == 0) {
            return presentValue;
        }
        // Recursive case
        return calculateFutureValue(presentValue, growthRate, periods - 1) * (1 + growthRate);
    }

    /**
     * 2. Naive Recursive AR(2) (Autoregressive Order 2) model.
     * Represents a model where Year N value depends on both Year N-1 and Year N-2.
     * Time Complexity: O(2^n) - Exponential due to overlapping subproblems!
     * Space Complexity: O(n)
     */
    public static double forecastAR2Naive(int year) {
        recursiveCallCount++;
        // Base Cases
        if (year == 0) return 1000.0; // Starting capital
        if (year == 1) return 1050.0; // Capital after Year 1

        // Recursive case: Value is a weighted combination of past 2 years (e.g., 70% of last year + 35% of year before)
        return 0.7 * forecastAR2Naive(year - 1) + 0.35 * forecastAR2Naive(year - 2);
    }

    /**
     * 3. Optimized Memoized Recursive AR(2) model.
     * Avoids excessive computation by caching results of subproblems.
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public static double forecastAR2Memoized(int year) {
        recursiveCallCount++;
        // Base Cases
        if (year == 0) return 1000.0;
        if (year == 1) return 1050.0;

        // Check cache first
        if (arCache.containsKey(year)) {
            return arCache.get(year);
        }

        // Compute and store in cache
        double result = 0.7 * forecastAR2Memoized(year - 1) + 0.35 * forecastAR2Memoized(year - 2);
        arCache.put(year, result);
        return result;
    }

    /**
     * 4. Optimized Iterative Future Value calculation.
     * Avoids stack overflow and operates in constant space.
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static double calculateFutureValueIterative(double presentValue, double growthRate, int periods) {
        double futureValue = presentValue;
        for (int i = 0; i < periods; i++) {
            futureValue *= (1 + growthRate);
        }
        return futureValue;
    }

    /**
     * Reset the helper call counter.
     */
    public static void resetCallCount() {
        recursiveCallCount = 0;
    }

    /**
     * Clear the memoization cache.
     */
    public static void clearCache() {
        arCache.clear();
    }
}
