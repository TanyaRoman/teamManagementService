package com.solutions.torneios.team_management_service.controller.api;

import com.solutions.torneios.team_management_service.persistence.entity.User;
import com.solutions.torneios.team_management_service.persistence.entity.Workout;
import com.solutions.torneios.team_management_service.service.logic.WorkoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/workouts")
public class WorkoutController {

    private final WorkoutService workoutService;

    @Autowired
    public WorkoutController(WorkoutService workoutService) {
        this.workoutService = workoutService;
    }

    @GetMapping("/all")
    private List<Workout> getAllWorkout(){
        return workoutService.getAllWorkouts();
    }

    @GetMapping("/{id}")
    private Workout getWorkout(@PathVariable("id") UUID id){
        return workoutService.getWorkoutById(id);
    }

    @DeleteMapping("/delete/{id}")
    private void deleteWorkout(@PathVariable("id") UUID id){
        workoutService.delete(id);
    }

    @PostMapping("/save")
    private UUID saveWorkout(Workout workout){
        workoutService.saveOrUpdate(workout);
        return workout.getId();
    }

    @PutMapping("/update")
    private Workout update(Workout workout){
        workoutService.saveOrUpdate(workout);
        return workout;
    }
}
