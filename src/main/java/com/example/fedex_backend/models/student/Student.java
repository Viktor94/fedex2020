package com.example.fedex_backend.models.student;

import java.util.Date;
import java.util.List;

import com.example.fedex_backend.models.program.Program;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Student {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(nullable = false, updatable = false)
  private Long id;

  @Column(unique = true)
  private String scriptCode;

  @ManyToMany
  private List<Program> programs;

  private String firstName;
  private String lastName;
  private Date date;
  private Boolean suspicious = false;
}
