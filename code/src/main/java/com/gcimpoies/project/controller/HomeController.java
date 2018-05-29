package com.gcimpoies.project.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.gcimpoies.project.view.AdminView;
import com.gcimpoies.project.view.HomeView;
import com.gcimpoies.project.view.UserView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class HomeController {

    @Autowired
    HomeView homeView;
    @Autowired
    AdminView adminView;
    @Autowired
    UserView userView;

    public HomeController(HomeView homeView) {
        this.homeView = homeView;
        homeView.setStudentLoginListener(new StudentLoginListener());
        homeView.setTeacherLoginListener(new TeacherLoginListener());
    }

    public void setHomeView(HomeView homeView) {
        this.homeView = homeView;
    }

    private class StudentLoginListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == homeView.loginStudentBtn) {
                homeView.frame.getContentPane().add(userView.panelStudent);
                homeView.frame.getContentPane().remove(adminView.panelTeacher);
                userView.panelStudent.setVisible(true);
                adminView.panelTeacher.setVisible(false);

            }

        }
    }

    private class TeacherLoginListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            if (e.getSource() == homeView.loginTeacherBtn) {
                homeView.frame.getContentPane().remove(userView.panelStudent);
                homeView.frame.getContentPane().add(adminView.panelTeacher);
                adminView.panelTeacher.setVisible(true);
                userView.panelStudent.setVisible(false);
            }

        }

    }
}