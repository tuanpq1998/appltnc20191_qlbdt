/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ltnc.nhom3.view;

import com.ltnc.nhom3.view.account.dloLogin;
import com.ltnc.nhom3.entity.Employee;
import com.ltnc.nhom3.service.BillDetailService;
import com.ltnc.nhom3.service.BillService;
import com.ltnc.nhom3.service.CustomerService;
import com.ltnc.nhom3.service.EmployeeService;
import com.ltnc.nhom3.service.ManufacturerService;
import com.ltnc.nhom3.service.PriceService;
import com.ltnc.nhom3.service.ProductService;
import com.ltnc.nhom3.view.template.MenuTemplate;
import com.ltnc.nhom3.view.template.SectionTemplate;
import com.ltnc.nhom3.utility.ConstantHelper;
import com.ltnc.nhom3.utility.IOHandler;
import com.ltnc.nhom3.view.account.pnlInfo;
import com.ltnc.nhom3.view.product.pnlList;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

/**
 *
 * @author admin
 */
public class frmMainWindow extends javax.swing.JFrame {
    private final int MAX_NUM_TAB = 6;
    private List<Integer> listTabMode = new ArrayList<>();

    private EmployeeService employeeService;
    private BillDetailService billDetailService;
    private BillService billService;
    private CustomerService customerService;
    private ManufacturerService manufacturerService;
    private PriceService priceService;
    private ProductService productService;

    private Employee loggedInEmployee;
    public static frmMainWindow rootFrame;
    private boolean isCollapse = true;

    /**
     * Creates new form frmMainWindow
     */
    public frmMainWindow() {
        rootFrame = this;
        listTabMode.add(ConstantHelper.MAIN_FRAME_INIT_MODE);
        setIconImages(IOHandler.getIconList());
        initComponents();
        
        updateTitleForHomeTab("Home");
        createFakeTabWithAddSymbol();
        loadInSection(new pnlBlank());
        
        employeeService = new EmployeeService();
        billDetailService = new BillDetailService();
        billService = new BillService();
        customerService = new CustomerService();
        manufacturerService = new ManufacturerService();
        priceService = new PriceService();
        productService = new ProductService();

        showLoginDialog();
        if (!loggedInEmployee.isAdmin()) {
            btnEmployee.setEnabled(false);
        }
        if (!loggedInEmployee.isActive()) {
            btnEmployee.setEnabled(false);
            btnCustomer.setEnabled(false);
            btnProduct.setEnabled(false);
            btnBill.setEnabled(false);
        }

        displayUserInLogoutButton();
    }
    
    private void updateTitleForHomeTab(String title) {
        JLabel label = new JLabel(title, JLabel.CENTER);
        label.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        label.setPreferredSize(new Dimension(80, 28));
        pnlTab.setTabComponentAt(0, label);
        pnlTab.setToolTipTextAt(0, title);
    }

