package com.financial.forecasting;

public class ForecastingTest {

    public static void main(String[] args) {
        System.out.println("=== Financial Forecasting Tool Demonstration ===\n");

        // Test 1: Simple Linear Recursive Future Value
        double principal = 10000.0; // $10,000
        double rate = 0.05;         // 5% growth rate
        int years = 10;
        
        System.out.println("--- 1. Testing Linear Recursive Future Value ---");
        System.out.printf("Starting Principal: $%,.2f%n", principal);
        System.out.printf("Annual Growth Rate: %.1f%%%n", rate * 100);
        System.out.println("Forecast Periods: " + years + " years");
        
        double recursiveResult = FinancialForecasting.calculateFutureValue(principal, rate, years);
        double iterativeResult = FinancialForecasting.calculateFutureValueIterative(principal, rate, years);
        
        System.out.printf("Recursive Forecast Result: $%,.2f%n", recursiveResult);
        System.out.printf("Iterative Forecast Result: $%,.2f%n", iterativeResult);
        System.out.println();

        // Test 2: Autoregressive AR(2) Model - Naive vs Memoized (Comparing Call Counts)
        int targetYear = 30;
        System.out.println("--- 2. Autoregressive AR(2) Forecasting Model Comparison ---");
        System.out.println("Target Forecast Year: " + targetYear);

        // A. Naive Recursive Approach
        System.out.println("\n[Running Naive Recursive AR(2)]");
        long startTimeNaive = System.nanoTime();
        FinancialForecasting.resetCallCount();
        double naiveForecast = FinancialForecasting.forecastAR2Naive(targetYear);
        long endTimeNaive = System.nanoTime();
        int naiveCalls = FinancialForecasting.recursiveCallCount;
        double naiveTimeMs = (endTimeNaive - startTimeNaive) / 1_000_000.0;
        System.out.printf("Naive Forecast Value: $%,.2f%n", naiveForecast);
        System.out.println("Total recursive calls made: " + naiveCalls);
        System.out.printf("Execution Time: %.4f ms%n", naiveTimeMs);

        // B. Memoized Recursive Approach
        System.out.println("\n[Running Memoized Recursive AR(2)]");
        long startTimeMemo = System.nanoTime();
        FinancialForecasting.resetCallCount();
        FinancialForecasting.clearCache();
        double memoForecast = FinancialForecasting.forecastAR2Memoized(targetYear);
        long endTimeMemo = System.nanoTime();
        int memoCalls = FinancialForecasting.recursiveCallCount;
        double memoTimeMs = (endTimeMemo - startTimeMemo) / 1_000_000.0;
        System.out.printf("Memoized Forecast Value: $%,.2f%n", memoForecast);
        System.out.println("Total recursive calls made: " + memoCalls);
        System.out.printf("Execution Time: %.4f ms%n", memoTimeMs);

        // Comparison Summary
        System.out.println("\n--- Summary of Optimizations ---");
        System.out.printf("Naive Call Count: %d%n", naiveCalls);
        System.out.printf("Memoized Call Count: %d%n", memoCalls);
        double savingsMultiplier = (double) naiveCalls / memoCalls;
        System.out.printf("Optimization reduced recursive calls by: %,.1fx%n", savingsMultiplier);
    }
}
