package com.solutions.torneios.team_management_service.persistence.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Getter
@Setter
@Entity
public class Workout {

    @Id
    @Column(name = "workout_id")
    @GeneratedValue//(strategy = GenerationType.IDENTITY)
    private UUID id;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "period")
    private int periond;

    @Column(name = "place")
    private String place;

    @Column(name = "number_of_persons")
    private int numberOfPersons;

    @OneToOne(mappedBy = "workout")
    private User user;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_workout",
            joinColumns = @JoinColumn(name = "workout_id", referencedColumnName = "workout_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id", referencedColumnName = "user_id"))
    @MapKeyJoinColumn(name = "users_map")
    private Map<Boolean, User> users;

    @ManyToOne
    @JoinColumn(name = "sport_id")
    private SportType sportId;
}
