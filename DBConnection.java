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
        
        }
        
        Connection conn = null;
        
        try{
            //Working Decryption - for connection
                Properties props = new Properties();
                FileInputStream in = new FileInputStream("C:\\Users\\magaj\\Documents\\NetBeansProjects\\PROJECTS_ROOT19\\medERP\\src\\encryptionhashBest\\connection.properties"); 
                props.load(in);
                String passwd = props.getProperty("database.login.password");
                String decryptedPassword = "";
                                        
            // open a connection.
            conn = DriverManager.getConnection(DB_URL,USER,decryptedPassword);
            
                      
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
