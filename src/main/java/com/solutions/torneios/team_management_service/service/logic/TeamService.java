package com.solutions.torneios.team_management_service.service.logic;

import com.solutions.torneios.team_management_service.persistence.entity.Team;
import com.solutions.torneios.team_management_service.service.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class TeamService {

    private final
    TeamRepository teamRepository;

    @Autowired
    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    public List<Team> getAllTeams(){
        List<Team> teams = new ArrayList<Team>();
        teamRepository.findAll().forEach(team -> teams.add(team));
        return teams;
    }

    public Team getTeamById(UUID id){
        return teamRepository.findById(id).get();
    }

    public void saveOrUpdate(Team team){
        teamRepository.save(team);
    }

    public void delete(UUID id){
        teamRepository.deleteById(id);
    }

    public void update(Team team, UUID id){
        teamRepository.save(team);
    }
}
