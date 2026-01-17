# School Management System - Backend Service

A RESTful API backend service for managing schools and students built with Spring Boot.

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
- [API Documentation](#api-documentation)

## 🎯 Overview

The School Management System is a backend service that provides RESTful APIs to manage schools and students. It implements a one-to-many relationship where one school can have multiple students. The application follows a layered architecture pattern with clear separation of concerns.

## ✨ Features

- **School Management**
  - Add new schools
  - Get all schools
  - Search schools by ID
  - Delete schools

- **Student Management**
  - Add new students to schools
  - Get all students
  - Search students by ID
  - Delete students

- **Data Relationships**
  - One-to-Many relationship between Schools and Students
  - Cascading operations for related entities

## 🛠 Technology Stack

- **Java**: 21
- **Spring Boot**: 4.0.1
- **Spring Data JPA**: Data persistence and ORM
- **MySQL**: Database (Aiven Cloud)
- **Lombok**: Reduce boilerplate code
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
│   │   │       ├── configuration/
│   │   │       │   └── MapperConfig.java              # ModelMapper configuration
│   │   │       ├── controller/
│   │   │       │   ├── SchoolController.java          # School REST endpoints
│   │   │       │   └── StudentController.java         # Student REST endpoints
│   │   │       ├── dto/
│   │   │       │   ├── SchoolDto.java                 # School data transfer object
│   │   │       │   └── StudentDto.java                # Student data transfer object
│   │   │       ├── entity/
│   │   │       │   ├── School.java                    # School JPA entity
│   │   │       │   └── Student.java                   # Student JPA entity
│   │   │       ├── mapper/
│   │   │       │   ├── SchoolMapper.java              # School mapper interface
│   │   │       │   └── StudentMapper.java             # Student mapper interface
│   │   │       ├── repository/
│   │   │       │   ├── SchoolRepository.java          # School data access layer
│   │   │       │   └── StudentRepository.java         # Student data access layer
│   │   │       └── service/
│   │   │           ├── SchoolService.java             # School service interface
│   │   │           ├── StudentService.java            # Student service interface
│   │   │           └── impl/
│   │   │               ├── SchoolImpl.java            # School service implementation
│   │   │               └── StudentImpl.java           # Student service implementation
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

The application uses MySQL database hosted on Aiven Cloud. Update the database credentials in `src/main/resources/application-local.yml`:

```yaml
spring:
  datasource:
    driver-class-name: com.mysql.cj.jdbc.Driver
    url: jdbc:mysql://<host>:<port>/<database_name>?ssl-mode=REQUIRED&createDatabaseIfNotExist=true&useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC
    username: <your-username>
    password: <your-password>
  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true
```

**Note**: For production, it's recommended to use environment variables or external configuration for sensitive data.

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
  "addressId": 100,
  "cityId": 1,
  "provinceId": 1
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

## 🗄️ Database Schema

### Tables

#### schools
| Column | Type | Description |
|--------|------|-------------|
| id | INTEGER | Primary Key |
| name | VARCHAR | School name |
| address_id | INTEGER | Reference to address |
| city_id | INTEGER | Reference to city |
| province_id | INTEGER | Reference to province |

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
| class_id | INTEGER | Reference to class |
| school_id | INTEGER | Foreign Key to schools |

### Relationships

- **School → Students**: One-to-Many (One school can have multiple students)
- **Cascade Type**: ALL (Operations on school cascade to students)

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

- [ ] Add authentication and authorization (Spring Security)
- [ ] Implement pagination for list endpoints
- [ ] Add comprehensive exception handling
- [ ] Implement validation for DTOs
- [ ] Add unit and integration tests
- [ ] Implement audit logging
- [ ] Add filtering and sorting capabilities
- [ ] Implement soft delete functionality
- [ ] Add API versioning
- [ ] Create Docker container for deployment

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## 📄 License

This project is licensed under the MIT License.

## 👤 Author

**ICET Education**
- Organization: Institute of Computer Engineering Technology

## 📞 Support

For support, email your-email@example.com or create an issue in the repository.

---

**Note**: Remember to update database credentials and remove sensitive information before committing to version control. Use environment variables or secure vault solutions for production deployments.

