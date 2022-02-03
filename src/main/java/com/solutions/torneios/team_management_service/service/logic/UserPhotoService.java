package com.solutions.torneios.team_management_service.service.logic;

import com.solutions.torneios.team_management_service.persistence.entity.UserPhoto;
import com.solutions.torneios.team_management_service.service.repository.UserPhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UserPhotoService {

    private final
    UserPhotoRepository userPhotoRepository;

    @Autowired
    public UserPhotoService(UserPhotoRepository userPhotoRepository) {
        this.userPhotoRepository = userPhotoRepository;
    }

    public List<UserPhoto> getAllUsersPhotos(){
        List<UserPhoto> userPhotos = new ArrayList<UserPhoto>();
        userPhotoRepository.findAll().forEach(userPhoto -> userPhotos.add(userPhoto));
        return userPhotos;
    }

    public UserPhoto getUserPhotoById(UUID id){
        return userPhotoRepository.findById(id).get();
    }

    public void saveOrUpdate(UserPhoto userPhoto){
        userPhotoRepository.save(userPhoto);
    }

    public void delete(UUID id){
        userPhotoRepository.deleteById(id);
    }

    public void update(UserPhoto userPhoto, UUID id){
        userPhotoRepository.save(userPhoto);
    }
}
