package com.springboot.demo.service;

import com.springboot.demo.dao.StudentDAO;
import com.springboot.demo.entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private StudentDAO studentDAO;

    public StudentServiceImpl(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    @Override
    public void save(Student theStudent) {
        studentDAO.save(theStudent);
    }

    @Override
    public Student findById(Integer id) {
        return studentDAO.findById(id);
    }

    @Override
    public List<Student> findAll() {
        return studentDAO.findAll();
    }

    @Override
    public Student update(Student theStudent) {
        return studentDAO.update(theStudent);
    }

    @Override
    public void delete(Integer id) {
        studentDAO.delete(id);
    }

    @Override
    public int deleteAll() {
        return studentDAO.deleteAll();
    }
}
