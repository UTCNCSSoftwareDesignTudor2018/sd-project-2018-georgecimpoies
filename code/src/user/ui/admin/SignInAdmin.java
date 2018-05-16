/**
 * Developed by Amit Kumar
 *
 * @MDI Production Planner
 */
package user.ui.admin;

import Db.DBConnectionAdmin;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import java.net.InetAddress;
import java.net.UnknownHostException;
import javax.swing.UnsupportedLookAndFeelException;
import user.ui.admin.DashboardAdmin;

/**
 *
 * @author Amit
 */
public class SignInAdmin extends javax.swing.JFrame {

    private String LOGGED_IP = "";
    private String LOGGED_MACHINE_USERNAME = "";
    private String LOGGED_USERNAME = "";
    private String LOGGED_NAME = "";
    private String LOGGED_USER_ID = "";
    private JOptionPane JOptionUnableToConnect;
    private boolean FAILED_TO_CONNECT = false;
    private DBConnectionAdmin db;

    /**
     * Creates new form Login
     */
    public SignInAdmin() {
        try { // to get systems look and feel
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            System.err.println("Couldn't use system look and feel.");
        }

        initComponents();
        setLayoutAndIcon();
        db = new DBConnectionAdmin();
        try {
            String user_ip = InetAddress.getLocalHost() + "";
            String[] split = user_ip.split("/");
            LOGGED_MACHINE_USERNAME = "" + split[0];
            LOGGED_IP = "" + split[1];
//            System.out.println(InetAddress.getLocalHost());
        } catch (UnknownHostException ex) {
            Logger.getLogger(SignInAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Creates new form Login from logout screen
     */
    public SignInAdmin(String fromLogout) {
        initComponents();
        setLayoutAndIcon();

    }

    /**
     * Set Icon of the header
     */
    final void setLayoutAndIcon() {
        setLocationRelativeTo(null);
        BufferedImage icon_image = null;
        File imageFile = new File("image/Logo64.png");
        try {
            icon_image = ImageIO.read(imageFile);
        } catch (IOException ex) {
        }
        this.setIconImage(icon_image);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_uname = new javax.swing.JTextField();
        txt_pass = new javax.swing.JPasswordField();
        btn_cancel = new javax.swing.JButton();
        btn_login = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        label_logo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Mdi Messenger Admin | Login");
        setResizable(false);
        setType(java.awt.Window.Type.POPUP);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Username");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Password");

        txt_uname.setToolTipText("Enter your username here");

        txt_pass.setToolTipText("Enter your password here");
        txt_pass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_passKeyReleased(evt);
            }
        });

        btn_cancel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_cancel.setText("Cancel");
        btn_cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelActionPerformed(evt);
            }
        });

        btn_login.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_login.setText("Login");
        btn_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_loginActionPerformed(evt);
            }
        });

        label_logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Logo.png"))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("MDI Messenger Admin");

        org.jdesktop.layout.GroupLayout jPanel2Layout = new org.jdesktop.layout.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .add(label_logo)
                .add(18, 18, 18)
                .add(jLabel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, label_logo, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .add(jPanel2Layout.createSequentialGroup()
                .add(19, 19, 19)
                .add(jLabel1)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(73, 73, 73)
                        .add(btn_login, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 100, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(btn_cancel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 100, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(35, 35, 35)
                        .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                            .add(jLabel2)
                            .add(jLabel3))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                            .add(txt_pass)
                            .add(txt_uname, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 218, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(43, Short.MAX_VALUE))
            .add(jPanel2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .add(0, 0, 0)
                .add(jPanel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel2)
                    .add(txt_uname, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(18, 18, 18)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel3)
                    .add(txt_pass, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(18, 18, Short.MAX_VALUE)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(btn_login)
                    .add(btn_cancel))
                .addContainerGap())
        );

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelActionPerformed
        System.exit(0);
//        new DashboardAdmin("2").setVisible(true);
//        new DashboardAdmin("1").setVisible(true);
//        dispose();
    }//GEN-LAST:event_btn_cancelActionPerformed

    private void btn_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_loginActionPerformed
        //login button pressed
        perform_login();
    }//GEN-LAST:event_btn_loginActionPerformed

    private void txt_passKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_passKeyReleased
    }//GEN-LAST:event_txt_passKeyReleased

    private boolean perform_login() {
        String logged_user_id = "";
        String utype = "";
        String uname = null, pass = null;
        uname = txt_uname.getText().toString();
        char pas[] = txt_pass.getPassword();

        if (pas.length > 1) {
            pass = new String(pas);
        }

        if (uname != null && pass != null) {
            if ((!uname.equals("") && !pass.equals("")) && (uname.length() > 3 && pass.length() > 3)) {
                logged_user_id = db.auth_user(uname, pass) + "";
                if (!logged_user_id.equals("")) {
                    new DashboardAdmin(logged_user_id).setVisible(true);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "User authentication failed!", "Login error!", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Username/password must be of atleast 4 digits!", "Login error!", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Username/password cannot be empty!", "Login error!", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            System.err.println("Couldn't use system look and feel.");
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SignInAdmin().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cancel;
    private javax.swing.JButton btn_login;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel label_logo;
    private javax.swing.JPasswordField txt_pass;
    private javax.swing.JTextField txt_uname;
    // End of variables declaration//GEN-END:variables
}
