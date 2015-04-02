/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import OTHER.Advert;
import OTHER.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Guszty
 */
public class UserDAL {
    
    public User getuser(String user_name,String pass_word)
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
           
           
         Class.forName("com.mysql.jdbc.Driver").newInstance();
         
         connection = DriverManager.getConnection(url+dbname,username,password);
         
         statement = connection.createStatement();
         
         statement.execute("select * from users where username='"+user_name+"' and password='"+pass_word+"'");
         
         rs = statement.getResultSet();
         
         rsmd = rs.getMetaData();
          
          while(rs.next()){
        
              user=new User(rs.getString("username"),rs.getString("password"),rs.getString("firstname"),rs.getString("lastname"),rs.getString("function"),rs.getInt("numberofadverts"));
            // s = s + "ID: " + rs.getInt("id")+"   USERNAME: "+rs.getString("username")+"  PASSWORD: "+rs.getString("password")+"  FUNCTION: "+rs.getString("function")+"\n";
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
      
       return user;
    }
    
    
    
    
    public void deleteuser(String nume,String prenume)
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
           
         Class.forName("com.mysql.jdbc.Driver").newInstance();
         
         connection = DriverManager.getConnection(url+dbname,username,password);
         
         statement = connection.createStatement();
         
         statement.execute("delete from users where firstname='"+prenume+"' and lastname='"+nume+"';");
         
         
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
    
    public void adduser(String username2,String password2,String prenume,String nume,String functie)
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
           
         Class.forName("com.mysql.jdbc.Driver").newInstance();
         
         connection = DriverManager.getConnection(url+dbname,username,password);
         
         statement = connection.createStatement();
         
         statement.execute("insert into users (username,password,firstname,lastname,function,numberofadverts) values ('"+username2+"','"+password2+"','"+prenume+"','"+nume+"','"+functie+"',0);");
         
         
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
    
    
    public void updateuser(String username2,String password2,String prenume,String nume,String functie)
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
           
         Class.forName("com.mysql.jdbc.Driver").newInstance();
         
         connection = DriverManager.getConnection(url+dbname,username,password);
         
         statement = connection.createStatement();
         
         //"UPDATE immobilieradvert SET description='"+description+"',picture=LOAD_FILE('"+image+"'),zone='"+zone+"',surface="+surface+",price="+price+",picturename='"+imagename+"'  WHERE title='"+title+"' ;"
         statement.execute("update users set password='"+password2+"',firstname='"+prenume+"',lastname='"+nume+"',function='"+functie+"' where username='"+username2+"';");
         
         
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
    
    
    public void updatenr(String nume,String prenume)
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
           
         Class.forName("com.mysql.jdbc.Driver").newInstance();
         
         connection = DriverManager.getConnection(url+dbname,username,password);
         
         statement = connection.createStatement();
         
         //"UPDATE immobilieradvert SET description='"+description+"',picture=LOAD_FILE('"+image+"'),zone='"+zone+"',surface="+surface+",price="+price+",picturename='"+imagename+"'  WHERE title='"+title+"' ;"
        statement.execute("update users set numberofadverts=numberofadverts+1 where username='"+nume+"' and password='"+prenume+"'");
         
         
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
    
    public ArrayList getallusers()
    {
        ArrayList<User> users = new ArrayList<User>();
        

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

           Class.forName("com.mysql.jdbc.Driver").newInstance();

           connection = DriverManager.getConnection(url+dbname,username,password);

           statement = connection.createStatement();
           
           statement.execute("select * from users where function='user';");
         
            rs = statement.getResultSet();

            while(rs.next())
            {

                 user=new User(rs.getString("username"),rs.getString("password"),rs.getString("firstname"),rs.getString("lastname"),rs.getString("function"),rs.getInt("numberofadverts"));
                 users.add(user);
                 
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

        
        
    
        return users;
    }
             
    
    
}
