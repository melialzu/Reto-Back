package edu.eafit.katio.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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

    /*
     * @GetMapping("/getall")
     * public ResponseEntity<Iterable<Authors>> getAllAuthors() {
     * var authors = _authorRepository.findAll();
     * return new ResponseEntity<Iterable<Authors>>(authors, HttpStatus.OK);
     * }
     */

    @GetMapping("/getall")
    public ResponseEntity<Iterable<Authors>> getAllAuthors() {
        var authors = new AuthorService(_authorRepository).getAllAuthors();
        return new ResponseEntity<Iterable<Authors>>(authors, HttpStatus.OK);
    }

}