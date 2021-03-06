/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ltnc.nhom3.view.bill;

import com.ltnc.nhom3.entity.Bill;
import com.ltnc.nhom3.entity.BillDetail;
import com.ltnc.nhom3.entity.Customer;
import com.ltnc.nhom3.entity.Employee;
import com.ltnc.nhom3.entity.Price;
import com.ltnc.nhom3.entity.Product;
import com.ltnc.nhom3.service.BillDetailService;
import com.ltnc.nhom3.service.BillService;
import com.ltnc.nhom3.service.CustomerService;
import com.ltnc.nhom3.service.EmployeeService;
import com.ltnc.nhom3.service.ManufacturerService;
import com.ltnc.nhom3.service.PriceService;
import com.ltnc.nhom3.service.ProductService;
import com.ltnc.nhom3.utility.ConstantHelper;
import com.ltnc.nhom3.utility.IOHandler;
import com.ltnc.nhom3.view.template.SectionTemplate;
import com.ltnc.nhom3.view.frmMainWindow;
import com.ltnc.nhom3.view.template.TableHelper;
import java.awt.Dimension;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author admin
 */
public class pnlEdit extends javax.swing.JPanel {
    
    private int totalQuantity = 0, billId;
    private double totalMoney = 0;
    private List<BillDetail> listBillDetails = new ArrayList<>();
    
    private EmployeeService employeeService;
    private CustomerService customerService;
    private PriceService priceService;
    private ManufacturerService manufacturerService;
    private BillService billService;
    private BillDetailService billDetailService;
    private ProductService productService;
    
