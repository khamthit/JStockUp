/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;
import Data.ButtonColor;
import Data.Msg;
import java.awt.Color;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import javax.swing.JOptionPane;
import modelManager.LangType;
import static modelManager.LangType.LN;
import sysConnect.module;
import model.Pack;
import modelManager.MaxIDTbl;
import modelManager.PackManager;

public class FrmPack extends javax.swing.JInternalFrame {
    Connection c = module.getConnection();
    String sql, frm;    
    LangType lang = new LangType();
    
    Pack pa = new Pack();
    PackManager pam = new PackManager();
    Msg msg = new Msg();
    
    public static int PackID=0;
    HashMap<String, Object[]>mapZ = null;
    
    public FrmPack() {
        initComponents();
        frm = this.getClass().getSimpleName();
        lang.showLang();
        lang.showLangForm();
        
        
        
    }
    public void showLang(){
        try {
            lblFormName.setText(lang.hmapForm.get(frm.toUpperCase())[LN]);
            lblPackNo.setText(lang.hmapSys.get("lblPackNo".concat(frm).toUpperCase())[LN]);
            lblPackStock.setText(lang.hmapSys.get("lblPackStock".concat(frm).toUpperCase())[LN]);
            btnShowData.setText(lang.hmapSys.get("btnshowdata".concat(frm).toUpperCase())[LN]);
            btnSave.setText(lang.hmapSys.get("btnSave".concat(frm).toUpperCase())[LN]);
            cbPack.setText(lang.hmapSys.get("cbPack".concat(frm).toUpperCase())[LN]);
            lblZoneNo.setText(lang.hmapSys.get("lblZoneNo".concat(frm).toUpperCase())[LN]);
            
            
        } catch (Exception e) {
        }
    }
    public void showClear(){
        try {
            PackID =0;
            txtPackName.setText("");
            txtPackNo.setText("");
            txtPackNo.requestFocus();
            cbPack.setSelected(false);
            showMaps();
            
        } catch (Exception e) {
        }
    }
    public void showMaps(){
        try {
            mapZ = pam.getMapZone();
            Map<String, Object[]>smap = new TreeMap<>(mapZ);
            cbbZone.removeAllItems();
            smap.keySet().forEach((s)->{
                cbbZone.addItem(s);
            });
            cbbZone.setSelectedIndex(-1);            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblFormName = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lblPackNo = new javax.swing.JLabel();
        txtPackNo = new javax.swing.JTextField();
        lblPackStock = new javax.swing.JLabel();
        txtPackName = new javax.swing.JTextField();
        btnShowData = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        cbPack = new javax.swing.JCheckBox();
        lblZoneNo = new javax.swing.JLabel();
        cbbZone = new javax.swing.JComboBox<>();

        setClosable(true);
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/StPack.png"))); // NOI18N
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        lblFormName.setFont(new java.awt.Font("Saysettha MX", 1, 18)); // NOI18N
        lblFormName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFormName.setText("Pack");
        lblFormName.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(lblFormName, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(lblFormName, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        lblPackNo.setFont(new java.awt.Font("Saysettha MX", 0, 12)); // NOI18N
        lblPackNo.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblPackNo.setText("PackNum");
        lblPackNo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        txtPackNo.setFont(new java.awt.Font("Saysettha MX", 0, 12)); // NOI18N
        txtPackNo.setToolTipText("");
        txtPackNo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPackNoKeyReleased(evt);
            }
        });

        lblPackStock.setFont(new java.awt.Font("Saysettha MX", 0, 12)); // NOI18N
        lblPackStock.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblPackStock.setText("Stock Name L2");
        lblPackStock.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        txtPackName.setFont(new java.awt.Font("Saysettha MX", 0, 12)); // NOI18N
        txtPackName.setToolTipText("");

        btnShowData.setBackground(new java.awt.Color(255, 255, 255));
        btnShowData.setFont(new java.awt.Font("Saysettha MX", 0, 12)); // NOI18N
        btnShowData.setText("Data");
        btnShowData.setContentAreaFilled(false);
        btnShowData.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnShowData.setOpaque(true);
        btnShowData.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnShowDataMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnShowDataMouseExited(evt);
            }
        });
        btnShowData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShowDataActionPerformed(evt);
            }
        });

        btnSave.setBackground(new java.awt.Color(255, 255, 255));
        btnSave.setFont(new java.awt.Font("Saysettha MX", 0, 12)); // NOI18N
        btnSave.setText("Save");
        btnSave.setContentAreaFilled(false);
        btnSave.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSave.setOpaque(true);
        btnSave.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSaveMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSaveMouseExited(evt);
            }
        });
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        cbPack.setBackground(new java.awt.Color(255, 255, 255));
        cbPack.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        cbPack.setText("Used");
        cbPack.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        lblZoneNo.setFont(new java.awt.Font("Saysettha MX", 0, 12)); // NOI18N
        lblZoneNo.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblZoneNo.setText("Zone");
        lblZoneNo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        cbbZone.setEditable(true);
        cbbZone.setFont(new java.awt.Font("Saysettha MX", 0, 12)); // NOI18N
        cbbZone.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(lblZoneNo, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbbZone, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(lblPackNo, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtPackNo, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(lblPackStock, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbPack, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(btnShowData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtPackName, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblZoneNo)
                    .addComponent(cbbZone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPackNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPackNo))
                .addGap(2, 2, 2)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPackName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPackStock))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbPack, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnShowData)
                    .addComponent(btnSave))
                .addGap(114, 114, 114))
        );

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtPackNoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPackNoKeyReleased
        
    }//GEN-LAST:event_txtPackNoKeyReleased

    private void btnShowDataMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnShowDataMouseEntered
        try {
            ButtonColor.showButtonEnter(btnShowData);
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnShowDataMouseEntered

    private void btnShowDataMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnShowDataMouseExited
        ButtonColor.showButtonExited(btnShowData);
    }//GEN-LAST:event_btnShowDataMouseExited

    private void btnShowDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShowDataActionPerformed
        try {
            showClear();
            FrmPackData f = new FrmPackData(null, closable);
            f.setVisible(true);
           
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnShowDataActionPerformed

    private void btnSaveMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaveMouseEntered
        ButtonColor.showButtonEnter(btnSave);
    }//GEN-LAST:event_btnSaveMouseEntered

    private void btnSaveMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaveMouseExited
        ButtonColor.showButtonExited(btnSave);
    }//GEN-LAST:event_btnSaveMouseExited

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        try {            
            String zid = cbbZone.getSelectedItem().toString();        
            if (txtPackNo.getText().equals("")){
                msg.showMsgWarming();
            }else{
                if (PackID ==0){
                    MaxIDTbl.maxID("PackID", "Tbl_Pack");
                    pa.setPackID(MaxIDTbl.getID);
                    pa.setPackNo(txtPackNo.getText());
                    pa.setPackName(txtPackName.getText());
                    pa.setUsed(cbPack.isSelected());
                    pa.setZoneid(Integer.parseInt(mapZ.get(zid)[0].toString()));
                    pam.insertTbl_Pack(pa);                
                    showClear();    
                    PackID =0;
                    pa.setPackID(PackID);
                }else{
                    pa.setPackID(PackID);
                    pa.setPackNo(txtPackNo.getText());
                    pa.setPackName(txtPackName.getText());
                    pa.setUsed(cbPack.isSelected());
                    pa.setZoneid(Integer.parseInt(mapZ.get(zid)[0].toString()));
                    pam.updateTbl_Pack(pa);
                    msg.showMsgSucess();
                    showClear();                
                }
            }                        
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        try {
            showLang();
            showMaps();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_formInternalFrameOpened


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnShowData;
    public static javax.swing.JCheckBox cbPack;
    public static javax.swing.JComboBox<String> cbbZone;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblFormName;
    private javax.swing.JLabel lblPackNo;
    private javax.swing.JLabel lblPackStock;
    private javax.swing.JLabel lblZoneNo;
    public static javax.swing.JTextField txtPackName;
    public static javax.swing.JTextField txtPackNo;
    // End of variables declaration//GEN-END:variables
}
