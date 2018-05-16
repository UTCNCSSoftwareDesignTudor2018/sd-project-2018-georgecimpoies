/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package user.ui.admin;

import Db.DBConnectionAdmin;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author sakshi
 */
public class DashboardAdmin extends javax.swing.JFrame {

    private static DashboardAdmin dashBoardObject;
    private AddShow addshowObject;
    private EditShow editshowObject;
    private DBConnectionAdmin db;
    private String[] USER_DETAILS_DB;
    private String[] USER_DETAILS;
    private JOptionPane JOptionUnableToConnect;
    private Object[][] OBJECT_TV_SHOWS;
    private int[] selectedRows;
    private String USER_ID = "";
    public boolean newMessageUp = false;
    public boolean myMessageOnly = false;
    /**
     * Tray params start
     */
    static TrayIcon trayIcon;
    //Tray param end

    /**
     * Creates new form DashboardAdmin
     */
    public DashboardAdmin() {
        initComponents();
    }

    public DashboardAdmin(String logged_user) {
        initComponents();
        dashBoardObject = this;
        USER_ID = logged_user;
        db = new DBConnectionAdmin();
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                loadMessagesTable();
            }
        });
        text_logged_in_as.setText("Admin User");
        startTask();

    }

    public void autoRefresh() {
        loadMessagesTable();
    }

    public void loadMessagesTable() {
        int selectedRow = jTable1.getSelectedRow();
        OBJECT_TV_SHOWS = db.getShowsList();

        //set column names of the jtable
        String AttributeNames[];
        AttributeNames = new String[6];
        AttributeNames[0] = "ID";
        AttributeNames[1] = "Sr.No.";
        AttributeNames[2] = "Title";
        AttributeNames[3] = "Description";
        AttributeNames[4] = "Total Seasons";
        AttributeNames[5] = "Episodes Per Season";

        jTable1.setModel(new javax.swing.table.DefaultTableModel(OBJECT_TV_SHOWS, AttributeNames) {
            boolean[] canEdit = new boolean[]{
                true, true, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        jTable1.getTableHeader().setReorderingAllowed(false);
        jTable1.getTableHeader().setResizingAllowed(false);
        for (int i = 0; i < jTable1.getColumnCount(); i++) {
            DefaultTableColumnModel colModel = (DefaultTableColumnModel) jTable1.getColumnModel();
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
                    col.setPreferredWidth(80);
                    break;
                case 4:
                    col.setPreferredWidth(80);
                    break;
                case 5:
                    col.setPreferredWidth(100);
                    break;
            }
        }
        jTable1.getColumnModel().getColumn(0).setMinWidth(0);
        jTable1.getColumnModel().getColumn(0).setMaxWidth(0);
        jTable1.getColumnModel().getColumn(0).setWidth(0);
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
            case 0: //exit 

                String updateLdate = "UPDATE users SET last_seen=NOW() WHERE "
                        + "id=" + USER_ID + ";";
                db.UpDateLastLoginDate(updateLdate);
                System.exit(0);
                break;
            case 1:
                break;
        }
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem5 = new javax.swing.JMenuItem();
        label_status_bar = new javax.swing.JLabel();
        text_logged_in_as = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        menu_file = new javax.swing.JMenu();
        menu_item_exit = new javax.swing.JMenuItem();
        menu_action = new javax.swing.JMenu();
        menu_item_add = new javax.swing.JMenuItem();
        menu_item_update = new javax.swing.JMenuItem();
        menu_item_delete = new javax.swing.JMenuItem();

        jMenuItem5.setText("jMenuItem5");

        setTitle("Admin ");

        label_status_bar.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        label_status_bar.setText("My App");

        text_logged_in_as.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        text_logged_in_as.setText("jLabel1");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Sr. No", "Title", "Description"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable1);

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

        menu_item_add.setText("Add New");
        menu_item_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_item_addActionPerformed(evt);
            }
        });
        menu_action.add(menu_item_add);

        menu_item_update.setText("Update");
        menu_item_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_item_updateActionPerformed(evt);
            }
        });
        menu_action.add(menu_item_update);

        menu_item_delete.setText("Delete");
        menu_item_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_item_deleteActionPerformed(evt);
            }
        });
        menu_action.add(menu_item_delete);

        jMenuBar1.add(menu_action);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(label_status_bar, javax.swing.GroupLayout.DEFAULT_SIZE, 540, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(text_logged_in_as, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 711, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 136, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(535, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_status_bar)
                    .addComponent(text_logged_in_as)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 478, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(62, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menu_item_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_item_addActionPerformed
        addshowObject = new AddShow(dashBoardObject);
        addshowObject.setVisible(true);
        loadMessagesTable();
    }//GEN-LAST:event_menu_item_addActionPerformed

    private void menu_item_exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_item_exitActionPerformed
//        String uname=txt=
        confirm_exit();
    }//GEN-LAST:event_menu_item_exitActionPerformed

    private void menu_item_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_item_updateActionPerformed
        selectedRows = jTable1.getSelectedRows();
        if (selectedRows.length <= 0) {
            JOptionPane.showMessageDialog(this, "Select a row/rows to Update!", "My App", JOptionPane.ERROR_MESSAGE);
            return;
        }
        int editShow = 0;
        int locShowId = 0;
        for (int i = 0; i < selectedRows.length; i++) {
            locShowId = Integer.parseInt(jTable1.getModel().getValueAt(selectedRows[i], 0).toString());
            editshowObject = new EditShow(dashBoardObject, locShowId);
            editshowObject.setVisible(true);
            loadMessagesTable();
        }
    }//GEN-LAST:event_menu_item_updateActionPerformed

    private void menu_item_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_item_deleteActionPerformed
        // TODO add your handling code here:
        selectedRows = jTable1.getSelectedRows();
        if (selectedRows.length <= 0) {
            JOptionPane.showMessageDialog(this, "Select a row/rows to delete!", "My App", JOptionPane.ERROR_MESSAGE);
            return;
        }
        int deleteShow = 0;
        int locShowId = 0;
        for (int i = 0; i < selectedRows.length; i++) {
            locShowId = Integer.parseInt(jTable1.getModel().getValueAt(selectedRows[i], 0).toString());
            deleteShow = db.deleteShow(locShowId + "");
        }
        loadMessagesTable();
    }//GEN-LAST:event_menu_item_deleteActionPerformed

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
                new DashboardAdmin().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel label_status_bar;
    private javax.swing.JMenu menu_action;
    private javax.swing.JMenu menu_file;
    private javax.swing.JMenuItem menu_item_add;
    private javax.swing.JMenuItem menu_item_delete;
    private javax.swing.JMenuItem menu_item_exit;
    private javax.swing.JMenuItem menu_item_update;
    private javax.swing.JLabel text_logged_in_as;
    // End of variables declaration//GEN-END:variables
}
