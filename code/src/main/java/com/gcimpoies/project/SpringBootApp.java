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
        homeView.getFrame().setVisible(true);
        homeController.setHomeView(homeView);
    }
}