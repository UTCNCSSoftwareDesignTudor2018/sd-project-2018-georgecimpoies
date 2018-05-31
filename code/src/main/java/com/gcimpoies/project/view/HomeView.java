package com.gcimpoies.project.view;

import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

@Component
public class HomeView {

    public JFrame frame;

    public JPanel panelHome;
    public JPanel loginPanel;
    public JPanel createProfilePanel;

    public JTextField adminUsernameText;
    public JTextField adminPasswordText;

    public JButton userBtn;
    public JButton loginAdminBtn;
    public JButton createAdminBtn;

    public JTextField profileNameText;
    public JTextField profileUsernameText;
    public JTextField profilePasswordText;

    public HomeView() {
        initialize();
    }

    public JFrame getFrame() {
        return frame;
    }

    public void setUserListener(ActionListener actionListener) {
        userBtn.addActionListener(actionListener);
    }

    public void setAdminLoginListener(ActionListener actionListener) {
        loginAdminBtn.addActionListener(actionListener);
    }

    public void setAdminCreateProfileListener(ActionListener actionListener) {
        createAdminBtn.addActionListener(actionListener);
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(0, 0, 300, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Home");
        frame.getContentPane().setLayout(null);
        frame.setLocationRelativeTo(null);

        panelHome = new JPanel();
        panelHome.setBounds(0, 0, 300, 150);
        panelHome.setBackground(Color.WHITE);
        panelHome.setLayout(null);
        frame.add(panelHome);

        userBtn = new JButton("User");
        userBtn.setBounds(10, 35, 130, 25);
        panelHome.add(userBtn);

        loginAdminBtn = new JButton("Admin");
        loginAdminBtn.setBounds(145, 35, 130, 25);
        panelHome.add(loginAdminBtn);

        adminUsernameText = new JTextField();
        adminPasswordText = new JTextField();

        loginPanel = new JPanel(new GridLayout(0, 1));
        loginPanel.add(new JLabel("Username:"));
        loginPanel.add(adminUsernameText);
        loginPanel.add(new JLabel("Password:"));
        loginPanel.add(adminPasswordText);

        createAdminBtn = new JButton("Create new account");
        loginPanel.add(createAdminBtn);

        profileNameText = new JTextField();
        profileUsernameText = new JTextField();
        profilePasswordText = new JTextField();

        createProfilePanel = new JPanel(new GridLayout(0, 1));
        createProfilePanel.add(new JLabel("Name:"));
        createProfilePanel.add(profileNameText);
        createProfilePanel.add(new JLabel("Username:"));
        createProfilePanel.add(profileUsernameText);
        createProfilePanel.add(new JLabel("Password:"));
        createProfilePanel.add(profilePasswordText);

    }

    public int createLoginOptionPane() {
        return JOptionPane.showConfirmDialog(null, loginPanel, "Login", JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE);
    }

    public int createProfileOptionPane() {
        return JOptionPane.showConfirmDialog(null, createProfilePanel, "Create profile", JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE);
    }
}
