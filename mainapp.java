/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package systest;


import java.awt.Graphics;
import java.awt.Image;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import java.io.BufferedReader; 
import java.io.File; 
import java.io.IOException; 
import java.io.InputStreamReader; 
import java.io.*;


/**
 *
 * @author ilyas
 */
public class mainapp extends javax.swing.JFrame {
    
    // Global Variables
    static int userIndex;
/*
    public static void openformemployee(boolean isNewUser, int id) throws SQLException {
        if (isNewUser) {
            JInternalFrame newemployeeframe = new userform();
            jDesktopPane1.add(newemployeeframe);
            newemployeeframe.setVisible(true);
        } else {
            JInternalFrame newemployeeframe2 = new userform(id);
            jDesktopPane1.add(newemployeeframe2);
            newemployeeframe2.setVisible(true);
        }
    }
    
    public static void openformclient(boolean isNewClient, int id) throws SQLException {
        if (isNewClient) {
            JInternalFrame newclientframe = new clientform();
            jDesktopPane1.add(newclientframe);
            newclientframe.setVisible(true);
        } else {
            JInternalFrame newclientframe2 = new clientform(id);
            jDesktopPane1.add(newclientframe2);
            newclientframe2.setVisible(true);
        }
    }
  */  
    ResultSet RSG;
    String TABLE_NAME = "users";
    // Global Internal Frames
    
    
    
    public mainapp(int id) {
        initComponents();
        userIndex = id;
        
        // add Internal frames
        
    }
    
    // GENERATED CODE HERE
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ImageIcon icon =  new ImageIcon(getClass().getResource("appbg.jpg"));
        Image img = icon.getImage();

        //Image newimg = img.getScaledInstance(jDesktopPane1.getWidth(), jDesktopPane1.getHeight(), Image.SCALE_SMOOTH);
        jDesktopPane1 = new javax.swing.JDesktopPane(){
            public void paintComponent (Graphics g) {
                super.paintComponent(g);
                g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
            }
        };
        jSeparator1 = new javax.swing.JSeparator();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        accountsettings = new javax.swing.JMenuItem();
        Settings = new javax.swing.JMenuItem();
        Disconnect = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        gestionClients = new javax.swing.JMenu();
        addclient = new javax.swing.JMenuItem();
        manageclients = new javax.swing.JMenuItem();
        lobby = new javax.swing.JMenuItem();
        appoinements = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        gestionCabinet = new javax.swing.JMenu();
        assurance = new javax.swing.JMenuItem();
        medicines = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        Administration = new javax.swing.JMenu();
        newemployee = new javax.swing.JMenuItem();
        manageemployee = new javax.swing.JMenuItem();
        Administration1 = new javax.swing.JMenu();
        newemployee1 = new javax.swing.JMenuItem();
        manageemployee1 = new javax.swing.JMenuItem();
        Administration2 = new javax.swing.JMenu();
        newemployee2 = new javax.swing.JMenuItem();
        manageemployee2 = new javax.swing.JMenuItem();
        Administration3 = new javax.swing.JMenu();
        newemployee3 = new javax.swing.JMenuItem();
        manageemployee3 = new javax.swing.JMenuItem();
        Administration4 = new javax.swing.JMenu();
        newemployee4 = new javax.swing.JMenuItem();
        manageemployee4 = new javax.swing.JMenuItem();
        Administration5 = new javax.swing.JMenu();
        newemployee5 = new javax.swing.JMenuItem();
        manageemployee5 = new javax.swing.JMenuItem();
        Administration6 = new javax.swing.JMenu();
        newemployee6 = new javax.swing.JMenuItem();
        manageemployee6 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("hospitalSys - Hospital Management System");
        setMinimumSize(new java.awt.Dimension(577, 454));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jDesktopPane1.setBackground(new java.awt.Color(0, 102, 153));
        jDesktopPane1.add(jSeparator1);
        jSeparator1.setBounds(0, 0, 0, 3);

        jMenu2.setText("HMS Hospital");

