package com.solutions.torneios.team_management_service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestHelloWorld {

    @GetMapping("/")
    @ResponseBody
    public String index(){
        return "Hello World)";
    }
}
