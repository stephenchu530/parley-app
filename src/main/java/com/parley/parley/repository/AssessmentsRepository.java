package com.parley.parley.repository;

import com.parley.parley.models.Assessments;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.UUID;

public interface AssessmentsRepository extends CrudRepository<Assessments, UUID> {
    Assessments findByDateOfInterview(Date dateOfInterview);
}
