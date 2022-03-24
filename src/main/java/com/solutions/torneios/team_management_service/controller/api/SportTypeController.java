package com.solutions.torneios.team_management_service.controller.api;

import com.solutions.torneios.team_management_service.persistence.entity.SportType;
import com.solutions.torneios.team_management_service.persistence.entity.User;
import com.solutions.torneios.team_management_service.service.logic.SportTypeService;
import com.solutions.torneios.team_management_service.service.model.SportTypeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/sportTypes")
@CrossOrigin
public class SportTypeController {

    private final SportTypeService sportTypeService;

    @Autowired
    public SportTypeController(SportTypeService sportTypeService) {
        this.sportTypeService = sportTypeService;
    }

    @GetMapping("/")
    private List<SportTypeDto> readAll(){
        return sportTypeService.getAllSportType();
    }

    @GetMapping("/{id}")
    private SportTypeDto read(@PathVariable("id") UUID id){
        return sportTypeService.getSportTypeById(id);
    }

    @DeleteMapping("/{id}")
    private void delete(@PathVariable("id") UUID id){
        sportTypeService.delete(id);
    }

    @PostMapping("/")
    private SportTypeDto create(@RequestBody SportTypeDto sportTypeDto){
        sportTypeService.saveOrUpdate(sportTypeDto);
        return sportTypeDto;
    }

    @PutMapping("/{id}")
    private SportTypeDto update(@RequestBody SportTypeDto sportTypeDto){
        sportTypeService.saveOrUpdate(sportTypeDto);
        return sportTypeDto;
    }
}
