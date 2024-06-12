package edu.eafit.katio.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="audiobooks_authors")
public class AudioBooks_Authors {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    private long audiobook_id;
    private Integer author_id;

    //Getters and Setters

    public AudioBooks_Authors(long audiobook_id, Integer author_id) {
        this.audiobook_id = audiobook_id;
        this.author_id = author_id;
    }

    public AudioBooks_Authors() {
    }

    public long getAudiobook_id() {
        return audiobook_id;
    }

    public void setAudiobook_id(long audiobook_id) {
        this.audiobook_id = audiobook_id;
    }

    public Integer getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(Integer author_id) {
        this.author_id = author_id;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    
}
