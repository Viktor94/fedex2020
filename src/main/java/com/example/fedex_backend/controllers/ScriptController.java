package com.example.fedex_backend.controllers;

import com.example.fedex_backend.models.script.ScriptDTO;
import com.example.fedex_backend.services.script.ScriptService;
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

  private ScriptService scriptService;

  @Autowired
  public ScriptController(ScriptService scriptService) {
    this.scriptService = scriptService;
  }

  @PostMapping(value = "/scripts")
  public ResponseEntity<?> addScript(@RequestBody ScriptDTO scriptDTO) {
    scriptService.manageScript(scriptDTO);

    return new ResponseEntity<>(HttpStatus.CREATED);
  }
}
