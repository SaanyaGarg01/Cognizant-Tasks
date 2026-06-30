# SLF4J and Logback Logging Example

This project demonstrates how to set up **SLF4J (Simple Logging Facade for Java)** with **Logback** as the concrete logging implementation to record runtime warnings and error messages.

---

## Logging Concepts

### What is SLF4J?
**SLF4J** is a logging facade or abstraction layer that allows you to write logging statements in your code independent of the concrete logging framework (such as Logback, Log4j2, or Java Util Logging). This makes your application loose-coupled and allows changing the logging implementation easily without modifying source code.

### What is Logback?
**Logback** is the actual logging framework that implements the SLF4J API interface. It handles writing log statements to files, console standard outputs, email alerts, or external log collectors.

### Log Levels
Logging frameworks organize messages by importance levels:
- **`ERROR`**: Serious issues causing application failures.
- **`WARN`**: Warnings about unexpected behaviors that don't halt execution.
- **`INFO`**: High-level operational events (startup, shutdown, database connected).
- **`DEBUG`**: Detailed diagnostic details for developer troubleshooting.
- **`TRACE`**: Granular trace statements (e.g., individual SQL execution params).

---

## Project Structure

```text
SLF4JLoggingExample/
│
├── pom.xml                             # Maven project descriptor with SLF4J & Logback dependencies
└── src/
    └── main/
        ├── java/
        │   └── com/
        │       └── example/
        │           └── LoggingExample.java # Core Java application executing logs
        └── resources/
            └── logback.xml             # Custom logging format settings
```

---

## Dependencies (`pom.xml`)

We add both the SLF4J API and Logback classic (which automatically binds to the SLF4J API):

```xml
<dependencies>
    <!-- SLF4J API -->
    <dependency> 
        <groupId>org.slf4j</groupId> 
        <artifactId>slf4j-api</artifactId> 
        <version>1.7.30</version> 
    </dependency> 
    <!-- Logback Classic (SLF4J Implementation) -->
    <dependency> 
        <groupId>ch.qos.logback</groupId> 
        <artifactId>logback-classic</artifactId> 
        <version>1.2.3</version> 
    </dependency> 
</dependencies>
```

---

## Custom Layout Configuration (`logback.xml`)

We define a structured console logger formatting layout under `src/main/resources/logback.xml`:

```xml
<pattern>%d{yyyy-MM-dd HH:mm:ss.SSS} [%thread] %-5level %logger{36} - %msg%n</pattern>
```
- **`%d`**: Displays time formatted in milliseconds.
- **`%thread`**: Name of the execution thread (e.g., `[main]`).
- **`%-5level`**: Displays log level aligned with 5 characters (e.g., `ERROR`, `WARN `).
- **`%logger`**: Truncated name of the logging class.
- **`%msg`**: Log text message.

---

## How to Run in an IDE

1. Open your IDE (IntelliJ IDEA, Eclipse, or VS Code).
2. Import/Open the `SLF4JLoggingExample` directory.
3. Allow the IDE to sync Maven dependencies.
4. Locate `LoggingExample.java` in `src/main/java`.
5. Right-click the file and select **Run 'LoggingExample.main()'**.

### Expected Console Output
```text
=== SLF4J Logging Demonstration ===
2026-06-30 09:45:12.456 [main] INFO  com.example.LoggingExample - Application starting up...
2026-06-30 09:45:12.458 [main] WARN  com.example.LoggingExample - This is a warning message - indicating a potential issue that doesn't stop the application.
2026-06-30 09:45:12.460 [main] ERROR com.example.LoggingExample - This is an error message - indicating a serious failure occurred.
=== Execution Completed ===
```
