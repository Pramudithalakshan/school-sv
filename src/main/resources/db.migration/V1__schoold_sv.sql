CREATE TABLE Parents
(
    ParentID    INT AUTO_INCREMENT PRIMARY KEY,
    FirstName   VARCHAR(50) NOT NULL,
    LastName    VARCHAR(50) NOT NULL,
    PhoneNumber VARCHAR(20),
    Email       VARCHAR(100) UNIQUE
);

CREATE TABLE Departments
(
    DepartmentID   INT AUTO_INCREMENT PRIMARY KEY,
    DepartmentName VARCHAR(100) NOT NULL
);

CREATE TABLE TeacherType
(
    TeacherTypeID INT AUTO_INCREMENT PRIMARY KEY,
    TypeName      VARCHAR(50) NOT NULL -- e.g., Full-time, Part-time
);

CREATE TABLE Grades
(
    GradeID   INT AUTO_INCREMENT PRIMARY KEY,
    GradeName VARCHAR(50) NOT NULL -- e.g., 10th Grade
);

CREATE TABLE ExamType
(
    ExamTypeID INT AUTO_INCREMENT PRIMARY KEY,
    TypeName   VARCHAR(50) NOT NULL -- e.g., Midterm, Final
);

CREATE TABLE Library
(
    LibraryID INT AUTO_INCREMENT PRIMARY KEY,
    BookTitle VARCHAR(255) NOT NULL,
    Author    VARCHAR(255),
    ISBN      VARCHAR(20) UNIQUE,
    Quantity  INT DEFAULT 1
);

CREATE TABLE Teachers
(
    TeacherID          INT AUTO_INCREMENT PRIMARY KEY,
    TeacherFirstName   VARCHAR(50) NOT NULL,
    TeacherLastName    VARCHAR(50) NOT NULL,
    TeacherDateOfBirth DATE,
    TeacherGender      VARCHAR(10),
    TeacherAddress     TEXT,
    TeacherPhoneNumber VARCHAR(20),
    TeacherEmail       VARCHAR(100) UNIQUE,
    DepartmentID       INT,
    TeacherTypeID      INT,
    FOREIGN KEY (DepartmentID) REFERENCES Departments (DepartmentID),
    FOREIGN KEY (TeacherTypeID) REFERENCES TeacherType (TeacherTypeID)
);

CREATE TABLE Classrooms
(
    ClassroomID   INT AUTO_INCREMENT PRIMARY KEY,
    ClassroomName VARCHAR(100) NOT NULL,
    GradeID       INT,
    TeacherID     INT,
    FOREIGN KEY (GradeID) REFERENCES Grades (GradeID),
    FOREIGN KEY (TeacherID) REFERENCES Teachers (TeacherID)
);

CREATE TABLE Students
(
    StudentID          INT AUTO_INCREMENT PRIMARY KEY,
    StudentFirstName   VARCHAR(50) NOT NULL,
    StudentLastName    VARCHAR(50) NOT NULL,
    StudentDateOfBirth DATE,
    StudentGender      VARCHAR(10),
    StudentAddress     TEXT,
    StudentPhoneNumber VARCHAR(20),
    StudentEmail       VARCHAR(100) UNIQUE,
    ParentID           INT,
    ClassroomID        INT,
    FOREIGN KEY (ParentID) REFERENCES Parents (ParentID),
    FOREIGN KEY (ClassroomID) REFERENCES Classrooms (ClassroomID)
);

CREATE TABLE Courses
(
    CourseID     INT AUTO_INCREMENT PRIMARY KEY,
    CourseName   VARCHAR(100) NOT NULL,
    Description  TEXT,
    TeacherID    INT,
    DepartmentID INT,
    FOREIGN KEY (TeacherID) REFERENCES Teachers (TeacherID),
    FOREIGN KEY (DepartmentID) REFERENCES Departments (DepartmentID)
);

CREATE TABLE StudentClassroom
(
    StudentClassroomID INT AUTO_INCREMENT PRIMARY KEY,
    StudentID          INT,
    ClassroomID        INT,
    TeacherID          INT,
    EnrollmentDate     DATE DEFAULT (CURRENT_DATE),
    FOREIGN KEY (StudentID) REFERENCES Students (StudentID),
    FOREIGN KEY (ClassroomID) REFERENCES Classrooms (ClassroomID),
    FOREIGN KEY (TeacherID) REFERENCES Teachers (TeacherID)
);

CREATE TABLE Enrollments
(
    EnrollmentID   INT AUTO_INCREMENT PRIMARY KEY,
    StudentID      INT,
    CourseID       INT,
    EnrollmentDate DATE DEFAULT (CURRENT_DATE),
    FOREIGN KEY (StudentID) REFERENCES Students (StudentID),
    FOREIGN KEY (CourseID) REFERENCES Courses (CourseID)
);

CREATE TABLE Attendance
(
    AttendanceID   INT AUTO_INCREMENT PRIMARY KEY,
    StudentID      INT,
    ClassroomID    INT,
    AttendanceDate DATE DEFAULT (CURRENT_DATE),
    Status         VARCHAR(20) NOT NULL, -- Present, Absent
    FOREIGN KEY (StudentID) REFERENCES Students (StudentID),
    FOREIGN KEY (ClassroomID) REFERENCES Classrooms (ClassroomID)
);

CREATE TABLE Exams
(
    ExamID     INT AUTO_INCREMENT PRIMARY KEY,
    ExamName   VARCHAR(100),
    CourseID   INT,
    ExamTypeID INT,
    ExamDate   DATE,
    FOREIGN KEY (CourseID) REFERENCES Courses (CourseID),
    FOREIGN KEY (ExamTypeID) REFERENCES ExamType (ExamTypeID)
);

CREATE TABLE ExamResults
(
    ExamResultID INT AUTO_INCREMENT PRIMARY KEY,
    StudentID    INT,
    ExamID       INT,
    Score        DECIMAL(5, 2),
    FOREIGN KEY (StudentID) REFERENCES Students (StudentID),
    FOREIGN KEY (ExamID) REFERENCES Exams (ExamID)
);

CREATE TABLE Assignments
(
    AssignmentID   INT AUTO_INCREMENT PRIMARY KEY,
    AssignmentName VARCHAR(100),
    CourseID       INT,
    DueDate        DATE,
    FOREIGN KEY (CourseID) REFERENCES Courses (CourseID)
);

CREATE TABLE BorrowedBooks
(
    BorrowID   INT AUTO_INCREMENT PRIMARY KEY,
    StudentID  INT,
    LibraryID  INT,
    BorrowDate DATE DEFAULT (CURRENT_DATE),
    ReturnDate DATE,
    FOREIGN KEY (StudentID) REFERENCES Students (StudentID),
    FOREIGN KEY (LibraryID) REFERENCES Library (LibraryID)
);

CREATE TABLE Fees
(
    FeeID     INT AUTO_INCREMENT PRIMARY KEY,
    StudentID INT,
    Amount    DECIMAL(10, 2),
    DueDate   DATE,
    PaidDate  DATE,
    FOREIGN KEY (StudentID) REFERENCES Students (StudentID)
);