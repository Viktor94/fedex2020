package com.example.fedex_backend.controllers;

import com.example.fedex_backend.exceptions.ProgramException;
import com.example.fedex_backend.models.program.ProgramUpdateDTO;
import com.example.fedex_backend.services.program.ProgramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/program-management")
public class ProgramController {

  private final ProgramService programService;

  @Autowired
  public ProgramController(ProgramService programService) {
    this.programService = programService;
  }

  @GetMapping("/programs")
  public ResponseEntity<?> getAllProgram() {
    return new ResponseEntity<>(programService.getAllProgram(), HttpStatus.OK);
  }

  @PutMapping("/programs/{id}")
  public ResponseEntity<?> updateProgram(@PathVariable Long id, @RequestBody ProgramUpdateDTO programUpdateDTO) throws ProgramException {
    programService.updateProgramSuspicion(id, programUpdateDTO);
    return new ResponseEntity<>(HttpStatus.OK);
  }
}
