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
public class ProUnit {
    int PUID;
    String Unit_L1;
    String Unit_L2;
    String Unit_Descriptions;

    public void setPUID(int PUID) {
        this.PUID = PUID;
    }

    public void setUnit_L1(String Unit_L1) {
        this.Unit_L1 = Unit_L1;
    }

    public void setUnit_L2(String Unit_L2) {
        this.Unit_L2 = Unit_L2;
    }

    public void setUnit_Descriptions(String Unit_Descriptions) {
        this.Unit_Descriptions = Unit_Descriptions;
    }

    public int getPUID() {
        return PUID;
    }

    public String getUnit_L1() {
        return Unit_L1;
    }

    public String getUnit_L2() {
        return Unit_L2;
    }

    public String getUnit_Descriptions() {
        return Unit_Descriptions;
    }
    
}
