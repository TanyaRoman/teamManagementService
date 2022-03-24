package com.solutions.torneios.team_management_service.persistence.repository;

import com.solutions.torneios.team_management_service.persistence.entity.UserPhoto;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface UserPhotoRepository extends CrudRepository<UserPhoto, UUID> {

}
