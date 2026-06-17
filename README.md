# 🛒 E-Commerce Backend (Spring Boot)

## 📌 Overview
This is a full-stack E-Commerce backend application built using Spring Boot.  
It provides authentication, product management, cart functionality, and complete order lifecycle management with admin control.

---

## 🚀 Features

### 👤 Authentication & Authorization
- User registration and login
- JWT-based authentication
- Role-based access control (USER, ADMIN)

---

### 🛍️ Product Management
- Add products (Admin only)
- View all products
- View product details

---

### 🛒 Cart Management
- Add items to cart
- Update cart quantity
- Remove items from cart
- View cart with total price calculation

---

### 📦 Order Management
- Place order from cart
- View user orders
- Order status tracking

Order Flow:
PENDING → CONFIRMED → SHIPPED → DELIVERED

---

### 🛠️ Admin Features
- View all orders
- Update order status
- Secure admin-only APIs

---

### ⚠️ Exception Handling
- Global exception handling using `@RestControllerAdvice`
- Custom exceptions:
  - ResourceNotFoundException
  - InvalidRequestException
  - UnauthorizedException

---

## 🧱 Tech Stack

- Java
- Spring Boot
- Spring Security
- JWT Authentication
- Spring Data JPA
- Hibernate
- PostgreSQL / MySQL
- Maven

---

## 🏗️ Architecture

Controller → Service → Repository → Database

- Layered architecture
- DTO-based request/response structure
- Clean separation of concerns

---

## 🔐 Security

- JWT token-based authentication
- Role-based authorization (USER / ADMIN)
- Protected admin endpoints

---

## 📡 API Endpoints

### Auth
- POST /api/auth/register
- POST /api/auth/login

### Products
- GET /api/products
- POST /api/products (ADMIN)

### Cart
- POST /api/cart/add
- GET /api/cart
- PUT /api/cart/update
- DELETE /api/cart/remove

### Orders
- POST /api/orders/place
- GET /api/orders/my-orders
- GET /api/orders (ADMIN)
- PUT /api/orders/{orderId}/status (ADMIN)

---

## 🎯 Learning Outcomes

- REST API development using Spring Boot
- JWT authentication and Spring Security
- Role-based access control
- Exception handling in production apps
- Real-world e-commerce backend design

---

## 📌 Future Improvements

- Frontend integration (React)
- Payment gateway integration
- Pagination and filtering
- Order tracking UI

---

## 👨‍💻 Author

Shivam Sharma  
Full Stack Developer (Java + Spring Boot + React)
