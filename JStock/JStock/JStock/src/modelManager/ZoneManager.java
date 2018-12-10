/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelManager;
import Data.Msg;
import sysConnect.module;
import java.sql.*;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.RemoveTableCount;
import model.Zones;

public class ZoneManager {
    Connection c = module.getConnection();
    String sql;
    
    public void showTbl_Zone(JTable table, DefaultTableModel model){
        try {
            RemoveTableCount.RemoveTable(table, model);
            sql = "Select ZoneID, ZoneNo from tbl_Zone order by ZoneID";
            ResultSet rs = c.createStatement().executeQuery(sql);
            while (rs.next()){
                model.addRow(new Object[]{rs.getString("ZoneID"), rs.getString("ZoneNo")});
            }
            table.setModel(model);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public Boolean insertTbl_Zone(Zones z){
        try {
            Msg msg = new Msg();
            sql = "Select zoneNo from tbl_zone where zoneNo = '"+ z.getZoneNo() +"'";
            ResultSet rs = c.createStatement().executeQuery(sql);
            if (rs.next()){                
                msg.showMsgSameData();
            }else{
                sql = "Insert into tbl_zone (ZoneID, ZoneNo) values (?,?)";
                PreparedStatement p = c.prepareStatement(sql);
                p.setInt(1, z.getZoneid());
                p.setString(2, z.getZoneNo());
                p.executeUpdate();
                p.close();
                msg.showMsgSucess();
                return true;
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public Boolean updateTbl_Zone(Zones z){
        try {
            sql = "Update tbl_Zone set ZoneNo = ? where ZoneID = (?)";
            PreparedStatement p = c.prepareStatement(sql);
            p.setString(1, z.getZoneNo());
            p.setInt(2, z.getZoneid());
            p.executeUpdate();
            p.close();
            return true;            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
}
