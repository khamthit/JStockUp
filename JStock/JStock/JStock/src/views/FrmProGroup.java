/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import Data.ButtonColor;

/**
 *
 * @author Admin
 */
public class FrmProGroup extends javax.swing.JInternalFrame {

    /**
     * Creates new form FrmProGroup
     */
    public FrmProGroup() {
        initComponents();
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
        lblUnitL1 = new javax.swing.JLabel();
        txtgroupL1 = new javax.swing.JTextField();
        lblUnitL2 = new javax.swing.JLabel();
        txtGroupL2 = new javax.swing.JTextField();
        btnData = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        lblUnitInfo = new javax.swing.JLabel();
        txtgroup_Descriptions = new javax.swing.JTextField();

        setClosable(true);
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/ProductGroup.png"))); // NOI18N

        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        lblFormName.setFont(new java.awt.Font("Saysettha MX", 1, 18)); // NOI18N
        lblFormName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFormName.setText("Group");
        lblFormName.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(lblFormName, javax.swing.GroupLayout.DEFAULT_SIZE, 383, Short.MAX_VALUE)
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

        lblUnitL1.setFont(new java.awt.Font("Saysettha MX", 0, 12)); // NOI18N
        lblUnitL1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblUnitL1.setText("GroupL1");
        lblUnitL1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        txtgroupL1.setFont(new java.awt.Font("Saysettha MX", 0, 12)); // NOI18N
        txtgroupL1.setToolTipText("");
        txtgroupL1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtgroupL1KeyReleased(evt);
            }
        });

        lblUnitL2.setFont(new java.awt.Font("Saysettha MX", 0, 12)); // NOI18N
        lblUnitL2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblUnitL2.setText("GroupL2");
        lblUnitL2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        txtGroupL2.setFont(new java.awt.Font("Saysettha MX", 0, 12)); // NOI18N
        txtGroupL2.setToolTipText("");

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

        lblUnitInfo.setFont(new java.awt.Font("Saysettha MX", 0, 12)); // NOI18N
        lblUnitInfo.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblUnitInfo.setText("GroupInfo");
        lblUnitInfo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        txtgroup_Descriptions.setFont(new java.awt.Font("Saysettha MX", 0, 12)); // NOI18N
        txtgroup_Descriptions.setToolTipText("");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(lblUnitInfo, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtgroup_Descriptions, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(lblUnitL1, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                                    .addComponent(lblUnitL2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtgroupL1, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
                                    .addComponent(txtGroupL2)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(btnData, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtgroupL1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblUnitL1))
                .addGap(2, 2, 2)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtGroupL2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblUnitL2))
                .addGap(2, 2, 2)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtgroup_Descriptions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblUnitInfo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnData)
                    .addComponent(btnSave))
                .addGap(103, 103, 103))
        );

        jPanel1.add(jPanel3, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtgroupL1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtgroupL1KeyReleased

    }//GEN-LAST:event_txtgroupL1KeyReleased

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
        
    }//GEN-LAST:event_btnDataActionPerformed

    private void btnSaveMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaveMouseEntered
        ButtonColor.showButtonEnter(btnSave);
    }//GEN-LAST:event_btnSaveMouseEntered

    private void btnSaveMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaveMouseExited
        ButtonColor.showButtonExited(btnSave);
    }//GEN-LAST:event_btnSaveMouseExited

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        
    }//GEN-LAST:event_btnSaveActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnData;
    private javax.swing.JButton btnSave;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lblFormName;
    private javax.swing.JLabel lblUnitInfo;
    private javax.swing.JLabel lblUnitL1;
    private javax.swing.JLabel lblUnitL2;
    public static javax.swing.JTextField txtGroupL2;
    public static javax.swing.JTextField txtgroupL1;
    public static javax.swing.JTextField txtgroup_Descriptions;
    // End of variables declaration//GEN-END:variables
}
