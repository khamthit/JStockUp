/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import Data.ButtonColor;
import java.sql.*;
import javax.swing.table.DefaultTableModel;
import model.TableHeader;
import model.Vendor;
import modelManager.LangType;
import static modelManager.LangType.LN;
import modelManager.VendorManager;
import sysConnect.module;

public class FrmVendorData extends javax.swing.JDialog {

    Connection c = module.getConnection();
    String sql, frm;
    DefaultTableModel model = new DefaultTableModel();
    Vendor v = new Vendor();
    VendorManager vm = new VendorManager();
    public FrmVendorData(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        frm = this.getClass().getSimpleName();
        model = (DefaultTableModel)jTable1.getModel();
        LangType.showLang();
        LangType.showLangForm();
        TableHeader.TableHeader_0(jTable1, frm);
        TableHeader.TableHeaderFont(jTable1);        
    }
    public void showLang(){
        try {
            lblFormName.setText(LangType.hmapForm.get(frm.toUpperCase())[LN]);
            btnData.setText(LangType.hmapSys.get("btnData".concat(frm).toUpperCase())[LN]);
            lblSearch.setText(LangType.hmapSys.get("lblSearch".concat(frm).toUpperCase())[LN]);                       
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
        lblFormName = new javax.swing.JLabel();
        lblSearch = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        btnData = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        lblFormName.setFont(new java.awt.Font("Saysettha MX", 1, 18)); // NOI18N
        lblFormName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFormName.setText("Vendor Data");
        lblFormName.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        lblSearch.setFont(new java.awt.Font("Saysettha MX", 0, 12)); // NOI18N
        lblSearch.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblSearch.setText("Search");
        lblSearch.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        txtSearch.setFont(new java.awt.Font("Saysettha MX", 0, 12)); // NOI18N
        txtSearch.setToolTipText("");
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });

        btnData.setBackground(new java.awt.Color(255, 255, 255));
        btnData.setFont(new java.awt.Font("Saysettha MX", 0, 12)); // NOI18N
        btnData.setText("Refresh");
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblFormName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnData, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(251, 251, 251)))
                .addGap(2, 2, 2))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(lblFormName, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSearch)
                    .addComponent(btnData))
                .addGap(2, 2, 2))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new java.awt.BorderLayout());

        jTable1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jTable1.setFont(new java.awt.Font("Saysettha MX", 0, 10)); // NOI18N
        jTable1.setForeground(new java.awt.Color(0, 51, 255));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "lblVendorNo", "lblvendorUsing", "lblVendor", "lblPhone1", "lblPhone2", "lblFax", "lblEmail", "lblWebSite", "lblPostalCode", "lblBankName", "lblBankAccount", "lblCreateVendor", "lblAddress"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Boolean.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, false, false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jTable1.setRowHeight(30);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setMinWidth(0);
            jTable1.getColumnModel().getColumn(0).setMaxWidth(0);
            jTable1.getColumnModel().getColumn(1).setMinWidth(80);
            jTable1.getColumnModel().getColumn(1).setMaxWidth(80);
            jTable1.getColumnModel().getColumn(2).setMinWidth(150);
            jTable1.getColumnModel().getColumn(2).setMaxWidth(150);
            jTable1.getColumnModel().getColumn(3).setMinWidth(90);
            jTable1.getColumnModel().getColumn(3).setMaxWidth(90);
            jTable1.getColumnModel().getColumn(4).setMinWidth(90);
            jTable1.getColumnModel().getColumn(4).setMaxWidth(90);
            jTable1.getColumnModel().getColumn(5).setMinWidth(90);
            jTable1.getColumnModel().getColumn(5).setMaxWidth(90);
            jTable1.getColumnModel().getColumn(6).setMinWidth(150);
            jTable1.getColumnModel().getColumn(6).setMaxWidth(150);
            jTable1.getColumnModel().getColumn(7).setMinWidth(150);
            jTable1.getColumnModel().getColumn(7).setMaxWidth(150);
            jTable1.getColumnModel().getColumn(8).setMinWidth(120);
            jTable1.getColumnModel().getColumn(8).setMaxWidth(120);
            jTable1.getColumnModel().getColumn(9).setMinWidth(120);
            jTable1.getColumnModel().getColumn(9).setMaxWidth(120);
            jTable1.getColumnModel().getColumn(10).setMinWidth(120);
            jTable1.getColumnModel().getColumn(10).setMaxWidth(120);
            jTable1.getColumnModel().getColumn(11).setMinWidth(90);
            jTable1.getColumnModel().getColumn(11).setMaxWidth(90);
            jTable1.getColumnModel().getColumn(12).setMinWidth(300);
            jTable1.getColumnModel().getColumn(12).setMaxWidth(300);
        }

        jPanel2.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        try {
            vm.showSearchTbl_Vendor(jTable1, model, txtSearch.getText().trim());
        } catch (Exception e) {
        }
    }//GEN-LAST:event_txtSearchKeyReleased

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
       vm.showTbl_Vendor(jTable1, model);
    }//GEN-LAST:event_btnDataActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        
    }//GEN-LAST:event_jTable1MouseClicked

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        try {
            showLang();
            vm.showTbl_Vendor(jTable1, model);
        } catch (Exception e) {
        }
    }//GEN-LAST:event_formWindowOpened

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmVendorData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmVendorData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmVendorData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmVendorData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FrmVendorData dialog = new FrmVendorData(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnData;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblFormName;
    private javax.swing.JLabel lblSearch;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
