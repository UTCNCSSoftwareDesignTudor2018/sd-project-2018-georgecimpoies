package com.gcimpoies.project.model;

import java.util.List;

public class Season {
    private int id;
    private int seasonNumber;
    private List<Episode> episodes;
    private String description;

    public Season(int id, int seasonNumber, List<Episode> episodes, String description) {
        this.id = id;
        this.seasonNumber = seasonNumber;
        this.episodes = episodes;
        this.description = description;
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
