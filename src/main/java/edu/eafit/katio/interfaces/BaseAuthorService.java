package edu.eafit.katio.interfaces;

import java.util.List;
import java.util.Optional;

import edu.eafit.katio.dtos.AudioBooksByAuthor;
import edu.eafit.katio.models.Authors;

public interface BaseAuthorService {

     Optional<Authors> getAuthorById(Long id);
     Iterable<Authors> getAuthorByName(String name);
     Iterable<Authors> getAuthorByCountry(String country);


     Authors addAuthors(Authors authors);

     Authors updateAuthor(String name, Authors updateAuthors);

     List<AudioBooksByAuthor> getAllAudioBooksByAuthorId(Integer idAuthor);
     List<AudioBooksByAuthor> getAllAudioBooksByAuthorName(String nameAuthor);
     List<AudioBooksByAuthor> getAllAudioBooksByAuthor(String nameAuthor, String lastNameAuthor);
}
