package com.solutions.torneios.team_management_service.service.logic;

import com.solutions.torneios.team_management_service.persistence.entity.Workout;
import com.solutions.torneios.team_management_service.persistence.repository.WorkoutRepository;
import com.solutions.torneios.team_management_service.service.mapper.CycleAvoidingMappingContext;
import com.solutions.torneios.team_management_service.service.mapper.WorkoutMapper;
import com.solutions.torneios.team_management_service.service.model.WorkoutDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class WorkoutService {

    private final
    WorkoutRepository workoutRepository;
    private final
    WorkoutMapper workoutMapper;


    @Autowired
    public WorkoutService(WorkoutRepository workoutRepository,
                          WorkoutMapper workoutMapper) {
        this.workoutMapper = workoutMapper;
        this.workoutRepository = workoutRepository;
    }

    public List<WorkoutDto> getAllWorkouts() {
        List<WorkoutDto> workouts = new ArrayList<>();
        workoutRepository.findAll().forEach(workout -> workouts.add(workoutMapper.workoutToWorkoutDto(workout, new CycleAvoidingMappingContext())));

        return workouts;
    }

    public WorkoutDto getWorkoutById(UUID id) {
        Workout workout = workoutRepository.findById(id).get();

        return workoutMapper.workoutToWorkoutDto(workout, new CycleAvoidingMappingContext());
    }

    public void saveOrUpdate(WorkoutDto workoutDto) {
        Workout workout = workoutMapper.workoutDtoToWorkout(workoutDto);
        workoutRepository.save(workout);
    }

    public void delete(UUID id) {
        workoutRepository.deleteById(id);
    }

    public void update(WorkoutDto workoutDto, UUID id) {
        Workout workout = workoutMapper.workoutDtoToWorkout(workoutDto);
        workoutRepository.save(workout);
    }

//    public List<WorkoutDto> findByIsRequest(boolean isRequest) {
//        List<WorkoutDto> workouts = new ArrayList<>();
//        workoutRepository.findByIsRequest(isRequest).forEach(workout -> workouts.add(workoutMapper.workoutToWorkoutDto(workout, new CycleAvoidingMappingContext())));
//        return workouts;
//    }
//    public List<WorkoutDto> getRequests(){
//
//    }
}
