package com.gcimpoies.project.view;

import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.gcimpoies.project.view.HomeView;
import org.springframework.stereotype.Component;

@Component
public class UserView {

    HomeView homeView = new HomeView();

    public JPanel panelStudent;
    public JPanel createProfilePanel;

    public JButton viewStudentInfoBtn;
    public JButton createStudentBtn;
    public JButton updateStudentBtn;
    public JButton viewStudentCoursesBtn;
    public JButton viewStudentGradesBtn;

    public JTextField studentNameText;
    public JTextField nameText;
    public JTextField cardText;
    public JTextField personalCodeText;
    public JTextField addressText;
    public JTextField profileNameText;
    public JTextField profileCardText;
    public JTextField profilePersonalNrText;
    public JTextField profileAddressText;
    public JTextField profileGroupText;

    public JTextField editStudentIdText;
    public JTextField editStudentGroupText;

    public JTextArea areaInfo;

    public UserView() {
        initialize();
    }

    public void setStudentViewInfoListener(ActionListener actionListener) {
        viewStudentInfoBtn.addActionListener(actionListener);
    }

    public void setStudentCreateProfileListener(ActionListener actionListener) {
        createStudentBtn.addActionListener(actionListener);
    }

    public void setStudentUpdateProfileListener(ActionListener actionListener) {
        updateStudentBtn.addActionListener(actionListener);
    }

    public void setStudentViewCoursesListener(ActionListener actionListener) {
        viewStudentCoursesBtn.addActionListener(actionListener);
    }

    public void setStudentViewGradesListener(ActionListener actionListener) {
        viewStudentGradesBtn.addActionListener(actionListener);
    }

    private void initialize() {

        panelStudent = new JPanel();
        panelStudent.setBounds(0, 45, 550, 312);
        panelStudent.setLayout(null);
        homeView.frame.getContentPane().add(panelStudent);
        panelStudent.setVisible(false);
        viewStudentInfoBtn = new JButton("View info");
        viewStudentInfoBtn.setBounds(130, 10, 100, 20);
        panelStudent.add(viewStudentInfoBtn);

        createStudentBtn = new JButton("Create profile");
        createStudentBtn.setBounds(60, 240, 120, 20);
        panelStudent.add(createStudentBtn);

        viewStudentGradesBtn = new JButton("View Grades");
        viewStudentGradesBtn.setBounds(60, 210, 120, 20);
        panelStudent.add(viewStudentGradesBtn);

        viewStudentCoursesBtn = new JButton("View courses");
        viewStudentCoursesBtn.setBounds(60, 175, 120, 20);
        panelStudent.add(viewStudentCoursesBtn);

        studentNameText = new JTextField("Student name");
        studentNameText.setBounds(10, 10, 100, 20);
        panelStudent.add(studentNameText);

        editStudentIdText = new JTextField("Student id");
        editStudentIdText.setBounds(70, 60, 100, 20);
        panelStudent.add(editStudentIdText);

        editStudentGroupText = new JTextField("Student group");
        editStudentGroupText.setBounds(70, 100, 100, 20);
        panelStudent.add(editStudentGroupText);

        updateStudentBtn = new JButton("Update profile");
        updateStudentBtn.setBounds(60, 140, 120, 20);
        panelStudent.add(updateStudentBtn);

        areaInfo = new JTextArea();
        areaInfo.setBounds(250, 10, 245, 245);
        panelStudent.add(areaInfo);

        profileNameText = new JTextField();
        profileCardText = new JTextField();
        profilePersonalNrText = new JTextField();
        profileAddressText = new JTextField();
        profileGroupText = new JTextField();

        createProfilePanel = new JPanel(new GridLayout(0, 1));
        createProfilePanel.add(new JLabel("Name:"));
        createProfilePanel.add(profileNameText);
        createProfilePanel.add(new JLabel("CardNr:"));
        createProfilePanel.add(profileCardText);
        createProfilePanel.add(new JLabel("PNC:"));
        createProfilePanel.add(profilePersonalNrText);
        createProfilePanel.add(new JLabel("Address:"));
        createProfilePanel.add(profileAddressText);
        createProfilePanel.add(new JLabel("Group:"));
        createProfilePanel.add(profileGroupText);

    }

    public int createOptionPane() {
        return JOptionPane.showConfirmDialog(null, createProfilePanel, "Create profile", JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE);
    }
}
