package com.gcimpoies.project.view;

import org.springframework.stereotype.Component;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;

@Component
public class UserView {

    public JFrame userFrame;
    public JPanel userPanel;
    public JScrollPane userScroll;
    public JScrollPane areaScrollPane;
    public DefaultTableModel tableModel;
    public JTextArea areaInfo;

    public JTable userTable;
    HomeView homeView = new HomeView();

    public UserView() {
        initialize();
    }

    public void setUserTableListener(MouseAdapter mouseAdapter) {
        userTable.addMouseListener(mouseAdapter);
    }

    private void initialize() {
        userFrame = new JFrame();
        userFrame.setBounds(0, 0, 1050, 550);
        userFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        userFrame.setLocationRelativeTo(null);
        userFrame.getContentPane().setLayout(null);
        userFrame.setTitle("User");

        userPanel = new JPanel();
        userPanel.setLayout(null);
        userPanel.setBounds(0, 0, 1050, 550);
        userPanel.setVisible(true);
        userPanel.setBackground(Color.WHITE);

        Object col[] = {"Articles"};
        tableModel = new DefaultTableModel(col, 0);
        userTable = new JTable();
        userTable.setModel(tableModel);
        userTable.setBounds(615, 10, 400, 485);
        userPanel.add(userTable);

        userScroll = new JScrollPane(userTable);
        userScroll.setBounds(615, 10, 400, 485);
        userScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        userFrame.add(userScroll);
        userFrame.add(userPanel);

        areaInfo = new JTextArea();
        areaInfo.setBounds(10, 10, 590, 485);

        areaScrollPane = new JScrollPane(areaInfo);
        areaScrollPane.setBounds(10, 10, 590, 485);
        areaScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        userPanel.add(areaScrollPane);

    }
}
