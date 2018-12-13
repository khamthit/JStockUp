/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelManager;
import Data.Msg;
import sysConnect.module;
import java.sql.*;
import java.util.HashMap;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Pack;
import model.RemoveTableCount;
import model.TableHeader;

public class PackManager {
    Connection c = module.getConnection();
    String sql;
    Msg msg = new Msg();
    public Boolean insertTbl_Pack(Pack pa){
        try {
            sql = "Select PackNo from tbl_Pack where PackNo = N'"+ pa.getPackNo() +"' and ZoneID = '"+ pa.getZoneid() +"'";
            ResultSet rs = c.createStatement().executeQuery(sql);
            if (rs.next()){
                msg.showMsgSameData();
            }else{
                sql = "Insert into tbl_pack (PackID, PackNo, PackData, Used, Zoneid, PackFree) values (?,?,?,?,?,?)";
                PreparedStatement p = c.prepareStatement(sql);
                p.setInt(1, pa.getPackID());
                p.setString(2, pa.getPackNo());
                p.setString(3, pa.getPackName());
                p.setBoolean(4, pa.getUsed());
                p.setInt(5, pa.getZoneid());
                p.setBoolean(6, false);
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
    public HashMap<String, Object[]>getMapZone(){
        try {
            HashMap<String, Object[]>map= new HashMap();
            sql = "Select zoneid, zoneNo from tbl_Zone order by ZoneID";
            ResultSet rs = c.createStatement().executeQuery(sql);
            while (rs.next()){
                map.put(rs.getString("ZoneNo"), new Object[]{rs.getString("zoneid"), rs.getString("zoneno"), rs.getString("zoneid")});
            }
            rs.close();
            return map;            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }    
    public void showPack(JTable table, DefaultTableModel model){
        try {
            TableHeader.RemoveTable(table, model);
            sql = "Select p.packID, p.zoneid, z.zoneNo, p.packNo, p.used, p.PackData from tbl_pack p\n" +
                    "left join tbl_Zone z on z.ZoneID = p.zoneid\n" +
                    "where p.Used = 1\n" +
                    "order by z.ZoneNo, p.PackNo";
            ResultSet rs = c.createStatement().executeQuery(sql);
            while (rs.next()){
                model.addRow(new Object[]{rs.getString("packid"), rs.getString("zoneid"), rs.getString("zoneNo"), rs.getString("packNo"), rs.getBoolean("used"), rs.getString("packData")});
            }
            table.setModel(model);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void showSearchPack(JTable table, DefaultTableModel model, String x){
        try {
            TableHeader.RemoveTable(table, model);
            sql = "Select p.packID, p.zoneid, z.zoneNo, p.packNo, p.used, p.PackData from tbl_pack p\n" +
                    "left join tbl_Zone z on z.ZoneID = p.zoneid\n" +
                    "where z.zoneNo like N'"+ x +"%' or p.packNo like N'"+ x +"%' or p.packData like N'"+ x +"%'\n" +
                    "order by z.ZoneNo, p.PackNo";
            ResultSet rs = c.createStatement().executeQuery(sql);
            while (rs.next()){
                 model.addRow(new Object[]{rs.getString("packid"), rs.getString("zoneid"), rs.getString("zoneNo"), rs.getString("packNo"), rs.getBoolean("used"), rs.getString("packData")});
            }
            table.setModel(model);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public Boolean updateTbl_Pack(Pack pa){
        try {
            sql = "Update tbl_pack set PackNo = ?, PackData = ?, Used = ?, ZoneID = ? where PackID = (?)";
            PreparedStatement p= c.prepareStatement(sql);
            p.setString(1, pa.getPackNo());
            p.setString(2, pa.getPackName());
            p.setBoolean(3, pa.getUsed());
            p.setInt(4, pa.getZoneid());
            p.setInt(5, pa.getPackID());
            p.executeUpdate();
            p.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public Boolean deleteTbl_Pack (Pack pa){
        try {
            Statement st = null;
            st = c.createStatement();
            sql = "Delete from tbl_Pack where packID = "+ pa.getPackID() +"";
            st.executeUpdate(sql);
            
        } catch (Exception e) {
            
        }
        return false;
    }
    
}
