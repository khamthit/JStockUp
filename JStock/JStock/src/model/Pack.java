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
public class Pack {
    int PackID;
    String PackNo;
    String PackName;
    Boolean used;
    int zoneid;
    String zoneids;

    public void setZoneids(String zoneids) {
        this.zoneids = zoneids;
    }

    public String getZoneids() {
        return zoneids;
    }

    public void setZoneid(int zoneid) {
        this.zoneid = zoneid;
    }

    public int getZoneid() {
        return zoneid;
    }
    
    public void setPackNo(String PackNo) {
        this.PackNo = PackNo;
    }

    public String getPackNo() {
        return PackNo;
    }

    public int getPackID() {
        return PackID;
    }

    public String getPackName() {
        return PackName;
    }

    public Boolean getUsed() {
        return used;
    }

    public void setPackID(int PackID) {
        this.PackID = PackID;
    }

    public void setPackName(String PackName) {
        this.PackName = PackName;
    }

    public void setUsed(Boolean used) {
        this.used = used;
    }
    
    
}
