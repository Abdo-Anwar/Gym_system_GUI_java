package frontend;

import constants.LoginCredentials;

public class Admin_login extends javax.swing.JFrame  implements LoginCredentials {

  
    public Admin_login() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        AdminLoginButton = new javax.swing.JButton();
        PassTextFiels = new javax.swing.JTextField();
        UserTextfield = new javax.swing.JTextField();
        Passwordlabel = new java.awt.Label();
        UserNameLable = new java.awt.Label();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Admin Login");

        AdminLoginButton.setBackground(new java.awt.Color(102, 102, 102));
        AdminLoginButton.setForeground(new java.awt.Color(255, 255, 255));
        AdminLoginButton.setText("Login");
        AdminLoginButton.setToolTipText("loginButton");
        AdminLoginButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AdminLoginButtonMouseClicked(evt);
            }
        });
        AdminLoginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AdminLoginButtonActionPerformed(evt);
            }
        });

        PassTextFiels.setToolTipText("PassText_filed");
        PassTextFiels.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PassTextFielsActionPerformed(evt);
            }
        });

        UserTextfield.setToolTipText("UserText_filed");
        UserTextfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UserTextfieldActionPerformed(evt);
            }
        });

        Passwordlabel.setAlignment(java.awt.Label.CENTER);
        Passwordlabel.setBackground(new java.awt.Color(153, 255, 153));
        Passwordlabel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Passwordlabel.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        Passwordlabel.setName("PasswordLable"); // NOI18N
        Passwordlabel.setText("Password");

        UserNameLable.setAlignment(java.awt.Label.CENTER);
        UserNameLable.setBackground(new java.awt.Color(153, 255, 153));
        UserNameLable.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        UserNameLable.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        UserNameLable.setName("UserLable"); // NOI18N
        UserNameLable.setText("UserName");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(AdminLoginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(91, 91, 91))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Passwordlabel, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(UserNameLable, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(UserTextfield, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
                            .addComponent(PassTextFiels))))
                .addGap(26, 26, 26))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(UserNameLable, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(UserTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Passwordlabel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PassTextFiels, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addComponent(AdminLoginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void PassTextFielsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PassTextFielsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PassTextFielsActionPerformed

    private void UserTextfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UserTextfieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UserTextfieldActionPerformed

    private void AdminLoginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AdminLoginButtonActionPerformed

    String username = UserTextfield.getText();
    String password = PassTextFiels.getText();
    
    System.out.println("Username: " + username);
    System.out.println("Password: " + password);

    }//GEN-LAST:event_AdminLoginButtonActionPerformed

    private void AdminLoginButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AdminLoginButtonMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_AdminLoginButtonMouseClicked

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
            java.util.logging.Logger.getLogger(Admin_login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Admin_login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Admin_login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Admin_login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Admin_login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AdminLoginButton;
    private javax.swing.JTextField PassTextFiels;
    private java.awt.Label Passwordlabel;
    private java.awt.Label UserNameLable;
    private javax.swing.JTextField UserTextfield;
    // End of variables declaration//GEN-END:variables
}
