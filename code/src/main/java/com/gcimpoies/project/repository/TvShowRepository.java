package com.gcimpoies.project.repository;

import com.gcimpoies.project.model.TvShow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TvShowRepository extends JpaRepository<TvShow, Integer> {
    public TvShow save(TvShow tvShow);

    public Optional<TvShow> findByTvShowId(Integer tvShowId);

    public void deleteTvShowByTvShowId(int tvShowId);

    public List<TvShow> findAllByUserId(int userId);
}
