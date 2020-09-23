package com.example.fedex_backend.models.program;

import com.example.fedex_backend.models.student.Student;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

    @ManyToMany
    private List<Student> studentList = new ArrayList<>();

    private Boolean isAllowed;

    public Program(ProgramDTO programDTO) {
        this.programName = programDTO.getProgramName();
        this.isAllowed = true;
    }

    public void addStudent(Student student) {
        this.studentList.add(student);
    }
}
