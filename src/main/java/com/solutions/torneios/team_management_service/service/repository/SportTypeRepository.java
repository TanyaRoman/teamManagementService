package com.solutions.torneios.team_management_service.service.repository;

import com.solutions.torneios.team_management_service.persistence.entity.SportType;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface SportTypeRepository extends CrudRepository<SportType, UUID> {

}
