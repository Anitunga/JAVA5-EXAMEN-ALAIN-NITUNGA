# LibraryManagementApi
A SpringBoot designed to manage authors and books in a Library.

## Introduction
The Library Management System is a Spring Boot application designed to manage books and authors in a library. It provides a RESTful API for creating, reading, updating, and deleting books and authors. The application uses a relational database to store data and provides a simple and intuitive API for interacting with the data.

# Features
- Create, read, update, and delete books and authors
- Search for books by title, author, or genre
- Filter books by author, genre, or publication date
- Sort books by title, author, or publication date
- Support for multiple authors per book
- Support for multiple genres per book

## Getting Started
To get started with the Library Management System, follow these steps:

Clone the repository:
```
git clone https://github.com/your-username/library-management-system.git
```
```
cd library-management-system
```

### Configure the database connection in `src/main/resources/application.properties`:
```properties
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=password
spring.h2.console.enabled=true
```

## API Endpoints
The following API endpoints are available:

### Book Endpoints
- GET /books: Get all books
- GET /books/{id}: Get a book by ID
- POST /books: Create a new book
- PUT /books/{id}: Update a book
- DELETE /books/{id}: Delete a book

### Author Endpoints
- GET /authors: Get all authors
- GET /authors/{id}: Get an author by ID
- POST /authors: Create a new author
- PUT /authors/{id}: Update an author
- DELETE /authors/{id}: Delete an author


