/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package systest;

//import hospitalSys.AuthenticatedEncryption;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import java.sql.*;
import static javax.swing.JOptionPane.*;
import javax.crypto.Cipher;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.security.MessageDigest;
import java.security.SecureRandom;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.util.Base64;
//import java.util.Arrays.toSpring;
import javax.crypto.Cipher;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import sun.misc.*;
import javax.crypto.Cipher;
//import org.apache.commons.codec.binary.Base64;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import java.security.SecureRandom;
import java.security.spec.KeySpec;
import java.security.KeyStore;
import java.security.Provider;
import java.security.AlgorithmParameters;
import java.util.Base64;
import java.io.UnsupportedEncodingException;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Date;
import java.util.Random;
///import hospitalSys.AuthenticatedEncryption.*;
import java.util.Arrays;
import java.util.Properties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.AlgorithmParameters;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.*;
import java.util.Base64;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;



/**
 *
 * @author ilyas
 */
public class Login extends javax.swing.JFrame {
PreparedStatement stmt;
Cipher cipher;
//private static String decrypted = "";
private static SecretKey tmp;
private static KeySpec spec;  
SecretKeySpec key;
//public static String decrypted = "";
    
//Declaration for additional code for decryption
final String secretKey = "secrete";
String decrypted = "";
String Username = "";
String Password = "User1";
String passw = "";
String decryptedPassword = "";
///String decryptedpass = "";
String decryptedpass = "";
String url ="jdbc:mysql://127.0.0.1:3306/employees";
String username = "root";
Connection conn = null;

String encryption = "";
String auth = "";

//Defination of Java QSL types for database query
private static final String SQL_TYPES =
            "TABLE, TABLESPACE, PROCEDURE, FUNCTION, TRIGGER, KEY, VIEW, MATERIALIZED VIEW, LIBRARY" +
                    "DATABASE LINK, DBLINK, INDEX, CONSTRAINT, TRIGGER, USER, SCHEMA, DATABASE, PLUGGABLE DATABASE, BUCKET, " +
                    "CLUSTER, COMMENT, SYNONYM, TYPE, JAVA, SESSION, ROLE, PACKAGE, PACKAGE BODY, OPERATOR" +
                    "SEQUENCE, RESTORE POINT, PFILE, CLASS, CURSOR, OBJECT, RULE, USER, DATASET, DATASTORE, " +
                    "COLUMN, FIELD, OPERATOR";

