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
public class ProCategory {
    int PCTID;
    String Cate_L1;
    String Cate_L2;
    String Cate_Descriptions;

    public int getPCTID() {
        return PCTID;
    }

    public String getCate_L1() {
        return Cate_L1;
    }

    public String getCate_L2() {
        return Cate_L2;
    }

    public String getCate_Descriptions() {
        return Cate_Descriptions;
    }

    public void setPCTID(int PCTID) {
        this.PCTID = PCTID;
    }

    public void setCate_L1(String Cate_L1) {
        this.Cate_L1 = Cate_L1;
    }

    public void setCate_L2(String Cate_L2) {
        this.Cate_L2 = Cate_L2;
    }

    public void setCate_Descriptions(String Cate_Descriptions) {
        this.Cate_Descriptions = Cate_Descriptions;
    }
    
}
