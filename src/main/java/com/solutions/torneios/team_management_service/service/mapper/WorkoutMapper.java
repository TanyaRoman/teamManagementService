package com.solutions.torneios.team_management_service.service.mapper;


import com.solutions.torneios.team_management_service.persistence.entity.Workout;
import com.solutions.torneios.team_management_service.service.model.WorkoutDto;
import org.mapstruct.Context;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface WorkoutMapper {
    @InheritInverseConfiguration
    WorkoutDto workoutToWorkoutDto(Workout entity,@Context CycleAvoidingMappingContext context);
    Workout workoutDtoToWorkout(WorkoutDto dto);
   // List<WorkoutDto> listWorkoutToListWorkoutDto(List<Workout> entities);
}
