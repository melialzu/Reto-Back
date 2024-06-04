package edu.eafit.katio.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import edu.eafit.katio.models.Books;

public interface BookRepository extends CrudRepository<Books, Long> {
    
    @Query(
        nativeQuery = true,
        value = "SELECT * FROM BOOKS WHERE Id like %:id%")
    List<Books> findById(@Param("id") Integer id);

    @Query(
        nativeQuery = true, 
        value = "SELECT * FROM BOOKS WHERE Name LIKE %:name%")
    List<Books> findByName(@Param("name") String name);

    @Query(
        nativeQuery = true, 
        value = "SELECT * FROM BOOKS WHERE Name LIKE %:name%")
    Optional<Books> findByNameEdit(@Param("name") String name);

    @Query(
        nativeQuery = true,
        value = "SELECT * FROM BOOKS WHERE Edition LIKE %:edition%")
    List<Books> findByEdition(@Param("edition") String edition);
    
    @Query(
        nativeQuery = true,
        value = "SELECT * FROM BOOKS WHERE Genre LIKE %:genre%")
    List<Books> findByGenre(@Param("genre") String genre);

    Books saveAndFlush(Books books);
} 