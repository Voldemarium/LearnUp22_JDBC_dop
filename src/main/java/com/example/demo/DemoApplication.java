package com.example.demo;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		CRUDUtils crudUtils = new CRUDUtils();
		//создаем свою схему
		crudUtils.setStudentData("CREATE SCHEMA IF NOT EXISTS test");
//		crudUtils.setStudentData("DROP SCHEMA IF EXISTS test CASCADE");
		// создаем таблицу
		crudUtils.setStudentData("CREATE TABLE IF NOT EXISTS test.students (\n" +
				"id SERIAL PRIMARY KEY UNIQUE NOT NULL,\n" +
				"name VARCHAR(80) NOT NULL,\n" +
				"surname VARCHAR(100),\n" +
				"course_name VARCHAR(100)\n" +
				")");

		crudUtils.setStudentData("DROP TABLE IF EXISTS test.students CASCADE");


		//Добавим запись в таблицу
		Student student = new Student();
		student.setName("Vova");
		student.setSurName("Ivanov");
		student.setCourseName("Java");
		List<Student> students1 = crudUtils.saveStudent(student, "test.students");
		System.out.println(students1);
//
		List<Student> students2 = crudUtils.getStudentData("SELECT * FROM test.students");
		System.out.println(students2);

//		System.out.println(crudUtils.deleteStudent(1));
	}
}
