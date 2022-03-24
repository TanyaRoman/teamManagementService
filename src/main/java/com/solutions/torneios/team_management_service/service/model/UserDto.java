package com.solutions.torneios.team_management_service.service.model;

import com.fasterxml.jackson.annotation.*;
import com.solutions.torneios.team_management_service.persistence.entity.User;
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
public class UserDto {
    private UUID id;

    private String role;

    private List<UserPhotoDto> photos;
    //@JsonIgnore
    private List<TeamDto> teams;

    private List<WorkoutDto> workouts;

}
