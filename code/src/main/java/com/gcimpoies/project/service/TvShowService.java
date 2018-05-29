package com.gcimpoies.project.service;

import com.gcimpoies.project.model.Season;
import com.gcimpoies.project.model.TvShow;
import com.gcimpoies.project.repository.TvShowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TvShowService {
    @Autowired
    TvShowRepository tvShowRepository;

    public TvShow createTvShow(int id, String tvShowname, String tvShowDescription, List<Season> seasons) {
        TvShow tvShow = new TvShow(id, tvShowname, tvShowDescription, seasons);
        tvShowRepository.save(tvShow);
        return tvShow;
    }

    public TvShow findById(int id) {
        if (tvShowRepository.findById(id).isPresent()) {
            return tvShowRepository.findById(id).get();
        } else return null;
    }

    public void addSeason(Season season, int tvShowId) {
        TvShow tvShow = findById(tvShowId);
        tvShow.getSeasons().add(season);
        tvShowRepository.save(tvShow);
    }

    public void addSeasons(List<Season> seasons, int tvShowId) {
        TvShow tvShow = findById(tvShowId);
        tvShow.getSeasons().addAll(seasons);
        tvShowRepository.save(tvShow);
    }

    public void delete(int id) {
        tvShowRepository.deleteTvShowById(id);
    }

    public List<Season> getEpisodes(int id) {
        return tvShowRepository.getSeasons(id);
    }
}
