package edu.eafit.katio.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import edu.eafit.katio.dtos.AudioBooksByAuthor;
import edu.eafit.katio.interfaces.BaseAuthorService;
import edu.eafit.katio.models.Authors;
import edu.eafit.katio.repositories.AudioBooksByAuthorRepository;
import edu.eafit.katio.repositories.AuthorRepository;

public class AuthorService implements BaseAuthorService {

    private AuthorRepository _AuthorRepository;
    private AudioBooksByAuthorRepository _AudioBooksByAuthorRepository;

    public AuthorService(AuthorRepository _AuthorRepository) {
        this._AuthorRepository = _AuthorRepository;
    }

    // Crear autor
    @Override
    public Authors addAuthors(Authors authors) {

        Optional<Authors> existingAuthor = _AuthorRepository.findByNameOpt(authors.getName());
        if (existingAuthor.isPresent()) {
            throw new RuntimeException("El Autor ya existe");
        }
        return _AuthorRepository.saveAndFlush(authors);
    }

    // Buscar por id
    @Override
    public Optional<Authors> getAuthorById(Long id) {
        return _AuthorRepository.findById(id);
    }

    // Buscar por nombre
    @Override
    public Iterable<Authors> getAuthorByName(String name) {
        return _AuthorRepository.findByName(name);
    }

    // Buscar por pais
    @Override
    public Iterable<Authors> getAuthorByCountry(String country) {
        return _AuthorRepository.findByCountry(country);
    }

    // Traer autores por rango de fechas de nacimiento
    public List<Authors> getAuthorsByDateRange(Date startDate, Date endDate) {
        var authorList = _AuthorRepository.findByPublishedDateBetween(startDate, endDate);
        return authorList;
    }

    // Actualizar autors
    @Override
    public Authors updateAuthor(String name, Authors authors) {
        Optional<Authors> oldAuthor = _AuthorRepository.findByNameOpt(name);
        if(oldAuthor.isPresent() && !oldAuthor.get().getName().isBlank()) 
        {
            oldAuthor.get().setName(authors.getName());
            oldAuthor.get().setLastname(authors.getLastname());
            oldAuthor.get().setCountry(authors.getCountry());
            oldAuthor.get().setBirthdate(authors.getBirthdate());

            return _AuthorRepository.saveAndFlush(oldAuthor.get());
        } else {
            return null;
        }
    }

    // Metodos del dto
    // Traer libros por Id del autor
    @Override
    public List<AudioBooksByAuthor> getAllAudioBooksByAuthorId(Integer idAuthor) {
       List<AudioBooksByAuthor> AuthorList = new ArrayList<AudioBooksByAuthor>();
       AuthorList = _AudioBooksByAuthorRepository .findByAuthorId(idAuthor);
       return AuthorList;
    }

    // Traer libros por el nombre del autor
    @Override 
    public List<AudioBooksByAuthor> getAllAudioBooksByAuthorName(String nameAuthor) {
        List<AudioBooksByAuthor> AuthorList = new ArrayList<AudioBooksByAuthor>();
        AuthorList = _AudioBooksByAuthorRepository.findByAuthorName(nameAuthor);
        return AuthorList;
    }

    // Traer libros por el nombre y/o apellido del autor
    @Override
    public List<AudioBooksByAuthor> getAllAudioBooksByAuthor(String nameAuthor, String lastNameAuthor) {
        List<AudioBooksByAuthor> AuthorList = new ArrayList<AudioBooksByAuthor>();

        if (lastNameAuthor.length() > 0 && nameAuthor.length() <= 0) 
        {
            AuthorList = _AudioBooksByAuthorRepository.findByAuthorLastName(lastNameAuthor);
        }
        else if (lastNameAuthor.length() <= 0 && nameAuthor.length() > 0) 
        {
            AuthorList = _AudioBooksByAuthorRepository.findByAuthorName(nameAuthor);
        }
        else 
        {
            AuthorList = _AudioBooksByAuthorRepository.findByAuthorFullName(lastNameAuthor, nameAuthor);
        }
        return AuthorList;
    } 
}
