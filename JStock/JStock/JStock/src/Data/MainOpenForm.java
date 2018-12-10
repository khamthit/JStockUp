/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;

/**
 *
 * @author Admin
 */
public class MainOpenForm {
    public static void Open(JInternalFrame inf, JDesktopPane desk){
        try {
            inf.setVisible(true);
            desk.add(inf);            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
