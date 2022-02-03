package com.solutions.torneios.team_management_service.persistence.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@Getter
@Setter
@Entity
public class UserPhoto {

    @Id
    @GeneratedValue//(strategy = GenerationType.IDENTITY)
    @Column(name = "photo_id")
    private UUID id;

    @Column(name = "photo")
    private String photo;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
