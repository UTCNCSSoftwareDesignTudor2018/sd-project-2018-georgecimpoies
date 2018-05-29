package com.gcimpoies.project.view;

import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.springframework.stereotype.Component;

@Component
public class HomeView {

    public JFrame frame;

    public JPanel panelHome;

    public JButton loginStudentBtn;
    public JButton loginTeacherBtn;

    public JFrame getFrame() {
        return frame;
    }

    public HomeView() {
        initialize();
    }

    public void setStudentLoginListener(ActionListener actionListener) {
        loginStudentBtn.addActionListener(actionListener);
    }

    public void setTeacherLoginListener(ActionListener actionListener) {
        loginTeacherBtn.addActionListener(actionListener);
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 550, 357);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        frame.setLocationRelativeTo(null);

        panelHome = new JPanel();
        panelHome.setBounds(0, 0, 550, 45);
        panelHome.setBackground(Color.GRAY);
        panelHome.setLayout(null);
        frame.add(panelHome);

        loginStudentBtn = new JButton("Student Login");
        loginStudentBtn.setBounds(100, 10, 144, 25);
        panelHome.add(loginStudentBtn);

        loginTeacherBtn = new JButton("Teacher Login");
        loginTeacherBtn.setBounds(280, 10, 144, 25);
        panelHome.add(loginTeacherBtn);

    }
}
