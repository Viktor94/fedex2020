package com.example.fedex_backend.exceptions;

import com.example.fedex_backend.models.Message;

public class WrongUsernameException extends RegisterException {

  private final String parameters;

  public WrongUsernameException(String parameters) {
    this.parameters = parameters;
  }

  @Override
  public Message getErrorMessage() {
    return new Message("error", parameters);
  }
}
