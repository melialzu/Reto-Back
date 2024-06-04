package edu.eafit.katio.controllers;

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

import edu.eafit.katio.models.AudioBooks;
import edu.eafit.katio.repositories.AudioBooksRepository;
import edu.eafit.katio.services.AudioBookService;

@RestController
@RequestMapping("/katio/audiobooks")
@CrossOrigin(origins = "*")
public class AudioBooksController {

    @Autowired
    private AudioBooksRepository _AudioBooksRepository;
    
    @GetMapping ("/getall")
    public ResponseEntity<Iterable<AudioBooks>> getallAudioBooks() 
    {
        var audiobooks = new AudioBookService(_AudioBooksRepository).getAllAudioBooks();
        return new ResponseEntity <Iterable<AudioBooks>> (audiobooks, HttpStatus.OK);
    }

    @GetMapping ("/getByName")
    public ResponseEntity<Iterable<AudioBooks>> getAudioBooksByName(@RequestParam("name") String name)
    {
        var audiobooks = new AudioBookService(_AudioBooksRepository).findAudioBooksByName(name);
        return new ResponseEntity<Iterable<AudioBooks>>(audiobooks, HttpStatus.OK);
    }

    @GetMapping ("/getByEdition")
    public ResponseEntity<Iterable<AudioBooks>> getAudioBooksByEdition(@RequestParam("edition") String edition)
    {
        var audiobooks = new AudioBookService(_AudioBooksRepository).findAudioBooksByEdition(edition); 
        return new ResponseEntity<Iterable<AudioBooks>>(audiobooks, HttpStatus.OK);
    }

    @GetMapping ("/getByLength")
    public ResponseEntity<Iterable<AudioBooks>> getAudioBooksByDuration(@RequestParam("duration") Long duration)
    {
        var audiobooks = new AudioBookService(_AudioBooksRepository).findAudioBooksByDuration(duration); 
        return new ResponseEntity<Iterable<AudioBooks>>(audiobooks, HttpStatus.OK);
    }

    @PostMapping ("/addaudiobooks")
    public ResponseEntity<AudioBooks> addAudioBooks(@RequestBody AudioBooks audioBooks)
    {
        var response = new AudioBookService(_AudioBooksRepository).createAudioBooks(audioBooks);
        return response.getId() == 0 ? new ResponseEntity<AudioBooks>(response, HttpStatus.BAD_REQUEST)
        : new ResponseEntity<AudioBooks>(response, HttpStatus.OK);
    }
}