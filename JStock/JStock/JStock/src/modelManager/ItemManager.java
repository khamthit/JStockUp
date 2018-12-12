/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelManager;

import java.sql.*;
import java.util.HashMap;
import sysConnect.module;

public class ItemManager {
    Connection c = module.getConnection();
    String sql;
    public HashMap<String, Object[]>hmapGroup(){
        try {
            HashMap<String, Object[]>mapGroup=new HashMap();
            sql = "Select pgid, groupname_L1, groupName_l2 from tbl_ProGroup order by GroupName_"+ LangType.Lang +"";
            ResultSet rs = c.createStatement().executeQuery(sql);
            while (rs.next()){
                mapGroup.put(rs.getString("groupname_"+ LangType.Lang +""), new Object[]{rs.getString("pgid"), rs.getString("groupname_l1"), rs.getString("groupName_L2")});
            }
            rs.close();
            return mapGroup;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public HashMap<String, Object[]>hmapCategory(){
        try {
            HashMap<String, Object[]>mapCate = new HashMap();
            sql = "Select pctid, cate_l1, cate_l2 from tbl_ProCategory order by Cate_"+ LangType.Lang +"";
            ResultSet rs = c.createStatement().executeQuery(sql);
            while(rs.next()){
                mapCate.put(rs.getString("cate_"+ LangType.Lang +""), new Object[]{rs.getString("pctid"), rs.getString("cate_L1"), rs.getString("cate_l2")});
            }
            rs.close();
            return mapCate;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public HashMap<String, Object[]>hmapUnit(){
        try {
            HashMap<String, Object[]>mapUnit = new HashMap();
            sql = "Select puid, unit_l1, unit_l2 from tbl_ProUnit order by unit_"+ LangType.Lang +"";
            ResultSet rs = c.createStatement().executeQuery(sql);
            while(rs.next()){
                mapUnit.put(rs.getString("unit_"+ LangType.Lang +""), new Object[]{rs.getString("puid"), rs.getString("unit_l1"), rs.getString("unit_l2")});
            }
            rs.close();
            return mapUnit;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public HashMap<String, Object[]>hmapSize(){
        try {
            HashMap<String, Object[]>mapSize = new HashMap();
            sql = "Select psizeid, sizename, sizedescriptions from tbl_ProSize order by sizename";
            ResultSet rs = c.createStatement().executeQuery(sql);
            while (rs.next()){
                mapSize.put(rs.getString("sizename"), new Object[]{rs.getString("psizeid"), rs.getString("sizename"), rs.getString("sizedescriptions")});
            }
            rs.close();
            return mapSize;
        } catch (Exception e) {
        }
        return null;
    }
    public HashMap<String, Object[]>hmapZone(){
        try {
            HashMap<String, Object[]>mapZone = new HashMap();
            sql = "Select zoneid, zoneno from tbl_Zone order by ZoneNo";
            ResultSet rs = c.createStatement().executeQuery(sql);
            while (rs.next()){
                mapZone.put(rs.getString("zoneNo"), new Object[]{rs.getString("zoneid"), rs.getString("zoneno"), rs.getString("zoneno")});
            }
            rs.close();
            return mapZone;
        } catch (Exception e) {
        }
        return null;
    }
    public HashMap<String, Object[]>hmapPack(){
        try {
            HashMap<String, Object[]>hmPack = new HashMap();
            sql = "Select packid, packNo from tbl_Pack where PackFree = 0 order by PackNo";
            ResultSet rs = c.createStatement().executeQuery(sql);
            while (rs.next()){
                hmPack.put(rs.getString("PackNo"), new Object[]{rs.getString("PackID"), rs.getString("packNo"), rs.getString("PackNo")});
            }
            rs.close();
            return hmPack;
        } catch (Exception e) {
        }
        return null;
    }
    public HashMap<String, Object[]>hmapPick(){
        try {
            HashMap<String, Object[]>hmPick = new HashMap();
            sql = "Select pickid, pickNo from tbl_Pick where pickFree = 0 order by PickNo";
            ResultSet rs = c.createStatement().executeQuery(sql);
            while (rs.next()){
                hmPick.put(rs.getString("pickNo"), new Object[]{rs.getString("pickid"), rs.getString("pickNo"), rs.getString("pickNo")});
            }
            rs.close();
            return hmPick;
        } catch (Exception e) {
        }
        return null;
    }
}
