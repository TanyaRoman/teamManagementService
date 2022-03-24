package com.solutions.torneios.team_management_service.controller.api;

import com.solutions.torneios.team_management_service.persistence.entity.User;
import com.solutions.torneios.team_management_service.service.logic.UserService;
import com.solutions.torneios.team_management_service.service.model.UserDto;
import com.solutions.torneios.team_management_service.service.model.WorkoutDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/users")
@CrossOrigin

public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    private List<UserDto> readAll(){
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    private UserDto read(@PathVariable("id") UUID id){
        return userService.getUserById(id);
    }

    @DeleteMapping("/{id}")
    private void delete(@PathVariable("id") UUID id){
        userService.delete(id);
    }

    @PostMapping("/")
    private UserDto save(@RequestBody UserDto userDto){
        userService.saveOrUpdate(userDto);

        return userDto;
    }

    @PutMapping("/{id}")
    private UserDto update(@RequestBody UserDto userDto){
        userService.saveOrUpdate(userDto);
        return userDto;
    }

}
