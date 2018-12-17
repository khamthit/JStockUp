/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author Admin
 */
public class Purchase {
    int Actid;
    int Actdid;
    String actNo;
    Date ActivityCreateDate;
    String CreateUser;
    String ActivityRec_type;
    int itid;
    int zoneid;
    int packid;
    int pickid;
    int venid;
    String ven_l1;
    String ven_l2;
    int Stockid;
    String stockname_l1;
    String stockname_l2;
    String barcode;
    String packbarcode;
    String item_l1;
    String item_l2;
    String Zoneno;
    String pickno;
    String packno;
    float qty;
    float Costprice;
    float Saleprice;
    Boolean ActivityDetails_RecType;
    Boolean Activiing;

    public int getActid() {
        return Actid;
    }

    public int getActdid() {
        return Actdid;
    }

    public String getActNo() {
        return actNo;
    }

    public Date getActivityCreateDate() {
        return ActivityCreateDate;
    }

    public String getCreateUser() {
        return CreateUser;
    }

    public String getActivityRec_type() {
        return ActivityRec_type;
    }

    public int getItid() {
        return itid;
    }

    public int getZoneid() {
        return zoneid;
    }

    public int getPackid() {
        return packid;
    }

    public int getPickid() {
        return pickid;
    }

    public int getVenid() {
        return venid;
    }

    public String getVen_l1() {
        return ven_l1;
    }

    public String getVen_l2() {
        return ven_l2;
    }

    public int getStockid() {
        return Stockid;
    }

    public String getStockname_l1() {
        return stockname_l1;
    }

    public String getStockname_l2() {
        return stockname_l2;
    }

    public String getBarcode() {
        return barcode;
    }

    public String getPackbarcode() {
        return packbarcode;
    }

    public String getItem_l1() {
        return item_l1;
    }

    public String getItem_l2() {
        return item_l2;
    }

    public String getZoneno() {
        return Zoneno;
    }

    public String getPickno() {
        return pickno;
    }

    public String getPackno() {
        return packno;
    }

    public float getQty() {
        return qty;
    }

    public float getCostprice() {
        return Costprice;
    }

    public float getSaleprice() {
        return Saleprice;
    }

    public Boolean getActivityDetails_RecType() {
        return ActivityDetails_RecType;
    }

    public Boolean getActiviing() {
        return Activiing;
    }

    public void setActid(int Actid) {
        this.Actid = Actid;
    }

    public void setActdid(int Actdid) {
        this.Actdid = Actdid;
    }

    public void setActNo(String actNo) {
        this.actNo = actNo;
    }

    public void setActivityCreateDate(Date ActivityCreateDate) {
        this.ActivityCreateDate = ActivityCreateDate;
    }

    public void setCreateUser(String CreateUser) {
        this.CreateUser = CreateUser;
    }

    public void setActivityRec_type(String ActivityRec_type) {
        this.ActivityRec_type = ActivityRec_type;
    }

    public void setItid(int itid) {
        this.itid = itid;
    }

    public void setZoneid(int zoneid) {
        this.zoneid = zoneid;
    }

    public void setPackid(int packid) {
        this.packid = packid;
    }

    public void setPickid(int pickid) {
        this.pickid = pickid;
    }

    public void setVenid(int venid) {
        this.venid = venid;
    }

    public void setVen_l1(String ven_l1) {
        this.ven_l1 = ven_l1;
    }

    public void setVen_l2(String ven_l2) {
        this.ven_l2 = ven_l2;
    }

    public void setStockid(int Stockid) {
        this.Stockid = Stockid;
    }

    public void setStockname_l1(String stockname_l1) {
        this.stockname_l1 = stockname_l1;
    }

    public void setStockname_l2(String stockname_l2) {
        this.stockname_l2 = stockname_l2;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public void setPackbarcode(String packbarcode) {
        this.packbarcode = packbarcode;
    }

    public void setItem_l1(String item_l1) {
        this.item_l1 = item_l1;
    }

    public void setItem_l2(String item_l2) {
        this.item_l2 = item_l2;
    }

    public void setZoneno(String Zoneno) {
        this.Zoneno = Zoneno;
    }

    public void setPickno(String pickno) {
        this.pickno = pickno;
    }

    public void setPackno(String packno) {
        this.packno = packno;
    }

    public void setQty(float qty) {
        this.qty = qty;
    }

    public void setCostprice(float Costprice) {
        this.Costprice = Costprice;
    }

    public void setSaleprice(float Saleprice) {
        this.Saleprice = Saleprice;
    }

    public void setActivityDetails_RecType(Boolean ActivityDetails_RecType) {
        this.ActivityDetails_RecType = ActivityDetails_RecType;
    }

    public void setActiviing(Boolean Activiing) {
        this.Activiing = Activiing;
    }
    
}
