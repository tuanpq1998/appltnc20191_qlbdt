/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ltnc.nhom3.view.template;

import com.ltnc.nhom3.utility.ConstantHelper;
import com.sun.java.swing.plaf.windows.WindowsComboBoxUI;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JSeparator;

/**
 *
 * @author admin
 */
public class SectionTemplate {

    private static void changeColorBorder(JButton button, Color color) {
        button.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(color), BorderFactory.createEmptyBorder(0, 10, 0, 10)));
    }

    public static JButton getStyledButton() {
        JButton button = new JButton();
        button.setBackground(ConstantHelper.SECTION_PANEL_BG);
        changeColorBorder(button, ConstantHelper.SECTION_BTN_BODER_NORMAL);
        button.setContentAreaFilled(false);
        button.setFocusable(false);
        button.setOpaque(true);
        button.setMinimumSize(new Dimension(0, 30));
        button.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(ConstantHelper.SECTION_BTN_BG_HOVER);
                changeColorBorder(button, ConstantHelper.SECTION_BTN_BODER_HOVER);
            }
            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(ConstantHelper.SECTION_BTN_BG_NORMAL);
                changeColorBorder(button, ConstantHelper.SECTION_BTN_BODER_NORMAL);
            }
        });
        return button;
    }

    public static JPanel getStyledPanel() {
        JPanel panel = new JPanel();
        panel.setBackground(ConstantHelper.SECTION_PANEL_BG);
        return panel;
    }

    public static JSeparator getStyledSeparator() {
        JSeparator separator = new JSeparator();
        separator.setBackground(ConstantHelper.SECTION_PANEL_BG);
        separator.setForeground(ConstantHelper.SECTION_PANEL_LINE);
        return separator;
    }

    public static class CustomComboBoxModel extends DefaultComboBoxModel {
        private boolean selectionAllowed = true;
        public void setSelectionAllowed(boolean selectionAllowed) {
            this.selectionAllowed = selectionAllowed;
        }
        @Override
        public void setSelectedItem(Object anObject) {
            if (!ConstantHelper.COMBOBOX_SELECT_MANUFACTURER.equals(anObject))
                super.setSelectedItem(anObject);
            else if (selectionAllowed) {
                selectionAllowed = false;
                super.setSelectedItem(anObject);
            }
        }
    }

    public static CustomComboBoxModel getCustomComboBoxModel() {
        return new CustomComboBoxModel();
    }

    public static class CustomComboBoxUI extends WindowsComboBoxUI {
        @Override
        public void paintCurrentValueBackground(Graphics g, Rectangle bounds, boolean hasFocus) {
            Color t = g.getColor();
            g.setColor(ConstantHelper.SECTION_PANEL_BG);
            g.fillRect(bounds.x, bounds.y, bounds.width, bounds.height);
            g.setColor(t);
        }
    }

    public static WindowsComboBoxUI getCustomComboBoxUI() {
        return new CustomComboBoxUI();
    }

}
