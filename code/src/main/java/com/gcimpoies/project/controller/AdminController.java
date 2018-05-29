package com.gcimpoies.project.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.gcimpoies.project.service.AdminService;
import com.gcimpoies.project.view.AdminView;
import com.gcimpoies.project.view.UserView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class AdminController {

    private AdminView adminView;
    @Autowired
    UserView userView;

    public AdminController(AdminView adminView, AdminService adminService) {
        this.adminView = adminView;
       /* adminView.setTeacherViewInfoListener(new TeacherViewInfoListener());
        adminView.setTeacherViewCourseListener(new TeacherViewCoursesListener());
        adminView.setTeacherViewStudentsListener(new TeacherViewStudentsListener());
        adminView.setTeacherEnrollListener(new TeacherEnrollListener());
        adminView.setTeacherDeleteEnrollListener(new TeacherDeleteEnrollListener());
        adminView.setTeacherUpdateEnrollListener(new TeacherUpdateEnrollListener());
        adminView.setGenerateReportListener(new TeacherGenerateReportListener());*/
    }

   /* public void setAdminView(AdminView adminView) {
        this.adminView = adminView;
    }

    private class TeacherViewInfoListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == adminView.viewTeacherInfoBtn) {
                String teacherName = "";
                teacherName = adminView.teacherNameText.getText();
                adminView.areaInfo.setText(teacherService.getTeacherByName(teacherName).toString());
            }
        }
    }

    private class TeacherViewCoursesListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == adminView.viewTeacherCoursesBtn) {
                int teacherId = 0;
                teacherId = Integer.parseInt(adminView.teacherIdText.getText());
                adminView.areaInfo.setText(courseService.getCourses(teacherId).toString()
                        .substring(1, courseService.getCourses(teacherId).toString().length() - 1).replace(",", "\n"));
            }
        }
    }

    private class TeacherViewStudentsListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == adminView.viewTeacherStudentsBtn) {
                int courseId = 0;
                courseId = Integer.parseInt(adminView.courseIdText.getText());
                CourseDto courseDto = new CourseDto();
                courseDto.setCourseId(courseId);

                adminView.areaInfo.setText(courseService.setCourseId(courseDto).toString()
                        .substring(1, courseService.setCourseId(courseDto).toString().length() - 1).replace(",", "\n"));
            }
        }
    }

    private class TeacherEnrollListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == adminView.createEnrollmentBtn) {
                int courseId = 0;
                int studentId = 0;
                courseId = Integer.parseInt(adminView.courseEnrolIdText.getText());
                studentId = Integer.parseInt(adminView.studentEnrolIdText.getText());
                EnrollmentDto enrollmentDto = new EnrollmentDto();

                enrollmentDto.setCourse(courseService.findById(courseId));
                enrollmentDto.setStudent(studentService.getStudentById(studentId));
                enrollmentDto.setExam(examService.getExamById(2));

                adminView.areaInfo.setText(enrollmentService.createEnrollment(enrollmentDto));
            }
        }
    }

    private class TeacherDeleteEnrollListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == adminView.deleteEnrollmentBtn) {
                int enrollId = 0;
                enrollId = Integer.parseInt(adminView.enrollIdText.getText());
                adminView.areaInfo
                        .setText("Enrollment: " + enrollmentService.getEnrollmentById(enrollId) + " deleted");
                enrollmentService.deleteEnrollment(enrollId);
            }
        }
    }

    private class TeacherUpdateEnrollListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == adminView.updateEnrollmentBtn) {
                int examId = 0;
                int enrollId = 0;
                examId = Integer.parseInt(adminView.examIdText.getText());
                enrollId = Integer.parseInt(adminView.enrollIdText.getText());
                enrollmentService.updateExam(enrollmentService.getEnrollmentById(enrollId),
                        examService.getExamById(examId));
                adminView.areaInfo.setText(enrollmentService.getEnrollmentById(enrollId) + "\nUpdated successfully!");
            }
        }
    }

    private class TeacherGenerateReportListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == adminView.generateReportBtn) {
                String teacherName = "";
                teacherName = adminView.teacherNameText.getText();
                teacherService.factoryMethod("teacher", teacherName);
                adminView.areaInfo.setText("Teacher request generated in 'reportsCollection' collection\n from 'reports' mongoDB ");
            }
        }
    }*/


}
