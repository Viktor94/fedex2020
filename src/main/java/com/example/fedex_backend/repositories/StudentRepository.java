package com.example.fedex_backend.repositories;

import com.example.fedex_backend.models.student.Student;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {

  Optional<Student> findByScriptCode(String scriptCode);
}
