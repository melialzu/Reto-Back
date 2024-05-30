package edu.eafit.katio.services;

import edu.eafit.katio.interfaces.BaseAudioBookServices;
import edu.eafit.katio.models.AudioBooks;
import edu.eafit.katio.repositories.AudioBooksRepository;

public class AudioBookService implements BaseAudioBookServices{

    private AudioBooksRepository _AudioBooksRepository;

    public AudioBookService(AudioBooksRepository audioBooksRepository){
        _AudioBooksRepository = audioBooksRepository;
    }

    @Override
    public Iterable<edu.eafit.katio.models.AudioBooks> getAllAudioBooks() {
        var audioBookList = _AudioBooksRepository.findAll();
        return audioBookList;
    }

    @Override
    public Iterable<edu.eafit.katio.models.AudioBooks> findAudioBooksByEdition(String edition) {
        var audioBookList = _AudioBooksRepository.findAudioBooksByEdition(edition);
        return audioBookList;
    }
    
    public Iterable<edu.eafit.katio.models.AudioBooks> findAudioBooksByName(String name) {
        var audioBookList = _AudioBooksRepository.findAudioBooksByName(name);
        return audioBookList;
    }

    public Iterable<edu.eafit.katio.models.AudioBooks> findAudioBooksByDuration(Long duration) {
        var audioBookList = _AudioBooksRepository.findAudioBooksByLengthInSeconds(duration);
        return audioBookList;
    }
    
    public edu.eafit.katio.models.AudioBooks createAudioBooks(AudioBooks audioBooks) {
        var audioBook = _AudioBooksRepository.save(audioBooks);
        return audioBook;
    }
}
