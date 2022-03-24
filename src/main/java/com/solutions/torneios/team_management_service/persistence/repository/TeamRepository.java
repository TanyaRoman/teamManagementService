package com.solutions.torneios.team_management_service.persistence.repository;

import com.solutions.torneios.team_management_service.persistence.entity.Team;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface TeamRepository extends CrudRepository<Team, UUID> {

}
