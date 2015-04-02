/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;
import BL.AdvertBL;
import OTHER.*;

import DAL.AdvertDAL;
import static com.sun.javafx.fxml.expression.Expression.not;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;
import java.nio.file.Files;
import java.nio.file.Path;
import javax.swing.Icon;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JTable;
import javax.swing.table.TableColumn;
import javax.swing.*;
/**
 *
 * @author Guszty
 */
public class MainInterface extends javax.swing.JFrame{ 

    /**
     * Creates new form MainInterface
     */
    
    ImageIcon icon=null;
    DefaultTableModel Tmodel=null;
    DefaultTableModel jtable;
    
    
    public MainInterface()
    {
     
        
        initComponents(); 

        
        drawalladverts();
        
        
        //Jtable m_table = new JTable();
        
        table.addMouseListener(new MouseAdapter() 
        {
            public void mouseClicked(MouseEvent e) {
            int row = table.getSelectedRow();
            int col = table.getSelectedColumn();

            //System.out.println("row: "+row+" col: "+col);
            
            //new DisplayImmobilierAdvert().show();

            displayinformation(row,col);   
            
            
        }
        });
         
        
    }


    public void displayinformation(int row,int col)
    {
        String selectedtitle=(String) table.getModel().getValueAt(row,0);
        AdvertBL advertbl=new AdvertBL();
        ImmobilierAdvert advert=(ImmobilierAdvert)advertbl.getimmobilieradvert(selectedtitle);

        new DisplayImmobilierAdvert(advert).show();
        
    }
    
    public void drawalladverts()
    {
        
        DefaultTableModel jtable = (DefaultTableModel) table.getModel();
        jtable.setNumRows(0); 
        table.setRowHeight(100);
        
                
        AdvertBL advertbl=new AdvertBL();
       
        ArrayList<Advert> adverts = advertbl.getalladverts();
       
        int numberofadverts= adverts.size();
        
        Advert advert=null;
        
        for(int i=0;i<numberofadverts;i++)
        {
            advert=adverts.get(i);
            
            if(advert!=null)
            {
               // System.out.println("url imagine: "+advert.geturl());

                jtable.addRow(new Object[]{advert.gettitle(),advert.getdescription(),""});
                icon = new ImageIcon(advert.geturl());
                table.getColumnModel().getColumn(2).setCellRenderer(new ImageRenderer());
                jtable.setValueAt(icon, i, 2);
            }
        }
        
        /*
        jtable.addRow(new Object[]{"Ana","are",""});
        icon = new ImageIcon("C:/Users/Guszty/Desktop/new_testimage.jpg");
        table.getColumnModel().getColumn(2).setCellRenderer(new ImageRenderer());
        jtable.setValueAt(icon, 0, 2);
        
       jtable.addRow(new Object[]{"Vasi","are",""});
       icon = new ImageIcon("C:/Users/Guszty/Desktop/test_new.jpg");
       table.getColumnModel().getColumn(2).setCellRenderer(new ImageRenderer());
       jtable.setValueAt(icon, 1, 2);
*/
      //System.out.println("advert 1: "+a.gettitle() +"\n length: "+ adv.getalladverts().size());
      
       //System.out.println("advert 1: \ntitle: "+a.gettitle() +"\ndescription: "+a.getdescription()+"\npicture url: "+a.geturl()+"\npicture name: "+a.getpicturename());
 
    }

    
    public void searchinadverts(String searchtext)
    {
 
        DefaultTableModel jtable = (DefaultTableModel) table.getModel();
        jtable.setNumRows(0); 
        table.setRowHeight(100);
        
                
        AdvertBL advertbl=new AdvertBL();
       
        ArrayList<Advert> adverts = advertbl.searchinadverts(searchtext);
       
        int numberofadverts= adverts.size();
        
        Advert advert=null;
        
        for(int i=0;i<numberofadverts;i++)
        {
            advert=adverts.get(i);
            
            if(advert!=null)
            {
                //System.out.println("url imagine: "+advert.geturl());

                jtable.addRow(new Object[]{advert.gettitle(),advert.getdescription(),""});
                icon = new ImageIcon(advert.geturl());
                table.getColumnModel().getColumn(2).setCellRenderer(new ImageRenderer());
                jtable.setValueAt(icon, i, 2);
            }
        }
        
       
        this.repaint();
    }
    
    public void mouseClicked(MouseEvent e) 
    {
        System.out.println("sa dat pe mouse");
        repaint();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        searchtextfield = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("LogIn");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Titlu", "Descriere", "Poza"
            }
        ));
        table.setGridColor(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(table);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selectati domeniul...", "Anunturi imobiliare", "Pestari servicii" }));

        jButton3.setText("Cauta");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Adauga anunt");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton2.setText("Refresh");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton5.setText("Afiseaza toate");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 809, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(714, 714, 714)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(37, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jButton4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(searchtextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton3)
                                .addGap(18, 18, 18)
                                .addComponent(jButton5)
                                .addGap(18, 18, 18)
                                .addComponent(jButton2)))))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3)
                    .addComponent(searchtextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2)
                    .addComponent(jButton5))
                .addGap(39, 39, 39)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(jLabel1))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
  

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        
        new LogIn().show();
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        
        new AddAdvert().show();
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
       
        String searchtext=searchtextfield.getText();
        
        if(!(searchtext.equals("")))
        {
            searchinadverts(searchtext);
        }
        
        searchtextfield.setText("");
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        
       table.repaint();
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        
        drawalladverts();
        
    }//GEN-LAST:event_jButton5ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]){
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainInterface().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField searchtextfield;
    public javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables

   
}
