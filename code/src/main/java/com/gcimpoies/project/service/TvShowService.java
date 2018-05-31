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

    public TvShow createTvShow(TvShow tvShow) {
        tvShowRepository.save(tvShow);
        return tvShow;
    }

    public TvShow findById(int id) {
        if (tvShowRepository.findByTvShowId(id).isPresent()) {
            return tvShowRepository.findByTvShowId(id).get();
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
        tvShowRepository.deleteTvShowByTvShowId(id);
    }

    public List<TvShow> getFavourites(int userId){
        return tvShowRepository.findAllByUserId(userId);
    }

}
