/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import Data.ButtonColor;
import com.l2fprod.common.swing.renderer.DefaultCellRenderer;
import java.sql.*;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;
import model.Purchase;
import model.TableHeader;
import modelManager.LangType;
import static modelManager.LangType.LN;
import modelManager.PurchaseeManager;
import sysConnect.module;

/**
 *
 * @author Admin
 */
public class FrmPurchaseOrderAddDetails extends javax.swing.JDialog {

    Connection c = module.getConnection();
    String frm,sql;
    DefaultTableModel model = new DefaultTableModel();
    public static String Actid;
    Purchase pc = new Purchase();
    PurchaseeManager pcm = new PurchaseeManager();
    public FrmPurchaseOrderAddDetails(java.awt.Frame parent, boolean modal, String xy) {
        super(parent, modal);
        initComponents();
        frm = this.getClass().getSimpleName();
        model = (DefaultTableModel)jTable1.getModel();
        LangType.showLang();
        LangType.showLangForm();
        lblPONumber.setText(Actid); 
        TableHeader.TableHeaderFont(jTable1);
        TableHeader.TableHeader_0(jTable1, frm);
        DefaultCellRenderer cellRender = new DefaultCellRenderer();
        cellRender.setHorizontalAlignment(JLabel.CENTER);
        jTable1.getColumnModel().getColumn(4).setCellRenderer(cellRender);
        jTable1.getColumnModel().getColumn(5).setCellRenderer(cellRender);
        jTable1.getColumnModel().getColumn(6).setCellRenderer(cellRender);
    }
    public void showLang(){
        try {
            lblFormName.setText(LangType.hmapForm.get(frm.toUpperCase())[LN]);
            btnFinished.setText(LangType.hmapSys.get("btnfinished".concat(frm).toUpperCase())[LN]);
            lblPONO.setText(LangType.hmapSys.get("lblpono".concat(frm).toUpperCase())[LN]);       
            lblCount.setText(LangType.hmapSys.get("lblCount".concat(frm).toUpperCase())[LN]);
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
        lblPONO = new javax.swing.JLabel();
        btnFinished = new javax.swing.JButton();
        lblPONumber = new javax.swing.JLabel();
        lblCount = new javax.swing.JLabel();
        lblCountTotal = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        lblFormName.setFont(new java.awt.Font("Saysettha MX", 1, 18)); // NOI18N
        lblFormName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFormName.setText("PO Details");
        lblFormName.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        lblPONO.setFont(new java.awt.Font("Saysettha MX", 0, 12)); // NOI18N
        lblPONO.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblPONO.setText("PO Number");
        lblPONO.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnFinished.setBackground(new java.awt.Color(255, 255, 255));
        btnFinished.setFont(new java.awt.Font("Saysettha MX", 0, 12)); // NOI18N
        btnFinished.setText("Finish");
        btnFinished.setContentAreaFilled(false);
        btnFinished.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnFinished.setOpaque(true);
        btnFinished.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnFinishedMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnFinishedMouseExited(evt);
            }
        });
        btnFinished.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinishedActionPerformed(evt);
            }
        });

        lblPONumber.setFont(new java.awt.Font("Saysettha MX", 1, 12)); // NOI18N
        lblPONumber.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblPONumber.setText("PO Number");
        lblPONumber.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        lblCount.setFont(new java.awt.Font("Saysettha MX", 0, 12)); // NOI18N
        lblCount.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblCount.setText("Count");
        lblCount.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        lblCountTotal.setFont(new java.awt.Font("Saysettha MX", 1, 12)); // NOI18N
        lblCountTotal.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblCountTotal.setText("0");
        lblCountTotal.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblFormName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblPONO, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblPONumber, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblCount, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblCountTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnFinished, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addGap(2, 2, 2))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(lblFormName, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPONO)
                    .addComponent(btnFinished)
                    .addComponent(lblPONumber)
                    .addComponent(lblCount)
                    .addComponent(lblCountTotal))
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
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Barcode", "Barcode", "PackBarcode", "Product", "Qty", "Price", "TotalPrice"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
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
            jTable1.getColumnModel().getColumn(1).setMinWidth(100);
            jTable1.getColumnModel().getColumn(1).setMaxWidth(100);
            jTable1.getColumnModel().getColumn(2).setMinWidth(100);
            jTable1.getColumnModel().getColumn(2).setMaxWidth(100);
            jTable1.getColumnModel().getColumn(3).setMinWidth(150);
            jTable1.getColumnModel().getColumn(3).setMaxWidth(150);
            jTable1.getColumnModel().getColumn(4).setMinWidth(80);
            jTable1.getColumnModel().getColumn(4).setMaxWidth(80);
            jTable1.getColumnModel().getColumn(5).setMinWidth(80);
            jTable1.getColumnModel().getColumn(5).setMaxWidth(80);
            jTable1.getColumnModel().getColumn(6).setMinWidth(80);
            jTable1.getColumnModel().getColumn(6).setMaxWidth(80);
        }

        jPanel2.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnFinishedMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFinishedMouseEntered
        try {
            ButtonColor.showButtonEnter(btnFinished);
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnFinishedMouseEntered

    private void btnFinishedMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFinishedMouseExited
        ButtonColor.showButtonExited(btnFinished);
    }//GEN-LAST:event_btnFinishedMouseExited

    private void btnFinishedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinishedActionPerformed
        try {
            pc.setActNo(lblPONumber.getText().trim());
            pcm.updateActiviting(pc);
            dispose();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnFinishedActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
       
    }//GEN-LAST:event_jTable1MouseClicked

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        try {
            dispose();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_formWindowClosed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        try {
            showLang();
            pcm.showFrmPurchaseOrderAddDetails(jTable1, model, lblPONumber.getText().trim());
            pcm.showCountFrmPurchaseOrderAddDetails(lblPONumber.getText().trim());
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
            java.util.logging.Logger.getLogger(FrmPurchaseOrderAddDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmPurchaseOrderAddDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmPurchaseOrderAddDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmPurchaseOrderAddDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FrmPurchaseOrderAddDetails dialog = new FrmPurchaseOrderAddDetails(new javax.swing.JFrame(), true, null);
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
    private javax.swing.JButton btnFinished;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblCount;
    public static javax.swing.JLabel lblCountTotal;
    private javax.swing.JLabel lblFormName;
    private javax.swing.JLabel lblPONO;
    public static javax.swing.JLabel lblPONumber;
    // End of variables declaration//GEN-END:variables
}
