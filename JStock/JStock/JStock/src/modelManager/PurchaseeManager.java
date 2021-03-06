/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelManager;

import Data.Msg;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.sql.*;
import java.text.SimpleDateFormat;
import javax.swing.ActionMap;
import javax.swing.DefaultComboBoxModel;
import javax.swing.InputMap;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.KeyStroke;
import javax.swing.table.DefaultTableModel;
import model.Purchase;
import model.RemoveTableCount;
import sysConnect.module;
import views.FrmMain;
import views.FrmPurchaseOrderAddDetails;

/**
 *
 * @author Admin
 */
public class PurchaseeManager {

    Connection c = module.getConnection();
    String sql;
    Msg msg = new Msg();

    public HashMap<String, Object[]> hmapStock() {
        try {
            HashMap<String, Object[]> mapStock = new HashMap();
            sql = "Select stockid, stockname_l1, stockname_l2, stockname_" + LangType.Lang + " AS stockname from tbl_Stock\n"
                    + "order by StockName_l2";
            ResultSet rs = c.createStatement().executeQuery(sql);
            while (rs.next()) {
                mapStock.put(rs.getString("stockname"), new Object[]{rs.getString("stockid"), rs.getString("stockname_l1"), rs.getString("stockname_l2")});
            }
            rs.close();
            return mapStock;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public HashMap<String, Object[]> hmapVendor() {
        try {
            HashMap<String, Object[]> hmVendor = new HashMap();
            sql = "Select venid, ven_l1, ven_l2, ven_" + LangType.Lang + " AS venName from tbl_Vendor\n"
                    + "where VendorUsing =1\n"
                    + "order by ven_" + LangType.Lang + "";
            ResultSet rs = c.createStatement().executeQuery(sql);
            while (rs.next()) {
                hmVendor.put(rs.getString("ven_" + LangType.Lang + ""), new Object[]{rs.getString("venid"), rs.getString("ven_l1"), rs.getString("ven_l2")});
            }
            rs.close();
            return hmVendor;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public void showTbl_Items(JTable table, DefaultTableModel model) {
        try {
            RemoveTableCount.RemoveTable(table, model);
            sql = "Select itid, 'false' as chooser, barode, packBarcode, item_l1, item_l2, costprice, '' As Qty from tbl_Item\n"
                    + "where itemuse = 1\n"
                    + "order by Barode";
            ResultSet rs = c.createStatement().executeQuery(sql);
            while (rs.next()) {
                model.addRow(new Object[]{rs.getString("itid"), rs.getBoolean("chooser"), rs.getString("barode"), rs.getString("packbarcode"), rs.getString("Item_l1"),
                    rs.getString("item_l2"), rs.getFloat("costprice"), rs.getString("qty")});
            }
            table.setModel(model);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void showItemKey(String x, JTable table){
        try {  
            int indx = table.getSelectedRow();
            sql = "Select itid, 'false' as chooser, barode, packBarcode, item_l1, item_l2, costprice, '' As Qty from tbl_Item\n"
                    + "where itemuse = 1 and barode = N'"+ x +"' or item_l1 like N'"+ x +"%' or item_l2 like N'"+ x +"%'";
            ResultSet rs = c.createStatement().executeQuery(sql);
            while (rs.next()){
                table.setValueAt(rs.getString("itid"), indx, 0);
                table.setValueAt(true, indx, 1);
                table.setValueAt(rs.getString("barode"), indx, 2);
                table.setValueAt(rs.getString("packbarcode"), indx, 3);
                table.setValueAt(rs.getString("Item_L1"), indx, 4);
                table.setValueAt(rs.getString("item_L2"), indx, 5);
                table.setValueAt(rs.getDouble("costprice"), indx, 6);
                //table.setValueAt(1, indx, 7);
                table.requestFocus();                
            }
        } catch (Exception e) {
            //e.printStackTrace();
        }
    }
    
    public void showSearchTbl_Vendor(JTable table, DefaultTableModel model, String x) {
        try {
            RemoveTableCount.RemoveTable(table, model);
            sql = "Select itid, 'false' as chooser, barode, packBarcode, item_l1, item_l2, costprice, '' As Qty from tbl_Item\n"
                    + "where barode like N'%" + x + "%' or packBarcode like N'%" + x + "%' or item_l1 like N'%" + x + "%' "
                    + "or item_l2 like N'%" + x + "%' and itemuse = 1\n"
                    + "order by Barode";
            ResultSet rs = c.createStatement().executeQuery(sql);
            while (rs.next()) {
                model.addRow(new Object[]{rs.getString("itid"), rs.getBoolean("chooser"), rs.getString("barode"), rs.getString("packbarcode"), rs.getString("Item_l1"),
                    rs.getString("item_l2"), rs.getFloat("costprice"), rs.getString("qty")});
            }
            table.setModel(model);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Boolean insertActivity(Purchase pc) {
        try {
            sql = "Insert into tbl_activity (actid, actno, createdate, createuser, rec_type, checkmark) values "
                    + "(?,?,?,?,?,?)";
            PreparedStatement p = c.prepareStatement(sql);
            p.setInt(1, pc.getActid());
            p.setString(2, pc.getActNo());
            p.setDate(3, (Date) pc.getActivityCreateDate());
            p.setString(4, pc.getCreateUser());
            p.setString(5, pc.getActivityRec_type());
            p.setBoolean(6, pc.getCheckMark());
            p.executeUpdate();
            p.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public Boolean insertActivityDetails(Purchase pc) {
        try {
            sql = "insert into tbl_activityDetails (actdid, actid, itid, venid, barode, packbarcode, item_l1, item_l2, costprice, qty, activing, rec_type) values "
                    + "(?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement p = c.prepareStatement(sql);
            p.setInt(1, pc.getActdid());
            p.setInt(2, pc.getActid());
            p.setInt(3, pc.getItid());
            p.setInt(4, pc.getVenid());
            p.setString(5, pc.getBarcode());
            p.setString(6, pc.getPackbarcode());
            p.setString(7, pc.getItem_l1());
            p.setString(8, pc.getItem_l2());
            p.setFloat(9, pc.getCostprice());
            p.setFloat(10, pc.getQty());
            p.setBoolean(11, pc.getActiviing());
            p.setString(12, pc.getActivityRec_type());
            p.executeUpdate();
            p.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public Boolean deleteActivityDetail(String x){
        try {
            Statement st = null;
            st = c.createStatement();
            sql = "Delete act from tbl_activitydetails act\n" +
                "left join tbl_Activity ati on ati.ACTID = act.actid\n" +
                "where ati.ActNo = N'"+ x +"'";
            st.execute(sql);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public Boolean deleteActivity(String x){
        try {
            Statement st = null;
            st = c.createStatement();
            sql = "delete tbl_Activity \n" +
                    "where actno= '"+ x +"'";
            st.execute(sql);
            return true;
        } catch (Exception e) {
        }
        return false;
    }
    public void showTbl_Activity(JTable table, DefaultTableModel model) {
        try {
            RemoveTableCount.RemoveTable(table, model);
            sql = "select createdate, actno, products, qty, totalPrice, ven_" + LangType.Lang + " AS vendor, email, website, createUser from vw_PO\n"
                    + "order by createDate Desc";
            ResultSet rs = c.createStatement().executeQuery(sql);
            while (rs.next()) {
                model.addRow(new Object[]{rs.getString("createdate"), rs.getString("actno"), rs.getDouble("products"), rs.getDouble("qty"), rs.getDouble("totalPrice"),
                    rs.getString("vendor"), rs.getString("email"), rs.getString("website"), rs.getString("createUser")});
            }
            table.setModel(model);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void showTbl_ActivityActived(JTable table, DefaultTableModel model) {
        try {
            RemoveTableCount.RemoveTable(table, model);
            sql = "select createdate, actno, products, qty, totalPrice, ven_" + LangType.Lang + " AS vendor, email, website, createUser from Vw_POActived\n"
                    + "order by createDate Desc";
            ResultSet rs = c.createStatement().executeQuery(sql);
            while (rs.next()) {
                model.addRow(new Object[]{rs.getString("createdate"), rs.getString("actno"), rs.getDouble("products"), rs.getDouble("qty"), rs.getDouble("totalPrice"),
                    rs.getString("vendor"), rs.getString("email"), rs.getString("website"), rs.getString("createUser")});
            }
            table.setModel(model);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void searchTbl_ActivityActived(JTable table, DefaultTableModel model, String x){
        try {
            RemoveTableCount.RemoveTable(table, model);
            sql = "select createdate, actno, products, qty, totalPrice, ven_" + LangType.Lang + " AS vendor, email, website, createUser from Vw_POActived "
                    + "where createDate like N'"+ x +"%' or actno like N'"+ x +"%' or ven_"+ LangType.Lang +" like N'"+ x +"%' "
                    + "or email like N'"+ x +"%' or website like N'"+ x +"%' or createUser like N'"+ x +"%' \n"
                    + "order by createDate Desc";
            ResultSet rs = c.createStatement().executeQuery(sql);
            while (rs.next()) {
                model.addRow(new Object[]{rs.getString("createdate"), rs.getString("actno"), rs.getDouble("products"), rs.getDouble("qty"), rs.getDouble("totalPrice"),
                    rs.getString("vendor"), rs.getString("email"), rs.getString("website"), rs.getString("createUser")});
            }
            table.setModel(model);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void showSearchTbl_Activity(JTable table, DefaultTableModel model, String x) {
        try {
            RemoveTableCount.RemoveTable(table, model);
            sql = "select createdate, actno, products, qty, totalPrice, ven_" + LangType.Lang + " AS vendor, email, website, createUser from vw_PO\n"
                    + "where Createdate like N'%" + x + "%' or actno like N'%" + x + "%' or email like N'%" + x + "%' or website like N'%" + x + "%' "
                    + "or createuser like N'%" + x + "%' or ven_" + LangType.Lang + " like N'%" + x + "%' order by createDate";
            ResultSet rs = c.createStatement().executeQuery(sql);
            while (rs.next()) {
                model.addRow(new Object[]{rs.getString("createdate"), rs.getString("actno"), rs.getDouble("products"), rs.getDouble("qty"), rs.getDouble("totalPrice"),
                    rs.getString("vendor"), rs.getString("email"), rs.getString("website"), rs.getString("createUser")});
            }
            table.setModel(model);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void showFrmPurchaseOrderAddDetails(JTable table, DefaultTableModel model, String x) {
        try {
            RemoveTableCount.RemoveTable(table, model);
            sql = "Select actdid, barode, packBarcode, item_" + LangType.Lang + " as items, qty, costprice, totalMoney \n"
                    + "from vw_PODetails \n"
                    + "where ActNo = N'" + x + "'\n"
                    + "order by item_" + LangType.Lang + "";
            ResultSet rs = c.createStatement().executeQuery(sql);
            while (rs.next()) {
                model.addRow(new Object[]{rs.getString("actdid"), rs.getString("barode"), rs.getString("packbarcode"), rs.getString("items"), rs.getDouble("qty"),
                    rs.getDouble("costprice"), rs.getDouble("totalMoney")});
            }
            table.setModel(model);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void showCountFrmPurchaseOrderAddDetails(String x) {
        try {
            sql = "Select count(barode) as countbarcode from vw_PODetails where ActNo = N'" + x + "'";
            ResultSet rs = c.createStatement().executeQuery(sql);
            if (rs.next()) {
                FrmPurchaseOrderAddDetails.lblCountTotal.setText(rs.getString("countbarcode"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public Boolean updateActiviting(Purchase pc) {
        try {
            sql = "update act set act.Activing = 0\n"
                    + "from tbl_ActivityDetails act \n"
                    + "left join tbl_Activity a on a.ACTID = act.actid\n"
                    + "where a.ActNo = (?)";
            PreparedStatement p = c.prepareStatement(sql);
            p.setString(1, pc.getActNo());
            p.executeUpdate();
            p.executeUpdate();
            p.close();
            msg.showMsgSucess();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    } 
    public Boolean voidTbl_ActivityDetails(String x, Purchase pc){
        try {
            sql = "update atc set atc.activing = 0, atc.void = 1, atc.voidDate = ?, atc.voidbyUser = ? \n" +
                    "from tbl_activitydetails atc\n" +
                    "left join tbl_activity act on act.actid = atc.actid\n" +
                    "where act.actno = '"+ x +"'";
            PreparedStatement p = c.prepareStatement(sql);
            p.setDate(1, (Date) pc.getActivityCreateDate());
            p.setString(2, pc.getCreateUser());
            p.executeUpdate();
            p.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
}
