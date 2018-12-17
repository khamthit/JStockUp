/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelManager;

import java.util.HashMap;
import java.sql.*;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.RemoveTableCount;
import sysConnect.module;


/**
 *
 * @author Admin
 */
public class PurchaseeManager {
    Connection c = module.getConnection();
    String sql;
    public HashMap<String, Object[]>hmapStock(){
        try {
            HashMap<String, Object[]>mapStock = new HashMap();
            sql = "Select stockid, stockname_l1, stockname_l2, stockname_"+ LangType.Lang +" AS stockname from tbl_Stock\n" +
                    "order by StockName_l2";
            ResultSet rs = c.createStatement().executeQuery(sql);
            while(rs.next()){
                mapStock.put(rs.getString("stockname"), new Object[]{rs.getString("stockid"), rs.getString("stockname_l1"), rs.getString("stockname_l2")});
            }
            rs.close();
            return mapStock;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public HashMap<String, Object[]>hmapVendor(){
        try {
            HashMap<String, Object[]>hmVendor = new HashMap();
            sql= "Select venid, ven_l1, ven_l2, ven_"+ LangType.Lang +" AS venName from tbl_Vendor\n" +
                "where VendorUsing =1\n" +
                "order by ven_"+ LangType.Lang +"";
            ResultSet rs = c.createStatement().executeQuery(sql);
            while (rs.next()){
                hmVendor.put(rs.getString("ven_"+ LangType.Lang +""), new Object[]{rs.getString("venid"), rs.getString("ven_l1"), rs.getString("ven_l2")});
            }       
            rs.close();
            return hmVendor;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public void showTbl_Vendor(JTable table, DefaultTableModel model){
        try {
            RemoveTableCount.RemoveTable(table, model);
            sql = "Select itid, 'false' as chooser, barode, packBarcode, item_l1, item_l2, costprice, '0' As Qty from tbl_Item\n" +
                "where itemuse = 1\n" +
                "order by Barode";
            ResultSet rs = c.createStatement().executeQuery(sql);
            while(rs.next()){
                model.addRow(new Object[]{rs.getString("itid"), rs.getBoolean("chooser"), rs.getString("barode"), rs.getString("packbarcode"), rs.getString("Item_l1"), 
                rs.getString("item_l2"), rs.getFloat("costprice"), rs.getString("qty")});
            }
            table.setModel(model);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
