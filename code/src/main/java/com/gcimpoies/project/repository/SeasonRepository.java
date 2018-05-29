package com.gcimpoies.project.repository;

import com.gcimpoies.project.model.Episode;
import com.gcimpoies.project.model.Season;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SeasonRepository extends JpaRepository<Season, Integer> {
    public Season save(Season season);

    public Optional<Season> findById(Integer id);

    public void deleteSeasonById(int id);

    @Query("SELECT e FROM Episode e WHERE e.season_season_id = :seasonId")
    public List<Episode> getEpisodes(@Param("seasonId") int seasonId);
}
