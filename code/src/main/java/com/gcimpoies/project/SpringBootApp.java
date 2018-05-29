package com.gcimpoies.project;

import com.gcimpoies.project.controller.HomeController;
import com.gcimpoies.project.model.Episode;
import com.gcimpoies.project.model.Season;
import com.gcimpoies.project.model.TvShow;
import com.gcimpoies.project.model.User;
import com.gcimpoies.project.repository.EpisodeRepository;
import com.gcimpoies.project.repository.SeasonRepository;
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
@ComponentScan(basePackages = { "com.gcimpoies.*" })
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
        List<Episode> episodes = new ArrayList<>();
        Episode episode = episodeService.createEpisode(7, "7", "");
        episodes.add(episode);

        List<Season> seasons = new ArrayList<>();
        Season season = seasonService.createSeason(3, 3, "", episodes);
        seasons.add(season);

        List<TvShow> shows = new ArrayList<>();

        shows.add(new TvShow(4, "Peaky Blinders", "", seasons));
        shows.add(new TvShow(5, "Supernatural", "", seasons));
        shows.add(new TvShow(6, "Taken", "", seasons));

        User user = userService.createUser(2, "George", "georgel", "georgel", shows, new Date());
        for(TvShow tvShow : userService.getFavourites(user.getId())){
            System.out.println(tvShow.getShowName());
        }
/*        homeView.getFrame().setVisible(true);
        homeController.setHomeView(homeView);*/
    }
}