package com.solutions.torneios.team_management_service.service.mapper;


import com.solutions.torneios.team_management_service.persistence.entity.Team;
import com.solutions.torneios.team_management_service.service.model.TeamDto;
import org.mapstruct.Context;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper()
public interface TeamMapper {
    @InheritInverseConfiguration
    TeamDto teamToTeamDto(Team entity,@Context CycleAvoidingMappingContext context);
    Team teamDtoToTeam(TeamDto dto);
    //List<TeamDto> listTeamToListTeamDto(List<Team> entities);
}
