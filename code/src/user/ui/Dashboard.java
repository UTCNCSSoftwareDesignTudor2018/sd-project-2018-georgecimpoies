/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package user.ui;

import Db.DBConnectionAdmin;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.TableColumn;

public class Dashboard extends javax.swing.JFrame {

    private ViewSeasons viewseasonObject;
    private NewMessagePopup newMessagePopupObject;
    private static Dashboard dashBoardObject;
    private DBConnectionAdmin db;
    private String[] USER_DETAILS_DB;
    private String[] USER_DETAILS;
    private String LOGGED_USER_ID = "";
    private String LOGGED_NAME = "";
    private JOptionPane JOptionUnableToConnect;
    private Object[][] OBJECT_TV_SHOWS;
    private Object[][] OBJECT_FAV_TV_SHOWS;
    private int[] selectedRows;
    public String USER_ID = "";
    public boolean newMessageUp = false;
    

    /**
     * Creates new form Dashboard
     */
    public Dashboard() {
        initComponents();
    }

    public Dashboard(String logged_user) {
        initComponents();
        dashBoardObject = this;

        db = new DBConnectionAdmin();
        USER_DETAILS_DB = db.getUserDetails(logged_user);

        LOGGED_USER_ID = USER_DETAILS_DB[0];
        LOGGED_NAME = USER_DETAILS_DB[1];

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                loadAllshowsTable();
            }
        });
        //gather user details
        USER_DETAILS = new String[10];
        USER_DETAILS[0] = USER_DETAILS_DB[0];
        USER_DETAILS[1] = USER_DETAILS_DB[1];

        if ((USER_DETAILS[1] + "").equalsIgnoreCase("admin")) {

        } else {
            text_logged_in_as.setText("Standard User: " + USER_DETAILS[1]);
        }

        //load autorefresh function
        startTask();
    }

    public void autoRefresh() {
        loadAllshowsTable();
        String data[] = new String[3];
        if (!newMessageUp) {
            data = db.check_any_new_episode(LOGGED_USER_ID);
            if (data[1] != null) {
                System.err.println("hii");
                newMessageReceivedDialog(data[1]);
                newMessageUp = true;
            }
        }
    }

    private void loadAllshowsTable() {
        int selectedRow = mainTable.getSelectedRow();
        OBJECT_TV_SHOWS = db.getAvailableShowsList();

        //set column names of the jtable
        String AttributeNames[];
        AttributeNames = new String[5];
        AttributeNames[0] = "ID";
        AttributeNames[1] = "Sr.No.";
        AttributeNames[2] = "Title";
        AttributeNames[3] = "Action";
        AttributeNames[4] = "Title";

        mainTable.setModel(new javax.swing.table.DefaultTableModel(OBJECT_TV_SHOWS, AttributeNames) {
            boolean[] canEdit = new boolean[]{
                false, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        mainTable.getTableHeader().setReorderingAllowed(false);
        mainTable.getTableHeader().setResizingAllowed(false);
        for (int i = 0; i < mainTable.getColumnCount(); i++) {
            DefaultTableColumnModel colModel = (DefaultTableColumnModel) mainTable.getColumnModel();
            TableColumn col = colModel.getColumn(i);
            int width = 0, width1 = 0;

            switch (i) {
                case 1:
                    col.setPreferredWidth(40);
                    break;
                case 2:
                    col.setPreferredWidth(120);
                    break;
                case 3:
                    col.setPreferredWidth(100);
                    break;
            }
        }
        mainTable.getColumnModel().getColumn(0).setMinWidth(0);
        mainTable.getColumnModel().getColumn(0).setMaxWidth(0);
        mainTable.getColumnModel().getColumn(0).setWidth(0);
    }

    private void loadFavShowsTable() {
        int selectedRow = messagesTable1.getSelectedRow();
        OBJECT_FAV_TV_SHOWS = db.getFavShowsList(LOGGED_USER_ID);
        //set column names of the jtable
        String AttributeNames[];
        AttributeNames = new String[5];
        AttributeNames[0] = "ID";
        AttributeNames[1] = "Sr.No.";
        AttributeNames[2] = "Name";
        AttributeNames[3] = "No of Seasons";
        AttributeNames[4] = "Description";

        messagesTable1.setModel(new javax.swing.table.DefaultTableModel(OBJECT_FAV_TV_SHOWS, AttributeNames) {
            boolean[] canEdit = new boolean[]{
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        messagesTable1.getTableHeader().setReorderingAllowed(false);
        messagesTable1.getTableHeader().setResizingAllowed(false);
        for (int i = 0; i < messagesTable1.getColumnCount(); i++) {
            DefaultTableColumnModel colModel = (DefaultTableColumnModel) messagesTable1.getColumnModel();
            TableColumn col = colModel.getColumn(i);
            int width = 0, width1 = 0;

            switch (i) {
                case 1:
                    col.setPreferredWidth(20);
                    break;
                case 2:
                    col.setPreferredWidth(120);
                    break;
                case 3:
                    col.setPreferredWidth(120);
                    break;

            }
        }
        messagesTable1.getColumnModel().getColumn(0).setMinWidth(0);
        messagesTable1.getColumnModel().getColumn(0).setMaxWidth(0);
        messagesTable1.getColumnModel().getColumn(0).setWidth(0);
    }

    /**
     * Background process after fixed interval
     */
    private static Timer cloclTimer;
    private static boolean stopped = false;
    private static boolean unableToPing = false;
    private static ActionListener reloadData = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            if (!stopped) {
                dashBoardObject.autoRefresh();
            }
        }
    };

    public void startTask() {
        stopped = false;
        long intervaal = 15000;
        cloclTimer = new Timer((int) intervaal, reloadData);
        cloclTimer.start();
    }

    public void stopTask() {
        cloclTimer.stop();
        stopped = true;
    }
    /* End background process */

    public void updateStatusBar(String status_message) {
        label_status_bar.setText(status_message);
    }

    private void confirm_exit() {
        Object[] options = {"Yes",
            "Cancel"};
        int n = JOptionPane.showOptionDialog(this,
                "Do you want to exit App?",
                "My App",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[1]);
        switch (n) {
            case 0:
                String updateLdate = "UPDATE `users` SET `last_seen` = NOW() WHERE "
                        + "`id`=" + LOGGED_USER_ID + ";";
//                System.out.print(updateLdate);
                db.UpDateLastLoginDate(updateLdate);

                System.exit(0);
                break;
            case 1:
                break;
        }
    }

    /**
     * Called when user needs to be notified by popup dialog
     */
    private void newMessageReceivedDialog(String title) {
        newMessagePopupObject = new NewMessagePopup(dashBoardObject, title);
        newMessagePopupObject.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem5 = new javax.swing.JMenuItem();
        jPanel2 = new javax.swing.JPanel();
        label_status_bar = new javax.swing.JLabel();
        text_logged_in_as = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btn_load_fav = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        mainTable = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        messagesTable1 = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        menu_file = new javax.swing.JMenu();
        menu_item_exit = new javax.swing.JMenuItem();
        menu_action = new javax.swing.JMenu();
        menu_item_mark_fav = new javax.swing.JMenuItem();
        menu_item_see_seasons = new javax.swing.JMenuItem();

        jMenuItem5.setText("jMenuItem5");

        

        setTitle("MY APP");

        label_status_bar.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        label_status_bar.setText("My App");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label_status_bar)
                .addContainerGap(399, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(label_status_bar)
                .addGap(0, 6, Short.MAX_VALUE))
        );

        text_logged_in_as.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        text_logged_in_as.setText("jLabel1");

        jLabel2.setText("All TV Shows");

        jLabel3.setText("Favourite List");

        btn_load_fav.setText("Load Favourite List");
        btn_load_fav.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_load_favActionPerformed(evt);
            }
        });

        mainTable.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        mainTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Sr. No.", "Name", "No of Seasons", "Description"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        mainTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mainTableMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                mainTablemessageRowDoubleClick(evt);
            }
        });
        jScrollPane1.setViewportView(mainTable);

        messagesTable1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        messagesTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Sr. No.", "Name", "No of  Seasons", "Description"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(messagesTable1);

        menu_file.setText("File");

        menu_item_exit.setText("Exit");
        menu_item_exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_item_exitActionPerformed(evt);
            }
        });
        menu_file.add(menu_item_exit);

        jMenuBar1.add(menu_file);

        menu_action.setText("Action");

        menu_item_mark_fav.setText("Mark Favourite");
        menu_item_mark_fav.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_item_mark_favActionPerformed(evt);
            }
        });
        menu_action.add(menu_item_mark_fav);

        menu_item_see_seasons.setText("See Seasons");
        menu_item_see_seasons.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_item_see_seasonsActionPerformed(evt);
            }
        });
        menu_action.add(menu_item_see_seasons);

        jMenuBar1.add(menu_action);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(text_logged_in_as, javax.swing.GroupLayout.DEFAULT_SIZE, 379, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(45, 45, 45)
                .addComponent(btn_load_fav)
                .addGap(101, 101, 101))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(442, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(28, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(jLabel3))
                    .addComponent(btn_load_fav, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(text_logged_in_as, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(58, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 445, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(59, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menu_item_mark_favActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_item_mark_favActionPerformed
        selectedRows = mainTable.getSelectedRows();
        if (selectedRows.length <= 0) {
            JOptionPane.showMessageDialog(this, "Select a TV Show to Add as FAVOURITE!", "My App", JOptionPane.ERROR_MESSAGE);
            return;
        }
        int locShowId = 0;
        String data[];
        data = new String[3];
        for (int i = 0; i < selectedRows.length; i++) {
            locShowId = Integer.parseInt(mainTable.getModel().getValueAt(selectedRows[i], 0).toString());
            data[0] = mainTable.getModel().getValueAt(selectedRows[i], 0).toString();
            data[1] = LOGGED_USER_ID;
            db.update_fav_show(data);
        }
        loadFavShowsTable();
        autoRefresh();
    }//GEN-LAST:event_menu_item_mark_favActionPerformed

    private void menu_item_exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_item_exitActionPerformed
        confirm_exit();
    }//GEN-LAST:event_menu_item_exitActionPerformed

    private void btn_load_favActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_load_favActionPerformed
        // TODO add your handling code here:
        loadFavShowsTable();
    }//GEN-LAST:event_btn_load_favActionPerformed

    private void mainTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mainTableMouseClicked
        // TODO add your handling code here:
        System.out.println("mark fav");
    }//GEN-LAST:event_mainTableMouseClicked

    private void mainTablemessageRowDoubleClick(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mainTablemessageRowDoubleClick
        // TODO add your handling code here:
       
    }//GEN-LAST:event_mainTablemessageRowDoubleClick

    private void menu_item_see_seasonsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_item_see_seasonsActionPerformed
        // TODO add your handling code here:
        selectedRows = mainTable.getSelectedRows();
        if (selectedRows.length <= 0) {
            JOptionPane.showMessageDialog(this, "Select a row/rows to See Season!", "My App", JOptionPane.ERROR_MESSAGE);
            return;
        }
        int editShow = 0;
        int locShowId = 0;
        for (int i = 0; i < selectedRows.length; i++) {
            locShowId = Integer.parseInt(mainTable.getModel().getValueAt(selectedRows[i], 0).toString());
            viewseasonObject = new ViewSeasons(dashBoardObject, locShowId);
            viewseasonObject.setVisible(true);
    }//GEN-LAST:event_menu_item_see_seasonsActionPerformed
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            System.err.println("Couldn't use system look and feel.");
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Dashboard().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_load_fav;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel label_status_bar;
    private javax.swing.JTable mainTable;
    private javax.swing.JMenu menu_action;
    private javax.swing.JMenu menu_file;
    private javax.swing.JMenuItem menu_item_exit;
    private javax.swing.JMenuItem menu_item_mark_fav;
    private javax.swing.JMenuItem menu_item_see_seasons;
    private javax.swing.JTable messagesTable1;
    private javax.swing.JLabel text_logged_in_as;
    // End of variables declaration//GEN-END:variables
}