    /**
     * Creates new form pnlDetail
     * @param id
     * @param productService
     */   
    public pnlEdit(int billId, EmployeeService employeeService, CustomerService customerService, PriceService priceService,
            BillService billService, BillDetailService billDetailService, ProductService productService,
            ManufacturerService manufacturerService) {
        this.employeeService = employeeService;
        this.customerService = customerService;
        this.priceService = priceService;
        this.billService = billService;
        this.manufacturerService = manufacturerService;
        this.billDetailService = billDetailService;
        this.productService = productService;
        this.billId = billId;
        
        initComponents();
        jScrollPane1.getViewport().setBackground(ConstantHelper.SECTION_PANEL_BG);
        tblProductList.getTableHeader().setReorderingAllowed(false);

        tblProductList.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent event) {
                if (!event.getValueIsAdjusting() && tblProductList.getSelectedRowCount() > 0) {
                    int selectedIndex = tblProductList.getSelectedRow();
                    resetOrEnableProductField(true);
                    txtProduct.setText(""+tblProductList.getValueAt(selectedIndex, 1));
                    spnQuantity.setValue(listBillDetails.get(selectedIndex).getQuantity());
                }
            }
        });
        lblHeading.setText(String.format(ConstantHelper.BILL_EDIT_HEADING, billId));
        loadOldData();
    }
    
    private void loadOldData() {
        try {
            Bill bill = billService.findById(billId);
            int employeeId = bill.getEmployeeId(), customerId = bill.getCustomerId();
            txtNote.setText(bill.getNote());
            if (employeeId > 0) {
                Employee employee = employeeService.findById(employeeId);
                txtEmployeeAndDateCreated.setText((employee == null ? "" : employee.getFullname()
                        + " (" + employee.getUsername() + ")") + " - " + IOHandler.convertToDisplayDateTime(bill.getCreateDate()));
            }
            if (customerId > 0) {
                Customer customer = customerService.findById(customerId);
                if (customer == null) {
                } else {
                    txtCustomer.setText(customer.getFullname() + " - ĐT: " + customer.getPhone() + " - ĐC: " + customer.getAddress());
                }
            }
            lblTotal.setText(String.format(ConstantHelper.LBL_TOTAL_ADD_BILL, billDetailService.findSumQuantityByBillId(billId),
                    IOHandler.convertToDisplayPriceString(bill.getTotalMoney())));
            //add all product
            List<BillDetail> list = billDetailService.findAllByBillId(billId);
            for (BillDetail b : list) addOldDataToTable(b);
        } catch (SQLException ex) {
            Logger.getLogger(pnlDetail.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void resetOrEnableProductField(boolean isEnable) {
        btnUpdate.setEnabled(isEnable);
        btnDelete.setEnabled(isEnable);
        spnQuantity.setEnabled(isEnable);
        if (!isEnable) {
            spnQuantity.setValue(1);
            txtProduct.setText("");
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
        lblHeading = new javax.swing.JLabel();
        btnGoBack = SectionTemplate.getStyledButton();
        jSeparator2 = SectionTemplate.getStyledSeparator();
        pnlForm = SectionTemplate.getStyledPanel();
        pnlLeft = SectionTemplate.getStyledPanel();
        jLabel22 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        pnlRight = SectionTemplate.getStyledPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtNote = new javax.swing.JTextPane();
        txtCustomer = new javax.swing.JTextField();
        txtEmployeeAndDateCreated = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProductList = new TableHelper.CustomTable();
        btnDelete = SectionTemplate.getStyledButton();
        btnAdd = SectionTemplate.getStyledButton();
        lblTotal = new javax.swing.JLabel();
        jSeparator1 = SectionTemplate.getStyledSeparator();
        jPanel2 = SectionTemplate.getStyledPanel();
        btnReset = SectionTemplate.getStyledButton();
        btnSubmit = SectionTemplate.getStyledButton();
        jLabel1 = new javax.swing.JLabel();
        txtProduct = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        spnQuantity = new javax.swing.JSpinner();
        btnUpdate = SectionTemplate.getStyledButton();

        setBackground(ConstantHelper.SECTION_PANEL_BG);
        setMinimumSize(new java.awt.Dimension(654, 596));

        lblHeading.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        lblHeading.setText("title");

        btnGoBack.setText("Quay lại");
        btnGoBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGoBackActionPerformed(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel22.setText("Khách hàng:");
        jLabel22.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel22.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jLabel22.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        jLabel28.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel28.setText("Nhân viên & ngày tạo:");
        jLabel28.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel28.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jLabel28.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        jLabel29.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel29.setText("Note:");
        jLabel29.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel29.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jLabel29.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout pnlLeftLayout = new javax.swing.GroupLayout(pnlLeft);
        pnlLeft.setLayout(pnlLeftLayout);
        pnlLeftLayout.setHorizontalGroup(
            pnlLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLeftLayout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addGroup(pnlLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel22, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel28, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel29, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(10, 10, 10))
        );
        pnlLeftLayout.setVerticalGroup(
            pnlLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLeftLayout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addComponent(jLabel22)
                .addGap(25, 25, 25)
                .addComponent(jLabel28)
                .addGap(26, 26, 26)
                .addComponent(jLabel29)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane2.setEnabled(false);

        txtNote.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jScrollPane2.setViewportView(txtNote);

        txtCustomer.setEditable(false);
        txtCustomer.setBackground(ConstantHelper.SECTION_PANEL_BG);
        txtCustomer.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtCustomer.setName(""); // NOI18N
        txtCustomer.setPreferredSize(new java.awt.Dimension(6, 25));

        txtEmployeeAndDateCreated.setEditable(false);
        txtEmployeeAndDateCreated.setBackground(ConstantHelper.SECTION_PANEL_BG);
        txtEmployeeAndDateCreated.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtEmployeeAndDateCreated.setName(""); // NOI18N
        txtEmployeeAndDateCreated.setPreferredSize(new java.awt.Dimension(6, 25));

        javax.swing.GroupLayout pnlRightLayout = new javax.swing.GroupLayout(pnlRight);
        pnlRight.setLayout(pnlRightLayout);
        pnlRightLayout.setHorizontalGroup(
            pnlRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRightLayout.createSequentialGroup()
                .addGroup(pnlRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2)
                    .addComponent(txtCustomer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtEmployeeAndDateCreated, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(108, Short.MAX_VALUE))
        );
        pnlRightLayout.setVerticalGroup(
            pnlRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRightLayout.createSequentialGroup()
                .addComponent(txtCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(txtEmployeeAndDateCreated, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlFormLayout = new javax.swing.GroupLayout(pnlForm);
        pnlForm.setLayout(pnlFormLayout);
        pnlFormLayout.setHorizontalGroup(
            pnlFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFormLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(pnlLeft, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addGap(333, 333, 333))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblHeading, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnGoBack))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(pnlForm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(10, 10, 10)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblHeading, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(21, 21, 21))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnGoBack, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addComponent(pnlForm, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jScrollPane1.setBackground(ConstantHelper.SECTION_PANEL_BG);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        tblProductList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Sản phẩm", "Đơn giá", "Số lượng", "Thành tiền"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblProductList.setMinimumSize(new java.awt.Dimension(500, 500));
        tblProductList.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblProductList);

        btnDelete.setText("Xóa");
        btnDelete.setEnabled(false);
        btnDelete.setMaximumSize(new java.awt.Dimension(41, 28));
        btnDelete.setMinimumSize(new java.awt.Dimension(41, 28));
        btnDelete.setPreferredSize(new java.awt.Dimension(41, 28));
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnAdd.setText("Thêm SP");
        btnAdd.setMaximumSize(new java.awt.Dimension(63, 28));
        btnAdd.setMinimumSize(new java.awt.Dimension(63, 28));
        btnAdd.setPreferredSize(new java.awt.Dimension(63, 28));
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        lblTotal.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblTotal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTotal.setText("Tổng:");
        lblTotal.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        btnReset.setText("Đặt lại");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        btnSubmit.setText("Lưu");
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
                .addGap(0, 0, 0)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSubmit)
                    .addComponent(btnReset))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Sản phẩm:");

        txtProduct.setEditable(false);
        txtProduct.setBackground(ConstantHelper.SECTION_PANEL_BG);
        txtProduct.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Số lượng:");

        spnQuantity.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        spnQuantity.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));
        spnQuantity.setEditor(new javax.swing.JSpinner.NumberEditor(spnQuantity, ""));
        spnQuantity.setEnabled(false);

        btnUpdate.setText("Cập nhật");
        btnUpdate.setEnabled(false);
        btnUpdate.setMaximumSize(new java.awt.Dimension(67, 28));
        btnUpdate.setMinimumSize(new java.awt.Dimension(67, 28));
        btnUpdate.setPreferredSize(new java.awt.Dimension(67, 28));
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblTotal))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtProduct)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(spnQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(14, 14, 14)
                                .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1))))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnAdd, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(txtProduct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)
                        .addComponent(spnQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTotal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 7, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {spnQuantity, txtProduct});

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnAdd, btnDelete});

    }// </editor-fold>//GEN-END:initComponents

    private void btnGoBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGoBackActionPerformed
        frmMainWindow.rootFrame.loadInSection(new pnlDetail(billId, employeeService, customerService, priceService, billService, billDetailService, productService, manufacturerService));
    }//GEN-LAST:event_btnGoBackActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        txtCustomer.setText("");
        txtNote.setText("");
        totalQuantity = 0;
        totalMoney = 0;
        lblTotal.setText(String.format(ConstantHelper.LBL_TOTAL_ADD_BILL, totalQuantity, IOHandler.convertToDisplayPriceString(totalMoney)));
        ((DefaultTableModel) tblProductList.getModel()).setRowCount(0);
        listBillDetails.clear();
        resetOrEnableProductField(false);
        loadOldData();
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
        if ("".equals(txtCustomer.getText())) {
            return;
        }
        int numProduct = listBillDetails.size();
        if (numProduct > 0) {
            Bill bill = new Bill();
            bill.setId(billId);
            bill.setNote(txtNote.getText());
            bill.setTotalMoney(totalMoney);
            try {
                billService.update(bill);
                billDetailService.updateFromList(listBillDetails);
                JOptionPane.showMessageDialog(frmMainWindow.rootFrame, ConstantHelper.BILL_UPDATE_DONE_MESSAGE);
                btnGoBackActionPerformed(null);
            } catch (SQLException ex) {
                Logger.getLogger(pnlEdit.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnSubmitActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        if (tblProductList.getSelectedRowCount() > 0) {
            int[] selectedIndexes = tblProductList.getSelectedRows();
            DefaultTableModel model = (DefaultTableModel) tblProductList.getModel();
            for (int i = selectedIndexes.length -1; i >= 0; i--) {
                model.removeRow(selectedIndexes[i]);
                listBillDetails.remove(selectedIndexes[i]);
            }
            refreshTotal();
            tblProductList.clearSelection();
            resetOrEnableProductField(false);
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        JDialog d = new JDialog(frmMainWindow.rootFrame, ConstantHelper.PRODUCT_LIST_HEADING, true);
        com.ltnc.nhom3.view.product.pnlList list = new com.ltnc.nhom3.view.product.pnlList(priceService, 
                productService, manufacturerService, true, d);
        d.add(list);
        Dimension dim = list.getPreferredSize();
        d.setMinimumSize(new Dimension(dim.width, dim.height+20));
        d.setResizable(false);
        d.setLocationRelativeTo(frmMainWindow.rootFrame);
        d.setVisible(true);
        int productId = list.getReturnedProductId();
        
        if (productId != -1) {
            BillDetail billDetail = null;
            for (int i = 0; i < listBillDetails.size(); i++) {
                billDetail = listBillDetails.get(i);
                if (billDetail.getProductId() == productId) {
                    JOptionPane.showMessageDialog(frmMainWindow.rootFrame, ConstantHelper.BILL_DUPLICATE_PRODUCT_MESSAGE,
                            ConstantHelper.WARNING_DIALOG_TITLE, JOptionPane.WARNING_MESSAGE);
                    tblProductList.setRowSelectionInterval(i, i);
                    return;
                }
            }
            addNewToTable(productId);
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        try {
            spnQuantity.commitEdit();
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(frmMainWindow.rootFrame, ConstantHelper.NUMBER_INPUT_WRONG_MESSAGE);
            Logger.getLogger(pnlEdit.class.getName()).log(Level.SEVERE, null, ex);
            return;
        }
        int newQuantity = (int) spnQuantity.getValue(), selectedIndex = tblProductList.getSelectedRow();
        BillDetail billDetail = listBillDetails.get(selectedIndex);        
        double newSubTotal = newQuantity * billDetail.getSubTotal() / billDetail.getQuantity();
        billDetail.setSubTotal(newSubTotal);
        billDetail.setQuantity(newQuantity);
        tblProductList.setValueAt(newQuantity, selectedIndex, 3);
        tblProductList.setValueAt(IOHandler.convertToDisplayPriceString(newSubTotal), selectedIndex, 4);
        refreshTotal();
        tblProductList.clearSelection();
        resetOrEnableProductField(false);
    }//GEN-LAST:event_btnUpdateActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnGoBack;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSubmit;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblHeading;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JPanel pnlForm;
    private javax.swing.JPanel pnlLeft;
    private javax.swing.JPanel pnlRight;
    private javax.swing.JSpinner spnQuantity;
    private javax.swing.JTable tblProductList;
    private javax.swing.JTextField txtCustomer;
    private javax.swing.JTextField txtEmployeeAndDateCreated;
    private javax.swing.JTextPane txtNote;
    private javax.swing.JTextField txtProduct;
    // End of variables declaration//GEN-END:variables
   
    private void addNewToTable(int productId) {
        try {
            Product p = productService.findById(productId);
            Price price = priceService.findPriceByProductId(productId);
            double money = price.getValue();
            DefaultTableModel model = (DefaultTableModel) tblProductList.getModel();
            model.addRow(new Object[]{listBillDetails.size()+1, p.getName() + " - id: " + p.getId(), IOHandler.convertToDisplayPriceString(money), 1, IOHandler.convertToDisplayPriceString(money)});
            BillDetail billDetail = new BillDetail();
            billDetail.setProductId(productId);
            billDetail.setQuantity(1);
            billDetail.setSubTotal(money);
            billDetail.setBillId(billId);
            listBillDetails.add(billDetail);
            refreshTotal();
        } catch (SQLException ex) {
            Logger.getLogger(pnlEdit.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void addOldDataToTable(BillDetail billDetail) {
        try {
            int productId = billDetail.getProductId();
            Product p = productService.findById(productId);
            DefaultTableModel model = (DefaultTableModel) tblProductList.getModel();
            double subTotal = billDetail.getSubTotal();
            int quantity = billDetail.getQuantity();
            model.addRow(new Object[]{listBillDetails.size()+1, p.getName() + " - id: " + p.getId(), IOHandler.convertToDisplayPriceString(subTotal/quantity),
                billDetail.getQuantity(), IOHandler.convertToDisplayPriceString(billDetail.getSubTotal())});
            listBillDetails.add(billDetail);
        } catch (SQLException ex) {
            Logger.getLogger(pnlEdit.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void refreshTotal() {
        totalMoney = 0;
        totalQuantity = 0;
        for (BillDetail billDetail : listBillDetails) {
            totalMoney += billDetail.getSubTotal();
            totalQuantity += billDetail.getQuantity();
        }
        lblTotal.setText(String.format(ConstantHelper.LBL_TOTAL_ADD_BILL, totalQuantity, IOHandler.convertToDisplayPriceString(totalMoney)));
    }
}
