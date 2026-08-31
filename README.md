# Mr Chai — E-Commerce Web Application

Mr Chai is a full-stack e-commerce web application developed to practice and demonstrate real-world frontend and backend development. The project is being built incrementally, with user registration and login currently implemented and additional e-commerce features planned for future development.

## Project Status

**Currently in development**

The current version focuses on establishing frontend-backend communication and implementing user registration and login functionality with database integration.

## Current Implementation

### Frontend

The frontend is built using:

* HTML5
* CSS3
* JavaScript
* Fetch API
* JSON

Currently implemented:

* E-commerce homepage structure
* Navigation bar
* User login page UI
* User registration page UI
* Registration form with:
  * Name
  * Email
  * Password
    
* Client-side form handling using JavaScript
* Asynchronous communication with the Spring Boot backend using `fetch()`
* JSON request creation and transmission
* Login form with:
  * Email
  * Password
    
* Login form input handling and submission
* Login success and failure message handling
* Redirect to the dashboard after successful login

### Backend

The backend is built using:

* Java
* Spring Boot
* Spring Data JPA
* REST APIs
* Maven

Currently implemented:

* Layered backend structure
* User entity
* User repository
* User service
* User controller
* User registration REST API
* User login REST API
* Login form input handling and submission
* CORS configuration for frontend-backend communication
* Request handling using `@RequestBody`
* Database persistence using Spring Data JPA

### Database

The application currently uses:

* MySQL

User registration data is successfully stored in the database through the Spring Boot backend.

## Current Registration Flow

```text
User
 ↓
Registration Form
 ↓
JavaScript
 ↓
Create JSON Object
 ↓
Fetch API
 ↓
POST /users/register
 ↓
Spring Boot Controller
 ↓
User Service
 ↓
User Repository
 ↓
MySQL Database
```

Example request:

```json
{
  "name": "Mahesh",
  "email": "mahesh@example.com",
  "password": "password"
}
```
The backend processes the request and stores the user information in the database.

## Current Login Flow

```text
User
 ↓
Login Form
 ↓
JavaScript
 ↓
Create JSON Object
 ↓
Fetch API
 ↓
POST /users/login
 ↓
Spring Boot Controller
 ↓
User Service
 ↓
User Repository
 ↓
MySQL Database
 ↓
Validate Email & Password
 ↓
Login Response
 ↓
Success Message / Error Message
 ↓
Dashboard
```

## Project Structure

```text
Mr Chai/
│
├── Mr Chai Frontend/
│   ├── index.html
│   │
│   ├── HTML/
│   │   ├── dashboard.html
│   │   ├── login.html
│   │   └── register.html
│   │
│   ├── Style/
│   │   ├── index.css
│   │   ├── login.css
│   │   └── register.css
│   │
│   └── JS/
│       ├── login.js
│       └── register.js
│
├── Mr Chai Backend/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/
│   │   │   │   └── com/Mr_Chai/
│   │   │   │       ├── Controller/
│   │   │   │       ├── Entity/
│   │   │   │       ├── Repository/
│   │   │   │       ├── Service/
│   │   │   │       └── ECommerceBackendApplication.java
│   │   │   │
│   │   │   └── resources/
│   │   │       └── application.properties
│   │   │
│   │   └── test/
│   │
│   └── pom.xml
│
└── .gitignore
```

## API Endpoints

### User Registration

```http
POST /users/register
```

Request body:

```json
{
  "name": "Mahesh",
  "email": "mahesh@example.com",
  "password": "password"
}
```

### User Login

```http
POST /users/login
```

Request body:

```json
{
  "email": "mahesh@example.com",
  "password": "password"
}
```

> The login endpoint is integrated with the frontend login form. The frontend sends the user's email and password to the Spring Boot backend, which input handling and submission.

## Technologies Used

| Layer           | Technologies                    |
| --------------- | ------------------------------- |
| Frontend        | HTML5, CSS3, JavaScript         |
| Communication   | REST API, HTTP, JSON, Fetch API |
| Backend         | Java, Spring Boot               |
| Persistence     | Spring Data JPA, Hibernate      |
| Database        | MySQL                           |
| Build Tool      | Maven                           |
| Version Control | Git, GitHub                     |

## Planned Features

The project will be developed incrementally with the following features planned:

* [x] Project structure
* [x] Frontend registration form
* [x] Backend user registration API
* [x] Database persistence for users
* [x] Frontend-backend communication
* [x] User login
* [ ] Authentication and authorization
* [ ] Product management
* [ ] Product listing and dashboard
* [ ] Product search and filtering
* [ ] Shopping cart
* [ ] Order management
* [ ] Payment integration
* [ ] User profile
* [ ] Order history
* [ ] Admin functionality
* [ ] Deployment

## Learning Objectives

This project is being developed incrementally to gain practical experience with:

* Building RESTful APIs
* Connecting JavaScript applications with Spring Boot
* Sending and receiving JSON data
* Asynchronous JavaScript using `async/await`
* Spring Boot layered architecture
* Spring Data JPA and database persistence
* MySQL database integration
* Git and GitHub workflow
* Full-stack application development

## Development Approach

The application is being developed feature by feature rather than building the entire application at once.

The current development path is:

```text
User Registration
       ↓
User Login
       ↓
Authentication
       ↓
Product Management
       ↓
Product Dashboard
       ↓
Shopping Cart
       ↓
Orders
       ↓
Payment
       ↓
Admin Features
       ↓
Deployment
```

## Disclaimer

This project is developed for learning, portfolio development, and demonstrating full-stack development skills. Features will be added and improved progressively as development continues.
