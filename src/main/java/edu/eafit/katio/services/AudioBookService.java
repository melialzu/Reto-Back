package edu.eafit.katio.services;

import edu.eafit.katio.interfaces.BaseAudioBookServices;
import edu.eafit.katio.models.AudioBooks;
import edu.eafit.katio.repositories.AudioBooksRepository;

public class AudioBookService implements BaseAudioBookServices{

    private final AudioBooksRepository _AudioBooksRepository;

    public AudioBookService(AudioBooksRepository audioBooksRepository){
        _AudioBooksRepository = audioBooksRepository;
    }

    @Override
    public Iterable<AudioBooks> getAllAudioBooks() {
        var audioBookList = _AudioBooksRepository.findAll();
        return audioBookList;
    }

    @Override
    public Iterable<AudioBooks> findAudioBooksByEdition(String edition) {
        var audioBookList = _AudioBooksRepository.findAudioBooksByEdition(edition);
        return audioBookList;
    }
    
    public Iterable<AudioBooks> findAudioBooksByName(String name) {
        var audioBookList = _AudioBooksRepository.findAudioBooksByName(name);
        return audioBookList;
    }

    public Iterable<AudioBooks> findAudioBooksByDuration(Long duration) {
        var audioBookList = _AudioBooksRepository.findAudioBooksByLengthInSeconds(duration);
        return audioBookList;
    }
    
    public AudioBooks createAudioBooks(AudioBooks audioBooks) {
        var audioBook = _AudioBooksRepository.save(audioBooks);
        return audioBook;
    }
}
