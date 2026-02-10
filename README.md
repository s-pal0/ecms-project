# ecms-project
Enterprise Customer Management System - Spring Boot, Rest API


📌 Project Overview
ECMS (Customer Management System) backend RESTful application built using Spring Boot that provides APIs to manage customer data such as creating, viewing, updating, and deleting customers.
This project follows production-level layered architecture and demonstrates best practices for:
✅ REST API design
✅ Validation
✅ Exception handling
✅ Logging
✅ Database persistence using JPA & PostgreSQL


📌 Tech Stack
✅ Layer	     Technology
✅ Language	     Java 21
✅ Framework	 Spring Boot
✅ ORM	         Spring Data JPA (Hibernate)
✅ Database	     PostgreSQL
✅ Build Tool	 Maven
✅ Validation	 Jakarta Bean Validation
✅ Logging	     SLF4J + Logback
✅ API Style	 REST


📌 Project Structure
com.example.ecms
│
├── controller        → REST controllers (API layer)
├── service           → Business logic
│   └── impl
├── repository        → Database access (JPA)
├── entity            → JPA entities (tables)
├── dto               → Request / Response DTOs
├── exception         → Global exception handling
├── config            → Configuration classes
└── Main.java         → Application entry point


📌 Application Flow (High Level)
Client (Postman / UI)
↓
Controller (REST API)
↓
Service (Business Logic)
↓
Repository (JPA)
↓
PostgreSQL Database


📌 Features Implemented
Customer Management
 Add new customer
 Get all customers
 Get customer by ID
 Update customer (PUT)
 Partial update (PATCH)
 Delete customer

Cross-Cutting Concerns
 Input validation
 Global exception handling
 Structured logging
 Clean layered architecture


📌 API Endpoints (Sample)
Add Customer
 POST /api/customer/add

Get All Customers
 GET /api/customer/list

Get Customer by ID
 GET /api/customer/{cId}

Update Customer
 PUT /api/customer/update/{cId}

Partial Update
 PATCH /api/customer/pupdate/{cId}

Delete Customer
 DELETE /api/customer/delete/{cId}


📌 Sample Customer JSON
{
"name": "John Doe",
"email": "john.doe@example.com",
"phone": "0000000000"
}


📌 Configuration
Database Configuration (application.yml)
 spring:
 datasource:
 url: jdbc:postgresql://localhost:5432/ecms_db
 username: postgres
 password: postgres

 jpa:
 hibernate:
 ddl-auto: update
 show-sql: true


📌 Validation & Exception Handling
 Uses Jakarta Bean Validation (@NotBlank, @Size, etc.)
 Centralized error handling using @ControllerAdvice
 Consistent error responses for API consumers


📌 How to Run the Application
Prerequisites
 Java 17+
 Maven
 PostgreSQL

Steps
 git clone https://github.com/your-username/ecms-project.git
 cd ecms-project
 mvn spring-boot:run

Application will start at:
 http://localhost:8080


📌 Testing
You can test APIs using:
 Postman


📌 Future Enhancements
 Spring Security (JWT authentication)
 Swagger / OpenAPI documentation
 Unit & integration tests
 Docker support
 Cloud deployment


📌 Author
Sourav Pal
Java | Spring Boot | Backend Development


📌 License
This project is licensed under the MIT License.