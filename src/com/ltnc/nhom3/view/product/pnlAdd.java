/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ltnc.nhom3.view.product;

import com.ltnc.nhom3.entity.Manufacturer;
import com.ltnc.nhom3.entity.Price;
import com.ltnc.nhom3.entity.Product;
import com.ltnc.nhom3.service.ManufacturerService;
import com.ltnc.nhom3.service.PriceService;
import com.ltnc.nhom3.service.ProductService;
import com.ltnc.nhom3.utility.ColorHelper;
import com.ltnc.nhom3.utility.IOHandler;
import com.ltnc.nhom3.utility.LabelHelper;
import com.ltnc.nhom3.view.template.SectionTemplate;
import com.ltnc.nhom3.view.template.SectionTemplate.CustomComboBoxModel;
import com.ltnc.nhom3.view.frmMainWindow;
import com.ltnc.nhom3.view.manufacturer.DialogHelper;
import java.awt.Component;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicComboBoxRenderer;

/**
 *
 * @author admin
 */
public class pnlAdd extends javax.swing.JPanel {

    private ProductService productService;
    private ManufacturerService manufacturerService;
    private PriceService priceService;
    
    /**
     * Creates new form pnlDetail
     */
    public pnlAdd(ProductService productService) {
        this.productService = productService;
        manufacturerService = new ManufacturerService();
        priceService = new PriceService();
        initComponents();
        loadManufacturersToComboBox(-1);
        cbbManufacturer.setUI(SectionTemplate.getCustomComboBoxUI());
        frmMainWindow.rootFrame.getRootPane().setDefaultButton(btnSubmit); //set default btn
    }

    private void loadManufacturersToComboBox(int selectManufacturerId) {
        try {
            Manufacturer selectManufacturer = null;
            List<Manufacturer> list = manufacturerService.findAll();
            DefaultComboBoxModel model = SectionTemplate.getCustomComboBoxModel();
            model.addElement(LabelHelper.COMBOBOX_SELECT_MANUFACTURER);
            for (Manufacturer manufacturer : list) {
                model.addElement(manufacturer);
                 if (manufacturer.getId() == selectManufacturerId)
                    selectManufacturer = manufacturer;
            }
            cbbManufacturer.setModel(model);
            if (selectManufacturer != null) cbbManufacturer.setSelectedItem(selectManufacturer);
        } catch (SQLException ex) {
            Logger.getLogger(pnlAdd.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void resetComboBox() {
        CustomComboBoxModel model = (CustomComboBoxModel) cbbManufacturer.getModel();
        model.setSelectionAllowed(true);
        model.setSelectedItem(LabelHelper.COMBOBOX_SELECT_MANUFACTURER);
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
        lblHeading = new javax.swing.JLabel();
        btnGoBack = SectionTemplate.getStyledButton();
        jSeparator2 = SectionTemplate.getStyledSeparator();
        pnlForm = SectionTemplate.getStyledPanel();
        pnlLeft = SectionTemplate.getStyledPanel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        pnlRight = SectionTemplate.getStyledPanel();
        txtName = new javax.swing.JTextField();
        txtPrice = new javax.swing.JFormattedTextField();
        cbbManufacturer = new javax.swing.JComboBox<>();
        chbAvailabel = new javax.swing.JCheckBox();
        btnCreateManufacturer = SectionTemplate.getStyledButton();
        txtReleaseDate = new com.toedter.calendar.JDateChooser();
        txtReleaseDate.setLocale(new Locale("vi", "VI"));
        jScrollPane3 = new javax.swing.JScrollPane();
        txtDescription = new javax.swing.JTextArea();
        txtDescription.setLineWrap(true);
        txtDescription.setWrapStyleWord(true);
        jScrollPane4 = new javax.swing.JScrollPane();
        txtSpecifications = new javax.swing.JTextArea();
        txtSpecifications.setLineWrap(true);
        txtSpecifications.setWrapStyleWord(true);
        btnEditManufacturer = SectionTemplate.getStyledButton();
        jSeparator1 = SectionTemplate.getStyledSeparator();
        jPanel2 = SectionTemplate.getStyledPanel();
        btnReset = SectionTemplate.getStyledButton();
        btnSubmit = SectionTemplate.getStyledButton();

        setBackground(ColorHelper.SECTION_PANEL_BG);
        setPreferredSize(new java.awt.Dimension(654, 596));

        lblHeading.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        lblHeading.setText("Thêm sản phẩm");

        btnGoBack.setText("Quay lại");
        btnGoBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGoBackActionPerformed(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel22.setText("Tên: ");
        jLabel22.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel22.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jLabel22.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        jLabel23.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel23.setText("Đơn giá: ");
        jLabel23.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel23.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jLabel23.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        jLabel24.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel24.setText("Hãng sản xuất:");
        jLabel24.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel24.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jLabel24.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        jLabel25.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel25.setText("Thông số kỹ thuật:");
        jLabel25.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel25.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jLabel25.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        jLabel26.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel26.setText("Mô tả: ");
        jLabel26.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel26.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jLabel26.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        jLabel27.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel27.setText("Ngày ra mắt:");
        jLabel27.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel27.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jLabel27.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        jLabel28.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel28.setText("Tình trạng:");
        jLabel28.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel28.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jLabel28.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout pnlLeftLayout = new javax.swing.GroupLayout(pnlLeft);
        pnlLeft.setLayout(pnlLeftLayout);
        pnlLeftLayout.setHorizontalGroup(
            pnlLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLeftLayout.createSequentialGroup()
                .addContainerGap(76, Short.MAX_VALUE)
                .addGroup(pnlLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel22, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel23, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel24, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel27, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel28, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel25, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel26, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(10, 10, 10))
        );
        pnlLeftLayout.setVerticalGroup(
            pnlLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLeftLayout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addComponent(jLabel22)
                .addGap(26, 26, 26)
                .addComponent(jLabel23)
                .addGap(26, 26, 26)
                .addComponent(jLabel24)
                .addGap(26, 26, 26)
                .addComponent(jLabel27)
                .addGap(26, 26, 26)
                .addComponent(jLabel28)
                .addGap(26, 26, 26)
                .addComponent(jLabel25)
                .addGap(91, 91, 91)
                .addComponent(jLabel26)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        txtName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtName.setName(""); // NOI18N
        txtName.setPreferredSize(new java.awt.Dimension(6, 25));

        txtPrice.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));
        txtPrice.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        cbbManufacturer.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbbManufacturer.setMaximumRowCount(5);
        cbbManufacturer.setMinimumSize(new java.awt.Dimension(56, 25));
        cbbManufacturer.setRenderer(new BasicComboBoxRenderer() {
            @Override
            public Component getListCellRendererComponent(
                JList list, Object value, int index,
                boolean isSelected, boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index,
                    isSelected, cellHasFocus);
                if (value != null && !LabelHelper.COMBOBOX_SELECT_MANUFACTURER.equals(value)) {
                    Manufacturer item = (Manufacturer) value;
                    String manufacturerStr = IOHandler.convertToDisplayManufacturerString(item);
                    setText(manufacturerStr);
                    setToolTipText(manufacturerStr);
                }

                return this;
            }
        });

        chbAvailabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        chbAvailabel.setSelected(true);
        chbAvailabel.setText(LabelHelper.PRODUCT_AVAILABEL_MESSAGE);
        chbAvailabel.setBorder(null);
        chbAvailabel.setName(""); // NOI18N
        chbAvailabel.setOpaque(false);

        btnCreateManufacturer.setText("Tạo mới");
        btnCreateManufacturer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateManufacturerActionPerformed(evt);
            }
        });

