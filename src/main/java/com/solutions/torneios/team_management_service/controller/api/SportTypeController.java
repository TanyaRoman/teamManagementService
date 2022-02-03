package com.solutions.torneios.team_management_service.controller.api;

import com.solutions.torneios.team_management_service.persistence.entity.SportType;
import com.solutions.torneios.team_management_service.persistence.entity.User;
import com.solutions.torneios.team_management_service.service.logic.SportTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/sportTypes")
public class SportTypeController {

    private final SportTypeService sportTypeService;

    @Autowired
    public SportTypeController(SportTypeService sportTypeService) {
        this.sportTypeService = sportTypeService;
    }

    @GetMapping("/")
    private List<SportType> getAllSportTypes(){
        return sportTypeService.getAllSportType();
    }

    @GetMapping("/{id}")
    private SportType getSportType(@PathVariable("id") UUID id){
        return sportTypeService.getSportTypeById(id);
    }

    @DeleteMapping("/delete/{id}")
    private void deleteSportType(@PathVariable("id") UUID id){
        sportTypeService.delete(id);
    }

    @PostMapping("/save")
    private UUID saveSportType(SportType sportType){
        sportTypeService.saveOrUpdate(sportType);
        return sportType.getId();
    }

    @PutMapping("/update")
    private SportType update(SportType sportType){
        sportTypeService.saveOrUpdate(sportType);
        return sportType;
    }
}
