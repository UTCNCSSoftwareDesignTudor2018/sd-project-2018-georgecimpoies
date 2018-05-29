package com.gcimpoies.project.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import com.gcimpoies.project.service.UserService;
import com.gcimpoies.project.view.AdminView;
import com.gcimpoies.project.view.UserView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {

    private UserView userView;
    @Autowired
    UserService studentService;
    @Autowired
    AdminView adminView;

    public UserController(UserView userView, UserService userService) {
        this.userView = userView;
/*        userView.setStudentViewInfoListener(new StudentViewInfoListener());
        userView.setStudentCreateProfileListener(new StudentCreateProfileListener());
        userView.setStudentUpdateProfileListener(new StudentUpdateProfileListener());
        userView.setStudentViewCoursesListener(new StudentViewCoursesListener());
        userView.setStudentViewGradesListener(new StudentViewGradesListener());*/

    }

    public void setUserView(UserView userView) {
        this.userView = userView;
    }

    /*private class StudentViewInfoListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == userView.viewStudentInfoBtn) {
                String studentName = "";
                studentName = userView.studentNameText.getText();
                userView.areaInfo.setText(studentService.getStudentByName(studentName).toString());
            }
        }
    }

    private class StudentCreateProfileListener implements ActionListener {
        String name = "";
        String card = "";
        String pnc = "";
        String address = "";
        String group = "";

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == userView.createStudentBtn) {
                int optionPaneResult = userView.createOptionPane();
                if (optionPaneResult == JOptionPane.OK_OPTION) {
                    name = userView.profileNameText.getText();
                    card = userView.profileCardText.getText();
                    pnc = userView.profilePersonalNrText.getText();
                    address = userView.profileAddressText.getText();
                    group = userView.profileGroupText.getText();
                } else {
                    System.out.println("Cancelled");
                }
                StudentDto studentDto = new StudentDto(name, card, pnc, address, group);
                studentService.createStudent(studentDto);
            }

        }
    }

    private class StudentUpdateProfileListener implements ActionListener {
        int id = 0;
        String group = "";

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == userView.updateStudentBtn) {
                id = Integer.parseInt(userView.editStudentIdText.getText());
                group = userView.editStudentGroupText.getText();
                studentService.updateGroup(id, group);
                userView.areaInfo.setText(studentService.getStudentById(id).toString());
            }

        }
    }

    private class StudentViewCoursesListener implements ActionListener {
        int id = 0;

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == userView.viewStudentCoursesBtn) {
                id = Integer.parseInt(userView.editStudentIdText.getText());
                userView.areaInfo.setText(studentService.getCoursesByStudentId(id).toString()
                        .substring(1, studentService.getCoursesByStudentId(id).toString().length() - 1)
                        .replace(",", "\n"));
            }

        }
    }

    private class StudentViewGradesListener implements ActionListener {
        int id = 0;

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == userView.viewStudentGradesBtn) {
                id = Integer.parseInt(userView.editStudentIdText.getText());
                userView.areaInfo.setText(studentService.getGradesByStudentId(id).toString()
                        .substring(1, studentService.getGradesByStudentId(id).toString().length() - 1)
                        .replace(",", "\n"));
            }

        }
    }*/

}
