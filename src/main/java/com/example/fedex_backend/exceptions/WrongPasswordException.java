package com.example.fedex_backend.exceptions;

import com.example.fedex_backend.models.Message;

public class WrongPasswordException extends LoginException {

  @Override
  public Message getErrorMessage() {
    return new Message("error", "Wrong password!");
  }
}
