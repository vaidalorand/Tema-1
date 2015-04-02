/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BL;
import OTHER.*;
import DAL.*;

//import static com.sun.org.apache.xml.internal.serialize.OutputFormat.Defaults.Encoding;
import java.io.UnsupportedEncodingException;
import java.security.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Guszty
 */
public class UserBL {
    
    
    public User getUser(String username,String password)
    {
        User user=null;
        UserDAL userdal=new UserDAL();
        String encodedpassword=getMd5(password);
        user=userdal.getuser(username, encodedpassword);
        
        return user;
    }
    
    public void deleteuser(String nume,String prenume)
    {
       UserDAL userdal=new UserDAL();
       userdal.deleteuser(nume,prenume);
    }
    
    public void adduser(String username,String password,String prenume,String nume,String functie)
    {
        UserDAL userdal=new UserDAL();
        userdal.adduser(username,getMd5(password),prenume,nume,functie);
    }
    
    public void updateuser(String username,String password,String prenume,String nume,String functie)
    {
        UserDAL userdal=new UserDAL();
        userdal.updateuser(username,getMd5(password),prenume,nume,functie);
    }
    
    public ArrayList getallusers()
    {
        UserDAL userdal=new UserDAL();
        return userdal.getallusers();
    }
    
    public void updatenr(String nume,String prenume)
    {
        UserDAL userdal=new UserDAL();
        userdal.updatenr(nume, getMd5(prenume));
    }
    
    private String getMd5(String message)
    {
     
        String digest = null;
    
    try 
    { 
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] hash = md.digest(message.getBytes("UTF-8")); 
    //converting byte array to Hexadecimal String 
        StringBuilder sb = new StringBuilder(2*hash.length); 
        
        for(byte b : hash)
        { 
            sb.append(String.format("%02x", b&0xff)); 
        } 
        
        digest = sb.toString(); 
    } 
    catch (UnsupportedEncodingException ex) 
    { 
       // Logger.getLogger(StringReplace.class.getName()).log(Level.SEVERE, null, ex); 
    } 
    catch (NoSuchAlgorithmException ex) 
    { 
        //Logger.getLogger(StringReplace.class.getName()).log(Level.SEVERE, null, ex); 
    } 
    
    return digest; 
    }

    
    
}
