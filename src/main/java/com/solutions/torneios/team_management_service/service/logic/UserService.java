package com.solutions.torneios.team_management_service.service.logic;

import com.solutions.torneios.team_management_service.persistence.entity.User;
import com.solutions.torneios.team_management_service.persistence.repository.UserRepository;
import com.solutions.torneios.team_management_service.service.mapper.CycleAvoidingMappingContext;
import com.solutions.torneios.team_management_service.service.mapper.UserMapper;
import com.solutions.torneios.team_management_service.service.model.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    private final
    UserRepository userRepository;
    private final
    UserMapper userMapper;

    @Autowired
    public UserService(UserRepository userRepository,UserMapper userMapper) {
        this.userMapper=userMapper;
        this.userRepository = userRepository;
    }

    public List<UserDto> getAllUsers(){
       final  List<UserDto> users = new ArrayList<>();
          userRepository.findAll().forEach(user -> {
         users.add(userMapper.UserToUserDto(user,new CycleAvoidingMappingContext()));
          });
        return users;
    }

    public UserDto getUserById(UUID id){
        User user=userRepository.findById(id).get();
        return userMapper.UserToUserDto(user,new CycleAvoidingMappingContext());
    }

    public void saveOrUpdate(UserDto userDto){
        User user=userMapper.UserDtoToUser(userDto);

        userRepository.save(user);
    }

    public void delete(UUID id){
        userRepository.deleteById(id);
    }

    public void update(UserDto userDto, UUID id){
        User user=userMapper.UserDtoToUser(userDto);
        userRepository.save(user);
    }
}
