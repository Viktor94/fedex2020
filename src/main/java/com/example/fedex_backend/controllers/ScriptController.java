package com.example.fedex_backend.controllers;

import com.example.fedex_backend.models.dtos.KPPMDTO;
import com.example.fedex_backend.models.dtos.MUDTO;
import com.example.fedex_backend.models.script.ScriptDTO;
import com.example.fedex_backend.services.script.ScriptService;
import com.example.fedex_backend.services.student.StudentService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/script-management")
public class ScriptController {

  private final ScriptService scriptService;
  private final StudentService studentService;
  private final Logger LOGGER;

  @Autowired
  public ScriptController(ScriptService scriptService, StudentService studentService, Logger logger) {
    this.scriptService = scriptService;
    this.studentService = studentService;
    this.LOGGER = logger;
  }

  @PostMapping("/scripts")
  public ResponseEntity<?> addScript(@RequestBody ScriptDTO scriptDTO) {
    LOGGER.info("@POST /script-management/scripts");
    scriptService.manageScript(scriptDTO);
    return new ResponseEntity<>(HttpStatus.CREATED);
  }

  @PostMapping("/kppm")
  public ResponseEntity<?> addKPPM(@RequestBody KPPMDTO kppmdto) {
    LOGGER.info("@POST /script-management/kppm");
    studentService.updateKPPM(kppmdto);
    return new ResponseEntity<>(HttpStatus.CREATED);
  }

  @PostMapping("/mu")
  public ResponseEntity<?> addMU(@RequestBody MUDTO mudto) {
    LOGGER.info("@POST /script_management/mu");
    studentService.updateMU(mudto);
    return new ResponseEntity<>(HttpStatus.CREATED);
  }

}
