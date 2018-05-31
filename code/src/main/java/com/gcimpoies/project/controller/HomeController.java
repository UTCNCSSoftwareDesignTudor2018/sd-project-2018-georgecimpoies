package com.gcimpoies.project.controller;

import com.gcimpoies.project.model.Admin;
import com.gcimpoies.project.service.AdminService;
import com.gcimpoies.project.service.UserService;
import com.gcimpoies.project.view.AdminView;
import com.gcimpoies.project.view.HomeView;
import com.gcimpoies.project.view.UserView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@Controller
public class HomeController {
    @Autowired
    HomeView homeView;
    @Autowired
    UserController userController;
    @Autowired
    AdminController adminController;
    @Autowired
    AdminService adminService;
    @Autowired
    UserService userService;


    public HomeController(HomeView homeView) {
        this.homeView = homeView;
        homeView.setUserListener(new UserListener());
        homeView.setAdminLoginListener(new AdminLoginListener());
        homeView.setAdminCreateProfileListener(new AdminCreateProfileListener());
    }

    public void setHomeView(HomeView homeView) {
        this.homeView = homeView;
    }

    private class UserListener implements ActionListener {
        String username = "";
        String password = "";

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == homeView.userBtn) {
                if (e.getSource() == homeView.userBtn) {
                    UserView userView = new UserView();
                    int optionPaneResult = homeView.createLoginOptionPane();
                    if (optionPaneResult == JOptionPane.OK_OPTION) {
                        username = homeView.adminUsernameText.getText();
                        password = homeView.adminPasswordText.getText();
                        try {
                            if (userService.findByUsernameAndPassword(username, password) != null) {
                                userView.userFrame.setVisible(true);
                            } else {
                                JOptionPane.showMessageDialog(homeView.panelHome, "Invalid username or password", "Error",
                                        JOptionPane.ERROR_MESSAGE);
                            }
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(homeView.panelHome, "Something went wrong", "Error",
                                    JOptionPane.ERROR_MESSAGE);
                            ex.printStackTrace();
                        }
                    } else {
                        System.out.println("Cancelled");
                    }
                }
            }
        }
    }


    private class AdminLoginListener implements ActionListener {
        String username = "";
        String password = "";

        @Override
        public void actionPerformed(ActionEvent e) {

            if (e.getSource() == homeView.loginAdminBtn) {
                AdminView adminView = new AdminView();
                int optionPaneResult = homeView.createLoginOptionPane();
                if (optionPaneResult == JOptionPane.OK_OPTION) {
                    username = homeView.adminUsernameText.getText();
                    password = homeView.adminPasswordText.getText();
                    try {
                        if (adminService.getAdminByUsername(username) != null && adminService.getAdminByUsername(username).getPassword().equals(password)) {
                            adminView.adminFrame.setVisible(true);
                        } else {
                            JOptionPane.showMessageDialog(homeView.panelHome, "Invalid username or password", "Error",
                                    JOptionPane.ERROR_MESSAGE);
                        }
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(homeView.panelHome, "Something went wrong", "Error",
                                JOptionPane.ERROR_MESSAGE);
                        ex.printStackTrace();
                    }
                } else {
                    System.out.println("Cancelled");
                }
            }
        }
    }

    private class AdminCreateProfileListener implements ActionListener {
        String name = "";
        String username = "";
        String password = "";

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == homeView.createAdminBtn) {
                AdminView adminView = new AdminView();
                int optionPaneResult = homeView.createProfileOptionPane();
                if (optionPaneResult == JOptionPane.OK_OPTION) {
                    name = homeView.profileNameText.getText();
                    username = homeView.profileUsernameText.getText();
                    password = homeView.profilePasswordText.getText();
                    Admin admin = new Admin(name, username, password);
                    try {
                        adminController.createProfile(admin);
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
                } else {
                    System.out.println("Cancelled");
                }
            }
        }
    }
}
