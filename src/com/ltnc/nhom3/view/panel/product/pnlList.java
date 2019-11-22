/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ltnc.nhom3.view.panel.product;

import com.ltnc.nhom3.entity.Price;
import com.ltnc.nhom3.entity.Product;
import com.ltnc.nhom3.service.PriceService;
import com.ltnc.nhom3.service.ProductService;
import com.ltnc.nhom3.utility.ColorHelper;
import com.ltnc.nhom3.utility.IOHandler;
import com.ltnc.nhom3.utility.LabelHelper;
import com.ltnc.nhom3.utility.TableHelper;
import com.ltnc.nhom3.view.frmMainWindow;
import com.ltnc.nhom3.view.SectionTemplate;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author admin
 */
public class pnlList extends javax.swing.JPanel {
    private ProductService productService;
    private PriceService priceService;
    
    /**
     * Creates new form pnlBill
     */
    public pnlList() {
        productService = new ProductService();
        priceService = new PriceService();
        initComponents();
        loadTable(null);
        jScrollPane1.getViewport().setBackground(Color.white);
        tblList.getTableHeader().setReorderingAllowed(false);
        btnClearSearch.setVisible(false);
    }
    
    private void setOnOffForButtons(boolean isOn) {
        btnDelete.setEnabled(isOn);
        btnDetail.setEnabled(isOn);
        btnEdit.setEnabled(isOn);
    }
    
