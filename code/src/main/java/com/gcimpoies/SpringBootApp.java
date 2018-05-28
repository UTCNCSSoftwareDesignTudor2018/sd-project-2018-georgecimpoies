package com.gcimpoies;

import com.gcimpoies.project.controller.HomeController;
import com.gcimpoies.project.view.HomeView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootApp implements CommandLineRunner {
    @Autowired
    HomeView homeView;
    @Autowired
    HomeController homeController;


    public static void main(String[] args) {
        System.setProperty("java.awt.headless", "false");
        SpringApplication.run(SpringBootApp.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        /*homeView.getFrame().setVisible(true);
        homeController.setHomeView(homeView);*/
    }
}