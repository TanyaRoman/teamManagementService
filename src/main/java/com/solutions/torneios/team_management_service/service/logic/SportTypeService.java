package com.solutions.torneios.team_management_service.service.logic;

import com.solutions.torneios.team_management_service.persistence.entity.SportType;
import com.solutions.torneios.team_management_service.persistence.repository.SportTypeRepository;
import com.solutions.torneios.team_management_service.service.mapper.SportTypeMapper;
import com.solutions.torneios.team_management_service.service.model.SportTypeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class SportTypeService {

    private final
    SportTypeRepository sportTypeRepository;
    private final
    SportTypeMapper sportTypeMapper;

    @Autowired
    public SportTypeService(SportTypeRepository sportTypeRepository,
                            SportTypeMapper sportTypeMapper) {
        this.sportTypeRepository = sportTypeRepository;
        this.sportTypeMapper=sportTypeMapper;
    }

    public List<SportTypeDto> getAllSportType(){
        List<SportTypeDto> sportTypes = new ArrayList<>();
        sportTypeRepository.findAll().forEach(sportType -> sportTypes.add(sportTypeMapper.sportTypeToSportTypeDto(sportType)));
        return sportTypes;

    }

    public SportTypeDto getSportTypeById(UUID id){
        SportType st= sportTypeRepository.findById(id).get();
        return sportTypeMapper.sportTypeToSportTypeDto(st);
    }

    public void saveOrUpdate(SportTypeDto sportTypeDto)
    {
        SportType sportType=sportTypeMapper.sportTypeDtoToSportType(sportTypeDto);
        sportTypeRepository.save(sportType);
    }

    public void delete(UUID id){
        sportTypeRepository.deleteById(id);
    }

    public void update(SportTypeDto sportTypeDto, UUID id){
        SportType sportType=sportTypeMapper.sportTypeDtoToSportType(sportTypeDto);
        sportTypeRepository.save(sportType);
    }
}
