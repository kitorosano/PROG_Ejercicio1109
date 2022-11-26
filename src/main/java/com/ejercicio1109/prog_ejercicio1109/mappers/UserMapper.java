package com.ejercicio1109.prog_ejercicio1109.mappers;

import com.ejercicio1109.prog_ejercicio1109.dtos.UserDTO;
import com.ejercicio1109.prog_ejercicio1109.models.User;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserMapper {
  
  // ResultSet -> List<User>
  public static User toModel(ResultSet rs) {
    try {
      if (!rs.next()) return null;
      
      User user = new User();
      user.setId(rs.getLong("id"));
      user.setName(rs.getString("name"));
      user.setSurname(rs.getString("surname"));
      user.setEmail(rs.getString("email"));
      user.setPassword(rs.getString("password"));
      return user;
    } catch (Exception e) {
      System.out.println(e.getMessage());
      throw new RuntimeException("Error al mapear ResultSet a User", e);
    }
  }
  public static List<User> toModelList(ResultSet rs) {
    try {
      List<User> users = new ArrayList<>();
      User user = toModel(rs);
      while (user != null) {
        users.add(user);
        user = toModel(rs);
      }
      return users;
    } catch (Exception e) {
      System.out.println(e.getMessage());
      throw new RuntimeException("Error al mapear ResultSet a UserList", e);
    }
  }
  
  // UserDTO -> User
  public static User toModel(UserDTO userdto) {
    try {
      User user = new User();
      if(userdto.getName() != null) user.setName(userdto.getName());
      if(userdto.getSurname() != null) user.setSurname(userdto.getSurname());
      if(userdto.getEmail() != null) user.setEmail(userdto.getEmail());
      if(userdto.getPassword() != null) user.setPassword(userdto.getPassword());
      return user;
    } catch (Exception e) {
      System.out.println(e.getMessage());
      throw new RuntimeException("Error al mapear UserDTO a User", e);
    }
  }
  
  // User -> UserDTO
  public static UserDTO toDTO(User user){
    UserDTO userDTO = new UserDTO();
    try {
      userDTO.setId(user.getId());
      userDTO.setName(user.getName());
      userDTO.setSurname(user.getSurname());
      userDTO.setEmail(user.getEmail());
    } catch (Exception e) {
      System.out.println(e.getMessage());
      throw new RuntimeException("Error al mapear User a UserDTO", e);
    }
    
    return userDTO;
  }
  public static List<UserDTO> toDTOList(List<User> users) {
    List<UserDTO> userDTOList = new ArrayList<>();
    
    try {
      for (User user : users) {
        userDTOList.add(toDTO(user));
      }
    } catch (Exception e) {
      throw new RuntimeException("Error al mapear UserList a UserDTOList", e);
    }
    
    return userDTOList;
  }
}
