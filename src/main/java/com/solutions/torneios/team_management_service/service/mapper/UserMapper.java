package com.solutions.torneios.team_management_service.service.mapper;


import com.solutions.torneios.team_management_service.persistence.entity.User;
import com.solutions.torneios.team_management_service.service.model.UserDto;
import org.mapstruct.Context;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(uses={TeamMapper.class,WorkoutMapper.class,UserPhotoMapper.class})
public interface UserMapper {
    UserDto UserToUserDto(User entity,@Context CycleAvoidingMappingContext context);
    User UserDtoToUser(UserDto dto);
   // List<UserDto> listUserToListUserDto(List<User> entities);
}
