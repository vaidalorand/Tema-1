/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BL;
import DAL.*;
import OTHER.Advert;
import OTHER.ImmobilierAdvert;
import UI.MainInterface;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Guszty
 */
public class AdvertBL {
    
    String imageurl="";
    

    
    
    
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
        AdvertDAL advertdal=new AdvertDAL();
        advertdal.addImmobilierAdvert(title, description, converturl(image), price, zone, surface,imagename);
        MainInterface mi=new MainInterface();
    }
    

    public ArrayList getalladverts()
    {
        AdvertDAL advertdal=new AdvertDAL();
        ArrayList<Advert> adverts = advertdal.getalladverts();
        
        return adverts;
    }
    
    public Advert getimmobilieradvert(String title)
    {
        ImmobilierAdvert immobilieradvert=null;
        AdvertDAL advertdal=new AdvertDAL();
        
        immobilieradvert=(ImmobilierAdvert)advertdal.getimmobilieradvert(title);
        
        return immobilieradvert;
    }
    
    public ArrayList searchinadverts(String searchtext)
    {
        AdvertDAL advertdal=new AdvertDAL();
        ArrayList<Advert> adverts = advertdal.getalladverts();
        ArrayList<Advert> aux=new ArrayList<Advert>();
        Advert advert=null;
        
        for(int i=0;i<adverts.size();i++)
        {
            advert=adverts.get(i);
            
            if(searchtext.toLowerCase().contains(advert.gettitle().toLowerCase()) || searchtext.toLowerCase().contains(advert.getdescription().toLowerCase()))
            {
                aux.add(advert);
            }
            
        }
        
        return aux;
    }
     
    
    public void deleteadvert(String adverttitle)
    {
        AdvertDAL advertdal=new AdvertDAL();
        
        advertdal.deleteadvert(adverttitle);
        
    }
    
    public void updateImmobilierAdvert(String title,String description,String imageurl,double price,String zone,double surface,String imagename)
    {
        AdvertDAL advertdal=new AdvertDAL();
        
        advertdal.updateAdvert(title, description,converturl(imageurl), price, zone, surface,imagename);
        
    }
    
    
    public void addfromfile(String url) throws Exception 
    {
        //System.out.println(converturl(url));
        
        String splitBy = ",";
        BufferedReader br = new BufferedReader(new FileReader(converturl(url)));
        String line = br.readLine();
        String[] b = line.split(splitBy);
        
        String title;
        String description;
        String pictureurl;
        String zone;
        double surface;
        double price;
        String picturename;
        
        AdvertDAL advertdal=new AdvertDAL();
        
        if (!b.equals("")) 
        {
           //System.out.println(b[0]+b[1]+b[2]+b[3]+b[4]+b[5]+b[6]);
           title=b[0];
           description=b[1];
           pictureurl=b[2];
           zone=b[3];
           surface=Double.valueOf(b[4]);
           price=Double.valueOf(b[5]);
           picturename=b[6];
           
           advertdal.addImmobilierAdvert(title, description, pictureurl, price, zone, surface, picturename);
        }
        
        while((line = br.readLine()) !=null)
        {
            b = line.split(splitBy);
            
            title=b[0];
            description=b[1];
            pictureurl=b[2];
            zone=b[3];
            surface=Double.valueOf(b[4]);
            price=Double.valueOf(b[5]);
            picturename=b[6];

            advertdal.addImmobilierAdvert(title, description, pictureurl, price, zone, surface, picturename);
        }
        br.close();

    } 
    
    
    public void createcsv(String url)
    {
        
        String filename="exportedadverts.csv";
        String newurl=converturl(url+"\\")+filename;
        
        AdvertDAL advertdal=new AdvertDAL();
        ArrayList<ImmobilierAdvert> adverts = advertdal.getallImmobilieradverts();
        ImmobilierAdvert immobilieradvert=null;
        
        try
	{

            String sFileName;
	    FileWriter writer = new FileWriter(newurl);

            
            for(int i=0;i<adverts.size();i++)
            {
                immobilieradvert=adverts.get(i);
                System.out.println(immobilieradvert.gettitle());
                writer.append(immobilieradvert.gettitle());
                writer.append(',');
                writer.append(immobilieradvert.getdescription());
                writer.append(',');
                writer.append(immobilieradvert.geturl());
                writer.append(',');
                writer.append(immobilieradvert.getzone());
                writer.append(',');
                writer.append(String.valueOf(immobilieradvert.getsurface()));
                writer.append(',');
                writer.append(String.valueOf(immobilieradvert.getprice()));
                writer.append(',');
                writer.append(immobilieradvert.getpicturename());  
                writer.append('\n');
            
            }
            
	    writer.flush();
	    writer.close();
	}
	catch(IOException e)
	{
	     e.printStackTrace();
	} 
        
    
    }
    
    
    
}
