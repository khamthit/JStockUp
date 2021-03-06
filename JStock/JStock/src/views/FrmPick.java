/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import Data.ButtonColor;
import Data.Msg;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import model.Pick;
import model.RemoveTableCount;
import modelManager.LangType;
import static modelManager.LangType.LN;
import modelManager.MaxIDTbl;
import modelManager.PickManager;
import sysConnect.module;
public class FrmPick extends javax.swing.JInternalFrame {

    Connection c =module.getConnection();
    String sql, frm;
    public static int PickID=0;
    
    HashMap<String, Object[]>mZone = null;
    HashMap<String, Object[]>mPack = null;
    
    Pick pi = new Pick();
    PickManager pim = new PickManager();
    Msg msg = new Msg();
    
    public FrmPick() {
        initComponents();
        frm = this.getClass().getSimpleName();
        LangType.showLang();
        LangType.showLangForm();
        
        
    }
    public void showLang(){
        try {
            lblFormName.setText(LangType.hmapForm.get(frm.toUpperCase())[LN]);
            lblZoneNo.setText(LangType.hmapSys.get("lblzoneno".concat(frm).toUpperCase())[LN]);
            lblPack.setText(LangType.hmapSys.get("lblPack".concat(frm).toUpperCase())[LN]);
            lblPickNo.setText(LangType.hmapSys.get("lblPickNo".concat(frm).toUpperCase())[LN]);
            lblPickData.setText(LangType.hmapSys.get("lblPickData".concat(frm).toUpperCase())[LN]);
            cbUsed.setText(LangType.hmapSys.get("cbUsed".concat(frm).toUpperCase())[LN]);
            btnSave.setText(LangType.hmapSys.get("btnSave".concat(frm).toUpperCase())[LN]);
            btnData.setText(LangType.hmapSys.get("btnData".concat(frm).toUpperCase())[LN]);
            
            
        } catch (Exception e) {
        }
    }
    public void showClear(){
        try {
            cbUsed.setSelected(true);
            txtPickNo.setText("");
            txtPickData.setText("");
            txtPickNo.requestFocus();
            showMapZone();                       
        } catch (Exception e) {
        }
    }
    public void showMapZone(){
        try {
            mZone = pim.hmapZone();
            Map<String, Object>mZ = new TreeMap<>(mZone);
            cbbZone.removeAllItems();
            mZ.keySet().forEach((s->{
                cbbZone.addItem(s);
            }));
            cbbZone.setSelectedIndex(-1);            
        } catch (Exception e) {
        }
    }
    public void showPack(){
        try {
            //pim.xZone = cbbZone.getSelectedItem().toString().trim();            
            mPack = pim.hmapPack();
            Map<String, Object[]>smap = new TreeMap<>(mPack);
            smap.keySet().forEach((s->{
                cbbPack.addItem(s);
            }));
            cbbPack.setSelectedIndex(-1);            
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
        jPanel2 = new javax.swing.JPanel();
        lblFormName = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        lblZoneNo = new javax.swing.JLabel();
        cbbZone = new javax.swing.JComboBox<>();
        lblPickNo = new javax.swing.JLabel();
        txtPickNo = new javax.swing.JTextField();
        lblPickData = new javax.swing.JLabel();
        txtPickData = new javax.swing.JTextField();
        cbUsed = new javax.swing.JCheckBox();
        btnData = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        lblPack = new javax.swing.JLabel();
        cbbPack = new javax.swing.JComboBox<>();

        setClosable(true);
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Pick.png"))); // NOI18N
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

        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        lblFormName.setFont(new java.awt.Font("Saysettha MX", 1, 18)); // NOI18N
        lblFormName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFormName.setText("Pick");
        lblFormName.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(lblFormName, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(lblFormName, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        jPanel1.add(jPanel2, java.awt.BorderLayout.PAGE_START);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        lblZoneNo.setFont(new java.awt.Font("Saysettha MX", 0, 12)); // NOI18N
        lblZoneNo.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblZoneNo.setText("Zone");
        lblZoneNo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        cbbZone.setEditable(true);
        cbbZone.setFont(new java.awt.Font("Saysettha MX", 0, 12)); // NOI18N
        cbbZone.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cbbZone.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbbZoneMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cbbZoneMouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                cbbZoneMousePressed(evt);
            }
        });
        cbbZone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbZoneActionPerformed(evt);
            }
        });

        lblPickNo.setFont(new java.awt.Font("Saysettha MX", 0, 12)); // NOI18N
        lblPickNo.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblPickNo.setText("Pick Num");
        lblPickNo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        txtPickNo.setFont(new java.awt.Font("Saysettha MX", 0, 12)); // NOI18N
        txtPickNo.setToolTipText("");
        txtPickNo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPickNoKeyReleased(evt);
            }
        });

        lblPickData.setFont(new java.awt.Font("Saysettha MX", 0, 12)); // NOI18N
        lblPickData.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblPickData.setText("Pick Data");
        lblPickData.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        txtPickData.setFont(new java.awt.Font("Saysettha MX", 0, 12)); // NOI18N
        txtPickData.setToolTipText("");

        cbUsed.setBackground(new java.awt.Color(255, 255, 255));
        cbUsed.setFont(new java.awt.Font("Saysettha OT", 0, 12)); // NOI18N
        cbUsed.setText("Used");
        cbUsed.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnData.setBackground(new java.awt.Color(255, 255, 255));
        btnData.setFont(new java.awt.Font("Saysettha MX", 0, 12)); // NOI18N
        btnData.setText("Data");
        btnData.setContentAreaFilled(false);
        btnData.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnData.setOpaque(true);
        btnData.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnDataMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnDataMouseExited(evt);
            }
        });
        btnData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDataActionPerformed(evt);
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

        lblPack.setFont(new java.awt.Font("Saysettha MX", 0, 12)); // NOI18N
        lblPack.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblPack.setText("Pack");
        lblPack.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        cbbPack.setEditable(true);
        cbbPack.setFont(new java.awt.Font("Saysettha MX", 0, 12)); // NOI18N
        cbbPack.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cbbPack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbPackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(lblZoneNo, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbbZone, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(lblPickNo, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtPickNo, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(lblPickData, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbUsed, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(btnData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtPickData, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(lblPack, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbbPack, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblZoneNo)
                    .addComponent(cbbZone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPack)
                    .addComponent(cbbPack, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPickNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPickNo))
                .addGap(2, 2, 2)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPickData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPickData))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbUsed, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnData)
                    .addComponent(btnSave))
                .addGap(90, 90, 90))
        );

        jPanel1.add(jPanel3, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtPickNoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPickNoKeyReleased

    }//GEN-LAST:event_txtPickNoKeyReleased

    private void btnDataMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDataMouseEntered
        try {
            ButtonColor.showButtonEnter(btnData);
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnDataMouseEntered

    private void btnDataMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDataMouseExited
        ButtonColor.showButtonExited(btnData);
    }//GEN-LAST:event_btnDataMouseExited

    private void btnDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDataActionPerformed
        try {
            showClear();
            FrmPickData pd = new FrmPickData(null, closable);
            pd.setVisible(true);
            
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnDataActionPerformed

    private void btnSaveMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaveMouseEntered
        ButtonColor.showButtonEnter(btnSave);
    }//GEN-LAST:event_btnSaveMouseEntered

    private void btnSaveMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaveMouseExited
        ButtonColor.showButtonExited(btnSave);
    }//GEN-LAST:event_btnSaveMouseExited

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        try {            
            if (txtPickNo.getText().equals("")){
                msg.showMsgUnSucess();
                return;
            }
            String indexPack = cbbPack.getSelectedItem().toString();
            String indexZone = cbbZone.getSelectedItem().toString();
            if (PickID==0){
                sql = "Select pik.pickno, pik.PickData from tbl_Pick pik\n" +
                    "left join tbl_Pack pak on pak.PackID = pik.PackID where pik.pickNo = N'"+ txtPickNo.getText() +"' and pak.PackNo = N'"+ indexPack +"'";
                ResultSet rs = c.createStatement().executeQuery(sql);
                if (rs.next()){
                    msg.showMsgSameData();
                }else{
                    MaxIDTbl.maxID("PickID", "Tbl_Pick");                
                    pi.setPickid(MaxIDTbl.getID);
                    pi.setPickNo(txtPickNo.getText());
                    pi.setPickData(txtPickData.getText());                                       
                    pi.setPackID(Integer.parseInt(mPack.get(indexPack)[0].toString()));
                    pi.setZoneid(Integer.parseInt(mZone.get(indexZone)[0].toString()));
                    pi.setUsed(cbUsed.isSelected());
                    pim.insertTbl_Pick(pi);
                    msg.showMsgSucess();
                }                
            }else{
                showMapZone();
                showPack();
                pi.setPickid(PickID);
                pi.setPickNo(txtPickNo.getText());
                pi.setPickData(txtPickData.getText());
                pi.setPackID(Integer.parseInt(mPack.get(indexPack)[0].toString()));
                pi.setZoneid(Integer.parseInt(mZone.get(indexZone)[0].toString()));
                pi.setUsed(cbUsed.isSelected());
                pim.updateTbl_Pick(pi);
                msg.showMsgSucess();
                showClear();                
                
            }            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        try {
            showLang();           
            showMapZone();
            showPack();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_formInternalFrameOpened

    private void cbbZoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbZoneActionPerformed
        
    }//GEN-LAST:event_cbbZoneActionPerformed

    private void cbbZoneMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbbZoneMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbZoneMouseEntered

    private void cbbPackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbPackActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbPackActionPerformed

    private void cbbZoneMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbbZoneMouseClicked
        
    }//GEN-LAST:event_cbbZoneMouseClicked

    private void cbbZoneMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbbZoneMousePressed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_cbbZoneMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnData;
    private javax.swing.JButton btnSave;
    public static javax.swing.JCheckBox cbUsed;
    public static javax.swing.JComboBox<String> cbbPack;
    public static javax.swing.JComboBox<String> cbbZone;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lblFormName;
    private javax.swing.JLabel lblPack;
    private javax.swing.JLabel lblPickData;
    private javax.swing.JLabel lblPickNo;
    private javax.swing.JLabel lblZoneNo;
    public static javax.swing.JTextField txtPickData;
    public static javax.swing.JTextField txtPickNo;
    // End of variables declaration//GEN-END:variables
}
