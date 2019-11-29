/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ltnc.nhom3.view.template;

import com.ltnc.nhom3.utility.ConstantHelper;
import java.awt.Color;
import java.awt.Font;
import java.awt.font.TextAttribute;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JToggleButton;
import javax.swing.plaf.metal.MetalButtonUI;

/**
 *
 * @author admin
 */
public class MenuTemplate {

    public static JToggleButton getStyledButton() {
        JToggleButton button = new JToggleButton();
        button.setBackground(ConstantHelper.MENU_PANEL_BG);
        button.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        button.setForeground(new java.awt.Color(255, 255, 255));
        button.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 10, 0, 0));
        button.setContentAreaFilled(false);
        button.setFocusPainted(false);
        button.setOpaque(true);
        button.setMinimumSize(new java.awt.Dimension(80, 45));
        button.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        button.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        button.setUI(new MetalButtonUI() {
            @Override
            protected Color getDisabledTextColor() {
                return ConstantHelper.MENU_BTN_DISABLED;
            }
        });
        return button;
    }
    
    public static JPanel getStyledPanel() {
        JPanel panel = new JPanel();
        panel.setBackground(ConstantHelper.MENU_PANEL_BG);
        return panel;
    }
    
    public static JSeparator getStyledSeparator() {
        JSeparator separator = new JSeparator();
        separator.setBackground(ConstantHelper.MENU_PANEL_LINE);
        separator.setForeground(ConstantHelper.MENU_PANEL_LINE);
        separator.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 0, ConstantHelper.MENU_PANEL_BG));
        return separator;
    }
    
    public static JButton getStyledSecondaryButton() {
        JButton button = new JButton();
        button.setBackground(ConstantHelper.MENU_PANEL_BG);
        button.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        button.setForeground(new java.awt.Color(255, 255, 255));
        button.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 10, 0, 0));
        button.setContentAreaFilled(false);
        button.setFocusPainted(false);
        button.setOpaque(true);
        button.setMinimumSize(new java.awt.Dimension(80, 45));
        button.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        button.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        button.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        button.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Font font = button.getFont();
                Map attributes = font.getAttributes();
                attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
                button.setFont(font.deriveFont(attributes));
            }
            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Font font = button.getFont();
                Map attributes = font.getAttributes();
                attributes.put(TextAttribute.UNDERLINE, null);
                button.setFont(font.deriveFont(attributes));
            }
        });
        return button;
    }
}
