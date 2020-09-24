package com.example.fedex_backend.repositories;

import com.example.fedex_backend.models.ProgramCpuUsage;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProgramCpuUsageRepository extends CrudRepository<ProgramCpuUsage, Long> {

}
