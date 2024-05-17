package edu.eafit.katio.repositories;

import org.springframework.data.repository.CrudRepository;

import edu.eafit.katio.models.Authors;

public interface AuthorRepository extends CrudRepository<Authors, Long> {

}