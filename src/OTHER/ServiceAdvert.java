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
public class ServiceAdvert extends Advert{
    
    String title="";
    String description="";
    String url="";
    double pricperhour=0.0;
    String picturename="";
    
    public ServiceAdvert(String title,String description,String url,double priceperhour,String picturename)
    {
        super(title,description,url,picturename);
        this.title=title;
        this.description=description;
        this.url=url;
        this.pricperhour=priceperhour;
        this.picturename=picturename;
    }
    
    @Override
     public String gettitle()
    {
        return title;
    }
    @Override
    public String getdescription()
    {
        return description;
    }
    @Override
    public String geturl()
    {
        return url;
    }
    
    public double getpriceperhour()
    {
        return pricperhour;
    }
    
        public String getpicturename()
    {
        return picturename;
    }
    
}
