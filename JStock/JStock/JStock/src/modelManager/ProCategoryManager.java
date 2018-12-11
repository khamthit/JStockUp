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
import model.ProCategory;
import model.RemoveTableCount;
import sysConnect.module;

public class ProCategoryManager {
    Connection c = module.getConnection();
    String sql;
    Msg msg = new Msg();
    public Boolean insertTbl_ProCategory(ProCategory pc){
        try {
            sql = "Select cate_l1, cate_l2 from tbl_ProCategory where cate_l1 = N'"+ pc.getCate_L1() +"' or cate_l2 = N'"+ pc.getCate_L2() +"'";
            ResultSet rs = c.createStatement().executeQuery(sql);
            if (rs.next()){
                msg.showMsgSameData();
            }else{
                sql = "insert into tbl_ProCategory (PCTID, cate_l1, cate_l2, Cate_Descriptions) values (?,?,?,?)";
                PreparedStatement p = c.prepareStatement(sql);
                p.setInt(1, pc.getPCTID());
                p.setString(2, pc.getCate_L1());
                p.setString(3, pc.getCate_L2());
                p.setString(4, pc.getCate_Descriptions());
                p.executeUpdate();
                msg.showMsgSucess();
                p.close();
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public Boolean updateTbl_Procategory(ProCategory pc){
        try {
            sql = "Update tbl_proCategory set cate_l1 = ?, cate_l2 = ?, cate_descriptions = ? where pctid = (?)";
            PreparedStatement p = c.prepareStatement(sql);
            p.setString(1, pc.getCate_L1());
            p.setString(2, pc.getCate_L2());
            p.setString(3, pc.getCate_Descriptions());
            p.setInt(4, pc.getPCTID());
            p.executeUpdate();
            msg.showMsgSucess();
            p.close();
            return true;            
        } catch (Exception e) {
        }
        return false;
    }
    public void showTbl_ProCategory(JTable table, DefaultTableModel model){
        try {
            RemoveTableCount.RemoveTable(table, model);
            sql = "exec pd_ProCategory";
            ResultSet rs = c.createStatement().executeQuery(sql);
            while (rs.next()){
                model.addRow(new Object[]{rs.getString("pctid"), rs.getString("cate_l1"), rs.getString("cate_l2"), rs.getString("cate_descriptions")});                
            }
            table.setModel(model);
        } catch (Exception e) {
        }
    }
    public void showSearchTable_procategory(JTable table, DefaultTableModel model, String x){
        try {
            RemoveTableCount.RemoveTable(table, model);
            sql = "Select pctid, cate_l1, cate_l2, cate_descriptions from tbl_ProCategory\n" +
                    "where cate_l1 like N'%"+ x +"%' or cate_l2 like N'%"+ x +"%' or cate_Descriptions like N'%"+ x +"%'";
            ResultSet rs = c.createStatement().executeQuery(sql);
            while (rs.next()){
                model.addRow(new Object[]{rs.getString("pctid"), rs.getString("cate_l1"), rs.getString("cate_l2"), rs.getString("cate_descriptions")});                
            }
            table.setModel(model);
        } catch (Exception e) {
        }
    }
}
