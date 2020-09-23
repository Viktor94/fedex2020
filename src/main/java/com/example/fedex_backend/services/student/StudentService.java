package com.example.fedex_backend.services.student;

import com.example.fedex_backend.models.student.Student;

public interface StudentService {
    Student addStudent(Student student);

    Student saveStudent(Student student);
}
