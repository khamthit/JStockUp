/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelManager;

import Data.Msg;
import java.io.File;
import java.io.FileInputStream;
import java.sql.*;
import java.util.HashMap;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Item;
import model.RemoveTableCount;
import sysConnect.module;
import views.FrmItemAdd;

public class ItemManager {

    Connection c = module.getConnection();
    String sql;
    Msg msg = new Msg();

    public HashMap<String, Object[]> hmapGroup() {
        try {
            HashMap<String, Object[]> mapGroup = new HashMap();
            sql = "Select pgid, groupname_L1, groupName_l2 from tbl_ProGroup order by GroupName_" + LangType.Lang + "";
            ResultSet rs = c.createStatement().executeQuery(sql);
            while (rs.next()) {
                mapGroup.put(rs.getString("groupname_" + LangType.Lang + ""), new Object[]{rs.getString("pgid"), rs.getString("groupname_l1"), rs.getString("groupName_L2")});
            }
            rs.close();
            return mapGroup;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public HashMap<String, Object[]> hmapCategory() {
        try {
            HashMap<String, Object[]> mapCate = new HashMap();
            sql = "Select pctid, cate_l1, cate_l2 from tbl_ProCategory order by Cate_" + LangType.Lang + "";
            ResultSet rs = c.createStatement().executeQuery(sql);
            while (rs.next()) {
                mapCate.put(rs.getString("cate_" + LangType.Lang + ""), new Object[]{rs.getString("pctid"), rs.getString("cate_L1"), rs.getString("cate_l2")});
            }
            rs.close();
            return mapCate;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public HashMap<String, Object[]> hmapUnit() {
        try {
            HashMap<String, Object[]> mapUnit = new HashMap();
            sql = "Select puid, unit_l1, unit_l2 from tbl_ProUnit order by unit_" + LangType.Lang + "";
            ResultSet rs = c.createStatement().executeQuery(sql);
            while (rs.next()) {
                mapUnit.put(rs.getString("unit_" + LangType.Lang + ""), new Object[]{rs.getString("puid"), rs.getString("unit_l1"), rs.getString("unit_l2")});
            }
            rs.close();
            return mapUnit;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public HashMap<String, Object[]> hmapSize() {
        try {
            HashMap<String, Object[]> mapSize = new HashMap();
            sql = "Select psizeid, sizename, sizedescriptions from tbl_ProSize order by sizename";
            ResultSet rs = c.createStatement().executeQuery(sql);
            while (rs.next()) {
                mapSize.put(rs.getString("sizename"), new Object[]{rs.getString("psizeid"), rs.getString("sizename"), rs.getString("sizedescriptions")});
            }
            rs.close();
            return mapSize;
        } catch (Exception e) {
        }
        return null;
    }
    public HashMap<String, Object[]> hmapZone() {
        try {
            HashMap<String, Object[]> mapZone = new HashMap();
            sql = "Select zoneid, zoneno from tbl_Zone order by ZoneNo";
            ResultSet rs = c.createStatement().executeQuery(sql);
            while (rs.next()) {
                mapZone.put(rs.getString("zoneNo"), new Object[]{rs.getString("zoneid"), rs.getString("zoneno"), rs.getString("zoneno")});
            }
            rs.close();
            return mapZone;
        } catch (Exception e) {
        }
        return null;
    }
    public HashMap<String, Object[]> hmapPack() {
        try {
            HashMap<String, Object[]> hmPack = new HashMap();
            sql = "Select packid, packNo from tbl_Pack where PackFree = 0 order by PackNo";
            ResultSet rs = c.createStatement().executeQuery(sql);
            while (rs.next()) {
                hmPack.put(rs.getString("PackNo"), new Object[]{rs.getString("PackID"), rs.getString("packNo"), rs.getString("PackNo")});
            }
            rs.close();
            return hmPack;
        } catch (Exception e) {
        }
        return null;
    }
    public HashMap<String, Object[]> hmapPick() {
        try {
            HashMap<String, Object[]> hmPick = new HashMap();
            sql = "Select pickid, pickNo from tbl_Pick where pickFree = 0 order by PickNo";
            ResultSet rs = c.createStatement().executeQuery(sql);
            while (rs.next()) {
                hmPick.put(rs.getString("pickNo"), new Object[]{rs.getString("pickid"), rs.getString("pickNo"), rs.getString("pickNo")});
            }
            rs.close();
            return hmPick;
        } catch (Exception e) {
        }
        return null;
    }
    public Boolean insertTbl_ITemNoImage(Item it) {
        try {
            sql = "Select barode from tbl_Item where Barode = N'"+ it.getBarode().trim() +"'";
            ResultSet rs = c.createStatement().executeQuery(sql);
            if (rs.next()){
                msg.showMsgSameData();
            }else{
                sql = "insert into tbl_Item (ITID, Barode, PackBarcode, item_l1, item_l2, zoneid, packid, pickid, psizeid, puid, pctid, pgid, costprice, SalePrice, iteminfo, Itemuse, Createdate, Createuser) "
                        + "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                PreparedStatement p = c.prepareStatement(sql);
                p.setInt(1, it.getITID());
                p.setString(2, it.getBarode());
                p.setString(3, it.getPackBarcode());
                p.setString(4, it.getItem_L1());
                p.setString(5, it.getItem_L2());
                p.setInt(6, it.getZoneid());
                p.setInt(7, it.getPackid());
                p.setInt(8, it.getPickid());
                p.setInt(9, it.getPsizeid());
                p.setInt(10, it.getPuid());
                p.setInt(11, it.getPctid());
                p.setInt(12, it.getPgid());
                p.setFloat(13, it.getCostPrice());
                p.setFloat(14, it.getSalePrice());
                p.setString(15, it.getIteminfo());
                p.setBoolean(16, it.getItemuse());
                p.setDate(17, (Date) it.getCrateDate());
                p.setString(18, it.getCreateUser());
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
    public Boolean InsertTbl_ItemImage(Item it) {
        try {
            sql = "Select barode from tbl_Item where Barode = N'"+ it.getBarode().trim() +"'";
            ResultSet rs = c.createStatement().executeQuery(sql);
            if (rs.next()){
                msg.showMsgSameData();
            }else{
                sql = "insert into tbl_Item (ITID, Barode, PackBarcode, item_l1, item_l2, zoneid, packid, pickid, psizeid, puid, pctid, pgid, costprice, SalePrice, iteminfo, Itemuse, Createdate, Createuser, Item_img) "
                        + "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                PreparedStatement p = c.prepareStatement(sql);
                p.setInt(1, it.getITID());
                p.setString(2, it.getBarode());
                p.setString(3, it.getPackBarcode());
                p.setString(4, it.getItem_L1());
                p.setString(5, it.getItem_L2());
                p.setInt(6, it.getZoneid());
                p.setInt(7, it.getPackid());
                p.setInt(8, it.getPickid());
                p.setInt(9, it.getPsizeid());
                p.setInt(10, it.getPuid());
                p.setInt(11, it.getPctid());
                p.setInt(12, it.getPgid());
                p.setFloat(13, it.getCostPrice());
                p.setFloat(14, it.getSalePrice());
                p.setString(15, it.getIteminfo());
                p.setBoolean(16, it.getItemuse());
                p.setDate(17, (Date) it.getCrateDate());
                p.setString(18, it.getCreateUser());
                File ff = new File(it.getPathImg());
                FileInputStream fis = new FileInputStream(ff);
                int len = (int) ff.length();
                p.setBinaryStream(19, fis, len);
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
    public Boolean updateImage(Item it){
        try {
            sql = "update tbl_Item set Item_img = ? where ITID = (?)";
            PreparedStatement p = c.prepareStatement(sql);
            File ff = new File(it.getPathImg());
            FileInputStream fis = new FileInputStream(ff);
            int len = (int) ff.length();
            p.setBinaryStream(1, fis, len);
            p.setInt(2, it.getITID());
            p.executeUpdate();
            p.close();
            return true;            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public void showItem(JTable table, DefaultTableModel model){
        try {
            RemoveTableCount.RemoveTable(table, model);
            sql = "Select it.itid, it.itemUse, it.barode, it.packbarcode, it.item_"+ LangType.Lang +" as item, it.costprice, it.saleprice, g.groupname_"+ LangType.Lang +" as groups, ca.cate_"+ LangType.Lang +" as category, "
                    + "u.unit_"+ LangType.Lang +" as unit, sz.sizename, \n" +
                    "z.zoneNo, pak.packNo, pik.pickNo, it.ItemInfo from tbl_Item it\n" +
                    "left join tbl_ProGroup g on g.PGID = it.PGID\n" +
                    "left join tbl_ProCategory ca on ca.PCTID = it.PCTID\n" +
                    "left join tbl_ProUnit u on u.PUID = it.PUID\n" +
                    "left join tbl_ProSize sz on sz.PSizeID = it.psizeid\n" +
                    "left join tbl_Zone z on z.ZoneID = it.Zoneid\n" +
                    "left join tbl_Pack pak on pak.PackID = it.packid\n" +
                    "left join tbl_Pick pik on pik.PickID = it.pickid\n" +
                    "where it.ItemUse = 1\n" +
                    "order by Barode, item_l1";
            ResultSet rs = c.createStatement().executeQuery(sql);
            while (rs.next()){
                model.addRow(new Object[]{rs.getString("itid"), rs.getBoolean("itemUse"), rs.getString("barode"), rs.getString("packbarcode"), rs.getString("item"), rs.getDouble("costprice"), rs.getDouble("saleprice"), 
                    rs.getString("groups"), rs.getString("category"), rs.getString("Unit"), rs.getString("sizename"), 
                rs.getString("zoneno"), rs.getString("packNo"), rs.getString("pickNo"), rs.getString("itemInfo")});
            }
            table.setModel(model);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void showOpenItemClick(Item it){
        try {
            sql = "Select it.itid, it.itemUse, it.barode, it.packbarcode, it.item_L1, it.item_L2, it.costprice, it.saleprice, g.groupname_"+ LangType.Lang +" as groups, ca.cate_"+ LangType.Lang +" as category, "
                    + "u.unit_"+ LangType.Lang +" as unit, sz.sizename, \n" +
                    "z.zoneNo, pak.packNo, pik.pickNo, it.ItemInfo, it.Item_img from tbl_Item it\n" +
                    "left join tbl_ProGroup g on g.PGID = it.PGID\n" +
                    "left join tbl_ProCategory ca on ca.PCTID = it.PCTID\n" +
                    "left join tbl_ProUnit u on u.PUID = it.PUID\n" +
                    "left join tbl_ProSize sz on sz.PSizeID = it.psizeid\n" +
                    "left join tbl_Zone z on z.ZoneID = it.Zoneid\n" +
                    "left join tbl_Pack pak on pak.PackID = it.packid\n" +
                    "left join tbl_Pick pik on pik.PickID = it.pickid\n" +
                    "where it.itid = "+ FrmItemAdd.ITID +"\n" +
                    "order by Barode, item_l1";
            ResultSet rs = c.createStatement().executeQuery(sql);
            if (rs.next()){
                it.setBarode(rs.getString("barode"));
                it.setPackBarcode(rs.getString("PackBarcode"));
                it.setItem_L1(rs.getString("Item_L1"));
                it.setItem_L2(rs.getString("item_L2"));
                it.setCostPrice(rs.getFloat("costprice"));
                it.setSalePrice(rs.getFloat("saleprice"));
                it.setGroupname(rs.getString("groups"));
                it.setCategory(rs.getString("category"));
                it.setUnitname(rs.getString("unit"));
                it.setSizeNo(rs.getString("sizename"));
                it.setZoneNo(rs.getString("zoneno"));
                it.setPackNo(rs.getString("packNo"));
                it.setPickNo(rs.getString("PickNo"));
                it.setIteminfo(rs.getString("iteminfo"));     
                it.setImages(rs.getBytes("Item_Img"));
            }            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public Boolean updateTbl_Item(Item it){
        try {
            sql = "update tbl_Item set Barode=?, PackBarcode=?, item_l1=?, item_l2=?, zoneid=?, packid=?, pickid=?, psizeid=?, puid=?, pctid=?, "
                    + "pgid=?, costprice=?, SalePrice=?, iteminfo=?, Createdate=?, Createuser=? where ITID = (?)";
            PreparedStatement p = c.prepareStatement(sql);
            p.setString(1, it.getBarode());
            p.setString(2, it.getPackBarcode());
            p.setString(3, it.getItem_L1().trim());
            p.setString(4, it.getItem_L2().trim());
            p.setInt(5, it.getZoneid());
            p.setInt(6, it.getPackid());
            p.setInt(7, it.getPickid());
            p.setInt(8, it.getPsizeid());
            p.setInt(9, it.getPuid());
            p.setInt(10, it.getPctid());
            p.setInt(11, it.getPgid());
            p.setFloat(12, it.getCostPrice()); 
            p.setFloat(13, it.getSalePrice()); 
            p.setString(14, it.getIteminfo().trim()); 
            p.setDate(15, (Date) it.getCrateDate()); 
            p.setString(16, it.getCreateUser().trim()); 
            p.setInt(17, it.getITID());
            p.executeUpdate();
            p.close();
            msg.showMsgSucess();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public Boolean updateTbl_Item_Used(Item it){
        try {
            sql = "update tbl_Item set ItemUse = ? where ITID = (?)";
            PreparedStatement p = c.prepareStatement(sql);
            p.setBoolean(1, it.getItemuse());
            p.setInt(2, it.getITID());
            p.executeUpdate();
            p.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public void showSearchTbl_Item(JTable table, DefaultTableModel model, String x){
        try {
            RemoveTableCount.RemoveTable(table, model);
            sql = "Select it.itid, it.itemUse, it.barode, it.packbarcode, it.item_"+ LangType.Lang +" as item, it.costprice, it.saleprice, g.groupname_"+ LangType.Lang +" as groups, ca.cate_"+ LangType.Lang +" as category, "
                    + "u.unit_"+ LangType.Lang +" as unit, sz.sizename, \n" +
                    "z.zoneNo, pak.packNo, pik.pickNo, it.ItemInfo from tbl_Item it\n" +
                    "left join tbl_ProGroup g on g.PGID = it.PGID\n" +
                    "left join tbl_ProCategory ca on ca.PCTID = it.PCTID\n" +
                    "left join tbl_ProUnit u on u.PUID = it.PUID\n" +
                    "left join tbl_ProSize sz on sz.PSizeID = it.psizeid\n" +
                    "left join tbl_Zone z on z.ZoneID = it.Zoneid\n" +
                    "left join tbl_Pack pak on pak.PackID = it.packid\n" +
                    "left join tbl_Pick pik on pik.PickID = it.pickid\n" +
                    "where it.barode like N'%"+ x +"%' or it.Packbarcode like N'%"+ x +"%' or it.item_"+ LangType.Lang +" like N'%"+ x +"%' or it.costprice like N'%"+ x +"%' or it.salePrice like N'%"+ x +"%' or g.groupname_"+ LangType.Lang +" like N'%"+ x +"%' or ca.cate_"+ LangType.Lang +" like N'%"+ x +"%' "
                    + "or u.unit_"+ LangType.Lang +" like N'%"+ x +"%' or sz.sizename like N'%"+ x +"%' or z.zoneNo like N'%"+ x +"%' or pak.packno like N'%"+ x +"%' or pik.pickNo like N'%"+ x +"%' "
                    + "or it.iteminfo like N'%"+ x +"%' or it.createUser like N'%"+ x +"%'\n" +
                    "order by Barode, item_l1";
            ResultSet rs = c.createStatement().executeQuery(sql);
            while (rs.next()){
                model.addRow(new Object[]{rs.getString("itid"), rs.getBoolean("itemUse"), rs.getString("barode"), rs.getString("packbarcode"), rs.getString("item"), rs.getDouble("costprice"), rs.getDouble("saleprice"), 
                    rs.getString("groups"), rs.getString("category"), rs.getString("Unit"), rs.getString("sizename"), 
                rs.getString("zoneno"), rs.getString("packNo"), rs.getString("pickNo"), rs.getString("itemInfo")});
            }
            table.setModel(model);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public Boolean updatePickFree(Item it){
        try {
            sql = "update tbl_pick set PickFree = ? where pickid = ?";
            PreparedStatement p = c.prepareStatement(sql);
            p.setBoolean(1, true);
            p.setInt(2, it.getPickid());
            p.executeUpdate();
            p.close();
            return true;            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public Boolean updatePackFree(Item it){
        try {
            sql = "update tbl_pack set packFree = ? where packid = (?)";
            PreparedStatement p = c.prepareStatement(sql);
            p.setBoolean(1, true);
            p.setInt(2, it.getPackid());
            p.executeUpdate();
            p.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public Boolean updatePickFree_Not(Item it){
        try {
            sql = "update tbl_Pick set PickFree = ?\n" +
                "from tbl_Pick left join tbl_Item on tbl_item.pickid = tbl_pick.PickID\n" +
                "where tbl_Item.itid = (?)";
            PreparedStatement p = c.prepareStatement(sql);
            p.setBoolean(1, false);
            p.setInt(2, it.getITID());
            p.executeUpdate();
            p.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public Boolean updatePackFree_Not(Item it){
        try {
            sql = "update tbl_pack set PackFree = ?\n" +
                "from tbl_Pack left join tbl_Item on tbl_item.packid = tbl_pack.PackID\n" +
                "where tbl_Item.itid = (?)";
            PreparedStatement p = c.prepareStatement(sql);
            p.setBoolean(1, false);
            p.setInt(2, it.getITID());
            p.executeUpdate();
            p.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
