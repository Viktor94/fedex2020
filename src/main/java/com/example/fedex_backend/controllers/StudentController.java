package com.example.fedex_backend.controllers;

import com.example.fedex_backend.services.student.StudentService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student-management")
public class StudentController {

  private final StudentService studentService;
  private final Logger LOGGER;

  @Autowired
  public StudentController(StudentService studentService, Logger logger) {
    this.studentService = studentService;
    this.LOGGER = logger;
  }

  @GetMapping("/students")
  public ResponseEntity<?> getAllStudent() {
    LOGGER.info("@GET /student-management/students");
    return new ResponseEntity<>(studentService.getAllStudentFilteredBySuspicion(), HttpStatus.OK);
  }
}
