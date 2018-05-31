package com.gcimpoies.project.controller;

import com.gcimpoies.project.actionlisteners.AddTvShowListener;
import com.gcimpoies.project.model.Admin;
import com.gcimpoies.project.service.AdminService;
import com.gcimpoies.project.view.AdminView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class AdminController {
    @Autowired
    AdminView adminView;
    @Autowired
    AdminService adminService;
    @Autowired
    AddTvShowListener tvShowListener;
    private int id;
    private String password;
/*
    public AdminController() {

//        adminView.setPublishListener(tvShowListener);
*//*        adminView.setAdminUpdateProfileListener(new AdminUpdateProfileListener());
        adminView.setAdminDeleteProfileListener(new AdminDeleteProfileListener());*//*
    }*/


    public Admin createProfile(Admin admin) {
        return adminService.createAdmin(admin);
    }

  /*  private class AdminUpdateProfileListener implements ActionListener {
        String passwordNew = "";

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == adminView.updateAdminBtn) {
                passwordNew = adminView.passwordNewText.getText();
                try {
                    adminService.
                } catch (JSONException | IOException e1) {
                    e1.printStackTrace();
                }
            }

        }
    }

    private class AdminDeleteProfileListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == adminView.deleteAdminBtn) {
                try {
                    client.messageFromGUI("DELETE_PROFILE", id + "");
                } catch (JSONException | IOException e1) {

                    e1.printStackTrace();
                }
            }
        }
    }*/
}
