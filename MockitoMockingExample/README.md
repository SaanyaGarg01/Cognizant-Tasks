# Mocking and Stubbing with Mockito

This project demonstrates how to use **Mockito** alongside **JUnit 5** to test classes that depend on external components (APIs) by creating mock objects and stubbing their return behavior.

---

## Concept Overview

### What is Mocking?
**Mocking** is the process of creating objects that mimic the behavior of real, complex dependencies. This allows you to isolate the unit of code under test (the class being tested) without making actual calls to external databases, microservices, or third-party web APIs.

### What is Stubbing?
**Stubbing** is the process of defining the return values or behaviors of mock object methods when they are invoked during a test (e.g., instructing a mock API method `getData()` to return the string `"Mock Data"`).

---

## Project Structure

```text
MockitoMockingExample/
│
├── pom.xml                             # Maven project descriptor with JUnit 5 & Mockito dependencies
└── src/
    ├── main/
    │   └── java/
    │       └── com/
    │           └── example/
    │               ├── ExternalApi.java # External API interface (dependency)
    │               └── MyService.java   # Service class under test
    └── test/
        └── java/
            └── com/
                └── example/
                    ├── MyServiceTest.java # JUnit 5 + Mockito test case for mocking/stubbing
                    └── InteractionVerificationTest.java # JUnit 5 + Mockito test case for verifying interactions
```

---

## Dependencies (`pom.xml`)

To support Mockito with JUnit 5, the following dependencies are added inside `pom.xml`:

```xml
<dependencies>
    <!-- JUnit Jupiter (JUnit 5) -->
    <dependency>
        <groupId>org.junit.jupiter</groupId>
        <artifactId>junit-jupiter-api</artifactId>
        <version>5.10.2</version>
        <scope>test</scope>
    </dependency>
    <dependency>
        <groupId>org.junit.jupiter</groupId>
        <artifactId>junit-jupiter-engine</artifactId>
        <version>5.10.2</version>
        <scope>test</scope>
    </dependency>

    <!-- Mockito Core -->
    <dependency>
        <groupId>org.mockito</groupId>
        <artifactId>mockito-core</artifactId>
        <version>5.11.0</version>
        <scope>test</scope>
    </dependency>
</dependencies>
```

---

## How the Tests Work

### 1. Mocking and Stubbing (`MyServiceTest.java`)
- **Mocking**: We create a mock version of `ExternalApi` using:
  ```java
  ExternalApi mockApi = Mockito.mock(ExternalApi.class);
  ```
- **Stubbing**: We define the mock's behavior using Mockito's static `when()` and `thenReturn()` methods:
  ```java
  when(mockApi.getData()).thenReturn("Mock Data");
  ```
- **Execution & Assertion**: We run the code under test and verify the output:
  ```java
  MyService service = new MyService(mockApi);
  String result = service.fetchData();
  assertEquals("Mock Data", result);
  ```
- **Verification**: We verify that the mock's method was indeed called:
  ```java
  verify(mockApi, times(1)).getData();
  ```

### 2. Verifying Interactions with Arguments (`InteractionVerificationTest.java`)
- **Action**: We call a method `fetchDataById(101)` that takes a specific integer argument.
- **Verification**: We check that the mock was interacted with the exact argument using:
  ```java
  verify(mockApi, times(1)).getDataById(101);
  ```
- **Verification of Non-Interactions**: We also check that other methods/arguments were not invoked:
  ```java
  verify(mockApi, never()).getDataById(999);
  ```

---

## How to Run in an IDE

1. Open your IDE (IntelliJ IDEA, Eclipse, or VS Code).
2. Open the `MockitoMockingExample` directory.
3. Allow the IDE to sync dependencies via Maven.
4. Locate `MyServiceTest.java` in `src/test/java`.
5. Right-click the class and select **Run 'MyServiceTest'**.
