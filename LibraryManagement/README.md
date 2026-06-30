# Basic Spring Application Configuration (Library Management)

This project demonstrates how to set up a basic **Spring Framework** application using an XML configuration file (`applicationContext.xml`) to manage beans and dependency injection.

---

## Concept Overview

### Spring ApplicationContext
The **ApplicationContext** is the central interface within Spring that provides configuration details to the application. It is responsible for initializing, configuring, and assembling the beans (objects) defined in our configuration files.

### Dependency Injection (DI)
**Dependency Injection** is a design pattern where objects do not create their dependencies themselves, but rather receive them from an external assembler (the Spring container). This project demonstrates **Setter-Based Dependency Injection** where Spring injects the `BookRepository` bean into the `BookService` bean using the setter method.

---

## Project Structure

```text
LibraryManagement/
│
├── pom.xml                             # Maven project descriptor with Spring dependencies
└── src/
    └── main/
        ├── java/
        │   └── com/
        │       └── library/
        │           ├── MainApplication.java # Bootstrap entry class
        │           ├── repository/
        │           │   └── BookRepository.java # Repository layer bean
        │           └── service/
        │               └── BookService.java    # Service layer bean
        └── resources/
            └── applicationContext.xml  # Spring XML Configuration file
```

---

## Dependencies (`pom.xml`)

We include the `spring-context` dependency, which automatically imports `spring-core`, `spring-beans`, `spring-aop`, and `spring-expression`:

```xml
<dependencies>
    <!-- Spring Context -->
    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-context</artifactId>
        <version>5.3.31</version>
    </dependency>
</dependencies>
```

---

## Configuration (`applicationContext.xml`)

We register the beans and configure dependency injection:

```xml
<!-- Define bean for BookRepository -->
<bean id="bookRepository" class="com.library.repository.BookRepository" />

<!-- Define bean for BookService and inject BookRepository via setter injection -->
<bean id="bookService" class="com.library.service.BookService">
    <property name="bookRepository" ref="bookRepository" />
</bean>
```
- **`<property name="bookRepository" ref="bookRepository" />`**: Instructs Spring to invoke the `setBookRepository()` setter method in `BookService` and pass it the reference to the `bookRepository` bean.

---

## How to Run in an IDE

1. Open your IDE (IntelliJ IDEA, Eclipse, or VS Code).
2. Import/Open the `LibraryManagement` directory.
3. Allow the IDE to sync Maven dependencies.
4. Locate `MainApplication.java` in `src/main/java/com/library`.
5. Right-click the file and select **Run 'MainApplication.main()'**.

### Expected Console Output
```text
=== Initializing Spring Application Context ===
Jun 30, 2026 9:50:12 AM org.springframework.context.support.AbstractApplicationContext prepareRefresh
INFO: Refreshing org.springframework.context.support.ClassPathXmlApplicationContext@1d251891
=== Context Loaded Successfully ===

BookService: Managing book catalog...
BookRepository: Accessing database to fetch books...
```
This output confirms that the Spring Container successfully initialized the context, loaded the beans, and injected the repository dependency into the service.
