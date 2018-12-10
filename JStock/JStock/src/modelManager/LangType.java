/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelManager;

import java.util.HashMap;
import java.sql.*;
import sysConnect.module;

public class LangType {
    Connection c = module.getConnection();
    String sql;
    public static int LN;
    public static int LogIN =0;
    public static String Lang;
    public static HashMap<String, String[]> hmapForm= new HashMap();
    public static HashMap<String, String[]> hmapSys= new HashMap();
    
    public static String showLangForm(){
        try {
            Connection c = module.getConnection();
            String s = "exec pd_sysForm";
            ResultSet rs = c.createStatement().executeQuery(s);
            while (rs.next()){
                hmapForm.put(rs.getString(1), new String[]{rs.getString(2), rs.getString(3)});
            }
            c.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public static String showLang(){
        try {
            Connection c = module.getConnection();
            String s = "exec pd_SysLang";
            ResultSet rs = c.createStatement().executeQuery(s);
            while (rs.next()){
                hmapSys.put(rs.getString(1), new String[]{rs.getString(2), rs.getString(3)});
            }
            c.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
