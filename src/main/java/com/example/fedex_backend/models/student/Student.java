package com.example.fedex_backend.models.student;

import com.example.fedex_backend.models.program.Program;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Student {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(unique = true)
  private String scriptCode;

  @ManyToMany
  private List<Program> programs = new ArrayList<>();

  private String firstName;
  private String lastName;
  private Date date;

  @Column(columnDefinition = "boolean default false")
  private Boolean suspicious;

  public Student(StudentDTO studentDTO) {
    this.scriptCode = studentDTO.getScriptCode();
    this.firstName = studentDTO.getFirstName();
    this.lastName = studentDTO.getLastName();
  }
}
