/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

/**
 *
 * @author Admin
 */
public class ConvertDateSQL {
    public static java.sql.Date convertUtilDateToSqlDate(java.util.Date date){
        if (date !=null){
            java.sql.Date sqlDate = new java.sql.Date(date.getTime());
            return sqlDate;
        }        
        return null;
    }
}
