package com.gcimpoies.project.model;

import javax.persistence.*;

@Entity
@Table(name = "episodes")
public class Episode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "episode_id", updatable = false, nullable = false)
    private int id;

    @Column(name = "episode_number")
    private String episodeNumber;

    @Column(name = "episode_description")
    private String description;

    public Episode(int id, String episodeNumber, String description) {
        this.id = id;
        this.episodeNumber = episodeNumber;
        this.description = description;
    }

    public Episode() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEpisodeNumber() {
        return episodeNumber;
    }

    public void setEpisodeNumber(String episodeNumber) {
        this.episodeNumber = episodeNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
