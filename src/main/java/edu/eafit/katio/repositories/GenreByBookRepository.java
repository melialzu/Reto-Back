package edu.eafit.katio.repositories;

import org.springframework.data.repository.CrudRepository;

import edu.eafit.katio.dtos.GenreByBook;

public interface GenreByBookRepository extends CrudRepository<GenreByBook, Long> {
    GenreByBook saveAndFlush(GenreByBook genre);
}