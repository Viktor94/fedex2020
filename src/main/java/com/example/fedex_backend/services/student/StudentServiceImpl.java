package com.example.fedex_backend.services.student;

import com.example.fedex_backend.models.student.Student;
import com.example.fedex_backend.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {
    private StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public void addStudent(Student student) {
        if (!isStudentExist(student.getScriptCode())) {
            studentRepository.save(student);
        }
    }

    private boolean isStudentExist(String scriptCode) {
        return studentRepository.findByScriptCode(scriptCode).isPresent();
    }
}
