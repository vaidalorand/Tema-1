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
public class Advert {
    
    String title="";
    String description="";
    String url="";
    String picturename="";
    
    
    public Advert(String title,String description,String url,String picturename)
    {
        this.title=title;
        this.description=description;
        this.url=url;
        this.picturename=picturename;
    }
    
    
    public String gettitle()
    {
        return title;
    }
    
    public String getdescription()
    {
        return description;
    }
    
    public String geturl()
    {
        return url;
    }
    
    public String getpicturename()
    {
        return picturename;
    }
}
