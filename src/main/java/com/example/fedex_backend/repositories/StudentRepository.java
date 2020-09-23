package com.example.fedex_backend.repositories;

import com.example.fedex_backend.models.student.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {

    Optional<Student> findByScriptCode(String scriptCode);
}
