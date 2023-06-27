package com.example.demo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CRUDUtils {
    private String INSERT_STUDENT = "INSERT INTO test.students(name, surname, course_name) VALUES (?, ?, ?);";
    private String UPDATE_STUDENT = "UPDATE students SET course_name = ? WHERE id = ?;";
    private String DELETE_STUDENT = "DELETE FROM students WHERE id = ?;";

    DBConnection dbUtils = new DBConnection();

    public void setStudentData(String query) {
        try (Connection connection = dbUtils.getConnection(dbUtils.getDbUrl());
             PreparedStatement preparedStatement = connection.prepareStatement(query)
        ) {
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public List<Student> getStudentData(String query) {
        List<Student> students = new ArrayList<>();

        try (Connection connection = dbUtils.getConnection(dbUtils.getDbUrl());
             PreparedStatement preparedStatement = connection.prepareStatement(query)
        ) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                String course_name = rs.getString("course_name");

                students.add(new Student(id, name, surname, course_name));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return students;
    }

    public List<Student> saveStudent(Student student, String tableName) {
        List<Student> students = new ArrayList<>();
        try (Connection connection = dbUtils.getConnection(dbUtils.getDbUrl());
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_STUDENT)) {
            preparedStatement.setString(1, student.getName());  //вставка 1 в запрос INSERT_STUDENT (вместо первого ?)
            preparedStatement.setString(2, student.getSurName());//вставка 2 в запрос INSERT_STUDENT (вместо второго ?)
            preparedStatement.setString(3, student.getCourseName()); //вставка 3 в запрос INSERT_STUDENT (вместо третьего ?)
            preparedStatement.executeUpdate();
            PreparedStatement allStudents = connection.prepareStatement("SELECT*FROM "  + tableName);
            ResultSet rs = allStudents.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                String course_name = rs.getString("course_name");
                students.add(new Student(id, name, surname, course_name));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return students;
    }

    public List<Student> updateStudent(int studentId, String courseName) {
        List<Student> students = new ArrayList<>();
        try (Connection connection = dbUtils.getConnection(dbUtils.getDbUrl());
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_STUDENT)) {
            preparedStatement.setString(1, courseName); //вставка 1 в запрос UPDATE_STUDENT (вместо первого ?)
            preparedStatement.setInt(2, studentId);     //вставка 2 в запрос UPDATE_STUDENT (вместо второго ?)
            preparedStatement.executeUpdate();
            PreparedStatement allStudents = connection.prepareStatement("SELECT*FROM students");
            ResultSet rs = allStudents.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                String course_name = rs.getString("course_name");

                students.add(new Student(id, name, surname, course_name));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return students;
    }

    public List<Student> deleteStudent(int studentId) {
        List<Student> students = new ArrayList<>();
        try (Connection connection = dbUtils.getConnection(dbUtils.getDbUrl());
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_STUDENT)) {
            preparedStatement.setInt(1, studentId);     //вставка 2 в запрос UPDATE_STUDENT (вместо второго ?)
            preparedStatement.executeUpdate();

//            PreparedStatement preparedStatement1 = connection.prepareStatement("DROP TABLE students");
//            preparedStatement1.execute();

//            PreparedStatement preparedStatement2 = connection.prepareStatement("DROP SCHEMA test CASCADE");
//            preparedStatement2.execute();

            PreparedStatement allStudents = connection.prepareStatement("SELECT*FROM students");
            ResultSet rs = allStudents.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                String course_name = rs.getString("course_name");

                students.add(new Student(id, name, surname, course_name));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return students;
    }


}
