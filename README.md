# School Management System - Backend Service

A Spring Boot backend foundation for a comprehensive school management system with JWT-based authentication, database migration support, and a well-structured data model for educational institutions.

## 📋 Table of Contents
- [Quick Start](#quick-start)
- [Overview](#overview)
- [Project Status](#project-status)
- [Technology Stack](#technology-stack)
- [Project Structure](#project-structure)
- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [Configuration](#configuration)
- [Database Setup](#database-setup)
- [Running the Application](#running-the-application)
- [Database Schema](#database-schema)
- [Authentication & Security](#authentication--security)
- [API Documentation](#api-documentation)
- [Architecture](#architecture)
- [Development Roadmap](#development-roadmap)
- [Troubleshooting](#troubleshooting)
- [Contributing](#contributing)

## 🚀 Quick Start

Get the application running in 5 minutes:

```bash
# 1. Clone the repository
git clone <repository-url>
cd school-sv

# 2. Create MySQL database
mysql -u root -p
# In MySQL console:
# CREATE DATABASE school_sv_saas_db;
# EXIT;

# 3. Configure database credentials
# Edit src/main/resources/application.yml
# Update username and password with your MySQL credentials

# 4. Build and run
mvn clean install
mvn spring-boot:run
```

**Expected Output:**
- ✅ Flyway migrations executed
- ✅ Tables created automatically
- ✅ Application started on port 8080
- ✅ JWT authentication ready

**What's Next?**
- The security infrastructure is ready
- Database schema is complete
- Next step: Implement REST controllers and service layer (see [Development Roadmap](#development-roadmap))

---

## 🎯 Overview

The School Management System is a backend service foundation built with Spring Boot 4.0.1 and Java 21. The project establishes a secure authentication system with JWT tokens and a comprehensive database schema for managing educational institutions.

### Key Highlights
- **JWT-based authentication** with Spring Security 4.0.1
- **Database migration** with Flyway 11.20.2 for version-controlled schema management
- **Comprehensive database schema** covering students, teachers, courses, exams, attendance, library, and more
- **Security-first approach** with BCrypt password encryption and role-based access control
- **Modern Java 21** with latest Spring Boot 4.0.1
- **Well-structured foundation** ready for API implementation

### Planned Features (Database Schema Ready)

The database schema supports the following features, pending API implementation:

#### 📚 Academic Management
- **Student Management**: Registration, profiles, enrollment tracking
- **Teacher Management**: Staff records, department assignments, type classification
- **Classroom Management**: Class organization, grade-level structure, teacher assignments
- **Course Management**: Course catalog, teacher-course assignments, department structure
- **Grade/Year Management**: Grade levels and academic progression

#### 📊 Academic Operations
- **Enrollment System**: Student-course enrollment tracking with dates
- **Attendance Tracking**: Daily attendance records with Present/Absent status
- **Examination System**: Exam scheduling, types (Midterm, Final), course-based exams
- **Results Management**: Student exam scores and performance tracking
- **Assignment Management**: Course assignments with due dates

#### 📖 Library Management
- **Book Catalog**: Title, author, ISBN, quantity tracking
- **Borrowing System**: Book checkout/return with date tracking
- **Availability**: Real-time quantity management

#### 💰 Financial Management
- **Fee Management**: Student fee records
- **Payment Tracking**: Due dates, paid dates, amount tracking
- **Outstanding Fees**: Payment status monitoring

#### 👨‍👩‍👧‍👦 User Management
- **Parent/Guardian**: Contact information for students
- **Department Structure**: Academic and administrative departments
- **Teacher Types**: Employment classification (Full-time, Part-time)

#### 🔐 Security Features (Implemented)
- **User Authentication**: Username/password with JWT tokens
- **Role-Based Access**: ADMIN and USER roles with different permissions
- **Password Security**: BCrypt encryption with automatic salting
- **Token Management**: 10-hour token expiration with validation

## 📊 Project Status

### ✅ Implemented Components
- ✅ **Authentication System**: JWT token generation and validation
- ✅ **Security Configuration**: Spring Security with filter chain, role-based authorization
- ✅ **Database Schema**: Complete schema with 15+ tables via Flyway migrations
- ✅ **Entity Models**: User entity with JPA annotations
- ✅ **DTOs**: Data transfer objects for all major entities
- ✅ **Security Components**: JWT authentication filter, password encoding
- ✅ **Exception Handling**: Global exception handler with custom error details
- ✅ **Configuration**: ModelMapper, RestTemplate beans
- ✅ **OpenAPI Setup**: Swagger/OpenAPI configuration with JWT bearer authentication

### 🚧 In Development / Pending
- 🚧 **REST Controllers**: API endpoints need to be implemented
- 🚧 **Service Layer**: Business logic implementation pending
- 🚧 **Repository Layer**: Only UserRepository implemented, others needed
- 🚧 **Entity Layer**: Complete entity models for all database tables
- 🚧 **Data Validation**: Bean validation annotations
- 🚧 **Integration Tests**: Test coverage for APIs

### Architecture Status
The project has a solid **foundation** with:
- Security infrastructure ✅
- Database schema ✅
- Configuration setup ✅
- DTO models ✅

**Next steps**: Implement service layer and REST controllers to expose functionality.

## 🛠 Technology Stack

### Core Framework
- **Java**: 21 (Latest LTS)
- **Spring Boot**: 4.0.1
- **Maven**: Build and dependency management

### Spring Ecosystem
- **Spring Boot Starter Web**: 4.0.1 - RESTful API development
- **Spring Data JPA**: ORM and data persistence
- **Spring Security**: 4.0.1 - Authentication and authorization
- **Spring Boot Starter Validation**: 4.0.1 - Bean validation

### Database & Migration
- **MySQL Connector**: 9.3.0 - Database connectivity
- **Flyway MySQL**: 11.20.2 - Database version control and migration
- **Spring Boot Starter Flyway**: 4.0.1 - Flyway integration

### Security & Authentication
- **JWT (JSON Web Tokens)**: 0.11.5 - Token-based authentication
  - `jjwt-api` - JWT API
  - `jjwt-impl` - JWT Implementation (runtime)
  - `jjwt-jackson` - Jackson integration for JWT (runtime)
- **BCrypt**: Password encryption (included in Spring Security)

### Object Mapping & Utilities
- **Lombok**: 1.18.42 - Reduce boilerplate code (getters, setters, builders, etc.)
- **MapStruct**: 1.5.5.Final - Compile-time DTO ↔ Entity mapping
- **ModelMapper**: 3.1.1 - Runtime object mapping

### API Documentation
- **SpringDoc OpenAPI**: 2.8.13 - OpenAPI 3.0 specification
  - Swagger UI integration
  - Interactive API documentation
  - JWT bearer authentication support

### Build Tool
- **Maven**: 3.6+ recommended for dependency management and build automation

## 📁 Project Structure

```
school-sv/
├── pom.xml                                           # Maven configuration with dependencies
├── README.md                                         # Project documentation
├── SQL_DIALECT_SETUP.md                             # SQL dialect configuration guide
├── src/
│   ├── main/
│   │   ├── java/edu/icet/
│   │   │   ├── Main.java                            # Spring Boot application entry point
│   │   │   │
│   │   │   ├── auth/                                # Authentication components
│   │   │   │   └── JwtAuthenticationFilter.java     # JWT request interceptor filter
│   │   │   │
│   │   │   ├── configuration/                       # Spring configuration beans
│   │   │   │   ├── Configurations.java              # ModelMapper & RestTemplate config
│   │   │   │   └── OpenAPIConfig.java               # Swagger/OpenAPI configuration
│   │   │   │
│   │   │   ├── dto/                                 # Data Transfer Objects
│   │   │   │   ├── Assignments.java                 # Assignment DTO
│   │   │   │   ├── Attendance.java                  # Attendance DTO
│   │   │   │   ├── BorrowedBooks.java               # Library borrowing DTO
│   │   │   │   ├── ClassRooms.java                  # Classroom DTO
│   │   │   │   ├── Courses.java                     # Course DTO
│   │   │   │   ├── Departments.java                 # Department DTO
│   │   │   │   ├── Enrollments.java                 # Enrollment DTO
│   │   │   │   ├── ExamResults.java                 # Exam results DTO
│   │   │   │   ├── Exams.java                       # Exams DTO
│   │   │   │   ├── ExamType.java                    # Exam type DTO
│   │   │   │   ├── Fees.java                        # Fees DTO
│   │   │   │   ├── Grades.java                      # Grades DTO
│   │   │   │   ├── Library.java                     # Library DTO
│   │   │   │   ├── Parents.java                     # Parents DTO
│   │   │   │   ├── StudentClassRoom.java            # Student-classroom relation DTO
│   │   │   │   ├── Students.java                    # Student DTO
│   │   │   │   ├── Teachers.java                    # Teacher DTO
│   │   │   │   └── TeacherType.java                 # Teacher type DTO
│   │   │   │
│   │   │   ├── entity/                              # JPA Entity models
│   │   │   │   └── User.java                        # User entity (authentication)
│   │   │   │
│   │   │   ├── enums/                               # Enumeration types
│   │   │   │   ├── Gender.java                      # Gender (MALE, FEMALE, OTHER)
│   │   │   │   ├── Status.java                      # Status (PRESENT, ABSENT)
│   │   │   │   └── Type.java                        # Type (PUBLIC, PRIVATE)
│   │   │   │
│   │   │   ├── exception/                           # Exception handling
│   │   │   │   ├── ErrorDetails.java                # Error response structure
│   │   │   │   ├── GlobalExceptionHandler.java      # Global exception handler
│   │   │   │   └── ResourceNotFoundException.java   # Custom exception
│   │   │   │
│   │   │   ├── repository/                          # Data access layer
│   │   │   │   └── UserRepository.java              # User JDBC repository
│   │   │   │
│   │   │   ├── security/                            # Security configuration
│   │   │   │   ├── ApplicationConfig.java           # Auth provider & encoder config
│   │   │   │   └── Config.java                      # HTTP security filter chain
│   │   │   │
│   │   │   └── util/                                # Utility classes
│   │   │       └── JwtService.java                  # JWT token generation & validation
│   │   │
│   │   └── resources/
│   │       ├── application.properties                # JWT secret key
│   │       ├── application.yml                       # Database configuration
│   │       └── db.migration/
│   │           └── V1__schoold_sv.sql                # Flyway migration script
│   │
│   └── test/
│       └── java/                                     # Test classes (empty)
│
└── target/
    ├── classes/                                      # Compiled bytecode
    ├── school-sv-1.0-SNAPSHOT.jar                    # Packaged application JAR
    └── ...
```

### Key Directories

- **`auth/`**: JWT authentication filter for request interception
- **`configuration/`**: Spring beans and application configurations
- **`dto/`**: Data Transfer Objects for API requests/responses (18 DTOs defined)
- **`entity/`**: JPA entities representing database tables (User entity implemented)
- **`enums/`**: Enumeration types for Gender, Status, and Type
- **`exception/`**: Global exception handling and custom exceptions
- **`repository/`**: Data access layer using JdbcTemplate (User repository implemented)
- **`security/`**: Spring Security configurations for authentication and authorization
- **`util/`**: Utility classes including JWT service
- **`db.migration/`**: Flyway SQL migration scripts for database versioning

---

## 📦 DTOs & Enums

### Data Transfer Objects (DTOs)

The project includes 18 DTO classes for transferring data between layers, all using Lombok for getters/setters:

#### Core DTOs

1. **Students.java**
   - `id`, `firstName`, `lastName`, `birthday`, `gender`, `address`, `phone`, `email`
   - `parentId`, `classId`
   - Maps to Students table

2. **Teachers.java**
   - `id`, `firstName`, `lastName`, `birthDate`, `gender`, `address`, `phone`, `email`
   - `departmentId`, `teacherTypeId`
   - Maps to Teachers table

3. **ClassRooms.java**
   - `id`, `name`, `groupId`, `teacherId`
   - Maps to Classrooms table

4. **Courses.java**
   - Course information for curriculum management
   - Maps to Courses table

5. **Grades.java**
   - Grade level information
   - Maps to Grades table

6. **Parents.java**
   - Parent/guardian contact information
   - Maps to Parents table

7. **Departments.java**
   - `id`, `name`
   - Maps to Departments table

#### Academic & Operations DTOs

8. **Attendance.java**
   - `id`, `studentId`, `classId`, `enrollDate`, `status` (PRESENT/ABSENT)
   - Maps to Attendance table

9. **Enrollments.java**
   - Student course enrollment records
   - Maps to Enrollments table

10. **StudentClassRoom.java**
    - Many-to-many relationship between students and classrooms
    - Maps to StudentClassroom table

#### Assessment DTOs

11. **Exams.java**
    - Examination scheduling and details
    - Maps to Exams table

12. **ExamType.java**
    - Exam classification (Midterm, Final, Quiz)
    - Maps to ExamType table

13. **ExamResults.java**
    - Student exam scores and results
    - Maps to ExamResults table

14. **Assignments.java**
    - Course assignments and homework
    - Maps to Assignments table

#### Library & Financial DTOs

15. **Library.java**
    - `id`, `title`, `author`, `isbn`, `quantity`
    - Maps to Library table

16. **BorrowedBooks.java**
    - Book borrowing records
    - Maps to BorrowedBooks table

17. **Fees.java**
    - Student fee and payment tracking
    - Maps to Fees table

#### Employment DTOs

18. **TeacherType.java**
    - Teacher employment types (Full-time, Part-time)
    - Maps to TeacherType table

### Enumeration Types

The project includes 3 enum classes for type-safe constants:

#### 1. Gender.java
```java
public enum Gender {
    MALE,
    FEMALE,
    OTHER
}
```
**Used in:** Students, Teachers entities

#### 2. Status.java
```java
public enum Status {
    PRESENT,
    ABSENT
}
```
**Used in:** Attendance records

#### 3. Type.java
```java
public enum Type {
    PUBLIC,
    PRIVATE
}
```
**Used in:** School classification (not yet in database schema)

### DTO Design Pattern

**Benefits:**
- **Decoupling**: API structure independent of database schema
- **Security**: Control what data is exposed to clients
- **Versioning**: Change DTOs without affecting database
- **Validation**: Add validation annotations without modifying entities
- **Performance**: Transfer only needed data

**Usage Pattern:**
```
Client → DTO → Controller → Service → Entity → Repository → Database
                                     ↕
Database → Entity → Repository → Service → DTO → Controller → Client
```

### Adding Validation to DTOs

DTOs should include validation annotations when used in controller requests:

```java
package edu.icet.dto;

import edu.icet.enums.Gender;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;

@Getter
@Setter
public class Students {
    private Integer id;
    
    @NotBlank(message = "First name is required")
    @Size(min = 2, max = 50, message = "First name must be between 2 and 50 characters")
    private String firstName;
    
    @NotBlank(message = "Last name is required")
    @Size(min = 2, max = 50, message = "Last name must be between 2 and 50 characters")
    private String lastName;
    
    @Past(message = "Birthday must be in the past")
    private Date birthday;
    
    @NotNull(message = "Gender is required")
    private Gender gender;
    
    @Size(max = 255, message = "Address cannot exceed 255 characters")
    private String address;
    
    @Pattern(regexp = "^[0-9]{10}$", message = "Phone must be 10 digits")
    private String phone;
    
    @Email(message = "Invalid email format")
    @NotBlank(message = "Email is required")
    private String email;
    
    @NotNull(message = "Class ID is required")
    private Integer classId;
}
```

**Common Validation Annotations:**
- `@NotNull` - Field cannot be null
- `@NotBlank` - String cannot be null, empty, or whitespace
- `@Size(min, max)` - String/Collection size constraints
- `@Email` - Valid email format
- `@Past` / `@Future` - Date constraints
- `@Pattern(regexp)` - Regex validation
- `@Min` / `@Max` - Numeric range validation
- `@Positive` / `@PositiveOrZero` - Numeric positivity

---

## 🏛️ Entity Models

### Implemented Entities

#### User Entity ✅

**Location**: `edu.icet.entity.User`

**Purpose**: Represents users for authentication and authorization.

**Fields:**
- `id` (Integer) - Primary key
- `username` (String) - Unique username, validated as not blank
- `password` (String) - BCrypt encrypted password, validated as not blank
- `role` (String) - User role (ADMIN, USER, TEACHER), validated as not blank

**Annotations:**
- `@Entity` - JPA entity marker
- `@Table(name = "users")` - Maps to users table
- `@Id` - Primary key designation
- `@Data` - Lombok: generates getters, setters, equals, hashCode, toString
- `@Builder` - Builder pattern for object creation
- `@AllArgsConstructor` / `@NoArgsConstructor` - Constructors
- `@NotBlank` - Bean validation for required fields

**Validation:**
- Username, password, and role cannot be empty
- Custom error messages defined

**Usage:**
- Used by UserRepository for authentication
- Loaded by Spring Security UserDetailsService
- Password encrypted before storage

### Entities To Be Implemented

Based on the database schema, the following entities need implementation:

- **Student** → Students table
- **Teacher** → Teachers table
- **Parent** → Parents table
- **Department** → Departments table
- **Classroom** → Classrooms table
- **Course** → Courses table
- **Grade** → Grades table
- **TeacherType** → TeacherType table
- **ExamType** → ExamType table
- **Library** → Library table
- **Enrollment** → Enrollments table
- **StudentClassroom** → StudentClassroom table
- **Attendance** → Attendance table
- **Exam** → Exams table
- **ExamResult** → ExamResults table
- **Assignment** → Assignments table
- **BorrowedBook** → BorrowedBooks table
- **Fee** → Fees table

**Entity Implementation Checklist:**
- [ ] Define JPA entity with `@Entity` annotation
- [ ] Map to table with `@Table` annotation
- [ ] Define primary key with `@Id` and `@GeneratedValue`
- [ ] Add relationship annotations (`@ManyToOne`, `@OneToMany`, etc.)
- [ ] Add validation annotations (`@NotNull`, `@Size`, etc.)
- [ ] Use Lombok `@Data` or explicit getters/setters
- [ ] Define proper equals() and hashCode() methods

---

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

The application uses MySQL database with Flyway for automated migrations. Configure database credentials in `src/main/resources/application.yml`:

```yaml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/school_sv_saas_db
    username: your_mysql_username
    password: your_mysql_password
    driver-class-name: com.mysql.cj.jdbc.Driver

  flyway:
    enabled: true
```

**Configuration Options:**

| Property | Description | Example |
|----------|-------------|---------|
| `spring.datasource.url` | JDBC connection URL | `jdbc:mysql://localhost:3306/school_sv_saas_db` |
| `spring.datasource.username` | Database username | `root` or your MySQL user |
| `spring.datasource.password` | Database password | Your MySQL password |
| `spring.flyway.enabled` | Enable Flyway migrations | `true` |

**Important Notes:**
- Create the database (`school_sv_saas_db`) before first run, or let Flyway create it if your user has permissions
- For production, use environment variables for sensitive data:
  ```yaml
  spring:
    datasource:
      username: ${DB_USERNAME}
      password: ${DB_PASSWORD}
  ```
- Never commit real credentials to version control
- The database schema is automatically created by Flyway migration scripts

### JWT Configuration

The JWT secret key is configured in `src/main/resources/application.properties`:

```properties
SECRET_KEY=your_base64_encoded_secret_key_min_256_bits
```

**Security Requirements:**
- Secret key must be at least 256 bits (32 bytes) for HS256 algorithm
- Use a base64-encoded random string
- Example generation in Java:
  ```java
  import io.jsonwebtoken.SignatureAlgorithm;
  import io.jsonwebtoken.security.Keys;
  import java.util.Base64;
  
  Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
  String secretString = Base64.getEncoder().encodeToString(key.getEncoded());
  ```

**Security Best Practices:**
- Change the SECRET_KEY for production deployments
- Store sensitive keys in environment variables: `SECRET_KEY=${JWT_SECRET_KEY}`
- Rotate keys periodically
- Never commit production keys to version control
- Use different keys for different environments (dev, staging, prod)

### Token Expiration

JWT tokens are currently configured to expire after **10 hours**. You can modify this in `JwtService.java`:

```java
// Current: 10 hours (1000ms * 60s * 60m * 10h)
.setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
```

### Security Configuration

The `Config.java` defines access control rules:

| Endpoint Pattern | Access Level | Roles Required |
|------------------|--------------|----------------|
| `/auth/**` | Public | None |
| `/school/**` | Protected | ADMIN |
| `/student/**` | Public | None |
| `/teacher/**` | Protected | ADMIN |
| `/user/**` | Public | None |
| All other endpoints | Protected | Authenticated users |

**Note:** The current configuration allows public access to student and user endpoints. Adjust based on your security requirements.

## 🗄️ Database Setup

### Automatic Migration with Flyway

The application uses Flyway for database version control. The schema is automatically created on application startup from the migration script.

**Migration File**:
- `src/main/resources/db.migration/V1__schoold_sv.sql` - Complete database schema with all tables

**Flyway Migration Process**:
1. On application startup, Flyway checks the database
2. If `flyway_schema_history` table doesn't exist, it creates it
3. Flyway executes the V1 migration script to create all tables
4. Migration history is recorded for version tracking
5. Subsequent runs skip already-applied migrations

### Manual Database Creation

Create the database before first run:

```sql
CREATE DATABASE school_sv_saas_db;
```

Flyway will handle all table creation automatically when you start the application.

### Database Schema Overview

The V1 migration creates **15 tables**:

**Core Tables:**
- `Parents` - Parent/guardian information
- `Departments` - Academic departments
- `TeacherType` - Teacher employment types (Full-time, Part-time)
- `Grades` - Grade/year levels
- `ExamType` - Examination types (Midterm, Final, etc.)
- `Library` - Library book catalog

**Personnel Tables:**
- `Teachers` - Teacher information and assignments
- `Students` - Student records and enrollment

**Academic Tables:**
- `Classrooms` - Classroom organization
- `Courses` - Course definitions
- `StudentClassroom` - Student-classroom relationships
- `Enrollments` - Student course enrollments
- `Exams` - Examination records
- `ExamResults` - Student exam scores

**Operations Tables:**
- `Attendance` - Student attendance tracking
- `Assignments` - Course assignments
- `BorrowedBooks` - Library book borrowing
- `Fees` - Student fee management

### SQL Dialect Configuration (IntelliJ IDEA)

If you see SQL syntax errors in your IDE, configure the MySQL dialect:

**Quick Fix:**
1. Open `src/main/resources/db.migration/V1__schoold_sv.sql`
2. Look at the bottom-right corner of the editor
3. Click on the SQL dialect indicator
4. Select **MySQL** from the dropdown

**Project-Wide Configuration:**
1. Go to **Settings** → **Languages & Frameworks** → **SQL Dialects**
2. Set **Project SQL Dialect** to **MySQL**
3. Click **Apply** and **OK**

For detailed instructions, see [SQL_DIALECT_SETUP.md](SQL_DIALECT_SETUP.md).

### Verify Database Setup

After running the application, verify tables were created:

```bash
mysql -u your_username -p
```

```sql
USE school_sv_saas_db;

SHOW TABLES;
-- Should show: Parents, Departments, TeacherType, Grades, ExamType, 
--              Library, Teachers, Classrooms, Students, Courses, 
--              StudentClassroom, Enrollments, Attendance, Exams, 
--              ExamResults, Assignments, BorrowedBooks, Fees, 
--              flyway_schema_history

DESCRIBE students;  -- View student table structure
SELECT * FROM flyway_schema_history;  -- View migration history
```

### Foreign Key Relationships

The database enforces referential integrity through foreign keys:

```
Parents (1) ────── (N) Students
Departments (1) ────── (N) Teachers
Departments (1) ────── (N) Courses
TeacherType (1) ────── (N) Teachers
Grades (1) ────── (N) Classrooms
Classrooms (1) ────── (N) Students
Classrooms (1) ────── (N) StudentClassroom
Teachers (1) ────── (N) Classrooms
Teachers (1) ────── (N) Courses
Teachers (1) ────── (N) StudentClassroom
Students (1) ────── (N) StudentClassroom
Students (1) ────── (N) Enrollments
Students (1) ────── (N) Attendance
Students (1) ────── (N) ExamResults
Students (1) ────── (N) BorrowedBooks
Students (1) ────── (N) Fees
Courses (1) ────── (N) Enrollments
Courses (1) ────── (N) Assignments
Courses (1) ────── (N) Exams
ExamType (1) ────── (N) Exams
Exams (1) ────── (N) ExamResults
Library (1) ────── (N) BorrowedBooks
```

## 🏃 Running the Application

### Step 1: Create Database

Create the MySQL database before first run:

```bash
mysql -u your_username -p
```

```sql
CREATE DATABASE school_sv_saas_db;
EXIT;
```

### Step 2: Configure Application

Update database credentials in `src/main/resources/application.yml` with your MySQL username and password.

Update JWT secret key in `src/main/resources/application.properties` (generate a secure key for production).

### Step 3: Build the Project

```bash
mvn clean install
```

This will:
- Download all dependencies
- Compile source code
- Generate MapStruct implementations
- Create JAR file in `target/` directory

### Step 4: Run the Application

**Option 1: Using Maven**
```bash
mvn spring-boot:run
```

**Option 2: Using Java JAR**
```bash
java -jar target/school-sv-1.0-SNAPSHOT.jar
```

**Option 3: Using IDE**
- Run the `Main.java` class directly from your IDE

### Verify Application Started

You should see output indicating:
- Spring Boot banner
- Flyway migrations executed successfully
- Tomcat server started on port 8080
- Application started successfully

Check for logs like:
```
Flyway Community Edition 11.20.2
Successfully validated 1 migration
Creating Schema History table
Successfully applied 1 migration
Tomcat started on port 8080
Started Main in X.XXX seconds
```

### Default Configuration

- **Server Port**: 8080
- **Context Path**: `/`
- **Database**: MySQL on localhost:3306
- **JWT Token Expiration**: 10 hours

### Environment-Specific Configuration

For different environments, use Spring profiles:

```bash
# Development
mvn spring-boot:run -Dspring-boot.run.profiles=dev

# Production
java -jar target/school-sv-1.0-SNAPSHOT.jar --spring.profiles.active=prod
```

## 🔌 API Implementation Status

### Current Status

The project currently has the **authentication and security infrastructure** in place but **REST API endpoints are not yet implemented**.

**What's Ready:**
- ✅ Security filter chain with JWT authentication
- ✅ User authentication mechanism
- ✅ Database schema with 15+ tables
- ✅ DTOs for all major entities
- ✅ Exception handling infrastructure
- ✅ OpenAPI/Swagger configuration

**What Needs Implementation:**
- ⏳ REST Controllers for exposing endpoints
- ⏳ Service layer with business logic
- ⏳ Repository implementations for all entities
- ⏳ Entity models for all database tables

### Planned API Endpoints

Once controllers are implemented, the following endpoints will be available:

#### Authentication (Foundation Ready)
- `POST /auth/register` - User registration
- `POST /auth/login` - User authentication and token generation

#### Student Management (Pending Implementation)
- `POST /api/students` - Create student
- `GET /api/students` - Get all students
- `GET /api/students/{id}` - Get student by ID
- `PUT /api/students/{id}` - Update student
- `DELETE /api/students/{id}` - Delete student

#### Teacher Management (Pending Implementation)
- `POST /api/teachers` - Create teacher
- `GET /api/teachers` - Get all teachers
- `GET /api/teachers/{id}` - Get teacher by ID
- `PUT /api/teachers/{id}` - Update teacher
- `DELETE /api/teachers/{id}` - Delete teacher

#### Course Management (Pending Implementation)
- `POST /api/courses` - Create course
- `GET /api/courses` - Get all courses
- Course enrollment and assignment APIs

#### Other Planned APIs
- Classroom management
- Attendance tracking
- Exam and results management
- Library management
- Fee management
- Department management

### Testing the Authentication

Once you implement authentication endpoints, test with:

```bash
# Register a user
curl -X POST http://localhost:8080/auth/register \
  -H "Content-Type: application/json" \
  -d '{"username":"testuser","password":"password123","role":"USER"}'

# Login and get token
curl -X POST http://localhost:8080/auth/login \
  -H "Content-Type: application/json" \
  -d '{"username":"testuser","password":"password123"}'
```

The response will include a JWT token that can be used for authenticated requests.

## 🗄️ Database Schema

The database schema is managed by Flyway migration: `V1__schoold_sv.sql`. Below is the complete structure of all tables.

### Tables Overview

---

#### 1. Parents
Stores parent/guardian information for students.

| Column | Type | Constraints | Description |
|--------|------|-------------|-------------|
| ParentID | INT | PRIMARY KEY, AUTO_INCREMENT | Unique parent identifier |
| FirstName | VARCHAR(50) | NOT NULL | Parent's first name |
| LastName | VARCHAR(50) | NOT NULL | Parent's last name |
| PhoneNumber | VARCHAR(20) | - | Contact phone number |
| Email | VARCHAR(100) | UNIQUE | Email address |

---

#### 2. Departments
Academic departments within the institution.

| Column | Type | Constraints | Description |
|--------|------|-------------|-------------|
| DepartmentID | INT | PRIMARY KEY, AUTO_INCREMENT | Unique department identifier |
| DepartmentName | VARCHAR(100) | NOT NULL | Department name |

---

#### 3. TeacherType
Types of teacher employment (Full-time, Part-time, etc.).

| Column | Type | Constraints | Description |
|--------|------|-------------|-------------|
| TeacherTypeID | INT | PRIMARY KEY, AUTO_INCREMENT | Unique type identifier |
| TypeName | VARCHAR(50) | NOT NULL | Type name (e.g., Full-time, Part-time) |

---

#### 4. Grades
Grade/year levels in the educational system.

| Column | Type | Constraints | Description |
|--------|------|-------------|-------------|
| GradeID | INT | PRIMARY KEY, AUTO_INCREMENT | Unique grade identifier |
| GradeName | VARCHAR(50) | NOT NULL | Grade name (e.g., Grade 10, 10th Grade) |

---

#### 5. ExamType
Types of examinations (Midterm, Final, Quiz, etc.).

| Column | Type | Constraints | Description |
|--------|------|-------------|-------------|
| ExamTypeID | INT | PRIMARY KEY, AUTO_INCREMENT | Unique exam type identifier |
| TypeName | VARCHAR(50) | NOT NULL | Type name (e.g., Midterm, Final) |

---

#### 6. Library
Library book catalog.

| Column | Type | Constraints | Description |
|--------|------|-------------|-------------|
| LibraryID | INT | PRIMARY KEY, AUTO_INCREMENT | Unique book identifier |
| BookTitle | VARCHAR(255) | NOT NULL | Book title |
| Author | VARCHAR(255) | - | Author name |
| ISBN | VARCHAR(20) | UNIQUE | ISBN number |
| Quantity | INT | DEFAULT 1 | Number of copies available |

---

#### 7. Teachers
Comprehensive teacher information and assignments.

| Column | Type | Constraints | Description |
|--------|------|-------------|-------------|
| TeacherID | INT | PRIMARY KEY, AUTO_INCREMENT | Unique teacher identifier |
| TeacherFirstName | VARCHAR(50) | NOT NULL | Teacher's first name |
| TeacherLastName | VARCHAR(50) | NOT NULL | Teacher's last name |
| TeacherDateOfBirth | DATE | - | Date of birth |
| TeacherGender | VARCHAR(10) | - | Gender |
| TeacherAddress | TEXT | - | Residential address |
| TeacherPhoneNumber | VARCHAR(20) | - | Contact number |
| TeacherEmail | VARCHAR(100) | UNIQUE | Email address |
| DepartmentID | INT | FOREIGN KEY | Reference to Departments table |
| TeacherTypeID | INT | FOREIGN KEY | Reference to TeacherType table |

**Foreign Keys:**
- `DepartmentID` → `Departments(DepartmentID)`
- `TeacherTypeID` → `TeacherType(TeacherTypeID)`

---

#### 8. Classrooms
Classroom organization and teacher assignments.

| Column | Type | Constraints | Description |
|--------|------|-------------|-------------|
| ClassroomID | INT | PRIMARY KEY, AUTO_INCREMENT | Unique classroom identifier |
| ClassroomName | VARCHAR(100) | NOT NULL | Classroom name |
| GradeID | INT | FOREIGN KEY | Reference to Grades table |
| TeacherID | INT | FOREIGN KEY | Assigned teacher (class teacher) |

**Foreign Keys:**
- `GradeID` → `Grades(GradeID)`
- `TeacherID` → `Teachers(TeacherID)`

---

#### 9. Students
Complete student records and enrollment information.

| Column | Type | Constraints | Description |
|--------|------|-------------|-------------|
| StudentID | INT | PRIMARY KEY, AUTO_INCREMENT | Unique student identifier |
| StudentFirstName | VARCHAR(50) | NOT NULL | Student's first name |
| StudentLastName | VARCHAR(50) | NOT NULL | Student's last name |
| StudentDateOfBirth | DATE | - | Date of birth |
| StudentGender | VARCHAR(10) | - | Gender (MALE, FEMALE, OTHER) |
| StudentAddress | TEXT | - | Residential address |
| StudentPhoneNumber | VARCHAR(20) | - | Contact number |
| StudentEmail | VARCHAR(100) | UNIQUE | Email address |
| ParentID | INT | FOREIGN KEY | Reference to Parents table |
| ClassroomID | INT | FOREIGN KEY | Assigned classroom |

**Foreign Keys:**
- `ParentID` → `Parents(ParentID)`
- `ClassroomID` → `Classrooms(ClassroomID)`

---

#### 10. Courses
Course catalog and teacher assignments.

| Column | Type | Constraints | Description |
|--------|------|-------------|-------------|
| CourseID | INT | PRIMARY KEY, AUTO_INCREMENT | Unique course identifier |
| CourseName | VARCHAR(100) | NOT NULL | Course name |
| Description | TEXT | - | Course description |
| TeacherID | INT | FOREIGN KEY | Assigned teacher |
| DepartmentID | INT | FOREIGN KEY | Department offering the course |

**Foreign Keys:**
- `TeacherID` → `Teachers(TeacherID)`
- `DepartmentID` → `Departments(DepartmentID)`

---

#### 11. StudentClassroom
Many-to-many relationship between students and classrooms with enrollment tracking.

| Column | Type | Constraints | Description |
|--------|------|-------------|-------------|
| StudentClassroomID | INT | PRIMARY KEY, AUTO_INCREMENT | Unique record identifier |
| StudentID | INT | FOREIGN KEY | Reference to Students table |
| ClassroomID | INT | FOREIGN KEY | Reference to Classrooms table |
| TeacherID | INT | FOREIGN KEY | Reference to Teachers table |
| EnrollmentDate | DATE | DEFAULT CURRENT_DATE | Date of enrollment |

**Foreign Keys:**
- `StudentID` → `Students(StudentID)`
- `ClassroomID` → `Classrooms(ClassroomID)`
- `TeacherID` → `Teachers(TeacherID)`

---

#### 12. Enrollments
Student course enrollments.

| Column | Type | Constraints | Description |
|--------|------|-------------|-------------|
| EnrollmentID | INT | PRIMARY KEY, AUTO_INCREMENT | Unique enrollment identifier |
| StudentID | INT | FOREIGN KEY | Reference to Students table |
| CourseID | INT | FOREIGN KEY | Reference to Courses table |
| EnrollmentDate | DATE | DEFAULT CURRENT_DATE | Date of enrollment |

**Foreign Keys:**
- `StudentID` → `Students(StudentID)`
- `CourseID` → `Courses(CourseID)`

---

#### 13. Attendance
Daily student attendance tracking.

| Column | Type | Constraints | Description |
|--------|------|-------------|-------------|
| AttendanceID | INT | PRIMARY KEY, AUTO_INCREMENT | Unique attendance record |
| StudentID | INT | FOREIGN KEY | Reference to Students table |
| ClassroomID | INT | FOREIGN KEY | Reference to Classrooms table |
| AttendanceDate | DATE | DEFAULT CURRENT_DATE | Date of attendance |
| Status | VARCHAR(20) | NOT NULL | Status (Present, Absent) |

**Foreign Keys:**
- `StudentID` → `Students(StudentID)`
- `ClassroomID` → `Classrooms(ClassroomID)`

---

#### 14. Exams
Examination records and scheduling.

| Column | Type | Constraints | Description |
|--------|------|-------------|-------------|
| ExamID | INT | PRIMARY KEY, AUTO_INCREMENT | Unique exam identifier |
| ExamName | VARCHAR(100) | - | Exam name |
| CourseID | INT | FOREIGN KEY | Reference to Courses table |
| ExamTypeID | INT | FOREIGN KEY | Reference to ExamType table |
| ExamDate | DATE | - | Scheduled exam date |

**Foreign Keys:**
- `CourseID` → `Courses(CourseID)`
- `ExamTypeID` → `ExamType(ExamTypeID)`

---

#### 15. ExamResults
Student exam scores and results.

| Column | Type | Constraints | Description |
|--------|------|-------------|-------------|
| ExamResultID | INT | PRIMARY KEY, AUTO_INCREMENT | Unique result identifier |
| StudentID | INT | FOREIGN KEY | Reference to Students table |
| ExamID | INT | FOREIGN KEY | Reference to Exams table |
| Score | DECIMAL(5, 2) | - | Exam score |

**Foreign Keys:**
- `StudentID` → `Students(StudentID)`
- `ExamID` → `Exams(ExamID)`

---

#### 16. Assignments
Course assignments and homework.

| Column | Type | Constraints | Description |
|--------|------|-------------|-------------|
| AssignmentID | INT | PRIMARY KEY, AUTO_INCREMENT | Unique assignment identifier |
| AssignmentName | VARCHAR(100) | - | Assignment name |
| CourseID | INT | FOREIGN KEY | Reference to Courses table |
| DueDate | DATE | - | Assignment due date |

**Foreign Keys:**
- `CourseID` → `Courses(CourseID)`

---

#### 17. BorrowedBooks
Library book borrowing records.

| Column | Type | Constraints | Description |
|--------|------|-------------|-------------|
| BorrowID | INT | PRIMARY KEY, AUTO_INCREMENT | Unique borrow record |
| StudentID | INT | FOREIGN KEY | Reference to Students table |
| LibraryID | INT | FOREIGN KEY | Reference to Library table |
| BorrowDate | DATE | DEFAULT CURRENT_DATE | Date borrowed |
| ReturnDate | DATE | - | Date returned (null if not returned) |

**Foreign Keys:**
- `StudentID` → `Students(StudentID)`
- `LibraryID` → `Library(LibraryID)`

---

#### 18. Fees
Student fee management and payment tracking.

| Column | Type | Constraints | Description |
|--------|------|-------------|-------------|
| FeeID | INT | PRIMARY KEY, AUTO_INCREMENT | Unique fee record |
| StudentID | INT | FOREIGN KEY | Reference to Students table |
| Amount | DECIMAL(10, 2) | - | Fee amount |
| DueDate | DATE | - | Payment due date |
| PaidDate | DATE | - | Date paid (null if unpaid) |

**Foreign Keys:**
- `StudentID` → `Students(StudentID)`

---

### Entity Relationships Diagram

```
                                ┌─────────────┐
                                │  Parents    │
                                └──────┬──────┘
                                       │
                                       │ 1:N
                                       ↓
┌─────────────┐    1:N    ┌──────────────────┐    N:1    ┌─────────────┐
│ Departments │◄──────────│    Teachers      │──────────►│ TeacherType │
└──────┬──────┘            └────────┬─────────┘            └─────────────┘
       │                            │
       │ 1:N                        │ 1:N
       ↓                            ↓
┌─────────────┐            ┌─────────────────┐
│   Courses   │            │   Classrooms    │◄────────┐
└──────┬──────┘            └────────┬────────┘         │
       │                            │                   │ N:1
       │ 1:N                        │ 1:N               │
       ↓                            ↓               ┌───┴────┐
┌─────────────┐            ┌─────────────────┐     │ Grades │
│ Assignments │            │    Students     │     └────────┘
└─────────────┘            └────────┬────────┘
                                    │
              ┌─────────────────────┼─────────────────────┐
              │ 1:N                 │ 1:N                 │ 1:N
              ↓                     ↓                     ↓
      ┌─────────────┐      ┌──────────────┐    ┌────────────────┐
      │ Enrollments │      │  Attendance  │    │ BorrowedBooks  │
      └──────┬──────┘      └──────────────┘    └────────┬───────┘
             │                                           │ N:1
             │ N:1                                       ↓
             ↓                                   ┌───────────────┐
      ┌─────────────┐                           │    Library    │
      │   Courses   │                           └───────────────┘
      └──────┬──────┘
             │ 1:N
             ↓
      ┌─────────────┐    1:N    ┌─────────────┐    N:1    ┌──────────┐
      │    Exams    │◄──────────│ ExamResults │──────────►│ Students │
      └──────┬──────┘            └─────────────┘            └──────────┘
             │ N:1
             ↓
      ┌─────────────┐
      │  ExamType   │
      └─────────────┘

      ┌─────────────┐    N:1    ┌──────────────────┐
      │   Fees      │──────────►│    Students      │
      └─────────────┘            └──────────────────┘

      ┌──────────────────┐    N:1    ┌──────────────────┐
      │ StudentClassroom │──────────►│    Students      │
      └──────────────────┘            └──────────────────┘
```

### Key Relationships Summary

| Parent Table | Child Table | Relationship | Description |
|--------------|-------------|--------------|-------------|
| Parents | Students | 1:N | One parent can have multiple students |
| Departments | Teachers | 1:N | One department has multiple teachers |
| Departments | Courses | 1:N | One department offers multiple courses |
| TeacherType | Teachers | 1:N | One type categorizes multiple teachers |
| Grades | Classrooms | 1:N | One grade has multiple classrooms |
| Teachers | Classrooms | 1:N | One teacher manages multiple classrooms |
| Teachers | Courses | 1:N | One teacher teaches multiple courses |
| Classrooms | Students | 1:N | One classroom has multiple students |
| Students | Enrollments | 1:N | One student enrolls in multiple courses |
| Students | Attendance | 1:N | One student has multiple attendance records |
| Students | ExamResults | 1:N | One student has multiple exam results |
| Students | BorrowedBooks | 1:N | One student can borrow multiple books |
| Students | Fees | 1:N | One student has multiple fee records |
| Courses | Enrollments | 1:N | One course has multiple enrollments |
| Courses | Assignments | 1:N | One course has multiple assignments |
| Courses | Exams | 1:N | One course has multiple exams |
| ExamType | Exams | 1:N | One exam type categorizes multiple exams |
| Exams | ExamResults | 1:N | One exam has multiple student results |
| Library | BorrowedBooks | 1:N | One book can be borrowed multiple times |

### Data Integrity Features

- **Foreign Key Constraints**: Ensure referential integrity across all relationships
- **Unique Constraints**: Prevent duplicate emails and ISBN numbers
- **Default Values**: Auto-populate dates with `CURRENT_DATE`
- **Auto Increment**: Automatic ID generation for all primary keys
- **Cascading**: Delete operations cascade where appropriate (not explicitly defined, needs implementation)

## 🔐 Authentication & Security

The application implements JWT (JSON Web Token) based authentication with Spring Security 4.0.1.

### Security Architecture

```
┌─────────────────────────────────────────────────────────┐
│                  HTTP Request                           │
│            (with Authorization: Bearer <token>)         │
└─────────────────────────┬───────────────────────────────┘
                          │
                          ↓
        ┌─────────────────────────────────────┐
        │   JwtAuthenticationFilter           │
        │  - Extract token from header        │
        │  - Validate JWT signature           │
        │  - Extract username from token      │
        └─────────────────┬───────────────────┘
                          │
                          ↓
        ┌─────────────────────────────────────┐
        │   UserDetailsService                │
        │  - Load user from database          │
        │  - Create UserDetails object        │
        └─────────────────┬───────────────────┘
                          │
                          ↓
        ┌─────────────────────────────────────┐
        │   JwtService                        │
        │  - Verify token validity            │
        │  - Check token expiration           │
        └─────────────────┬───────────────────┘
                          │
                          ↓
        ┌─────────────────────────────────────┐
        │   SecurityContext                   │
        │  - Set Authentication object        │
        │  - Grant authorities/roles          │
        └─────────────────┬───────────────────┘
                          │
                          ↓
        ┌─────────────────────────────────────┐
        │   Controller / Service Layer        │
        │  - Process authenticated request    │
        └─────────────────────────────────────┘
```

### Authentication Flow

**Note:** Authentication endpoints (register/login) need to be implemented. The infrastructure is ready.

1. **User Registration** (To be implemented)
   - Client sends username, password, and role
   - Password encrypted with BCrypt
   - User saved to `users` table
   - JWT token generated and returned

2. **User Login** (To be implemented)
   - Client sends credentials
   - Spring Security validates against database
   - If valid, JWT token generated with 10-hour expiration
   - Token returned to client

3. **Authenticated Requests**
   - Client includes token in header: `Authorization: Bearer <token>`
   - `JwtAuthenticationFilter` intercepts request
   - Token extracted and validated
   - User details loaded from database
   - Authentication object set in SecurityContext
   - Request proceeds to controller

4. **Authorization**
   - Security configuration enforces role-based access
   - Unauthorized requests return 403 Forbidden
   - Unauthenticated requests return 401 Unauthorized

### Security Components

#### 1. JwtAuthenticationFilter
**Location**: `edu.icet.auth.JwtAuthenticationFilter`

**Responsibilities:**
- Extends `OncePerRequestFilter` to intercept every HTTP request
- Extracts JWT token from `Authorization` header
- Validates token format (must start with "Bearer ")
- Extracts username from token
- Loads user details from database
- Validates token against user
- Sets authentication in SecurityContext
- Allows request to proceed through filter chain

**Key Methods:**
- `doFilterInternal()` - Main filtering logic

---

#### 2. JwtService
**Location**: `edu.icet.util.JwtService`

**Responsibilities:**
- Generate JWT tokens with user claims
- Sign tokens with secret key (HS256 algorithm)
- Extract username from token
- Extract all claims from token
- Validate token signatures
- Check token expiration
- Use secret key from `application.properties`

**Key Methods:**
- `generateToken(String username)` - Create new JWT token
- `extractUsername(String token)` - Get username from token
- `isTokenValid(String token, UserDetails userDetails)` - Validate token
- `extractAllClaims(String token)` - Parse token claims

**Token Structure:**
- **Header**: Algorithm (HS256) and token type (JWT)
- **Payload**: Subject (username), issued at, expiration time
- **Signature**: HMAC SHA256 with secret key
- **Expiration**: 10 hours from issue time

---

#### 3. ApplicationConfig
**Location**: `edu.icet.security.ApplicationConfig`

**Responsibilities:**
- Configure `UserDetailsService` to load users from database
- Set up `BCryptPasswordEncoder` for password hashing
- Configure `AuthenticationProvider` with DAO authentication
- Provide `AuthenticationManager` bean

**Beans Configured:**
- `userDetailsService()` - Loads user by username using `UserRepository`
- `passwordEncoder()` - BCrypt encoder with default strength
- `authenticationProvider()` - DAO authentication with user details and password encoder
- `authenticationManager()` - Spring Security authentication manager

---

#### 4. Config (Security Filter Chain)
**Location**: `edu.icet.security.Config`

**Responsibilities:**
- Define HTTP security rules
- Configure CSRF protection (disabled for API)
- Set up authorization rules
- Configure session management (stateless)
- Register JWT filter in filter chain

**Access Control Rules:**

| Endpoint Pattern | Access Level | Required Roles |
|------------------|--------------|----------------|
| `/auth/**` | Public | None |
| `/school/**` | Protected | ADMIN |
| `/student/**` | Public | None |
| `/teacher/**` | Protected | ADMIN |
| `/user/**` | Public | None |
| All others | Protected | Any authenticated user |

**Security Features:**
- **CSRF Disabled**: Suitable for stateless API
- **Stateless Sessions**: No server-side session storage
- **JWT Filter**: Executes before `UsernamePasswordAuthenticationFilter`
- **Role-based Authorization**: `hasRole()` checks

---

#### 5. UserRepository
**Location**: `edu.icet.repository.UserRepository`

**Implementation:**
- Uses Spring's `JdbcTemplate` for direct SQL queries
- Method: `findByUsername(String username)` - Retrieves user for authentication
- Returns `User` entity mapped from database row

---

### Password Security

- **Hashing Algorithm**: BCrypt with default cost factor (10)
- **Salt**: Automatically generated per password
- **One-way**: Passwords cannot be decrypted, only verified
- **Secure**: Resistant to rainbow table attacks

### Token Security

- **Signing Algorithm**: HMAC SHA256 (HS256)
- **Secret Key**: 256-bit minimum (configured in application.properties)
- **Token Format**: `xxxxx.yyyyy.zzzzz` (header.payload.signature)
- **Expiration**: Tokens expire after 10 hours
- **Stateless**: No server-side token storage

### Role-Based Access Control (RBAC)

The system supports role-based authorization:

**Defined Roles:**
- `ADMIN` - Full system access, can manage schools and teachers
- `TEACHER` - (To be defined in implementation)
- `USER` - Basic user access

**Implementation:**
- Roles stored in `users` table
- Prefixed with "ROLE_" in Spring Security (e.g., "ROLE_ADMIN")
- Checked via `hasRole()` in security configuration

### Security Best Practices Implemented

✅ **Password Encryption**: BCrypt hashing, never plain text  
✅ **JWT Tokens**: Secure token-based authentication  
✅ **Stateless Architecture**: No session management  
✅ **Filter Chain**: Request filtering before reaching controllers  
✅ **Exception Handling**: Global exception handler for security errors  
✅ **CSRF Protection**: Disabled for API (enabled for web applications)  

### Security Best Practices To Implement

⏳ **Environment Variables**: Move secrets to environment variables  
⏳ **HTTPS**: Use TLS/SSL in production  
⏳ **Rate Limiting**: Prevent brute force attacks  
⏳ **Refresh Tokens**: Implement token refresh mechanism  
⏳ **Token Blacklist**: Track revoked tokens  
⏳ **Account Lockout**: Lock accounts after failed login attempts  
⏳ **Password Policy**: Enforce strong password requirements  
⏳ **Audit Logging**: Log authentication events  

### Using Authentication (Once Implemented)

**Example 1: Register User**
```bash
curl -X POST http://localhost:8080/auth/register \
  -H "Content-Type: application/json" \
  -d '{
    "username": "admin",
    "password": "SecurePass123!",
    "role": "ADMIN"
  }'
```

**Example 2: Login**
```bash
curl -X POST http://localhost:8080/auth/login \
  -H "Content-Type: application/json" \
  -d '{
    "username": "admin",
    "password": "SecurePass123!"
  }'
```

**Response:**
```json
{
  "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiJhZG1pbiIsImlhdCI6MTY..."
}
```

**Example 3: Authenticated Request**
```bash
curl -X GET http://localhost:8080/api/students \
  -H "Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9..."
```


## 📚 API Documentation

The project includes OpenAPI/Swagger configuration (`OpenAPIConfig.java`) for interactive API documentation.

### Access Swagger UI

Once REST controllers are implemented and the application is running, access the documentation at:

**Swagger UI**: [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)  
**OpenAPI JSON**: [http://localhost:8080/v3/api-docs](http://localhost:8080/v3/api-docs)

### OpenAPI Configuration

The `OpenAPIConfig` class provides:
- API title: "LMS API" (Learning Management System)
- Version: 1.0
- JWT Bearer authentication support
- Security scheme for testing authenticated endpoints

### Using Swagger UI

Once implemented, Swagger UI will provide:
- Interactive API testing interface
- Automatic request/response examples
- Authentication token input field
- Schema definitions for all DTOs
- Try-it-out functionality for each endpoint

**Note**: Currently, the API documentation will be empty until controllers are implemented.

## 🏗️ Architecture

The application follows a **Layered Architecture** pattern with clear separation of concerns. Currently, the foundation layers are implemented with authentication infrastructure.

### Current Architecture

```
┌─────────────────────────────────────────────────────┐
│              Client (Frontend / API Consumer)        │
└─────────────────────────────────────────────────────┘
                          ↓
┌─────────────────────────────────────────────────────┐
│         Controller Layer (REST Endpoints)            │
│  ⏳ TO BE IMPLEMENTED                                │
│  - Authentication endpoints                          │
│  - Student, Teacher, Course APIs                     │
│  - Request validation & Response formatting          │
└─────────────────────────────────────────────────────┘
                          ↓
┌─────────────────────────────────────────────────────┐
│          Security Layer (Authentication)  ✅         │
│  - JwtAuthenticationFilter                           │
│  - ApplicationConfig, Config                         │
│  - Token validation & User authentication            │
└─────────────────────────────────────────────────────┘
                          ↓
┌─────────────────────────────────────────────────────┐
│          Service Layer (Business Logic)              │
│  ⏳ TO BE IMPLEMENTED                                │
│  - Business rules & validations                      │
│  - Transaction management                            │
│  - DTO ↔ Entity mapping                             │
└─────────────────────────────────────────────────────┘
                          ↓
┌─────────────────────────────────────────────────────┐
│      Repository Layer (Data Access)  ⚠️              │
│  - UserRepository (JdbcTemplate) ✅                  │
│  - Other repositories TO BE IMPLEMENTED              │
│  - Spring Data JPA or JDBC operations                │
└─────────────────────────────────────────────────────┘
                          ↓
┌─────────────────────────────────────────────────────┐
│          Database (MySQL)  ✅                        │
│  - school_sv_saas_db                                 │
│  - Managed by Flyway migrations                      │
│  - 18 tables with foreign key relationships          │
└─────────────────────────────────────────────────────┘
```

### Layer Implementation Status

| Layer | Status | Components |
|-------|--------|------------|
| **Database** | ✅ Complete | 18 tables, Flyway migration |
| **Security** | ✅ Complete | JWT filter, authentication, authorization |
| **Repository** | ⚠️ Partial | UserRepository only |
| **Service** | ❌ Not Started | Need business logic implementation |
| **Controller** | ❌ Not Started | Need REST endpoints |
| **DTO** | ✅ Complete | 18 DTOs defined |
| **Entity** | ⚠️ Partial | User entity only |
| **Exception Handling** | ✅ Complete | Global handler, custom exceptions |

### Layer Responsibilities

#### 1. Controller Layer (Presentation) ⏳ Pending
- **Purpose**: Handle HTTP requests and responses
- **Responsibilities**:
  - Receive and validate HTTP requests
  - Route requests to service layer
  - Transform service responses to HTTP responses
  - Handle CORS and HTTP headers
- **Technologies**: Spring MVC, `@RestController`, `@RequestMapping`
- **To Implement**: AuthController, StudentController, TeacherController, etc.

#### 2. Security Layer ✅ Implemented
- **Purpose**: Authentication and authorization
- **Responsibilities**:
  - Intercept and filter requests
  - Validate JWT tokens
  - Authenticate users against database
  - Enforce role-based access control
- **Technologies**: Spring Security 4.0.1, JWT 0.11.5
- **Components**: 
  - `JwtAuthenticationFilter` - Request interceptor
  - `JwtService` - Token operations
  - `ApplicationConfig` - Security beans
  - `Config` - Filter chain configuration

#### 3. Service Layer (Business Logic) ⏳ Pending
- **Purpose**: Implement business rules and orchestration
- **Responsibilities**:
  - Validate business rules
  - Coordinate repository operations
  - Handle transactions with `@Transactional`
  - Map between DTOs and Entities
  - Implement domain logic
- **Technologies**: Spring Service, `@Service`
- **To Implement**: StudentService, TeacherService, CourseService, etc.

#### 4. Repository Layer (Data Access) ⚠️ Partial
- **Purpose**: Database operations and persistence
- **Responsibilities**:
  - CRUD operations
  - Custom query definitions
  - Data access abstraction
- **Technologies**: 
  - JdbcTemplate (currently used in UserRepository)
  - Spring Data JPA (configured but not used yet)
- **Implemented**: UserRepository with `JdbcTemplate`
- **To Implement**: Repositories for all other entities

#### 5. Entity Layer (Domain Model) ⚠️ Partial
- **Purpose**: Represent database tables as Java objects
- **Responsibilities**:
  - Map to database tables with JPA annotations
  - Define relationships (@OneToMany, @ManyToOne)
  - Validation annotations
- **Technologies**: JPA, Hibernate, Lombok
- **Implemented**: `User` entity
- **To Implement**: Student, Teacher, Course entities, etc.

#### 6. DTO Layer (Data Transfer) ✅ Implemented
- **Purpose**: Transfer data between layers and external clients
- **Responsibilities**:
  - Decouple API contracts from domain model
  - Reduce over-fetching of data
  - Version API independently
  - Provide clean JSON structure
- **Technologies**: Lombok (getters/setters)
- **Implemented**: 18 DTOs for all major entities

### Design Patterns

#### Implemented
✅ **Dependency Injection**: Spring's IoC container  
✅ **Filter Pattern**: JWT authentication filter  
✅ **Builder Pattern**: User entity with `@Builder`  
✅ **DTO Pattern**: 18 DTOs for data transfer  
✅ **Exception Handler Pattern**: Global exception handling  

#### To Implement
⏳ **Repository Pattern**: Spring Data JPA repositories  
⏳ **Service Pattern**: Business logic encapsulation  
⏳ **Factory Pattern**: Object creation  
⏳ **Strategy Pattern**: Different authentication strategies  

### Object Mapping Strategy

The project is configured with two mapping libraries:

#### MapStruct (Compile-time) - Configured
- **Dependency**: mapstruct 1.5.5.Final + mapstruct-processor
- **Advantage**: Type-safe, no reflection, better performance
- **Status**: Configured but not yet used
- **Use case**: Entity → DTO conversions (read operations)

#### ModelMapper (Runtime) - Configured
- **Dependency**: modelmapper 3.1.1
- **Bean**: Configured in `Configurations.java`
- **Advantage**: Flexible, convention-based mapping
- **Status**: Bean ready but not yet used
- **Use case**: DTO → Entity conversions (write operations)

### Transaction Management

- Spring's declarative transaction support ready
- Use `@Transactional` on service methods when implemented
- Automatic rollback on runtime exceptions
- Database connection pooling via HikariCP (Spring Boot default)

### Exception Handling ✅ Implemented

**GlobalExceptionHandler** (`@ControllerAdvice`):
- Handles `ResourceNotFoundException` → 404 HTTP status
- Returns structured error response with `ErrorDetails`
- Centralized exception management

**Custom Exceptions**:
- `ResourceNotFoundException` - For entity not found scenarios
- `ErrorDetails` - Structured error response (timestamp, message, details)

### Configuration Beans ✅ Implemented

**Configurations.java** provides:
- `ModelMapper` bean for object mapping
- `RestTemplate` bean for HTTP client operations

**OpenAPIConfig.java** provides:
- OpenAPI documentation configuration
- JWT bearer authentication scheme
- API metadata (title, version)


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

## 🗺️ Development Roadmap

### Phase 1: Foundation ✅ COMPLETED

- [x] Project setup with Spring Boot 4.0.1 and Java 21
- [x] Maven dependency configuration
- [x] Database schema design (18 tables)
- [x] Flyway migration setup
- [x] JWT authentication infrastructure
- [x] Spring Security configuration
- [x] DTO models for all entities
- [x] User entity with JPA
- [x] Global exception handling
- [x] OpenAPI/Swagger configuration
- [x] Utility beans (ModelMapper, RestTemplate)

### Phase 2: Core Implementation 🚧 IN PROGRESS

#### High Priority - Next Steps
- [ ] **Implement JPA Entities**
  - [ ] Student entity with relationships
  - [ ] Teacher entity with department relations
  - [ ] Classroom entity with grade relations
  - [ ] Course entity with teacher/department relations
  - [ ] All supporting entities (Parents, Departments, etc.)

- [ ] **Implement Repositories**
  - [ ] StudentRepository (Spring Data JPA)
  - [ ] TeacherRepository
  - [ ] ClassroomRepository
  - [ ] CourseRepository
  - [ ] Supporting repositories for all entities
  - [ ] Consider migrating UserRepository to Spring Data JPA

- [ ] **Implement Service Layer**
  - [ ] AuthenticationService (register, login, token management)
  - [ ] StudentService (CRUD operations, business logic)
  - [ ] TeacherService
  - [ ] CourseService
  - [ ] ClassroomService
  - [ ] Transaction management with `@Transactional`

- [ ] **Implement REST Controllers**
  - [ ] AuthenticationController (`/auth/*`)
  - [ ] StudentController (`/api/students/*`)
  - [ ] TeacherController (`/api/teachers/*`)
  - [ ] CourseController (`/api/courses/*`)
  - [ ] ClassroomController (`/api/classrooms/*`)
  - [ ] Input validation with `@Valid`
  - [ ] Proper HTTP status codes and responses

### Phase 3: Enhanced Features 📋 PLANNED

- [ ] **Pagination & Sorting**
  - [ ] Implement `Pageable` in repository methods
  - [ ] Add sorting parameters to GET endpoints
  - [ ] Configure default page sizes

- [ ] **Search & Filtering**
  - [ ] Search students by name, email, classroom
  - [ ] Filter by grade, academic year
  - [ ] Date range queries for attendance, exams
  - [ ] Advanced filtering with Spring Data Specifications

- [ ] **Attendance Management**
  - [ ] Student attendance CRUD APIs
  - [ ] Attendance reports by date range
  - [ ] Attendance percentage calculation
  - [ ] Bulk attendance marking

- [ ] **Exam & Results Management**
  - [ ] Exam scheduling APIs
  - [ ] Result entry and management
  - [ ] Grade calculation
  - [ ] Result reports

- [ ] **Library Management**
  - [ ] Book borrowing and return APIs
  - [ ] Availability checking
  - [ ] Overdue tracking
  - [ ] Fine calculation

- [ ] **Fee Management**
  - [ ] Fee structure definition
  - [ ] Payment recording
  - [ ] Payment history
  - [ ] Outstanding fee reports

### Phase 4: Testing & Quality 🧪 PLANNED

- [ ] **Unit Testing**
  - [ ] Service layer unit tests with Mockito
  - [ ] Repository tests with `@DataJpaTest`
  - [ ] JWT service tests
  - [ ] Target: 80%+ code coverage

- [ ] **Integration Testing**
  - [ ] API integration tests with `@SpringBootTest`
  - [ ] Database integration tests
  - [ ] Security integration tests
  - [ ] Use H2 in-memory database for tests

- [ ] **API Testing**
  - [ ] RestAssured test suite
  - [ ] Postman collection
  - [ ] Authentication flow tests

### Phase 5: Production Readiness 🚀 PLANNED

- [ ] **Enhanced Security**
  - [ ] Refresh token implementation
  - [ ] Token blacklist/revocation
  - [ ] Password policy enforcement
  - [ ] Account lockout after failed attempts
  - [ ] Rate limiting for auth endpoints

- [ ] **Logging & Monitoring**
  - [ ] Structured logging with Logback
  - [ ] Request/response logging
  - [ ] Audit trail for sensitive operations
  - [ ] Performance metrics
  - [ ] Health check endpoints

- [ ] **Data Validation**
  - [ ] Comprehensive bean validation
  - [ ] Custom validators
  - [ ] Business rule validation
  - [ ] Input sanitization

- [ ] **API Improvements**
  - [ ] API versioning (`/api/v1/`)
  - [ ] HATEOAS links
  - [ ] Response compression
  - [ ] Content negotiation (JSON/XML)

- [ ] **Deployment**
  - [ ] Docker containerization with Dockerfile
  - [ ] Docker Compose for local development
  - [ ] Environment-specific configurations
  - [ ] Production deployment guide
  - [ ] CI/CD pipeline setup

### Phase 6: Advanced Features 🌟 FUTURE

- [ ] Multi-tenancy support for SaaS
- [ ] File upload (profile pictures, documents)
- [ ] Email notification system
- [ ] SMS integration
- [ ] Report generation (PDF/Excel)
- [ ] Dashboard analytics
- [ ] Real-time updates with WebSocket
- [ ] Batch processing for bulk operations
- [ ] Caching with Redis
- [ ] Message queue integration
- [ ] OAuth2 social login
- [ ] Two-factor authentication (2FA)

### Contributing

Contributions are welcome! Priority areas:
1. **Phase 2**: Core implementation (entities, repositories, services, controllers)
2. **Phase 3**: Enhanced features (attendance, exams, library)
3. **Phase 4**: Testing and quality assurance

Please follow the existing code structure and conventions when contributing.

## 🔧 Troubleshooting

### Common Issues and Solutions

#### 1. Database Connection Failed

**Error:** `Cannot create PoolableConnectionFactory` or `Communications link failure`

**Solutions:**
- Ensure MySQL server is running:
  ```bash
  sudo systemctl status mysql
  # or
  sudo service mysql status
  
  # Start if not running
  sudo systemctl start mysql
  ```
- Verify database exists:
  ```sql
  mysql -u root -p
  SHOW DATABASES;
  # If school_sv_saas_db doesn't exist, create it:
  CREATE DATABASE school_sv_saas_db;
  ```
- Check credentials in `application.yml` match your MySQL username/password
- Verify MySQL is listening on port 3306:
  ```bash
  sudo netstat -tlnp | grep 3306
  ```
- Check firewall isn't blocking port 3306

---

#### 2. Flyway Migration Errors

**Error:** `FlywayException: Validate failed` or `Migration checksum mismatch`

**Possible Causes:**
- SQL file was modified after initial migration
- Database schema manually altered
- Inconsistent migration history

**Solutions:**

**For Development (Safe to reset):**
```sql
-- Drop and recreate database
DROP DATABASE school_sv_saas_db;
CREATE DATABASE school_sv_saas_db;
```

**For Production (Check history first):**
```sql
-- View migration history
SELECT * FROM flyway_schema_history ORDER BY installed_rank;

-- Repair metadata (use carefully)
mvn flyway:repair
```

**If SQL file is correct but IDE shows errors:**
- This is just IDE highlighting - the SQL is valid for MySQL
- See [SQL_DIALECT_SETUP.md](SQL_DIALECT_SETUP.md) for fixing IDE dialect configuration
- The migration will work correctly despite IDE errors

---

#### 3. SQL Dialect Errors in IntelliJ IDEA

**Error:** Red squiggly lines in `V1__schoold_sv.sql` file

**Cause:** IntelliJ may be using wrong SQL dialect (Oracle instead of MySQL)

**Quick Fix:**
1. Open `src/main/resources/db.migration/V1__schoold_sv.sql`
2. Look at bottom-right corner of editor
3. Click on SQL dialect indicator
4. Select **MySQL**

**Detailed Guide:** See [SQL_DIALECT_SETUP.md](SQL_DIALECT_SETUP.md)

**Note:** If the application runs and migrations succeed, the SQL is correct. IDE errors are false positives.

---

#### 4. JWT Secret Key Error

**Error:** `SignatureException: JWT signature does not match` or `WeakKeyException`

**Solutions:**
- Ensure SECRET_KEY in `application.properties` is at least 256 bits (32 bytes)
- Generate new key using base64-encoded random string
- Key must be same for token generation and validation
- Don't modify SECRET_KEY after tokens are issued (invalidates all tokens)

**Generate secure key:**
```bash
# Using OpenSSL
openssl rand -base64 32

# Or use online generator for development
# Production: Use environment variables
```

---

#### 5. MapStruct Implementations Not Generated

**Error:** Cannot find mapper implementation classes

**Solutions:**
- MapStruct dependencies are configured but mappers aren't created yet
- Once you create mapper interfaces, regenerate:
  ```bash
  mvn clean compile
  ```
- Check `target/generated-sources/annotations` for generated mappers
- Ensure MapStruct processor is in `pom.xml` (it is)

---

#### 6. Port 8080 Already in Use

**Error:** `Port 8080 was already in use`

**Solutions:**

**Option 1: Kill existing process**
```bash
# Find process using port 8080
sudo lsof -i :8080
# or
sudo netstat -tlnp | grep 8080

# Kill the process
sudo kill -9 <PID>
```

**Option 2: Change application port**
Add to `application.yml`:
```yaml
server:
  port: 8081
```

---

#### 7. Lombok Not Working in IDE

**Error:** Cannot find getter/setter methods

**Solutions:**

**IntelliJ IDEA:**
1. Go to **Settings** → **Build, Execution, Deployment** → **Compiler** → **Annotation Processors**
2. Check **Enable annotation processing**
3. Click **Apply** and **OK**
4. Rebuild project: **Build** → **Rebuild Project**

**Eclipse:**
1. Download `lombok.jar` from https://projectlombok.org/download
2. Run: `java -jar lombok.jar`
3. Select Eclipse installation directory
4. Restart Eclipse

**Verify Lombok installation:**
```bash
# Clean and rebuild
mvn clean compile
```

---

#### 8. Maven Build Fails

**Error:** Compilation errors or dependency resolution failures

**Solutions:**
```bash
# Clean Maven cache
mvn clean

# Force update dependencies
mvn clean install -U

# Skip tests if test-related errors
mvn clean install -DskipTests

# Verify Java version (must be 21)
java -version
mvn -version
```

**If dependencies won't download:**
- Check internet connection
- Clear corrupted cache: Delete `~/.m2/repository`
- Try different Maven repository mirror

---

#### 9. Application Starts but No Endpoints Available

**Symptom:** Application starts successfully but API calls return 404

**Reason:** This is expected! REST controllers haven't been implemented yet.

**Current State:**
- ✅ Application starts correctly
- ✅ Security filter chain active
- ✅ Database tables created
- ⏳ API endpoints pending implementation

**What Works:**
- Database connection and Flyway migrations
- Security configuration loaded
- Swagger UI accessible (will be empty until controllers added)

**Next Steps:**
- Implement REST controllers (see Development Roadmap)
- Create service layer
- Implement repositories

---

#### 10. MySQL Access Denied

**Error:** `Access denied for user 'root'@'localhost'`

**Solutions:**
- Verify MySQL username/password in `application.yml`
- Reset MySQL root password if forgotten:
  ```bash
  sudo mysql
  ALTER USER 'root'@'localhost' IDENTIFIED BY 'new_password';
  FLUSH PRIVILEGES;
  EXIT;
  ```
- Check user has permissions on database:
  ```sql
  GRANT ALL PRIVILEGES ON school_sv_saas_db.* TO 'your_user'@'localhost';
  FLUSH PRIVILEGES;
  ```

---

#### 11. Class Not Found Exception

**Error:** `ClassNotFoundException` or `NoClassDefFoundError`

**Solutions:**
- Clean and rebuild:
  ```bash
  mvn clean install
  ```
- Delete `target/` directory and rebuild
- Check all dependencies are resolved:
  ```bash
  mvn dependency:tree
  ```
- Reimport Maven project in IDE

---

### Debugging Tips

#### Enable Debug Logging

Add to `application.yml`:
```yaml
logging:
  level:
    root: INFO
    edu.icet: DEBUG
    org.springframework.security: DEBUG
    org.flywaydb: DEBUG
    org.springframework.jdbc: DEBUG
```

#### Check Database Schema

```sql
-- Connect to database
mysql -u your_username -p school_sv_saas_db

-- List all tables
SHOW TABLES;

-- Check table structure
DESCRIBE Students;
DESCRIBE Teachers;

-- View migration history
SELECT * FROM flyway_schema_history;

-- Check if users table has data
SELECT * FROM users;
```

#### Verify Dependencies

```bash
# List all dependencies
mvn dependency:tree

# Check for conflicts
mvn dependency:analyze
```

#### Test Database Connection Independently

Create a simple test:
```java
@SpringBootTest
class DatabaseConnectionTest {
    @Autowired
    private DataSource dataSource;
    
    @Test
    void testConnection() throws SQLException {
        assertNotNull(dataSource.getConnection());
    }
}
```

---

### Getting Help

If you're still experiencing issues:

1. **Check Logs**: Review complete stack trace in console output
2. **Verify Setup**: Ensure MySQL is running and database exists
3. **Clean Build**: `mvn clean install` often resolves build issues
4. **Check Versions**: Java 21, Maven 3.6+, MySQL 8.0+
5. **Review Configuration**: Double-check `application.yml` and `application.properties`

### Known Limitations

- **No Controllers**: REST endpoints not implemented yet - this is work in progress
- **Single Entity**: Only User entity implemented, others pending
- **UserRepository**: Uses JdbcTemplate instead of Spring Data JPA (consider migrating)
- **No Tests**: Test directory exists but no tests written yet
- **Public Endpoints**: Student and user endpoints are public (consider restricting)

### Success Indicators

✅ **Application Started Successfully If:**
- Spring Boot banner appears
- "Started Main in X seconds" message shown
- No red ERROR messages in console
- Flyway migrations executed successfully
- Tomcat server started on port 8080

✅ **Database Setup Successful If:**
```sql
-- All tables exist
SHOW TABLES;
-- Should show 18 tables + flyway_schema_history

-- Migration recorded
SELECT * FROM flyway_schema_history;
-- Should show V1__schoold_sv.sql with success=1
```

---

## 💡 Development Tips & Best Practices

### Getting Started with Development

1. **Understand the Foundation**
   - Review the [Architecture](#architecture) section
   - Study the existing User entity and UserRepository
   - Understand the security flow with JWT
   - Examine the database schema

2. **Implementation Order**
   - Start with simple entities (Department, Grade, TeacherType)
   - Move to core entities (Student, Teacher)
   - Then relationship entities (Enrollment, StudentClassroom)
   - Finally, operational entities (Attendance, Exams)

3. **Follow Existing Patterns**
   - Mirror the User entity structure
   - Use Lombok annotations consistently
   - Follow the security configuration pattern
   - Use the exception handling approach

### Code Examples for Implementation

#### Example: Creating a Student Entity

```java
package edu.icet.entity;

import edu.icet.enums.Gender;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import java.util.Date;

@Entity
@Table(name = "Students")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "StudentID")
    private Integer id;
    
    @Column(name = "StudentFirstName", nullable = false, length = 50)
    @NotBlank(message = "First name is required")
    private String firstName;
    
    @Column(name = "StudentLastName", nullable = false, length = 50)
    @NotBlank(message = "Last name is required")
    private String lastName;
    
    @Column(name = "StudentDateOfBirth")
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;
    
    @Column(name = "StudentGender", length = 10)
    @Enumerated(EnumType.STRING)
    private Gender gender;
    
    @Column(name = "StudentEmail", unique = true, length = 100)
    @Email(message = "Invalid email format")
    private String email;
    
    // Relationships
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ParentID", referencedColumnName = "ParentID")
    private Parent parent;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ClassroomID", referencedColumnName = "ClassroomID")
    private Classroom classroom;
}
```

#### Example: Spring Data JPA Repository

```java
package edu.icet.repository;

import edu.icet.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    // Derived query methods (Spring Data JPA auto-generates)
    List<Student> findByClassroomId(Integer classroomId);
    List<Student> findByLastNameContainingIgnoreCase(String lastName);
    Optional<Student> findByEmail(String email);
    boolean existsByEmail(String email);
    
    // Custom JPQL query
    @Query("SELECT s FROM Student s WHERE s.classroom.grade.id = :gradeId")
    List<Student> findStudentsByGrade(@Param("gradeId") Integer gradeId);
    
    // Native SQL query
    @Query(value = "SELECT * FROM Students WHERE StudentGender = :gender", nativeQuery = true)
    List<Student> findByGenderNative(@Param("gender") String gender);
}
```

#### Example: Service Implementation

```java
package edu.icet.service.impl;

import edu.icet.dto.Students;
import edu.icet.entity.Student;
import edu.icet.exception.ResourceNotFoundException;
import edu.icet.repository.StudentRepository;
import edu.icet.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    private final ModelMapper modelMapper;
    
    @Override
    public Students createStudent(Students studentDto) {
        // Check if email already exists
        if (studentRepository.existsByEmail(studentDto.getEmail())) {
            throw new IllegalArgumentException("Email already registered");
        }
        
        // Map DTO to Entity
        Student student = modelMapper.map(studentDto, Student.class);
        
        // Save to database
        Student saved = studentRepository.save(student);
        
        // Map Entity back to DTO
        return modelMapper.map(saved, Students.class);
    }
    
    @Override
    @Transactional(readOnly = true)
    public Students getStudentById(Integer id) {
        Student student = studentRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Student not found with id: " + id));
        return modelMapper.map(student, Students.class);
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<Students> getAllStudents() {
        return studentRepository.findAll().stream()
            .map(student -> modelMapper.map(student, Students.class))
            .collect(Collectors.toList());
    }
    
    @Override
    public Students updateStudent(Integer id, Students studentDto) {
        Student existing = studentRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Student not found with id: " + id));
        
        // Update fields
        existing.setFirstName(studentDto.getFirstName());
        existing.setLastName(studentDto.getLastName());
        existing.setEmail(studentDto.getEmail());
        // ...update other fields...
        
        Student updated = studentRepository.save(existing);
        return modelMapper.map(updated, Students.class);
    }
    
    @Override
    public void deleteStudent(Integer id) {
        if (!studentRepository.existsById(id)) {
            throw new ResourceNotFoundException("Student not found with id: " + id);
        }
        studentRepository.deleteById(id);
    }
}
```

#### Example: REST Controller with Security

```java
package edu.icet.controller;

import edu.icet.dto.Students;
import edu.icet.service.StudentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/students")
@RequiredArgsConstructor
@CrossOrigin
@Tag(name = "Student Management", description = "APIs for managing students")
@SecurityRequirement(name = "bearerAuth")
public class StudentController {
    private final StudentService studentService;
    
    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Create new student", description = "Register a new student in the system")
    public ResponseEntity<Students> createStudent(@Valid @RequestBody Students studentDto) {
        Students created = studentService.createStudent(studentDto);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }
    
    @GetMapping("/{id}")
    @Operation(summary = "Get student by ID")
    public ResponseEntity<Students> getStudent(@PathVariable Integer id) {
        Students student = studentService.getStudentById(id);
        return ResponseEntity.ok(student);
    }
    
    @GetMapping
    @Operation(summary = "Get all students")
    public ResponseEntity<List<Students>> getAllStudents() {
        List<Students> students = studentService.getAllStudents();
        return ResponseEntity.ok(students);
    }
    
    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Update student")
    public ResponseEntity<Students> updateStudent(
            @PathVariable Integer id,
            @Valid @RequestBody Students studentDto) {
        Students updated = studentService.updateStudent(id, studentDto);
        return ResponseEntity.ok(updated);
    }
    
    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Delete student")
    public ResponseEntity<Void> deleteStudent(@PathVariable Integer id) {
        studentService.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }
}
```

### Common Development Tasks

#### Add New Entity
1. Create entity class in `entity/` package
2. Add JPA annotations
3. Define relationships
4. Use Lombok annotations

#### Add New Repository
1. Create interface extending `JpaRepository<Entity, ID>`
2. Add custom query methods
3. Annotate with `@Repository`

#### Add New Service
1. Create service interface
2. Create implementation class
3. Inject repository dependencies
4. Add `@Transactional` for write operations

#### Add New Controller
1. Create controller class
2. Annotate with `@RestController` and `@RequestMapping`
3. Inject service dependency
4. Add endpoint methods with validation
5. Add OpenAPI annotations

### Recommended Development Tools

- **IntelliJ IDEA Ultimate** - Best Spring Boot support
- **Postman** - API testing
- **MySQL Workbench** - Database management
- **Git** - Version control
- **Docker** - Containerization (future)

---

## 🤝 Contributing

Contributions are welcome! This project is in active development and needs help with:

### Priority Areas
1. **REST Controller Implementation** - Create API endpoints
2. **Service Layer Development** - Implement business logic
3. **Repository Implementation** - Complete data access layer
4. **Entity Models** - Create JPA entities for all tables
5. **Testing** - Unit and integration tests
6. **Documentation** - API documentation and code comments

### Contribution Guidelines

1. **Fork the repository**
   ```bash
   git clone <repository-url>
   cd school-sv
   ```

2. **Create a feature branch**
   ```bash
   git checkout -b feature/implement-student-controller
   ```

3. **Make your changes**
   - Follow existing code structure and naming conventions
   - Use Lombok annotations to reduce boilerplate
   - Add appropriate validation annotations
   - Write unit tests for your code
   - Update documentation if needed

4. **Test your changes**
   ```bash
   mvn clean test
   mvn spring-boot:run
   ```

5. **Commit with clear messages**
   ```bash
   git add .
   git commit -m "feat: implement student CRUD controller"
   ```

6. **Push to your fork**
   ```bash
   git push origin feature/implement-student-controller
   ```

7. **Open a Pull Request**
   - Provide clear description of changes
   - Reference any related issues
   - Include test results

### Code Style Guidelines

- **Java**: Follow Oracle Java conventions
- **Indentation**: 4 spaces (not tabs)
- **Naming**: 
  - Classes: PascalCase
  - Methods/Variables: camelCase
  - Constants: UPPER_SNAKE_CASE
- **Lombok**: Use `@Data`, `@Builder`, `@RequiredArgsConstructor` where appropriate
- **DTOs**: Use getters/setters with Lombok
- **Entities**: Use JPA annotations properly
- **Services**: Interface + Implementation pattern
- **Controllers**: RESTful naming conventions

### Testing Requirements

- Write unit tests for service layer
- Write integration tests for repositories
- Maintain or improve code coverage
- Test security scenarios (authenticated/unauthenticated)

## 👤 Author

**Organization**: Institute of Computer Engineering Technology (ICET)  
**Project**: School Management System Backend  
**Version**: 1.0-SNAPSHOT  
**License**: All rights reserved

## 📞 Support & Contact

For questions, issues, or contributions:

- **Issues**: Create an issue in the repository with detailed description
- **Email**: [contact-email]@example.com
- **Documentation**: Check README.md and SQL_DIALECT_SETUP.md

## 📄 License

This project is proprietary software. All rights reserved.

---

## ⚠️ Important Security Notes

**Before Deployment:**

1. **Change Default Credentials**
   - Replace SECRET_KEY in `application.properties`
   - Update database credentials
   - Use environment variables:
     ```bash
     export SECRET_KEY="your-production-key"
     export DB_PASSWORD="your-db-password"
     ```

2. **Use Environment Variables**
   ```yaml
   spring:
     datasource:
       username: ${DB_USERNAME:root}
       password: ${DB_PASSWORD}
   ```
   
   ```properties
   SECRET_KEY=${JWT_SECRET_KEY}
   ```

3. **Never Commit Secrets**
   - Add `application-local.yml` to `.gitignore`
   - Use `.env` files for local development (add to `.gitignore`)
   - Use secret management services in production (AWS Secrets Manager, Azure Key Vault, etc.)

4. **Enable HTTPS**
   - Configure SSL/TLS certificates
   - Force HTTPS in production
   - Update CORS policies for production domains

5. **Security Checklist**
   - [ ] Change JWT secret key
   - [ ] Update database credentials
   - [ ] Configure environment variables
   - [ ] Enable HTTPS
   - [ ] Review access control rules
   - [ ] Implement rate limiting
   - [ ] Set up logging and monitoring
   - [ ] Regular security audits

---

## 🎯 Project Highlights Summary

### What Makes This Project Special

✨ **Modern Technology Stack**
- Latest Spring Boot 4.0.1 with Java 21
- Cutting-edge security with JWT 0.11.5
- Database version control with Flyway 11.20.2

🔒 **Security First**
- Complete JWT authentication infrastructure
- Role-based access control ready
- BCrypt password encryption
- Stateless architecture for scalability

📊 **Comprehensive Database Design**
- 18 interconnected tables
- Proper foreign key relationships
- Covers all aspects of school management
- Production-ready schema

🏗️ **Clean Architecture**
- Layered architecture pattern
- Clear separation of concerns
- DTO pattern for API flexibility
- Exception handling infrastructure

🚀 **Developer Friendly**
- Lombok reduces boilerplate
- ModelMapper for object mapping
- OpenAPI documentation ready
- Comprehensive README with examples

### Quick Stats

| Metric | Count |
|--------|-------|
| Database Tables | 18 |
| DTO Classes | 18 |
| Entity Classes | 1 (User) - 17 pending |
| Enum Types | 3 |
| Security Filters | 1 (JWT) |
| Configuration Classes | 3 |
| Exception Handlers | 1 (Global) |
| Repositories | 1 (User) - others pending |
| Spring Boot Version | 4.0.1 |
| Java Version | 21 |

### Technology Maturity

| Technology | Version | Status |
|------------|---------|--------|
| Spring Boot | 4.0.1 | Latest stable |
| Java | 21 | LTS version |
| MySQL Connector | 9.3.0 | Latest |
| Spring Security | 4.0.1 | Latest |
| Flyway | 11.20.2 | Latest |
| Lombok | 1.18.42 | Latest |
| JWT | 0.11.5 | Stable |

---

**Last Updated**: February 24, 2026  
**Spring Boot Version**: 4.0.1  
**Java Version**: 21  
**Database**: MySQL with Flyway migrations  
**Status**: Foundation Complete - API Implementation in Progress

---

### 📝 Documentation Files

- **[README.md](README.md)** - This comprehensive project guide
- **[SQL_DIALECT_SETUP.md](SQL_DIALECT_SETUP.md)** - IntelliJ SQL dialect configuration guide
- **[pom.xml](pom.xml)** - Maven dependencies and build configuration

### 🔗 Quick Links

- [Quick Start Guide](#quick-start) - Get running in 5 minutes
- [Configuration Guide](#configuration) - Setup database and JWT
- [Database Schema](#database-schema) - Complete table structure
- [Development Roadmap](#development-roadmap) - What's next
- [Development Tips](#development-tips--best-practices) - Code examples and best practices
- [Troubleshooting](#troubleshooting) - Common issues and solutions

---

💡 **Tip**: This project is a solid foundation. Follow the [Development Roadmap](#development-roadmap) to complete the implementation, starting with creating entities and repositories for core tables like Students, Teachers, and Courses.

---

**Made with ❤️ by ICET - Institute of Computer Engineering Technology**

