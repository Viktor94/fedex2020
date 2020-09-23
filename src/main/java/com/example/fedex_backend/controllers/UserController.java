package com.example.fedex_backend.controllers;

import com.example.fedex_backend.exceptions.UsernameAlreadyTakenException;
import com.example.fedex_backend.security.JwtUtil;
import com.example.fedex_backend.exceptions.MissingFieldException;
import com.example.fedex_backend.exceptions.MissingParametersException;
import com.example.fedex_backend.exceptions.NoSuchUserException;
import com.example.fedex_backend.exceptions.WrongPasswordException;
import com.example.fedex_backend.exceptions.WrongUsernameException;
import com.example.fedex_backend.models.User;
import com.example.fedex_backend.models.dtos.UserLoginDTO;
import com.example.fedex_backend.models.dtos.UserRegisterDTO;
import com.example.fedex_backend.models.dtos.UserRegisterResponseDTO;
import com.example.fedex_backend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

  private final JwtUtil jwtUtil;
  private final UserService userService;

  @Autowired
  public UserController(JwtUtil jwtUtil, UserService userService) {
    this.jwtUtil = jwtUtil;
    this.userService = userService;
  }

  @PostMapping("/register")
  public ResponseEntity<?> register(@RequestBody(required = false) UserRegisterDTO userRegisterDTO)
      throws WrongUsernameException, MissingFieldException, UsernameAlreadyTakenException {
    userService.checkUserRegisterDTO(userRegisterDTO);
    User user = userService.findUserByEmail(userRegisterDTO.getUsername());
    UserRegisterResponseDTO dto = new UserRegisterResponseDTO(user.getUsername());

    return new ResponseEntity<>(dto, HttpStatus.OK);
  }

  @PostMapping("/login")
  public ResponseEntity<?> login(@RequestBody(required = false) UserLoginDTO dto)
      throws NoSuchUserException, MissingParametersException, WrongPasswordException {
    userService.validatePlayerLogin(dto);

    final UserDetails userDetails = userService.loadUserByUsername(dto.getUsername());
    final String jwt = jwtUtil.generateToken(userDetails, 60);

    return new ResponseEntity<>(jwt, HttpStatus.OK);
  }
}
