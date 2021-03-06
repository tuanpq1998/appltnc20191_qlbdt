/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ltnc.nhom3.view.employee;

import com.ltnc.nhom3.entity.Employee;
import com.ltnc.nhom3.service.EmployeeService;
import com.ltnc.nhom3.utility.ConstantHelper;
import com.ltnc.nhom3.utility.IOHandler;
import com.ltnc.nhom3.view.template.SectionTemplate;
import com.ltnc.nhom3.view.frmMainWindow;
import java.awt.Color;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author admin
 */
public class pnlDetail extends javax.swing.JPanel {

    private Employee employee;
    private EmployeeService employeeService;
    
    /**
     * Creates new form pnlDetail
     * @param id
     * @param productService
     */   
    public pnlDetail(int id, EmployeeService employeeService) {
        this.employeeService = employeeService;
        initComponents();
        try {
            employee = employeeService.findById(id);
            displayProductInfo();
        } catch (SQLException ex) {
            Logger.getLogger(pnlDetail.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void displayProductInfo() {
        lblHeading.setText(employee.getUsername());
        lblFullname.setText(employee.getFullname());
        lblAddress.setText(employee.getAddress() == null ? ConstantHelper.NO_INFORMATION_MESSAGE
                : employee.getAddress());
        lblPhone.setText(employee.getPhone() == null ? ConstantHelper.NO_INFORMATION_MESSAGE
                : employee.getPhone());
        lblIdentityCard.setText(employee.getIndentityCard() == null ? ConstantHelper.NO_INFORMATION_MESSAGE
                : employee.getIndentityCard());
        lblUsername.setText(employee.getUsername());
        lblGender.setText(employee.isMale() ? ConstantHelper.EMPLOYEE_GENDER_MALE 
                : ConstantHelper.EMPLOYEE_GENDER_FEMALE);
        if (employee.isActive()) {
            btnDisableOrEnable.setText(ConstantHelper.EMPLOYEE_DISABLE_ACTIVE_STATUS_BTN_TEXT);
            lblStatus.setText(ConstantHelper.ACCOUNT_ACTIVE_TEXT);
            lblStatus.setForeground(Color.green);
        } else {
            btnDisableOrEnable.setText(ConstantHelper.EMPLOYEE_ENABLE_ACTIVE_STATUS_BTN_TEXT);
            lblStatus.setText(ConstantHelper.ACCOUNT_DEACTIVE_TEXT);
            lblStatus.setForeground(Color.red);
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
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        pnlRight = SectionTemplate.getStyledPanel();
        lblFullname = new javax.swing.JLabel();
        lblAddress = new javax.swing.JLabel();
        lblPhone = new javax.swing.JLabel();
        lblIdentityCard = new javax.swing.JLabel();
        lblUsername = new javax.swing.JLabel();
        lblStatus = new javax.swing.JLabel();
        lblGender = new javax.swing.JLabel();
        jSeparator1 = SectionTemplate.getStyledSeparator();
        jPanel2 = SectionTemplate.getStyledPanel();
        btnDisableOrEnable = SectionTemplate.getStyledButton();
        btnEdit = SectionTemplate.getStyledButton();
        btnResetPassword = SectionTemplate.getStyledButton();

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
        jLabel22.setText("Họ tên:");
        jLabel22.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel22.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jLabel22.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        jLabel23.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel23.setText("Địa chỉ:");
        jLabel23.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel23.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jLabel23.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        jLabel24.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel24.setText("Điện thoại:");
        jLabel24.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel24.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jLabel24.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        jLabel26.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel26.setText("Trạng thái:");
        jLabel26.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel26.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jLabel26.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        jLabel27.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel27.setText("Giới tính:");
        jLabel27.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel27.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jLabel27.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        jLabel28.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel28.setText("Số CMND:");
        jLabel28.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel28.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jLabel28.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        jLabel29.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel29.setText("Tài khoản:");
        jLabel29.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel29.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jLabel29.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout pnlLeftLayout = new javax.swing.GroupLayout(pnlLeft);
        pnlLeft.setLayout(pnlLeftLayout);
        pnlLeftLayout.setHorizontalGroup(
            pnlLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLeftLayout.createSequentialGroup()
                .addContainerGap(111, Short.MAX_VALUE)
                .addGroup(pnlLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel22, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel23, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel24, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel27, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel28, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel26, javax.swing.GroupLayout.Alignment.TRAILING)
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
                .addGap(20, 20, 20)
                .addComponent(jLabel29)
                .addGap(20, 20, 20)
                .addComponent(jLabel26)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblFullname.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblFullname.setText("Info");

        lblAddress.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblAddress.setText("Info");

        lblPhone.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblPhone.setText("Info");

        lblIdentityCard.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblIdentityCard.setText("Info");

        lblUsername.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblUsername.setText("Info");

        lblStatus.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        lblStatus.setText("Info");

        lblGender.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblGender.setText("Info");

        javax.swing.GroupLayout pnlRightLayout = new javax.swing.GroupLayout(pnlRight);
        pnlRight.setLayout(pnlRightLayout);
        pnlRightLayout.setHorizontalGroup(
            pnlRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRightLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblFullname)
                    .addComponent(lblAddress)
                    .addComponent(lblPhone)
                    .addComponent(lblIdentityCard)
                    .addComponent(lblUsername)
                    .addComponent(lblStatus)
                    .addComponent(lblGender))
                .addContainerGap(321, Short.MAX_VALUE))
        );
        pnlRightLayout.setVerticalGroup(
            pnlRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRightLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(lblFullname)
                .addGap(20, 20, 20)
                .addComponent(lblAddress)
                .addGap(20, 20, 20)
                .addComponent(lblPhone)
                .addGap(20, 20, 20)
                .addComponent(lblGender)
                .addGap(20, 20, 20)
                .addComponent(lblIdentityCard)
                .addGap(20, 20, 20)
                .addComponent(lblUsername)
                .addGap(20, 20, 20)
                .addComponent(lblStatus)
                .addContainerGap())
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
                .addGroup(pnlFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(pnlRight, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlLeft, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
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
                                .addComponent(pnlForm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(31, 31, 31))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblHeading, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnGoBack)))))
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
                .addComponent(pnlForm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        btnDisableOrEnable.setText("Khóa");
        btnDisableOrEnable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDisableOrEnableActionPerformed(evt);
            }
        });

        btnEdit.setText("Sửa");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnResetPassword.setText("Đặt lại mật khẩu");
        btnResetPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetPasswordActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnResetPassword)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnDisableOrEnable)
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
                    .addComponent(btnDisableOrEnable)
                    .addComponent(btnResetPassword))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jSeparator1))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 7, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnGoBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGoBackActionPerformed
        frmMainWindow.rootFrame.loadInSection(new pnlList(employeeService));
    }//GEN-LAST:event_btnGoBackActionPerformed

    private void btnDisableOrEnableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDisableOrEnableActionPerformed
        int option = JOptionPane.showConfirmDialog(frmMainWindow.rootFrame,
                ConstantHelper.CONFIRM_DIALOG_MESSAGE, ConstantHelper.CONFIRM_DIALOG_TITLE, JOptionPane.YES_NO_OPTION);
        if (option == JOptionPane.YES_OPTION) {
            try {
                if (employee.isActive()) {
                    if (employeeService.disableById(employee.getId())) {
                        employee = employeeService.findById(employee.getId());
                        displayProductInfo();
                    }
                } else {
                    if (employeeService.enableById(employee.getId())) {
                        employee = employeeService.findById(employee.getId());
                        displayProductInfo();
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(pnlList.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnDisableOrEnableActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        frmMainWindow.rootFrame.loadInSection(new pnlForm(employeeService, employee.getId()));
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnResetPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetPasswordActionPerformed
        int option = JOptionPane.showConfirmDialog(frmMainWindow.rootFrame,
                ConstantHelper.CONFIRM_DIALOG_MESSAGE, ConstantHelper.CONFIRM_DIALOG_TITLE, JOptionPane.YES_NO_OPTION);
        if (option == JOptionPane.YES_OPTION) {
            try {
                String newPassword = IOHandler.generatePassword(employee.getUsername());
                employeeService.updatePassword(employee.getId(), newPassword);
                JOptionPane.showMessageDialog(frmMainWindow.rootFrame, 
                        String.format(ConstantHelper.EMPLOYEE_RESET_PASSWORD_DONE_MESSAGE, newPassword));
            } catch (SQLException ex) {
                Logger.getLogger(pnlList.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnResetPasswordActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDisableOrEnable;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnGoBack;
    private javax.swing.JButton btnResetPassword;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblAddress;
    private javax.swing.JLabel lblFullname;
    private javax.swing.JLabel lblGender;
    private javax.swing.JLabel lblHeading;
    private javax.swing.JLabel lblIdentityCard;
    private javax.swing.JLabel lblPhone;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JPanel pnlForm;
    private javax.swing.JPanel pnlLeft;
    private javax.swing.JPanel pnlRight;
    // End of variables declaration//GEN-END:variables
}
