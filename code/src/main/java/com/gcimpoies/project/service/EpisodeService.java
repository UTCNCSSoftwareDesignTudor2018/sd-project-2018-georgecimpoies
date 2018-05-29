package com.gcimpoies.project.service;

import com.gcimpoies.project.model.Episode;
import com.gcimpoies.project.repository.EpisodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EpisodeService {
    @Autowired
    EpisodeRepository episodeRepository;

    public Episode createEpisode(int id, String episodeNumber, String description){
        Episode episode = new Episode(id, episodeNumber, description);
        episodeRepository.save(episode);
        return episode;
    }

    public Episode findById(int id) {
        if (episodeRepository.findById(id).isPresent()) {
            return episodeRepository.findById(id).get();
        } else return null;
    }

    public void delete(int id) {
        episodeRepository.deleteEpisodeById(id);
    }
}
