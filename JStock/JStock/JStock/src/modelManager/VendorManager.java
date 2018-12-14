/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelManager;

import Data.ConvertDateSQL;
import Data.Msg;
import java.sql.*;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.RemoveTableCount;
import model.Vendor;
import sysConnect.module;

public class VendorManager {

    Connection c = module.getConnection();
    String sql;
    Msg msg = new Msg();

    public Boolean insertTbl_Vendor(Vendor v) {
        try {
            sql = "Select ven_L1, ven_L2 from tbl_vendor where Ven_L1 = N'" + v.getVen_l1().trim() + "' and Ven_L2 = N'" + v.getVen_l2().trim() + "'";
            ResultSet rs = c.createStatement().executeQuery(sql);
            if (rs.next()) {
                msg.showMsgSameData();
            } else {
                sql = "insert into tbl_vendor (venid, ven_l1, ven_l2, phone1, phone2, fax, email, website, BankName, BankAccount, VendorStart, VendorInfo, CreateDate, CreatebyUser, PostalCode, VendorUsing) "
                        + "Values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                PreparedStatement p = c.prepareStatement(sql);
                p.setInt(1, v.getVenid());
                p.setString(2, v.getVen_l1().trim());
                p.setString(3, v.getVen_l2().trim());
                p.setString(4, v.getPhone1());
                p.setString(5, v.getPhone2());
                p.setString(6, v.getFax());
                p.setString(7, v.getEmail());
                p.setString(8, v.getWebsite());
                p.setString(9, v.getBankname());
                p.setString(10, v.getBankAccount().trim());
                p.setDate(11, ConvertDateSQL.convertUtilDateToSqlDate(v.getVendorStart()));
                p.setString(12, v.getVendorInfo().trim());
                p.setDate(13, ConvertDateSQL.convertUtilDateToSqlDate(v.getCreatedate()));
                p.setString(14, v.getCreateUser());
                p.setString(15, v.getPostalCode().trim());
                p.setBoolean(16, v.getVendorUsing());
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

    public void showTbl_Vendor(JTable table, DefaultTableModel model) {
        try {
            RemoveTableCount.RemoveTable(table, model);
            sql = "select venid, vendorusing, ven_l1, ven_l2, phone1, phone2, fax, email, website, postalCode, bankname, bankAccount, format(vendorStart, 'dd-MM-yyyy') AS vendorStart, vendorInfo \n"
                    + "from tbl_Vendor\n"
                    + "where VendorUsing = 1\n"
                    + "order by ven_l2";
            ResultSet rs = c.createStatement().executeQuery(sql);
            while (rs.next()) {
                model.addRow(new Object[]{rs.getString("venid"), rs.getBoolean("vendorusing"), rs.getString("ven_l1"), rs.getString("ven_l2"), rs.getString("phone1"), rs.getString("phone2"), rs.getString("fax"), rs.getString("email"), rs.getString("website"), rs.getString("postalCode"), rs.getString("BankName"), rs.getString("bankAccount"), rs.getString("vendorStart"), rs.getString("vendorInfo")});
            }
            table.setModel(model);
        } catch (Exception e) {
        }
    }

    public void showSearchTbl_Vendor(JTable table, DefaultTableModel model, String x) {
        try {
            RemoveTableCount.RemoveTable(table, model);
            sql = "select venid, vendorusing, ven_l1, ven_l2, phone1, phone2, fax, email, website, postalCode, bankname, bankAccount, format(vendorStart, 'dd-MM-yyyy') AS vendorStart, vendorInfo \n"
                    + "from tbl_Vendor\n"
                    + "where ven_l1 like N'%" + x + "%' or ven_l2 like N'%" + x + "%' or phone1 like N'%" + x + "%' or phone2 like N'%" + x + "%' or fax like N'%" + x + "%' or email like N'%" + x + "%' or website like N'%" + x + "%' or postalcode like N'%" + x + "%' or bankname like N'%" + x + "%' or bankAccount  like N'%" + x + "%' or vendorinfo like N'%" + x + "%' \n"
                    + "order by ven_l1";
            ResultSet rs = c.createStatement().executeQuery(sql);
            while (rs.next()) {
                model.addRow(new Object[]{rs.getString("venid"), rs.getBoolean("vendorusing"), rs.getString("ven_l1"), rs.getString("ven_l2"), rs.getString("phone1"), rs.getString("phone2"), rs.getString("fax"), rs.getString("email"), rs.getString("website"), rs.getString("postalCode"), rs.getString("BankName"), rs.getString("bankAccount"), rs.getString("vendorStart"), rs.getString("vendorInfo")});
            }
            table.setModel(model);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
