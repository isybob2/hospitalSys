/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package systest;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.AlgorithmParameters;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.*;
import java.util.Base64;
import java.util.Properties;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author mdana
 */
public class DBConnection {
    
    // we need to set the connector first.
    static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/employees";
    static final String USER = "root";
    static final String PASS = "";
    static final String Password = "User1";
    ///static String decrypted = "";
    
    static String encryption = "";
    static String auth = "";
    private static SecretKeySpec key;
    
    static String encryp = "";
    static String encrypkey = "";
    
    public static Connection connectDB(){
         byte[] salt = new String("12345678").getBytes();
 
         AuthenticatedEncryptionCreated authenticatedEncryption = new systest.AuthenticatedEncryptionCreated();
        // Decreasing this speeds down startup time and can be useful during testing, but it also makes it easier for brute force attackers
        int iterationCount = 40000;
        // Other values give me java.security.InvalidKeyException: Illegal key size or default parameters
        int keyLength = 128;

        try {
         key = authenticatedEncryption.createSecretKey(Password.toCharArray(),
         salt, iterationCount, keyLength);
        } catch (Exception ex) {
                     //Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Connection conn = null;
        
        try{
            //Working Decryption - for connection
                Properties props = new Properties();
                FileInputStream in = new FileInputStream("C:\\Users\\magaj\\Documents\\NetBeansProjects\\PROJECTS_ROOT19\\medERP\\src\\encryptionhashBest\\connection.properties"); 
                props.load(in);
                String passwd = props.getProperty("database.login.password");

                String decryptedPassword = authenticatedEncryption.decrypt(passwd, key);
                          
            // open a connection.
            conn = DriverManager.getConnection(DB_URL,USER,decryptedPassword);
            
            decryptedPassword = "";
            
            return conn;
            
        } catch(SQLException ex){
             ex.printStackTrace();
             return null;
        } catch(Exception ex){
            
            System.out.println("There were errors while connecting to Database.");
            
            return null;
        }
    }
    
   
}
