# School Management System - Backend Service

A RESTful API backend service for managing schools, students, grades, and classes with JWT-based authentication, built with Spring Boot.

## 📋 Table of Contents
- [Overview](#overview)
- [Features](#features)
- [Technology Stack](#technology-stack)
- [Project Structure](#project-structure)
- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [Configuration](#configuration)
- [Running the Application](#running-the-application)
- [API Endpoints](#api-endpoints)
- [Database Schema](#database-schema)
- [Authentication](#authentication)
- [API Documentation](#api-documentation)

## 🎯 Overview

The School Management System is a comprehensive backend service that provides RESTful APIs to manage schools, students, grades, and classes. It implements complex relationships including one-to-many and many-to-one associations between entities. The application features JWT-based authentication and authorization using Spring Security, follows a layered architecture pattern with clear separation of concerns, and provides interactive API documentation via Swagger UI.

## ✨ Features

- **Authentication & Authorization**
  - User registration and login
  - JWT-based authentication
  - Role-based access control
  - Secure password encryption

- **School Management**
  - Add new schools
  - Get all schools
  - Search schools by ID
  - Delete schools
  - Track school address information

- **Student Management**
  - Add new students to schools and classes
  - Get all students
  - Search students by ID
  - Delete students
  - Manage student contact information (phone, email, NIC)

- **Grade Management**
  - Add new grades
  - Get all grades
  - Search grades by ID
  - Delete grades
  - Hierarchical grade organization

- **Class Management**
  - Add new classes
  - Get all classes
  - Search classes by ID
  - Delete classes
  - Associate classes with grades

- **Data Relationships**
  - One-to-Many: School → Students
  - One-to-Many: Grade → Classes
  - One-to-Many: Class → Students
  - Many-to-One: Student → School
  - Many-to-One: Student → Class
  - Many-to-One: Class → Grade
  - Cascading operations for related entities

## 🛠 Technology Stack

- **Java**: 21
- **Spring Boot**: 4.0.1
- **Spring Data JPA**: Data persistence and ORM
- **Spring Security**: 4.0.1 - Authentication and authorization
- **MySQL**: 9.3.0 - Database (Local/Cloud compatible)
- **JWT (JSON Web Tokens)**: 0.11.5 - Token-based authentication
  - jjwt-api
  - jjwt-impl
  - jjwt-jackson
- **Lombok**: 1.18.42 - Reduce boilerplate code
- **MapStruct**: 1.5.5.Final - DTO to Entity mapping
- **ModelMapper**: 3.1.1 - Object mapping
- **SpringDoc OpenAPI**: 2.8.13 - API documentation (Swagger UI)
- **Maven**: Build and dependency management

## 📁 Project Structure

```
school-sv/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── edu/icet/
│   │   │       ├── Main.java                          # Application entry point
│   │   │       ├── auth/
│   │   │       │   └── JwtAuthenticationFilter.java   # JWT request filter
│   │   │       ├── configuration/
│   │   │       │   └── MapperConfig.java              # ModelMapper configuration
│   │   │       ├── controller/
│   │   │       │   ├── AuthenticationController.java  # Authentication endpoints
│   │   │       │   ├── ClassesController.java         # Class REST endpoints
│   │   │       │   ├── GradeController.java           # Grade REST endpoints
│   │   │       │   ├── SchoolController.java          # School REST endpoints
│   │   │       │   └── StudentController.java         # Student REST endpoints
│   │   │       ├── dto/
│   │   │       │   ├── AuthenticationResponse.java    # JWT response DTO
│   │   │       │   ├── ClassesDto.java                # Class data transfer object
│   │   │       │   ├── GradeDto.java                  # Grade data transfer object
│   │   │       │   ├── SchoolDto.java                 # School data transfer object
│   │   │       │   ├── StudentDto.java                # Student data transfer object
│   │   │       │   └── UserDto.java                   # User data transfer object
│   │   │       ├── entity/
│   │   │       │   ├── Classes.java                   # Class JPA entity
│   │   │       │   ├── Grade.java                     # Grade JPA entity
│   │   │       │   ├── School.java                    # School JPA entity
│   │   │       │   ├── Student.java                   # Student JPA entity
│   │   │       │   └── User.java                      # User JPA entity
│   │   │       ├── mapper/
│   │   │       │   ├── ClassMapper.java               # Class mapper interface
│   │   │       │   ├── GradeMapper.java               # Grade mapper interface
│   │   │       │   ├── SchoolMapper.java              # School mapper interface
│   │   │       │   └── StudentMapper.java             # Student mapper interface
│   │   │       ├── repository/
│   │   │       │   ├── ClassesRepository.java         # Class data access layer
│   │   │       │   ├── GradeRepository.java           # Grade data access layer
│   │   │       │   ├── SchoolRepository.java          # School data access layer
│   │   │       │   ├── StudentRepository.java         # Student data access layer
│   │   │       │   └── UserRepository.java            # User data access layer
│   │   │       ├── security/
│   │   │       │   ├── ApplicationConfig.java         # Security configuration
│   │   │       │   └── Config.java                    # Additional security config
│   │   │       ├── service/
│   │   │       │   ├── AuthenticationService.java     # Authentication service interface
│   │   │       │   ├── ClassesService.java            # Class service interface
│   │   │       │   ├── GradeService.java              # Grade service interface
│   │   │       │   ├── SchoolService.java             # School service interface
│   │   │       │   ├── StudentService.java            # Student service interface
│   │   │       │   └── impl/
│   │   │       │       ├── AuthenticationServiceImpl.java # Auth implementation
│   │   │       │       ├── ClassesImpl.java           # Class service implementation
│   │   │       │       ├── GradeImpl.java             # Grade service implementation
│   │   │       │       ├── SchoolImpl.java            # School service implementation
│   │   │       │       └── StudentImpl.java           # Student service implementation
│   │   │       └── util/
│   │   │           └── JwtService.java                # JWT utility service
│   │   └── resources/
│   │       ├── application.yml                        # Main configuration
│   │       └── application-local.yml                  # Local profile configuration
│   └── test/
│       └── java/
└── pom.xml                                            # Maven dependencies
```

## 📋 Prerequisites

Before running this application, ensure you have the following installed:

- **Java Development Kit (JDK)**: Version 21 or higher
- **Maven**: Version 3.6 or higher
- **MySQL Database**: Running instance or access to cloud database
- **IDE** (Optional): IntelliJ IDEA, Eclipse, or VS Code

## 🚀 Installation

1. **Clone the repository**
   ```bash
   git clone <repository-url>
   cd school-sv
   ```

2. **Build the project**
   ```bash
   mvn clean install
   ```

   This will:
   - Download all dependencies
   - Compile the source code
   - Generate MapStruct implementation classes
   - Create the JAR file

## ⚙️ Configuration

### Database Configuration

The application uses MySQL database. Update the database credentials in `src/main/resources/application-local.yml`:

```yaml
spring:
  datasource:
    driver-class-name: com.mysql.cj.jdbc.Driver
    url: jdbc:mysql://localhost:3306/school_sv_db
    username: root
    password: Root@123
  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true
```

**Note**: For production, it's recommended to use environment variables or external configuration for sensitive data like passwords.

### JWT Configuration

JWT secret keys and expiration times should be configured in your application properties. Ensure to use strong secret keys in production environments.

The application uses a SECRET_KEY configured in `src/main/resources/application.properties`:

**Security Note**: Secret key should be changed and stored securely (e.g., in environment variables) for production deployments.

### Application Profiles

- **Default Profile**: `local` (configured in `application.yml`)
- **Local Profile**: Development configuration with database settings

## 🏃 Running the Application

### Using Maven

```bash
mvn spring-boot:run
```

### Using Java

```bash
java -jar target/school-sv-1.0-SNAPSHOT.jar
```

### Using IDE

Run the `Main.java` class directly from your IDE.

The application will start on the default port (usually **8080**).

## 📡 API Endpoints

### Authentication APIs

| Method | Endpoint | Description | Request Body |
|--------|----------|-------------|--------------|
| POST | `/auth/register` | Register a new user | UserDto |
| POST | `/auth/authenticate` | Authenticate and get JWT token | UserDto |

**UserDto Structure:**
```json
{
  "id": 1,
  "username": "john_doe",
  "password": "password123",
  "role": "USER"
}
```

**AuthenticationResponse Structure:**
```json
{
  "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9..."
}
```

### School Management APIs

| Method | Endpoint | Description | Request Body |
|--------|----------|-------------|--------------|
| POST | `/school/add-school` | Add a new school | SchoolDto |
| GET | `/school/get-school` | Get all schools | - |
| GET | `/school/search-school?id={id}` | Search school by ID | - |
| DELETE | `/school/delete-school?id={id}` | Delete school by ID | - |

**SchoolDto Structure:**
```json
{
  "id": 1,
  "name": "ABC School",
  "addressId": 100
}
```

### Student Management APIs

| Method | Endpoint | Description | Request Body |
|--------|----------|-------------|--------------|
| POST | `/student/add-student` | Add a new student | StudentDto |
| GET | `/student/get-students` | Get all students | - |
| GET | `/student/search-student/{id}` | Search student by ID | - |
| DELETE | `/student/delete-student/{id}` | Delete student by ID | - |

**StudentDto Structure:**
```json
{
  "id": 1,
  "firstName": "John",
  "lastName": "Doe",
  "phone": "0771234567",
  "email": "john.doe@example.com",
  "nic": "123456789V",
  "addressId": 200,
  "classId": 10,
  "schoolId": 1
}
```

### Grade Management APIs

| Method | Endpoint | Description | Request Body |
|--------|----------|-------------|--------------|
| POST | `/grade/add-grade` | Add a new grade | GradeDto |
| GET | `/grade/get-grades` | Get all grades | - |
| GET | `/grade/search-grade/{id}` | Search grade by ID | - |
| DELETE | `/grade/delete-grade/{id}` | Delete grade by ID | - |

**GradeDto Structure:**
```json
{
  "id": 1,
  "name": "Grade 10"
}
```

### Class Management APIs

| Method | Endpoint | Description | Request Body |
|--------|----------|-------------|--------------|
| POST | `/classes/add-class` | Add a new class | ClassesDto |
| GET | `/classes/get-classes` | Get all classes | - |
| GET | `/classes/search-class/{id}` | Search class by ID | - |
| DELETE | `/classes/delete-class/{id}` | Delete class by ID | - |

**ClassesDto Structure:**
```json
{
  "id": 1,
  "gradeId": 10
}
```

## 🗄️ Database Schema

### Tables

#### users
| Column | Type | Description |
|--------|------|-------------|
| id | INTEGER | Primary Key |
| username | VARCHAR | Username for authentication |
| password | VARCHAR | Encrypted password |
| role | VARCHAR | User role (e.g., USER, ADMIN) |

#### schools
| Column | Type | Description |
|--------|------|-------------|
| id | INTEGER | Primary Key |
| name | VARCHAR | School name |
| address_id | INTEGER | Reference to address |

#### students
| Column | Type | Description |
|--------|------|-------------|
| id | INTEGER | Primary Key |
| first_name | VARCHAR | Student's first name |
| last_name | VARCHAR | Student's last name |
| phone | VARCHAR | Contact number |
| email | VARCHAR | Email address |
| nic | VARCHAR | National ID |
| address_id | INTEGER | Reference to address |
| class_id | INTEGER | Foreign Key to classes |
| school_id | INTEGER | Foreign Key to schools |

#### grade
| Column | Type | Description |
|--------|------|-------------|
| id | INTEGER | Primary Key |
| name | VARCHAR | Grade name (e.g., Grade 10) |

#### classes
| Column | Type | Description |
|--------|------|-------------|
| id | INTEGER | Primary Key |
| grade_id | INTEGER | Foreign Key to grade |

### Relationships

- **School → Students**: One-to-Many (One school can have multiple students)
  - Cascade Type: ALL (Operations on school cascade to students)
- **Grade → Classes**: One-to-Many (One grade can have multiple classes)
- **Class → Students**: One-to-Many (One class can have multiple students)
  - Cascade Type: ALL (Operations on class cascade to students)
- **Student → School**: Many-to-One (Many students belong to one school)
- **Student → Class**: Many-to-One (Many students belong to one class)
- **Class → Grade**: Many-to-One (Many classes belong to one grade)

## 🔐 Authentication

The application implements JWT (JSON Web Token) based authentication using Spring Security:

### Authentication Flow

1. **Registration**: Users register with username, password, and role
2. **Authentication**: Users authenticate with credentials and receive a JWT token
3. **Authorization**: Subsequent requests include the JWT token in the Authorization header
4. **Token Validation**: JwtAuthenticationFilter validates the token for each protected endpoint

### Security Components

- **JwtAuthenticationFilter**: Intercepts requests and validates JWT tokens
- **JwtService**: Handles token generation, validation, and extraction of user details
- **ApplicationConfig**: Configures Spring Security with authentication providers and password encoding
- **Config**: Additional security configurations for HTTP security and CORS

### Protected Endpoints

All API endpoints (except `/auth/register` and `/auth/authenticate`) require a valid JWT token in the Authorization header:

```
Authorization: Bearer <your-jwt-token>
```

### CORS Configuration

The application has CORS (Cross-Origin Resource Sharing) enabled on all controllers using the `@CrossOrigin` annotation, allowing frontend applications from different origins to access the API endpoints.

## 📚 API Documentation

Once the application is running, you can access the interactive API documentation:

**Swagger UI**: [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

**OpenAPI JSON**: [http://localhost:8080/v3/api-docs](http://localhost:8080/v3/api-docs)

## 🏗️ Architecture

The application follows a **layered architecture** pattern:

1. **Controller Layer**: Handles HTTP requests and responses
2. **Service Layer**: Contains business logic
3. **Repository Layer**: Handles data persistence
4. **Entity Layer**: JPA entities representing database tables
5. **DTO Layer**: Data Transfer Objects for API communication
6. **Mapper Layer**: Converts between DTOs and Entities

## 🔄 Object Mapping

The application uses two mapping strategies:

1. **MapStruct**: Used for entity-to-DTO conversions in read operations
   - Compile-time code generation
   - Type-safe mappings
   - Better performance

2. **ModelMapper**: Used for DTO-to-entity conversions in write operations
   - Runtime mapping
   - More flexible for complex mappings


## 🧪 Testing

Run the tests using:

```bash
mvn test
```

## 🔧 Build

Create a production-ready JAR:

```bash
mvn clean package
```

The JAR file will be created at `target/school-sv-1.0-SNAPSHOT.jar`

## 📝 Future Enhancements

- [x] Add authentication and authorization (Spring Security) ✅ **Implemented**
- [ ] Implement pagination for list endpoints
- [ ] Add comprehensive exception handling
- [ ] Implement validation for DTOs
- [ ] Add unit and integration tests
- [ ] Implement audit logging
- [ ] Add filtering and sorting capabilities
- [ ] Implement soft delete functionality
- [ ] Add API versioning
- [ ] Create Docker container for deployment
- [ ] Implement refresh token mechanism
- [ ] Add rate limiting for API endpoints

## 🔧 Troubleshooting

### Common Issues

1. **Database Connection Failed**
   - Ensure MySQL server is running
   - Verify database credentials in `application-local.yml`
   - Check if the database `school_sv_db` exists

2. **MapStruct Implementation Not Generated**
   - Run `mvn clean compile` to regenerate mapper implementations
   - Check that MapStruct processor dependency is included in `pom.xml`

3. **JWT Token Errors**
   - Ensure SECRET_KEY is properly configured in `application.properties`
   - Verify token is included in Authorization header with "Bearer " prefix

4. **Port Already in Use**
   - Change server port in `application-local.yml`:
     ```yaml
     server:
       port: 8081
     ```

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## 👤 Author

**ICET Education**
- Organization: Institute of Computer Engineering Technology

## 📞 Support

For support, email your-email@example.com or create an issue in the repository.

---

**Note**: Remember to update database credentials and remove sensitive information before committing to version control. Use environment variables or secure vault solutions for production deployments.

