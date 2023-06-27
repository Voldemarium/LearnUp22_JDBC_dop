
create schema if not exists test;
USE test;

CREATE TABLE students (
id SERIAL PRIMARY KEY unique,
name VARCHAR(80),
surname VARCHAR(100),
course_name VARCHAR(100)
);

INSERT INTO students(name, surname, course_name) VALUES('Alex', 'Ivanov', 'Java');



