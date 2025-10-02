package com.example.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.controller.IStudentController;
import com.example.entities.Student;
import com.example.service.IStudentService;

import java.util.List;

@RestController
@RequestMapping("/resp/api/student")
public class StudentControllerImpl implements IStudentController {
	@Autowired
	private IStudentService studentService;
	
	@PostMapping(path = "/save")
	@Override
	public Student saveStudent(@RequestBody Student student) {
		return studentService.saveStudent(student);
	}

    @GetMapping(path = "/list")
    @Override
    public List<Student> getAllStudents() {
        List<Student> Students = studentService.getAllStudents();
        return Students;
    }

    @GetMapping(path = "studentName/{name}")
    @Override
    public Student getStudentByName(@PathVariable(name = "name", required = true ) String name) {
        Student student = studentService.getStudentByName(name);
        return student;
    }

    @DeleteMapping(path = "delete/{id}")
    @Override
    public boolean deleteStudentById(@PathVariable(name = "id", required = true ) int id) {
        return studentService.deleteStudentById(id);
    }

    @GetMapping(path = "list/{id}")
    @Override
    public Student getStudentById(@PathVariable(name = "id", required = true) int id) {
        Student student = studentService.getStudentById(id);
        return student;
    }

    @PutMapping(path = "update/{id}")
    @Override
    public Student updateStudentById(@PathVariable(name = "id", required = true) int id,@RequestBody Student student) {
        student = studentService.updateStudentById(id, student);
        return student;
    }

}







