package com.example.fedex_backend.repositories;

import com.example.fedex_backend.models.program.Program;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProgramRepository extends CrudRepository<Program, Long> {

  Optional<Program> findByProgramName(String programName);
}
