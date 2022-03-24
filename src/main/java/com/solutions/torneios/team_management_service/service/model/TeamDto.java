package com.solutions.torneios.team_management_service.service.model;

import com.fasterxml.jackson.annotation.*;
import com.solutions.torneios.team_management_service.persistence.entity.Team;
import lombok.Getter;
import lombok.Setter;


import java.util.List;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class TeamDto {
    private UUID id;

    private String name;

    private int level;
    private UUID captainId;

    private List<UserDto> users;
}
