package com.gcimpoies.project.actionlisteners;

import com.gcimpoies.project.model.Season;
import com.gcimpoies.project.model.TvShow;
import com.gcimpoies.project.service.TvShowService;
import com.gcimpoies.project.view.AdminView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

@Service
public class AddTvShowListener implements ActionListener {
    @Autowired
    TvShowService tvShowService;
    @Autowired
    AdminView adminView;

    String tvShowName = "";
    String tvShowDescription = "";
    String numberOfSeasons = "";

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == adminView.addTvShowBtn) {
            try {
                tvShowName = adminView.tvShowName.getText();
                tvShowDescription = adminView.tvShowDescription.getText();
                numberOfSeasons = adminView.numberOfSeasons.getText();
                TvShow tvShow = new TvShow(tvShowName, tvShowDescription, 0);
                List<Season> seasons = new ArrayList<>();
                for (int i = 0; i < Integer.valueOf(numberOfSeasons); i++) {
                    seasons.add(new Season());
                }
                tvShowService.createTvShow(tvShow);

            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
    }
}