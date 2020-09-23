package com.example.fedex_backend.exceptions;


import com.example.fedex_backend.models.Message;

public abstract class LoginException extends Exception {

  public abstract Message getErrorMessage();
}
