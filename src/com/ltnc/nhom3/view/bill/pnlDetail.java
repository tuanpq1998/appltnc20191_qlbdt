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
import java.awt.Font;
import java.awt.print.PrinterException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author admin
 */
public class pnlDetail extends javax.swing.JPanel {

    private int billId, totalPage, pageNum, totalItems;
    
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
    public pnlDetail(int id, EmployeeService employeeService, CustomerService customerService, PriceService priceService,
            BillService billService, BillDetailService billDetailService, ProductService productService,
            ManufacturerService manufacturerService) {
        this.employeeService = employeeService;
        this.customerService = customerService;
        this.priceService = priceService;
        this.billService = billService;
        this.manufacturerService = manufacturerService;
        this.billDetailService = billDetailService;
        this.productService = productService;
        this.billId = id;
        
        initComponents();
        jScrollPane1.getViewport().setBackground(ConstantHelper.SECTION_PANEL_BG);
        tblProductList.getTableHeader().setReorderingAllowed(false);
        lblHeading.setText(String.format(ConstantHelper.BILL_DETAIL_HEADING, billId));
        
        displayBillInfo();
    }
    
    private void displayBillInfo() {
        try {
            Bill bill = billService.findById(billId);
            int employeeId = bill.getEmployeeId(), customerId = bill.getCustomerId();

            lblCreateDate.setText(IOHandler.convertToDisplayDateTime(bill.getCreateDate()));
            txtNote.setText(bill.getNote());

            if (employeeId > 0) {
                Employee employee = employeeService.findById(employeeId);
                lblEmployeeCreated.setText(employee==null ? "" : employee.getFullname() 
                        + " (" + employee.getUsername() + ")");
            }
            if (customerId > 0) {
                Customer customer = customerService.findById(customerId);
                if (customer == null) {
                
                } else {
                    lblCustomerName.setText(customer.getFullname());
                    lblCustomerAddress.setText(customer.getAddress());
                    lblCustomerPhone.setText(customer.getPhone());
                }
            }
            getTotalPage();
            displayBillDetail(1);
            
            lblTotalMoneyAndQuantity.setText(String.format(ConstantHelper.LBL_TOTAL_ADD_BILL, billDetailService.findSumQuantityByBillId(billId), 
                    IOHandler.convertToDisplayPriceString(bill.getTotalMoney())));
        } catch (SQLException ex) {
            Logger.getLogger(pnlDetail.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void displayBillDetail(int pageNum) {
        this.pageNum = pageNum;
        reloadPaginationButtons();
        String[] titles = ConstantHelper.TBL_BILLDETAIL_TITLES;
        DefaultTableModel dtm = TableHelper.getNonEditableTableModel(titles);
        List<BillDetail> billDetails = null;
        try {
            billDetails = billDetailService.findAllByBillId(billId, pageNum);
            Object[] row = new Object[titles.length];
            if (billDetails.isEmpty()) {
                row[1] = ConstantHelper.NO_RESULT_MESSAGE;
                dtm.addRow(row);
            } else {
                Product product = null;
                BillDetail billDetail = null;
                for (int i = 0; i < billDetails.size(); i++) {
                    billDetail = billDetails.get(i);
                    
                    row[0] = i + (pageNum - 1) * ConstantHelper.ITEM_BILLDETAIL_PER_PAGE + 1;
                    row[3] = billDetail.getQuantity();
                    row[4] = IOHandler.convertToDisplayPriceString(billDetail.getSubTotal());
                    
                    product = productService.findById(billDetail.getProductId());
                    if (product != null) {
                        row[1] = product.getName() + " - id :" + product.getId();
                        row[2] = IOHandler.convertToDisplayPriceString(billDetail.getSubTotal() / billDetail.getQuantity());
                    }
                    dtm.addRow(row);
                }
            }
            tblProductList.setModel(dtm);
            TableHelper.setWidthForAllColumns(tblProductList, ConstantHelper.TBL_BILLDETAIL_WIDTHS);
        } catch (SQLException ex) {
            Logger.getLogger(pnlDetail.class.getName()).log(Level.SEVERE, null, ex);
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
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        pnlRight = SectionTemplate.getStyledPanel();
        lblCustomerName = new javax.swing.JLabel();
        lblCustomerAddress = new javax.swing.JLabel();
        lblCustomerPhone = new javax.swing.JLabel();
        lblEmployeeCreated = new javax.swing.JLabel();
        lblCreateDate = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtNote = new javax.swing.JTextPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProductList = new TableHelper.CustomTable();
        jPanel4 = SectionTemplate.getStyledPanel();
        btnNextPage = SectionTemplate.getStyledButton();
        btnPrevPage = SectionTemplate.getStyledButton();
        btnLastPage = SectionTemplate.getStyledButton();
        btnFirstPage = SectionTemplate.getStyledButton();
        lblPaginationStatus = new javax.swing.JLabel();
        jSeparator1 = SectionTemplate.getStyledSeparator();
        jPanel2 = SectionTemplate.getStyledPanel();
        btnPrint = SectionTemplate.getStyledButton();
        btnEdit = SectionTemplate.getStyledButton();
        lblTotalMoneyAndQuantity = new javax.swing.JLabel();

        setBackground(ConstantHelper.SECTION_PANEL_BG);

        lblHeading.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        lblHeading.setText(null);

        btnGoBack.setText("Quay lại");
        btnGoBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGoBackActionPerformed(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel22.setText("Họ tên KH:");
        jLabel22.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel22.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jLabel22.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        jLabel23.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel23.setText("Địa chỉ KH: ");
        jLabel23.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel23.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jLabel23.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        jLabel24.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel24.setText("Điện thoại KH:");
        jLabel24.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel24.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jLabel24.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        jLabel27.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel27.setText("Ngày tạo hóa đơn:");
        jLabel27.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel27.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jLabel27.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        jLabel28.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel28.setText("Nhân viên tạo:");
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
                .addContainerGap(74, Short.MAX_VALUE)
                .addGroup(pnlLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel22, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel23, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel24, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel27, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel28, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel29, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(10, 10, 10))
        );
        pnlLeftLayout.setVerticalGroup(
            pnlLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLeftLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel22)
                .addGap(20, 20, 20)
                .addComponent(jLabel23)
                .addGap(20, 20, 20)
                .addComponent(jLabel24)
                .addGap(20, 20, 20)
                .addComponent(jLabel27)
                .addGap(20, 20, 20)
                .addComponent(jLabel28)
                .addGap(24, 24, 24)
                .addComponent(jLabel29)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblCustomerName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblCustomerName.setText("Info");

        lblCustomerAddress.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblCustomerAddress.setText("Info");

        lblCustomerPhone.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblCustomerPhone.setText("Info");

        lblEmployeeCreated.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblEmployeeCreated.setText("Info");

        lblCreateDate.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblCreateDate.setText("Info");

        jScrollPane2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane2.setEnabled(false);

        txtNote.setEditable(false);
        txtNote.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jScrollPane2.setViewportView(txtNote);

        javax.swing.GroupLayout pnlRightLayout = new javax.swing.GroupLayout(pnlRight);
        pnlRight.setLayout(pnlRightLayout);
        pnlRightLayout.setHorizontalGroup(
            pnlRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRightLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCustomerName)
                    .addComponent(lblCustomerAddress)
                    .addComponent(lblCustomerPhone)
                    .addComponent(lblEmployeeCreated)
                    .addComponent(lblCreateDate)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(52, Short.MAX_VALUE))
        );
        pnlRightLayout.setVerticalGroup(
            pnlRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRightLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(lblCustomerName)
                .addGap(20, 20, 20)
                .addComponent(lblCustomerAddress)
                .addGap(20, 20, 20)
                .addComponent(lblCustomerPhone)
                .addGap(20, 20, 20)
                .addComponent(lblCreateDate)
                .addGap(20, 20, 20)
                .addComponent(lblEmployeeCreated)
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
                    .addComponent(pnlLeft, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlRight, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(337, 337, 337))
        );

        jScrollPane1.setBackground(ConstantHelper.SECTION_PANEL_BG);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        tblProductList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblProductList);

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
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(pnlForm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(21, 21, 21))
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 614, Short.MAX_VALUE))
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
                .addComponent(pnlForm, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

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
                .addGap(0, 0, 0))
        );

        btnPrint.setText("In");
        btnPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintActionPerformed(evt);
            }
        });

        btnEdit.setText("Sửa");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnPrint)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnEdit)
                .addGap(2, 2, 2))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEdit)
                    .addComponent(btnPrint))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblTotalMoneyAndQuantity.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblTotalMoneyAndQuantity.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTotalMoneyAndQuantity.setText("Tổng tiền");
        lblTotalMoneyAndQuantity.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTotalMoneyAndQuantity)
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTotalMoneyAndQuantity)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 7, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnGoBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGoBackActionPerformed
        frmMainWindow.rootFrame.loadInSection(new pnlList(employeeService, customerService, priceService, billService, billDetailService, productService, manufacturerService));
    }//GEN-LAST:event_btnGoBackActionPerformed

    private void btnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintActionPerformed
        try {
            Bill bill = billService.findById(billId);
            int employeeID = bill.getEmployeeId(), customerID = bill.getCustomerId();
            Customer customer = customerService.findById(customerID);
            Employee employee = employeeService.findById(employeeID);
            Product product = null;
            Price price = null;
            StringBuilder sb = new StringBuilder();
            String rule = "-------------+-----------+---+------------\n", cell = "%-12.12s| %-10.10s| %-2.2s| %-11.11s\n";
            sb.append("  --------CỬA HÀNG ĐIỆN THOẠI--------\n")
                    .append("\n               Hóa đơn bán\n")
                    .append("                   ***                    \n")
                    .append("Nhân viên : ").append(employee.getFullname()).append("\n")
                    .append("Tài khoản : ").append(employee.getUsername()).append("\n")
                    .append("                   ***                    \n")
                    .append("Mã hóa đơn : ").append(bill.getId()).append("\n")
                    .append("Ngày tạo : ").append(IOHandler.convertToDisplayDateTime(bill.getCreateDate())).append("\n")
                    .append("Ngày in : ").append(IOHandler.convertToDisplayDateTime(new Date())).append("\n")
                    .append("                   ***                    \n")
                    .append("Tên khách hàng  : ").append(customer.getFullname()).append("\n")
                    .append("Địa chỉ KH : ").append(customer.getAddress()).append("\n")
                    .append("Số điện thoại : ").append(customer.getPhone()).append("\n")
                    .append("                   ***                    \n")
                    .append("DS SẢN PHẨM :  \n");
            sb.append(rule).append(" SP          | Đ.giá     | SL| T.tiền      \n")
                    .append(rule);
            List<BillDetail> billDetails = billDetailService.findAllByBillId(billId);
            String productName = null, quantity = null, subTotal = null, priceStr = null;
            for (BillDetail billDetail : billDetails) {
                product = productService.findById(billDetail.getProductId());
                price = priceService.findPriceByProductId(billDetail.getProductId());
                productName = product.getName() + " [" + product.getId() + "]";
                quantity = billDetail.getQuantity() + "";
                subTotal = IOHandler.convertToDisplayPriceString(billDetail.getSubTotal());
                priceStr = IOHandler.convertToDisplayPriceString(price.getValue());
                int temp1 = (int) Math.ceil(productName.length() / 11.0f),
                        temp2 = (int) Math.ceil(priceStr.length() / 10.0f),
                        temp3 = (int) Math.ceil(quantity.length() / 2.0f),
                        temp4 = (int) Math.ceil(subTotal.length() / 11.0f),
                        largest = Collections.max(Arrays.asList(temp1, temp2, temp3, temp4));
                for (int i = 0; i < largest; i++) {
                    String tempStr1 = (i * 11 > productName.length() ? "" : productName.substring(i * 11)),
                            tempStr2 = (i * 9 > priceStr.length() ? "" : priceStr.substring(i * 10)),
                            tempStr3 = (i * 3 > quantity.length() ? "" : quantity.substring(i * 2)),
                            tempStr4 = (i * 11 > subTotal.length() ? "" : subTotal.substring(i * 11));
                    sb.append(" ").append(String.format(cell, tempStr1, tempStr2, tempStr3, tempStr4));
                }
                sb.append(rule);
            }
            sb.append("                   ***                    \n")
                    .append("TỔNG TIỀN : ").append(IOHandler.convertToDisplayPriceString(bill.getTotalMoney()))
                    .append("\n").append("CẢM ƠN QUÝ KHÁCH!")
                    .append("\n-----------------------------------------------------------\n");
            JTextArea printArea = new JTextArea(sb.toString());
            printArea.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 10));
            printArea.print();
        } catch (SQLException | PrinterException ex) {
            Logger.getLogger(pnlDetail.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnPrintActionPerformed
    
    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        frmMainWindow.rootFrame.loadInSection(new pnlEdit(billId, employeeService, customerService, priceService, billService, billDetailService, productService, manufacturerService));
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnNextPageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextPageActionPerformed
        displayBillDetail(++pageNum);
    }//GEN-LAST:event_btnNextPageActionPerformed

    private void btnPrevPageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrevPageActionPerformed
        displayBillDetail(--pageNum);
    }//GEN-LAST:event_btnPrevPageActionPerformed

    private void btnLastPageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLastPageActionPerformed
        pageNum = totalPage;
        displayBillDetail(pageNum);
    }//GEN-LAST:event_btnLastPageActionPerformed

    private void btnFirstPageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFirstPageActionPerformed
        pageNum = 1;
        displayBillDetail(pageNum);
    }//GEN-LAST:event_btnFirstPageActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnFirstPage;
    private javax.swing.JButton btnGoBack;
    private javax.swing.JButton btnLastPage;
    private javax.swing.JButton btnNextPage;
    private javax.swing.JButton btnPrevPage;
    private javax.swing.JButton btnPrint;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblCreateDate;
    private javax.swing.JLabel lblCustomerAddress;
    private javax.swing.JLabel lblCustomerName;
    private javax.swing.JLabel lblCustomerPhone;
    private javax.swing.JLabel lblEmployeeCreated;
    private javax.swing.JLabel lblHeading;
    private javax.swing.JLabel lblPaginationStatus;
    private javax.swing.JLabel lblTotalMoneyAndQuantity;
    private javax.swing.JPanel pnlForm;
    private javax.swing.JPanel pnlLeft;
    private javax.swing.JPanel pnlRight;
    private javax.swing.JTable tblProductList;
    private javax.swing.JTextPane txtNote;
    // End of variables declaration//GEN-END:variables

    private void getTotalPage() {
        try {
            totalItems = billDetailService.countAllByBillId(billId);
            totalPage = totalItems / ConstantHelper.ITEM_BILLDETAIL_PER_PAGE 
                    + (totalItems % ConstantHelper.ITEM_BILLDETAIL_PER_PAGE ==  0 ? 0 : 1);
        } catch (SQLException ex) {
            Logger.getLogger(com.ltnc.nhom3.view.employee.pnlList.class.getName()).log(Level.SEVERE, null, ex);
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
