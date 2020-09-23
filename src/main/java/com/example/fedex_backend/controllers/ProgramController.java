package com.example.fedex_backend.controllers;

import com.example.fedex_backend.services.program.ProgramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/programs")
public class ProgramController {

    private final ProgramService programService;

    @Autowired
    public ProgramController(ProgramService programService) {
        this.programService = programService;
    }

    @GetMapping("")
    public ResponseEntity<?> getAllProgram() {
        return new ResponseEntity<>(programService.getAllProgram(), HttpStatus.OK);
    }
}
