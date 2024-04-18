/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package software.project;

import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class LoginForm extends javax.swing.JFrame {

    /**
     * Creates new form LoginForm
     */
    public LoginForm() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        title_lbl = new javax.swing.JLabel();
        username_lbl = new javax.swing.JLabel();
        username_field = new javax.swing.JTextField();
        pass_lbl = new javax.swing.JLabel();
        rgstr_btn = new javax.swing.JButton();
        login_btn = new javax.swing.JButton();
        pass_lgn_field = new javax.swing.JPasswordField();
        jPanel2 = new javax.swing.JPanel();
        reg_lbl = new javax.swing.JLabel();
        name_lbl = new javax.swing.JLabel();
        username_lbl1 = new javax.swing.JLabel();
        pass_lbl1 = new javax.swing.JLabel();
        email_lbl = new javax.swing.JLabel();
        email_field = new javax.swing.JTextField();
        pass_field = new javax.swing.JTextField();
        username_field1 = new javax.swing.JTextField();
        name_field = new javax.swing.JTextField();
        register_btn = new javax.swing.JButton();
        back_btn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        title_lbl.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        title_lbl.setText("Login to Laundray Automated Serivce");

        username_lbl.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        username_lbl.setText("Username:");

        pass_lbl.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        pass_lbl.setText("Password:");

        rgstr_btn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        rgstr_btn.setText("Register");
        rgstr_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rgstr_btnActionPerformed(evt);
            }
        });

        login_btn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        login_btn.setText("Login");
        login_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                login_btnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(54, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(title_lbl)
                            .addGap(45, 45, 45))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(rgstr_btn)
                            .addGap(18, 18, 18)
                            .addComponent(login_btn)
                            .addGap(123, 123, 123)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pass_lbl)
                            .addComponent(username_lbl))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(username_field, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pass_lgn_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {pass_lgn_field, username_field});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(title_lbl)
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(username_lbl)
                    .addComponent(username_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pass_lbl)
                    .addComponent(pass_lgn_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 95, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rgstr_btn)
                    .addComponent(login_btn))
                .addGap(16, 16, 16))
        );

        jTabbedPane1.addTab("tab1", jPanel1);

        reg_lbl.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        reg_lbl.setText("Register Account:");

        name_lbl.setText("Name:");

        username_lbl1.setText("Username:");

        pass_lbl1.setText("Password:");

        email_lbl.setText("Email:");

        email_field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                email_fieldActionPerformed(evt);
            }
        });

        pass_field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pass_fieldActionPerformed(evt);
            }
        });

        register_btn.setText("Register");

        back_btn.setText("Back");
        back_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                back_btnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(email_lbl)
                            .addComponent(name_lbl)
                            .addComponent(username_lbl1)
                            .addComponent(pass_lbl1))
                        .addGap(41, 41, 41)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(email_field, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pass_field, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(name_field, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(username_field1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(back_btn)
                        .addGap(59, 59, 59)
                        .addComponent(register_btn))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(128, 128, 128)
                        .addComponent(reg_lbl)))
                .addContainerGap(141, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(reg_lbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(name_lbl)
                    .addComponent(name_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(username_lbl1)
                    .addComponent(username_field1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pass_lbl1)
                    .addComponent(pass_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(email_lbl)
                    .addComponent(email_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(register_btn)
                    .addComponent(back_btn))
                .addGap(30, 30, 30))
        );

        jTabbedPane1.addTab("tab2", jPanel2);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -29, -1, 320));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void email_fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_email_fieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_email_fieldActionPerformed

    private void pass_fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pass_fieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pass_fieldActionPerformed
 //mohammed
    private void rgstr_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rgstr_btnActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(1);
        String name = name_field.getText();
        String email = email_field.getText();
        String username = username_field.getText();
        String password =pass_field.getText();


    // here we are inserting what the user entered to our db
    DBconnection dbConnection = new DBconnection();
    boolean success = dbConnection.register_client(name, email, username, password);

    if (success) {
        JOptionPane.showMessageDialog(this, "Thank you "+name + " for registering in our system.");
    } else {
        JOptionPane.showMessageDialog(this, "Registration failed! please try again");
    }

    }//GEN-LAST:event_rgstr_btnActionPerformed

    
    // mohammed
    private void login_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_login_btnActionPerformed
        // TODO add your handling code here:
    String email = username_field.getText();
    String password = String.valueOf(pass_lgn_field.getPassword());

    Login login = new Login(); // creating object of login
    boolean isValid = login.checkVerification(email, password); // to check if logIn is valid or not

    if (isValid) {
        String userType = login.getType();
        if (userType.equals("ADMIN")) {
            new Admin_Interface().setVisible(true);
        } else if (userType.equals("CLIENT")) {
            new User_Interface().setVisible(true);
        }
        dispose(); // Close the login form
    } else {
        JOptionPane.showMessageDialog(this, "Invalid username or password, please try again");
    }
    }//GEN-LAST:event_login_btnActionPerformed

    private void back_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_back_btnActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(0);
    }//GEN-LAST:event_back_btnActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back_btn;
    private javax.swing.JTextField email_field;
    private javax.swing.JLabel email_lbl;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton login_btn;
    private javax.swing.JTextField name_field;
    private javax.swing.JLabel name_lbl;
    private javax.swing.JTextField pass_field;
    private javax.swing.JLabel pass_lbl;
    private javax.swing.JLabel pass_lbl1;
    private javax.swing.JPasswordField pass_lgn_field;
    private javax.swing.JLabel reg_lbl;
    private javax.swing.JButton register_btn;
    private javax.swing.JButton rgstr_btn;
    private javax.swing.JLabel title_lbl;
    private javax.swing.JTextField username_field;
    private javax.swing.JTextField username_field1;
    private javax.swing.JLabel username_lbl;
    private javax.swing.JLabel username_lbl1;
    // End of variables declaration//GEN-END:variables
}
