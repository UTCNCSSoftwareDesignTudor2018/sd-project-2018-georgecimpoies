package com.gcimpoies.project.model;

import javax.persistence.*;

@Entity
@Table(name = "episodes")
public class Episode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "episode_id", updatable = false, nullable = false)
    private int episodeId;

    @Column(name = "episode_number")
    private String episodeNumber;

    @Column(name = "episode_description")
    private String description;

    @JoinColumn(name="season_id", nullable=false)
    private int seasonId;

    public Episode(String episodeNumber, String description, int seasonId) {
        this.episodeNumber = episodeNumber;
        this.description = description;
        this.seasonId = seasonId;
    }

    public Episode() {
    }

    public int getSeasonId() {
        return seasonId;
    }

    public void setSeasonId(int seasonId) {
        this.seasonId = seasonId;
    }

    public int getEpisodeId() {
        return episodeId;
    }

    public void setEpisodeId(int id) {
        this.episodeId = id;
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
