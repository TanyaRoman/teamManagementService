package com.solutions.torneios.team_management_service.persistence.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "sport_types")
public class SportType {

    @Id
    @GeneratedValue//(strategy = GenerationType.IDENTITY)
    @Column(name = "sport_id")
    private UUID id;

    @Column(name = "name")
    private String name;


}
