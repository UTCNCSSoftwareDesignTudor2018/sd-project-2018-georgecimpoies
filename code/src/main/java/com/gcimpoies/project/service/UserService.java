package com.gcimpoies.project.service;

import com.gcimpoies.project.model.TvShow;
import com.gcimpoies.project.model.User;
import com.gcimpoies.project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public User createUser(User user) {
        userRepository.save(user);
        return user;
    }

    public User findById(int id) {
        if (userRepository.findByUserId(id).isPresent()) {
            return userRepository.findByUserId(id).get();
        } else return null;
    }

    public void addFavourite(TvShow tvShow, int userId) {
        User user = findById(userId);
        user.getFavourites().add(tvShow);
        userRepository.save(user);
    }

    public void addFavourites(List<TvShow> tvShows, int userId) {
        User user = findById(userId);
        user.getFavourites().addAll(tvShows);
        userRepository.save(user);
    }

    public User findByUsernameAndPassword(String username, String password) {
        if (userRepository.findUserByUsernameAndPassword(username, password).isPresent()) {
            return userRepository.findUserByUsernameAndPassword(username, password).get();
        }
        return null;
    }

    public void delete(int id) {
        userRepository.deleteUserByUserId(id);
    }
}
