package com.solutions.torneios.team_management_service.controller.api;

import com.solutions.torneios.team_management_service.persistence.entity.UserPhoto;
import com.solutions.torneios.team_management_service.service.logic.UserPhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/userPhotos")
public class UserPhotoController {

    private final UserPhotoService userPhotoService;

    @Autowired
    public UserPhotoController(UserPhotoService userPhotoService) {
        this.userPhotoService = userPhotoService;
    }

    @GetMapping("/")
    private List<UserPhoto> readAll(){
        return userPhotoService.getAllUsersPhotos();
    }

    @GetMapping("/{id}")
    private UserPhoto read(@PathVariable("id") UUID id){
        return userPhotoService.getUserPhotoById(id);
    }

    @DeleteMapping("/{id}")
    private void delete(@PathVariable("id") UUID id){
        userPhotoService.delete(id);
    }

    @PostMapping("/")
    private UserPhoto save(@RequestBody UserPhoto userPhoto){
        userPhotoService.saveOrUpdate(userPhoto);
        return userPhoto;
    }

    @PutMapping("/")
    private UserPhoto update(@RequestBody UserPhoto userPhoto){
        userPhotoService.saveOrUpdate(userPhoto);
        return userPhoto;
    }
}
