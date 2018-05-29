package com.gcimpoies.project.view;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.gcimpoies.project.view.HomeView;
import org.springframework.stereotype.Component;

@Component
public class AdminView {

    HomeView homeView = new HomeView();

    public JButton viewTeacherInfoBtn;
    public JButton viewTeacherCoursesBtn;
    public JButton viewTeacherStudentsBtn;
    public JButton createEnrollmentBtn;
    public JButton deleteEnrollmentBtn;
    public JButton updateEnrollmentBtn;
    public JButton generateReportBtn;

    public JPanel panelTeacher;

    public JTextField teacherNameText;
    public JTextField teacherIdText;
    public JTextField courseIdText;
    public JTextField studentEnrolIdText;
    public JTextField courseEnrolIdText;
    public JTextField enrollIdText;
    public JTextField examIdText;

    public JTextArea areaInfo;

    public JScrollPane scrollPane;

    public AdminView() {
        initialize();
    }

    public void setTeacherViewInfoListener(ActionListener actionListener) {
        viewTeacherInfoBtn.addActionListener(actionListener);
    }

    public void setTeacherViewCourseListener(ActionListener actionListener) {
        viewTeacherCoursesBtn.addActionListener(actionListener);
    }

    public void setTeacherViewStudentsListener(ActionListener actionListener) {
        viewTeacherStudentsBtn.addActionListener(actionListener);
    }

    public void setTeacherEnrollListener(ActionListener actionListener) {
        createEnrollmentBtn.addActionListener(actionListener);
    }

    public void setTeacherDeleteEnrollListener(ActionListener actionListener) {
        deleteEnrollmentBtn.addActionListener(actionListener);
    }

    public void setTeacherUpdateEnrollListener(ActionListener actionListener) {
        updateEnrollmentBtn.addActionListener(actionListener);
    }

    public void setGenerateReportListener(ActionListener actionListener) {
        generateReportBtn.addActionListener(actionListener);
    }

    private void initialize() {

        panelTeacher = new JPanel();
        panelTeacher.setBounds(0, 45, 550, 312);
        panelTeacher.setLayout(null);
        homeView.frame.getContentPane().add(panelTeacher);
        panelTeacher.setVisible(false);

        viewTeacherInfoBtn = new JButton("View info");
        viewTeacherInfoBtn.setBounds(115, 10, 120, 20);
        panelTeacher.add(viewTeacherInfoBtn);

        viewTeacherCoursesBtn = new JButton("View courses");
        viewTeacherCoursesBtn.setBounds(115, 55, 120, 20);
        panelTeacher.add(viewTeacherCoursesBtn);

        viewTeacherStudentsBtn = new JButton("View students");
        viewTeacherStudentsBtn.setBounds(115, 80, 120, 20);
        panelTeacher.add(viewTeacherStudentsBtn);

        createEnrollmentBtn = new JButton("Enroll");
        createEnrollmentBtn.setBounds(115, 150, 120, 20);
        panelTeacher.add(createEnrollmentBtn);

        deleteEnrollmentBtn = new JButton("Delete enroll");
        deleteEnrollmentBtn.setBounds(115, 200, 120, 20);
        panelTeacher.add(deleteEnrollmentBtn);

        updateEnrollmentBtn = new JButton("Update grade");
        updateEnrollmentBtn.setBounds(115, 230, 120, 20);
        panelTeacher.add(updateEnrollmentBtn);

        generateReportBtn = new JButton("Gen. report");
        generateReportBtn.setBounds(115, 115, 120, 20);
        panelTeacher.add(generateReportBtn);


        teacherNameText = new JTextField("Teacher name");
        teacherNameText.setBounds(10, 10, 100, 20);
        panelTeacher.add(teacherNameText);

        teacherIdText = new JTextField("Teacher id");
        teacherIdText.setBounds(10, 55, 100, 20);
        panelTeacher.add(teacherIdText);

        courseIdText = new JTextField("Course id");
        courseIdText.setBounds(10, 80, 100, 20);
        panelTeacher.add(courseIdText);

        studentEnrolIdText = new JTextField("Student id");
        studentEnrolIdText.setBounds(10, 140, 100, 20);
        panelTeacher.add(studentEnrolIdText);

        courseEnrolIdText = new JTextField("Course id");
        courseEnrolIdText.setBounds(10, 160, 100, 20);
        panelTeacher.add(courseEnrolIdText);

        enrollIdText = new JTextField("Enroll id");
        enrollIdText.setBounds(10, 200, 100, 20);
        panelTeacher.add(enrollIdText);

        examIdText = new JTextField("New grade");
        examIdText.setBounds(10, 230, 100, 20);
        panelTeacher.add(examIdText);

        areaInfo = new JTextArea();
        areaInfo.setBounds(250, 10, 245, 245);

        scrollPane = new JScrollPane(areaInfo);
        scrollPane.setBounds(250, 10, 245, 245);
        panelTeacher.add(scrollPane);

    }

}
