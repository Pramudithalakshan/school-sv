CREATE TABLE IF NOT EXISTS subject(
    id INT AUTO_INCREMENT PRIMARY KEY,
    subject_name VARCHAR(100) NOT NULL,
    medium_id INT NOT NULL,
    description TEXT,
    CONSTRAINT fk_subject_medium FOREIGN KEY (medium_id) REFERENCES medium(id)
);

CREATE TABLE IF NOT EXISTS academic_years (
    id INT AUTO_INCREMENT PRIMARY KEY,
    year_label int NOT NULL,
    start_year YEAR NOT NULL,
    end_year YEAR NOT NULL,
    isActive BOOLEAN DEFAULT TRUE
);

CREATE TABLE IF NOT EXISTS employees (
    id INT AUTO_INCREMENT PRIMARY KEY,
    role VARCHAR(50) NOT NULL,
    join_date DATE NOT NULL,
    basic_salary DECIMAL(10,2) NOT NULL,
    allowances DECIMAL(10,2),
    bank_account VARCHAR(50),
    school_id INT NOT NULL,
    CONSTRAINT fk_employee_school FOREIGN KEY (school_id) REFERENCES schools(id)
);
CREATE TABLE IF NOT EXISTS teachers(
    id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    gender ENUM('MALE', 'FEMALE', 'OTHER') NOT NULL,
    contact_number VARCHAR(15),
    email VARCHAR(100) UNIQUE,
    qualification VARCHAR(100),
    hire_date DATE NOT NULL,
    isActive BOOLEAN DEFAULT TRUE,
    medium_id INT NOT NULL,
    subject_id INT NOT NULL,
    employee_id INT NOT NULL,
    CONSTRAINT fk_teacher_medium FOREIGN KEY (medium_id) REFERENCES medium(id),
    CONSTRAINT fk_teacher_subject FOREIGN KEY (subject_id) REFERENCES subject(id),
    CONSTRAINT fk_teacher_employee FOREIGN KEY (employee_id) REFERENCES employees(id)
);