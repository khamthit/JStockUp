/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.awt.Color;
import javax.swing.JButton;

/**
 *
 * @author Malimar
 */
public class ButtonColor {
    public static void showButtonEnter(JButton btn){
        try {
            btn.setBackground(new Color(180,150,255));
        } catch (Exception e) {
        }
    }
    public static void showButtonExited(JButton btn){
        try {
            btn.setBackground(new Color(255,255,255));
        } catch (Exception e) {
        }
    }
    
}
