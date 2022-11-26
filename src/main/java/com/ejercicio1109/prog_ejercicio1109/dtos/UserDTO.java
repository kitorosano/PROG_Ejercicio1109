package com.ejercicio1109.prog_ejercicio1109.dtos;

public class UserDTO {
  
  private long id;
  private String name;
  private String surname;
  private String email;
  private String password;
  
  public UserDTO() {
  }
  
  public long getId() {
    return id;
  }
  public void setId(long id) {
    if(id < 0) {
      throw new IllegalArgumentException("El id no puede ser negativo");
    }
    this.id = id;
  }
  
  public String getName() {
    return name;
  }
  public void setName(String name) {
    if (name == null || name.isEmpty())
      throw new IllegalArgumentException("El nombre no puede ser vacio");
    this.name = name;
  }
  
  public String getSurname() {
    return surname;
  }
  public void setSurname(String surname) {
    if (surname == null || surname.isEmpty())
      throw new IllegalArgumentException("El apellido no puede ser vacio");
    this.surname = surname;
  }
  
  public String getEmail() {
    return email;
  }
  public void setEmail(String email) {
    if (email == null || email.isEmpty())
      throw new IllegalArgumentException("El correo no puede ser vacio");
    // verificar que sea valido
    if(!checkValidEmail(email))
      throw new IllegalArgumentException("El correo no es valido");
    this.email = email;
  }
  
  public String getPassword() {
    return password;
  }
  public void setPassword(String password) {
    if (password == null || password.isEmpty())
      throw new IllegalArgumentException("La contraseña no puede ser vacia");
    this.password = password;
  }
  
  private boolean checkValidEmail(String email) {
    return email.matches("^[A-Za-z0-9+_.-]+@(.+)$");
  }
}
