/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelManager;

import Data.Msg;
import java.sql.*;
import model.ProSize;
import sysConnect.module;

public class ProSizeManager {

    String sql;
    Connection c = module.getConnection();
    Msg msg = new Msg();

    public Boolean InsertTblProSize(ProSize ps) {
        try {
            sql = "insert into tbl_ProSize (PSizeID, SizeName, SizeDescriptions) values (?,?,?)";
            PreparedStatement p = c.prepareStatement(sql);
            p.setInt(1, ps.getProSizeID());
            p.setString(2, ps.getProSizeName());
            p.setString(3, ps.getProSizeDescriptions());
            p.executeUpdate();
            msg.showMsgSucess();
            p.close();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

}
