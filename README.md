# School Management System - Backend Service (SaaS)

A comprehensive RESTful API backend service for managing educational institutions including schools, students, grades, classes, and hostels with JWT-based authentication and role-based access control, built with Spring Boot 4.0.1.

## 📋 Table of Contents
- [Overview](#overview)
- [Features](#features)
- [Technology Stack](#technology-stack)
- [Project Structure](#project-structure)
- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [Configuration](#configuration)
- [Database Setup](#database-setup)
- [Running the Application](#running-the-application)
- [API Endpoints](#api-endpoints)
- [Database Schema](#database-schema)
- [Authentication & Security](#authentication--security)
- [API Documentation](#api-documentation)
- [Architecture](#architecture)
- [Troubleshooting](#troubleshooting)

## 🎯 Overview

The School Management System is a **SaaS (Software as a Service)** platform designed to provide a comprehensive backend solution for educational institutions. This RESTful API service enables the management of multiple schools, students, grades, classes, and hostels with a robust security layer. 

Key highlights:
- **Multi-tenancy support** for managing multiple schools
- **JWT-based authentication** with Spring Security 4.0.1
- **Database migration** with Flyway for version-controlled schema management
- **Layered architecture** with clear separation of concerns
- **Interactive API documentation** via Swagger UI/OpenAPI
- **Modern Java 21** with latest Spring Boot 4.0.1

## ✨ Features

### Authentication & Authorization
- User registration and login
- JWT-based authentication with token generation
- Role-based access control (USER, ADMIN)
- Secure password encryption with BCrypt
- Request filtering and validation

### School Management
- Add new schools with comprehensive details
- Retrieve all schools
- Search schools by ID
- Delete schools
- Track school information:
  - Establishment date
  - Classification (Type: PUBLIC/PRIVATE)
  - Contact details (email, phone, website)
  - Vision and mission statements
  - Capacity tracking (students and teachers)
  - Principal information
  - School motto

### Student Management
- Register new students to schools and classes
- Get all students with full details
- Search students by ID
- Delete students
- Manage student information:
  - Personal details (first name, last name, date of birth)
  - Gender (MALE, FEMALE, OTHER)
  - Contact information (phone, email, address)
  - Enrollment date tracking
  - Class and school association
  - Hostel assignment (optional)

### Grade Management
- Create new grades
- Get all grades
- Search grades by ID
- Delete grades
- Track grade status (active/inactive)
- Hierarchical organization structure

### Class Management
- Create new classes
- Get all classes
- Search classes by ID
- Delete classes
- Associate classes with grades
- Academic year tracking
- Class status management (active/inactive)

### Hostel Management
- Hostel creation and management
- Gender-specific hostel assignment
- Capacity tracking
- Warden information management
- Contact details for hostels
- Association with schools

### Data Relationships & Integrity
- **One-to-Many**: School → Students, Grade → Classes, Class → Students, School → Hostels
- **Many-to-One**: Student → School, Student → Class, Class → Grade, Student → Hostel
- Foreign key constraints for data integrity
- Cascading operations where appropriate

## 🛠 Technology Stack

### Core Framework
- **Java**: 21 (Latest LTS)
- **Spring Boot**: 4.0.1
- **Maven**: Build and dependency management

### Spring Ecosystem
- **Spring Data JPA**: Data persistence and ORM
- **Spring Security**: 4.0.1 - Authentication and authorization
- **Spring Boot Starter Web**: 4.0.1 - RESTful API development

### Database & Migration
- **MySQL Connector**: 9.3.0 - Database connectivity
- **Flyway**: 11.20.2 - Database version control and migration
  - Flyway Core
  - Flyway MySQL

### Security & Authentication
- **JWT (JSON Web Tokens)**: 0.11.5 - Token-based authentication
  - `jjwt-api` - JWT API
  - `jjwt-impl` - JWT Implementation
  - `jjwt-jackson` - Jackson integration for JWT

### Object Mapping
- **Lombok**: 1.18.42 - Reduce boilerplate code (getters, setters, builders)
- **MapStruct**: 1.5.5.Final - Compile-time DTO ↔ Entity mapping
- **ModelMapper**: 3.1.1 - Runtime object mapping

### API Documentation
- **SpringDoc OpenAPI**: 2.8.13 - OpenAPI 3.0 specification
  - Swagger UI integration
  - Interactive API documentation

### Build Tool
- **Maven**: Dependency management and build automation

## 📁 Project Structure

```
school-sv/
├── pom.xml                                            # Maven configuration
├── README.md                                          # Project documentation
├── src/
│   ├── main/
│   │   ├── java/edu/icet/
│   │   │   ├── Main.java                             # Application entry point
│   │   │   ├── auth/
│   │   │   │   └── JwtAuthenticationFilter.java      # JWT request filter
│   │   │   ├── configuration/
│   │   │   │   └── Configurations.java               # Application configurations
│   │   │   ├── controller/
│   │   │   │   ├── AuthenticationController.java    # Authentication endpoints
│   │   │   │   ├── ClassesController.java           # Class REST endpoints
│   │   │   │   ├── GradeController.java             # Grade REST endpoints
│   │   │   │   ├── SchoolController.java            # School REST endpoints
│   │   │   │   └── StudentController.java           # Student REST endpoints
│   │   │   ├── dto/
│   │   │   │   ├── AcademicYearDto.java             # Academic year DTO
│   │   │   │   ├── AuthenticationResponse.java      # JWT response DTO
│   │   │   │   ├── ClassesDto.java                  # Class data transfer object
│   │   │   │   ├── ClassSubjectsDto.java            # Class subjects DTO
│   │   │   │   ├── EmployeeDto.java                 # Employee DTO
│   │   │   │   ├── EvaluatinoDto.java               # Evaluation DTO
│   │   │   │   ├── ExamDto.java                     # Exam DTO
│   │   │   │   ├── GradeDto.java                    # Grade data transfer object
│   │   │   │   ├── HostelDto.java                   # Hostel DTO
│   │   │   │   ├── LeaveDto.java                    # Leave DTO
│   │   │   │   ├── MarksDto.java                    # Marks DTO
│   │   │   │   ├── MediumDto.java                   # Medium DTO
│   │   │   │   ├── PaymentDto.java                  # Payment DTO
│   │   │   │   ├── PrincipleDto.java                # Principal DTO
│   │   │   │   ├── SchoolDto.java                   # School data transfer object
│   │   │   │   ├── SocietyDto.java                  # Society DTO
│   │   │   │   ├── StaffDto.java                    # Staff DTO
│   │   │   │   ├── StudentAttendance.java           # Student attendance DTO
│   │   │   │   ├── StudentDto.java                  # Student data transfer object
│   │   │   │   ├── SubjectDto.java                  # Subject DTO
│   │   │   │   ├── TeacherAttendanceDto.java        # Teacher attendance DTO
│   │   │   │   ├── TeacherDto.java                  # Teacher DTO
│   │   │   │   ├── TeacherScheduleDto.java          # Teacher schedule DTO
│   │   │   │   ├── TeacherTrainingDto.java          # Teacher training DTO
│   │   │   │   ├── TimetableDto.java                # Timetable DTO
│   │   │   │   ├── TypeDto.java                     # Type DTO
│   │   │   │   └── UserDto.java                     # User data transfer object
│   │   │   ├── entity/
│   │   │   │   └── User.java                        # User JPA entity
│   │   │   ├── enums/
│   │   │   │   ├── Gender.java                      # Gender enumeration
│   │   │   │   └── Type.java                        # Type enumeration
│   │   │   ├── repository/
│   │   │   │   └── UserRepository.java              # User data access layer
│   │   │   ├── security/
│   │   │   │   ├── ApplicationConfig.java           # Security configuration
│   │   │   │   └── Config.java                      # HTTP security config
│   │   │   ├── service/
│   │   │   │   ├── AuthenticationService.java       # Authentication service interface
│   │   │   │   ├── ClassesService.java              # Class service interface
│   │   │   │   ├── GradeService.java                # Grade service interface
│   │   │   │   ├── SchoolService.java               # School service interface
│   │   │   │   ├── StudentService.java              # Student service interface
│   │   │   │   └── impl/
│   │   │   │       ├── AuthenticationServiceImpl.java # Auth implementation
│   │   │   │       ├── ClassesImpl.java             # Class service implementation
│   │   │   │       ├── GradeImpl.java               # Grade service implementation
│   │   │   │       ├── SchoolImpl.java              # School service implementation
│   │   │   │       └── StudentImpl.java             # Student service implementation
│   │   │   └── util/
│   │   │       └── JwtService.java                  # JWT utility service (optional)
│   │   └── resources/
│   │       ├── application.properties               # JWT secret key config
│   │       ├── application.yml                      # Database configuration
│   │       └── db/
│   │           └── migration/
│   │               └── V1__schoolDb.sql             # Flyway database schema
│   └── test/
│       └── java/                                    # Test classes
└── target/
    ├── classes/                                     # Compiled classes
    ├── school-sv-1.0-SNAPSHOT.jar                   # Built JAR file
    └── ...
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

The application uses MySQL database with Flyway for automated migrations. Update the database credentials in `src/main/resources/application.yml`:

```yaml
spring:
  datasource:
    driver-class-name: com.mysql.cj.jdbc.Driver
    url: jdbc:mysql://localhost:3306/school_sv_saas_db
    username: your_database_username
    password: your_database_password
```

**Important Notes:**
- For production, use environment variables or external configuration for sensitive data
- The database schema is automatically created by Flyway migration scripts
- Flyway version control ensures consistent database state across environments

### JWT Configuration

The JWT secret key is configured in `src/main/resources/application.properties`:

```properties
SECRET_KEY=your_secret_key_here_minimum_256_bits
```

**Security Warning**: 
- Change the SECRET_KEY for production deployments
- Store sensitive keys in environment variables or secure vault solutions
- Never commit real production keys to version control

## 🗄️ Database Setup

### Automatic Migration with Flyway

The application uses Flyway for database version control. The schema is automatically created on first run from the migration scripts:

**Migration Files**:
- `src/main/resources/db/migration/V1__schoolDb.sql` - Core tables (users, schools, grades, classes, hostels, students, medium)
- `src/main/resources/db/migration/V2__schoolDb.sql` - Additional tables (subjects, academic_years, employees, teachers)
- `src/main/resources/db/migration/V3__schoolDb.sql` - Extended tables (evaluations, exams, leaves, marks, payments, principles, societies, staff, attendances, schedules, training, timetables, types)

### Manual Database Creation (Optional)

If you prefer to create the database manually before running the application:

```sql
CREATE DATABASE school_sv_saas_db;
USE school_sv_saas_db;
```

Then let Flyway handle the table creation automatically when the application starts.

### SQL Dialect Configuration (IntelliJ IDEA)

If you're using IntelliJ IDEA and want SQL syntax highlighting and autocomplete in migration files:

1. Open the SQL file: `src/main/resources/db/migration/V1__schoolDb.sql`
2. Look for the SQL dialect notification at the top of the editor
3. Click on "No SQL dialect configured" or the dialect dropdown
4. Select **MySQL** as the SQL dialect
5. Alternatively, configure project-wide:
   - Go to **Settings** → **Languages & Frameworks** → **SQL Dialects**
   - Set **Project SQL Dialect** to **MySQL**

This enables:
- SQL syntax highlighting
- Code completion for MySQL keywords
- Error detection for MySQL-specific syntax
- Database schema inspection

### Flyway Migration

Flyway will automatically:
1. Check the database version
2. Apply pending migrations in order (V1, V2, V3)
3. Track migration history in `flyway_schema_history` table
4. Ensure database consistency

The migrations create the following tables:

**V1 (Core System)**:
- `medium` table - Language medium
- `users` table - User authentication
- `grades` table - Grade levels
- `schools` table - School information
- `hostels` table - Hostel management
- `classes` table - Class organization
- `students` table - Student records

**V2 (Academic & Staff)**:
- `subject` table - Subject management
- `academic_years` table - Academic year tracking
- `employees` table - Employee records
- `teachers` table - Teacher information

**V3 (Operations & Management)**:
- `evaluations` table - Teacher evaluations
- `exams` table - Examination records
- `leaves` table - Leave management
- `marks` table - Student marks/grades
- `payments` table - Payment processing
- `principles` table - Principal information
- `societies` table - Student societies
- `staff` table - Non-teaching staff
- `student_attendances` table - Student attendance tracking
- `teacher_attendances` table - Teacher attendance tracking
- `teacher_schedules` table - Teacher scheduling
- `teacher_training` table - Teacher training programs
- `time_tables` table - Timetable management
- `types` table - Type classifications

All foreign key relationships and constraints are established automatically.

**Note about SQL File Errors:**
- The SQL file begins with `BEGIN;` but doesn't end with `COMMIT;` - this is intentional as Flyway manages transactions
- If you see syntax highlighting errors in your IDE, ensure MySQL dialect is selected (see above)
- The schema will work correctly when executed by Flyway

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

| Method | Endpoint | Description | Auth Required |
|--------|----------|-------------|---------------|
| POST | `/auth/register` | Register a new user | No |
| POST | `/auth/authenticate` | Login and receive JWT token | No |

**Request Body (UserDto):**
```json
{
  "username": "john_doe",
  "password": "SecurePass123!",
  "role": "USER"
}
```

**Response (AuthenticationResponse):**
```json
{
  "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiJqb2huX2RvZSIsImlhdCI6MTY..."
}
```

---

### School Management APIs

| Method | Endpoint | Description | Auth Required |
|--------|----------|-------------|---------------|
| POST | `/school/add-school` | Create a new school | Yes |
| GET | `/school/get-school` | Get all schools | Yes |
| GET | `/school/search-school?id={id}` | Search school by ID | Yes |
| DELETE | `/school/delete-school?id={id}` | Delete a school | Yes |

**Request Body (SchoolDto):**
```json
{
  "name": "Springfield High School",
  "establishmentDate": "1990-06-15",
  "classification": "Category A",
  "email": "info@springfieldhigh.edu",
  "webSiteUrl": "https://www.springfieldhigh.edu",
  "contact": "0771234567",
  "principleId": 101,
  "vision": "Excellence in Education",
  "mission": "To provide quality education for all",
  "studentCapacity": 2000,
  "teacherCapacity": 150,
  "type": "PUBLIC",
  "motto": "Knowledge is Power"
}
```

---

### Student Management APIs

| Method | Endpoint | Description | Auth Required |
|--------|----------|-------------|---------------|
| POST | `/student/add-student` | Register a new student | Yes |
| GET | `/student/get-students` | Get all students | Yes |
| GET | `/student/search-student/{id}` | Get student by ID | Yes |
| DELETE | `/student/delete-student/{id}` | Delete a student | Yes |

**Request Body (StudentDto):**
```json
{
  "classId": 10,
  "firstName": "John",
  "lastName": "Doe",
  "dateOfBirth": "2010-05-15",
  "gender": "MALE",
  "address": "123 Main Street, Springfield",
  "contact": "0771234567",
  "email": "john.doe@student.edu",
  "enrollmentDate": "2024-01-15",
  "schoolId": 1,
  "hostelId": 5
}
```

**Response (StudentDto):**
```json
{
  "id": 1,
  "classId": 10,
  "firstName": "John",
  "lastName": "Doe",
  "dateOfBirth": "2010-05-15",
  "gender": "MALE",
  "address": "123 Main Street, Springfield",
  "contact": "0771234567",
  "email": "john.doe@student.edu",
  "enrollmentDate": "2024-01-15",
  "schoolId": 1,
  "hostelId": 5
}
```

---

### Grade Management APIs

| Method | Endpoint | Description | Auth Required |
|--------|----------|-------------|---------------|
| POST | `/grade/add-grade` | Create a new grade | Yes |
| GET | `/grade/get-grades` | Get all grades | Yes |
| GET | `/grade/search-grade/{id}` | Get grade by ID | Yes |
| DELETE | `/grade/delete-grade/{id}` | Delete a grade | Yes |

**Request Body (GradeDto):**
```json
{
  "gradeName": "Grade 10",
  "isActive": true
}
```

---

### Class Management APIs

| Method | Endpoint | Description | Auth Required |
|--------|----------|-------------|---------------|
| POST | `/classes/add-class` | Create a new class | Yes |
| GET | `/classes/get-classes` | Get all classes | Yes |
| GET | `/classes/search-class/{id}` | Get class by ID | Yes |
| DELETE | `/classes/delete-class/{id}` | Delete a class | Yes |

**Request Body (ClassesDto):**
```json
{
  "gradeId": 10,
  "className": "10-A",
  "academicYear": "2024",
  "isActive": true
}
```

---

### Authentication Header

For all protected endpoints, include the JWT token in the Authorization header:

```
Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9...
```

## 🗄️ Database Schema

The database schema is managed by Flyway migrations. Here's the complete structure:

### Tables Overview

#### Core Tables (V1 Migration)

#### 1. medium
Stores language medium information for multi-language support.

| Column | Type | Constraints | Description |
|--------|------|-------------|-------------|
| id | INT | PRIMARY KEY, AUTO_INCREMENT | Unique medium identifier |
| language | VARCHAR(10) | NOT NULL | Language name |

---

#### 2. users
Stores user authentication and authorization information.

| Column | Type | Constraints | Description |
|--------|------|-------------|-------------|
| id | INT | PRIMARY KEY, AUTO_INCREMENT | Unique user identifier |
| username | VARCHAR(20) | NOT NULL | Username for login |
| password | VARCHAR(100) | NOT NULL | Encrypted password (BCrypt) |
| role | VARCHAR(10) | NOT NULL | User role (USER, ADMIN) |

---

#### 3. grades
Manages grade levels in the educational system.

| Column | Type | Constraints | Description |
|--------|------|-------------|-------------|
| id | INT | PRIMARY KEY, AUTO_INCREMENT | Unique grade identifier |
| grade_name | VARCHAR(50) | NOT NULL | Grade name (e.g., "Grade 10") |
| isActive | BOOLEAN | DEFAULT TRUE | Active status flag |

---

#### 4. schools
Stores comprehensive school information.

| Column | Type | Constraints | Description |
|--------|------|-------------|-------------|
| id | INT | PRIMARY KEY, AUTO_INCREMENT | Unique school identifier |
| school_name | VARCHAR(100) | NOT NULL | Name of the school |
| established_date | DATE | - | School establishment date |
| classification | VARCHAR(50) | - | School classification |
| email | VARCHAR(100) | UNIQUE | School email address |
| website_url | VARCHAR(100) | - | School website URL |
| contact_number | VARCHAR(15) | - | School contact number |
| principalId | INT | - | Principal's ID |
| vision | TEXT | - | School vision statement |
| mission | TEXT | - | School mission statement |
| student_capacity | INT | - | Maximum student capacity |
| teacher_capacity | INT | - | Maximum teacher capacity |
| type | ENUM('PUBLIC', 'PRIVATE') | - | School type |
| motto | VARCHAR(255) | - | School motto |

---

#### 5. hostels
Manages hostel information for residential students.

| Column | Type | Constraints | Description |
|--------|------|-------------|-------------|
| id | INT | PRIMARY KEY, AUTO_INCREMENT | Unique hostel identifier |
| hostel_name | VARCHAR(100) | NOT NULL | Name of the hostel |
| gender | ENUM('MALE', 'FEMALE') | - | Gender-specific hostel |
| capacity | INT | - | Maximum hostel capacity |
| warden_name | VARCHAR(100) | - | Name of the warden |
| contact_number | VARCHAR(15) | - | Hostel contact number |
| school_id | INT | NOT NULL, FOREIGN KEY | Reference to schools table |

**Foreign Key:** `fk_hostel_school` → `schools(id)`

---

#### 6. classes
Represents individual classes within grades.

| Column | Type | Constraints | Description |
|--------|------|-------------|-------------|
| id | INT | PRIMARY KEY, AUTO_INCREMENT | Unique class identifier |
| grade_id | INT | NOT NULL, FOREIGN KEY | Reference to grades table |
| class_name | VARCHAR(50) | NOT NULL | Class name (e.g., "10-A") |
| academic_year | VARCHAR(20) | NOT NULL | Academic year |
| isActive | BOOLEAN | DEFAULT TRUE | Active status flag |

**Foreign Key:** `fk_class_grade` → `grades(id)`

---

#### 7. students
Stores comprehensive student information.

| Column | Type | Constraints | Description |
|--------|------|-------------|-------------|
| id | INT | PRIMARY KEY, AUTO_INCREMENT | Unique student identifier |
| class_id | INT | NOT NULL, FOREIGN KEY | Reference to classes table |
| first_name | VARCHAR(50) | NOT NULL | Student's first name |
| last_name | VARCHAR(50) | NOT NULL | Student's last name |
| date_of_birth | DATE | - | Student's birth date |
| gender | ENUM('MALE', 'FEMALE', 'OTHER') | - | Student's gender |
| address | VARCHAR(255) | - | Residential address |
| phone_number | VARCHAR(15) | - | Contact phone number |
| email | VARCHAR(100) | UNIQUE | Student email address |
| enrollment_date | DATE | DEFAULT CURRENT_DATE | Date of enrollment |
| school_id | INT | NOT NULL, FOREIGN KEY | Reference to schools table |
| hostel_id | INT | FOREIGN KEY, NULLABLE | Reference to hostels table (optional) |

**Foreign Keys:**
- `fk_student_class` → `classes(id)`
- `fk_student_school` → `schools(id)`
- `fk_student_hostel` → `hostels(id)`

---

### Entity Relationships

```
schools (1) ────── (N) students
schools (1) ────── (N) hostels
grades (1) ────── (N) classes
classes (1) ────── (N) students
hostels (1) ────── (N) students [optional]
```

### Relationship Details

1. **School → Students** (One-to-Many)
   - One school can have multiple students
   - Each student belongs to one school

2. **School → Hostels** (One-to-Many)
   - One school can have multiple hostels
   - Each hostel belongs to one school

3. **Grade → Classes** (One-to-Many)
   - One grade can have multiple classes
   - Each class belongs to one grade

4. **Class → Students** (One-to-Many)
   - One class can have multiple students
   - Each student belongs to one class

5. **Hostel → Students** (One-to-Many, Optional)
   - One hostel can accommodate multiple students
   - Students can optionally be assigned to a hostel

### Data Integrity

- Foreign key constraints ensure referential integrity
- Unique constraints on email fields prevent duplicates
- ENUM types enforce valid values for gender and school type
- Default values for enrollment_date and active status flags

## 🔐 Authentication & Security

The application implements a robust JWT (JSON Web Token) based authentication system using Spring Security 4.0.1.

### Authentication Flow

1. **Registration** (`/auth/register`)
   - User provides username, password, and role
   - Password is encrypted using BCrypt
   - User entity is saved to database
   - JWT token is generated and returned

2. **Authentication** (`/auth/authenticate`)
   - User provides credentials (username & password)
   - Spring Security validates credentials
   - If valid, JWT token is generated and returned
   - Token contains user details and expiration time

3. **Authorization**
   - Client includes JWT token in Authorization header
   - `JwtAuthenticationFilter` intercepts all requests
   - Token is validated and user details are extracted
   - Request proceeds if token is valid

4. **Access Control**
   - Role-based authorization (USER, ADMIN)
   - Protected endpoints require valid JWT token
   - Unauthorized requests return 401/403 status

### Security Components

#### JwtAuthenticationFilter
- Intercepts incoming HTTP requests
- Extracts JWT token from Authorization header
- Validates token and sets authentication context
- Filters out unauthenticated requests

#### JwtService (Utility)
- Generates JWT tokens with user claims
- Validates token signatures
- Extracts user information from tokens
- Handles token expiration

#### ApplicationConfig
- Configures authentication providers
- Sets up password encoding (BCrypt)
- Defines UserDetailsService for loading user data
- Configures security filters chain

#### Config (Security Configuration)
- Defines HTTP security rules
- Configures CORS (Cross-Origin Resource Sharing)
- Specifies public endpoints (register, authenticate)
- Sets up stateless session management
- Integrates JWT authentication filter

### Protected Endpoints

**Public Endpoints** (No authentication required):
- `POST /auth/register`
- `POST /auth/authenticate`

**Protected Endpoints** (JWT token required):
- All `/school/*` endpoints
- All `/student/*` endpoints
- All `/grade/*` endpoints
- All `/classes/*` endpoints

### Using the API with Authentication

1. **Register a new user:**
```bash
curl -X POST http://localhost:8080/auth/register \
  -H "Content-Type: application/json" \
  -d '{"username":"admin","password":"admin123","role":"ADMIN"}'
```

2. **Login and get token:**
```bash
curl -X POST http://localhost:8080/auth/authenticate \
  -H "Content-Type: application/json" \
  -d '{"username":"admin","password":"admin123"}'
```

Response:
```json
{
  "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9..."
}
```

3. **Use token for protected endpoints:**
```bash
curl -X GET http://localhost:8080/student/get-students \
  -H "Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9..."
```

### CORS Configuration

Cross-Origin Resource Sharing (CORS) is enabled on all controllers using `@CrossOrigin` annotation, allowing frontend applications from different origins to access the API.

### Security Best Practices

- Passwords are never stored in plain text (BCrypt encryption)
- JWT tokens have expiration times
- Secret keys should be rotated regularly
- Use HTTPS in production
- Store secrets in environment variables or vault solutions
- Implement rate limiting for authentication endpoints
- Add refresh token mechanism for better security

## 📚 API Documentation

Once the application is running, you can access the interactive API documentation:

**Swagger UI**: [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

**OpenAPI JSON**: [http://localhost:8080/v3/api-docs](http://localhost:8080/v3/api-docs)

## 🏗️ Architecture

The application follows a **Layered Architecture** pattern with clear separation of concerns:

### Architectural Layers

```
┌─────────────────────────────────────────────────────┐
│              Client (Frontend / API Consumer)        │
└─────────────────────────────────────────────────────┘
                          ↓
┌─────────────────────────────────────────────────────┐
│         Controller Layer (REST Endpoints)            │
│  - AuthenticationController                          │
│  - SchoolController, StudentController               │
│  - GradeController, ClassesController                │
│  - Request validation & Response formatting          │
└─────────────────────────────────────────────────────┘
                          ↓
┌─────────────────────────────────────────────────────┐
│          Security Layer (Authentication)             │
│  - JwtAuthenticationFilter                           │
│  - ApplicationConfig, Config                         │
│  - Token validation & User authentication            │
└─────────────────────────────────────────────────────┘
                          ↓
┌─────────────────────────────────────────────────────┐
│          Service Layer (Business Logic)              │
│  - AuthenticationService, SchoolService              │
│  - StudentService, GradeService, ClassesService      │
│  - Business rules & Transaction management           │
└─────────────────────────────────────────────────────┘
                          ↓
┌─────────────────────────────────────────────────────┐
│      Repository Layer (Data Access)                  │
│  - UserRepository, SchoolRepository                  │
│  - StudentRepository, GradeRepository                │
│  - ClassesRepository                                 │
│  - Spring Data JPA interfaces                        │
└─────────────────────────────────────────────────────┘
                          ↓
┌─────────────────────────────────────────────────────┐
│          Database (MySQL)                            │
│  - school_sv_saas_db                                 │
│  - Managed by Flyway migrations                      │
└─────────────────────────────────────────────────────┘
```

### Layer Responsibilities

#### 1. Controller Layer (Presentation)
- **Purpose**: Handle HTTP requests and responses
- **Responsibilities**:
  - Receive and validate HTTP requests
  - Route requests to appropriate service methods
  - Transform service responses to HTTP responses
  - Handle cross-cutting concerns (CORS, headers)
- **Technologies**: Spring MVC, `@RestController`, `@RequestMapping`
- **Example**: `StudentController.java`

#### 2. Security Layer
- **Purpose**: Authentication and authorization
- **Responsibilities**:
  - Intercept and filter requests
  - Validate JWT tokens
  - Authenticate users
  - Enforce access control policies
- **Technologies**: Spring Security, JWT
- **Example**: `JwtAuthenticationFilter.java`, `Config.java`

#### 3. Service Layer (Business Logic)
- **Purpose**: Implement business rules and orchestration
- **Responsibilities**:
  - Implement core business logic
  - Coordinate between multiple repositories
  - Handle transactions
  - Transform between DTOs and Entities
- **Technologies**: Spring Service, `@Service`, `@Transactional`
- **Example**: `StudentImpl.java` (implements `StudentService`)

#### 4. Repository Layer (Data Access)
- **Purpose**: Database operations and persistence
- **Responsibilities**:
  - CRUD operations on database
  - Custom query definitions
  - Data persistence abstraction
- **Technologies**: Spring Data JPA, `JpaRepository`
- **Example**: `UserRepository.java`

#### 5. Entity Layer (Domain Model)
- **Purpose**: Represent database tables as Java objects
- **Technologies**: JPA, Hibernate, Lombok
- **Example**: `User.java`

#### 6. DTO Layer (Data Transfer)
- **Purpose**: Transfer data between layers
- **Responsibilities**:
  - Decouple API contracts from domain model
  - Reduce data exposure
  - Version API independently
- **Technologies**: Lombok, Jackson
- **Example**: `StudentDto.java`

### Design Patterns Used

1. **Dependency Injection**: Spring's IoC container
2. **Repository Pattern**: Spring Data JPA repositories
3. **Service Pattern**: Business logic encapsulation
4. **DTO Pattern**: Data transfer between layers
5. **Filter Pattern**: JWT authentication filter
6. **Builder Pattern**: Lombok's `@Builder` annotation

### Object Mapping Strategy

The application uses two mapping approaches:

#### MapStruct (Compile-time)
- **Used for**: Entity → DTO conversions (read operations)
- **Advantages**: 
  - Type-safe mappings
  - No reflection overhead
  - Better performance
  - Compile-time error detection

#### ModelMapper (Runtime)
- **Used for**: DTO → Entity conversions (write operations)
- **Advantages**:
  - Flexible mapping rules
  - Convention-based mapping
  - Good for complex transformations
- **Configuration**: Configured in `Configurations.java`

### Transaction Management

- Spring's declarative transaction management
- `@Transactional` annotations on service methods
- Automatic rollback on exceptions
- Database connection pooling

### Exception Handling

- Spring's exception handling mechanism
- Custom error responses
- HTTP status code mapping

### Configuration Management

- **Profile-based**: Development, staging, production
- **Externalized**: `application.yml`, `application.properties`
- **Environment variables**: For sensitive data


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

### Completed Features ✅
- [x] User authentication with JWT
- [x] Role-based authorization with Spring Security
- [x] Database migration with Flyway
- [x] RESTful API design
- [x] Interactive API documentation (Swagger UI)

### Planned Features 🚀

#### High Priority
- [ ] **Comprehensive Exception Handling**
  - Global exception handler
  - Custom error responses
  - Proper HTTP status codes
  - Error logging and tracking

- [ ] **Input Validation**
  - Bean validation annotations (`@Valid`, `@NotNull`, etc.)
  - Custom validators
  - Request validation middleware

- [ ] **Pagination & Sorting**
  - Page-based responses
  - Sorting by multiple fields
  - Configurable page sizes

- [ ] **Search & Filtering**
  - Search students by name, email, class
  - Filter by date ranges
  - Advanced query capabilities

#### Medium Priority
- [ ] **Complete Entity Implementation**
  - Teachers entity and management
  - Subjects and class subjects
  - Exams and evaluations
  - Marks and grading system
  - Attendance tracking (students & teachers)
  - Leave management
  - Timetable scheduling
  - Society and club management
  - Payment processing

- [ ] **Testing**
  - Unit tests with JUnit 5
  - Integration tests
  - Test coverage reports
  - API testing with RestAssured

- [ ] **Audit Logging**
  - Track all CRUD operations
  - User activity logs
  - Change history
  - Audit trail for compliance

- [ ] **Soft Delete**
  - Logical deletion instead of physical
  - Restore deleted records
  - Archival system

#### Low Priority / Future Considerations
- [ ] **API Versioning**
  - URL-based versioning (`/api/v1/`, `/api/v2/`)
  - Header-based versioning
  - Backward compatibility

- [ ] **Refresh Token Mechanism**
  - Long-lived refresh tokens
  - Short-lived access tokens
  - Token rotation strategy

- [ ] **Rate Limiting**
  - Prevent API abuse
  - Throttling by user/IP
  - Configurable limits

- [ ] **Caching**
  - Redis integration
  - Cache frequently accessed data
  - Improve performance

- [ ] **File Upload**
  - Student profile pictures
  - Document management
  - AWS S3 or local storage

- [ ] **Notifications**
  - Email notifications
  - SMS integration
  - In-app notifications

- [ ] **Reports & Analytics**
  - Student performance reports
  - Attendance reports
  - Export to PDF/Excel
  - Dashboard analytics

- [ ] **Deployment**
  - Docker containerization
  - Kubernetes orchestration
  - CI/CD pipeline
  - Production deployment guides

- [ ] **Multi-tenancy**
  - Complete SaaS implementation
  - Tenant isolation
  - Tenant-specific configurations

- [ ] **API Security Enhancements**
  - OAuth2 integration
  - Two-factor authentication (2FA)
  - API key management
  - Request signing

### Contributing to Development

We welcome contributions! Priority is given to:
1. Exception handling and validation
2. Test coverage
3. Complete entity implementations
4. Performance improvements

## 🔧 Troubleshooting

### Common Issues and Solutions

#### 1. Database Connection Failed

**Error:** `Cannot create PoolableConnectionFactory`

**Solutions:**
- Ensure MySQL server is running:
  ```bash
  sudo systemctl status mysql
  # or
  sudo service mysql status
  ```
- Verify database exists:
  ```sql
  SHOW DATABASES;
  ```
- Check credentials in `application.yml` match your MySQL setup
- Verify port 3306 is not blocked by firewall
- Test connection manually:
  ```bash
  mysql -u root -p -h localhost
  ```

#### 2. Flyway Migration Errors

**Error:** `FlywayException: Validate failed`

**Solutions:**
- Check if database is in consistent state
- View migration history:
  ```sql
  SELECT * FROM flyway_schema_history;
  ```
- For development, drop and recreate database:
  ```sql
  DROP DATABASE school_sv_saas_db;
  CREATE DATABASE school_sv_saas_db;
  ```
- Repair Flyway metadata (use with caution):
  ```bash
  mvn flyway:repair
  ```

#### 3. MapStruct Implementation Not Generated

**Error:** Mapper implementation classes not found

**Solutions:**
- Clean and recompile:
  ```bash
  mvn clean compile
  ```
- Ensure MapStruct processor is in `pom.xml`
- Check Maven annotation processor settings
- Rebuild project in IDE
- Verify `target/generated-sources/annotations` directory exists

#### 4. JWT Token Errors

**Error:** `Invalid JWT signature` or `ExpiredJwtException`

**Solutions:**
- Verify SECRET_KEY matches between token generation and validation
- Check token hasn't expired
- Ensure token includes "Bearer " prefix in Authorization header
- Validate token format (should have 3 parts separated by dots)
- Test token:
  ```bash
  curl -H "Authorization: Bearer YOUR_TOKEN" http://localhost:8080/student/get-students
  ```

#### 5. Port Already in Use

**Error:** `Port 8080 is already in use`

**Solutions:**
- Kill process using the port:
  ```bash
  # Find process
  sudo lsof -i :8080
  # Kill process
  sudo kill -9 <PID>
  ```
- Or change port in `application.yml`:
  ```yaml
  server:
    port: 8081
  ```

#### 6. Lombok Not Working

**Error:** Getters/Setters not found

**Solutions:**
- Enable annotation processing in IDE
  - **IntelliJ IDEA**: Settings → Build, Execution, Deployment → Compiler → Annotation Processors → Enable annotation processing
  - **Eclipse**: Install Lombok plugin
- Verify Lombok dependency in `pom.xml`
- Rebuild project

#### 7. CORS Issues

**Error:** `Access to XMLHttpRequest has been blocked by CORS policy`

**Solutions:**
- Verify `@CrossOrigin` annotation on controllers
- Check CORS configuration in `Config.java`
- For specific origins, update CORS config:
  ```java
  @CrossOrigin(origins = "http://localhost:3000")
  ```

#### 8. 401 Unauthorized on Protected Endpoints

**Error:** `401 Unauthorized` response

**Solutions:**
- Ensure you're authenticated and have a valid token
- Check token is included in Authorization header
- Verify token format: `Bearer <token>`
- Token may have expired - authenticate again
- Check security configuration allows the endpoint

#### 9. Maven Build Fails

**Error:** Maven compilation errors

**Solutions:**
- Clean Maven cache:
  ```bash
  mvn clean
  ```
- Update Maven dependencies:
  ```bash
  mvn clean install -U
  ```
- Delete `.m2/repository` cache if corrupted
- Check Java version (should be 21):
  ```bash
  java -version
  mvn -version
  ```

#### 10. Application Starts but Endpoints Return 404

**Error:** `404 Not Found` on valid endpoints

**Solutions:**
- Verify application started without errors
- Check controller mappings in logs
- Confirm base URL: `http://localhost:8080`
- Check if context path is configured
- View all mappings:
  ```bash
  curl http://localhost:8080/actuator/mappings
  ```

### Logging

Enable detailed logging for debugging:

```yaml
logging:
  level:
    root: INFO
    edu.icet: DEBUG
    org.springframework.security: DEBUG
    org.flywaydb: DEBUG
```

### Getting Help

If you're still experiencing issues:

1. Check application logs in console
2. Review Flyway migration logs
3. Verify all dependencies are resolved: `mvn dependency:tree`
4. Check Spring Boot actuator health: `http://localhost:8080/actuator/health`
5. Create an issue with error logs and environment details

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

For support, email info.pramudithalakshan@example.com or create an issue in the repository.

---

**Note**: Remember to update database credentials and remove sensitive information before committing to version control. Use environment variables or secure vault solutions for production deployments.