        accountsettings.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hospitalSys/images/icons8-edit.png"))); // NOI18N
        accountsettings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accountsettingsActionPerformed(evt);
            }
        });
        jMenu2.add(accountsettings);

        Settings.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hospitalSys/images/icons8-settings.png"))); // NOI18N
        Settings.setText("Settings");
        Settings.setEnabled(false);
        Settings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SettingsActionPerformed(evt);
            }
        });
        jMenu2.add(Settings);

        Disconnect.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hospitalSys/images/icons8-shutdown.png"))); // NOI18N
        Disconnect.setText("Disconnect");
        Disconnect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DisconnectActionPerformed(evt);
            }
        });
        jMenu2.add(Disconnect);

        jMenuBar1.add(jMenu2);

        jMenu1.setText("|");
        jMenuBar1.add(jMenu1);

        gestionClients.setText("Patients");

        addclient.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hospitalSys/images/icons8-add_user_male.png"))); // NOI18N
        addclient.setText("Add New Patient");
        addclient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addclientActionPerformed(evt);
            }
        });
        gestionClients.add(addclient);

        manageclients.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hospitalSys/images/icons8-conference.png"))); // NOI18N
        manageclients.setText("Manage Patient");
        manageclients.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageclientsActionPerformed(evt);
            }
        });
        gestionClients.add(manageclients);

        lobby.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hospitalSys/images/icons8-waiting_room_s.png"))); // NOI18N
        lobby.setText("Waiting Room");
        lobby.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lobbyActionPerformed(evt);
            }
        });
        gestionClients.add(lobby);

        appoinements.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hospitalSys/images/icons8-calendar.png"))); // NOI18N
        appoinements.setText("Appointments");
        appoinements.setToolTipText("");
        appoinements.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                appoinementsActionPerformed(evt);
            }
        });
        gestionClients.add(appoinements);

        jMenuItem4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hospitalSys/images/icons8-paper_money.png"))); // NOI18N
        jMenuItem4.setText("Facturation");
        jMenuItem4.setEnabled(false);
        gestionClients.add(jMenuItem4);

        jMenuBar1.add(gestionClients);

        gestionCabinet.setText("Medication");

        assurance.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hospitalSys/images/icons8-tips.png"))); // NOI18N
        assurance.setText("Insurances");
        assurance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                assuranceActionPerformed(evt);
            }
        });
        gestionCabinet.add(assurance);

        medicines.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hospitalSys/images/icons8-pills_s.png"))); // NOI18N
        medicines.setText("Medicines");
        medicines.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                medicinesActionPerformed(evt);
            }
        });
        gestionCabinet.add(medicines);

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hospitalSys/images/icons8-treatment.png"))); // NOI18N
        jMenuItem1.setText("Medical Reports");
        jMenuItem1.setEnabled(false);
        gestionCabinet.add(jMenuItem1);

        jMenuBar1.add(gestionCabinet);

        Administration.setText("Administration");

        newemployee.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hospitalSys/images/icons8-add_user_male.png"))); // NOI18N
        newemployee.setText("New Employee Account");
        newemployee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newemployeeActionPerformed(evt);
            }
        });
        Administration.add(newemployee);

        manageemployee.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hospitalSys/images/icons8-conference.png"))); // NOI18N
        manageemployee.setText("Manage Employees");
        manageemployee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageemployeeActionPerformed(evt);
            }
        });
        Administration.add(manageemployee);

        jMenuBar1.add(Administration);

        Administration1.setText("Doctor");

        newemployee1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hospitalSys/images/icons8-add_user_male.png"))); // NOI18N
        newemployee1.setText("Appointment");
        newemployee1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newemployee1ActionPerformed(evt);
            }
        });
        Administration1.add(newemployee1);

        manageemployee1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hospitalSys/images/icons8-conference.png"))); // NOI18N
        manageemployee1.setText("Consultation");
        manageemployee1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageemployee1ActionPerformed(evt);
            }
        });
        Administration1.add(manageemployee1);

        jMenuBar1.add(Administration1);

        Administration2.setText("Promotions");

        newemployee2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hospitalSys/images/icons8-add_user_male.png"))); // NOI18N
        newemployee2.setText("All Campaigns");
        newemployee2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newemployee2ActionPerformed(evt);
            }
        });
        Administration2.add(newemployee2);

        manageemployee2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hospitalSys/images/icons8-conference.png"))); // NOI18N
        manageemployee2.setText("Community Promotions");
        manageemployee2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageemployee2ActionPerformed(evt);
            }
        });
        Administration2.add(manageemployee2);

        jMenuBar1.add(Administration2);

        Administration3.setText("Library");

        newemployee3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hospitalSys/images/icons8-add_user_male.png"))); // NOI18N
        newemployee3.setText("General");
        newemployee3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newemployee3ActionPerformed(evt);
            }
        });
        Administration3.add(newemployee3);

        manageemployee3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hospitalSys/images/icons8-conference.png"))); // NOI18N
        manageemployee3.setText("Nurses Resources");
        manageemployee3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageemployee3ActionPerformed(evt);
            }
        });
        Administration3.add(manageemployee3);

        jMenuBar1.add(Administration3);

        Administration4.setText("System Monitor");

        newemployee4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hospitalSys/images/icons8-add_user_male.png"))); // NOI18N
        newemployee4.setText("Cyber");
        newemployee4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newemployee4ActionPerformed(evt);
            }
        });
        Administration4.add(newemployee4);

        manageemployee4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hospitalSys/images/icons8-conference.png"))); // NOI18N
        manageemployee4.setText("Network");
        manageemployee4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageemployee4ActionPerformed(evt);
            }
        });
        Administration4.add(manageemployee4);

        jMenuBar1.add(Administration4);

        Administration5.setText("Reports");

        newemployee5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hospitalSys/images/icons8-add_user_male.png"))); // NOI18N
        newemployee5.setText("Patients");
        newemployee5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newemployee5ActionPerformed(evt);
            }
        });
        Administration5.add(newemployee5);

        manageemployee5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hospitalSys/images/icons8-conference.png"))); // NOI18N
        manageemployee5.setText("Medical");
        manageemployee5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageemployee5ActionPerformed(evt);
            }
        });
        Administration5.add(manageemployee5);

        jMenuBar1.add(Administration5);

        Administration6.setText("About Us");

        newemployee6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hospitalSys/images/icons8-add_user_male.png"))); // NOI18N
        newemployee6.setText("Patients");
        newemployee6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newemployee6ActionPerformed(evt);
            }
        });
        Administration6.add(newemployee6);

        manageemployee6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hospitalSys/images/icons8-conference.png"))); // NOI18N
        manageemployee6.setText("Medical");
        manageemployee6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageemployee6ActionPerformed(evt);
            }
        });
        Administration6.add(manageemployee6);

        jMenuBar1.add(Administration6);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 3000, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1500, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(1223, 509));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void DisconnectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DisconnectActionPerformed
        userIndex = -1;
        this.setVisible(false);
        JFrame login = new Login();
        login.setVisible(true);
    }//GEN-LAST:event_DisconnectActionPerformed

    private void SettingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SettingsActionPerformed
        
    }//GEN-LAST:event_SettingsActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        RSG = Connect.Select_request("SELECT * FROM "+TABLE_NAME+" WHERE id = "+userIndex);
        try {
            RSG.next();
            String Username = RSG.getString("username");
            String firstName = RSG.getString("nom");
            String lastName = RSG.getString("prenom");
            String role = RSG.getString("role");
            String fullName =  firstName + " " +lastName;
            
            //List of Roles : Medecin, Infirmier, Secretaire, Administrateur
            if (role.equals("Administrateur")) {
                Administration.setEnabled(true);
                gestionCabinet.setEnabled(true);
                gestionClients.setEnabled(true);
            } else if (role.equals("Infirmier")) {
                Administration.setEnabled(false);
                gestionCabinet.setEnabled(true);
                gestionClients.setEnabled(false);
            } else if (role.equals("Secretaire")) {
                Administration.setEnabled(false);
                gestionCabinet.setEnabled(false);
                gestionClients.setEnabled(true);
            } else if (role.equals("Medecin")) {
                Administration.setEnabled(false);
                gestionCabinet.setEnabled(true);
                gestionClients.setEnabled(true);
            }

            accountsettings.setText(fullName);
        } catch (SQLException ex) {
            Logger.getLogger(mainapp.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }//GEN-LAST:event_formWindowOpened

    private void accountsettingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_accountsettingsActionPerformed
        JInternalFrame usersettingsframe = new usersettings();
        jDesktopPane1.add(usersettingsframe);
        usersettingsframe.setVisible(true);
    }//GEN-LAST:event_accountsettingsActionPerformed

    private void newemployeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newemployeeActionPerformed
        JInternalFrame newemployeeframe = new userform();
        jDesktopPane1.add(newemployeeframe);
        newemployeeframe.setVisible(true);
    }//GEN-LAST:event_newemployeeActionPerformed

    private void manageemployeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageemployeeActionPerformed
        JInternalFrame employeesframe = new employees();
        jDesktopPane1.add(employeesframe);
        employeesframe.setVisible(true);
    }//GEN-LAST:event_manageemployeeActionPerformed

    private void addclientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addclientActionPerformed
        JInternalFrame newclientframe = new clientform();
        jDesktopPane1.add(newclientframe);
        newclientframe.setVisible(true);
    }//GEN-LAST:event_addclientActionPerformed

    private void manageclientsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageclientsActionPerformed
        JInternalFrame clientsframe = new clients();
        jDesktopPane1.add(clientsframe);
        clientsframe.setVisible(true);
    }//GEN-LAST:event_manageclientsActionPerformed

    private void assuranceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_assuranceActionPerformed
        JInternalFrame assuranceframe = new Insurance();
        jDesktopPane1.add(assuranceframe);
        assuranceframe.setVisible(true);
    }//GEN-LAST:event_assuranceActionPerformed

    private void medicinesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_medicinesActionPerformed
        JInternalFrame medframe = new Medicine();
        jDesktopPane1.add(medframe);
        medframe.setVisible(true);
    }//GEN-LAST:event_medicinesActionPerformed

    private void appoinementsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_appoinementsActionPerformed
        JInternalFrame apframe = new appoinement();
        jDesktopPane1.add(apframe);
        apframe.setVisible(true);
    }//GEN-LAST:event_appoinementsActionPerformed

    private void lobbyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lobbyActionPerformed
        JInternalFrame lobbyframe = new queue();
        jDesktopPane1.add(lobbyframe);
        lobbyframe.setVisible(true);
    }//GEN-LAST:event_lobbyActionPerformed

    private void newemployee1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newemployee1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_newemployee1ActionPerformed

    private void manageemployee1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageemployee1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_manageemployee1ActionPerformed

    private void newemployee2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newemployee2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_newemployee2ActionPerformed

    private void manageemployee2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageemployee2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_manageemployee2ActionPerformed

    private void newemployee3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newemployee3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_newemployee3ActionPerformed

    private void manageemployee3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageemployee3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_manageemployee3ActionPerformed

    private void newemployee4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newemployee4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_newemployee4ActionPerformed

    private void manageemployee4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageemployee4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_manageemployee4ActionPerformed

    private void newemployee5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newemployee5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_newemployee5ActionPerformed

    private void manageemployee5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageemployee5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_manageemployee5ActionPerformed

    private void newemployee6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newemployee6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_newemployee6ActionPerformed

    private void manageemployee6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageemployee6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_manageemployee6ActionPerformed

    
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
            java.util.logging.Logger.getLogger(mainapp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(mainapp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(mainapp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mainapp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        
            
        //Then a call to the method in each of the sub-project classes
        //Below is call to Doctor Appointment
        ///////////appointmentobj.displayMessage(); // Call the methods from their events
        
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new mainapp(-1).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu Administration;
    private javax.swing.JMenu Administration1;
    private javax.swing.JMenu Administration2;
    private javax.swing.JMenu Administration3;
    private javax.swing.JMenu Administration4;
    private javax.swing.JMenu Administration5;
    private javax.swing.JMenu Administration6;
    private javax.swing.JMenuItem Disconnect;
    private javax.swing.JMenuItem Settings;
    private javax.swing.JMenuItem accountsettings;
    private javax.swing.JMenuItem addclient;
    private javax.swing.JMenuItem appoinements;
    private javax.swing.JMenuItem assurance;
    private javax.swing.JMenu gestionCabinet;
    private javax.swing.JMenu gestionClients;
    public static javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JMenuItem lobby;
    private javax.swing.JMenuItem manageclients;
    private javax.swing.JMenuItem manageemployee;
    private javax.swing.JMenuItem manageemployee1;
    private javax.swing.JMenuItem manageemployee2;
    private javax.swing.JMenuItem manageemployee3;
    private javax.swing.JMenuItem manageemployee4;
    private javax.swing.JMenuItem manageemployee5;
    private javax.swing.JMenuItem manageemployee6;
    private javax.swing.JMenuItem medicines;
    private javax.swing.JMenuItem newemployee;
    private javax.swing.JMenuItem newemployee1;
    private javax.swing.JMenuItem newemployee2;
    private javax.swing.JMenuItem newemployee3;
    private javax.swing.JMenuItem newemployee4;
    private javax.swing.JMenuItem newemployee5;
    private javax.swing.JMenuItem newemployee6;
    // End of variables declaration//GEN-END:variables
}
