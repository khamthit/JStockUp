/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelManager;

import Data.Msg;
import java.sql.Connection;
import java.sql.ResultSet;
import model.Main;
import sysConnect.module;
import Data.Msg;

/**
 *
 * @author Malimar
 */
public class Mainmanager {
    Connection c = module.getConnection();
    String sql;
    
    Main m = new Main();
    Msg mg = new Msg();
    
    public void showCompany(Main m){
        try {
           sql = "Select com_names_"+ LangType.Lang+" as comname, phone_1 +'    '+ phone_2 as mobiles, Fax, com_image from tbl_mycompany where used = 1";
            ResultSet rs = c.createStatement().executeQuery(sql);
            if (rs.next()){
                m.setCompany(rs.getString("comname"));
                m.setMobile(rs.getString("mobiles"));
                m.setFax(rs.getString("fax"));                
            }
            rs.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void showLogin(Main m){
        try {
            sql = "Exec pd_Login @username = '"+ m.getUser() +"', @password = '"+ m.getPassworld() +"'";
            ResultSet rs= c.createStatement().executeQuery(sql);
            if (rs.next()){
                LangType.LogIN = 1;                
            }
           
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    
}
