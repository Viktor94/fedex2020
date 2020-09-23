package com.example.fedex_backend.repositories;

import com.example.fedex_backend.models.program.Program;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProgramRepository extends CrudRepository<Program, Long> {
    boolean findByProgramName(String programName);
}
