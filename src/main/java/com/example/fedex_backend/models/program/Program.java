package com.example.fedex_backend.models.program;

import com.example.fedex_backend.models.student.Student;
import com.fasterxml.jackson.annotation.JsonBackReference;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
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
public class Program {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(unique = true)
  private String programName;

  @JsonBackReference
  @ManyToMany(cascade = { CascadeType.ALL })
  private List<Student> studentList = new ArrayList<>();

  private Boolean isAllowed;

  public Program(ProgramDTO programDTO) {
    this.programName = programDTO.getName();
    this.isAllowed = true;
  }

  public void addStudent(Student student) {
    this.studentList.add(student);
  }
}
