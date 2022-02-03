package com.solutions.torneios.team_management_service.service.logic;

import com.solutions.torneios.team_management_service.persistence.entity.SportType;
import com.solutions.torneios.team_management_service.service.repository.SportTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class SportTypeService {

    private final
    SportTypeRepository sportTypeRepository;

    @Autowired
    public SportTypeService(SportTypeRepository sportTypeRepository) {
        this.sportTypeRepository = sportTypeRepository;
    }

    public List<SportType> getAllSportType(){
        List<SportType> sportTypes = new ArrayList<SportType>();
        sportTypeRepository.findAll().forEach(sportType -> sportTypes.add(sportType));
        return sportTypes;
    }

    public SportType getSportTypeById(UUID id){
        return sportTypeRepository.findById(id).get();
    }

    public void saveOrUpdate(SportType sportType){
        sportTypeRepository.save(sportType);
    }

    public void delete(UUID id){
        sportTypeRepository.deleteById(id);
    }

    public void update(SportType sportType, UUID id){
        sportTypeRepository.save(sportType);
    }
}
