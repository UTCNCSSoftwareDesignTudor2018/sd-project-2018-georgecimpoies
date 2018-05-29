package com.gcimpoies.project.repository;

import com.gcimpoies.project.model.Episode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EpisodeRepository extends JpaRepository<Episode, Integer> {
    public Episode save(Episode episode);

    public Optional<Episode> findById(Integer id);

    public void deleteEpisodeById(int id);
}
