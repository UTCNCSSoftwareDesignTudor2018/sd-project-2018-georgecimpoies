package com.gcimpoies.project.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "seasons")
public class Season {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "season_id", updatable = false, nullable = false)
    private int id;

    @Column(name = "season_number")
    private int seasonNumber;

    @Column(name = "season_description")
    private String description;

    @OneToMany(mappedBy = "episodes", fetch = FetchType.EAGER)
    private List<Episode> episodes;

    public Season(int id, int seasonNumber, List<Episode> episodes, String description) {
        this.id = id;
        this.seasonNumber = seasonNumber;
        this.episodes = episodes;
        this.description = description;
    }

    public Season() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSeasonNumber() {
        return seasonNumber;
    }

    public void setSeasonNumber(int seasonNumber) {
        this.seasonNumber = seasonNumber;
    }

    public List<Episode> getEpisodes() {
        return episodes;
    }

    public void setEpisodes(List<Episode> episodes) {
        this.episodes = episodes;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
