/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import modelManager.LangType;
import static modelManager.LangType.LN;

/**
 *
 * @author Malimar
 */
public class TableHeader {
    
    public static void TableHeader_0(JTable table, String frm){
        try {
            JTableHeader th = table.getTableHeader();
            TableColumnModel tcm = th.getColumnModel();
            table.getColumnCount();
            for(int i=0; i < table.getColumnCount(); i++){
                TableColumn tc = tcm.getColumn(i);            
                tc.setHeaderValue(LangType.hmapSys.get(table.getModel().getColumnName(i).concat(frm).toUpperCase()) [LN]);                
            }
            table.setAutoCreateRowSorter(true);
            th.repaint();
        } catch (Exception e) {
        }
        
    }
    public static void RemoveTable(JTable table, DefaultTableModel model){
        try {
            int indx = table.getRowCount()-1;
            while (indx > -1){
               model.removeRow(indx--);
            }
        } catch (Exception e) {
        }
    }
    public static void TableHeaderFont(JTable table){
        try {
            table.getTableHeader().setFont(new Font("Saysettha MX", Font.BOLD, 10));            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void TableCellRenderRightFrmPurchaseOrderAdd(JTable table){
        try {
            DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
            centerRenderer.setHorizontalAlignment(JLabel.RIGHT);
            table.getColumnModel().getColumn(7).setCellRenderer(centerRenderer);
        } catch (Exception e) {
        }
    }
}
