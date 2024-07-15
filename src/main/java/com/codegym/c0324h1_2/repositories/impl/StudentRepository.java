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

    @Override
    public void update(Long idEdit,Student studentEdit) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == idEdit) {
                Student editStudent = students.get(i);
                editStudent.setName(studentEdit.getName());
                editStudent.setAddress(studentEdit.getAddress());
                editStudent.setScore(studentEdit.getScore());
                return;
            }
        }
    }

    @Override
    public void save(Student student) {
        student.setId(students.get(students.size()-1).getId() + 1);
        students.add(student);
    }

    @Override
    public Student findById(Long id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }
}
