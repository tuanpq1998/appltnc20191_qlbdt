/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ltnc.nhom3;

import com.ltnc.nhom3.utility.ConstantHelper;
import com.ltnc.nhom3.view.frmMainWindow;
import java.awt.Insets;
import java.util.logging.Logger;
import javax.swing.UIManager;

/**
 *
 * @author admin
 */
public class MainApplication {
    public static void main(String args[]) {
        
        UIManager.put("OptionPane.background", ConstantHelper.SECTION_PANEL_BG);
        UIManager.put("Panel.background", ConstantHelper.SECTION_PANEL_BG);
        UIManager.put("ToolTip.background", ConstantHelper.SECTION_PANEL_BG);
        UIManager.put("TabbedPane.contentBorderInsets", new Insets(0, 0, 0, 0));
        UIManager.put("TabbedPane.tabInsets", new Insets(-1, 0, 0, 2));
        
        /* Set the Windows look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            Logger.getLogger(MainApplication.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        new frmMainWindow().setVisible(true);
    }
}
