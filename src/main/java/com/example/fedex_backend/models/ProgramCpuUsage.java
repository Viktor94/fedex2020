package com.example.fedex_backend.models;

import com.example.fedex_backend.models.program.CpuDTO;
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

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class ProgramCpuUsage {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;
  private Double cpuUsage;

  @JsonBackReference
  @ManyToOne
  private Student student;

  public ProgramCpuUsage(CpuDTO cpuDTO) {
    this.name = cpuDTO.getName();
    this.cpuUsage = cpuDTO.getCpuUsage();
  }
}
