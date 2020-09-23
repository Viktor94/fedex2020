package com.example.fedex_backend.controllers;

import com.example.fedex_backend.models.script.ScriptDTO;
import com.example.fedex_backend.services.program.ProgramService;
import com.example.fedex_backend.services.student.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/scripts")
public class ScriptController {

  private final ProgramService programService;
  private final StudentService studentService;

  @Autowired
  public ScriptController(ProgramService programService, StudentService studentService) {
    this.programService = programService;
    this.studentService = studentService;
  }

  @PostMapping(value = "")
  public ResponseEntity<?> addScript(@RequestBody ScriptDTO scriptDTO) {
    studentService.addStudent(scriptDTO.getStudent());
    programService.savePrograms(scriptDTO.getProgramDTOList());

    return new ResponseEntity<>(HttpStatus.CREATED);
  }
}
