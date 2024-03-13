package edu.eafit.katio.models;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepository extends CrudRepository <Usuarios, Integer> {

@Query("SELECT u FROM Usuarios u WHERE u.Nombre = ?1")
    List <Usuarios> findByNombre(String Nombre);

@Query("SELECT u FROM Usuarios u WHERE u.Identificacion= ?1")
    List <Usuarios> findByIdentificacion(String Identificacion);


   
    Usuarios saveAndFlush(Usuarios usuarios);
}

    

