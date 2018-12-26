/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelManager;

/**
 *
 * @author Admin
 */
import java.sql.*;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.RemoveTableCount;
import sysConnect.module;

public class ReceiveManager {

    Connection c = module.getConnection();
    String sql;

    public void showReceive(JTable table, DefaultTableModel model) {
        try {
            RemoveTableCount.RemoveTable(table, model);
            sql = "Select ac.actNo, v.ven_" + LangType.Lang + " AS vendorname, v.phone1, v.phone2, v.fax, v.email, "
                    + "format(ac.CreateDate, 'dd-MM-yyyy') As createdate, ac.CreateUser\n"
                    + "from tbl_activitydetails act\n"
                    + "left join tbl_Activity ac on ac.ACTID = act.actid\n"
                    + "left join tbl_Vendor v on v.venid = act.venid\n"
                    + "left join tbl_Item i on i.ITID = act.itid\n"
                    + "where act.Rec_type = 'PO' and Receive_activity is null\n"
                    + "group by ac.actNo, ac.CreateDate, ac.CreateUser, act.rec_type, act.receive_activity, v.ven_l1, v.phone1, v.phone2, v.fax, v.email\n"
                    + "order by ac.CreateDate desc, actNo desc";
            ResultSet rs = c.createStatement().executeQuery(sql);
            while (rs.next()){
                model.addRow(new Object[]{rs.getString("actNo"), rs.getString("vendorname"), rs.getString("phone1"), rs.getString("phone2"), rs.getString("fax"),
                rs.getString("email"), rs.getString("createdate"), rs.getString("createuser")});
            }
            table.setModel(model);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void showSearchReceive(JTable table, DefaultTableModel model, String x){
        try {
            RemoveTableCount.RemoveTable(table, model);
            sql = "Select ac.actNo, v.ven_" + LangType.Lang + " AS vendorname, v.phone1, v.phone2, v.fax, v.email, "
                    + "format(ac.CreateDate, 'dd-MM-yyyy') As createdate, ac.CreateUser\n"
                    + "from tbl_activitydetails act\n"
                    + "left join tbl_Activity ac on ac.ACTID = act.actid\n"
                    + "left join tbl_Vendor v on v.venid = act.venid\n"
                    + "left join tbl_Item i on i.ITID = act.itid\n"
                    + "where ac.actNo like N'"+ x +"%' or v.ven_" + LangType.Lang + " like N'%"+ x +"%' or v.phone1 like N'%"+ x +"%' or v.phone2 like N'%"+ x +"%' or v.fax like N'%"+ x +"%' or v.email like N'%"+ x +"%' and act.Rec_type = 'PO' and Receive_activity is null\n"
                    + "group by ac.actNo, ac.CreateDate, ac.CreateUser, act.rec_type, act.receive_activity, v.ven_l1, v.phone1, v.phone2, v.fax, v.email\n"
                    + "order by ac.CreateDate desc, actNo desc";
            ResultSet rs = c.createStatement().executeQuery(sql);
            while (rs.next()){
                model.addRow(new Object[]{rs.getString("actNo"), rs.getString("vendorname"), rs.getString("phone1"), rs.getString("phone2"), rs.getString("fax"),
                rs.getString("email"), rs.getString("createdate"), rs.getString("createuser")});
            }
            table.setModel(model);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
