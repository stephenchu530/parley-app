package com.parley.parley.repository;

import com.parley.parley.models.Schedules;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.UUID;

public interface SchedulesRepository extends CrudRepository<Schedules, UUID> {
    Schedules findByDueDateOfInterview(Date dueDateOfInterview);
}
