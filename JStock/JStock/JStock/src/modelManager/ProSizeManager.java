/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelManager;

import Data.Msg;
import java.sql.*;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.ProSize;
import model.RemoveTableCount;
import sysConnect.module;

public class ProSizeManager {

    String sql;
    Connection c = module.getConnection();
    Msg msg = new Msg();

    public Boolean InsertTblProSize(ProSize ps) {
        try {
            sql = "insert into tbl_ProSize (PSizeID, SizeName, SizeDescriptions) values (?,?,?)";
            PreparedStatement p = c.prepareStatement(sql);
            p.setInt(1, ps.getProSizeID());
            p.setString(2, ps.getProSizeName());
            p.setString(3, ps.getProSizeDescriptions());
            p.executeUpdate();
            msg.showMsgSucess();
            p.close();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public void showData(JTable table, DefaultTableModel model){
        try {
            RemoveTableCount.RemoveTable(table, model);
            sql = "Select * from tbl_ProSize\n" +
                    "order by SizeName";
            ResultSet rs = c.createStatement().executeQuery(sql);
            while (rs.next()){
                model.addRow(new Object[]{rs.getString("PSizeID"), rs.getString("sizename"), rs.getString("SizeDescriptions")});
            }
            table.setModel(model);
        } catch (Exception e) {
        }
    }
    public void showSearchData(JTable table, DefaultTableModel model, String x){
        try {
            RemoveTableCount.RemoveTable(table, model);
            sql = "Select * from tbl_ProSize where sizename like N'%"+ x +"%' or SizeDescriptions like N'%"+ x +"%' order by SizeName";
            ResultSet rs = c.createStatement().executeQuery(sql);
            while (rs.next()){
                model.addRow(new Object[]{rs.getString("PSizeID"), rs.getString("sizename"), rs.getString("SizeDescriptions")});
            }
            table.setModel(model);
        } catch (Exception e) {
        }
    }
    public boolean updateTblProSize(ProSize ps){
        try {
            sql = "update tbl_ProSize set Sizename = ?, sizeDescriptions = ? where PSizeID = (?)";
            PreparedStatement p = c.prepareStatement(sql);
            p.setString(1, ps.getProSizeName());
            p.setString(2, ps.getProSizeDescriptions());
            p.setInt(3, ps.getProSizeID());
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
