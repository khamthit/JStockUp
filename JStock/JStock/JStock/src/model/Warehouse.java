/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;

/**
 *
 * @author Malimar
 */
public class Warehouse {
    int Stockid;
    String stocknameL1;
    String stocknameL2;
    String mobile1;
    String mobile2;
    String Fax;
    String StockAddress;
    Date createDate;
    String createBy;

    public int getStockid() {
        return Stockid;
    }

    public String getStocknameL1() {
        return stocknameL1;
    }

    public String getStocknameL2() {
        return stocknameL2;
    }

    public String getMobile1() {
        return mobile1;
    }

    public String getMobile2() {
        return mobile2;
    }

    public String getFax() {
        return Fax;
    }

    public String getStockAddress() {
        return StockAddress;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setStockid(int Stockid) {
        this.Stockid = Stockid;
    }

    public void setStocknameL1(String stocknameL1) {
        this.stocknameL1 = stocknameL1;
    }

    public void setStocknameL2(String stocknameL2) {
        this.stocknameL2 = stocknameL2;
    }

    public void setMobile1(String mobile1) {
        this.mobile1 = mobile1;
    }

    public void setMobile2(String mobile2) {
        this.mobile2 = mobile2;
    }

    public void setFax(String Fax) {
        this.Fax = Fax;
    }

    public void setStockAddress(String StockAddress) {
        this.StockAddress = StockAddress;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }
}
