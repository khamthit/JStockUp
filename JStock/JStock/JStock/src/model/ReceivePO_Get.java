/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Admin
 */
public class ReceivePO_Get {
    int Actdid;
    Boolean Receive_activity;
    double Receive_qty;
    String Receive_bill;
    String Receive_POBill;
    int StockID;
    String StockName_L1;
    String StockName_L2;

    public void setStockID(int StockID) {
        this.StockID = StockID;
    }

    public void setStockName_L1(String StockName_L1) {
        this.StockName_L1 = StockName_L1;
    }

    public void setStockName_L2(String StockName_L2) {
        this.StockName_L2 = StockName_L2;
    }

    public int getStockID() {
        return StockID;
    }

    public String getStockName_L1() {
        return StockName_L1;
    }

    public String getStockName_L2() {
        return StockName_L2;
    }

    public void setActdid(int Actdid) {
        this.Actdid = Actdid;
    }

    public void setReceive_activity(Boolean Receive_activity) {
        this.Receive_activity = Receive_activity;
    }

    public void setReceive_qty(double Receive_qty) {
        this.Receive_qty = Receive_qty;
    }

    public void setReceive_bill(String Receive_bill) {
        this.Receive_bill = Receive_bill;
    }

    public void setReceive_POBill(String Receive_POBill) {
        this.Receive_POBill = Receive_POBill;
    }

    public int getActdid() {
        return Actdid;
    }

    public Boolean getReceive_activity() {
        return Receive_activity;
    }

    public double getReceive_qty() {
        return Receive_qty;
    }

    public String getReceive_bill() {
        return Receive_bill;
    }

    public String getReceive_POBill() {
        return Receive_POBill;
    }
    
}
