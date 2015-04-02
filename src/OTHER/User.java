/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OTHER;

/**
 *
 * @author Guszty
 */
public class User {
    
    String username="";
    String password="";
    String firstname="";
    String lastname="";
    String function="";
    int nr=0;
    
    public User(String username,String password,String firstname,String lastname,String function,int nr)
    {
        this.username=username;
        this.password=password;
        this.firstname=firstname;
        this.lastname=lastname;
        this.function=function;
        this.nr=nr;
    }
    
    
    public String getusername()
    {
        return username;
    }
    
    public String getpassword()
    {
        return password;
    }
    
    public String getfirstname()
    {
        return firstname;
    }
    
    public String getlastname()
    {
        return lastname;
    }
    
    public String getfunction()
    {
        return function;
    }
    
    public int getnr()
    {
        return nr;
    }
    
}
