package com.example.fedex_backend.controllers;

import com.example.fedex_backend.exceptions.ProgramException;
import com.example.fedex_backend.models.program.ProgramUpdateDTO;
import com.example.fedex_backend.services.program.ProgramService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/program-management")
public class ProgramController {

  private final ProgramService programService;
  private final Logger LOGGER;

  @Autowired
  public ProgramController(ProgramService programService, Logger logger) {
    this.programService = programService;
    this.LOGGER = logger;
  }

  @GetMapping("/programs")
  public ResponseEntity<?> getAllProgram() {
    LOGGER.info("@GET /program-management/programs");
    return new ResponseEntity<>(programService.getAllProgram(), HttpStatus.OK);
  }

  @PutMapping("/programs/{id}")
  public ResponseEntity<?> updateProgram(
      @PathVariable Long id, @RequestBody ProgramUpdateDTO programUpdateDTO)
      throws ProgramException {
    LOGGER.info("@PUT /program-management/programs/" + id);
    programService.updateProgramSuspicion(id, programUpdateDTO);
    return new ResponseEntity<>(HttpStatus.OK);
  }
}
