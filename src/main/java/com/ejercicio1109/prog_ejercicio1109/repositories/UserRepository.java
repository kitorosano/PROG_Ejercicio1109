package com.ejercicio1109.prog_ejercicio1109.repositories;

import com.ejercicio1109.prog_ejercicio1109.config.ConexionDB;
import com.ejercicio1109.prog_ejercicio1109.mappers.UserMapper;
import com.ejercicio1109.prog_ejercicio1109.models.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;

public class UserRepository {
  
  public List<User> findAll() {
    Connection connection = null;
    Statement statement = null;
    ResultSet resultSet = null;
    String selectUsers = "SELECT * FROM users";
    try {
      connection = ConexionDB.getConnection();
      statement = connection.createStatement();
      resultSet = statement.executeQuery(selectUsers);
      return UserMapper.toModelList(resultSet);
    } catch (RuntimeException e) {
      System.out.println(e.getMessage());
      throw new RuntimeException("Error al conectar con la base de datos", e);
    } catch (SQLException e) {
      System.out.println(e.getMessage());
      throw new RuntimeException("Error al obtener los usuarios", e);
    } finally {
      try {
        if (resultSet != null) resultSet.close();
        if (statement != null) statement.close();
        if (connection != null) connection.close();
      } catch (SQLException e) {
        System.out.println(e.getMessage());
        throw new RuntimeException("Error al cerrar la conexión a la base de datos", e);
      }
    }
  }
  
  public Optional<User> findById(String id) {
    Connection connection = null;
    Statement statement = null;
    ResultSet resultSet = null;
    String selectUser = "SELECT *  FROM users WHERE id = '" + id + "'";
    try {
      connection = ConexionDB.getConnection();
      statement = connection.createStatement();
      resultSet = statement.executeQuery(selectUser);
      return Optional.ofNullable(UserMapper.toModel(resultSet));
    } catch (RuntimeException e) {
      System.out.println(e.getMessage());
      throw new RuntimeException("Error al conectar con la base de datos", e);
    } catch (SQLException e) {
      System.out.println(e.getMessage());
      throw new RuntimeException("Error al obtener el usuario", e);
    } finally {
      try {
        if (resultSet != null) resultSet.close();
        if (statement != null) statement.close();
        if (connection != null) connection.close();
      } catch (SQLException e) {
        System.out.println(e.getMessage());
        throw new RuntimeException("Error al cerrar la conexión a la base de datos", e);
      }
    }
  }
  
  public void create(User user) {
    Connection connection = null;
    Statement statement = null;
    String insertUser = "INSERT INTO users (name, surname, email, password) VALUES ('" + user.getName() + "', '" + user.getSurname() + "', '" + user.getEmail() + "', '" + user.getPassword() + "')";
    try {
      connection = ConexionDB.getConnection();
      statement = connection.createStatement();
      statement.executeUpdate(insertUser);
    } catch (RuntimeException e) {
      System.out.println(e.getMessage());
      throw new RuntimeException("Error al conectar con la base de datos", e);
    } catch (SQLException e) {
      System.out.println(e.getMessage());
      throw new RuntimeException("Error al guardar el usuario", e);
    } finally {
      try {
        if (statement != null) statement.close();
        if (connection != null) connection.close();
      } catch (SQLException e) {
        System.out.println(e.getMessage());
        throw new RuntimeException("Error al cerrar la conexión a la base de datos", e);
      }
    }
  }
  
  public void updateById(String id, User user){
    Connection connection = null;
    Statement statement = null;
    String updateUser = "UPDATE users SET ";
    if (user.getName() != null) updateUser += "name = '" + user.getName() + "', ";
    if (user.getSurname() != null) updateUser += "surname = '" + user.getSurname() + "', ";
    if (user.getEmail() != null) updateUser += "email = '" + user.getEmail() + "', ";
    if (user.getPassword() != null) updateUser += "password = '" + user.getPassword() + "', ";
    updateUser = updateUser.substring(0, updateUser.length() - 2);
    updateUser += " WHERE id = '" + id + "'";
    
    try {
      connection = ConexionDB.getConnection();
      statement = connection.createStatement();
      statement.executeUpdate(updateUser);
    } catch (RuntimeException e) {
      System.out.println(e.getMessage());
      throw new RuntimeException("Error al conectar con la base de datos", e);
    } catch (SQLException e) {
      System.out.println(e.getMessage());
      throw new RuntimeException("Error al actualizar el usuario", e);
    } finally {
      try {
        if (statement != null) statement.close();
        if (connection != null) connection.close();
      } catch (SQLException e) {
        System.out.println(e.getMessage());
        throw new RuntimeException("Error al cerrar la conexión a la base de datos", e);
      }
    }
  }
  
  public void deleteById(String id) {
    Connection connection = null;
    Statement statement = null;
    String deleteUser = "DELETE FROM users WHERE id = '" + id + "'";
    try {
      connection = ConexionDB.getConnection();
      statement = connection.createStatement();
      statement.executeUpdate(deleteUser);
    } catch (RuntimeException e) {
      System.out.println(e.getMessage());
      throw new RuntimeException("Error al conectar con la base de datos", e);
    } catch (SQLException e) {
      System.out.println(e.getMessage());
      throw new RuntimeException("Error al eliminar el usuario", e);
    } finally {
      try {
        if (statement != null) statement.close();
        if (connection != null) connection.close();
      } catch (SQLException e) {
        System.out.println(e.getMessage());
        throw new RuntimeException("Error al cerrar la conexión a la base de datos", e);
      }
    }
  }
}
