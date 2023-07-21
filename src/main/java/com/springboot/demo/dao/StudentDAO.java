package com.springboot.demo.dao;

import com.springboot.demo.entity.Student;

import java.util.List;

public interface StudentDAO {

    public void save(Student theStudent);

    public Student findById(Integer id);

    public List<Student> findAll();

    public Student update(Student theStudent);

    public void delete(Integer id);

    public int deleteAll();
}
