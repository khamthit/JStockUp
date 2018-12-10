/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Malimar
 */
import java.sql.*;
import sysConnect.module;
public class Main {
    String company;
    String mobile;
    String fax;
    String Address;
    String LangType;
    String User;
    String passworld;

    public String getUser() {
        return User;
    }

    public String getPassworld() {
        return passworld;
    }

    public void setUser(String User) {
        this.User = User;
    }

    public void setPassworld(String passworld) {
        this.passworld = passworld;
    }

    public void setLangType(String LangType) {
        this.LangType = LangType;
    }

    public String getLangType() {
        return LangType;
    }

    public String getCompany() {
        return company;
    }

    public String getMobile() {
        return mobile;
    }

    public String getFax() {
        return fax;
    }

    public String getAddress() {
        return Address;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }
    
}
