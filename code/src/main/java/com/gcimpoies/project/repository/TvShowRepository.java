package com.gcimpoies.project.repository;

import com.gcimpoies.project.model.Season;
import com.gcimpoies.project.model.TvShow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TvShowRepository extends JpaRepository<TvShow, Integer> {
    public TvShow save(TvShow tvShow);

    public Optional<TvShow> findById(Integer id);

    public void deleteTvShowById(int id);

    @Query("SELECT s FROM Season s WHERE s.tv_show_id = :tvShowId")
    public List<Season> getSeasons(@Param("tvShowId") int tvShowId);
}
