package com.solutions.torneios.team_management_service.controller.api;

import com.solutions.torneios.team_management_service.persistence.entity.User;
import com.solutions.torneios.team_management_service.service.logic.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    private List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    private User getUser(@PathVariable("id") UUID id){
        return userService.getUserById(id);
    }

    @DeleteMapping("/delete/{id}")
    private void deleteUser(@PathVariable("id") UUID id){
        userService.delete(id);
    }

    @PostMapping("/save")
    private UUID saveUser(User user){
        userService.saveOrUpdate(user);
        return user.getId();
    }

    @PutMapping("/update")
    private User update(User user){
        userService.saveOrUpdate(user);
        return user;
    }
}
