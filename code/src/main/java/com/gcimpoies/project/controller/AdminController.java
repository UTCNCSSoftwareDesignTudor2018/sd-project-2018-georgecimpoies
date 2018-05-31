package com.gcimpoies.project.controller;

import com.gcimpoies.project.model.Admin;
import com.gcimpoies.project.service.AdminService;
import com.gcimpoies.project.view.AdminView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@Controller
public class AdminController {
    @Autowired
    AdminView adminView;
    @Autowired
    AdminService adminService;
    private int id;
    private String password;

    public AdminController() {
        adminView.setAdminUpdateProfileListener(new AdminUpdateProfileListener());
        adminView.setAdminDeleteProfileListener(new AdminDeleteProfileListener());
        adminView.setPublishListener(new PublishListener());
        adminView.chooseRelatedArticlesListener(new RelatedArticlesListener());
    }


    public Admin createProfile(Admin admin) {
        return adminService.createAdmin(admin);
    }

    private class AdminUpdateProfileListener implements ActionListener {
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
    }

    private class PublishListener implements ActionListener {
        String articleTitle = "";
        String articleAbstract = "";
        String articleBody = "";

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == adminView.addTvShowBtn) {
                ArticleService articleService = new ArticleService();
                try {
                    articleTitle = adminView.areaTitle.getText();
                    articleAbstract = adminView.areaAbstract.getText();
                    articleBody = adminView.areaBody.getText();
                    String articleContent = articleTitle + " " + articleAbstract + " " + articleBody + " " + id;
                    client.messageFromGUI("PUBLISH_ARTICLE", articleContent);
                } catch (JSONException | IOException e1) {
                    e1.printStackTrace();
                }
            }

        }
    }

    private class RelatedArticlesListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == adminView.chooseRelatedArticlesBtn) {
                JOptionPane.showMessageDialog(null,
                        "Chosen related articles: " + adminView.relatedList.getSelectedValuesList(),
                        "Related articles chosen", JOptionPane.INFORMATION_MESSAGE);

            }
        }
    }
}
