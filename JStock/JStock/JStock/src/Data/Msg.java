/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import static modelManager.LangType.Lang;

/**
 *
 * @author Malimar
 */
public class Msg {
    ImageIcon iconTrue = new ImageIcon("src/img/True.png");
    ImageIcon iconFalse = new ImageIcon("src/img/False.png");
    public void showMsgSucess(){
        try {
            if ("L1".equals(Lang)) {
                JOptionPane.showMessageDialog(null, "<html><p><font color=\"#000\"size=\"3\" face=\"Saysettha OT\">" + "ສໍາເລັດ" + "</font></p></html>", "ແຈ້ງເຕືອນ", JOptionPane.INFORMATION_MESSAGE,iconTrue);                
            } else {
                ImageIcon icon = new ImageIcon("src/img/True.png");
                JOptionPane.showMessageDialog(null, "<html><p><font color=\"#000\"size=\"3\" face=\"Saysettha OT\">" + "Sucessful" + "</font></p></html>", "MESSAGE", JOptionPane.INFORMATION_MESSAGE,iconTrue);
            }

        } catch (Exception e) {
        }
    }
    public void showMsgUnSucess(){
        try {
            if ("L1".equals(Lang)) {
                JOptionPane.showMessageDialog(null, "<html><p><font color=\"#000\"size=\"3\" face=\"Saysettha OT\">" + "ບໍ່ສໍາເລັດ" + "</font></p></html>", "ແຈ້ງເຕືອນ", JOptionPane.ERROR_MESSAGE, iconFalse);
            } else {
                JOptionPane.showMessageDialog(null, "<html><p><font color=\"#000\"size=\"3\" face=\"Saysettha OT\">" + "Unsucessful" + "</font></p></html>", "MESSAGE", JOptionPane.ERROR_MESSAGE, iconFalse);
            }
        } catch (Exception e) {
        }
    }
    public void showMsgWarming(){
        try {
            if ("L1".equals(Lang)) {
                JOptionPane.showMessageDialog(null, "<html><p><font color=\"#000\"size=\"3\" face=\"Saysettha OT\">" + "ກວດກາຂໍ້ມູນຂອງທ່ານອີກຄັ້ງ" + "</font></p></html>", "ແຈ້ງເຕືອນ", JOptionPane.ERROR_MESSAGE, iconFalse);
            } else {
                JOptionPane.showMessageDialog(null, "<html><p><font color=\"#000\"size=\"3\" face=\"Saysettha OT\">" + "Data is not enought" + "</font></p></html>", "MESSAGE", JOptionPane.ERROR_MESSAGE, iconFalse);
            }
        } catch (Exception e) {
        }
    }
    public void showMsgSameData(){
        try {
            if ("L1".equals(Lang)) {
                JOptionPane.showMessageDialog(null, "<html><p><font color=\"#000\"size=\"3\" face=\"Saysettha OT\">" + "ຂໍ້ມູນຂອງທ່ານມີແລ້ວໃນລະບົບ" + "</font></p></html>", "ແຈ້ງເຕືອນ", JOptionPane.ERROR_MESSAGE, iconFalse);
            } else {
                JOptionPane.showMessageDialog(null, "<html><p><font color=\"#000\"size=\"3\" face=\"Saysettha OT\">" + "Error, Data have been your system" + "</font></p></html>", "MESSAGE", JOptionPane.ERROR_MESSAGE, iconFalse);
            }
        } catch (Exception e) {
        }
    }
    public void showMsgCheckCombo(){
        try {
            if ("L1".equals(Lang)) {
                JOptionPane.showMessageDialog(null, "<html><p><font color=\"#000\"size=\"3\" face=\"Saysettha OT\">" + "ເລືອກຂໍ້ມູນກ່ອນ" + "</font></p></html>", "ແຈ້ງເຕືອນ", JOptionPane.ERROR_MESSAGE, iconFalse);
            } else {
                JOptionPane.showMessageDialog(null, "<html><p><font color=\"#000\"size=\"3\" face=\"Saysettha OT\">" + "Check Data First" + "</font></p></html>", "MESSAGE", JOptionPane.ERROR_MESSAGE, iconFalse);
            }
        } catch (Exception e) {
        }
    }
    
}
