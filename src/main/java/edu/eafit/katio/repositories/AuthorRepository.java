package edu.eafit.katio.repositories;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import edu.eafit.katio.models.Authors;

public interface AuthorRepository extends CrudRepository<Authors, Long> {

    @Query("SELECT a FROM Authors a WHERE a.Name = :name")
    Iterable<Authors> findByName(String name);

    @Query("SELECT a FROM Authors a WHERE a.Country = :country")
    Iterable<Authors> findByCountry(String country);
    
    @Query(
        nativeQuery = true, 
        value = "SELECT * FROM Authors a WHERE a.Name = :name")
    Optional<Authors> findByNameOpt(@Param("name") String name);

        @Query(
        nativeQuery = true,
        value = "SELECT * FROM Authors WHERE Birthdate BETWEEN :startDate AND :endDate"
    )
    List<Authors> findByPublishedDateBetween(@Param("startDate") Date startDate, @Param("endDate") Date endDate);


    Authors saveAndFlush(Authors authors);
}