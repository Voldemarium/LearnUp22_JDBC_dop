package com.example.demo;

import lombok.Data;

@Data
public class Student {
    private int id;
    private String name;
    private String surName;
    private String courseName;

    public Student () {};

    public Student(int id, String name, String surName, String courseName) {
        this.id = id;
        this.name = name;
        this.surName = surName;
        this.courseName = courseName;
    }
}