    private void setTabHeaderWithCloseBtn(String title, int index) {
        JLabel headerTitle = new JLabel(title.length() > 10 ? title.substring(0, 10) + "..." : title, JLabel.CENTER);
        pnlTab.setToolTipTextAt(1, title);
        headerTitle.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        JButton closeButton = new JButton("\u274C");
        closeButton.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 10));
        closeButton.setContentAreaFilled(false);
        closeButton.setFocusable(false);
        closeButton.setBorder(BorderFactory.createEmptyBorder());
        closeButton.setBackground(ConstantHelper.SECTION_PANEL_BG);
        closeButton.setPreferredSize(new Dimension(15, 14));
        closeButton.setOpaque(true);
        closeButton.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                closeButton.setBackground(new Color(241, 241, 241));
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                closeButton.setBackground(ConstantHelper.SECTION_PANEL_BG);
            }
        });
        JPanel pnlHeader = new JPanel();
        pnlHeader.add(headerTitle, BorderLayout.WEST);
        pnlHeader.add(closeButton, BorderLayout.EAST);
        pnlHeader.setPreferredSize(new Dimension(95, 28));
        listTabMode.add(ConstantHelper.MAIN_FRAME_INIT_MODE);
        pnlTab.setTabComponentAt(index, pnlHeader);
        closeButton.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i = pnlTab.indexOfTabComponent(pnlHeader);
                if (i != -1) {
                    listTabMode.remove(i);
                    pnlTab.remove(i);
                    if (i == pnlTab.getTabCount()-1) 
                        pnlTab.setSelectedIndex(i-1);
                    else reloadGroupButtonsInTab();
                }
            }
        });
    }

    private void createFakeTabWithAddSymbol() {
        JButton addButton = new JButton("\u2795");
        addButton.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 10));
        addButton.setContentAreaFilled(false);
        addButton.setFocusable(false);
        addButton.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        addButton.setBackground(ConstantHelper.SECTION_PANEL_BG);
        addButton.setPreferredSize(new Dimension(15, 20));
        addButton.setOpaque(true);
        addButton.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                addButton.setBackground(new Color(241, 241, 241));
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                addButton.setBackground(ConstantHelper.SECTION_PANEL_BG);
            }
        });
        JPanel pnlHeader = new JPanel();
        pnlHeader.add(addButton);
        pnlTab.addTab(null, new JPanel());
        pnlTab.setTabComponentAt(pnlTab.getTabCount() - 1, pnlHeader);
        pnlTab.setEnabledAt(pnlTab.getTabCount() - 1, false);
        addButton.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (pnlTab.getTabCount() > MAX_NUM_TAB)
                    JOptionPane.showMessageDialog(frmMainWindow.rootFrame, ConstantHelper.CREATE_TAB_NOT_ALLOWED_MESSAGE);
                else {
                    pnlTab.remove(pnlTab.getTabCount() - 1);
                    pnlTab.addTab(null, new pnlBlank());
                    setTabHeaderWithCloseBtn(ConstantHelper.NEW_TAB_DEFAULT_TITLE, pnlTab.getTabCount() - 1);
                    pnlTab.setSelectedIndex(pnlTab.getTabCount() - 1);
                    createFakeTabWithAddSymbol();
                }
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        groupBtnMenu = new javax.swing.ButtonGroup();
        pnlMenu = MenuTemplate.getStyledPanel();
        pnlMenuContainer = MenuTemplate.getStyledPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = MenuTemplate.getStyledSeparator();
        btnProduct = MenuTemplate.getStyledButton();
        btnCustomer = MenuTemplate.getStyledButton();
        btnBill = MenuTemplate.getStyledButton();
        btnEmployee = MenuTemplate.getStyledButton();
        jSeparator3 = MenuTemplate.getStyledSeparator();
        btnLogOut = MenuTemplate.getStyledSecondaryButton();
        jLabel2 = new javax.swing.JLabel();
        jSeparator4 = MenuTemplate.getStyledSeparator();
        btnAccount = MenuTemplate.getStyledSecondaryButton();
        btnCollapseMenu = MenuTemplate.getStyledSecondaryButton();
        pnlSection = SectionTemplate.getStyledPanel();
        pnlInSection = new javax.swing.JPanel();
        pnlTab = new javax.swing.JTabbedPane() {
            public void setSelectedIndex(int index) {
                super.setSelectedIndex(index);
                reloadGroupButtonsInTab();
            }
        };
        pnlTabHome = new javax.swing.JTabbedPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("App nhom 3");
        setMinimumSize(new java.awt.Dimension(990, 768));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel1.setBackground(pnlMenu.getBackground());
        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("App");
        jLabel1.setOpaque(true);

        groupBtnMenu.add(btnProduct);
        btnProduct.setText("Sản phẩm");
        btnProduct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnMenuSelectMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnMenuSelectMouseExited(evt);
            }
        });
        btnProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProductActionPerformed(evt);
            }
        });

        groupBtnMenu.add(btnCustomer);
        btnCustomer.setText("Khách hàng");
        btnCustomer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnMenuSelectMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnMenuSelectMouseExited(evt);
            }
        });
        btnCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCustomerActionPerformed(evt);
            }
        });

        groupBtnMenu.add(btnBill);
        btnBill.setText("Hóa đơn");
        btnBill.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnMenuSelectMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnMenuSelectMouseExited(evt);
            }
        });
        btnBill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBillActionPerformed(evt);
            }
        });

        groupBtnMenu.add(btnEmployee);
        btnEmployee.setText("Nhân viên");
        btnEmployee.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnMenuSelectMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnMenuSelectMouseExited(evt);
            }
        });
        btnEmployee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmployeeActionPerformed(evt);
            }
        });

        btnLogOut.setText("Đăng xuất");
        btnLogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogOutActionPerformed(evt);
            }
        });

        jLabel2.setBackground(pnlMenu.getBackground());
        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nhóm 3 - LTNC 20191");
        jLabel2.setOpaque(true);

        btnAccount.setText("Tài khoản");
        btnAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAccountActionPerformed(evt);
            }
        });

        btnCollapseMenu.setText(ConstantHelper.COLLAPSE_MENU_TEXT);
        btnCollapseMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCollapseMenuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlMenuContainerLayout = new javax.swing.GroupLayout(pnlMenuContainer);
        pnlMenuContainer.setLayout(pnlMenuContainerLayout);
        pnlMenuContainerLayout.setHorizontalGroup(
            pnlMenuContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator3)
            .addComponent(jSeparator4)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMenuContainerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlMenuContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addGroup(pnlMenuContainerLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMenuContainerLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel2)))
                .addContainerGap())
            .addComponent(btnProduct, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnCustomer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnBill, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnEmployee, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnlMenuContainerLayout.createSequentialGroup()
                .addGroup(pnlMenuContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLogOut, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCollapseMenu))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pnlMenuContainerLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnAccount, btnCollapseMenu, btnLogOut});

        pnlMenuContainerLayout.setVerticalGroup(
            pnlMenuContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMenuContainerLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(btnProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnBill, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 223, Short.MAX_VALUE)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCollapseMenu)
                .addGap(0, 0, 0)
                .addComponent(btnAccount)
                .addGap(0, 0, 0)
                .addComponent(btnLogOut)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pnlMenuContainerLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnAccount, btnCollapseMenu, btnEmployee, btnLogOut});

        javax.swing.GroupLayout pnlMenuLayout = new javax.swing.GroupLayout(pnlMenu);
        pnlMenu.setLayout(pnlMenuLayout);
        pnlMenuLayout.setHorizontalGroup(
            pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMenuLayout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(pnlMenuContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        pnlMenuLayout.setVerticalGroup(
            pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMenuLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(pnlMenuContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnlInSection.setBackground(new java.awt.Color(241, 241, 241));

        pnlTab.addTab("tab1", pnlTabHome);

        javax.swing.GroupLayout pnlInSectionLayout = new javax.swing.GroupLayout(pnlInSection);
        pnlInSection.setLayout(pnlInSectionLayout);
        pnlInSectionLayout.setHorizontalGroup(
            pnlInSectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlTab, javax.swing.GroupLayout.DEFAULT_SIZE, 698, Short.MAX_VALUE)
        );
        pnlInSectionLayout.setVerticalGroup(
            pnlInSectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlTab)
        );

        javax.swing.GroupLayout pnlSectionLayout = new javax.swing.GroupLayout(pnlSection);
        pnlSection.setLayout(pnlSectionLayout);
        pnlSectionLayout.setHorizontalGroup(
            pnlSectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlInSection, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlSectionLayout.setVerticalGroup(
            pnlSectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlInSection, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pnlSection, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlSection, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnMenuSelectMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMenuSelectMouseEntered
        JToggleButton button = (JToggleButton) evt.getComponent();
        setStyleForButton(button, ConstantHelper.STT_BTN_HOVER);
    }//GEN-LAST:event_btnMenuSelectMouseEntered

    private void btnMenuSelectMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMenuSelectMouseExited
        JToggleButton button = (JToggleButton) evt.getComponent();
        if (button.isSelected()) {
            setStyleForButton(button, ConstantHelper.STT_BTN_SELECTED);
        } else {
            setStyleForButton(button, ConstantHelper.STT_BTN_NORMAL);
        }
    }//GEN-LAST:event_btnMenuSelectMouseExited

    private void btnProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProductActionPerformed
        int indexTab = pnlTab.getSelectedIndex();
        if (listTabMode.get(indexTab) != ConstantHelper.MAIN_FRAME_PRODUCT_MODE) {
            loadInSection(btnProduct.getText(), new pnlList(priceService, productService, manufacturerService));
            listTabMode.set(indexTab, ConstantHelper.MAIN_FRAME_PRODUCT_MODE);
            reloadGroupButtons();
        }
    }//GEN-LAST:event_btnProductActionPerformed

    private void btnCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCustomerActionPerformed
        int indexTab = pnlTab.getSelectedIndex();
        if (listTabMode.get(indexTab) != ConstantHelper.MAIN_FRAME_CUSTOMER_MODE) {
            listTabMode.set(indexTab, ConstantHelper.MAIN_FRAME_CUSTOMER_MODE);
            reloadGroupButtons();
            loadInSection(btnCustomer.getText(), new com.ltnc.nhom3.view.customer.pnlList(customerService));
        }
    }//GEN-LAST:event_btnCustomerActionPerformed

    private void btnBillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBillActionPerformed
        int indexTab = pnlTab.getSelectedIndex();
        if (listTabMode.get(indexTab) != ConstantHelper.MAIN_FRAME_BILL_MODE) {
            loadInSection(btnBill.getText(), 
                    new com.ltnc.nhom3.view.bill.pnlList(employeeService, customerService, priceService, 
                            billService, billDetailService, productService, manufacturerService));
            listTabMode.set(indexTab, ConstantHelper.MAIN_FRAME_BILL_MODE);
            reloadGroupButtons();
        }
    }//GEN-LAST:event_btnBillActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        if (JOptionPane.showConfirmDialog(isActive() ? rootFrame : null, 
                ConstantHelper.CONFIRM_LOGOUT_DIALOG_MESSAGE, ConstantHelper.CONFIRM_LOGOUT_DIALOG_TITLE, 
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            this.dispose();
            new frmMainWindow().setVisible(true);
        } else {
            setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        }
    }//GEN-LAST:event_formWindowClosing

    private void btnLogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogOutActionPerformed
        formWindowClosing(null);
    }//GEN-LAST:event_btnLogOutActionPerformed

    private void btnEmployeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmployeeActionPerformed
        int indexTab = pnlTab.getSelectedIndex();
        if (listTabMode.get(indexTab) != ConstantHelper.MAIN_FRAME_EMPLOYEE_MODE) {
            loadInSection(btnEmployee.getText(), new com.ltnc.nhom3.view.employee.pnlList(employeeService));
            listTabMode.set(indexTab, ConstantHelper.MAIN_FRAME_EMPLOYEE_MODE);
            reloadGroupButtons();
        }
    }//GEN-LAST:event_btnEmployeeActionPerformed

    private void btnAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAccountActionPerformed
        loadInSection(new pnlInfo(loggedInEmployee, employeeService));
    }//GEN-LAST:event_btnAccountActionPerformed

    private void btnCollapseMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCollapseMenuActionPerformed
        javax.swing.GroupLayout pnlMenuLayout = new javax.swing.GroupLayout(pnlMenu);
        pnlMenu.setLayout(pnlMenuLayout);
        if (isCollapse) {
            pnlMenuLayout.setHorizontalGroup(
                    pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMenuLayout.createSequentialGroup()
                                    .addComponent(pnlMenuContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            )
            );
            pnlMenuLayout.setVerticalGroup(
                    pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlMenuLayout.createSequentialGroup()
                                    .addGap(30, 30, 30)
                                    .addComponent(pnlMenuContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addContainerGap())
            );
            btnCollapseMenu.setText(ConstantHelper.EXPAND_MENU_TEXT);
        } else {
            pnlMenuLayout.setHorizontalGroup(
                    pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMenuLayout.createSequentialGroup()
                                    .addContainerGap(20, Short.MAX_VALUE)
                                    .addComponent(pnlMenuContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(20, 20, 20))
            );
            pnlMenuLayout.setVerticalGroup(
                    pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlMenuLayout.createSequentialGroup()
                                    .addGap(30, 30, 30)
                                    .addComponent(pnlMenuContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addContainerGap())
            );
            btnCollapseMenu.setText(ConstantHelper.COLLAPSE_MENU_TEXT);
        }
        isCollapse = !isCollapse;
    }//GEN-LAST:event_btnCollapseMenuActionPerformed

    private void setStyleForButton(JToggleButton button, int status) {
        Color color = null;
        switch (status) {
            case ConstantHelper.STT_BTN_SELECTED:
                color = ConstantHelper.MENU_BTN_BG_SELECTED;
                break;
            case ConstantHelper.STT_BTN_HOVER:
                color = ConstantHelper.MENU_BTN_BG_HOVER;
                break;
            case ConstantHelper.STT_BTN_NORMAL:
                color = ConstantHelper.MENU_PANEL_BG;
                break;
        }
        button.setBackground(color);
    }

    private void reloadGroupButtons() {
        for (Enumeration<AbstractButton> buttons = groupBtnMenu.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();
            if (button.isSelected()) {
                setStyleForButton((JToggleButton) button, ConstantHelper.STT_BTN_SELECTED);
            } else {
                setStyleForButton((JToggleButton) button, ConstantHelper.STT_BTN_NORMAL);
            }
        }
    }

    private void showLoginDialog() {
        loggedInEmployee = null;
        dloLogin loginForm = new dloLogin(frmMainWindow.rootFrame, true, employeeService);
        loginForm.setVisible(true);
        loggedInEmployee = loginForm.getLoggedInEmployee();
    }

    public void loadInSection(JPanel panel) {
        pnlTab.setComponentAt(pnlTab.getSelectedIndex(), panel);
    }
    
    public void loadInSection(String title, JPanel panel) {
        if (pnlTab.getSelectedIndex() != 0)
            setTabHeaderWithCloseBtn(title, pnlTab.getSelectedIndex());
        else {
            updateTitleForHomeTab(title);
        }
        loadInSection(panel);
    }

    private void displayUserInLogoutButton() {
        if (loggedInEmployee.getUsername().length() > 8) {
            btnLogOut.setText(String.format(ConstantHelper.LOGOUT_BTN_TEXT,
                    loggedInEmployee.getUsername().substring(0, 8) + "..."));
        } else {
            btnLogOut.setText(String.format(ConstantHelper.LOGOUT_BTN_TEXT,
                    loggedInEmployee.getUsername()));
        }
        btnLogOut.setToolTipText(String.format(ConstantHelper.LOGOUT_BTN_TEXT,
                loggedInEmployee.getUsername()));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAccount;
    private javax.swing.JToggleButton btnBill;
    private javax.swing.JButton btnCollapseMenu;
    private javax.swing.JToggleButton btnCustomer;
    private javax.swing.JToggleButton btnEmployee;
    private javax.swing.JButton btnLogOut;
    private javax.swing.JToggleButton btnProduct;
    private javax.swing.ButtonGroup groupBtnMenu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JPanel pnlInSection;
    private javax.swing.JPanel pnlMenu;
    private javax.swing.JPanel pnlMenuContainer;
    private javax.swing.JPanel pnlSection;
    private javax.swing.JTabbedPane pnlTab;
    private javax.swing.JTabbedPane pnlTabHome;
    // End of variables declaration//GEN-END:variables

    public void reloadFollowMode() {
        switch (listTabMode.get(pnlTab.getSelectedIndex())) {
            case ConstantHelper.MAIN_FRAME_BILL_MODE:
                loadInSection(new com.ltnc.nhom3.view.bill.pnlList(employeeService, 
                        customerService, priceService, billService, billDetailService, 
                        productService, manufacturerService));
                break;
            case ConstantHelper.MAIN_FRAME_CUSTOMER_MODE:
                loadInSection(new com.ltnc.nhom3.view.customer.pnlList(customerService));
                break;
            case ConstantHelper.MAIN_FRAME_EMPLOYEE_MODE:
                loadInSection(new com.ltnc.nhom3.view.employee.pnlList(employeeService));
                break;
            case ConstantHelper.MAIN_FRAME_PRODUCT_MODE:
                loadInSection(new com.ltnc.nhom3.view.product.pnlList(priceService, productService, manufacturerService));
                break;
            default:
                loadInSection(new pnlBlank());
        }
    }
    
    public Employee getLoggedInEmployee() {
        return loggedInEmployee;
    }
    
    private void reloadGroupButtonsInTab() {
        switch (listTabMode.get(pnlTab.getSelectedIndex())) {
            case ConstantHelper.MAIN_FRAME_BILL_MODE:
                btnBill.setSelected(true);
                break;
            case ConstantHelper.MAIN_FRAME_CUSTOMER_MODE:
                btnCustomer.setSelected(true);
                break;
            case ConstantHelper.MAIN_FRAME_EMPLOYEE_MODE:
                btnEmployee.setSelected(true);
                break;
            case ConstantHelper.MAIN_FRAME_PRODUCT_MODE:
                btnProduct.setSelected(true);
                break;
            default:
                groupBtnMenu.clearSelection();
        }
        reloadGroupButtons();
    }
    
}
