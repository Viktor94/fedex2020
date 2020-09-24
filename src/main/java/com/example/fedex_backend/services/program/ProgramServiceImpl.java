package com.example.fedex_backend.services.program;

import com.example.fedex_backend.exceptions.ProgramException;
import com.example.fedex_backend.exceptions.ProgramNotFoundByIdException;
import com.example.fedex_backend.models.program.Program;
import com.example.fedex_backend.models.program.ProgramDTO;
import com.example.fedex_backend.models.program.ProgramUpdateDTO;
import com.example.fedex_backend.models.student.Student;
import com.example.fedex_backend.repositories.ProgramRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
  public ArrayList<Program> savePrograms(Student student, List<ProgramDTO> programDTOlist) {
    ArrayList<Program> programList = new ArrayList<>();
    for (ProgramDTO programDTO : programDTOlist) {
      Program program = new Program(programDTO);
      if (programRepository.findByProgramName(program.getProgramName()).isEmpty()) {
        program.addStudent(student);
        programList.add(program);
      }
    }
    programRepository.saveAll(programList);
    return programList;
  }

  @Override
  public void updateProgramSuspicion(Long id, ProgramUpdateDTO programUpdateDTO) throws ProgramException {
    Program program = programRepository.findById(id).orElse(null);
    if (program!=null) {
      program.setIsAllowed(programUpdateDTO.getIsAllowed());
      programRepository.save(program);
    } else {
      throw new ProgramNotFoundByIdException("User not found with the provided id: " + id);
    }

  }
}
