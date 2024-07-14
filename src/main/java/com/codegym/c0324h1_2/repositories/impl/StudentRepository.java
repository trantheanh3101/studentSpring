package com.codegym.c0324h1_2.repositories.impl;


import com.codegym.c0324h1_2.models.Student;
import com.codegym.c0324h1_2.repositories.IStudentRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepository implements IStudentRepository {
    private static List<Student> students = new ArrayList<>();

    static {
        students.add(new Student(1L,"theanh1","TH",9.0f));
        students.add(new Student(2L,"theanh2","TH",9.0f));
        students.add(new Student(3L,"theanh3","TH",9.0f));
    }

    public List<Student> findAll() {
        return students;
    }
}
