/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import Data.ButtonColor;
import java.awt.Image;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import model.Item;
import modelManager.ItemManager;
import modelManager.LangType;
import static modelManager.LangType.LN;
import sysConnect.module;
import Data.ResizeScall;
import static Data.ResizeScall.ResizeScall;
public class FrmItemAdd extends javax.swing.JDialog {
    Connection c = module.getConnection();
    String sql, frm;
    Image ic;
    Item it = new Item();
    ItemManager itm = new ItemManager();
    HashMap<String, Object[]>hmGroup = null;
    HashMap<String, Object[]>hmCate = null;
    HashMap<String, Object[]>hmUnit = null;
    HashMap<String, Object[]>hmSize = null;
    HashMap<String, Object[]>hmZone = null;
    HashMap<String, Object[]>hmPack = null;
    HashMap<String, Object[]>hmPick = null;
    
    public FrmItemAdd(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        frm = this.getClass().getSimpleName();
        LangType.showLang();
        LangType.showLangForm();
        
    }
    public void showLang(){
        try {
            lblFormName.setText(LangType.hmapForm.get(frm.toUpperCase())[LN]);
            btnSave.setText(LangType.hmapSys.get("btnsave".concat(frm).toUpperCase())[LN]);
            btnBrowse.setText(LangType.hmapSys.get("btnBrowse".concat(frm).toUpperCase())[LN]);
            lblBarcode.setText(LangType.hmapSys.get("lblbarcode".concat(frm).toUpperCase())[LN]);
            lblPackBarcode.setText(LangType.hmapSys.get("lblpackbarcode".concat(frm).toUpperCase())[LN]);
            lblItem_L1.setText(LangType.hmapSys.get("lblitem_l1".concat(frm).toUpperCase())[LN]);
            lblItem_L2.setText(LangType.hmapSys.get("lblItem_l2".concat(frm).toUpperCase())[LN]);
            lblGroup.setText(LangType.hmapSys.get("lblgroup".concat(frm).toUpperCase())[LN]);
            lblCategory.setText(LangType.hmapSys.get("lblCategory".concat(frm).toUpperCase())[LN]);
            lblUnit.setText(LangType.hmapSys.get("lblunit".concat(frm).toUpperCase())[LN]);
            lblSize.setText(LangType.hmapSys.get("lblsize".concat(frm).toUpperCase())[LN]);
            lblZone.setText(LangType.hmapSys.get("lblzone".concat(frm).toUpperCase())[LN]);
            lblPack.setText(LangType.hmapSys.get("lblpack".concat(frm).toUpperCase())[LN]);
            lblPick.setText(LangType.hmapSys.get("lblPick".concat(frm).toUpperCase())[LN]);
            
            
            
        } catch (Exception e) {
        }
    }
    public void showMapGroup(){
        try {
            hmGroup = itm.hmapGroup();
            Map<String, Object>smap = new TreeMap<>(hmGroup);
            cbbGroup.removeAllItems();
            smap.keySet().forEach((s)->{
               cbbGroup.addItem(s);
            });
            cbbGroup.setSelectedIndex(-1);
        } catch (Exception e) {
        }
    }
    public void showMapCategory(){
        try {
            hmCate = itm.hmapCategory();
            Map<String, Object>smap = new TreeMap<>(hmCate);
            cbbCategory.removeAllItems();
            smap.keySet().forEach((s->{
                cbbCategory.addItem(s);
            }));
            cbbCategory.setSelectedIndex(-1);
        } catch (Exception e) {
        }
    }
    public void showMapUnit(){
        try {
            hmUnit = itm.hmapUnit();
            Map<String, Object>smap = new TreeMap<>(hmUnit);
            cbbUnit.removeAllItems();
            smap.keySet().forEach((s->{
                cbbUnit.addItem(s);
            }));
            cbbUnit.setSelectedIndex(-1);            
        } catch (Exception e) {
        }
    }
    public void showMapSize(){
        try {
            hmSize= itm.hmapSize();
            Map<String, Object>smap = new TreeMap<>(hmSize);
            cbbSize.removeAllItems();
            smap.keySet().forEach((s->{
                cbbSize.addItem(s);
            }));
            cbbSize.setSelectedIndex(-1);
        } catch (Exception e) {
        }
    }
    public void showMapZone(){
        try {
            hmZone = itm.hmapZone();
            Map<String, Object[]>smap = new TreeMap<>(hmZone);
            cbbZone.removeAllItems();
            smap.keySet().forEach((s->{
                cbbZone.addItem(s);
            }));
            cbbZone.setSelectedIndex(-1);
        } catch (Exception e) {
        }
    }
    public void showMapPack(){
        try {
            hmPack = itm.hmapPack();
            Map<String, Object>smap = new TreeMap<>(hmPack);
            cbbPack.removeAllItems();
            smap.keySet().forEach((s->{
                cbbPack.addItem(s);
            }));
            cbbPack.setSelectedIndex(-1);
        } catch (Exception e) {
        }
    }
    public void showMapPick(){
        try {
            hmPick = itm.hmapPick();
            Map<String, Object>smap = new TreeMap<>(hmPick);
            cbbPick.removeAllItems();
            smap.keySet().forEach((s->{
                cbbPick.addItem(s);
            }));
            cbbPick.setSelectedIndex(-1);
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
        jPanel3 = new javax.swing.JPanel();
        lblImage = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        lblGroup = new javax.swing.JLabel();
        cbbGroup = new javax.swing.JComboBox<>();
        lblCategory = new javax.swing.JLabel();
        cbbCategory = new javax.swing.JComboBox<>();
        lblUnit = new javax.swing.JLabel();
        cbbUnit = new javax.swing.JComboBox<>();
        lblSize = new javax.swing.JLabel();
        cbbSize = new javax.swing.JComboBox<>();
        lblZone = new javax.swing.JLabel();
        cbbZone = new javax.swing.JComboBox<>();
        lblPack = new javax.swing.JLabel();
        cbbPack = new javax.swing.JComboBox<>();
        lblPick = new javax.swing.JLabel();
        cbbPick = new javax.swing.JComboBox<>();
        btnSave = new javax.swing.JButton();
        lblBarcode = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        lblPackBarcode = new javax.swing.JLabel();
        txtSearch1 = new javax.swing.JTextField();
        lblItem_L1 = new javax.swing.JLabel();
        txtSearch2 = new javax.swing.JTextField();
        lblItem_L2 = new javax.swing.JLabel();
        txtSearch3 = new javax.swing.JTextField();
        btnBrowse = new javax.swing.JButton();

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
        lblFormName.setText("Add Item");
        lblFormName.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblFormName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 489, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(lblFormName, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        lblImage.setFont(new java.awt.Font("Saysettha MX", 0, 10)); // NOI18N
        lblImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblImage.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        lblImage.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(lblImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(lblImage, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        lblGroup.setFont(new java.awt.Font("Saysettha MX", 0, 12)); // NOI18N
        lblGroup.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblGroup.setText("Group");
        lblGroup.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        cbbGroup.setEditable(true);
        cbbGroup.setFont(new java.awt.Font("Saysettha MX", 0, 12)); // NOI18N
        cbbGroup.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cbbGroup.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbbGroupMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cbbGroupMouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                cbbGroupMousePressed(evt);
            }
        });
        cbbGroup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbGroupActionPerformed(evt);
            }
        });

        lblCategory.setFont(new java.awt.Font("Saysettha MX", 0, 12)); // NOI18N
        lblCategory.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblCategory.setText("Category");
        lblCategory.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        cbbCategory.setEditable(true);
        cbbCategory.setFont(new java.awt.Font("Saysettha MX", 0, 12)); // NOI18N
        cbbCategory.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cbbCategory.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbbCategoryMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cbbCategoryMouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                cbbCategoryMousePressed(evt);
            }
        });
        cbbCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbCategoryActionPerformed(evt);
            }
        });

        lblUnit.setFont(new java.awt.Font("Saysettha MX", 0, 12)); // NOI18N
        lblUnit.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblUnit.setText("Unit");
        lblUnit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        cbbUnit.setEditable(true);
        cbbUnit.setFont(new java.awt.Font("Saysettha MX", 0, 12)); // NOI18N
        cbbUnit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cbbUnit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbbUnitMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cbbUnitMouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                cbbUnitMousePressed(evt);
            }
        });
        cbbUnit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbUnitActionPerformed(evt);
            }
        });

        lblSize.setFont(new java.awt.Font("Saysettha MX", 0, 12)); // NOI18N
        lblSize.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblSize.setText("Size");
        lblSize.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        cbbSize.setEditable(true);
        cbbSize.setFont(new java.awt.Font("Saysettha MX", 0, 12)); // NOI18N
        cbbSize.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cbbSize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbbSizeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cbbSizeMouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                cbbSizeMousePressed(evt);
            }
        });
        cbbSize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbSizeActionPerformed(evt);
            }
        });

        lblZone.setFont(new java.awt.Font("Saysettha MX", 0, 12)); // NOI18N
        lblZone.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblZone.setText("Zone");
        lblZone.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

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

        lblPack.setFont(new java.awt.Font("Saysettha MX", 0, 12)); // NOI18N
        lblPack.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblPack.setText("Pack");
        lblPack.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        cbbPack.setEditable(true);
        cbbPack.setFont(new java.awt.Font("Saysettha MX", 0, 12)); // NOI18N
        cbbPack.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cbbPack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbbPackMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cbbPackMouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                cbbPackMousePressed(evt);
            }
        });
        cbbPack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbPackActionPerformed(evt);
            }
        });

        lblPick.setFont(new java.awt.Font("Saysettha MX", 0, 12)); // NOI18N
        lblPick.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblPick.setText("Pick");
        lblPick.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        cbbPick.setEditable(true);
        cbbPick.setFont(new java.awt.Font("Saysettha MX", 0, 12)); // NOI18N
        cbbPick.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cbbPick.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbbPickMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cbbPickMouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                cbbPickMousePressed(evt);
            }
        });
        cbbPick.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbPickActionPerformed(evt);
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

        lblBarcode.setFont(new java.awt.Font("Saysettha MX", 0, 12)); // NOI18N
        lblBarcode.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblBarcode.setText("Barcode");
        lblBarcode.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        txtSearch.setFont(new java.awt.Font("Saysettha MX", 0, 12)); // NOI18N
        txtSearch.setToolTipText("");
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });

        lblPackBarcode.setFont(new java.awt.Font("Saysettha MX", 0, 12)); // NOI18N
        lblPackBarcode.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblPackBarcode.setText("Pack Barcode");
        lblPackBarcode.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        txtSearch1.setFont(new java.awt.Font("Saysettha MX", 0, 12)); // NOI18N
        txtSearch1.setToolTipText("");
        txtSearch1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearch1KeyReleased(evt);
            }
        });

        lblItem_L1.setFont(new java.awt.Font("Saysettha MX", 0, 12)); // NOI18N
        lblItem_L1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblItem_L1.setText("Item Name L1");
        lblItem_L1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        txtSearch2.setFont(new java.awt.Font("Saysettha MX", 0, 12)); // NOI18N
        txtSearch2.setToolTipText("");
        txtSearch2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearch2KeyReleased(evt);
            }
        });

        lblItem_L2.setFont(new java.awt.Font("Saysettha MX", 0, 12)); // NOI18N
        lblItem_L2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblItem_L2.setText("Item Name L2");
        lblItem_L2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        txtSearch3.setFont(new java.awt.Font("Saysettha MX", 0, 12)); // NOI18N
        txtSearch3.setToolTipText("");
        txtSearch3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearch3KeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSave, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblItem_L1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblPackBarcode, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblBarcode, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(lblItem_L2, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtSearch3, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                                    .addComponent(txtSearch2)
                                    .addComponent(txtSearch)
                                    .addComponent(txtSearch1)))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(lblPick, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbbPick, 0, 190, Short.MAX_VALUE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(lblPack, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbbPack, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(lblZone, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbbZone, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(lblSize, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbbSize, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(lblUnit, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbbUnit, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(lblGroup, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(8, 8, 8))
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(lblCategory, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbbGroup, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cbbCategory, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblBarcode))
                .addGap(2, 2, 2)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearch1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPackBarcode))
                .addGap(2, 2, 2)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearch2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblItem_L1))
                .addGap(2, 2, 2)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearch3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblItem_L2))
                .addGap(2, 2, 2)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblGroup)
                    .addComponent(cbbGroup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCategory)
                    .addComponent(cbbCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUnit)
                    .addComponent(cbbUnit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSize)
                    .addComponent(cbbSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblZone)
                    .addComponent(cbbZone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPack)
                    .addComponent(cbbPack, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPick)
                    .addComponent(cbbPick, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addComponent(btnSave)
                .addGap(2, 2, 2))
        );

        btnBrowse.setBackground(new java.awt.Color(255, 255, 255));
        btnBrowse.setFont(new java.awt.Font("Saysettha MX", 0, 12)); // NOI18N
        btnBrowse.setText("Browse");
        btnBrowse.setContentAreaFilled(false);
        btnBrowse.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBrowse.setOpaque(true);
        btnBrowse.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnBrowseMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnBrowseMouseExited(evt);
            }
        });
        btnBrowse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBrowseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnBrowse, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE))
                .addGap(2, 2, 2)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(btnBrowse)
                        .addGap(0, 0, 0))))
        );

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        try {
            showLang();
            showMapGroup();
            showMapCategory();
            showMapUnit();
            showMapSize();
            showMapZone();
            showMapPack();
            showMapPick();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_formWindowOpened

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased

    }//GEN-LAST:event_txtSearchKeyReleased

    private void txtSearch1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearch1KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearch1KeyReleased

    private void txtSearch2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearch2KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearch2KeyReleased

    private void txtSearch3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearch3KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearch3KeyReleased

    private void btnBrowseMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBrowseMouseEntered
        ButtonColor.showButtonEnter(btnBrowse);
    }//GEN-LAST:event_btnBrowseMouseEntered

    private void btnBrowseMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBrowseMouseExited
        ButtonColor.showButtonExited(btnBrowse);
    }//GEN-LAST:event_btnBrowseMouseExited

    private void btnBrowseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBrowseActionPerformed
        try {
            JFileChooser choose = new JFileChooser();
            choose.showOpenDialog(null);
            it.setPathImg(choose.getSelectedFile().getAbsolutePath());
            Image img = new ImageIcon(it.getPathImg()).getImage();
            ic = ResizeScall(img, lblImage.getWidth(), lblImage.getHeight());
            lblImage.setIcon(new ImageIcon(ic));            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnBrowseActionPerformed

    private void cbbGroupMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbbGroupMouseClicked

    }//GEN-LAST:event_cbbGroupMouseClicked

    private void cbbGroupMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbbGroupMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbGroupMouseEntered

    private void cbbGroupMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbbGroupMousePressed
        // TODO add your handling code here:

    }//GEN-LAST:event_cbbGroupMousePressed

    private void cbbGroupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbGroupActionPerformed

    }//GEN-LAST:event_cbbGroupActionPerformed

    private void cbbCategoryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbbCategoryMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbCategoryMouseClicked

    private void cbbCategoryMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbbCategoryMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbCategoryMouseEntered

    private void cbbCategoryMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbbCategoryMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbCategoryMousePressed

    private void cbbCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbCategoryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbCategoryActionPerformed

    private void cbbUnitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbbUnitMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbUnitMouseClicked

    private void cbbUnitMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbbUnitMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbUnitMouseEntered

    private void cbbUnitMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbbUnitMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbUnitMousePressed

    private void cbbUnitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbUnitActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbUnitActionPerformed

    private void cbbSizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbbSizeMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbSizeMouseClicked

    private void cbbSizeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbbSizeMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbSizeMouseEntered

    private void cbbSizeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbbSizeMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbSizeMousePressed

    private void cbbSizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbSizeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbSizeActionPerformed

    private void cbbZoneMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbbZoneMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbZoneMouseClicked

    private void cbbZoneMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbbZoneMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbZoneMouseEntered

    private void cbbZoneMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbbZoneMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbZoneMousePressed

    private void cbbZoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbZoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbZoneActionPerformed

    private void cbbPackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbbPackMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbPackMouseClicked

    private void cbbPackMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbbPackMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbPackMouseEntered

    private void cbbPackMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbbPackMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbPackMousePressed

    private void cbbPackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbPackActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbPackActionPerformed

    private void cbbPickMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbbPickMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbPickMouseClicked

    private void cbbPickMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbbPickMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbPickMouseEntered

    private void cbbPickMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbbPickMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbPickMousePressed

    private void cbbPickActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbPickActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbPickActionPerformed

    private void btnSaveMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaveMouseEntered
        ButtonColor.showButtonEnter(btnSave);
    }//GEN-LAST:event_btnSaveMouseEntered

    private void btnSaveMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaveMouseExited
        ButtonColor.showButtonExited(btnSave);
    }//GEN-LAST:event_btnSaveMouseExited

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSaveActionPerformed

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
            java.util.logging.Logger.getLogger(FrmItemAdd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmItemAdd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmItemAdd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmItemAdd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FrmItemAdd dialog = new FrmItemAdd(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnBrowse;
    private javax.swing.JButton btnSave;
    public static javax.swing.JComboBox<String> cbbCategory;
    public static javax.swing.JComboBox<String> cbbGroup;
    public static javax.swing.JComboBox<String> cbbPack;
    public static javax.swing.JComboBox<String> cbbPick;
    public static javax.swing.JComboBox<String> cbbSize;
    public static javax.swing.JComboBox<String> cbbUnit;
    public static javax.swing.JComboBox<String> cbbZone;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JLabel lblBarcode;
    private javax.swing.JLabel lblCategory;
    private javax.swing.JLabel lblFormName;
    private javax.swing.JLabel lblGroup;
    private javax.swing.JLabel lblImage;
    private javax.swing.JLabel lblItem_L1;
    private javax.swing.JLabel lblItem_L2;
    private javax.swing.JLabel lblPack;
    private javax.swing.JLabel lblPackBarcode;
    private javax.swing.JLabel lblPick;
    private javax.swing.JLabel lblSize;
    private javax.swing.JLabel lblUnit;
    private javax.swing.JLabel lblZone;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtSearch1;
    private javax.swing.JTextField txtSearch2;
    private javax.swing.JTextField txtSearch3;
    // End of variables declaration//GEN-END:variables
}
