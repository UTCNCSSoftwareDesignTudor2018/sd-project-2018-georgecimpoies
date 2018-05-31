package com.gcimpoies.project.repository;

import com.gcimpoies.project.model.Episode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EpisodeRepository extends JpaRepository<Episode, Integer> {
    public Episode save(Episode episode);

    public Optional<Episode> findByEpisodeId(Integer episodeId);

    public void deleteEpisodeByEpisodeId(int episodeId);

    public List<Episode> findAllBySeasonId(int seasonId);
}
