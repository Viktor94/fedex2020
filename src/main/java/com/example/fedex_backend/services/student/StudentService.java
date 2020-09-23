package com.example.fedex_backend.services.student;

import com.example.fedex_backend.models.student.Student;

import java.util.List;

public interface StudentService {
    Student addStudent(Student student);

    Student saveStudent(Student student);

    List<Student> getAllStudentFilteredBySuspicion();
}
