/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import OTHER.*;
import java.awt.List;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 * @author Guszty
 */
public class AdvertDAL{
    
    
    public String converturl(String oldurl)
    {
        String newurl="";
        
        char[] chars=oldurl.toCharArray();
          
        for(int i=0;i<oldurl.length();i++)
        {
            if(chars[i]=='\\')
            {
                chars[i]='/';
            }
        }
          
       newurl=new String(chars);

        return newurl;
        
    }
    
    public void addImmobilierAdvert(String title,String description,String image,Double price, String zone,Double surface,String imagename)
    {
    
      User user=null;
      String url="jdbc:mysql://localhost:3306/";
      String dbname="piata";
      String username="root";
      String password="root";
      Connection connection = null;
      Statement statement= null;
      ResultSet rs= null;
      ResultSetMetaData rsmd = null;
      
      try {
           
          System.out.println("picture dimension: "+image.length());
           
         Class.forName("com.mysql.jdbc.Driver").newInstance();
         
         connection = DriverManager.getConnection(url+dbname,username,password);
         
         statement = connection.createStatement();
         
         
         System.out.println("\nImage url in dal: "+image);
         System.out.println("\nImage name in dal: "+imagename);
         //statement.execute("select * from users where username='"+user_name+"' and password='"+pass_word+"'");
         //insert into immobilieradvert (title,description,picture,zone,surface,price) values ('apartament','vand apartament','C:/Users/Guszty/Desktop/test_new.jpg','grigorescu',63.0,63000.0);
         //INSERT INTO immobilieradvert (title,description,picture,zone,surface,price,picturename) values ('apartament','vand apartament',LOAD_FILE('C:/Users/Guszty/Desktop/new_testimage.jpg'),'grigorescu',63.0,63000.0,'new_testimage.jpg');
         //
         
         statement.execute("insert into immobilieradvert (title,description,picture,zone,surface,price,picturename) values ('"+title+"','"+description+"',LOAD_FILE('"+image+"'),'"+zone+"',"+surface+","+price+",'"+imagename+"')");
          
         //statement.execute("insert into immobilieradvert (title,description,picture,zone,surface,price,picturename) values ('"+title+"','"+description+"','"+image+"','"+zone+"',"+surface+","+price+",'"+imagename+"')");
         
         rs = statement.getResultSet();
        
          
      }
      catch(Exception sqlex) {
          System.err.println("The thorubles are with the connecting in the method:");
          sqlex.printStackTrace(System.err);
      }
      finally {
         if (rs != null) { 
            try { 
                rs.close();  
            } 
            catch(SQLException e) {
            }  
            rs = null;  
         }
         if (statement != null) { 
            try { 
               statement.close();  
            } 
            catch(SQLException e) {}  
            statement = null;  
         }
         if (connection != null) { 
            try { 
                connection.close();  
            } 
            catch(SQLException e) {}  
            connection = null;  
         }
      }
    }
    
    
    public ArrayList getalladverts()
    {
      Advert advert=null;
      ArrayList<Advert> adverts = new ArrayList<Advert>();

         
      User user=null;
      String url="jdbc:mysql://localhost:3306/";
      String dbname="piata";
      String username="root";
      String password="root";
      Connection connection = null;
      Statement statement= null;
      ResultSet rs= null;
      ResultSetMetaData rsmd = null;
      
      InputStream input = null;
      FileOutputStream output = null;

      String picturename="";
      String pictureurl="";
      String title="";
      String description=""; 
      String zone="";
      double surface=0.0;
      double price=0.0;
      
       try {
           
           
         Class.forName("com.mysql.jdbc.Driver").newInstance();
         
         connection = DriverManager.getConnection(url+dbname,username,password);
         
         statement = connection.createStatement();
         
         String sql="select * from immobilieradvert;";
              
         statement.execute(sql);
         
         rs = statement.getResultSet();
         
         while (rs.next()) {
            
            picturename=rs.getString("picturename");
             
             
            int i = rs.getInt("id");
            Blob ph = rs.getBlob("picture");


            InputStream in = ph.getBinaryStream();
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            OutputStream outputStream = new FileOutputStream (picturename);

            int length = (int) ph.length();
            int bufferSize = 1024;

            byte[] buffer = new byte[bufferSize];

            while ((length = in.read(buffer)) != -1) 
            {
                    //System.out.println("writing " + length + " bytes");
                    out.write(buffer, 0, length);   
            }
            
                out.writeTo(outputStream); 
                in.close();
                
            
            File fileout = new File(picturename);
            pictureurl=converturl(fileout.getAbsolutePath());
            title=rs.getString("title");
            description=rs.getString("description");
            
            
            advert=new Advert(title,description,pictureurl,picturename);
            
            adverts.add(advert);
            
         }
         /*
          while(rs.next()){
              
            picturename=rs.getString("picturename");
              
            File theFile = new File(picturename);
            output = new FileOutputStream(theFile);
       
            input =rs.getBinaryStream("picture"); 
            System.out.println("Reading resume from database...");
            System.out.println(sql);
				
            byte[] buffer = new byte[1024];
            
            while (input.read(buffer) > 0) 
            {
                output.write(buffer);
            }
				
            System.out.println("\nSaved to file: " + theFile.getAbsolutePath());
				
            //System.out.println("\nCompleted successfully!");
            
            pictureurl=converturl(theFile.getAbsolutePath());
            title=rs.getString("title");
            description=rs.getString("description");
            
            
            advert=new Advert(title,description,pictureurl,picturename);
            
            adverts.add(advert);
              
          }
          */
          
          
      }
      catch(Exception sqlex) {
          System.err.println("The thorubles are with the connecting in the method:");
          sqlex.printStackTrace(System.err);
      }
      finally {
         if (rs != null) { 
            try { 
                rs.close();  
            } 
            catch(SQLException e) {
            }  
            rs = null;  
         }
         if (statement != null) { 
            try { 
               statement.close();  
            } 
            catch(SQLException e) {}  
            statement = null;  
         }
         if (connection != null) { 
            try { 
                connection.close();  
            } 
            catch(SQLException e) {}  
            connection = null;  
         }
      }

         
         

         return adverts;
        //return advert;
    }
    
    
    
