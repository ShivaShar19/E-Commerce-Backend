# 🛒 E-Commerce Backend API

## 📌 Overview

A production-style E-Commerce Backend application built using Spring Boot and Spring Security. The system supports JWT authentication, role-based authorization, product management, shopping cart operations, and complete order lifecycle management.

This project follows a layered architecture and demonstrates real-world backend development practices used in modern e-commerce platforms.

---

## 🚀 Features

### 👤 Authentication & Authorization

* User Registration
* User Login
* JWT Token-Based Authentication
* BCrypt Password Encryption
* Role-Based Access Control (USER / ADMIN)

---

### 🛍️ Product Management

* Create Products (Admin Only)
* Update Products (Admin Only)
* Delete Products (Admin Only)
* View All Products
* View Product Details
* Search Products by Keyword

---

### 🛒 Cart Management

* Add Products to Cart
* View User Cart
* Update Product Quantity
* Remove Products from Cart
* Automatic Cart Total Calculation

---

### 📦 Order Management

* Place Orders from Cart
* View Order History
* View Order Details
* Order Status Tracking

#### Order Workflow

```text
PENDING
   ↓
CONFIRMED
   ↓
SHIPPED
   ↓
DELIVERED
```

---

### 🛠️ Admin Features

* Manage Product Catalog
* View All Orders
* Update Order Status
* Secure Admin-Only APIs

---

### ⚠️ Exception Handling

Global exception handling implemented using:

```java
@RestControllerAdvice
```

Custom Exceptions:

* ResourceNotFoundException
* InvalidRequestException
* UnauthorizedException

---

## 🧱 Tech Stack

### Backend

* Java 21
* Spring Boot
* Spring Security
* Spring Data JPA
* Hibernate
* Maven

### Database

* PostgreSQL

### Security

* JWT Authentication
* BCrypt Password Encoder

---

## 🏗️ Architecture

```text
Controller
    ↓
Service
    ↓
Repository
    ↓
Database
```

### Design Principles

* Layered Architecture
* DTO-Based Communication
* Separation of Concerns
* RESTful API Design

---

## 🔐 Security Features

* Stateless Authentication
* JWT Access Tokens
* Role-Based Authorization
* Protected Endpoints
* Password Encryption using BCrypt
* CORS Configuration

---

## 📡 REST API Endpoints

### Authentication

| Method | Endpoint           |
| ------ | ------------------ |
| POST   | /api/auth/register |
| POST   | /api/auth/login    |

---

### Products

| Method | Endpoint                           |
| ------ | ---------------------------------- |
| GET    | /api/products                      |
| GET    | /api/products/{id}                 |
| GET    | /api/products/search?keyword=value |
| POST   | /api/products                      |
| PUT    | /api/products/{id}                 |
| DELETE | /api/products/{id}                 |

---

### Cart

| Method | Endpoint                      |
| ------ | ----------------------------- |
| POST   | /api/cart/add                 |
| GET    | /api/cart                     |
| PUT    | /api/cart/update              |
| DELETE | /api/cart/remove/{cartItemId} |

---

### Orders

| Method | Endpoint                     |
| ------ | ---------------------------- |
| POST   | /api/orders/place            |
| GET    | /api/orders/my-orders        |
| GET    | /api/orders/{orderId}        |
| GET    | /api/orders                  |
| PUT    | /api/orders/{orderId}/status |

---

## 🎯 Key Learning Outcomes

* Spring Boot REST API Development
* JWT Authentication & Authorization
* Spring Security Configuration
* Role-Based Access Control
* Database Design with JPA & Hibernate
* Exception Handling in Production Applications
* E-Commerce Domain Modeling
* Clean Architecture Practices

---

## 📈 Future Enhancements

* React Frontend Integration
* Product Reviews & Ratings
* Wishlist Functionality
* Payment Gateway Integration
* Product Categories
* Pagination & Filtering
* Cloudinary Image Upload
* Docker Containerization
* CI/CD Pipeline
* Deployment on Railway & Vercel

---

## 👨‍💻 Author

**Shivam Sharma**

Java Full Stack Developer

### Skills

* Java
* Spring Boot
* Spring Security
* PostgreSQL
* React
* REST APIs
* JWT Authentication
