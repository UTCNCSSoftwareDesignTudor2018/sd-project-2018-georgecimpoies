package com.gcimpoies.project;

import com.gcimpoies.project.controller.HomeController;
import com.gcimpoies.project.model.*;
import com.gcimpoies.project.service.*;
import com.gcimpoies.project.view.HomeView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootApplication
@EnableJpaRepositories("com.gcimpoies.*")
@ComponentScan(basePackages = {"com.gcimpoies.*"})
@EntityScan("com.gcimpoies.*")
public class SpringBootApp implements CommandLineRunner {
    @Autowired
    HomeView homeView;
    @Autowired
    HomeController homeController;
    @Autowired
    AdminService adminService;
    @Autowired
    UserService userService;
    @Autowired
    EpisodeService episodeService;
    @Autowired
    SeasonService seasonService;
    @Autowired
    TvShowService tvShowService;

    public static void main(String[] args) {
        System.setProperty("java.awt.headless", "false");
        SpringApplication.run(SpringBootApp.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
/*        User user = new User(2, "George", "georgel", "georgel", new Date());

        TvShow show1 = new TvShow("Supernatural", "", user.getUserId());
        TvShow show2 = new TvShow("Peaky Blinders", "", user.getUserId());
        TvShow show3 = new TvShow("Rome", "", user.getUserId());

        Season season1 = new Season(1, "", show1.getTvShowId());
        Season season2 = new Season(2, "", show2.getTvShowId());
        Season season3 = new Season(3, "", show3.getTvShowId());

        Episode episode1 = new Episode("1", "jhsdgfkiuysdah", season1.getSeasonId());
        Episode episode2 = new Episode("2", "jhsdgfkiuysdah", season1.getSeasonId());
        Episode episode3 = new Episode("3", "jhsdgfkiuysdah", season1.getSeasonId());

        episodeService.createEpisode(episode1);
        episodeService.createEpisode(episode2);
        episodeService.createEpisode(episode3);

        seasonService.createSeason(season1);
        seasonService.createSeason(season2);
        seasonService.createSeason(season3);

        tvShowService.createTvShow(show1);
        tvShowService.createTvShow(show2);
        tvShowService.createTvShow(show3);

        userService.createUser(user);

        for (TvShow tvShow : tvShowService.getFavourites(user.getUserId())) {
            System.out.println(tvShow.getShowName());
        }*/
        homeView.getFrame().setVisible(true);
        homeController.setHomeView(homeView);
    }
}