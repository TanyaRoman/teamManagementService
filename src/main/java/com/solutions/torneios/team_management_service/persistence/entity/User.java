package com.solutions.torneios.team_management_service.persistence.entity;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@Entity

@Table(name = "users")

public class User {

    @Id
    @Column(name = "user_id")
    // @GeneratedValue//(strategy = GenerationType.IDENTITY)
    private UUID id;

    @Column(name = "role")
    private String role;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="user_id")
    private List<UserPhoto> photos;

    @ManyToMany(mappedBy = "users")
//@JsonIgnore
    private List<Team> teams;

    @ManyToMany(mappedBy = "users")
    private List<Workout> workouts ;



}
