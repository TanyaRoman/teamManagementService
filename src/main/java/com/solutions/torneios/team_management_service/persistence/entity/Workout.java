package com.solutions.torneios.team_management_service.persistence.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "workouts")

public class Workout {

    @Id
    @Column(name = "workout_id")
    @GeneratedValue//(strategy = GenerationType.IDENTITY)
    private UUID id;

    @Column(name = "start_date")
    private LocalDateTime startDate;

    @Column(name = "period")
    private int period;

    @Column(name = "place")
    private String place;

    @Column(name = "number_of_persons")
    private int numberOfPersons;

    @Column(name = "team_id")
    private UUID teamId;

    @Column(name = "user_id")//,nullable = false)
    private UUID userId;

    @ManyToMany
//    @JoinTable(name = "user_workout",
//            joinColumns = @JoinColumn(name = "workout_id", referencedColumnName = "workout_id"),
//            inverseJoinColumns = @JoinColumn(name = "user_id", referencedColumnName = "user_id"))
    private List<User> users;

    @ManyToOne
    private SportType sportId;
    private boolean request;

}
