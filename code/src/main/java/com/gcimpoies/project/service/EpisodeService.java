package com.gcimpoies.project.service;

import com.gcimpoies.project.model.Episode;
import com.gcimpoies.project.repository.EpisodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EpisodeService {
    @Autowired
    EpisodeRepository episodeRepository;

    public Episode createEpisode(Episode episode){
        episodeRepository.save(episode);
        return episode;
    }

    public Episode findById(int id) {
        if (episodeRepository.findByEpisodeId(id).isPresent()) {
            return episodeRepository.findByEpisodeId(id).get();
        } else return null;
    }

    public void delete(int id) {
        episodeRepository.deleteEpisodeByEpisodeId(id);
    }

    public List<Episode> getEpisodes(int seasonId) {
        return episodeRepository.findAllBySeasonId(seasonId);
    }
}
