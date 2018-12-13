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
public class Vendor {
    int venid;
    String ven_l1;
    String ven_l2;
    String phone1;
    String phone2;
    String fax;
    String email;
    String website;
    String bankname;
    String bankAccount;
    Date VendorStart;
    String vendorInfo;
    Date Createdate;
    String CreateUser;
    Boolean vendorUsing;
    String PostalCode;

    public void setVenid(int venid) {
        this.venid = venid;
    }

    public void setVen_l1(String ven_l1) {
        this.ven_l1 = ven_l1;
    }

    public void setVen_l2(String ven_l2) {
        this.ven_l2 = ven_l2;
    }

    public void setPhone1(String phone1) {
        this.phone1 = phone1;
    }

    public void setPhone2(String phone2) {
        this.phone2 = phone2;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public void setBankname(String bankname) {
        this.bankname = bankname;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    public void setVendorStart(Date VendorStart) {
        this.VendorStart = VendorStart;
    }

    public void setVendorInfo(String vendorInfo) {
        this.vendorInfo = vendorInfo;
    }

    public void setCreatedate(Date Createdate) {
        this.Createdate = Createdate;
    }

    public void setCreateUser(String CreateUser) {
        this.CreateUser = CreateUser;
    }

    public void setVendorUsing(Boolean vendorUsing) {
        this.vendorUsing = vendorUsing;
    }

    public void setPostalCode(String PostalCode) {
        this.PostalCode = PostalCode;
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

    public String getPhone1() {
        return phone1;
    }

    public String getPhone2() {
        return phone2;
    }

    public String getFax() {
        return fax;
    }

    public String getEmail() {
        return email;
    }

    public String getWebsite() {
        return website;
    }

    public String getBankname() {
        return bankname;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public Date getVendorStart() {
        return VendorStart;
    }

    public String getVendorInfo() {
        return vendorInfo;
    }

    public Date getCreatedate() {
        return Createdate;
    }

    public String getCreateUser() {
        return CreateUser;
    }

    public Boolean getVendorUsing() {
        return vendorUsing;
    }

    public String getPostalCode() {
        return PostalCode;
    }
    
}
