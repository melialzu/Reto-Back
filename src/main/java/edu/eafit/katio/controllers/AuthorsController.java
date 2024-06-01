package edu.eafit.katio.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.eafit.katio.models.Authors;
import edu.eafit.katio.repositories.AuthorRepository;
import edu.eafit.katio.services.AuthorService;



@RestController
@RequestMapping("/katio/authors")
@CrossOrigin(origins = "*")
public class AuthorsController {
    @Autowired
    private AuthorRepository _authorRepository;

    @GetMapping("/getall")
    public ResponseEntity<Iterable<Authors>> getAllAuthors() {
        var authors = _authorRepository.findAll();
        return new ResponseEntity<Iterable<Authors>>(authors, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Authors> addAuthors(@RequestBody Authors authors) {
        var authorCreado = new AuthorService(_authorRepository).addAuthors(authors);
        return authorCreado.getId() == 0 ?
         new ResponseEntity<Authors>(authorCreado, HttpStatus.BAD_REQUEST)
        : new ResponseEntity<Authors>(authorCreado, HttpStatus.OK);

    }

    @GetMapping("/id")
    public ResponseEntity<Optional<Authors>> getAuthorById(@RequestParam("Id") Long id) {

        var authorById = new AuthorService(_authorRepository).getAuthorById(id);
        return new ResponseEntity<Optional<Authors>>(authorById, HttpStatus.OK);

    }

    @GetMapping("/name")
    public ResponseEntity<Iterable<Authors>> getAuthorByName(@RequestParam("Name") String name) {
        var authorByName = new AuthorService(_authorRepository).getAuthorByName(name);
        return new ResponseEntity<Iterable<Authors>>(authorByName, HttpStatus.OK);
    }

    @GetMapping("/country")
    public ResponseEntity<Iterable<Authors>> getAuthorByCountry(@RequestParam("Country") String country) {
        var authorByCountry = new AuthorService(_authorRepository).getAuthorByCountry(country);
        return new ResponseEntity<Iterable<Authors>>(authorByCountry, HttpStatus.OK);
    }
   




    /**
     * buscar un autor por id
     * buscar un autor por Nombre o Apellido
     * Agregar un autor
     * Editar un autor
     * Buscar un autor por pais de procedencia
     */
}