package Db;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.text.SimpleDateFormat;
import java.util.Calendar;

//this class handles all database connections
public class DBConnectionAdmin {

    private javax.swing.JButton btn1;
    Connection connect = null;
    Statement statement = null;
    ResultSet rs = null;
    //Database configuration
    String DB_HOST = "localhost";
    String DB_PORT_NUMBER = "3306";
    String DB_NAME = "my_app";
    String DB_USER_NAME = "george";
    String DB_PASSWORD = "George29.";

    private javax.swing.JButton mark_fav;

    /**
     * Creates a new instance of ConnectToDB
     */
    //initialize the variables in this constructor
    public DBConnectionAdmin() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            //System.out.println("Where is your MySQL JDBC Driver?");
            return;
        }

        //System.out.println("MySQL JDBC Driver Registered!");
        Connection connection = null;

        try {
            connection = DriverManager
                    .getConnection(/*"jdbc:mysql://" + DB_HOST + DB_PORT_NUMBER + "/"
                            + DB_NAME + "?zeroDateTimeBehavior=convertToNull", DB_USER_NAME, DB_PASSWORD*/
                            "jdbc:mysql://localhost:3306/my_app","george","George29.");
            statement = connection.createStatement();
        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();
            return;
        }

        if (connection != null) {
            connect = connection;
            // System.out.println("You made it, take control your database now!");
        } else {
            System.out.println("Failed to make connection!");
        }
    }

    public static java.sql.Connection getMyConnection() throws Exception{

        try{//Accessing driver from the JAR file
            Class.forName("com.mysql.jdbc.Driver");

            //Creating a variable for the connection called "con"
            java.sql.Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentsmanagement","george","George29.");

            //jdbc:myql://localhost/product is the database
            //root is the database user
            //no password
            System.out.println("Connected");
            return con;
        } catch(Exception e){System.out.println(e); System.out.println("Error\n");}

        return null;
    }

    //to get connection
    public Connection getConnection() {
        return connect;
    }

    //method to update database; use this for all insert, update statements
    public void UpDateLastLoginDate(String query) {
        try {
            statement.executeUpdate(query);
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, sqle.getMessage(), "ERROR",
                    javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }

    /*
     * used to authenticate users
     * returns user type as string
     */
    public String[] auth_user(String uname, String pass) {
        String logged_user[];
        logged_user = new String[2];
        String sql1 = "select id, u_name from users where u_name=? AND password=? ";

        try {
            PreparedStatement pstmt = getMyConnection().prepareStatement(sql1);
            pstmt.setString(1, uname);
            pstmt.setString(2, pass);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                logged_user[0] = rs.getString(1);
                logged_user[1] = rs.getString(2);

                return logged_user;
            }
        } catch (Exception sqle) {
            JOptionPane.showMessageDialog(null, sqle.getMessage(), "ERROR",
                    javax.swing.JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }

    //Close the database connection
    public void closeConnection() {
        try {
            statement.close();
            connect.close();
        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, error.getMessage(), "Error",
                    javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }

    /*
     * Use this to perform all insert statements
     */
    public int executeUpdate_preparedStmt(PreparedStatement preparedStatement) {
        try {
            int executeUpdate = preparedStatement.executeUpdate();
            return executeUpdate;
        } catch (SQLException ex) {
            Logger.getLogger(DBConnectionAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public int executeUpdatePreparedStmt(PreparedStatement preparedStatement) {
        int last_inserted_id = 0;
        try {
            int executeUpdate = preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.getGeneratedKeys();
            if (rs.next()) {
                last_inserted_id = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBConnectionAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
        return last_inserted_id;
    }

    public String getTotalshows() {
        String sql = "SELECT count(*) as total_shows FROM `tv_shows` WHERE `deleted`=0;";
        String total_messages = "";
        try {
            PreparedStatement pstmt = connect.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                total_messages = rs.getString(1);
            }
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, sqle.getMessage(), "ERROR",
                    javax.swing.JOptionPane.ERROR_MESSAGE);
        }
        return total_messages;
    }

    public Object[][] getShowsList() {
        String sql = "";
        int totalshows = Integer.parseInt(getTotalshows());
//        System.out.println(totalMessages);

        Object ALL_SHOWS[][] = new Object[totalshows][9];

        sql = "SELECT `id`,`name`,`description`,`no_of_seasons`,`no_of_episodes` FROM `tv_shows`  "
                + "WHERE `deleted`=0  ORDER BY `id` DESC;";

        int rowCount = 0;
        try {
            PreparedStatement pstmt = connect.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                ALL_SHOWS[rowCount][0] = rs.getString(1) + ""; //id
                ALL_SHOWS[rowCount][1] = rowCount + 1 + ""; //id
                ALL_SHOWS[rowCount][2] = rs.getString(2) + ""; //name
                ALL_SHOWS[rowCount][3] = rs.getString(3) + ""; //desc.
                ALL_SHOWS[rowCount][4] = rs.getString(4) + ""; //episode
                ALL_SHOWS[rowCount][5] = rs.getString(5) + ""; //season

                rowCount++;
            }
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, sqle.getMessage(), "ERROR",
                    javax.swing.JOptionPane.ERROR_MESSAGE);
        }
        return ALL_SHOWS;
    }

    public Object[][] getAvailableShowsList() {

        String sql = "";
        int totalshows = Integer.parseInt(getTotalshows());
        Object ALL_SHOWS[][] = new Object[totalshows][9];
        btn1 = new javax.swing.JButton("ab");
        sql = "SELECT `id`,`name`,`no_of_seasons`,`description`,`no_of_episodes` FROM `tv_shows`  "
                + "WHERE `deleted`=0  ORDER BY `id` DESC;";

        int rowCount = 0;
        try {
            PreparedStatement pstmt = connect.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                ALL_SHOWS[rowCount][0] = rs.getString(1) + ""; //id
                ALL_SHOWS[rowCount][1] = rowCount + 1 + ""; //id
                ALL_SHOWS[rowCount][2] = rs.getString(2) + ""; //name
                ALL_SHOWS[rowCount][3] = rs.getString(3) + ""; //seasons.
                ALL_SHOWS[rowCount][4] = rs.getString(4) + ""; //desc
                ALL_SHOWS[rowCount][5] = rs.getString(5) + ""; //episodes

                rowCount++;
            }
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, sqle.getMessage(), "ERROR",
                    javax.swing.JOptionPane.ERROR_MESSAGE);
        }
        return ALL_SHOWS;
    }

    public String get_show_name(Integer id) {
        String show_name = "";
        String sql = "";
        sql = "SELECT `name` from `tv_shows` where `id`= ?";
        try {
            PreparedStatement pstmt = connect.prepareStatement(sql);
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                show_name = rs.getString(1);
            }
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, sqle.getMessage(), "ERROR",
                    javax.swing.JOptionPane.ERROR_MESSAGE);
        }
        return show_name;
    }

    public String[] getShowsList(Integer id) {
        String sql = "";
        String ALL_SHOWS[] = new String[4];

        sql = "SELECT `name`,`description`,`no_of_seasons`,`no_of_episodes` FROM `tv_shows`  "
                + "WHERE `deleted`=0 and id =?  ORDER BY `id` DESC;";

        int rowCount = 0;
        try {
            PreparedStatement pstmt = connect.prepareStatement(sql);
            pstmt.setInt(1, id);
//           System.out.println(pstmt);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                ALL_SHOWS[0] = rs.getString(1); //id
                ALL_SHOWS[1] = rs.getString(2); //name
                ALL_SHOWS[2] = rs.getString(3); //desc.
                ALL_SHOWS[3] = rs.getString(4); //season
                //  ALL_SHOWS[4] = rs.getString(5); //episode

                rowCount++;
            }
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, sqle.getMessage(), "ERROR",
                    javax.swing.JOptionPane.ERROR_MESSAGE);
        }
        return ALL_SHOWS;
    }

    public Object[][] getFavShowsList(String id) {

        String sql = "";
        int totalshows = Integer.parseInt(getTotalshows());
        Object ALL_FAV_SHOWS[][] = new Object[totalshows][5];

        sql = "SELECT tv_shows.id,name,no_of_seasons,description  FROM `tv_shows`  LEFT JOIN favourites ON "
                + "favourites.show_id=tv_shows.id WHERE  favourites.user_id =? and tv_shows.deleted=0 ";
        int rowCount = 0;
        try {
            PreparedStatement pstmt = connect.prepareStatement(sql);
            pstmt.setString(1,id);
            System.out.print(pstmt);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                ALL_FAV_SHOWS[rowCount][0] = rs.getString(1) + ""; //id
                ALL_FAV_SHOWS[rowCount][1] = rowCount + 1; //sr
                ALL_FAV_SHOWS[rowCount][2] = rs.getString(2) + ""; //name
                ALL_FAV_SHOWS[rowCount][3] = rs.getString(3) + ""; //no_of_seasons
                ALL_FAV_SHOWS[rowCount][4] = rs.getString(4) + ""; //desc
                rowCount++;
            }
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, sqle.getMessage(), "ERROR",
                    javax.swing.JOptionPane.ERROR_MESSAGE);
        }
        return ALL_FAV_SHOWS;
    }

    /**
     * get user details by user_id
     *
     * @return String array of user details
     */
    public String[] getUserDetails(String LOGGED_USER_ID) {
        String sql = "select `u_name` from users where id=?;";
        String[] user_details = new String[2];
        user_details[0] = LOGGED_USER_ID;
        try {
            PreparedStatement pstmt = connect.prepareStatement(sql);
            pstmt.setString(1, LOGGED_USER_ID);
            //System.out.println(pstmt);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                user_details[1] = rs.getString(1);

            }
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, sqle.getMessage(), "ERROR",
                    javax.swing.JOptionPane.ERROR_MESSAGE);
        }
        return user_details;
    }

    /**
     * to delete a show
     *
     * @param showID
     * @return
     */
    public int deleteShow(String showID) {
        String sql = "";
        int executeUpdate_preparedStmt = 0;
        try {
            sql = "UPDATE `tv_shows` SET `deleted`=1 WHERE `id`=?;";
            PreparedStatement pstmt2 = connect.prepareStatement(sql);
            pstmt2.setString(1, showID);
            executeUpdate_preparedStmt = executeUpdate_preparedStmt(pstmt2);
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, sqle.getMessage(), "ERROR",
                    javax.swing.JOptionPane.ERROR_MESSAGE);
        }
        return executeUpdate_preparedStmt;
    }

    public int add_episodes(int show_last_id, int season_last_id, String val) {
        int i = 0;
        int j = 0;
        int val_int = Integer.parseInt(val);
        Calendar cc = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd H:mm:ss");
        String date = "";
        for (i = 1; i <= val_int; i++) {
            j = i - 1;
            if (i == 1) {
                date = "NOW()";
            } else {
                cc.add(Calendar.DAY_OF_MONTH,7);
                //Date after adding the days to the given date
                String newDate = "'" + sdf.format(cc.getTime()) + "'";
                date = newDate;
            }
            String sql = "INSERT INTO `episodes`"
                    + "(`show_id`,`season_id`,`episode`,`date_added`) VALUES ("
                    + "?,?,?," + date + ")";
            try {
                PreparedStatement pstmt = connect.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                pstmt.setInt(1, show_last_id);
                pstmt.setInt(2, season_last_id);
                pstmt.setInt(3, i);
//                if (i == 1) {
//                    pstmt.setObject(4, "NOW()");
//                } else {
//                    pstmt.setString(4,date);
//                }
                System.err.println("query" + pstmt);
                executeUpdatePreparedStmt(pstmt);
            } catch (SQLException sqle) {
                JOptionPane.showMessageDialog(null, sqle.getMessage(), "ERROR",
                        javax.swing.JOptionPane.ERROR_MESSAGE);
            }
        }
        return 0;
    }

    public int add_seasons(int show_last_id, String val1, String val2) {
        int i = 0;
        int total_seasons = Integer.parseInt(val1);
        int total_episodes = Integer.parseInt(val2);
        for (i = 1; i <= total_seasons; i++) {
            String sql = "INSERT INTO `seasons`"
                    + "(`show_id`, `season`) VALUES ("
                    + "?,?)";
            try {
                PreparedStatement pstmt = connect.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                pstmt.setInt(1, show_last_id);
                pstmt.setInt(2, i);
                int season_last_id1 = executeUpdatePreparedStmt(pstmt);
                add_episodes(show_last_id, season_last_id1, val2);

            } catch (SQLException sqle) {
                JOptionPane.showMessageDialog(null, sqle.getMessage(), "ERROR",
                        javax.swing.JOptionPane.ERROR_MESSAGE);
            }
        }
        return 0;
    }
    public int add_show(String[] data) {
        String sql = "INSERT INTO `tv_shows`"
                + "(`name`, `description`, `no_of_seasons`,`no_of_episodes`,`date_added`) VALUES ("
                + "?,?,?,?,NOW())";
        try {
            PreparedStatement pstmt = connect.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, data[0]);
            pstmt.setString(2, data[1]);
            pstmt.setString(3, data[2]);
            pstmt.setString(4, data[3]);
//            System.out.println(pstmt);
            int lastid = executeUpdatePreparedStmt(pstmt);

            add_seasons(lastid, data[2], data[3]);

        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, sqle.getMessage(), "ERROR",
                    javax.swing.JOptionPane.ERROR_MESSAGE);
        }
        return 0;
    }
    public int update_fav_show(String[] data) {
        String sql = "INSERT INTO `favourites` (`show_id`,`user_id`,`date_added`) "
                + " VALUES (?,?,NOW())";
        try {
            PreparedStatement pstmt = connect.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, data[0]);
            pstmt.setString(2, data[1]);
            return executeUpdatePreparedStmt(pstmt);

        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, sqle.getMessage(), "ERROR",
                    javax.swing.JOptionPane.ERROR_MESSAGE);
        }
        return 0;
    }

    public Object[][] get_seasons_by_id(String id) {
        int rowCount = 0;
        int total_shows = Integer.parseInt(getTotalshows());
        Object data[][] = new Object[total_shows][3];
//     data=new String[3];
        String sql1 = "SELECT `id`,`season`,(SELECT COUNT(`episode`) FROM `episodes` WHERE `season_id`=`seasons`.`id`) as `episodes` from `seasons` "
                + " WHERE `show_id`=?";
        try {
            PreparedStatement pstmt = connect.prepareStatement(sql1, Statement.RETURN_GENERATED_KEYS);

            pstmt.setString(1, id);
            System.out.println(pstmt);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                data[rowCount][0] = rs.getString(1) + ""; //id
                data[rowCount][1] = rs.getString(2) + ""; //id
                data[rowCount][2] = rs.getString(3) + ""; //id

                rowCount++;
            }
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, sqle.getMessage(), "ERROR",
                    javax.swing.JOptionPane.ERROR_MESSAGE);
        }
        return data;
    }

    public Object[][] get_episodes_by_id(String id) {
        int rowCount = 0;
        int total_shows = Integer.parseInt(getTotalshows());
        Object data[][] = new Object[total_shows][3];
//     data=new String[3];
        String sql1 = "SELECT `id`,`episode` FROM `episodes` "
                + " WHERE `season_id`=?";
        try {
            PreparedStatement pstmt = connect.prepareStatement(sql1, Statement.RETURN_GENERATED_KEYS);

            pstmt.setString(1, id);
            System.out.println(pstmt);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                data[rowCount][0] = rs.getString(1) + ""; //id
                data[rowCount][1] = rs.getString(2) + ""; //id

                rowCount++;
            }
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, sqle.getMessage(), "ERROR",
                    javax.swing.JOptionPane.ERROR_MESSAGE);
        }
        return data;
    }

    public int edit_show(String[] data) {
        String sql = "UPDATE `tv_shows` SET "
                + "`name` =?, `description`=?,`date_modified`= NOW() WHERE `id`=?";
        try {
            PreparedStatement pstmt = connect.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, data[0]);
            pstmt.setString(2, data[1]);
            pstmt.setString(3, data[2]);

            return executeUpdatePreparedStmt(pstmt);

        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, sqle.getMessage(), "ERROR",
                    javax.swing.JOptionPane.ERROR_MESSAGE);
        }
        return 0;
    }

    public String[] check_any_new_episode(String id) {
        int unReadMessageCount = 0;
        String data[] = new String[3];
        String sql = " SELECT id,name FROM tv_shows WHERE deleted=0 and id in (SELECT show_id FROM `episodes` " +
                "WHERE date_added > (select last_seen from users where id=?)"
                + " and show_id in (SELECT show_id FROM favourites WHERE user_id=?))";
        try {
            PreparedStatement pstmt = connect.prepareStatement(sql);
            pstmt.setString(1, id);
            pstmt.setString(2, id);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                data[0] = rs.getString(1);
                data[1] = rs.getString(2);
            }
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, sqle.getMessage(), "ERROR",
                    javax.swing.JOptionPane.ERROR_MESSAGE);
        }
        return data;
    }
}
