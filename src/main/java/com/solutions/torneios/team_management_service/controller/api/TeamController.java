package com.solutions.torneios.team_management_service.controller.api;

import com.solutions.torneios.team_management_service.persistence.entity.Team;
import com.solutions.torneios.team_management_service.persistence.entity.User;
import com.solutions.torneios.team_management_service.service.logic.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/teams")
public class TeamController {

    private final TeamService teamService;

    @Autowired
    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @GetMapping("/")
    private List<Team> getAllTeams(){
        return teamService.getAllTeams();
    }

    @GetMapping("/{id}")
    private Team getTeam(@PathVariable("id") UUID id){
        return teamService.getTeamById(id);
    }

    @DeleteMapping("/delete/{id}")
    private void deleteTeam(@PathVariable("id") UUID id){
        teamService.delete(id);
    }

    @PostMapping("/save")
    private UUID saveTeam(Team team){
        teamService.saveOrUpdate(team);
        return team.getId();
    }

    @PutMapping("/update")
    private Team update(Team team){
        teamService.saveOrUpdate(team);
        return team;
    }
}