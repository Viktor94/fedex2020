package com.example.fedex_backend.controllers;

import com.example.fedex_backend.models.script.ScriptDTO;
import com.example.fedex_backend.services.script.ScriptService;
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
  private final Logger LOGGER;

  @Autowired
  public ScriptController(ScriptService scriptService, Logger logger) {
    this.scriptService = scriptService;
    this.LOGGER = logger;
  }

  @PostMapping("/scripts")
  public ResponseEntity<?> addScript(@RequestBody ScriptDTO scriptDTO) {
    LOGGER.info("@POST /script-management/scripts");
    scriptService.manageScript(scriptDTO);
    return new ResponseEntity<>(HttpStatus.CREATED);
  }
}
