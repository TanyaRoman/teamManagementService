package com.solutions.torneios.team_management_service.service.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class WorkoutDto {
    private UUID id;

    private LocalDateTime startDate;


    private int period;


    private String place;


    private int numberOfPersons;


    private UUID teamId;


    private UUID userId;

    private List<UserDto> users;


    private SportTypeDto sportId;
    private boolean request;
}
