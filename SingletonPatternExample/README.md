# Singleton Design Pattern Example

This project demonstrates the **Singleton Design Pattern** implemented in Java. The Singleton pattern ensures that a class has only one instance and provides a global point of access to it.

In this example, we implement a thread-safe `Logger` utility class to ensure consistent logging across the entire application lifecycle.

## Project Structure

```text
SingletonPatternExample/
│
├── README.md                           # Documentation for the project
└── src/
    └── com/
        └── patterns/
            └── singleton/
                ├── Logger.java         # Singleton Logger implementation
                └── SingletonPatternTest.java # Test suite to verify singleton behavior
```

## Implementation Details

### 1. The Singleton Class (`Logger.java`)
To enforce the Singleton pattern, the `Logger` class implements the following key features:
- **Private Constructor**: Prevents instantiation of the class from outside (`new Logger()` is not allowed).
- **Private Static Instance**: A `private static volatile Logger instance` field holds the unique instance.
- **Double-Checked Locking**: The `getInstance()` method uses double-checked locking to ensure that the singleton instantiation is thread-safe and performs efficiently.
- **Volatile Keyword**: The `volatile` modifier ensures that changes made to the `instance` variable are immediately visible to all threads, preventing partially initialized instances.
- **Reflection Protection**: The private constructor includes a check to throw an exception if initialization is attempted when an instance already exists (protecting against reflection attacks).

### 2. The Verification Test (`SingletonPatternTest.java`)
The test suite performs two types of verification:
- **Single-Threaded Access Test**: Retrieves two logger references and checks if they point to the exact same memory address (`logger1 == logger2`).
- **Multi-Threaded Concurrent Access Test**: Spawns multiple threads concurrently calling `Logger.getInstance()` to ensure that only a single `Logger` instance is created and shared across all threads under race conditions.

## How to Compile and Run

To compile and run this project, make sure you have the Java Development Kit (JDK) installed and configured on your system.

### Option 1: Using terminal commands (from the project root directory)

1. **Navigate to the project root directory**:
   ```bash
   cd SingletonPatternExample
   ```

2. **Compile the Java files**:
   ```bash
   javac -d bin src/com/patterns/singleton/*.java
   ```
   *(This compiles the source files and outputs the class files into a `bin` directory)*

3. **Run the test program**:
   ```bash
   java -cp bin com.patterns.singleton.SingletonPatternTest
   ```

### Expected Output
When run, the application will output details of both tests:
```text
=== Starting Singleton Pattern Verification ===
[Test 1] Single-Threaded Access Test
[System] Logger initialized.
[2026-06-29 22:58:12.456] [INFO] This is a log message using logger1 reference.
[2026-06-29 22:58:12.458] [INFO] This is a log message using logger2 reference.
logger1 hashcode: 12345678
logger2 hashcode: 12345678
Are both references identical? true
SUCCESS: Both references point to the same Logger instance.

[Test 2] Multi-Threaded Concurrent Access Test
[2026-06-29 22:58:12.465] [DEBUG] Logged from concurrent Thread 0
[2026-06-29 22:58:12.466] [DEBUG] Logged from concurrent Thread 2
[2026-06-29 22:58:12.467] [DEBUG] Logged from concurrent Thread 1
...
Total logger references retrieved from threads: 10
Are all retrieved instances identical? true
SUCCESS: Thread safety verified. Only one instance of Logger was created and shared across all threads.
```
