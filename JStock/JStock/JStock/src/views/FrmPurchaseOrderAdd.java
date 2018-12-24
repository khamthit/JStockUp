/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import Data.ButtonColor;
import Data.ConvertDateSQL;
import Data.Msg;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import model.Purchase;
import model.TableHeader;
import modelManager.LangType;
import static modelManager.LangType.LN;
import modelManager.MaxIDTbl;
import modelManager.PurchaseeManager;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import sysConnect.module;
import java.util.Date;
import org.apache.commons.beanutils.converters.SqlDateConverter;

/**
 *
 * @author Admin
 */
public class FrmPurchaseOrderAdd extends javax.swing.JDialog {

    Connection c = module.getConnection();
    String sql, frm;
    DefaultTableModel model = new DefaultTableModel();
    public static int ACTID = 0;
    Purchase pc = new Purchase();
    PurchaseeManager pcm = new PurchaseeManager();
    HashMap<String, Object[]> hmStock = null;
    HashMap<String, Object[]> hmVendor = null;
    Msg msg = new Msg();

    public FrmPurchaseOrderAdd(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        frm = this.getClass().getSimpleName();
        model = (DefaultTableModel) jTable1.getModel();
        LangType.showLang();
        LangType.showLangForm();
        TableHeader.TableHeaderFont(jTable1);
        TableHeader.TableHeader_0(jTable1, frm);
        TableHeader.TableCellRenderRightFrmPurchaseOrderAdd(jTable1);
    }

    public void showMapStock() {
        try {
            hmStock = pcm.hmapStock();
            Map<String, Object[]> smap = new TreeMap<>(hmStock);
            cbbVendorStock.removeAllItems();
            smap.keySet().forEach((s) -> {
                cbbVendorStock.addItem(s);
            });
            cbbVendorStock.setSelectedIndex(-1);
            AutoCompleteDecorator.decorate(cbbVendorStock);
        } catch (Exception e) {
        }
    }

