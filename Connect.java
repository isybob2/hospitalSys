/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package systest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.AlgorithmParameters;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ilyas
 */
public class Connect {
static String url = "";        
    static String userName = "";          
    static String password = "";
    static String decryptedurl = "";
    static String decryptedusername = "";
    static String decryptedpassword = "";
    static SecretKeySpec urlkey;
    static SecretKeySpec usernamekey;
    static SecretKeySpec passwordkey;
    final String secretKey = "secrete";
    
    public static Connection getConnection() throws SQLException{
        ////////////////////////////////////////////////////////
       Properties props = new Properties();
                ///try (FileInputStream in = new FileInputStream("src/encryptionhashBest/First.properties")) {
                
        try{
            //BasicTextEncryptor encryptor = new BasicTextEncryptor();
            //encryptor.setPassword("jasypt");

            //decrypt to use
            FileInputStream in = new FileInputStream("C:\\Users\\magaj\\Documents\\NetBeansProjects\\PROJECTS_ROOT19\\medERP\\src\\encryptionhashBest\\connect.properties"); 
            props.load(in);
            
            
            
            //String driver = props.getProperty("datasource.driver");
            url = props.getProperty("datasource.url");        
            userName = props.getProperty("datasource.userName");          
            password = props.getProperty("datasource.password");
            
            decryptedurl = decrypt(url, urlkey);
            decryptedusername = decrypt(userName, usernamekey);
            decryptedpassword = decrypt(password, passwordkey);

            //decrypt to make connection
            ///Class.forName(driver);
            //Connection con = DriverManager.getConnection(url, userName, password);
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = (Connection) DriverManager.getConnection(decryptedurl, decryptedusername, decryptedpassword);
            con.setAutoCommit(false);

            return con;
        } catch(ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch(SQLException e) {
            e.printStackTrace();
            return null;
        }
        
        
        
        ///////////////////////////////////////////////////////////////////
        
      /* 
        //direct connection  
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/employees", "root", "user1");
            System.out.println("INFO : Connected to DB 'Hospital' successfully");
            return con;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("ERROR : Can't Connect to DB");
        }
        return null;
    }
    */  
      return null;
   }   
    
    public static ResultSet Select_request(String req){
        ResultSet rs;
        try{      
            Connection c = getConnection();
            Statement st= c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
            rs= st.executeQuery(req);
            
            /* 
            //writing to mysql database securely wiyh Prepared statement to prevent sql injection attack
            //Check jtable report in MedicalReport for the retrieval version
            String insert = "INSERT INTO customer(name,address,email) VALUES(?, ?, ?);";
            PreparedStatement ps = connection.prepareStatement(insert);
            ps.setString(1, name);
            ps.setString(2, addre);
            ps.setString(3, email);

            ResultSet rs = ps.executeQuery();
            */
            return rs;
        }catch(Exception e){
            System.err.println("ERROR : Can't Reach DB");
            e.printStackTrace();
            return null;
        }

    }
    
    public static boolean AMS_request(String req){
        try{
            Connection c = getConnection();
            Statement st= c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
            int rowaffected = st.executeUpdate(req);
//            if (rowaffected >= 1){
//                return true;
//            }
//            else{
//                return false;
//            }
            return true;
        }catch(Exception e){
            System.err.println("ERROR : Can't Update DB");
            e.printStackTrace();
            return false;
        }
    }
    
    public static DefaultTableModel FillTable(String req){
        ResultSet rs= Select_request(req);
        try {
            DefaultTableModel m =new DefaultTableModel();
            int nbcol=rs.getMetaData().getColumnCount();
            String[] nomcol= new String[nbcol];
            for(int i=0;i<nbcol;i++){
                nomcol[i]=rs.getMetaData().getColumnName(i+1);
            }
            m.setColumnIdentifiers(nomcol);
            while(rs.next()){
                String [] donner =new String[nbcol];
                for(int i=0;i<nbcol;i++){
                    donner[i]=rs.getString(i+1);
                }
                m.addRow(donner);
            }
            return m;
        } catch (SQLException ex) {
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
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
}
