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
public class ProGroup {
    int GroupID;
    String GroupName_L1;
    String GroupName_L2;
    String GroupDescriptions;

    public void setGroupID(int GroupID) {
        this.GroupID = GroupID;
    }

    public void setGroupName_L1(String GroupName_L1) {
        this.GroupName_L1 = GroupName_L1;
    }

    public void setGroupName_L2(String GroupName_L2) {
        this.GroupName_L2 = GroupName_L2;
    }

    public void setGroupDescriptions(String GroupDescriptions) {
        this.GroupDescriptions = GroupDescriptions;
    }

    public int getGroupID() {
        return GroupID;
    }

    public String getGroupName_L1() {
        return GroupName_L1;
    }

    public String getGroupName_L2() {
        return GroupName_L2;
    }

    public String getGroupDescriptions() {
        return GroupDescriptions;
    }
    
}
