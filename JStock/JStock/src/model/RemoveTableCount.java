/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Malimar
 */
public class RemoveTableCount {
    public static void RemoveTable(JTable table, DefaultTableModel model){
        try {
            int index = table.getRowCount()-1;
            while (index > -1){
                model.removeRow(index--);
            }
            
        } catch (Exception e) {
        }
    }
    
}
