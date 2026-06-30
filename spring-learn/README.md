# Spring Web Project (Spring Learn)

This is a demonstration project exploring **Spring Boot Starter Web** and **Spring Web MVC** integration. It sets up an embedded Tomcat server, registers REST controller mappings, and logs runtime events using customized Logback patterns.

---

## Technical Concept Walkthrough

### 1. Folder Structure
- **`src/main/java`**: Contains source code implementing controllers and bootstrappers.
- **`src/main/resources`**: Contains resource properties (`application.properties`) configuring web ports and log patterns.
- **`src/test/java`**: Reserved for unit testing components.

### 2. Main Bootstrapper (`SpringLearnApplication.java`)
- **`main()` method**: Boots the embedded Tomcat container, maps components, and loads the Spring context.
- **`@SpringBootApplication`**: Combines `@SpringBootConfiguration`, `@EnableAutoConfiguration`, and `@ComponentScan` to automatically discover and assemble web controller components.

### 3. REST Controller Mappings (`HomeController.java`)
- **`@RestController`**: Registers the class as a web controller where returned handler values are written directly to HTTP response bodies (no template resolving needed).
- **`@GetMapping("/")`**: Binds HTTP `GET` requests sent to the root path to the handler method.

---

## Project Structure

```text
spring-learn/
│
├── pom.xml                             # Spring Boot Maven configurations
├── README.md                           # Documentation and walk-through guides
└── src/
    └── main/
        ├── java/
        │   └── com/
        │       └── cognizant/
        │           └── springlearn/
        │               ├── SpringLearnApplication.java # Bootstrap class
        │               └── controller/
        │                   └── HomeController.java     # REST Controller mapping
        └── resources/
            ├── application.properties  # Server ports & logger patterns
            └── date-format.xml         # Spring Core SimpleDateFormat configuration bean
```

---

## Setup & Compilation Instructions

### Step 1: Build the Maven Project
Compile and package the JAR file using Maven:
```bash
mvn clean package
```
*(If you are running behind a proxy server as indicated in the task, execute the command with the proxies configured):*
```bash
mvn clean package -Dhttp.proxyHost=proxy.cognizant.com -Dhttp.proxyPort=6050 -Dhttps.proxyHost=proxy.cognizant.com -Dhttps.proxyPort=6050 -Dhttp.proxyUser=123456
```

### Step 2: Run the Application
Start the Spring Boot web application:
```bash
java -jar target/spring-learn-0.0.1-SNAPSHOT.jar
```
Or run directly via maven wrapper:
```bash
mvn spring-boot:run
```

### Step 3: Test SimpleDateFormat XML Loading
During startup, the application logs the initialization of the XML context and outputs the parsed date object:
```text
30-06-26 10:15:12.456 [main] INFO  c.c.s.SpringLearnApplication - Start displayDate
30-06-26 10:15:12.600 [main] INFO  o.s.c.s.ClassPathXmlApplicationContext - Refreshing ClassPathXmlApplicationContext
Parsed Date Result: Mon Dec 31 00:00:00 UTC 2018
30-06-26 10:15:12.720 [main] INFO  c.c.s.SpringLearnApplication - End displayDate
```

### Step 4: Test Web Endpoint
Open your browser and navigate to:
[http://localhost:8080/](http://localhost:8080/)

You should see the welcome string:
`Welcome to Spring Learn Web Application!`
