package com.solutions.torneios.team_management_service.persistence.repository;

import com.solutions.torneios.team_management_service.persistence.entity.Workout;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface WorkoutRepository extends CrudRepository<Workout, UUID> {
   // List<Workout> findByIsRequest(boolean isRequest);


}
