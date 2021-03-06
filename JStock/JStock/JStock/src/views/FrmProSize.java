/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.sql.*;
import modelManager.LangType;
import static modelManager.LangType.LN;
import sysConnect.module;
import Data.ButtonColor;
import Data.Msg;
import model.ProSize;
import modelManager.MaxIDTbl;
import modelManager.ProSizeManager;

public class FrmProSize extends javax.swing.JInternalFrame {

    Connection c = module.getConnection();
    String sql, frm;
    ProSize ps = new ProSize();
    ProSizeManager psm = new ProSizeManager();
    Msg msg = new Msg();
    public static int prosizeid = 0;

    public FrmProSize() {
        initComponents();
        frm = this.getClass().getSimpleName();
        LangType.showLang();
        LangType.showLangForm();

    }
    public void showClear(){
        try {
            prosizeid=0;
            txtsize.setText("");
            txtsizeDes.setText("");
            txtsize.requestFocus();
        } catch (Exception e) {
        }
    }
    public void showLang() {
        try {
            lblFormName.setText(LangType.hmapForm.get(frm.toUpperCase())[LN]);
            lblSizeName.setText(LangType.hmapSys.get("lblSizeName".concat(frm).toUpperCase())[LN]);
            lblSizeDecriptions.setText(LangType.hmapSys.get("lblSizeDecriptions".concat(frm).toUpperCase())[LN]);
            btnData.setText(LangType.hmapSys.get("btnData".concat(frm).toUpperCase())[LN]);
            btnSave.setText(LangType.hmapSys.get("btnsave".concat(frm).toUpperCase())[LN]);

        } catch (Exception e) {
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
        lblSizeName = new javax.swing.JLabel();
        txtsize = new javax.swing.JTextField();
        lblSizeDecriptions = new javax.swing.JLabel();
        txtsizeDes = new javax.swing.JTextField();
        btnData = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();

        setClosable(true);
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/ProSize.png"))); // NOI18N
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
        lblFormName.setText("Size");
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

        lblSizeName.setFont(new java.awt.Font("Saysettha MX", 0, 12)); // NOI18N
        lblSizeName.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblSizeName.setText("Size");
        lblSizeName.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        txtsize.setFont(new java.awt.Font("Saysettha MX", 0, 12)); // NOI18N
        txtsize.setToolTipText("");
        txtsize.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtsizeKeyReleased(evt);
            }
        });

        lblSizeDecriptions.setFont(new java.awt.Font("Saysettha MX", 0, 12)); // NOI18N
        lblSizeDecriptions.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblSizeDecriptions.setText("Size Descriptions");
        lblSizeDecriptions.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        txtsizeDes.setFont(new java.awt.Font("Saysettha MX", 0, 12)); // NOI18N
        txtsizeDes.setToolTipText("");

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

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(157, 157, 157)
                .addComponent(btnData, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(lblSizeName, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtsize, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(lblSizeDecriptions, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtsizeDes, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtsize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSizeName))
                .addGap(2, 2, 2)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtsizeDes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSizeDecriptions))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnData)
                    .addComponent(btnSave))
                .addContainerGap())
        );

        jPanel1.add(jPanel3, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtsizeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtsizeKeyReleased

    }//GEN-LAST:event_txtsizeKeyReleased

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
            FrmProSizeData ps = new FrmProSizeData(null, closable);
            ps.setVisible(true);
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
            if (txtsize.getText().equals("")){
                msg.showMsgWarming();
                return;
            }
            ps.setProSizeDescriptions(txtsizeDes.getText());
            ps.setProSizeName(txtsize.getText());
            if (prosizeid == 0) {
                sql = "Select SizeName from tbl_Prosize where sizename = N'" + txtsize.getText().trim() + "'";
                ResultSet rs = c.createStatement().executeQuery(sql);
                if (rs.next()) {
                    msg.showMsgSameData();
                } else {
                    MaxIDTbl.maxID("PSizeID", "tbl_ProSize");
                    ps.setProSizeID(MaxIDTbl.getID);
                    psm.InsertTblProSize(ps);
                    showClear();
                }

            } else {
                ps.setProSizeID(prosizeid);
                psm.updateTblProSize(ps);
                showClear();
                

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        try {
            showLang();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_formInternalFrameOpened


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnData;
    private javax.swing.JButton btnSave;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lblFormName;
    private javax.swing.JLabel lblSizeDecriptions;
    private javax.swing.JLabel lblSizeName;
    public static javax.swing.JTextField txtsize;
    public static javax.swing.JTextField txtsizeDes;
    // End of variables declaration//GEN-END:variables
}
