# Spring Data JPA ORM Learn Example

This is a demonstration project exploring **Spring Data JPA** and **Hibernate** integration in a Spring Boot application. It maps a relational database table `country` to a Java object structure, executes queries, and prints output statements using customized Logback logging patterns.

---

## Technical Concept Walkthrough

### 1. Folder Structure
- **`src/main/java`**: Houses core application source code containing business entities, repositories, and transactional services.
- **`src/main/resources`**: Contains resource property files (`application.properties`) configuring datasource drivers, Hibernate properties, and SLF4J logger levels.
- **`src/test/java`**: Reserved for unit testing components.

### 2. Main Bootstrapper (`OrmLearnApplication.java`)
- **`main()` method**: Boots the embedded Tomcat container, compiles beans, wires dependencies, and returns the initialized `ApplicationContext`.
- **`@SpringBootApplication`**: A convenience annotation that combines:
  - `@SpringBootConfiguration`: Declares the class as a source of bean definitions.
  - `@EnableAutoConfiguration`: Automatically configures dependencies declared in `pom.xml` (like datasource configuration and JPA entity managers).
  - `@ComponentScan`: Scans the current package and sub-packages (e.g. model, service, repository) for Spring components (@Component, @Service, @Repository).

### 3. JPA Model Mapping (`Country.java`)
- **`@Entity`**: Registers the class as a JPA entity model.
- **`@Table(name="country")`**: Maps the class to the database table named `country`.
- **`@Id`**: Designates the primary key identifier.
- **`@Column(name="co_code")`**: Links properties to specific database column fields (e.g. `co_code` and `co_name`).

---

## Project Structure

```text
orm-learn/
│
├── pom.xml                             # Spring Boot Maven configurations
├── db_setup.sql                        # Helper SQL script to create schema & seed country table
├── README.md                           # Documentation and walk-through guides
└── src/
    └── main/
        ├── java/
        │   └── com/
        │       └── cognizant/
        │           └── ormlearn/
        │               ├── OrmLearnApplication.java # Bootstrap class
        │               ├── model/
        │               │   └── Country.java         # JPA Country Entity
        │               ├── repository/
        │               │   └── CountryRepository.java # Country JPA Repository
        │               └── service/
        │                   └── CountryService.java    # Country Transactional Service
        └── resources/
            └── application.properties  # Database credentials & logger patterns
```

---

## Setup & Compilation Instructions

### Step 1: Initialize MySQL Database
Run the MySQL database schema initialization commands. You can execute the script `db_setup.sql` in MySQL Workbench or type the commands in your MySQL client terminal:
```bash
mysql -u root -p
```
Inside MySQL console:
```sql
CREATE DATABASE ormlearn;
USE ormlearn;
CREATE TABLE country(co_code VARCHAR(2) PRIMARY KEY, co_name VARCHAR(50));
INSERT INTO country VALUES ('IN', 'India');
INSERT INTO country VALUES ('US', 'United States of America');
```

### Step 2: Build the Maven Project
Compile and package the JAR file using Maven:
```bash
mvn clean package
```
*(If you are running behind a proxy server as indicated in the task, execute the command with the proxies configured):*
```bash
mvn clean package -Dhttp.proxyHost=proxy.cognizant.com -Dhttp.proxyPort=6050 -Dhttps.proxyHost=proxy.cognizant.com -Dhttps.proxyPort=6050 -Dhttp.proxyUser=123456
```

### Step 3: Run the Application
Start the Spring Boot application:
```bash
java -jar target/orm-learn-0.0.1-SNAPSHOT.jar
```
Or run directly via maven wrapper:
```bash
mvn spring-boot:run
```

---

## Log Output Verification
Upon running the application, watch the console logs. Standard Logback configuration renders traces showing:
1. Verification that the main thread starts.
2. Hibernate SQL queries executing on the database.
3. Country objects output matching database values.

```text
30-06-26 10:05:12.456 [main] INFO  com.cognizant.ormlearn.OrmLearnApplication - Inside main
...
30-06-26 10:05:14.120 [main] DEBUG com.cognizant.ormlearn.OrmLearnApplication - countries=[Country [code=IN, name=India], Country [code=US, name=United States of America]]
...
```
