package com.gcimpoies.project.model;

import java.util.Date;
import java.util.List;

public class User {
    private int id;
    private String name;
    private String username;
    private String password;
    private List<TvShow> favourites;
    private Date lastLogin;

    public User(int id, String name, String username, String password, List<TvShow> favourites, Date lastLogin) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
        this.favourites = favourites;
        this.lastLogin = lastLogin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<TvShow> getFavourites() {
        return favourites;
    }

    public void setFavourites(List<TvShow> favourites) {
        this.favourites = favourites;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }
}
