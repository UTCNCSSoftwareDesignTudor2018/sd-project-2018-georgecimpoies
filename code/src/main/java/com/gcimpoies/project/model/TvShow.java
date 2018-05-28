package com.gcimpoies.project.model;

import java.util.List;

public class TvShow {
    private int id;
    private String showName;
    private String description;
    private List<Season> seasons;

    public TvShow(int id, String showName, String description, List<Season> seasons) {
        this.id = id;
        this.showName = showName;
        this.description = description;
        this.seasons = seasons;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getShowName() {
        return showName;
    }

    public void setShowName(String showName) {
        this.showName = showName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Season> getSeasons() {
        return seasons;
    }

    public void setSeasons(List<Season> seasons) {
        this.seasons = seasons;
    }
}