    public ArrayList getallImmobilieradverts()
    {
      Advert advert=null;
      ArrayList<ImmobilierAdvert> adverts = new ArrayList<ImmobilierAdvert>();

         
      User user=null;
      String url="jdbc:mysql://localhost:3306/";
      String dbname="piata";
      String username="root";
      String password="root";
      Connection connection = null;
      Statement statement= null;
      ResultSet rs= null;
      ResultSetMetaData rsmd = null;
      
      InputStream input = null;
      FileOutputStream output = null;

      String picturename="";
      String pictureurl="";
      String title="";
      String description=""; 
      String zone="";
      double surface=0.0;
      double price=0.0;
      
       try {
           
           
         Class.forName("com.mysql.jdbc.Driver").newInstance();
         
         connection = DriverManager.getConnection(url+dbname,username,password);
         
         statement = connection.createStatement();
         
         String sql="select * from immobilieradvert;";
              
         statement.execute(sql);
         
         rs = statement.getResultSet();
         
         while (rs.next()) {
            
            picturename=rs.getString("picturename");
             
             
            int i = rs.getInt("id");
            Blob ph = rs.getBlob("picture");


            InputStream in = ph.getBinaryStream();
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            OutputStream outputStream = new FileOutputStream (picturename);

            int length = (int) ph.length();
            int bufferSize = 1024;

            byte[] buffer = new byte[bufferSize];

            while ((length = in.read(buffer)) != -1) 
            {
                    //System.out.println("writing " + length + " bytes");
                    out.write(buffer, 0, length);   
            }
            
                out.writeTo(outputStream); 
                in.close();
                
            
            File fileout = new File(picturename);
            pictureurl=converturl(fileout.getAbsolutePath());
            title=rs.getString("title");
            description=rs.getString("description");
            zone=rs.getString("zone");
            surface=rs.getDouble("surface");
            price=rs.getDouble("price");
            
            advert=new ImmobilierAdvert(title,description,pictureurl,zone,surface,price,picturename);
            
            adverts.add((ImmobilierAdvert) advert);
            
         }
         
      }
      catch(Exception sqlex) {
          System.err.println("The thorubles are with the connecting in the method:");
          sqlex.printStackTrace(System.err);
      }
      finally {
         if (rs != null) { 
            try { 
                rs.close();  
            } 
            catch(SQLException e) {
            }  
            rs = null;  
         }
         if (statement != null) { 
            try { 
               statement.close();  
            } 
            catch(SQLException e) {}  
            statement = null;  
         }
         if (connection != null) { 
            try { 
                connection.close();  
            } 
            catch(SQLException e) {}  
            connection = null;  
         }
      }

         
         

         return adverts;
        //return advert;
    }
    
    
    
