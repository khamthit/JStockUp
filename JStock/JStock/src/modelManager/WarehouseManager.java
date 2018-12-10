/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelManager;
import java.sql.*;
import java.text.SimpleDateFormat;
import model.Warehouse;
import sysConnect.module;
import Data.Msg;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.RemoveTableCount;
import views.FrmWareHouse;

public class WarehouseManager {
    Connection c = module.getConnection();    
    String sqls;
    
    
    public Boolean insertTbl_warehouse(Warehouse wh){
        try {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            java.util.Date dt = new java.util.Date();    
            String xx = df.format(dt);
            String sql = "Insert into tbl_stock (Stockid, stockname_l1, stockname_l2, mobile1, mobile2, fax, stock_address, createdate, createby) values "
                    + "(?,?,?,?,?,?,?,?,?)";
            PreparedStatement p = c.prepareStatement(sql);
            p.setInt(1, wh.getStockid());
            p.setString(2, wh.getStocknameL1());
            p.setString(3, wh.getStocknameL2());
            p.setString(4, wh.getMobile1());
            p.setString(5, wh.getMobile2());
            p.setString(6, wh.getFax());
            p.setString(7, wh.getStockAddress());
            p.setString(8, xx);
            p.setString(9, wh.getCreateBy());
            p.executeUpdate();
            Msg m = new Msg();
            m.showMsgSucess();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public void showFrmWarehouseData(JTable table, DefaultTableModel model){
        try {
            RemoveTableCount.RemoveTable(table, model);
            sqls = "Select stockid, stockName_"+ LangType.Lang +" AS names, mobile1, mobile2, fax, Stock_address from tbl_stock\n" +
                    "order by stockName_"+ LangType.Lang +"";
            ResultSet rs = c.createStatement().executeQuery(sqls);
            while (rs.next()){
                model.addRow(new Object[]{rs.getString("stockid"), rs.getString("names"), rs.getString("mobile1"), rs.getString("mobile2"), rs.getString("fax"),rs.getString("stock_address")});
            }
            table.setModel(model);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void showFrmWarehouseDataSearch(JTable table, DefaultTableModel model, String x){
        try {
            RemoveTableCount.RemoveTable(table, model);
            sqls = "Select stockid, stockName_"+ LangType.Lang +" AS names, mobile1, mobile2, fax, Stock_address from tbl_stock "
                    + "where stockName_"+LangType.Lang+" like N'"+ x +"%' or mobile1 like N'"+ x +"%' or mobile2 like N'"+ x +"%' or fax like N'"+ x +"%' or Stock_address like N'"+ x +"%' "
                    + "order by stockName_"+ LangType.Lang +"";
            ResultSet rs = c.createStatement().executeQuery(sqls);
            while (rs.next()){
                model.addRow(new Object[]{rs.getString("stockid"), rs.getString("names"), rs.getString("mobile1"), rs.getString("mobile2"), rs.getString("fax"),rs.getString("stock_address")});
            }
            table.setModel(model);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void showOnclick(Warehouse wh){
        try {            
            sqls = "Select * from tbl_stock where StockID = "+ wh.getStockid() +"";
            ResultSet rs = c.createStatement().executeQuery(sqls);
            if (rs.next()){
                wh.setStocknameL1(rs.getString("StockName_L1"));
                wh.setStocknameL2(rs.getString("StockName_L2"));
                wh.setMobile1(rs.getString("Mobile1"));
                wh.setMobile2(rs.getString("Mobile2"));
                wh.setFax(rs.getString("Fax"));
                wh.setStockAddress(rs.getString("stock_address"));                                
            }            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public Boolean updateTableStock(Warehouse w){
        try {
            sqls="Update tbl_Stock set StockName_L1 = ?, StockName_L2 = ?, Mobile1=?, Mobile2 = ?, Fax = ?, Stock_address = ? where StockID = (?)";
            PreparedStatement p = c.prepareStatement(sqls);
            p.setString(1, w.getStocknameL1());
            p.setString(2, w.getStocknameL2());
            p.setString(3, w.getMobile1());
            p.setString(4, w.getMobile2());
            p.setString(5, w.getFax());
            p.setString(6, w.getStockAddress());
            p.setInt(7, w.getStockid());
            p.executeUpdate();
            p.close();
            Msg m = new Msg();
            m.showMsgSucess();            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
