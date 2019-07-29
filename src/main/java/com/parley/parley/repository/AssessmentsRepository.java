package com.parley.parley.repository;

import com.parley.parley.models.Assessments;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;


public interface AssessmentsRepository extends CrudRepository<Assessments, Long> {
    Assessments findByDateOfInterview(Date dateOfInterview);
}