    public Advert getimmobilieradvert(String title)
    {
        
      ImmobilierAdvert advert=null;
 
      User user=null;
      String url="jdbc:mysql://localhost:3306/";
      String dbname="piata";
      String username="root";
      String password="root";
      Connection connection = null;
      Statement statement= null;
      ResultSet rs= null;
      ResultSetMetaData rsmd = null;
      
      InputStream input = null;
      FileOutputStream output = null;

      String picturename="";
      String pictureurl="";
      String description=""; 
      String zone="";
      double surface=0.0;
      double price=0.0;
      
       try {
           
           
         Class.forName("com.mysql.jdbc.Driver").newInstance();
         
         connection = DriverManager.getConnection(url+dbname,username,password);
         
         statement = connection.createStatement();
         
         String sql="select * from immobilieradvert where title='"+title+"';";
              
         statement.execute(sql);
         
         rs = statement.getResultSet();
         
         while (rs.next()) {
            
            picturename=rs.getString("picturename");
   
            int i = rs.getInt("id");
            Blob ph = rs.getBlob("picture");

            InputStream in = ph.getBinaryStream();
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            OutputStream outputStream = new FileOutputStream (picturename);

            int length = (int) ph.length();
            int bufferSize = 1024;

            byte[] buffer = new byte[bufferSize];

            while ((length = in.read(buffer)) != -1) 
            {
                    //System.out.println("writing " + length + " bytes");
                    out.write(buffer, 0, length);   
            }
            
            out.writeTo(outputStream); 
            in.close();
                
            
            File fileout = new File(picturename);
            pictureurl=converturl(fileout.getAbsolutePath());
            title=rs.getString("title");
            description=rs.getString("description");
            
            title=rs.getString("title");
            description=rs.getString("description");
            zone=rs.getString("zone");
            surface=rs.getDouble("surface");
            price=rs.getDouble("price");
                    
                    
                    
            advert=new ImmobilierAdvert(title,description,pictureurl,zone,surface,price,picturename);

            
         }
      }
      catch(Exception sqlex) {
          System.err.println("The thorubles are with the connecting in the method:");
          sqlex.printStackTrace(System.err);
      }
      finally {
         if (rs != null) { 
            try { 
                rs.close();  
            } 
            catch(SQLException e) {
            }  
            rs = null;  
         }
         if (statement != null) { 
            try { 
               statement.close();  
            } 
            catch(SQLException e) {}  
            statement = null;  
         }
         if (connection != null) { 
            try { 
                connection.close();  
            } 
            catch(SQLException e) {}  
            connection = null;  
         }
      }

       
          return advert;
      }
        
    public void deleteadvert(String adverttitle)
    {

      String url="jdbc:mysql://localhost:3306/";
      String dbname="piata";
      String username="root";
      String password="root";
      Connection connection = null;
      Statement statement= null;
      ResultSet rs= null;
      ResultSetMetaData rsmd = null;
      
      
       try {
           
           
         Class.forName("com.mysql.jdbc.Driver").newInstance();
         
         connection = DriverManager.getConnection(url+dbname,username,password);
         
         statement = connection.createStatement();
         
         String sql="delete from immobilieradvert where title='"+adverttitle+"'";
         
         statement.execute(sql);
         
          
      }
      catch(Exception sqlex) {
          System.err.println("The thorubles are with the connecting in the method:");
          sqlex.printStackTrace(System.err);
      }
      finally {
         if (rs != null) { 
            try { 
                rs.close();  
            } 
            catch(SQLException e) {
            }  
            rs = null;  
         }
         if (statement != null) { 
            try { 
               statement.close();  
            } 
            catch(SQLException e) {}  
            statement = null;  
         }
         if (connection != null) { 
            try { 
                connection.close();  
            } 
            catch(SQLException e) {}  
            connection = null;  
         }
      }

    }
    
    
    
    public void updateAdvert(String title,String description,String image,Double price, String zone,Double surface,String imagename)
    {
    
      User user=null;
      String url="jdbc:mysql://localhost:3306/";
      String dbname="piata";
      String username="root";
      String password="root";
      Connection connection = null;
      Statement statement= null;
      ResultSet rs= null;
      ResultSetMetaData rsmd = null;
      
      try {
           
         System.out.println("picture dimension: "+image.length());
           
         Class.forName("com.mysql.jdbc.Driver").newInstance();
         
         connection = DriverManager.getConnection(url+dbname,username,password);
         
         statement = connection.createStatement();

         //UPDATE tutorials_tbl SET tutorial_title='Learning JAVA' WHERE tutorial_id=3;
         
         statement.execute("UPDATE immobilieradvert SET description='"+description+"',picture=LOAD_FILE('"+image+"'),zone='"+zone+"',surface="+surface+",price="+price+",picturename='"+imagename+"'  WHERE title='"+title+"' ;");

      }
      catch(Exception sqlex) {
          System.err.println("The thorubles are with the connecting in the method:");
          sqlex.printStackTrace(System.err);
      }
      finally {
         if (rs != null) { 
            try { 
                rs.close();  
            } 
            catch(SQLException e) {
            }  
            rs = null;  
         }
         if (statement != null) { 
            try { 
               statement.close();  
            } 
            catch(SQLException e) {}  
            statement = null;  
         }
         if (connection != null) { 
            try { 
                connection.close();  
            } 
            catch(SQLException e) {}  
            connection = null;  
         }
      }
    }
    
    
    

}
