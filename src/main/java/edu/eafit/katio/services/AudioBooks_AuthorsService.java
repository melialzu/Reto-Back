package edu.eafit.katio.services;

import edu.eafit.katio.interfaces.BaseAudioBooks_AuthorsService;
import edu.eafit.katio.models.AudioBooks_Authors;
import edu.eafit.katio.repositories.AudioBooks_AuthorsRepository;

public class AudioBooks_AuthorsService implements BaseAudioBooks_AuthorsService {

    private final AudioBooks_AuthorsRepository _AudioBooks_AuthorsRepository;

    public AudioBooks_AuthorsService(AudioBooks_AuthorsRepository audioBooks_AuthorsRepository){
        _AudioBooks_AuthorsRepository = audioBooks_AuthorsRepository;
    }

    public AudioBooks_Authors createAudioBooks_Authors(AudioBooks_Authors audioBooksAuthors) {
        var saveAudioBooksAuthors = _AudioBooks_AuthorsRepository.save(audioBooksAuthors);

        return saveAudioBooksAuthors;
    }
}
