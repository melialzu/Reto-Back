package edu.eafit.katio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import edu.eafit.katio.dtos.BooksByAuthor;

public interface BooksByAuthorRepository extends JpaRepository<BooksByAuthor, Long> {
    
    @Query(nativeQuery = true,
        value =
            "SELECT " +
                "bk.id as Id_Book, bk.Name as Book_Name, bk.ISBN13, "+
                "au.LastName as Author_Name " +
            "FROM Authors au " +
            "JOIN Books bk ON bk.author_id = au.id " +
            "WHERE " +
                "au.Lastname LIKE %:lastname%")
    Iterable<BooksByAuthor> findByAuthorLastName(@Param("lastname") String LastName);

    @Query(nativeQuery = true,
        value =
            "SELECT " +
                "bk.id as Id_Book, bk.Name as Book_Name, bk.ISBN13, "+
                "au.LastName as Author_Name " +
            "FROM Authors au " +
            "JOIN Books bk ON bk.author_id = au.id " +
            "WHERE " +
                "au.Name LIKE %:name%")
    Iterable<BooksByAuthor> findByAuthorName(@Param("name") String Name);

    @Query(nativeQuery = true,
        value =
            "SELECT " +
                "bk.id as Id_Book, bk.Name as Book_Name, bk.ISBN13, "+
                "au.LastName as Author_Name " +
            "FROM Authors au " +
            "JOIN Books bk ON bk.author_id = au.id " +
            "WHERE " +
                "au.Lastname LIKE %:lastname% OR au.Name LIKE %:name%")
    Iterable<BooksByAuthor> findByAuthorFullName(@Param("lastname") String LastName, @Param("name") String Name);
}
