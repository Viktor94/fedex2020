package com.example.fedex_backend.services.student;

import com.example.fedex_backend.models.student.Student;
import com.example.fedex_backend.repositories.StudentRepository;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

  private final StudentRepository studentRepository;

  @Autowired
  public StudentServiceImpl(StudentRepository studentRepository) {
    this.studentRepository = studentRepository;
  }

  @Override
  public void addStudent(Student student) {
    if (!isStudentExist(student.getScriptCode())) {
      student.setDate(new Date(System.currentTimeMillis()));
      studentRepository.save(student);
    } else {
      Student student1 = studentRepository.findByScriptCode(student.getScriptCode()).get();
      student1.setDate(new Date(System.currentTimeMillis()));
      student1.setSuspicious(false);
    }
  }

  private boolean isStudentExist(String scriptCode) {
    return studentRepository.findByScriptCode(scriptCode).isPresent();
  }

  @Scheduled(fixedRate = 60000)
  public void updateStudents() {
    Date date = new Date(System.currentTimeMillis());
    List<Student> studentList = StreamSupport
        .stream(studentRepository.findAll().spliterator(), false)
        .collect(Collectors.toList());

    for (Student student : studentList) {
      student.setSuspicious(date.getTime() - student.getDate().getTime() > 60000);
      studentRepository.save(student);
    }
  }
}
