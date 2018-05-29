package com.gcimpoies.project.service;

import com.gcimpoies.project.model.Episode;
import com.gcimpoies.project.model.Season;
import com.gcimpoies.project.repository.SeasonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeasonService {
    @Autowired
    SeasonRepository seasonRepository;

    public Season createSeason(int id, int seasonNumber, String seasonDescription, List<Episode> episodes){
        Season season = new Season(id, seasonNumber, episodes, seasonDescription);
        seasonRepository.save(season);
        return season;
    }

    public Season findById(int id) {
        if (seasonRepository.findById(id).isPresent()) {
            return seasonRepository.findById(id).get();
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
        seasonRepository.deleteSeasonById(id);
    }

    public List<Episode> getEpisodes(int id) {
        return seasonRepository.getEpisodes(id);
    }
}
