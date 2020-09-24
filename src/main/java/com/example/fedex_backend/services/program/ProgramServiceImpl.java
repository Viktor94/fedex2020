package com.example.fedex_backend.services.program;

import com.example.fedex_backend.exceptions.ProgramException;
import com.example.fedex_backend.exceptions.ProgramNotFoundByIdException;
import com.example.fedex_backend.models.ProgramCpuUsage;
import com.example.fedex_backend.models.ProgramMemoryUsage;
import com.example.fedex_backend.models.program.CpuDTO;
import com.example.fedex_backend.models.program.Program;
import com.example.fedex_backend.models.program.ProgramDTO;
import com.example.fedex_backend.models.program.ProgramUpdateDTO;
import com.example.fedex_backend.models.student.Student;
import com.example.fedex_backend.repositories.ProgramCpuUsageRepository;
import com.example.fedex_backend.repositories.ProgramMemoryUsageRepository;
import com.example.fedex_backend.repositories.ProgramRepository;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProgramServiceImpl implements ProgramService {

  private final ProgramRepository programRepository;
  private final Logger LOGGER;
  private final ProgramCpuUsageRepository programCpuUsageRepository;
  private final ProgramMemoryUsageRepository programMemoryUsageRepository;

  @Autowired
  public ProgramServiceImpl(
      ProgramRepository programRepository,
      Logger logger,
      ProgramCpuUsageRepository programCpuUsageRepository,
      ProgramMemoryUsageRepository programMemoryUsageRepository) {
    this.programRepository = programRepository;
    this.LOGGER = logger;
    this.programCpuUsageRepository = programCpuUsageRepository;
    this.programMemoryUsageRepository = programMemoryUsageRepository;
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
  public void updateProgramSuspicion(Long id, ProgramUpdateDTO programUpdateDTO)
      throws ProgramException {
    Program program = programRepository.findById(id).orElse(null);
    if (program != null) {
      program.setIsAllowed(programUpdateDTO.getIsAllowed());
      programRepository.save(program);
    } else {
      LOGGER.info("User not found with the provided id: " + id);
      throw new ProgramNotFoundByIdException("User not found with the provided id: " + id);
    }
  }

  @Override
  public void saveProgramMemoryUsage(Student student, List<ProgramDTO> programDTOlist) {
    programMemoryUsageRepository.deleteAll(student.getProgramMemoryUsages());
    ArrayList<ProgramMemoryUsage> programMemoryUsageList = new ArrayList<>();
    for (ProgramDTO programDTO : programDTOlist) {
      ProgramMemoryUsage programMemoryUsage = new ProgramMemoryUsage(programDTO);
      programMemoryUsage.setStudent(student);
      programMemoryUsageList.add(programMemoryUsage);
    }
    programMemoryUsageRepository.saveAll(programMemoryUsageList);
  }

  @Override
  public void saveProgramCpuUsage(Student student, List<CpuDTO> cpuDTOList) {
    programCpuUsageRepository.deleteAll(student.getProgramCpuUsages());
    ArrayList<ProgramCpuUsage> programMemoryUsageList = new ArrayList<>();
    for (CpuDTO cpuDTO : cpuDTOList) {
      ProgramCpuUsage programCpuUsage = new ProgramCpuUsage(cpuDTO);
      programCpuUsage.setStudent(student);
      programMemoryUsageList.add(programCpuUsage);
    }
    programCpuUsageRepository.saveAll(programMemoryUsageList);
  }
}
