package edu.eafit.katio.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import edu.eafit.katio.models.AudioBooks;

public interface AudioBooksRepository extends CrudRepository<AudioBooks, Long> {
    
    @Query(
        nativeQuery = true,
        value = "SELECT * FROM audiobooks WHERE ISBN10 = ?1"
    )
    Optional<AudioBooks> findAudioBookByISBN10(@Param("ISBN10") String isbn10);

    
    @Query(
        nativeQuery = true,
        value = "SELECT ab.* FROM audiobooks ab \n" +
        "INNER JOIN authors a ON ab.Author_Id = a.ID \n" +
        "WHERE (:author = '' OR (a.Name ILIKE CONCAT('%',:author, '%')) \n"
    )
    Iterable<AudioBooks> findAudioBooksByAuthor(@Param("author") String author);

    @Query(
        nativeQuery = true,
        value = "SELECT * FROM audiobooks WHERE (Name ILIKE CONCAT('%',:name, '%')"
    )
    Iterable<AudioBooks> findAudioBooksByName(@Param("name") String name);


    Iterable<AudioBooks> findAudioBooksByEdition(String edition);

    Iterable<AudioBooks> findAudioBooksByLengthInSeconds(Long lengthInSeconds);

    AudioBooks saveAndFlush(AudioBooks audioBooks);
    
}
