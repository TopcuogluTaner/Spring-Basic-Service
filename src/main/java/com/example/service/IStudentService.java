package com.example.service;

import com.example.entities.Student;

import java.util.List;

public interface IStudentService {

	public Student saveStudent(Student student);

    public List<Student> getAllStudents();

    public Student getStudentByName(String name);

    public boolean deleteStudentById(Integer id);

    public Student getStudentById(Integer id);

    public Student updateStudentById(int id,Student student);
}
