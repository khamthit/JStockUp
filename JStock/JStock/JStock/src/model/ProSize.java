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
public class ProSize {
    int ProSizeID;
    String ProSizeName;
    String ProSizeDescriptions;

    public int getProSizeID() {
        return ProSizeID;
    }

    public String getProSizeName() {
        return ProSizeName;
    }

    public String getProSizeDescriptions() {
        return ProSizeDescriptions;
    }

    public void setProSizeID(int ProSizeID) {
        this.ProSizeID = ProSizeID;
    }

    public void setProSizeName(String ProSizeName) {
        this.ProSizeName = ProSizeName;
    }

    public void setProSizeDescriptions(String ProSizeDescriptions) {
        this.ProSizeDescriptions = ProSizeDescriptions;
    }
    
    
}
