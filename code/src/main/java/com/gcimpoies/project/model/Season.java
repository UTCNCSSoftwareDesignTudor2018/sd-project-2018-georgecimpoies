package com.gcimpoies.project.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "seasons")
public class Season {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "season_id", updatable = false, nullable = false)
    private int seasonId;

    @Column(name = "season_number")
    private int seasonNumber;

    @Column(name = "season_description")
    private String description;

    @OneToMany(mappedBy = "seasonId", fetch = FetchType.EAGER)
    private List<Episode> episodes;

    @JoinColumn(name="tvshow_id", nullable=false)
    private int tvShowId;

    public Season(int seasonNumber, String description, int tvShowId) {
        this.seasonNumber = seasonNumber;
        this.episodes = new ArrayList<>();;
        this.description = description;
        this.tvShowId = tvShowId;
    }

    public Season() {
    }

    public int getTvShowId() {
        return tvShowId;
    }

    public void setTvShowId(int tvShowId) {
        this.tvShowId = tvShowId;
    }

    public int getSeasonId() {
        return seasonId;
    }

    public void setSeasonId(int id) {
        this.seasonId = id;
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