    public void loadTable(List<Product> products) {
        String[] titles = LabelHelper.TBL_PRODUCT_TITLES;
        DefaultTableModel dtm = TableHelper.getNonEditableTableModel(titles);
        
        try {
            if (products == null) 
                products = productService.findAll();
            Object[] row = new Object[titles.length];
            if (products.isEmpty()) {
                row[1] = LabelHelper.NO_RESULT_MESSAGE;
                dtm.addRow(row);
                setOnOffForButtons(false);
            } else {
                Price price = null;
                for (Product product : products) {
                    row[0] = product.getId();
                    row[1] = product.getName();
                    
                    price = priceService.findPriceByProductId(product.getId());
                    row[2] = price==null ? LabelHelper.NO_INFORMATION_MESSAGE 
                            : IOHandler.convertToDisplayPriceString(price.getValue());
                    
                    row[3] = IOHandler.convertToDisplayDate(product.getReleaseDate());
                    row[4] = product.isAvailable() ? LabelHelper.PRODUCT_AVAILABEL_MESSAGE 
                            : LabelHelper.PRODUCT_NOT_AVAILABEL_MESSAGE;
                    dtm.addRow(row);
                }
                setOnOffForButtons(true);
            }
            tblList.setModel(dtm);
            TableHelper.setWithForAllColumns(tblList, LabelHelper.TBL_PRODUCT_TITLES_WIDTHS);
            
        } catch (SQLException ex) {
            Logger.getLogger(pnlList.class.getName()).log(Level.SEVERE, null, ex);
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

        jPanel1 = SectionTemplate.getStyledPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblList = new javax.swing.JTable();
        lblHeading = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        jSeparator2 = SectionTemplate.getStyledSeparator();
        btnClearSearch = SectionTemplate.getStyledButton();
        jSeparator1 = SectionTemplate.getStyledSeparator();
        jPanel2 = SectionTemplate.getStyledPanel();
        btnDetail = SectionTemplate.getStyledButton();
        btnEdit = SectionTemplate.getStyledButton();
        btnDelete = SectionTemplate.getStyledButton();
        btnAdd = SectionTemplate.getStyledButton();

        setBackground(ColorHelper.SECTION_PANEL_BG);

        jScrollPane1.setBackground(getBackground());
        jScrollPane1.setBorder(null);

        tblList.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tblList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblList.setRowHeight(25);
        jScrollPane1.setViewportView(tblList);

        lblHeading.setBackground(getBackground());
        lblHeading.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        lblHeading.setText(com.ltnc.nhom3.utility.LabelHelper.PRODUCT_LIST_HEADING);

        txtSearch.setBackground(getBackground());
        txtSearch.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtSearch.setForeground(Color.GRAY);
        txtSearch.setText("Tìm kiếm");
        txtSearch.setToolTipText(txtSearch.getText());
        txtSearch.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtSearchFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtSearchFocusLost(evt);
            }
        });
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSearchKeyPressed(evt);
            }
        });

        btnClearSearch.setText("Quay lại");
        btnClearSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearSearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 614, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblHeading, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnClearSearch)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnClearSearch)
                            .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblHeading)
                        .addGap(396, 396, 396))))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnClearSearch, txtSearch});

        btnDetail.setText("Xem chi tiết");
        btnDetail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetailActionPerformed(evt);
            }
        });

        btnEdit.setText("Sửa");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnDelete.setText("Xóa");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnAdd.setText("Thêm");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAdd)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnDelete)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnEdit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnDetail)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDetail)
                    .addComponent(btnEdit)
                    .addComponent(btnDelete)
                    .addComponent(btnAdd))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(38, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtSearchFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSearchFocusGained
        txtSearch.setForeground(ColorHelper.SEARCH_SECTION_TEXT_FOCUS);
        if ("Tìm kiếm".equals(txtSearch.getText())) {
            txtSearch.setText("");
        }
    }//GEN-LAST:event_txtSearchFocusGained

    private void txtSearchFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSearchFocusLost
        txtSearch.setForeground(ColorHelper.SEARCH_SECTION_TEXT_NON_FOCUS);
        if (txtSearch.getText() == null || txtSearch.getText().length() == 0) {
            txtSearch.setText("Tìm kiếm");
        }
    }//GEN-LAST:event_txtSearchFocusLost


    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        if (tblList.getSelectedRowCount() > 0){
            int option = JOptionPane.showConfirmDialog(frmMainWindow.rootFrame, 
                    LabelHelper.CONFIRM_DIALOG_MESSAGE, LabelHelper.CONFIRM_DIALOG_TITLE, JOptionPane.YES_NO_OPTION);
            if (option == JOptionPane.YES_OPTION){
                try {
                    if (productService.deleteByIds(TableHelper.extractSelectedIdList(tblList)))
                        loadTable(null);
                } catch (SQLException ex) {
                    Logger.getLogger(pnlList.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void txtSearchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyPressed
        String searchKey = txtSearch.getText().trim();
        if (!searchKey.equals("") && evt.getKeyCode()==KeyEvent.VK_ENTER)  {
            List<Product> listResultProduct;
            try {
                listResultProduct = productService.findAllByName(searchKey);
                loadTable(listResultProduct);
                
                String searchKeyHeading = searchKey;
                if (searchKey.length() > 20) 
                    searchKeyHeading = searchKeyHeading.substring(0,15) + " ...";
                    
                lblHeading.setText(LabelHelper.PRODUCT_LIST_SEARCH_HEADING+" '"+searchKeyHeading+"'");
                lblHeading.setToolTipText(LabelHelper.PRODUCT_LIST_SEARCH_HEADING+" '"+searchKey+"'");
                btnClearSearch.setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(pnlList.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_txtSearchKeyPressed

    private void btnClearSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearSearchActionPerformed
        lblHeading.setText(LabelHelper.PRODUCT_LIST_HEADING);
        lblHeading.setToolTipText(null);
        txtSearch.setText("");
        loadTable(null);
        btnClearSearch.setVisible(false);
    }//GEN-LAST:event_btnClearSearchActionPerformed

    private void btnDetailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetailActionPerformed
        if (tblList.getSelectedRowCount() == 1){
            frmMainWindow.rootFrame.loadInSection(new pnlDetail(TableHelper.extractSelectedId(tblList), 
                    productService));
        }
    }//GEN-LAST:event_btnDetailActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        if (tblList.getSelectedRowCount() == 1){
            frmMainWindow.rootFrame.loadInSection(new pnlEdit(TableHelper.extractSelectedId(tblList), 
                    productService));
        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        frmMainWindow.rootFrame.loadInSection(new pnlAdd(productService));
    }//GEN-LAST:event_btnAddActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnClearSearch;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnDetail;
    private javax.swing.JButton btnEdit;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblHeading;
    private javax.swing.JTable tblList;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
