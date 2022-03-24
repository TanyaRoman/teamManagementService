package com.solutions.torneios.team_management_service.persistence.repository;

import com.solutions.torneios.team_management_service.persistence.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface UserRepository extends CrudRepository<User, UUID> {

}
