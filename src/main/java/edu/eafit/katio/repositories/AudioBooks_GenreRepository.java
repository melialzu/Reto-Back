package edu.eafit.katio.repositories;


import org.springframework.data.repository.CrudRepository;

import edu.eafit.katio.models.AudioBooks_Genre;

public interface AudioBooks_GenreRepository extends CrudRepository<AudioBooks_Genre, Long> {
    
}
