package com.example.fedex_backend.services.program;

import com.example.fedex_backend.models.program.Program;
import com.example.fedex_backend.models.program.ProgramDTO;

import java.util.List;

public interface ProgramService {
    List<Program> getAllProgram();
    void savePrograms (List<ProgramDTO> programDTOlist);
}