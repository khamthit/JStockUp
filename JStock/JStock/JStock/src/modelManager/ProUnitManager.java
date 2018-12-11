/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelManager;
import Data.Msg;
import sysConnect.module;
import java.sql.*;
import model.ProUnit;

public class ProUnitManager {
    Connection c = module.getConnection();
    String sql;
    Msg msg = new Msg();
    
    public Boolean insertTbl_ProUnit(ProUnit pr){
        try {
            sql = "Select unit_l1, unit_l2 from tbl_ProUnit \n" +
                    "where unit_L1 = N'"+ pr.getUnit_L1().trim() +"' or unit_L2 = N'"+ pr.getUnit_L2().trim() +"'";
            ResultSet rs = c.createStatement().executeQuery(sql);
            if (rs.next()){
                msg.showMsgSameData();
            }else{
                sql = "Insert into tbl_ProUnit (PUID, Unit_L1, Unit_L2, Unit_Descriptions) values (?,?,?,?)";
                PreparedStatement p = c.prepareStatement(sql);
                p.setInt(1, pr.getPUID());
                p.setString(2, pr.getUnit_L1());
                p.setString(3, pr.getUnit_L2());
                p.setString(4, pr.getUnit_Descriptions());
                p.executeUpdate();
                msg.showMsgSucess();
                p.close();
                return true;
            }
            
            
        } catch (Exception e) {
        }
        return false;
    }
    
    
}
