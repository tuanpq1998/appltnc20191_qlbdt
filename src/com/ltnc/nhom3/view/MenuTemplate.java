/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ltnc.nhom3.view;

import com.ltnc.nhom3.utility.ColorHelper;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JToggleButton;

/**
 *
 * @author admin
 */
public class MenuTemplate {

    public static JToggleButton getStyledButton() {
        JToggleButton button = new JToggleButton();
        button.setBackground(ColorHelper.MENU_PANEL_BG);
        button.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        button.setForeground(new java.awt.Color(255, 255, 255));
        button.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 10, 0, 0));
        button.setContentAreaFilled(false);
        button.setFocusPainted(false);
        button.setOpaque(true);
        button.setMinimumSize(new java.awt.Dimension(80, 45));
        button.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        button.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        return button;
    }
    
    public static JPanel getStyledPanel() {
        JPanel panel = new JPanel();
        panel.setBackground(ColorHelper.MENU_PANEL_BG);
        return panel;
    }
    
    public static JSeparator getStyledSeparator() {
        JSeparator separator = new JSeparator();
        separator.setBackground(ColorHelper.MENU_PANEL_LINE);
        separator.setForeground(ColorHelper.MENU_PANEL_LINE);
        return separator;
    }
}
