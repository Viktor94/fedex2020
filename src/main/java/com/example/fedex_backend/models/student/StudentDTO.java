package com.example.fedex_backend.models.student;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO {

  private String scriptCode;
  private String firstName;
  private String lastName;
}
