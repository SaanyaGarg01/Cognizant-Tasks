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
        │               ├── model/
        │               │   └── Country.java            # Country model POJO
        │               ├── security/
        │               │   ├── SecurityConfig.java       # Security settings configuration
        │               │   └── JwtAuthorizationFilter.java # JWT authorization validation filter
        │               └── controller/
        │                   ├── HomeController.java       # REST Controller mapping (Welcome)
        │                   ├── HelloController.java      # REST Controller mapping (Hello World)
        │                   ├── CountryController.java    # REST Controller mapping (Country/Countries)
        │                   └── AuthenticationController.java # JWT auth controller
        └── resources/
            ├── application.properties  # Server ports & logger patterns (runs on 8090)
            ├── date-format.xml         # Spring Core SimpleDateFormat configuration bean
            └── country.xml             # Spring Core Country XML configuration beans
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

### Step 4: Test Web Welcome Endpoint
Open your browser and navigate to:
[http://localhost:8090/](http://localhost:8090/)

You should see the welcome string:
`Welcome to Spring Learn Web Application!`

### Step 5: Test Hello World Web Service
Open your browser or Postman and trigger a GET request:
[http://localhost:8090/hello](http://localhost:8090/hello)

#### Sample Response:
```text
Hello World!!
```

#### Expected Log Outputs:
Check the console logs to verify that the start and end logger traces are present:
```text
30-06-26 10:28:45.120 [http-nio-8090-exec-1] INFO  c.c.s.c.HelloController - Start sayHello
30-06-26 10:28:45.122 [http-nio-8090-exec-1] INFO  c.c.s.c.HelloController - End sayHello
```

### Step 6: Test Country Web Service
Open your browser or Postman and trigger a GET request:
[http://localhost:8090/country](http://localhost:8090/country)

#### Sample Response:
```json
{
  "code": "IN",
  "name": "India"
}
```

### Step 7: Test All Countries Web Service
Open your browser or Postman and trigger a GET request:
[http://localhost:8090/countries](http://localhost:8090/countries)

#### Sample Response:
```json
[
  { "code": "IN", "name": "India"},
  { "code": "US", "name": "United States"},
  { "code": "JP", "name": "Japan"},
  { "code": "DE", "name": "Germany"}
]
```

### Step 8: Test Get Country by Code (Case Insensitive)
Open your browser or Postman and trigger a GET request:
[http://localhost:8090/countries/in](http://localhost:8090/countries/in) (or [http://localhost:8090/country/in](http://localhost:8090/country/in))

#### Sample Response:
```json
{
  "code": "IN",
  "name": "India"
}
```

### Step 9: Authenticate and Generate JWT
Send a GET request with basic credentials `user:pwd` to request the JWT token:
```bash
curl -s -u user:pwd http://localhost:8090/authenticate
```
#### Sample Response:
```json
{"token":"eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1c2VyIiwiaWF0IjoxNTcwMzc5NDc0LCJleHAiOjE1NzAzODA2NzR9..."}
```

### Step 10: Access Secure Services Using Bearer Token
Send requests to other services including the bearer token in headers:
```bash
curl -s -H "Authorization: Bearer <TOKEN>" http://localhost:8090/countries
```
If token validation succeeds, the response delivers the countries payload. If the token is modified or invalid, the server responds with a `403 Forbidden` or `401 Unauthorized` status code.

---

## SME Aspects Explanation

### 1. What happens in the controller method?
When a request hits `/country` or `/countries`, Spring's `DispatcherServlet` identifies the mapped handler method in `CountryController`. The handler method instantiates a Spring container using `ClassPathXmlApplicationContext("country.xml")`, retrieves the target bean (`in` or `countryList`), and returns the object/list directly.

### 2. How is the bean converted into a JSON response?
Spring Boot Web automatically configures the **Jackson JSON serialization engine** (`MappingJackson2HttpMessageConverter`). Since `CountryController` is annotated with `@RestController`, Spring realizes that the return value must be written directly to the HTTP response body instead of being resolved as a view template. Jackson serializes the fields of the Java POJO (via its getter methods) into standard JSON key-value properties.

### 3. HTTP Header details received (Chrome Network Tab & Postman Headers)
- **`Content-Type: application/json`**: Indicates that the response body is formatted as a JSON string.
- **`Transfer-Encoding: chunked`**: Dynamic response body payload sizes are sent in parts.
- **`Connection: keep-alive`**: Keeps the underlying TCP connection open for subsequent requests.
- **`Date`**: The current date and timestamp from the host machine.
