package com.solutions.torneios.team_management_service.service.mapper;

import com.solutions.torneios.team_management_service.persistence.entity.SportType;
import com.solutions.torneios.team_management_service.service.model.SportTypeDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface SportTypeMapper {
    SportTypeDto sportTypeToSportTypeDto(SportType entity);
    SportType sportTypeDtoToSportType(SportTypeDto dto);
    //List<SportTypeDto> listSportTypeToListSportTypeDto(List<SportType> entities);
}
