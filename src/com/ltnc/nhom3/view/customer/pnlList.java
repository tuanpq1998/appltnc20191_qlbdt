/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ltnc.nhom3.view.customer;

import com.ltnc.nhom3.entity.Customer;
import com.ltnc.nhom3.service.CustomerService;
import com.ltnc.nhom3.utility.ConstantHelper;
import com.ltnc.nhom3.view.template.TableHelper;
import com.ltnc.nhom3.view.template.SectionTemplate;
import com.ltnc.nhom3.view.frmMainWindow;
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
 * @author PhungSyLinh
 */
public class pnlList extends javax.swing.JPanel {
    
    private CustomerService customerService;
    private String searchKey;
    private int totalPage;
    private int pageNum;
    
    /**
     * Creates new form pnlList
     */
    public pnlList(CustomerService customerService) {
        this.customerService = customerService;
        initComponents();
        getTotalPage();
        loadTable(1);
        jScrollPane1.getViewport().setBackground(ConstantHelper.SECTION_PANEL_BG);
        tblList.getTableHeader().setReorderingAllowed(false);
        btnClearSearch.setVisible(false);
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
        jPanel2 = SectionTemplate.getStyledPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblList = new TableHelper.CustomTable();
        lblHeading = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        jSeparator2 = SectionTemplate.getStyledSeparator();
        btnClearSearch = SectionTemplate.getStyledButton();
        jSeparator1 = SectionTemplate.getStyledSeparator();
        jPanel4 = SectionTemplate.getStyledPanel();
        btnNextPage = SectionTemplate.getStyledButton();
        btnPrevPage = SectionTemplate.getStyledButton();
        btnLastPage = SectionTemplate.getStyledButton();
        btnFirstPage = SectionTemplate.getStyledButton();
        lblPaginationStatus = new javax.swing.JLabel();
        jPanel3 = SectionTemplate.getStyledPanel();
        btnEdit = SectionTemplate.getStyledButton();
        btnAdd = SectionTemplate.getStyledButton();
        btnDelete = SectionTemplate.getStyledButton();

        jPanel1.setBackground(ConstantHelper.SECTION_PANEL_BG);

        jScrollPane1.setBorder(null);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

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

        lblHeading.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        lblHeading.setText(ConstantHelper.CUSTOMER_LIST_HEADING);

        txtSearch.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtSearch.setForeground(Color.GRAY);
        txtSearch.setText("Tìm kiếm");
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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 614, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lblHeading, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnClearSearch)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnClearSearch)
                            .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblHeading))
                .addGap(15, 15, 15)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 346, Short.MAX_VALUE)
                .addGap(11, 11, 11))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnClearSearch, txtSearch});

        btnNextPage.setText("▶");
        btnNextPage.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNextPage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextPageActionPerformed(evt);
            }
        });

        btnPrevPage.setText("◀");
        btnPrevPage.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPrevPage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrevPageActionPerformed(evt);
            }
        });

        btnLastPage.setText("▶|");
        btnLastPage.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLastPage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLastPageActionPerformed(evt);
            }
        });

        btnFirstPage.setText("|◀");
        btnFirstPage.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnFirstPage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFirstPageActionPerformed(evt);
            }
        });

        lblPaginationStatus.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        lblPaginationStatus.setText("1/2");
        lblPaginationStatus.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnFirstPage)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnPrevPage)
                .addGap(20, 20, 20)
                .addComponent(lblPaginationStatus)
                .addGap(20, 20, 20)
                .addComponent(btnNextPage)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnLastPage)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(lblPaginationStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnNextPage)
                        .addComponent(btnPrevPage)
                        .addComponent(btnLastPage)
                        .addComponent(btnFirstPage)))
                .addGap(8, 8, 8))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator1))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        btnEdit.setText("Sửa");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnAdd.setText("Thêm");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnDelete.setText("Xóa");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnDelete)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAdd)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnEdit)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEdit)
                    .addComponent(btnAdd)
                    .addComponent(btnDelete))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, 0)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(0, 0, 0)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(528, 528, 528)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, 0)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(53, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents
    
    private void setOnOffForButtons(boolean isOn) {
        btnDelete.setEnabled(isOn);
        btnEdit.setEnabled(isOn);
    }
    
    public void loadTable(int pageNum) {
        this.pageNum = pageNum;
        reloadPaginationButtons();
        String[] titles = ConstantHelper.TBL_CUSTOMER_TITLES;
        DefaultTableModel dtm = TableHelper.getNonEditableTableModel(titles);
        List<Customer> customers = null;
        try {
            if (searchKey == null) {
                customers = customerService.findAll(pageNum);
            } else {
                customers = customerService.findByName(searchKey, pageNum);
            }
            Object[] row = new Object[titles.length];
            if (customers.isEmpty()) {
                row[1] = ConstantHelper.NO_RESULT_MESSAGE;
                dtm.addRow(row);
                setOnOffForButtons(false);
            } else {
                for (Customer customer : customers) {
                    row[0] = customer.getId();
                    row[1] = customer.getFullname();
                    row[2] = customer.getAddress();
                    row[3] = customer.getPhone();
                    dtm.addRow(row);
                }
                setOnOffForButtons(true);
            }    
            tblList.setModel(dtm);
            TableHelper.setWidthForAllColumns(tblList, ConstantHelper.TBL_CUSTOMER_WIDTHS);
        } catch (SQLException ex) {
            Logger.getLogger(pnlList.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    private void txtSearchFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSearchFocusGained
        txtSearch.setForeground(ConstantHelper.SEARCH_SECTION_TEXT_FOCUS);
        if("Tìm kiếm".equals(txtSearch.getText())){
            txtSearch.setText("");
        }
    }//GEN-LAST:event_txtSearchFocusGained

    private void txtSearchFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSearchFocusLost
        txtSearch.setForeground(ConstantHelper.SEARCH_SECTION_TEXT_NON_FOCUS);
        if (txtSearch.getText()==null || txtSearch.getText().length()==0) {
            txtSearch.setText("Tìm kiếm");
        }
    }//GEN-LAST:event_txtSearchFocusLost

    private void txtSearchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyPressed
        String searchKeyInput = txtSearch.getText().trim();
        if(!searchKeyInput.equals("") && evt.getKeyCode() == KeyEvent.VK_ENTER){
            searchKey = searchKeyInput;
            loadTable(1);
            if (searchKey.length() > 15)
                lblHeading.setText(String.format(ConstantHelper.PRODUCT_LIST_SEARCH_HEADING, searchKey.substring(0, 15) + "..."));
            else 
                lblHeading.setText(String.format(ConstantHelper.PRODUCT_LIST_SEARCH_HEADING, searchKey));
            lblHeading.setToolTipText(String.format(ConstantHelper.PRODUCT_LIST_SEARCH_HEADING, searchKey));
            btnClearSearch.setVisible(true);
        }
    }//GEN-LAST:event_txtSearchKeyPressed

    private void btnClearSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearSearchActionPerformed
        lblHeading.setText(ConstantHelper.CUSTOMER_LIST_HEADING);
        lblHeading.setToolTipText(null);
        txtSearch.setText("");
        searchKey = null;
        getTotalPage();
        loadTable(1);
        btnClearSearch.setVisible(false);
    }//GEN-LAST:event_btnClearSearchActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        if (tblList.getSelectedRowCount() == 1) {
            frmMainWindow.rootFrame.loadInSection(new pnlForm(customerService, TableHelper.extractSelectedId(tblList)));
        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        frmMainWindow.rootFrame.loadInSection(new pnlForm(customerService));
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
         if (tblList.getSelectedRowCount() > 0) {
            int option = JOptionPane.showConfirmDialog(frmMainWindow.rootFrame, ConstantHelper.CONFIRM_DIALOG_MESSAGE,
                    ConstantHelper.CONFIRM_DIALOG_TITLE,JOptionPane.YES_NO_OPTION);
            if(option == JOptionPane.YES_OPTION){
                try {
                    customerService.deleteById(TableHelper.extractSelectedId(tblList));
                    getTotalPage();
                    loadTable(pageNum > totalPage? 1 : pageNum);
                } catch (SQLException ex) {
                    Logger.getLogger(pnlList.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnNextPageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextPageActionPerformed
        loadTable(++pageNum);
    }//GEN-LAST:event_btnNextPageActionPerformed

    private void btnPrevPageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrevPageActionPerformed
        loadTable(--pageNum);
    }//GEN-LAST:event_btnPrevPageActionPerformed

    private void btnLastPageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLastPageActionPerformed
        loadTable(totalPage);
    }//GEN-LAST:event_btnLastPageActionPerformed

    private void btnFirstPageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFirstPageActionPerformed
        loadTable(1);
    }//GEN-LAST:event_btnFirstPageActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnClearSearch;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnFirstPage;
    private javax.swing.JButton btnLastPage;
    private javax.swing.JButton btnNextPage;
    private javax.swing.JButton btnPrevPage;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblHeading;
    private javax.swing.JLabel lblPaginationStatus;
    private javax.swing.JTable tblList;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables

    private void getTotalPage() {
        try {
            int totalItems = 0;
            if (searchKey == null)
                totalItems = customerService.countAll();
            else totalItems = customerService.countAllByName(searchKey);
            totalPage = totalItems / ConstantHelper.ITEM_PER_PAGE 
                    + (totalItems % ConstantHelper.ITEM_PER_PAGE == 0? 0 : 1);
        } catch (SQLException ex) {
            Logger.getLogger(pnlList.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void reloadPaginationButtons() {
        btnPrevPage.setEnabled(true);
        btnFirstPage.setEnabled(true);
        btnLastPage.setEnabled(true);
        btnNextPage.setEnabled(true);
        if (pageNum == 1) {
            btnFirstPage.setEnabled(false);
            btnPrevPage.setEnabled(false);
        }
        if (pageNum == totalPage) {
            btnNextPage.setEnabled(false);
            btnLastPage.setEnabled(false);
        }
        lblPaginationStatus.setText(String.format(ConstantHelper.PAGINATION_TEXT, pageNum, totalPage));
    }
}