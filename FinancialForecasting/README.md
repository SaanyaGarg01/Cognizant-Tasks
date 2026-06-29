# Financial Forecasting Tool (Recursive Algorithms)

This project implements a **Financial Forecasting Tool** using Java to predict future asset values based on past data. It focuses on exploring **Recursive Algorithms**, analyzing their time and space complexity, and implementing optimizations (Memoization and Iteration) to prevent excessive computational overhead.

---

## 1. Understanding Recursive Algorithms

### What is Recursion?
**Recursion** is a programming technique where a method calls itself to solve a smaller instance of the same problem. A recursive method typically contains two parts:
1. **Base Case(s)**: Simple, terminating conditions that return a value without making further recursive calls, preventing infinite loops.
2. **Recursive Step(s)**: The core logic where the method breaks down the problem and calls itself with modified parameters that move closer to the base case.

### How Recursion Simplifies Problems
Recursion is highly useful for problems that can be defined in terms of smaller subproblems of the same nature (self-similarity). Examples include:
- **Divide and Conquer** algorithms (e.g., QuickSort, MergeSort).
- **Tree/Graph Traversals** (e.g., File system directories, DOM tree nodes).
- **Mathematical Recurrence Relations** (e.g., Factorials, Fibonacci, Autoregressive financial forecasting models).

By using recursion, the code matches the mathematical representation directly, resulting in cleaner, shorter, and more readable code compared to complex nested loops.

---

## 2. Project Structure

```text
FinancialForecasting/
│
├── README.md                           # Explanation of recursion, complexity & optimizations
└── src/
    └── com/
        └── financial/
            └── forecasting/
                ├── FinancialForecasting.java # Linear recursion, naive AR(2), memoized AR(2)
                └── ForecastingTest.java     # Test driver with call-count comparisons
```

---

## 3. Recursive Models & Optimization Analysis

### Model 1: Simple Linear Recursive Future Value
Calculates future values based on a constant interest rate.
- **Formula**: \(FV = FV(n - 1) \times (1 + r)\)
- **Time Complexity**: **\(O(n)\)** where \(n\) is the number of periods, as there is 1 recursive call per year.
- **Space Complexity**: **\(O(n)\)** due to the execution call stack frame for each year.

### Model 2: Autoregressive AR(2) Model
A more realistic model where the forecast for year \(n\) depends on weighted values of the *past two years*.
- **Formula**: \(Value(n) = 0.7 \times Value(n - 1) + 0.35 \times Value(n - 2)\)

#### A. Naive Recursive Version (`forecastAR2Naive`)
- **Overlap**: Calculates the same year's value multiple times (e.g., to find year 5, it calls year 4 and 3. To find year 4, it calls year 3 and 2. Year 3 is calculated twice).
- **Time Complexity**: **\(O(2^n)\)** (Exponential growth). For year 30, it requires **over 2.6 million recursive calls**!
- **Excessive Computation**: The recursive tree grows exponentially, making large forecasts impossible.

#### B. Memoized Recursive Version (`forecastAR2Memoized`) - **Optimization 1**
- **Approach**: Caches results in a hash map (`arCache`). Before performing recursive calls, it checks if the value has already been computed.
- **Time Complexity**: **\(O(n)\)** (Linear). Each year's value is calculated exactly once. For year 30, it requires **only 59 recursive calls**!
- **Space Complexity**: **\(O(n)\)** for cache storage and call stack.

#### C. Iterative Version (`calculateFutureValueIterative`) - **Optimization 2**
- **Approach**: Converts the recursion into a standard loop.
- **Time Complexity**: **\(O(n)\)** (Linear).
- **Space Complexity**: **\(O(1)\)** (Constant). Since there are no recursive call stack frames, it avoids stack overflow hazards entirely, making it safe for extremely large values of \(n\).

---

## 4. How to Compile and Run

### Run from Terminal (from project root directory)

1. **Navigate to the project root directory**:
   ```bash
   cd FinancialForecasting
   ```

2. **Compile the source files**:
   ```bash
   javac -d bin src/com/financial/forecasting/*.java
   ```

3. **Run the test driver**:
   ```bash
   java -cp bin com.financial.forecasting.ForecastingTest
   ```

### Simulation Output
```text
=== Financial Forecasting Tool Demonstration ===

--- 1. Testing Linear Recursive Future Value ---
Starting Principal: $10,000.00
Annual Growth Rate: 5.0%
Forecast Periods: 10 years
Recursive Forecast Result: $16,288.95
Iterative Forecast Result: $16,288.95

--- 2. Autoregressive AR(2) Forecasting Model Comparison ---
Target Forecast Year: 30

[Running Naive Recursive AR(2)]
Naive Forecast Value: $1,475.25
Total recursive calls made: 2692537
Execution Time: 8.4230 ms

[Running Memoized Recursive AR(2)]
Memoized Forecast Value: $1,475.25
Total recursive calls made: 59
Execution Time: 0.0540 ms

--- Summary of Optimizations ---
Naive Call Count: 2692537
Memoized Call Count: 59
Optimization reduced recursive calls by: 45,636.2x
```
This comparison highlights how memoization changes the time complexity from **exponential** to **linear**, saving computation time by orders of magnitude.
