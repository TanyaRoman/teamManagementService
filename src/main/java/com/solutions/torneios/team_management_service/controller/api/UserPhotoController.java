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
    private List<UserPhoto> getAllUserPhotos(){
        return userPhotoService.getAllUsersPhotos();
    }

    @GetMapping("/{id}")
    private UserPhoto getUserPhoto(@PathVariable("id") UUID id){
        return userPhotoService.getUserPhotoById(id);
    }

    @DeleteMapping("/delete/{id}")
    private void deleteUserPhoto(@PathVariable("id") UUID id){
        userPhotoService.delete(id);
    }

    @PostMapping("/")
    private UUID saveUserPhoto(UserPhoto userPhoto){
        userPhotoService.saveOrUpdate(userPhoto);
        return userPhoto.getId();
    }

    @PutMapping("/")
    private UserPhoto update(UserPhoto userPhoto){
        userPhotoService.saveOrUpdate(userPhoto);
        return userPhoto;
    }
}
