package com.example.fedex_backend.models.student;

import com.example.fedex_backend.models.ProgramCpuUsage;
import com.example.fedex_backend.models.ProgramMemoryUsage;
import com.example.fedex_backend.models.program.Program;
import com.fasterxml.jackson.annotation.JsonBackReference;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
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

  @ManyToMany(mappedBy = "studentList")
  private List<Program> programs = new ArrayList<>();

  @OneToMany(mappedBy = "student")
  private List<ProgramCpuUsage> programCpuUsages = new ArrayList<>();

  @OneToMany(mappedBy = "student")
  private List<ProgramMemoryUsage> programMemoryUsages = new ArrayList<>();

  private String firstName;
  private String lastName;
  private Date date;
  private Integer kppm;
  private Integer cursorTravelDistance;
  private Integer buttonsPressed;
  private Integer scrollWheelActivity;

  @Column(columnDefinition = "boolean default false")
  private Boolean suspicious;

  public Student(StudentDTO studentDTO) {
    this.scriptCode = studentDTO.getScriptCode();
    this.firstName = studentDTO.getFirstName();
    this.lastName = studentDTO.getLastName();
  }

  public void setMU(
      Integer cursorTravelDistance, Integer buttonsPressed, Integer scrollWheelActivity) {
    this.cursorTravelDistance = cursorTravelDistance;
    this.buttonsPressed = buttonsPressed;
    this.scrollWheelActivity = scrollWheelActivity;
  }
}
