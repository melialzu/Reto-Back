package edu.eafit.katio.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import edu.eafit.katio.dtos.BooksByAuthor;

public interface BooksByAuthorRepository extends CrudRepository<BooksByAuthor, Long> {

    // Find by Id
    @Query(nativeQuery = true,
    value = "SELECT " +
            "bk.id as Id_Book, bk.Name as Book_Name, bk.ISBN13, " +
            "au.LastName as Author_Name " +
            "FROM Authors au " +
            "JOIN Books bk ON bk.author_id = au.id " +
            "WHERE au.id = :idAuthor")
    Iterable<BooksByAuthor> findByAuthorId(@Param("idAuthor") Integer idAuthor);

    // Find by Name
    @Query(nativeQuery = true,
    value = "SELECT " +
            "bk.id as Id_Book, bk.Name as Book_Name, bk.ISBN13, " +
            "au.LastName as Author_Name " +
            "FROM Authors au " +
            "JOIN Books bk ON bk.author_id = au.id " +
            "WHERE au.Name LIKE %:name%")
    Iterable<BooksByAuthor> findByAuthorName(@Param("name") String name);

    @Query(nativeQuery = true,
        value = "SELECT " +
                "bk.id as Id_Book, bk.Name as Book_Name, bk.ISBN13, " +
                "au.LastName as Author_Name " +
                "FROM Authors au " +
                "JOIN Books bk ON bk.author_id = au.id " +
                "WHERE au.LastName LIKE %:lastname%")
    Iterable<BooksByAuthor> findByAuthorLastName(@Param("lastname") String lastName);


    // Find by FullName
    @Query(nativeQuery = true,
        value = "SELECT " +
                "bk.id as Id_Book, bk.Name as Book_Name, bk.ISBN13, " +
                "au.LastName as Author_Name " +
                "FROM Authors au " +
                "JOIN Books bk ON bk.author_id = au.id " +
                "WHERE au.LastName LIKE %:lastname% OR au.Name LIKE %:name%")
    Iterable<BooksByAuthor> findByAuthorFullName(@Param("lastname") String lastNameAuthor, @Param("name") String nameAuthor);


}

