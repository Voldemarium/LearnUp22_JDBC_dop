create schema if not exists test;
USE test;

DROP TABLE IF EXISTS student;
CREATE TABLE students (
id INT PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(80),
surname VARCHAR(100),
course_name VARCHAR(100)
);

INSERT INTO students(name, surname, course_name) VALUES('Alex', 'Ivanov', 'Java');



