package edu.eafit.katio.repository;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import edu.eafit.katio.models.Usuarios;

public interface UsuarioRepository extends CrudRepository<Usuarios, Integer> {

    @Query("SELECT u FROM Usuarios u WHERE u.Nombre = ?1")
    List<Usuarios> findByNombre(String Nombre);

    @Query("SELECT u FROM Usuarios u WHERE u.Identificacion= ?1")
    List<Usuarios> findByIdentificacion(String Identificacion);

    @Query("SELECT u FROM Usuarios u WHERE u.Email=?1 and u.Password =?2")
    List<Usuarios> findByEmailAndPasswordList (String Email,String Password);

    @Query("SELECT u FROM Usuarios u WHERE u.Email= ?1")
    List<Usuarios> findByEmail(String Email);



    Usuarios saveAndFlush(Usuarios usuarios);
}
