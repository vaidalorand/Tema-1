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
public class ImmobilierAdvert extends Advert{
    
    String title="";
    String description="";
    String url="";
    String zone="";
    double surface=0.0;
    double price=0.0;
    String picturename="";
    
    public ImmobilierAdvert(String title,String description,String url,String zone,double surface,double price,String picturename)
    {
        super(title,description,url,picturename);
        this.title=title;
        this.description=description;
        this.url=url;
        this.zone=zone;
        this.surface=surface;
        this.price=price;
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
    
    public String getzone()
    {
        return zone;
    }
    
    public double getsurface()
    {
        return surface;
    }
    
    public double getprice()
    {
        return price;
    }
        public String getpicturename()
    {
        return picturename;
    }
    
}
