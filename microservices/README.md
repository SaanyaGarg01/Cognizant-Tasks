# Bank Microservices (Account & Loan)

This project demonstrates the creation of two independent microservices for a bank application:
1. **Account Microservice**: Runs on port `8080` (default) exposing `/accounts/{number}`.
2. **Loan Microservice**: Runs on port `8081` (customized) exposing `/loans/{number}`.

---

## Architecture Design

Instead of housing both accounts and loans in a monolithic application, each domain is split into a separate Maven Spring Boot web project. They can be built, packaged, deployed, and scaled independently without backend connectivity.

```text
       ┌────────────────────────────────────────────────────────┐
       │                   Bank Client / Browser                │
       └───────────────┬────────────────────────┬───────────────┘
                       │                        │
     GET /accounts/00987... (8080)            GET /loans/H0098... (8081)
                       │                        │
                       ▼                        ▼
         ┌─────────────────────────┐      ┌─────────────────────────┐
         │   Account Microservice  │      │    Loan Microservice    │
         │       (Port 8080)       │      │       (Port 8081)       │
         └─────────────────────────┘      └─────────────────────────┘
```

---

## Directory Structure

```text
microservices/
│
├── README.md                           # Documentation and guides
│
├── account/                            # Account Microservice project
│   ├── pom.xml                         # Account dependencies descriptor
│   └── src/
│       └── main/
│           ├── java/com/cognizant/account/
│           │   ├── AccountApplication.java # Bootstrap class
│           │   ├── model/Account.java      # Model entity POJO
│           │   └── controller/AccountController.java # API REST Controller
│           └── resources/
│               └── application.properties # Server port 8080 settings
│
└── loan/                               # Loan Microservice project
    ├── pom.xml                         # Loan dependencies descriptor
    └── src/
        └── main/
            ├── java/com/cognizant/loan/
            │   ├── LoanApplication.java    # Bootstrap class
            │   ├── model/Loan.java         # Model entity POJO
            │   └── controller/LoanController.java # API REST Controller
            └── resources/
                └── application.properties # Server port 8081 settings (avoids port conflicts)
```

---

## Build Instructions

To compile and package both microservices:

1. **Account Microservice**:
   ```bash
   cd account
   mvn clean package
   ```
2. **Loan Microservice**:
   ```bash
   cd ../loan
   mvn clean package
   ```

---

## Port Conflict Resolution

By default, all Spring Boot applications bind to port `8080`. Launching both applications simultaneously on the same machine will trigger a `java.net.BindException: Address already in use` error.

To resolve this, we configured the Loan Microservice to bind to port `8081` in its `application.properties` configuration file:
```properties
server.port=8081
```

---

## How to Test

### 1. Test Account Microservice
Start the account service, then browse or send a GET request to:
[http://localhost:8080/accounts/00987987973432](http://localhost:8080/accounts/00987987973432)

#### Expected Response:
```json
{
  "number": "00987987973432",
  "type": "savings",
  "balance": 234343.0
}
```

### 2. Test Loan Microservice
Start the loan service, then browse or send a GET request to:
[http://localhost:8081/loans/H00987987972342](http://localhost:8081/loans/H00987987972342)

#### Expected Response:
```json
{
  "number": "H00987987972342",
  "type": "car",
  "loan": 400000.0,
  "emi": 3258.0,
  "tenure": 18
}
```
