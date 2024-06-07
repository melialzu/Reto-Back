package edu.eafit.katio.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import edu.eafit.katio.models.Books;

public interface BookRepository extends CrudRepository<Books, Long> {
    
    @Query(
        nativeQuery = true,
        value = "SELECT * FROM BOOKS WHERE Id like %:id%")
    Iterable<Books> findById(@Param("id") Integer id);

    @Query(
        nativeQuery = true, 
        value = "SELECT * FROM BOOKS WHERE Name LIKE %:name%")
    Iterable<Books> findByName(@Param("name") String name);

    @Query(
        nativeQuery = true,
        value = "SELECT * FROM BOOKS WHERE Edition LIKE %:edition%")
    Iterable<Books> findByEdition(@Param("edition") String edition);
    
    @Query(
        nativeQuery = true,
        value = "SELECT * FROM BOOKS WHERE Genre LIKE %:genre%")
    Iterable<Books> findByGenre(@Param("genre") String genre);

    Books saveAndFlush(Books books);
} 