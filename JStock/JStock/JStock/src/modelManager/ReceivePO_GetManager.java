/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelManager;
import java.sql.*;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
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
}
