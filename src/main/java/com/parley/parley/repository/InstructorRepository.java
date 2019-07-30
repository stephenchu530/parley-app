package com.parley.parley.repository;

import com.parley.parley.models.Instructor;
import org.springframework.data.repository.CrudRepository;

public interface InstructorRepository extends CrudRepository<Instructor, Long> {
    Instructor findByUsername(String username);
}
