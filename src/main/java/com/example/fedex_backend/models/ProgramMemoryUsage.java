package com.example.fedex_backend.models;

import com.example.fedex_backend.models.program.ProgramDTO;
import com.example.fedex_backend.models.student.Student;
import com.fasterxml.jackson.annotation.JsonBackReference;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProgramMemoryUsage {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;
  private Double memory;
  @JsonBackReference
  @ManyToOne
  private Student student;

  public ProgramMemoryUsage(ProgramDTO programDTO) {
    this.name = programDTO.getName();
    this.memory = programDTO.getMemory();
  }
}
