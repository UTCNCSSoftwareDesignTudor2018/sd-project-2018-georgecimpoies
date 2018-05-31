package com.gcimpoies.project.repository;

import com.gcimpoies.project.model.TvShow;
import com.gcimpoies.project.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    public User save(User user);

    public Optional<User> findByUserId(Integer userId);

    public Optional<User> findUserByUsernameAndPassword(String username, String password);

    public void deleteUserByUserId(int userId);
}
