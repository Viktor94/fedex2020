package com.example.fedex_backend.models.program;

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
public class Program {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;

    @Column(unique = true)
    private String programName;

    private Boolean isAllowed;

   public Program(ProgramDTO programDTO) {
        this.programName = programDTO.getProgramName();
        this.isAllowed = true;
    }
}
