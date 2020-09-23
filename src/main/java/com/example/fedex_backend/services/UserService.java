package com.example.fedex_backend.services;


import com.example.fedex_backend.exceptions.MissingFieldException;
import com.example.fedex_backend.exceptions.MissingParametersException;
import com.example.fedex_backend.exceptions.NoSuchUserException;
import com.example.fedex_backend.exceptions.UsernameAlreadyTakenException;
import com.example.fedex_backend.exceptions.WrongPasswordException;
import com.example.fedex_backend.exceptions.WrongUsernameException;
import com.example.fedex_backend.models.User;
import com.example.fedex_backend.models.dtos.UserLoginDTO;
import com.example.fedex_backend.models.dtos.UserRegisterDTO;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserService {

  User findUserByEmail(String email);

  UserDetails loadUserByUsername(String username);

  void checkUserRegisterDTO(UserRegisterDTO userRegisterDTO)
      throws MissingFieldException, WrongUsernameException, UsernameAlreadyTakenException;

  Boolean isUserValidByEmail(String email);

  void saveUser(User user);

  void validatePlayerLogin(UserLoginDTO dto)
      throws MissingParametersException, NoSuchUserException, WrongPasswordException;
}
