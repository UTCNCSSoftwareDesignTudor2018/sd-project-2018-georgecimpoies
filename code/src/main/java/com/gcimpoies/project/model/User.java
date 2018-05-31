package com.gcimpoies.project.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", updatable = false, nullable = false)
    private int userId;

    @Column(name = "full_name")
    private String name;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "last_loggin")
    private Date lastLogin;

    @OneToMany(mappedBy = "userId", fetch = FetchType.EAGER)
    private List<TvShow> favourites;

    public User(String name, String username, String password) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.favourites = new ArrayList<>();
        this.lastLogin = new Date();
    }

    public User() {
        this.userId = 2;
        this.name = "Blank";
        this.username = "Blank";
        this.password = "Blank";
        this.favourites = new ArrayList<>();
        this.lastLogin = new Date();
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int id) {
        this.userId = id;
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
