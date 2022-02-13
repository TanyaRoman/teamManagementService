package com.solutions.torneios.team_management_service.persistence.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User {

    @Id
    @Column(name = "user_id")
    @GeneratedValue//(strategy = GenerationType.IDENTITY)
    private UUID id;

    @Column(name = "role")
    private String role;

    @OneToMany(mappedBy = "user")
    private List<UserPhoto> photos;

    @ManyToMany
    private List<Team> teams;

    @ManyToMany
    private List<Workout> workouts;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinTable(name = "user_workout",
            joinColumns =
                    { @JoinColumn(name = "user_id", referencedColumnName = "user_id") },
            inverseJoinColumns =
                    { @JoinColumn(name = "workout_id", referencedColumnName = "workout_id") })
    private Workout workout;
}
