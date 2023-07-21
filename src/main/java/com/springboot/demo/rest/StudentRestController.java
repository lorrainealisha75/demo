package com.springboot.demo.rest;

import com.springboot.demo.dao.StudentDAO;
import com.springboot.demo.entity.Student;
import com.springboot.demo.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private StudentService studentService;

    public StudentRestController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students")
    public List<Student> findAll() {
        return studentService.findAll();
    }

    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId) {
        Student student = studentService.findById(studentId);

        if (student == null) {
            throw new RuntimeException("Student not found - " + studentId);
        }

        return student;
    }

    @PostMapping("/students")
    public void addStudent(@RequestBody Student student) {
        studentService.save(student);
    }

    @PutMapping("/students")
    public Student updateStudent(@RequestBody Student student) {
        return studentService.update(student);
    }

    @DeleteMapping("/students/{studentId}")
    public void deleteStudent(@PathVariable int studentId) {
        studentService.delete(studentId);
    }

}
