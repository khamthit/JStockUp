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
import model.ProGroup;
import model.RemoveTableCount;

public class ProGroupManager {

    Connection c = module.getConnection();
    String sql;
    Msg msg = new Msg();
    public Boolean insertTbl_ProGroup(ProGroup pg) {
        try {
            sql = "Select GroupName_L1, GroupName_L2 from tbl_ProGroup where GroupName_l1 = N'" + pg.getGroupName_L1() + "' or GroupName_L2 = N'" + pg.getGroupName_L2() + "'";
            ResultSet rs = c.createStatement().executeQuery(sql);
            if (rs.next()) {
                msg.showMsgSameData();
            } else {
                sql = "Insert into tbl_ProGroup (PGID, GroupName_L1, GroupName_L2, Group_Descriptions) values (?,?,?,?)";
                PreparedStatement p = c.prepareStatement(sql);
                p.setInt(1, pg.getGroupID());
                p.setString(2, pg.getGroupName_L1());
                p.setString(3, pg.getGroupName_L2());
                p.setString(4, pg.getGroupDescriptions());
                p.executeUpdate();
                p.close();
                msg.showMsgSucess();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public void showTbl_ProGroup(JTable table, DefaultTableModel model){
        try {
            RemoveTableCount.RemoveTable(table, model);
            sql = "exec pd_ProGroup";
            ResultSet rs = c.createStatement().executeQuery(sql);
            while (rs.next()){
                model.addRow(new Object[]{rs.getString("pgid"), rs.getString("groupname_l1"), rs.getString("groupname_l2"), rs.getString("group_Descriptions")});
            }
            table.setModel(model);
        } catch (Exception e) {
        }
    }
}
