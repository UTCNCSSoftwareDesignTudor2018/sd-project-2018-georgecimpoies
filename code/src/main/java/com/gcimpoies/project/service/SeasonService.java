package com.gcimpoies.project.service;

import com.gcimpoies.project.model.Episode;
import com.gcimpoies.project.model.Season;
import com.gcimpoies.project.repository.SeasonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SeasonService {
    @Autowired
    SeasonRepository seasonRepository;

    public Season createSeason(Season season){
        seasonRepository.save(season);
        return season;
    }

    public Season findById(int id) {
        if (seasonRepository.findBySeasonId(id).isPresent()) {
            return seasonRepository.findBySeasonId(id).get();
        } else return null;
    }

    public void addEpisode(Episode episode, int seasonId) {
        Season season = findById(seasonId);
        season.getEpisodes().add(episode);
        seasonRepository.save(season);
    }

    public void addEpisode(List<Episode> episodes, int seasonId) {
        Season season = findById(seasonId);
        season.getEpisodes().addAll(episodes);
        seasonRepository.save(season);
    }

    public void delete(int id) {
        seasonRepository.deleteSeasonBySeasonId(id);
    }

    public List<Season> getSeasons(int tvShowId){
        return seasonRepository.findAllByTvShowId(tvShowId);
    }
}
