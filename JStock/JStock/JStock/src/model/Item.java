/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

public class Item {
  int ITID;
  String Barode;
  String PackBarcode;
  String Item_L1;
  String Item_L2;
  int Zoneid;
  int packid;
  int pickid;
  int psizeid;
  int puid;
  int pctid;
  int pgid;
  float CostPrice;
  float SalePrice;
  String iteminfo;
  String PathImg;
  Boolean Itemuse;
  Date CrateDate;
  String CreateUser;

    public void setITID(int ITID) {
        this.ITID = ITID;
    }

    public void setBarode(String Barode) {
        this.Barode = Barode;
    }

    public void setPackBarcode(String PackBarcode) {
        this.PackBarcode = PackBarcode;
    }

    public void setItem_L1(String Item_L1) {
        this.Item_L1 = Item_L1;
    }

    public void setItem_L2(String Item_L2) {
        this.Item_L2 = Item_L2;
    }

    public void setZoneid(int Zoneid) {
        this.Zoneid = Zoneid;
    }

    public void setPackid(int packid) {
        this.packid = packid;
    }

    public void setPickid(int pickid) {
        this.pickid = pickid;
    }

    public void setPsizeid(int psizeid) {
        this.psizeid = psizeid;
    }

    public void setPuid(int puid) {
        this.puid = puid;
    }

    public void setPctid(int pctid) {
        this.pctid = pctid;
    }

    public void setPgid(int pgid) {
        this.pgid = pgid;
    }

    public void setCostPrice(float CostPrice) {
        this.CostPrice = CostPrice;
    }

    public void setSalePrice(float SalePrice) {
        this.SalePrice = SalePrice;
    }

    public void setIteminfo(String iteminfo) {
        this.iteminfo = iteminfo;
    }

    public void setPathImg(String PathImg) {
        this.PathImg = PathImg;
    }

    public void setItemuse(Boolean Itemuse) {
        this.Itemuse = Itemuse;
    }

    public void setCrateDate(Date CrateDate) {
        this.CrateDate = CrateDate;
    }

    public void setCreateUser(String CreateUser) {
        this.CreateUser = CreateUser;
    }

    public int getITID() {
        return ITID;
    }

    public String getBarode() {
        return Barode;
    }

    public String getPackBarcode() {
        return PackBarcode;
    }

    public String getItem_L1() {
        return Item_L1;
    }

    public String getItem_L2() {
        return Item_L2;
    }

    public int getZoneid() {
        return Zoneid;
    }

    public int getPackid() {
        return packid;
    }

    public int getPickid() {
        return pickid;
    }

    public int getPsizeid() {
        return psizeid;
    }

    public int getPuid() {
        return puid;
    }

    public int getPctid() {
        return pctid;
    }

    public int getPgid() {
        return pgid;
    }

    public float getCostPrice() {
        return CostPrice;
    }

    public float getSalePrice() {
        return SalePrice;
    }

    public String getIteminfo() {
        return iteminfo;
    }

    public String getPathImg() {
        return PathImg;
    }

    public Boolean getItemuse() {
        return Itemuse;
    }

    public Date getCrateDate() {
        return CrateDate;
    }

    public String getCreateUser() {
        return CreateUser;
    }

}
