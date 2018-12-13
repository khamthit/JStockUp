/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelManager;
import java.sql.*;
import java.util.HashMap;
import java.util.TreeMap;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Pick;
import model.RemoveTableCount;
import model.TableHeader;
import sysConnect.module;
import views.FrmPick;

public class PickManager {
    Connection c = module.getConnection();
    String sql;
    public static String xZone="";
    
    public HashMap<String, Object[]>hmapZone(){
        try {
            HashMap<String, Object[]>mapZone = new HashMap();
            sql = "Select zoneid, zoneno from tbl_zone order by ZoneNo";
            ResultSet rs = c.createStatement().executeQuery(sql);
            while (rs.next()){
                mapZone.put(rs.getString("zoneno"), new Object[]{rs.getString("zoneid"), rs.getString("zoneno"), rs.getString("zoneno")});
            }
            rs.close();
            return mapZone;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public HashMap<String, Object[]>hmapPack(){
        try {
            HashMap<String, Object[]>mapPack = new HashMap();
            sql = "Select p.packid, p.packno from tbl_pack p\n" +
                    "left join tbl_Zone z on z.ZoneID = p.ZoneID\n" +
                    "order by z.zoneid, p.packNo";
            ResultSet rs = c.createStatement().executeQuery(sql);
            while (rs.next()){
                mapPack.put(rs.getString("PackNo"), new Object[]{rs.getString("PackID"), rs.getString("packno"), rs.getString("packNo")});
            }
            rs.close();
            return mapPack;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }    
    public Boolean insertTbl_Pick(Pick pi){
        try {
            sql = "Insert into tbl_pick (pickid, pickno, pickdata, packid, zoneid, used, pickFree) values (?,?,?,?,?,?,?)";
            PreparedStatement p = c.prepareStatement(sql);
            p.setInt(1, pi.getPickid());
            p.setString(2, pi.getPickNo());
            p.setString(3, pi.getPickData());
            p.setInt(4, pi.getPackID());
            p.setInt(5, pi.getZoneid());
            p.setBoolean(6, pi.getUsed());
            p.setBoolean(7, false);
            p.executeUpdate();
            p.close();
            return true;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public void showTbl_Pick(JTable table, DefaultTableModel model){
        try {
            TableHeader.RemoveTable(table, model);
            sql = "exec pd_Pick";
            ResultSet rs = c.createStatement().executeQuery(sql);
            while (rs.next()){
                model.addRow(new Object[]{rs.getString("pickid"), rs.getString("packid"), rs.getString("zoneid"), rs.getString("pickNo"), 
                rs.getString("packNo"), rs.getString("zoneno"), rs.getString("pickData"), rs.getBoolean("used")});
            }
            table.setModel(model);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public Boolean updateTbl_Pick(Pick pi){
        try {
            sql = "Update tbl_pick set PickNo = ?, PickData = ?, PackID = ?, ZoneID = ?, Used = ? where PickID = (?)";
            PreparedStatement p = c.prepareStatement(sql);
            p.setString(1, pi.getPickNo());
            p.setString(2, pi.getPickData());
            p.setInt(3, pi.getPackID());
            p.setInt(4, pi.getZoneid());
            p.setBoolean(5, pi.getUsed());
            p.setInt(6, pi.getPickid());
            p.executeUpdate();
            p.close();
            return true;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public void showSearch(JTable table, DefaultTableModel model , String x){
        try {
            RemoveTableCount.RemoveTable(table, model);
            sql = "Select pik.pickid, pik.packid, z.zoneid, pik.pickNo, pak.packNo, z.zoneno, pik.pickData, pik.Used \n" +
                    "from tbl_Pick pik \n" +
                    "left join tbl_Pack pak on pak.PackID = pik.PackID\n" +
                    "left join tbl_Zone z on z.ZoneID = pik.ZoneID\n" +
                    "where pik.pickNo like N'"+ x +"%' or pak.packNo like N'"+ x +"%' or z.zoneno like N'"+ x +"%' or pik.pickData like N'"+ x +"%' and pik.Used = 1\n" +
                    "order by z.ZoneNo, pak.PackNo, pik.PickNo";
            ResultSet rs = c.createStatement().executeQuery(sql);
            while (rs.next()){
                model.addRow(new Object[]{rs.getString("pickid"), rs.getString("packid"), rs.getString("zoneid"), rs.getString("pickNo"), rs.getString("packNo"), rs.getString("zoneNo"), rs.getString("pickData"), rs.getBoolean("used")});
            }
            table.setModel(model);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }    
}
