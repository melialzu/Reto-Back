package edu.eafit.katio.services;

import edu.eafit.katio.repositories.AudioBooks_GenreRepository;

public class AudioBooks_GenreService {

    private final AudioBooks_GenreRepository _AudioBooks_GenreRepository;

    public AudioBooks_GenreService(AudioBooks_GenreRepository audioBooks_GenreRepository){
        _AudioBooks_GenreRepository = audioBooks_GenreRepository;
    }

    public Integer deleteByAudioBookId(Long audiobookId){
        return _AudioBooks_GenreRepository.deleteByAudioBookId(audiobookId);
    }
}
