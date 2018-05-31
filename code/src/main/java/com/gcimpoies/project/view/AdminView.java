package com.gcimpoies.project.view;

import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.event.ActionListener;

@Component
public class AdminView {
    public JFrame adminFrame;
    public JPanel adminPanel;

    public JTextField passwordNewText;
    public JTextField tvShowName;
    public JTextField tvShowDescription;
    public JTextField numberOfSeasons;

    public JButton updateAdminBtn;
    public JButton deleteAdminBtn;
    public JButton chooseRelatedArticlesBtn;
    public JButton addTvShowBtn;

    public JScrollPane listScrollPane;

    public JList<String> relatedList;
    public DefaultListModel<String> relatedModel;

    HomeView homeView = new HomeView();

    public AdminView() {
        initialize();
    }

    public void setAdminUpdateProfileListener(ActionListener actionListener) {
        updateAdminBtn.addActionListener(actionListener);
    }

    public void setAdminDeleteProfileListener(ActionListener actionListener) {
        deleteAdminBtn.addActionListener(actionListener);
    }

    public void setchooseRelatedArticlesBtnListener(ActionListener actionListener) {
        chooseRelatedArticlesBtn.addActionListener(actionListener);
    }

    public void setPublishListener(ActionListener actionListener) {
        addTvShowBtn.addActionListener(actionListener);
    }

    public void chooseRelatedArticlesListener(ActionListener actionListener) {
        chooseRelatedArticlesBtn.addActionListener(actionListener);
    }

    private void initialize() {
        adminFrame = new JFrame();
        adminFrame.setBounds(0, 0, 1050, 450);
        adminFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        adminFrame.getContentPane().setLayout(null);
        adminFrame.setTitle("Admin");
        adminFrame.setLocationRelativeTo(null);

        adminPanel = new JPanel();
        adminPanel.setBounds(0, 0, 1050, 450);
        adminPanel.setLayout(null);
        adminFrame.add(adminPanel);

        passwordNewText = new JTextField("New password");
        passwordNewText.setBounds(10, 350, 120, 20);
        adminPanel.add(passwordNewText);

        tvShowName = new JTextField("TV Show Name");
        tvShowName.setBounds(10, 50, 120, 20);
        adminPanel.add(tvShowName);

        tvShowDescription = new JTextField("TV Show Description");
        tvShowDescription.setBounds(10, 80, 120, 20);
        adminPanel.add(tvShowDescription);

        numberOfSeasons = new JTextField("Number of seasons");
        numberOfSeasons.setBounds(10, 110, 120, 20);
        adminPanel.add(numberOfSeasons);

        updateAdminBtn = new JButton("Update profile");
        updateAdminBtn.setBounds(140, 350, 120, 20);
        adminPanel.add(updateAdminBtn);

        deleteAdminBtn = new JButton("Delete profile");
        deleteAdminBtn.setBounds(270, 350, 120, 20);
        adminPanel.add(deleteAdminBtn);

        addTvShowBtn = new JButton("Add TV Show");
        addTvShowBtn.setBounds(800, 340, 190, 30);
        adminPanel.add(addTvShowBtn);

        relatedModel = new DefaultListModel<>();
        relatedList = new JList<>(relatedModel);
        relatedList.setBounds(800, 40, 200, 250);
        relatedList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        relatedList.setLayoutOrientation(JList.VERTICAL);
        adminPanel.add(relatedList);

        listScrollPane = new JScrollPane(relatedList);
        listScrollPane.setBounds(800, 40, 200, 250);
        listScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        adminPanel.add(listScrollPane);

    }

}
