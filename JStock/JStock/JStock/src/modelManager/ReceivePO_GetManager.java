/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelManager;
import java.sql.*;
import java.util.HashMap;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.ReceivePO_Get;
import model.RemoveTableCount;
import sysConnect.module;

public class ReceivePO_GetManager {
    Connection c = module.getConnection();
    String sql;
    
    public void showReceivePO_Get(JTable table, DefaultTableModel model, String x){
        try {
            RemoveTableCount.RemoveTable(table, model);
            sql = "Select act.actdid, act.Barode, act.item_"+ LangType.Lang +" AS item, pu.unit_"+ LangType.Lang +" AS units, act.Costprice, isnull(Receive_qty, '0') as receive_qty\n" +
                    "from tbl_activitydetails act\n" +
                    "left join tbl_Activity ac on ac.ACTID = act.actid\n" +
                    "left join tbl_Vendor v on v.venid = act.venid\n" +
                    "left join tbl_Item it on it.ITID = act.itid\n" +
                    "left join tbl_ProUnit pu on pu.PUID = it.PUID\n" +
                    "where ac.ActNo = N'"+ x +"'\n" +
                    "group by act.actdid, act.Barode, ac.actNo, act.item_"+ LangType.Lang +", act.Costprice, receive_qty, pu.Unit_"+ LangType.Lang +"";
            ResultSet rs = c.createStatement().executeQuery(sql);
            while (rs.next()){
                model.addRow(new Object[]{rs.getString("actdid"), rs.getString("barode"), rs.getString("item"), rs.getString("units"), rs.getDouble("costprice"), rs.getDouble("receive_qty")});
            }
            table.setModel(model);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void showSearchReceivePO_Get(JTable table, DefaultTableModel model, String x, String x1){
        try {
            RemoveTableCount.RemoveTable(table, model);
            sql = "Select act.actdid, act.Barode, act.item_"+ LangType.Lang +" AS item, pu.unit_"+ LangType.Lang +" AS units, act.Costprice, isnull(Receive_qty, '0') as receive_qty\n" +
                    "from tbl_activitydetails act\n" +
                    "left join tbl_Activity ac on ac.ACTID = act.actid\n" +
                    "left join tbl_Vendor v on v.venid = act.venid\n" +
                    "left join tbl_Item it on it.ITID = act.itid\n" +
                    "left join tbl_ProUnit pu on pu.PUID = it.PUID\n" +
                    "where act.barode like N'"+ x1 +"%' or act.item_"+LangType.Lang+" like N'%"+ x1 +"%' or pu.unit_"+ LangType.Lang +" like N'%"+ x1 +"%' "
                    + "group by act.actdid, act.Barode, ac.actNo, act.item_"+ LangType.Lang +", act.Costprice, receive_qty, pu.Unit_"+ LangType.Lang +" "
                    + "having ac.ActNo = N'"+ x +"'";
            ResultSet rs = c.createStatement().executeQuery(sql);
            while (rs.next()){
                model.addRow(new Object[]{rs.getString("actdid"), rs.getString("barode"), rs.getString("item"), rs.getString("units"), rs.getDouble("costprice"), rs.getDouble("receive_qty")});
            }
            table.setModel(model);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public Boolean getProduct(ReceivePO_Get rcg){
        try {
            sql = "update tbl_activitydetails set stockid = ?, stockname_l1 = ?, stockname_l2 = ?, Receive_activity = ?, Receive_qty = ?,\n" +
            "Receive_bill = ?, Receive_POBill = ? where Actdid = (?)";
            PreparedStatement p = c.prepareStatement(sql);
            p.setInt(1, rcg.getStockID());
            p.setString(2, rcg.getStockName_L1());
            p.setString(3, rcg.getStockName_L2());
            p.setBoolean(4, rcg.getReceive_activity());
            p.setDouble(5, rcg.getReceive_qty());
            p.setString(6, rcg.getReceive_bill());
            p.setString(7, rcg.getReceive_POBill());
            p.setInt(8, rcg.getActdid());
            p.executeUpdate();
            p.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public HashMap<String, Object[]>mapStock(){
        try {
            HashMap<String, Object[]>map = new HashMap();
            sql = "Select stockid, StockName_"+ LangType.Lang +" as stocks, stockname_L1, stockname_l2 from tbl_Stock\n" +
                    "order by StockName_"+ LangType.Lang +"";
            ResultSet rs = c.createStatement().executeQuery(sql);
            while (rs.next()){
                map.put(rs.getString("stocks"), new Object[]{rs.getString("stockid"), rs.getString("stockname_l1"), rs.getString("stockname_l2")});
            }
            return map;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