        txtReleaseDate.setDoubleBuffered(false);
        txtReleaseDate.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtReleaseDate.setMaximumSize(new java.awt.Dimension(91, 20));
        txtReleaseDate.setMinimumSize(new java.awt.Dimension(91, 20));

        txtDescription.setColumns(20);
        txtDescription.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtDescription.setRows(4);
        txtDescription.setTabSize(3);
        jScrollPane3.setViewportView(txtDescription);

        txtSpecifications.setColumns(20);
        txtSpecifications.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtSpecifications.setRows(4);
        txtSpecifications.setTabSize(3);
        jScrollPane4.setViewportView(txtSpecifications);

        btnEditManufacturer.setText("Sửa");
        btnEditManufacturer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditManufacturerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlRightLayout = new javax.swing.GroupLayout(pnlRight);
        pnlRight.setLayout(pnlRightLayout);
        pnlRightLayout.setHorizontalGroup(
            pnlRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRightLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(chbAvailabel)
                    .addComponent(txtName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtPrice)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
                    .addComponent(jScrollPane3)
                    .addGroup(pnlRightLayout.createSequentialGroup()
                        .addGroup(pnlRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(cbbManufacturer, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtReleaseDate, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE))
                        .addGap(7, 7, 7)
                        .addComponent(btnEditManufacturer)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCreateManufacturer)))
                .addContainerGap(65, Short.MAX_VALUE))
        );
        pnlRightLayout.setVerticalGroup(
            pnlRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRightLayout.createSequentialGroup()
                .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(pnlRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbbManufacturer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnCreateManufacturer)
                        .addComponent(btnEditManufacturer)))
                .addGap(23, 23, 23)
                .addComponent(txtReleaseDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(chbAvailabel)
                .addGap(23, 23, 23)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pnlRightLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnCreateManufacturer, btnEditManufacturer, cbbManufacturer, txtName, txtPrice, txtReleaseDate});

        javax.swing.GroupLayout pnlFormLayout = new javax.swing.GroupLayout(pnlForm);
        pnlForm.setLayout(pnlFormLayout);
        pnlFormLayout.setHorizontalGroup(
            pnlFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFormLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(pnlLeft, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlRight, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlFormLayout.setVerticalGroup(
            pnlFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFormLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(pnlFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlRight, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlLeft, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(21, 21, 21))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator2)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(pnlForm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblHeading, javax.swing.GroupLayout.PREFERRED_SIZE, 513, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                        .addComponent(btnGoBack))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnGoBack)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblHeading))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlForm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnGoBack, lblHeading});

        btnReset.setText("Đặt lại");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        btnSubmit.setText("Gửi");
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnReset)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSubmit)
                .addGap(2, 2, 2))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSubmit)
                    .addComponent(btnReset))
                .addContainerGap(18, Short.MAX_VALUE))
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
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnGoBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGoBackActionPerformed
        frmMainWindow.rootFrame.loadInSection(new pnlList());
    }//GEN-LAST:event_btnGoBackActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        txtName.setText("");
        txtPrice.setText("");
        txtDescription.setText("");
        txtSpecifications.setText("");
        txtReleaseDate.setDate(null);
        chbAvailabel.setSelected(true);
        resetComboBox();
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
        // TODO : check required
        try {    
            txtPrice.commitEdit();
        } catch (ParseException ex) {
            txtPrice.requestFocus();
            Logger.getLogger(pnlAdd.class.getName()).log(Level.SEVERE, null, ex);
            return;
        }
        Product product = new Product();
        product.setName(txtName.getText());
        product.setAvailable(chbAvailabel.isSelected());
        product.setDecription(txtDescription.getText());
        product.setSpecifications(txtSpecifications.getText());
        product.setReleaseDate(IOHandler.convertToStringSQLDate(txtReleaseDate.getDate()));
        product.setManufacturerId(((Manufacturer)cbbManufacturer.getSelectedItem()).getId());
        
        Price price = new Price();
        try {
            int productId = productService.createAndReturnId(product);
            if (productId > 0) {
                if (txtPrice.getValue() != null){
                    price.setProductId(productId);
                    price.setValue(((Number)txtPrice.getValue()).doubleValue());
                    price.setStartDate(IOHandler.convertToStringSQLDateTime(new Date()));
                    priceService.create(price);
                }
                JOptionPane.showMessageDialog(frmMainWindow.rootFrame, LabelHelper.ADD_DONE_DIALOG_MESSAGE);
                frmMainWindow.rootFrame.loadInSection(new pnlList());
            };
        } catch (SQLException ex) {
            Logger.getLogger(pnlAdd.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSubmitActionPerformed

    private void btnCreateManufacturerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateManufacturerActionPerformed
        int returnedId = DialogHelper.showAddManufacturerForm(frmMainWindow.rootFrame, manufacturerService);
        if (returnedId != -1)
            loadManufacturersToComboBox(returnedId);
    }//GEN-LAST:event_btnCreateManufacturerActionPerformed

    private void btnEditManufacturerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditManufacturerActionPerformed
        if(!LabelHelper.COMBOBOX_SELECT_MANUFACTURER.equals(cbbManufacturer.getSelectedItem())) {
            int manufacturerId = ((Manufacturer)cbbManufacturer.getSelectedItem()).getId();
            if(DialogHelper.showEditManufacturerForm(frmMainWindow.rootFrame, manufacturerService,
                    manufacturerId) == 0)
                resetComboBox();
            loadManufacturersToComboBox(manufacturerId);
        }
    }//GEN-LAST:event_btnEditManufacturerActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCreateManufacturer;
    private javax.swing.JButton btnEditManufacturer;
    private javax.swing.JButton btnGoBack;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSubmit;
    private javax.swing.JComboBox<String> cbbManufacturer;
    private javax.swing.JCheckBox chbAvailabel;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblHeading;
    private javax.swing.JPanel pnlForm;
    private javax.swing.JPanel pnlLeft;
    private javax.swing.JPanel pnlRight;
    private javax.swing.JTextArea txtDescription;
    private javax.swing.JTextField txtName;
    private javax.swing.JFormattedTextField txtPrice;
    private com.toedter.calendar.JDateChooser txtReleaseDate;
    private javax.swing.JTextArea txtSpecifications;
    // End of variables declaration//GEN-END:variables
}