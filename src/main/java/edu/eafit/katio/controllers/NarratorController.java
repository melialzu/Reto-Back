package edu.eafit.katio.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import edu.eafit.katio.models.Narrators;
import edu.eafit.katio.repositories.NarratorRepository;
import edu.eafit.katio.services.NarratorService;

@RestController
@RequestMapping("/katio/narrators")
@CrossOrigin(origins = "*")
public class NarratorController {

    @Autowired
    private NarratorRepository _narratorRepository;


    // Crear un Narrador
    @PostMapping("/add")
    public ResponseEntity<Narrators> addNarrator(@RequestBody Narrators narrators) {
        try {
            Narrators createdNarrator = new NarratorService(_narratorRepository).addNarrators(narrators);
            return new ResponseEntity<>(createdNarrator, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    // Editar un Narrador
    @PutMapping("/update/{name}")
    public ResponseEntity<Object> updateNarrator(@PathVariable("name") String name, @RequestBody Narrators updateNarrator) {
        Narrators updatedNarrator = new NarratorService(_narratorRepository).updateNarrators(name, updateNarrator);
        if (updatedNarrator != null) {
            return new ResponseEntity<>(updatedNarrator, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Narrador no Encontrado", HttpStatus.NOT_FOUND);
        }
    }

    // Traer Todos los Narradores
    @GetMapping("/getall")
    public ResponseEntity<Iterable<Narrators>> getAllNarrators() {
        var narrators = new NarratorService(_narratorRepository).getAllNarrators();
        return new ResponseEntity<>(narrators, HttpStatus.OK);
    }

    // Traer Narradores por Id
    @GetMapping("/getById/{id}")
    public ResponseEntity<Iterable<Narrators>> getNarratorsById(@PathVariable("id") Integer id) {
        var response = new NarratorService(_narratorRepository).getNarratorsById(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // Traer Narradores por Nombre
    @GetMapping("/getByName/{name}")
    public ResponseEntity<Iterable<Narrators>> getNarratorsByName(@PathVariable("name") String name) {
        var response = new NarratorService(_narratorRepository).getNarratorsByName(name);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // Traer Narradores por Apellido
    @GetMapping("/getByLastName/{lastName}")
    public ResponseEntity<Iterable<Narrators>> getNarratorsByLastName(@PathVariable("lastName") String lastName) {
        var response = new NarratorService(_narratorRepository).getNarratorsByLastName(lastName);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // Traer Narradores por Género
    @GetMapping("/getByGenre/{genre}")
    public ResponseEntity<Iterable<Narrators>> getNarratorsByGenre(@PathVariable("genre") String genre) {
        var response = new NarratorService(_narratorRepository).getNarratorsByGenre(genre);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
