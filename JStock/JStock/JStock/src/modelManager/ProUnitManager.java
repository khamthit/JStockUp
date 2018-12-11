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
import model.ProUnit;
import model.RemoveTableCount;

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
    public void showTbl_ProUnit(JTable table, DefaultTableModel model){
        try {
            RemoveTableCount.RemoveTable(table, model);
            sql = "exec pd_ProUnit";
            ResultSet rs = c.createStatement().executeQuery(sql);
            while (rs.next()){
                model.addRow(new Object[]{rs.getString("PUID"), rs.getString("Unit_L1"), rs.getString("Unit_L2"), rs.getString("Unit_Descriptions")});
            }
            table.setModel(model);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void showSearchTbl_ProUnit(JTable table, DefaultTableModel model, String x){
        try {
            RemoveTableCount.RemoveTable(table, model);
            sql = "Select puid, unit_l1, unit_l2, Unit_Descriptions from tbl_ProUnit "
                    + "Where Unit_L1 like N'%"+ x +"%' or unit_L2 like N'%"+ x +"%' or Unit_Descriptions like N'%"+ x +"%'";
            ResultSet rs = c.createStatement().executeQuery(sql);
            while (rs.next()){
                model.addRow(new Object[]{rs.getString("PUID"), rs.getString("Unit_L1"), rs.getString("Unit_L2"), rs.getString("Unit_Descriptions")});
            }
            table.setModel(model);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public Boolean updateTbl_ProUnit(ProUnit pu){
        try {
            sql = "update tbl_prounit set unit_l1 = ?, unit_l2 = ?, Unit_Descriptions = ? where puid = (?)";
            PreparedStatement p = c.prepareStatement(sql);
            p.setString(1, pu.getUnit_L1());
            p.setString(2, pu.getUnit_L2());
            p.setString(3, pu.getUnit_Descriptions());
            p.setInt(4, pu.getPUID());
            p.executeUpdate();
            msg.showMsgSucess();
            p.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
