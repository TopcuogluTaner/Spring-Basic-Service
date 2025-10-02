package com.example.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entities.Student;
import com.example.repository.StudentRepository;
import com.example.service.IStudentService;

import java.util.List;

@Service
public class IStudentServiceImpl implements IStudentService{
    @Autowired
	private StudentRepository studentRepository;
	@Override
	public Student saveStudent(Student student) {
		return studentRepository.save(student); 
	}

    @Override
    public List<Student> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        return students;
    }

    @Override
    public Student getStudentByName(String name) {
        Student student = studentRepository.getStudentByFirstName(name);
        return student;
    }

    @Override
    public boolean deleteStudentById(Integer id) {
        if (id == null) {
            throw new IllegalArgumentException("ID cannot be null");
        }

        boolean exists = studentRepository.existsById(id);
        if (exists) {
            studentRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Student getStudentById(Integer id) {
        Student student = studentRepository.getStudentById(id);
        if(student != null){
            return student;
        }
        return null;
    }

    @Override
    public Student updateStudentById(int id, Student student) {
        Student student1 = studentRepository.getStudentById(id);
        if(student1 != null){
            student1.setFirstName(student.getFirstName());
            student1.setLastName(student.getLastName());
            student1.setDateOfBirth(student.getDateOfBirth());
        }
        else{
            throw new IllegalArgumentException("Student with id " + id + " does not exist");
        }
        studentRepository.save(student1);
        return student1;
    }

}
