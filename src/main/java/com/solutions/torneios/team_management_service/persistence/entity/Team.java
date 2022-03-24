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
@Table(name = "teams")

public class Team {

    @Id
    @Column(name = "team_id")
    @GeneratedValue//(strategy = GenerationType.IDENTITY)
    private UUID id;

    @Column(name = "name")
    private String name;

    @Column(name = "level")
    private int level;

    @Column(name = "captain_id")
    private UUID captainId;

    @ManyToMany(cascade = CascadeType.ALL)

//    @JoinTable(name = "user_team",
//            joinColumns = @JoinColumn(name = "team_id", referencedColumnName = "team_id"),
//            inverseJoinColumns = @JoinColumn(name = "user_id", referencedColumnName = "user_id"))
    private List<User> users;

}