    public void showMapVendor() {
        try {
            hmVendor = pcm.hmapVendor();
            Map<String, Object[]> smap = new TreeMap<>(hmVendor);
            cbbVendorStock.removeAllItems();
            smap.keySet().forEach((s -> {
                cbbVendorStock.addItem(s);
            }));
            cbbVendorStock.setSelectedIndex(-1);
            AutoCompleteDecorator.decorate(cbbVendorStock);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void showLang() {
        try {
            lblFormName.setText(LangType.hmapForm.get(frm.toUpperCase())[LN]);
            btnData.setText(LangType.hmapSys.get("btnData".concat(frm).toUpperCase())[LN]);
            btnImport.setText(LangType.hmapSys.get("btnimport".concat(frm).toUpperCase())[LN]);
            btnPO.setText(LangType.hmapSys.get("btnPO".concat(frm).toUpperCase())[LN]);
            lblSearch.setText(LangType.hmapSys.get("lblSearch".concat(frm).toUpperCase())[LN]);
            lblStock.setText(LangType.hmapSys.get("lblStock".concat(frm).toUpperCase())[LN]);
            lblChooserVendor.setText(LangType.hmapSys.get("lblchooservendor".concat(frm).toUpperCase())[LN]);

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
        lblSearch = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        btnData = new javax.swing.JButton();
        lblStock = new javax.swing.JCheckBox();
        lblChooserVendor = new javax.swing.JLabel();
        cbbVendorStock = new javax.swing.JComboBox<>();
        btnPO = new javax.swing.JButton();
        btnImport = new javax.swing.JButton();
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
        lblFormName.setText("Purchase Order");
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

        lblStock.setBackground(new java.awt.Color(255, 255, 255));
        lblStock.setFont(new java.awt.Font("Saysettha MX", 0, 12)); // NOI18N
        lblStock.setText("Stock");
        lblStock.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lblStockActionPerformed(evt);
            }
        });

        lblChooserVendor.setFont(new java.awt.Font("Saysettha MX", 0, 12)); // NOI18N
        lblChooserVendor.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblChooserVendor.setText("Choose");
        lblChooserVendor.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        cbbVendorStock.setEditable(true);
        cbbVendorStock.setFont(new java.awt.Font("Saysettha MX", 0, 12)); // NOI18N
        cbbVendorStock.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnPO.setBackground(new java.awt.Color(255, 255, 255));
        btnPO.setFont(new java.awt.Font("Saysettha MX", 0, 12)); // NOI18N
        btnPO.setText("PO");
        btnPO.setContentAreaFilled(false);
        btnPO.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPO.setOpaque(true);
        btnPO.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnPOMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnPOMouseExited(evt);
            }
        });
        btnPO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPOActionPerformed(evt);
            }
        });

        btnImport.setBackground(new java.awt.Color(255, 255, 255));
        btnImport.setFont(new java.awt.Font("Saysettha MX", 0, 12)); // NOI18N
        btnImport.setText("Import");
        btnImport.setContentAreaFilled(false);
        btnImport.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnImport.setOpaque(true);
        btnImport.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnImportMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnImportMouseExited(evt);
            }
        });
        btnImport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImportActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblFormName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(lblStock, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblChooserVendor, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(cbbVendorStock, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(btnPO, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(btnImport, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(lblSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(btnData)))
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
                    .addComponent(btnData)
                    .addComponent(lblStock)
                    .addComponent(lblChooserVendor)
                    .addComponent(cbbVendorStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPO)
                    .addComponent(btnImport))
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
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "choose", "choose", "Barcode", "PackBarcode", "ItemL1", "ItemL2", "Costprice", "qty"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Boolean.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Double.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, false, false, false, false, false, true
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
            jTable1.getColumnModel().getColumn(2).setMinWidth(120);
            jTable1.getColumnModel().getColumn(2).setMaxWidth(120);
            jTable1.getColumnModel().getColumn(3).setMinWidth(120);
            jTable1.getColumnModel().getColumn(3).setMaxWidth(120);
            jTable1.getColumnModel().getColumn(4).setMinWidth(200);
            jTable1.getColumnModel().getColumn(4).setMaxWidth(200);
            jTable1.getColumnModel().getColumn(5).setMinWidth(200);
            jTable1.getColumnModel().getColumn(5).setMaxWidth(200);
            jTable1.getColumnModel().getColumn(6).setMinWidth(80);
            jTable1.getColumnModel().getColumn(6).setMaxWidth(80);
            jTable1.getColumnModel().getColumn(7).setMinWidth(60);
            jTable1.getColumnModel().getColumn(7).setMaxWidth(60);
        }

        jPanel2.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        try {
            pcm.showSearchTbl_Vendor(jTable1, model, txtSearch.getText().trim());
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

    }//GEN-LAST:event_btnDataActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        try {
            int index = jTable1.getSelectedRow();
            Boolean x = (Boolean) jTable1.getValueAt(index, 1);
            if (x == true) {

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void btnPOMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPOMouseEntered
        ButtonColor.showButtonEnter(btnPO);
    }//GEN-LAST:event_btnPOMouseEntered

    private void btnPOMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPOMouseExited
        ButtonColor.showButtonExited(btnPO);
    }//GEN-LAST:event_btnPOMouseExited

    private void btnPOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPOActionPerformed
        try {
            //this is insert activity
            String indx = cbbVendorStock.getSelectedItem().toString();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date dt = new Date();
            String sd = sdf.format(dt);
            Date now = new Date();
            now = sdf.parse(sd);
            MaxIDTbl.maxID("actid", "tbl_activity");
            MaxIDTbl.maxID("actno", "tbl_activity");
            pc.setActid(MaxIDTbl.getID);
            pc.setActNo("0" + MaxIDTbl.getID);
            pc.setActivityCreateDate(ConvertDateSQL.convertUtilDateToSqlDate(now));
            pc.setCreateUser(FrmMain.txtUsername.getText());
            pc.setActivityRec_type("PO");
            pcm.insertActivity(pc);
            int row = jTable1.getRowCount();
            for (int i = 0; i < row; i++) {
                Boolean ch = (Boolean) jTable1.getValueAt(i, 1);
                if (ch == true) {
                    MaxIDTbl.maxID("Actdid", "tbl_activityDetails");
                    pc.setItid(Integer.parseInt(jTable1.getValueAt(i, 0).toString()));
                    pc.setVenid(Integer.parseInt(hmVendor.get(indx)[0].toString()));
                    pc.setBarcode(jTable1.getValueAt(i, 2).toString().trim());
                    pc.setPackbarcode(jTable1.getValueAt(i, 3).toString().trim());
                    pc.setItem_l1(jTable1.getValueAt(i, 4).toString().trim());
                    pc.setItem_l2(jTable1.getValueAt(i, 5).toString().trim());
                    pc.setCostprice(Float.parseFloat(jTable1.getValueAt(i, 6).toString()));
                    pc.setQty(Float.parseFloat(jTable1.getValueAt(i, 7).toString()));
                    pc.setActivityRec_type("PO");
                    pc.setActiviing(true);
                    pc.setActdid(MaxIDTbl.getID);
                    pcm.insertActivityDetails(pc);
                }
            }
            pcm.showTbl_Vendor(jTable1, model);
            String x = "";
            x = pc.getActNo();
            FrmPurchaseOrderAddDetails.Actid = x;
            if (x.equals("")){
                msg.showMsgWarming();
            }else{
                FrmPurchaseOrderAddDetails fad = new FrmPurchaseOrderAddDetails(null, true, x);
                fad.setVisible(true);
            }
            
        } catch (Exception e) {
            //e.printStackTrace();
        }
    }//GEN-LAST:event_btnPOActionPerformed

    private void btnImportMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnImportMouseEntered
        ButtonColor.showButtonEnter(btnImport);
    }//GEN-LAST:event_btnImportMouseEntered

    private void btnImportMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnImportMouseExited
        ButtonColor.showButtonExited(btnImport);
    }//GEN-LAST:event_btnImportMouseExited

    private void btnImportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImportActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnImportActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        try {
            showLang();
            pcm.showTbl_Vendor(jTable1, model);
            showMapVendor();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_formWindowOpened

    private void lblStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lblStockActionPerformed
        try {
            if (lblStock.isSelected() == true) {
                showMapStock();
                pcm.showTbl_Vendor(jTable1, model);
            } else {
                showMapVendor();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_lblStockActionPerformed

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
            java.util.logging.Logger.getLogger(FrmPurchaseOrderAdd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmPurchaseOrderAdd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmPurchaseOrderAdd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmPurchaseOrderAdd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FrmPurchaseOrderAdd dialog = new FrmPurchaseOrderAdd(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnImport;
    private javax.swing.JButton btnPO;
    private javax.swing.JComboBox<String> cbbVendorStock;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblChooserVendor;
    private javax.swing.JLabel lblFormName;
    private javax.swing.JLabel lblSearch;
    private javax.swing.JCheckBox lblStock;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
