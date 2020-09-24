package com.example.fedex_backend.services.student;

import com.example.fedex_backend.models.student.Student;
import com.example.fedex_backend.repositories.StudentRepository;
import com.example.fedex_backend.services.program.ProgramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class StudentServiceImpl implements StudentService {

  private final StudentRepository studentRepository;
  private ProgramService programService;

  @Autowired
  public StudentServiceImpl(StudentRepository studentRepository, ProgramService programService) {
    this.studentRepository = studentRepository;
    this.programService = programService;
  }

  @Override
  public Student addStudent(Student student) {
    Optional<Student> optionalStudent = isStudentExist(student.getScriptCode());
    if (optionalStudent.isEmpty()) {
      student.setDate(new Date(System.currentTimeMillis()));
      return saveStudent(student);
    } else {
      Student existingStudent = optionalStudent.get();
      existingStudent.setDate(new Date(System.currentTimeMillis()));
      existingStudent.setSuspicious(false);
      return saveStudent(existingStudent);
    }
  }

  @Override
  public Student saveStudent(Student student) {
      return studentRepository.save(student);
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

  private Optional<Student> isStudentExist(String scriptCode) {
    return studentRepository.findByScriptCode(scriptCode);
  }


}
