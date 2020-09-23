package com.example.fedex_backend.services.program;

import com.example.fedex_backend.models.program.Program;
import com.example.fedex_backend.models.program.ProgramDTO;
import com.example.fedex_backend.models.student.Student;

import java.util.ArrayList;
import java.util.List;

public interface ProgramService {
    List<Program> getAllProgram();

    ArrayList<Program> savePrograms(Student student, List<ProgramDTO> programDTOlist);
}