    /**
     * Creates new form login
     */
    public Login() {
        initComponents();
         
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        usernamefield = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        passfield = new javax.swing.JPasswordField();
        loginbtn = new javax.swing.JButton();
        errorfield = new javax.swing.JLabel();
        loginbtn1 = new javax.swing.JButton();
        jforgotpassword = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("hospitalSys | Login");
        setResizable(false);
        getContentPane().setLayout(null);

        jLabel3.setFont(new java.awt.Font("Corporate A", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 102, 204));
        jLabel3.setText("Login");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(170, 30, 110, 60);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hospitalSys/images/entrance1.jpg"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 480, 170);

        jLabel4.setText("Username");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(100, 190, 90, 16);
        getContentPane().add(usernamefield);
        usernamefield.setBounds(100, 210, 290, 40);

        jLabel5.setText("Password");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(100, 260, 90, 16);
        getContentPane().add(passfield);
        passfield.setBounds(100, 280, 290, 40);

        loginbtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        loginbtn.setText("Login");
        loginbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginbtnActionPerformed(evt);
            }
        });
        getContentPane().add(loginbtn);
        loginbtn.setBounds(100, 350, 290, 40);

        errorfield.setForeground(new java.awt.Color(204, 0, 0));
        getContentPane().add(errorfield);
        errorfield.setBounds(100, 390, 290, 20);

        loginbtn1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        loginbtn1.setText("Register");
        loginbtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginbtn1ActionPerformed(evt);
            }
        });
        getContentPane().add(loginbtn1);
        loginbtn1.setBounds(100, 410, 290, 40);

        jforgotpassword.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jforgotpassword.setForeground(new java.awt.Color(0, 102, 255));
        jforgotpassword.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jforgotpassword.setLabel("Forgot Password");
        jforgotpassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jforgotpasswordActionPerformed(evt);
            }
        });
        getContentPane().add(jforgotpassword);
        jforgotpassword.setBounds(250, 480, 140, 23);

        setSize(new java.awt.Dimension(462, 587));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void loginbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginbtnActionPerformed
        Username = usernamefield.getText().toString();
        Password = passfield.getText().toString();
        //String password = "User1";
        System.out.println("Username");
        System.out.println("Userpassword");
        byte[] salt = new String("12345678").getBytes();

        // Decreasing this speeds down startup time and can be useful during testing, but it also makes it easier for brute force attackers
        int iterationCount = 40000;
        // Other values give me java.security.InvalidKeyException: Illegal key size or default parameters
        int keyLength = 128;

        try {
         key = createSecretKey(Password.toCharArray(),
         salt, iterationCount, keyLength);
       } catch (Exception ex) {
                     //Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
       }
      System.out.println("Userpassword2");
        //Using RASP to detect zero-day attack
        if (isSQLInjection(Username) || isSQLInjection(Password)) {
            showMessageDialog(null, "Potential SQL Injection detected!", "Critical Warning", ERROR_MESSAGE);
                 
        } else {
            System.out.println("Userpassword3");
            try {
                encryption = makeKey();
                auth = makeKey();
                
                Properties props = new Properties();
                FileInputStream in = new FileInputStream("C:\\Users\\magaj\\Documents\\NetBeansProjects\\PROJECTS_ROOT19\\medERP\\src\\encryptionhashBest\\connection.properties"); 
                     
               /* 
                  ///////////////////////////////////////////////////////////////////////////
                  //Working Decryption - for connection
                  Properties props = new Properties();
                  //Decryption
                  ///Properties props = new Properties();
                  ///try (FileInputStream in = new FileInputStream("src/encryptionhashBest/First.properties")) {
                
                      FileInputStream in = new FileInputStream("C:\\Users\\magaj\\Documents\\NetBeansProjects\\PROJECTS_ROOT19\\medERP\\src\\encryptionhashBest\\connection.properties"); 
                      props.load(in);
                      String passw = props.getProperty("database.login.password");
                      System.out.println("Retrieved Password: " + passw);

                      ///AuthenticatedEncryption authenticatedEncryption = new AuthenticatedEncryption(encryption, auth);

                      //Decrypt password
                      ///decrypted = authenticatedEncryption.decrypt(passw);
                      ///System.out.println("Decrypted Password From : " + decrypted);
                     
                      decryptedPassword = decrypt(passw, key);
                      ///String decryptedpass = decryptedPassword;
                      
                      System.out.println("Decrypted password From File: " + decryptedPassword);
                      System.out.println("Decrypted password From File2: " + decryptedpass);
                    
                      
                  //////////////////////////////////////////////////////////////////////////////////
                      //////////////conn = (Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/employees", "root", "User1");
             */      
                
                Connection dbconn = DBConnection.connectDB();

                 //Authenticated for login activities
                String TABLE_NAME = "users";
                
                
                  
     /////////////////////////////////////////////////////////////////////
            //Decrypt from properties file for user login and other access
                PreparedStatement pst = null;
                        ////dbconn.prepareStatement("SELECT * FROM "+TABLE_NAME+" WHERE username = '"+Username+"' and password = '"+encrypted+"'");
                        String query = "SELECT * FROM "+TABLE_NAME+" WHERE username = '"+Username+"'";
                pst = dbconn.prepareStatement(query);
                
                //Using RASP to detect zero-day attack
                if (isSQLInjection2(query)) {
                    showMessageDialog(null, "Wrong Database Query", "Critical Warning", ERROR_MESSAGE);
                       
                } else {
                    //Execute database query only if there is no sql injection 
                
                    System.out.println("Print 1");
                    //DECRYPT FETCHED PASSWORD
                    ResultSet rs = pst.executeQuery();
               /*   
                  PreparedStatement st = (PreparedStatement)
                        ////dbconn.prepareStatement("SELECT * FROM "+TABLE_NAME+" WHERE username = '"+Username+"' and password = '"+encrypted+"'");
                conn.prepareStatement("SELECT * FROM "+TABLE_NAME+" WHERE username = '"+Username+"'");
                System.out.println("Print 1");
                //DECRYPT FETCHED PASSWORD
                  ResultSet rs = st.executeQuery();
                */  
                  //Open the output stream and store properties after you have closed the input stream.
                props = new Properties();
                ///try (FileInputStream in = new FileInputStream("src/encryptionhashBest/First.properties")) {
                try {
                    in = new FileInputStream("C:\\Users\\magaj\\Documents\\NetBeansProjects\\PROJECTS_ROOT19\\medERP\\src\\encryptionhashBest\\userlogin.properties"); 
                    //FileInputStream in = new FileInputStream("/userlogin.properties"); 
                    props.load(in);
                    passw = props.getProperty("user1.password");
                    System.out.println("Retrieved Password: " + passw);
                    
                    ///AuthenticatedEncryption authenticatedEncryption = new AuthenticatedEncryption(encryption, auth);

                    //Decrypt password
                    ///decrypted = authenticatedEncryption.decrypt(passw);
                    ///System.out.println("Decrypted Password From : " + decrypted);
                    decrypted = decrypt(passw, key);
                    System.out.println("Decrypted password From File: " + decrypted);
                
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
               
                                                           
                    if (rs.next()){
                                                
                        if (decrypted.equals(Password)){
                            int id = rs.getInt("emp_no");
                            System.out.println("Employee ID: " + id);
                           
                         } else {
                            showMessageDialog(null, "Wrong Password", "Warning", ERROR_MESSAGE);
                         }
                    }else {
                        showMessageDialog(null, "Wrong Username/Password combination", "Warning", ERROR_MESSAGE);
                        //errorfield.setText("Wrong Username/Password combination !");

                    }
                    
                 } //end of database RASP isSQLInjection2 check - For database query string (end of if - else
                
                } catch (Exception ex) {
                     ///showMessageDialog(null, "Wrong Username/Password combination", "Warning", ERROR_MESSAGE);
                    //Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                }
        }  //end of first RASP isSQLInjection check - For user login credentials
         
        
                
                
    }//GEN-LAST:event_loginbtnActionPerformed

    private static boolean isSQLInjection(String input) {
        // Simple pattern matching to detect SQL injection. Below are examples of malicious input 
        ///String[] sqlInjectionPatterns = {"'","1", "1=1", "\"", ";", "--", "/*", "*/", " OR ", " AND "};
        String[] sqlInjectionPatterns = {
            "'", "\"", ";", "--", "/*", "*/", " OR ", " AND ", "(?i)(.*)(\\b)+(OR|AND)(\\s)+(true|false)(\\s)*(.*)",
            "(?i)(.*)(\\b)+(OR|AND)(\\s)+(\\w)(\\s)*(\\=)(\\s)*(\\w)(\\s)*(.*)",
            "(?i)(.*)(\\b)+(OR|AND)(\\s)+(equals|not equals)(\\s)+(true|false)(\\s)*(.*)",
            "(?i)(.*)(\\b)+(OR|AND)(\\s)+([0-9A-Za-z_'][0-9A-Za-z\\d_']*)(\\s)*(\\=)(\\s)*([0-9A-Za-z_'][0-9A-Za-z\\d_']*)(\\s)*(.*)",
            "(?i)(.*)(\\b)+(OR|AND)(\\s)+([0-9A-Za-z_'][0-9A-Za-z\\d_']*)(\\s)*(\\!\\=)(\\s)*([0-9A-Za-z_'][0-9A-Za-z\\d_']*)(\\s)*(.*)",
            "(?i)(.*)(\\b)+(OR|AND)(\\s)+([0-9A-Za-z_'][0-9A-Za-z\\d_']*)(\\s)*(\\<\\>)(\\s)*([0-9A-Za-z_'][0-9A-Za-z\\d_']*)(\\s)*(.*)",
            "(.*)(/\\*|\\*/|;){1,}(.*)",
            "(.*)(-){2,}(.*)",
            };

        for (String pattern : sqlInjectionPatterns) {
            if (input.contains(pattern)) {
                return true;
            }
        }
        return false;
    }
    
     private static boolean isSQLInjection2(String input) {
        // Simple pattern matching to detect SQL injection. Below are examples of malicious input 
        ///String[] sqlInjectionPatterns = {"'","1", "1=1", "\"", ";", "--", "/*", "*/", " OR ", " AND "};
        String[] sqlInjectionPatterns = {
            "(?i)(.*)(\\b)+SELECT(\\b)+\\s.*(\\b)(.*)",
//            "(?i)(.*)(\\b)+SELECT(\\b)+\\s.*(\\b)+FROM(\\b)+\\s.*(.*)",
            "(?i)(.*)(\\b)+INSERT(\\b)+\\s.*(\\b)+INTO(\\b)+\\s.*(.*)",
            "(?i)(.*)(\\b)+UPDATE(\\b)+\\s.*(.*)",
            "(?i)(.*)(\\b)+DELETE(\\b)+\\s.*(\\b)+FROM(\\b)+\\s.*(.*)",
            "(?i)(.*)(\\b)+UPSERT(\\b)+\\s.*(.*)",
            "(?i)(.*)(\\b)+SAVEPOINT(\\b)+\\s.*(.*)",
            "(?i)(.*)(\\b)+CALL(\\b)+\\s.*(.*)",
            "(?i)(.*)(\\b)+ROLLBACK(\\b)+\\s.*(.*)",
            "(?i)(.*)(\\b)+KILL(\\b)+\\s.*(.*)",
            "(?i)(.*)(\\b)+DROP(\\b)+\\s.*(.*)",
            "(?i)(.*)(\\b)+CREATE(\\b)+(\\s)*(" + SQL_TYPES.replaceAll(",", "|") + ")(\\b)+\\s.*(.*)",
            "(?i)(.*)(\\b)+ALTER(\\b)+(\\s)*(" + SQL_TYPES.replaceAll(",", "|") + ")(\\b)+\\s.*(.*)",
            "(?i)(.*)(\\b)+TRUNCATE(\\b)+(\\s)*(" + SQL_TYPES.replaceAll(",", "|") + ")(\\b)+\\s.*(.*)",
            "(?i)(.*)(\\b)+LOCK(\\b)+(\\s)*(" + SQL_TYPES.replaceAll(",", "|") + ")(\\b)+\\s.*(.*)",
            "(?i)(.*)(\\b)+UNLOCK(\\b)+(\\s)*(" + SQL_TYPES.replaceAll(",", "|") + ")(\\b)+\\s.*(.*)",
            "(?i)(.*)(\\b)+RELEASE(\\b)+(\\s)*(" + SQL_TYPES.replaceAll(",", "|") + ")(\\b)+\\s.*(.*)",
            "(?i)(.*)(\\b)+DESC(\\b)+(\\w)*\\s.*(.*)",
            "(?i)(.*)(\\b)+DESCRIBE(\\b)+(\\w)*\\s.*(.*)",
            };

        for (String pattern : sqlInjectionPatterns) {
            if (input.contains(pattern)) {
                return true;
            }
        }
        return false;
    }
    
    private void loginbtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginbtn1ActionPerformed
       
    }//GEN-LAST:event_loginbtn1ActionPerformed

    private void jforgotpasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jforgotpasswordActionPerformed
        
    }//GEN-LAST:event_jforgotpasswordActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws Exception {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Mac Os".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    private static String makeKey() throws Exception {
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(256);
        SecretKey secretKey = keyGen.generateKey();
        byte[] secretKeyEncoded = secretKey.getEncoded();
        return Base64.getEncoder().encodeToString(secretKeyEncoded);
    }
    
    private static SecretKeySpec createSecretKey(char[] password, byte[] salt, int iterationCount, int keyLength) throws NoSuchAlgorithmException, InvalidKeySpecException {
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA512");
        PBEKeySpec keySpec = new PBEKeySpec(password, salt, iterationCount, keyLength);
        SecretKey keyTmp = keyFactory.generateSecret(keySpec);
        return new SecretKeySpec(keyTmp.getEncoded(), "AES");
    }

    private static String encrypt(String property, SecretKeySpec key) throws GeneralSecurityException, UnsupportedEncodingException {
        Cipher pbeCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        pbeCipher.init(Cipher.ENCRYPT_MODE, key);
        AlgorithmParameters parameters = pbeCipher.getParameters();
        IvParameterSpec ivParameterSpec = parameters.getParameterSpec(IvParameterSpec.class);
        byte[] cryptoText = pbeCipher.doFinal(property.getBytes("UTF-8"));
        byte[] iv = ivParameterSpec.getIV();
        return base64Encode(iv) + ":" + base64Encode(cryptoText);
    }

    private static String base64Encode(byte[] bytes) {
        return Base64.getEncoder().encodeToString(bytes);
    }

    private static String decrypt(String string, SecretKeySpec key) throws GeneralSecurityException, IOException {
        
        return new String(pbeCipher.doFinal(base64Decode(property)), "UTF-8");
    }

    private static byte[] base64Decode(String property) throws IOException {
        return Base64.getDecoder().decode(property);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel errorfield;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JButton jforgotpassword;
    private javax.swing.JButton loginbtn;
    private javax.swing.JButton loginbtn1;
    private javax.swing.JPasswordField passfield;
    private javax.swing.JTextField usernamefield;
    // End of variables declaration//GEN-END:variables
}
