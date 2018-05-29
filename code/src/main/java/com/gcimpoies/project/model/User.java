package com.gcimpoies.project.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", updatable = false, nullable = false)
    private int id;

    @Column(name = "full_name")
    private String name;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "last_loggin")
    private Date lastLogin;

    @OneToMany(mappedBy = "tvshows", fetch = FetchType.EAGER)
    private List<TvShow> favourites;

    public User(int id, String name, String username, String password, List<TvShow> favourites, Date lastLogin) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
        this.favourites = favourites;
        this.lastLogin = lastLogin;
    }

    public User() {
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
