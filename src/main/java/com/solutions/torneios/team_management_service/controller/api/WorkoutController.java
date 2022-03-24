package com.solutions.torneios.team_management_service.controller.api;

import com.solutions.torneios.team_management_service.persistence.entity.User;
import com.solutions.torneios.team_management_service.persistence.entity.Workout;
import com.solutions.torneios.team_management_service.service.logic.WorkoutService;
import com.solutions.torneios.team_management_service.service.model.WorkoutDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/workouts")
@CrossOrigin

public class WorkoutController {

    private final WorkoutService workoutService;

    @Autowired
    public WorkoutController(WorkoutService workoutService) {
        this.workoutService = workoutService;
    }

    @GetMapping("/")
    private List<WorkoutDto> readAll(){
        return workoutService.getAllWorkouts();
    }

    @GetMapping("/{id}")
    private WorkoutDto read(@PathVariable("id") UUID id){
        return workoutService.getWorkoutById(id);
    }

    @DeleteMapping("/{id}")
    private void delete(@PathVariable("id") UUID id){
        workoutService.delete(id);
    }

    @PostMapping("/")
    private WorkoutDto save(@RequestBody WorkoutDto workoutDto){
        workoutService.saveOrUpdate(workoutDto);
        return workoutDto;
    }

    @PutMapping("/{id}")
    private WorkoutDto update(@RequestBody WorkoutDto workoutDto){
        workoutService.saveOrUpdate(workoutDto);
        return workoutDto;
    }
//    @GetMapping("/requests/{isrequest}")
//    private List<WorkoutDto> getByIsRequest(@PathVariable("isrequest") boolean isrequest){
//        return workoutService.findByIsRequest(isrequest);
//    }
}
