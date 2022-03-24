package com.solutions.torneios.team_management_service.service.logic;

import com.solutions.torneios.team_management_service.persistence.entity.Team;
import com.solutions.torneios.team_management_service.persistence.repository.TeamRepository;
import com.solutions.torneios.team_management_service.service.mapper.CycleAvoidingMappingContext;
import com.solutions.torneios.team_management_service.service.mapper.TeamMapper;
import com.solutions.torneios.team_management_service.service.model.TeamDto;
import com.solutions.torneios.team_management_service.service.model.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class TeamService {

    private final
    TeamRepository teamRepository;
    private final
    TeamMapper teamMapper;

    @Autowired
    public TeamService(TeamRepository teamRepository,TeamMapper teamMapper) {
        this.teamMapper=teamMapper;
        this.teamRepository = teamRepository;
    }

    public List<TeamDto> getAllTeams(){
//        List<Team> teams = new ArrayList<>();
//        teamRepository.findAll().forEach(team -> teams.add(team));
//
//        return teamMapper.listTeamToListTeamDto(teams);
        final  List<TeamDto> teams = new ArrayList<>();
        teamRepository.findAll().forEach(team -> {
            teams.add(teamMapper.teamToTeamDto(team,new CycleAvoidingMappingContext()));
        });
        return teams;
    }

    public TeamDto getTeamById(UUID id){
        Team team=teamRepository.findById(id).get();

        return teamMapper.teamToTeamDto(team,new CycleAvoidingMappingContext());
    }

    public void saveOrUpdate(TeamDto teamDto){
        Team team=teamMapper.teamDtoToTeam(teamDto);
        teamRepository.save(team);
    }

    public void delete(UUID id){
        teamRepository.deleteById(id);
    }

    public void update(TeamDto teamDto, UUID id){
        Team team=teamMapper.teamDtoToTeam(teamDto);
        teamRepository.save(team);
    }
}
