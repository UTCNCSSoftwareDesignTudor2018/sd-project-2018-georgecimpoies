package com.gcimpoies.project.repository;

import com.gcimpoies.project.model.Season;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SeasonRepository extends JpaRepository<Season, Integer> {
    public Season save(Season season);

    public Optional<Season> findBySeasonId(Integer seasonId);

    public void deleteSeasonBySeasonId(int seasonId);

    public List<Season> findAllByTvShowId(int tvShowId);
}
