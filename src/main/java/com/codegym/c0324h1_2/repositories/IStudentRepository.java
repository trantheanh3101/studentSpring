package com.codegym.c0324h1_2.repositories;

import com.codegym.c0324h1_2.models.Student;

import java.util.List;

public interface IStudentRepository {
    void save(Student student);

    Student findById(Long id);

    List<Student> findAll();

    void update(Long idEdit,Student studentEdit);
}
