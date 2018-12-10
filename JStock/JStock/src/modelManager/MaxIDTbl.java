/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelManager;
import java.sql.*;
import sysConnect.module;

public class MaxIDTbl {
    Connection c = module.getConnection();    
    public static int getID=0;
    
    public static void maxID(String filed, String table){
        try {
            Connection c = module.getConnection();
            String sql = "Select isnull(max("+ filed +"+1), 1) as countmax from "+ table +"";
            ResultSet rs = c.createStatement().executeQuery(sql);
            if (rs.next()){
                getID = rs.getInt("countmax");
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
