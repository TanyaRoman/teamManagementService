package com.solutions.torneios.team_management_service.service.logic;

import com.solutions.torneios.team_management_service.persistence.entity.UserPhoto;
import com.solutions.torneios.team_management_service.persistence.repository.UserPhotoRepository;
import com.solutions.torneios.team_management_service.service.mapper.UserPhotoMapper;
import com.solutions.torneios.team_management_service.service.model.UserPhotoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UserPhotoService {

    private final
    UserPhotoRepository userPhotoRepository;
    private final
    UserPhotoMapper userPhotoMapper;
    @Autowired
    public UserPhotoService(UserPhotoRepository userPhotoRepository,
                            UserPhotoMapper userPhotoMapper) {
        this.userPhotoRepository = userPhotoRepository;
        this.userPhotoMapper=userPhotoMapper;
    }

    public List<UserPhotoDto> getAllUsersPhotos(){
        List<UserPhotoDto> userPhotos = new ArrayList<>();
        userPhotoRepository.findAll().forEach(userPhoto -> userPhotos.add(userPhotoMapper.userPhotoToUserPhotoDto(userPhoto)));
        return userPhotos;
    }

    public UserPhotoDto getUserPhotoById(UUID id){

        UserPhoto userPhoto= userPhotoRepository.findById(id).get();
        return userPhotoMapper.userPhotoToUserPhotoDto(userPhoto);
    }

    public void saveOrUpdate(UserPhotoDto userPhotoDto){
        UserPhoto userPhoto=userPhotoMapper.userPhotoDtoToUserPhoto(userPhotoDto);
        userPhotoRepository.save(userPhoto);
    }

    public void delete(UUID id){
        userPhotoRepository.deleteById(id);
    }

    public void update(UserPhotoDto userPhotoDto, UUID id){
        UserPhoto userPhoto=userPhotoMapper.userPhotoDtoToUserPhoto(userPhotoDto);
        userPhotoRepository.save(userPhoto);
    }
}
