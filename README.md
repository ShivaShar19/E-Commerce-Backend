# 🛒 E-Commerce Backend API

A production-style E-Commerce Backend built using Spring Boot, Spring Security, JWT Authentication, PostgreSQL, and JPA/Hibernate.

## 🚀 Features

### Authentication & Authorization

* User Registration
* User Login
* BCrypt Password Encryption
* JWT Token Generation
* JWT Token Validation
* Stateless Authentication
* Protected APIs using Spring Security

### Database

* PostgreSQL Integration
* Spring Data JPA
* Hibernate ORM

### Security

* Spring Security
* JWT Authentication Filter
* Custom UserDetailsService
* Password Hashing with BCrypt

## 🛠 Tech Stack

* Java 17
* Spring Boot
* Spring Security
* Spring Data JPA
* PostgreSQL
* JWT (JSON Web Token)
* Maven
* Lombok

## 📁 Project Structure

```
src
├── controller
├── service
│   ├── impl
├── repository
├── entity
├── dto
├── security
├── config
└── exception
```

## ⚙️ Setup Instructions

### Clone Repository

```bash
git clone https://github.com/YOUR_USERNAME/ecommerce-backend.git
cd ecommerce-backend
```

### Configure Database

Create a PostgreSQL database:

```sql
CREATE DATABASE Ecommerce;
```

Update:

```properties
src/main/resources/application.properties
```

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/Ecommerce
spring.datasource.username=postgres
spring.datasource.password=your_password
```

### Configure JWT

```properties
app.jwt.secret=your_secret_key
app.jwt.expiration=86400000
```

### Run Application

```bash
mvn spring-boot:run
```

Application runs on:

```
http://localhost:8080
```

---

## API Endpoints

### Register User

```http
POST /api/auth/register
```

Request Body:

```json
{
  "name": "Shivam",
  "email": "shivam@gmail.com",
  "password": "123456"
}
```

---

### Login User

```http
POST /api/auth/login
```

Request Body:

```json
{
  "email": "shivam@gmail.com",
  "password": "123456"
}
```

Response:

```json
{
  "token": "JWT_TOKEN"
}
```

---

### Access Protected API

Add JWT Token:

```http
Authorization: Bearer YOUR_TOKEN
```

Example:

```http
GET /api/test
```

Response:

```text
Authenticated Successfully
```

---

## Current Progress

### Completed

* JWT Authentication
* User Registration
* User Login
* Spring Security Integration
* PostgreSQL Integration
* Password Encryption

### Upcoming Features

* Product Management
* Categories
* Shopping Cart
* Order Management
* Image Upload (Cloudinary)
* Swagger Documentation
* Global Exception Handling
* Docker Deployment
* CI/CD Pipeline

## 👨‍💻 Author

Shivam Sharma

Java Full Stack Developer
