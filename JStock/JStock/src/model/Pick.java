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
public class Pick {
    int pickid;
    String pickNo;
    String pickData;
    int packID;
    int Zoneid;
    String zonename;
    Boolean used;
    String PackNo;

    public void setPackNo(String PackNo) {
        this.PackNo = PackNo;
    }

    public String getPackNo() {
        return PackNo;
    }

    public int getPickid() {
        return pickid;
    }

    public String getPickNo() {
        return pickNo;
    }

    public String getPickData() {
        return pickData;
    }

    public int getPackID() {
        return packID;
    }

    public int getZoneid() {
        return Zoneid;
    }

    public String getZonename() {
        return zonename;
    }

    public Boolean getUsed() {
        return used;
    }

    public void setPickid(int pickid) {
        this.pickid = pickid;
    }

    public void setPickNo(String pickNo) {
        this.pickNo = pickNo;
    }

    public void setPickData(String pickData) {
        this.pickData = pickData;
    }

    public void setPackID(int packID) {
        this.packID = packID;
    }

    public void setZoneid(int Zoneid) {
        this.Zoneid = Zoneid;
    }

    public void setZonename(String zonename) {
        this.zonename = zonename;
    }

    public void setUsed(Boolean used) {
        this.used = used;
    }
    
}
