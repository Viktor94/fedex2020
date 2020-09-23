package com.example.fedex_backend.services.program;

import com.example.fedex_backend.models.program.Program;
import com.example.fedex_backend.models.program.ProgramDTO;
import com.example.fedex_backend.repositories.ProgramRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProgramServiceImpl implements ProgramService {

    private final ProgramRepository programRepository;

    @Autowired
    public ProgramServiceImpl(ProgramRepository programRepository) {
        this.programRepository = programRepository;
    }

    @Override
    public List<Program> getAllProgram() {
        return (List<Program>) programRepository.findAll();
    }

    @Override
    public void savePrograms(List<ProgramDTO> programDTOlist) {
        ArrayList<Program> programList = new ArrayList<>();
        for (ProgramDTO programDTO: programDTOlist) {
            Program program = new Program(programDTO);
            if (programRepository.findByProgramName(program.getProgramName()).isEmpty()){
                programList.add(program);
            }
        }
        programRepository.saveAll(programList);
    }


}
