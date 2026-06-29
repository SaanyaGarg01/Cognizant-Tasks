# JUnit Setup Example

This project demonstrates how to set up **JUnit 4** in a Maven-based Java project to write and run unit tests.

---

## Project Structure

This project follows the standard Maven project structure, which separates source code from test code:

```text
JUnitSetupExample/
│
├── pom.xml                             # Maven project descriptor containing JUnit dependency
└── src/
    ├── main/
    │   └── java/
    │       └── com/
    │           └── example/
    │               └── Calculator.java # Class under test (business logic)
    └── test/
        └── java/
            └── com/
                └── example/
                    ├── CalculatorTest.java # JUnit test cases for Calculator
                    └── AssertionsTest.java # JUnit assertions demonstration test cases
```

---

## Maven Configuration (`pom.xml`)

The JUnit dependency is configured inside the `dependencies` section of the `pom.xml` file:

```xml
<dependencies>
    <!-- JUnit 4 dependency -->
    <dependency> 
        <groupId>junit</groupId> 
        <artifactId>junit</artifactId> 
        <version>4.13.2</version> 
        <scope>test</scope> 
    </dependency> 
</dependencies>
```

- **`<groupId>` and `<artifactId>`**: Uniquely identify the JUnit library.
- **`<version>4.13.2</version>`**: Uses the latest stable release of JUnit 4.
- **`<scope>test</scope>`**: Restricts the library to test source code compile and execution tasks only; it will not be bundled in the final application artifact.

---

## Code Reference

### 1. Business Logic (`Calculator.java`)
Implements basic arithmetic operations: addition, subtraction, multiplication, and division. It includes boundary verification checks such as throwing an `IllegalArgumentException` on division-by-zero operations.

### 2. Unit Tests
- **[CalculatorTest.java](file:///c:/Users/lenovo/Downloads/New%20folder/cognizant%202-ReactJS%20HOC/Cognizant%20Tasks/JUnitSetupExample/src/test/java/com/example/CalculatorTest.java)**: Verifies the `Calculator` operations. Uses basic assertions and verifies exceptions using `@Test(expected = IllegalArgumentException.class)`.
- **[AssertionsTest.java](file:///c:/Users/lenovo/Downloads/New%20folder/cognizant%202-ReactJS%20HOC/Cognizant%20Tasks/JUnitSetupExample/src/test/java/com/example/AssertionsTest.java)**: Demonstrates various assertions including:
  - `assertEquals()`: Verifies expectation values match actual results.
  - `assertTrue()` / `assertFalse()`: Verifies conditional states.
  - `assertNull()` / `assertNotNull()`: Checks references.
  - `assertSame()`: Checks memory location identity.
  - `assertArrayEquals()`: Checks contents of arrays.

---

## How to Run in an IDE

1. Open **IntelliJ IDEA**, **Eclipse**, or **VS Code**.
2. Select **Open Project** and navigate to the `JUnitSetupExample` directory.
3. The IDE will automatically recognize the `pom.xml` file, load it as a Maven project, and download the JUnit dependency.
4. Locate `CalculatorTest.java` in the directory hierarchy.
5. Right-click the file or test methods, and select **Run 'CalculatorTest'** to verify tests pass successfully.
