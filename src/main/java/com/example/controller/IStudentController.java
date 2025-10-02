package com.example.controller;

import com.example.entities.Student;

import java.util.List;

public interface IStudentController {

	public Student saveStudent(Student student);

    public List<Student> getAllStudents();

    public Student getStudentByName(String name);

    public boolean deleteStudentById(int id);

    public Student getStudentById(int id);

    public Student updateStudentById(int id,Student student);
}
