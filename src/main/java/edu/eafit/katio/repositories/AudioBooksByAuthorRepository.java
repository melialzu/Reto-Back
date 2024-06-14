package edu.eafit.katio.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import edu.eafit.katio.dtos.AudioBooksByAuthor;

public interface AudioBooksByAuthorRepository extends CrudRepository<AudioBooksByAuthor, Long> {

    // Find by Author Id
    @Query(nativeQuery = true,
    value = "SELECT " +
            "ab.id as Id_AudioBook, ab.Name as AudioBook_Name, ab.ISBN13, " +
            "au.Lastname as Author_Name " +
            "FROM Authors au " +
            "JOIN audiobooks ab ON ab.author_id = au.id " +
            "WHERE au.id = :idAuthor")
    List<AudioBooksByAuthor> findByAuthorId(@Param("idAuthor") Integer idAuthor);

    // Find by Author Name
    @Query(nativeQuery = true,
    value = "SELECT " +
            "ab.id as Id_AudioBook, ab.Name as AudioBook_Name, ab.ISBN13, " +
            "au.Lastname as Author_Name " +
            "FROM Authors au " +
            "JOIN audiobooks ab ON ab.author_id = au.id " +
            "WHERE au.Name LIKE %:name%")
    List<AudioBooksByAuthor> findByAuthorName(@Param("name") String name);

    // Find by Author LastName
    @Query(nativeQuery = true,
    value = "SELECT " +
            "ab.id as Id_AudioBook, ab.Name as AudioBook_Name, ab.ISBN13, " +
            "au.Lastname as Author_Name " +
            "FROM Authors au " +
            "JOIN audiobooks ab ON ab.author_id = au.id " +
            "WHERE au.Lastname LIKE %:lastname%")
    List<AudioBooksByAuthor> findByAuthorLastName(@Param("lastname") String lastName);

    // Find by Author FullName (Name or LastName)
    @Query(nativeQuery = true,
    value = "SELECT " +
            "ab.id as Id_AudioBook, ab.Name as AudioBook_Name, ab.ISBN13, " +
            "au.Lastname as Author_Name " +
            "FROM Authors au " +
            "JOIN audiobooks ab ON ab.author_id = au.id " +
            "WHERE au.Lastname LIKE %:lastname% OR au.Name LIKE %:name%")
    List<AudioBooksByAuthor> findByAuthorFullName(@Param("lastname") String lastNameAuthor, @Param("name") String nameAuthor);
}

