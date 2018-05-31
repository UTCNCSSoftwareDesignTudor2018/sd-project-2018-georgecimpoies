package com.gcimpoies.project.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tvshows")
public class TvShow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tvshow_id", updatable = false, nullable = false)
    private int tvShowId;

    @Column(name = "show_name")
    private String showName;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "tvShowId", fetch = FetchType.EAGER)
    private List<Season> seasons;

    @JoinColumn(name="user_id", nullable=false)
    private int userId;

    public TvShow(String showName, String description, int userId) {
        this.showName = showName;
        this.description = description;
        this.seasons = new ArrayList<>();
        this.userId = userId;
    }

    public TvShow() {
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getTvShowId() {
        return tvShowId;
    }

    public void setTvShowId(int id) {
        this.tvShowId = id;
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
