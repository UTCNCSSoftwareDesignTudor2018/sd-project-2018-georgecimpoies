package com.gcimpoies.project.controller;

import com.gcimpoies.project.model.User;
import com.gcimpoies.project.service.TvShowService;
import com.gcimpoies.project.service.UserService;
import com.gcimpoies.project.view.UserView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


@Controller
public class UserController implements Observer {
    @Autowired
    UserView userView;
    @Autowired
    UserService userService;
    @Autowired
    TvShowService tvShowService;

    public UserController(UserView userView) {
        this.userView = userView;
        userView.setUserTableListener(new UserTableListener());
    }

    @Override
    public void update() {
    }

    public User createProfile(User user) {
        return userService.createUser(user);
    }

 /*   public void runClient(UserController userController, ArticleService articleService) throws JSONException {
        client = new Client(userController);
        try {
            client.run();
            articleService.getObserverList().add(userController);
            client.messageFromGUI("GET_ALL_ARTICLES", "");
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    public void setUserView(UserView userView) {
        this.userView = userView;
    }

    public void displayArticleTitles(String articles)
            throws JSONException, JsonParseException, JsonMappingException, IOException {
        userView.tableModel.getDataVector().removeAllElements();
        userView.tableModel.fireTableDataChanged();
        List<Article> articleList = JsonUtil.convertJsonToList(articles);
        for (Article a : articleList) {
            userView.tableModel.addRow(new Object[] { a.getArticleTitle() });
        }
    }

    public void displayArticleBody(String jsonArticle)
            throws JSONException, JsonParseException, JsonMappingException, IOException {

        Article article = JsonUtil.convertJsonToJava(jsonArticle, Article.class);
        userView.areaInfo.setText("");
        userView.areaInfo
                .append("Abstract: \n" + article.getArticleAbstract() + "\n\n" + article.getArticleBody() + "\n");
    }*/

    private class UserTableListener extends MouseAdapter {

        @Override
        public void mouseClicked(MouseEvent e) {
            if (e.getSource() == userView.userTable) {

                Point point = e.getPoint();
                int row = userView.userTable.rowAtPoint(point);
                int col = userView.userTable.columnAtPoint(point);
                String title = (String) userView.userTable.getValueAt(row, col);
                if (e.getClickCount() == 1 && userView.userTable.getSelectedRow() != -1) {

                }
            }

        }
    }
}
