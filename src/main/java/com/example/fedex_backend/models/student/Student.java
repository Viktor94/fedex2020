package com.example.fedex_backend.models.student;

import com.example.fedex_backend.models.program.Program;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
    private Boolean suspicious = false;

    public Student(StudentDTO studentDTO) {
        this.scriptCode = studentDTO.getScriptCode();
        this.firstName = studentDTO.getFirstName();
        this.lastName = studentDTO.getLastName();
    }
}
