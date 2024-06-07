package edu.eafit.katio.models;


import org.springframework.boot.autoconfigure.security.SecurityProperties.User;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Usuarios{
    

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    @Column(nullable = false)
    private String Nombre;
    private String Apellido;
    private String Email;
    private String Telefono;
    private String Identificacion;
    private String Password; // Password. 
    private String Salt;
    private String Username;

     @Enumerated(EnumType.STRING) //indicar a JPA que los valores del enum deben almacenarse como cadenas en la base de datos.
    private Roles Role;
  


 
    
    public Roles getRole() {
        return Role;
    }

    public void setRole(Roles role) {
        Role = role;
    }
 

    public String getUsername() {
        return Username;
    }
    public void setUsername(String username) {
        Username = username;
    }   
    
    public String getSalt() {
        return Salt;
    }
    public void setSalt(String salt) {
        Salt = salt;
    }
    public Integer getId() {
        return Id;
    }
    public void setId(Integer id) {
        Id = id;
    }
    public String getNombre() {
        return Nombre;
    }
    public void setNombre(String nombre) {
        
        Nombre = nombre;
    }
   


    public String getPassword() {
        return Password;
    }
    public void setPassword(String password) {
        Password = password;
    }
    public String getApellido() {
        return Apellido;
    }
    public void setApellido(String apellido) {
        Apellido = apellido;
    }
    public String getEmail() {
        return Email;
    }
    public void setEmail(String email) {
        Email = email;
    }
    public String getTelefono() {
        return Telefono;
    }
    public void setTelefono(String telefono) {
        Telefono = telefono;
    }
    public String getIdentificacion() {
        return Identificacion;
    }
    public void setIdentificacion(String identificacion) {
        Identificacion = identificacion;
    }
}