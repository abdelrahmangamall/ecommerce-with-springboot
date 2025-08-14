# 🛒 E-Commerce Backend with Spring Boot

This project is a **Spring Boot-based E-Commerce backend** designed with clean architecture principles, advanced Spring features, and robust security.  
It demonstrates real-world backend development skills including **JWT authentication, role-based authorization, AOP, and reusable response handling**.

---

## 🚀 Features

- **Entity Relationships**
  - Implemented `@OneToMany`, `@ManyToOne`, and `@ManyToMany` relationships using JPA/Hibernate.
- **Base Response Structure**
  - Clean and reusable `ApiResponse` wrapper for consistent API responses.
- **Exception Handling**
  - Custom `ResourceNotFoundException` for clear error management.
- **Service & Controller Best Practices**
  - Layered architecture with proper separation of concerns.
- **Authentication & Authorization**
  - Secure login with **JWT (JSON Web Token)**.
  - Role-based access control (`USER` vs `ADMIN`).
  - Protection of sensitive API endpoints with Spring Security.
- **Advanced Spring Boot Concepts**
  - Aspect-Oriented Programming (AOP) for clean cross-cutting concerns.
  - Global exception handling for better error reporting.

---

## 🛠️ Tech Stack

- **Java** (JDK 11/17+)
- **Spring Boot**
  - Spring Web
  - Spring Data JPA
  - Spring Security + JWT
- **Database**: MySQL / H2 (for testing)
- **Maven** (Build tool)
- **Swagger / OpenAPI** for API documentation

---

## ⚡ Getting Started

### Prerequisites
- Install **Java 11+**
- Install **Maven**
- Set up **MySQL** (or use H2 in-memory)

### Run the Project
```bash
# Clone repository
git clone https://github.com/abdelrahmangamall/ecommerce-with-springboot.git

# Navigate into project
cd ecommerce-with-springboot

# Build and run
mvn spring-boot:run
