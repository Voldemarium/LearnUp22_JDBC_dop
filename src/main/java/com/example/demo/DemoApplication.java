package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class DemoApplication {
	//Особенность базы H2 - все данные в базе аннулируются после закрытия каждого подсоединения (Connection) к ней
	//т.е база H2  существует только в пределах работы одного метода

	public static void main(String[] args) {
		CRUDUtils crudUtils = new CRUDUtils();

		List<Student> students = crudUtils.getStudentData("SELECT * FROM students");
		System.out.println(students);

		System.out.println(crudUtils.deleteStudent(1));
	}
}
