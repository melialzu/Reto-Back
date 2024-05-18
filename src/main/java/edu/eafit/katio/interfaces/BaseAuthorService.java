package edu.eafit.katio.interfaces;

import java.util.Optional;

import org.hibernate.mapping.List;

import edu.eafit.katio.models.Authors;
import edu.eafit.katio.models.Usuarios;

public interface BaseAuthorService {

     Authors addAuthors(Authors authors);
     Optional<Authors> getAuthorById(Long id);
     Iterable<Authors> getAuthorByName(String name);
     Iterable<Authors> getAuthorByCountry(String country);
    

   
     

}
