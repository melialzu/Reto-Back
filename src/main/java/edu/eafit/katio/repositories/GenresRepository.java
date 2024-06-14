package edu.eafit.katio.repositories;

import org.springframework.data.repository.CrudRepository;

import edu.eafit.katio.models.Genres;

public interface GenresRepository extends CrudRepository<Genres, Long> {
    Genres saveAndFlush(Genres genre);
}