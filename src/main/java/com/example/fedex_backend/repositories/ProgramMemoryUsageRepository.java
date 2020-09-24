package com.example.fedex_backend.repositories;

import com.example.fedex_backend.models.ProgramMemoryUsage;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProgramMemoryUsageRepository extends CrudRepository<ProgramMemoryUsage, Long> {}
