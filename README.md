# 🛒 E-Commerce Backend with Spring Boot

This project is a **Spring Boot-based E-Commerce backend** designed with clean architecture principles, advanced Spring features, and robust security.  
It demonstrates real-world backend development skills, including **JWT authentication, role-based authorization, AOP, and reusable response handling**.

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

<img width="1919" height="847" alt="Screenshot 2025-08-15 235153" src="https://github.com/user-attachments/assets/b8f0d4d7-5a15-415a-b9bb-213663591a57" />
<img width="1910" height="886" alt="Screenshot 2025-08-15 235121" src="https://github.com/user-attachments/assets/d80bbe10-60e6-49ca-8fe4-836e781f77b1" />
<img width="1918" height="572" alt="Screenshot 2025-08-15 234827" src="https://github.com/user-attachments/assets/5b554fa3-8654-4d68-9f19-cc0cf9ca2e49" />
<img width="1913" height="607" alt="Screenshot 2025-08-15 234751" src="https://github.com/user-attachments/assets/be0f7cda-f54e-4041-85ff-a1f10d66d135" />
<img width="1919" height="986" alt="Screenshot 2025-08-15 234511" src="https://github.com/user-attachments/assets/c218aa7d-07e9-421c-91ac-95ba8436a668" />
<img width="1920" height="1080" alt="Screenshot 2025-08-15 234432" src="https://github.com/user-attachments/assets/7e42aedf-bf77-4703-bb12-5f1e43233d04" />

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
