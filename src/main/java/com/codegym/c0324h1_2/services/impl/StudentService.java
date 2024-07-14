package com.codegym.c0324h1_2.services.impl;


import com.codegym.c0324h1_2.models.Student;
import com.codegym.c0324h1_2.repositories.impl.StudentRepository;
import com.codegym.c0324h1_2.services.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService implements IStudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }
}
