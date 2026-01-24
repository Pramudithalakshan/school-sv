CREATE TABLE IF NOT EXISTS evaluations(
    id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    teacher_id INT NOT NULL,
    evaluated_by VARCHAR(20) NOT NULL ,
    score INT NOT NULL ,
    feedback TEXT NOT NULL ,
    date DATE NOT NULL,
    CONSTRAINT fk_evaluations_teachers FOREIGN KEY (teacher_id) REFERENCES teachers (id)
);
CREATE TABLE IF NOT EXISTS exams(
    id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(20) NOT NULL ,
    student_id INT NOT NULL ,
    date DATE NOT NULL,
    CONSTRAINT fk_exams_students FOREIGN KEY (student_id) REFERENCES students(id)
);
CREATE TABLE IF NOT EXISTS leaves(
    id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    teacher_id INT NOT NULL ,
    date DATE NOT NULL ,
    reason VARCHAR(50) NOT NULL ,
    isApproved BOOLEAN NOT NULL ,
    CONSTRAINT fk_leaves_teacher FOREIGN KEY (teacher_id) REFERENCES teachers(id)
);
CREATE TABLE IF NOT EXISTS marks(
    id INT AUTO_INCREMENT PRIMARY KEY ,
    student_id INT NOT NULL ,
    exam_id INT NOT NULL ,
    marks INT NOT NULL ,
    grade VARCHAR(10) NOT NULL ,
    CONSTRAINT fk_marks_students FOREIGN KEY (student_id) REFERENCES students(id),
    CONSTRAINT fk_marks_exams FOREIGN KEY (exam_id) REFERENCES exams(id)
);
CREATE TABLE IF NOT EXISTS payments(
    id INT PRIMARY KEY AUTO_INCREMENT NOT NULL ,
    employee_id INT NOT NULL ,
    amount DECIMAL(10,2) NOT NULL ,
    date DATE NOT NULL ,
    CONSTRAINT fk_payments_employee FOREIGN KEY (employee_id) REFERENCES employees(id)
);
CREATE TABLE IF NOT EXISTS principles(
    id INT PRIMARY KEY AUTO_INCREMENT,
    contact VARCHAR(10) NOT NULL ,
    address VARCHAR(100) NOT NULL ,
    school_id INT NOT NULL ,
    employee_id INT NOT NULL ,
    CONSTRAINT fk_principles_schools FOREIGN KEY (school_id) REFERENCES schools(id),
    CONSTRAINT fk_principles_employees FOREIGN KEY (employee_id) REFERENCES employees(id)
);
CREATE TABLE IF NOT EXISTS societies(
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(20) NOT NULL
);
CREATE TABLE IF NOT EXISTS staff(
    id INT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(20) NOT NULL ,
    last_name VARCHAR(20) NOT NULL ,
    gender ENUM('MALE', 'FEMALE', 'OTHER') NOT NULL ,
    date_of_birth DATE NOT NULL ,
    address VARCHAR(50) NOT NULL ,
    contact VARCHAR(10) NOT NULL ,
    email VARCHAR(100) NOT NULL ,
    employee_id INT NOT NULL ,
    CONSTRAINT fk_staff_employees FOREIGN KEY (employee_id) REFERENCES employees(id)
);
CREATE TABLE  IF NOT EXISTS  student_attendances(
    id INT PRIMARY KEY AUTO_INCREMENT,
    student_id INT NOT NULL ,
    date DATE NOT NULL ,
    isAttended BOOLEAN NOT NULL ,
    CONSTRAINT fk_student_attendances_students FOREIGN KEY (student_id) REFERENCES students(id)
);
CREATE TABLE IF NOT EXISTS teacher_attendances(
    id INT PRIMARY KEY AUTO_INCREMENT,
    date DATE NOT NULL ,
    check_in_time TIME(2) NOT NULL ,
    check_out_time TIME(2) NOT NULL,
    teacher_id INT NOT NULL ,
    CONSTRAINT fk_teacher_attendances_teachers FOREIGN KEY (teacher_id) REFERENCES teachers(id)
);
CREATE TABLE IF NOT EXISTS teacher_schedules(
    id INT PRIMARY KEY AUTO_INCREMENT,
    class_id INT NOT NULL ,
    subject_id INT NOT NULL ,
    start_time TIME(2) NOT NULL ,
    end_time TIME(2) NOT NULL ,
    CONSTRAINT fk_teacher_schedules_classes FOREIGN KEY (class_id) REFERENCES classes(id),
    CONSTRAINT fk_teacher_schedules_subjects FOREIGN KEY (subject_id) REFERENCES subject(id)
);
CREATE TABLE IF NOT EXISTS teacher_training(
    id INT PRIMARY KEY AUTO_INCREMENT,
    teacher_id INT NOT NULL ,
    program_name VARCHAR(20) NOT NULL ,
    provider VARCHAR(20) NOT NULL ,
    start_date DATE NOT NULL ,
    end_date DATE NOT NULL ,
    certification VARCHAR(20) NOT NULL ,
    CONSTRAINT fk_teacher_training_teachers FOREIGN KEY (teacher_id) REFERENCES teachers(id)
);
CREATE TABLE IF NOT EXISTS time_tables(
    id INT PRIMARY KEY AUTO_INCREMENT,
    class_id INT NOT NULL ,
    subject_id INT NOT NULL ,
    teacher_id INT NOT NULL ,
    day_of_week DATE not null ,
    periods INT NOT NULL ,
    start_time TIME(2) NOT NULL ,
    end_time TIME(2) NOT NULL ,
    isActive BOOLEAN NOT NULL ,
    CONSTRAINT fk_time_tables_classes FOREIGN KEY (class_id) REFERENCES classes(id),
    CONSTRAINT fk_time_tables_subject FOREIGN KEY (subject_id) REFERENCES subject(id),
    CONSTRAINT fk_time_table_teacher FOREIGN KEY (teacher_id) REFERENCES teachers(id)
);
CREATE TABLE IF NOT EXISTS types(
    id INT AUTO_INCREMENT PRIMARY KEY ,
    type VARCHAR(10) NOT NULL
);