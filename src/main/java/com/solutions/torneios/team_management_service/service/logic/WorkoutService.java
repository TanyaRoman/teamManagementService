package com.solutions.torneios.team_management_service.service.logic;

import com.solutions.torneios.team_management_service.persistence.entity.Workout;
import com.solutions.torneios.team_management_service.service.repository.WorkoutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class WorkoutService {

    private final
    WorkoutRepository workoutRepository;

    @Autowired
    public WorkoutService(WorkoutRepository workoutRepository) {
        this.workoutRepository = workoutRepository;
    }

    public List<Workout> getAllWorkouts(){
        List<Workout> workouts = new ArrayList<Workout>();
        workoutRepository.findAll().forEach(workout -> workouts.add(workout));
        return workouts;
    }

    public Workout getWorkoutById(UUID id){
        return workoutRepository.findById(id).get();
    }

    public void saveOrUpdate(Workout workout){
        workoutRepository.save(workout);
    }

    public void delete(UUID id){
        workoutRepository.deleteById(id);
    }

    public void update(Workout workout, UUID id){
        workoutRepository.save(workout);
    }
}
