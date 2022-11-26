package com.ejercicio1109.prog_ejercicio1109.services;

import com.ejercicio1109.prog_ejercicio1109.dtos.UserDTO;
import com.ejercicio1109.prog_ejercicio1109.mappers.UserMapper;
import com.ejercicio1109.prog_ejercicio1109.models.User;
import com.ejercicio1109.prog_ejercicio1109.repositories.UserRepository;

import java.util.List;
import java.util.Optional;

public class UserService {
  
  UserRepository userRepository = new UserRepository();
  
  public List<UserDTO> findAll() {
    List<User> users = userRepository.findAll();
    return UserMapper.toDTOList(users);
  }
  
  public Optional<UserDTO> findById(String id){
    return userRepository.findById(id).map(UserMapper::toDTO);
  }
  
  public void create(UserDTO userdto) {
    User user = UserMapper.toModel(userdto);
    userRepository.create(user);
  }
  
  public void updateById(String id, UserDTO userdto) {
    User user = UserMapper.toModel(userdto);
    userRepository.updateById(id, user);
  }
  
  public void deleteById(String id) {
    userRepository.deleteById(id);
  }
}
