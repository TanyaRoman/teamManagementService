package com.solutions.torneios.team_management_service.service.model;


import lombok.Getter;
import lombok.Setter;

import java.util.UUID;
@Getter
@Setter
public class UserPhotoDto {
    private UUID id;


    private String photo;


    private UUID user;
}
