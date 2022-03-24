package com.solutions.torneios.team_management_service.controller.api;

import com.solutions.torneios.team_management_service.persistence.entity.UserPhoto;
import com.solutions.torneios.team_management_service.service.logic.UserPhotoService;
import com.solutions.torneios.team_management_service.service.model.UserPhotoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/userPhotos")
@CrossOrigin

public class UserPhotoController {

    private final UserPhotoService userPhotoService;

    @Autowired
    public UserPhotoController(UserPhotoService userPhotoService) {
        this.userPhotoService = userPhotoService;
    }

    @GetMapping("/")
    private List<UserPhotoDto> readAll(){
        return userPhotoService.getAllUsersPhotos();
    }

    @GetMapping("/{id}")
    private UserPhotoDto read(@PathVariable("id") UUID id){
        return userPhotoService.getUserPhotoById(id);
    }

    @DeleteMapping("/{id}")
    private void delete(@PathVariable("id") UUID id){
        userPhotoService.delete(id);
    }

    @PostMapping("/")
    private UserPhotoDto save(@RequestBody UserPhotoDto userPhotoDto){
        userPhotoService.saveOrUpdate(userPhotoDto);
        return userPhotoDto;
    }

    @PutMapping("/")
    private UserPhotoDto update(@RequestBody UserPhotoDto userPhotoDto){
        userPhotoService.saveOrUpdate(userPhotoDto);
        return userPhotoDto;
    }
}
