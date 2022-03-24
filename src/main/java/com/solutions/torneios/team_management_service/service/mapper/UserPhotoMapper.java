package com.solutions.torneios.team_management_service.service.mapper;


import com.solutions.torneios.team_management_service.persistence.entity.UserPhoto;
import com.solutions.torneios.team_management_service.service.model.UserPhotoDto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface UserPhotoMapper {
    @InheritInverseConfiguration
    UserPhotoDto userPhotoToUserPhotoDto(UserPhoto entity);
    UserPhoto userPhotoDtoToUserPhoto(UserPhotoDto dto);
    //List<UserPhotoDto> listUserPhotoToListUserPhotoDto(List<UserPhoto> entities);
}
