/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ltnc.nhom3.view.template;

import com.ltnc.nhom3.utility.ConstantHelper;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author admin
 */
public class TableHelper {
    
    public static class CustomTable extends JTable {
        final Color LINE_VERTICAL_FORCUS = new Color(188,224,245);
        final Color LINE_HORIZONTAL_FORCUS = new Color(38, 160, 218);
        final Color LINE_BACKGROUND_FORCUS = new Color(203, 232, 246);
        
        final Color LINE_HORIZONTAL_HOVER = new Color(112, 192, 231);
        final Color LINE_VERTICAL_HOVER = new Color(211, 233, 250);
        final Color LINE_BACKGROUND_HOVER = new Color(229, 243, 251);
        
        private int rollOverRowIndex = -1;
        private int rollOverColumnHeader = -1;
        
        @Override
        public String getToolTipText(MouseEvent e) {
            String tip = null;
            java.awt.Point p = e.getPoint();
            int rowIndex = rowAtPoint(p);
            int colIndex = columnAtPoint(p);
            try {
                return getValueAt(rowIndex, colIndex).toString();
            } catch (RuntimeException exception) {
            }
            return tip;
        }
        
        protected void repaintRow(int row) {
            if (row == -1) return;
            int modelRow = convertRowIndexToModel(row);
            ((AbstractTableModel)getModel()).fireTableRowsUpdated(modelRow, modelRow);
        }

        @Override
        public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
            JComponent c = (JComponent) super.prepareRenderer(renderer, row, column);
            if (isRowSelected(row) && !ConstantHelper.NO_RESULT_MESSAGE.equals(getValueAt(row, 1))) {
                c.setBackground(LINE_BACKGROUND_FORCUS);
                c.setForeground(Color.BLACK);
                if (column == getColumnCount() - 1) {
                    c.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createMatteBorder(1, 0, 1, 1, LINE_HORIZONTAL_FORCUS), c.getBorder()));
                } else if (column == 0) {
                    c.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createMatteBorder(1, 1, 1, 0, LINE_HORIZONTAL_FORCUS),
                            BorderFactory.createMatteBorder(0, 0, 0, 1, LINE_VERTICAL_FORCUS)));
                } else {
                    c.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createMatteBorder(1, 0, 1, 0, LINE_HORIZONTAL_FORCUS),
                            BorderFactory.createCompoundBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, LINE_VERTICAL_FORCUS), c.getBorder())));
                }
            } else if (row == rollOverRowIndex) {
                c.setBackground(LINE_BACKGROUND_HOVER);
                c.setForeground(Color.black);
                if (column == getColumnCount() - 1) {
                    c.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createMatteBorder(1, 0, 1, 1, LINE_HORIZONTAL_HOVER), c.getBorder()));
                } else if (column == 0) {
                    c.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createMatteBorder(1, 1, 1, 0, LINE_HORIZONTAL_HOVER),
                            BorderFactory.createMatteBorder(0, 0, 0, 1, LINE_VERTICAL_HOVER)));
                } else {
                    c.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createMatteBorder(1, 0, 1, 0, LINE_HORIZONTAL_HOVER),
                            BorderFactory.createCompoundBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, LINE_VERTICAL_HOVER), c.getBorder())));
                }
            } else {
                if (getRowCount()-1 == row)
                    c.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, getGridColor()), c.getBorder()));
                c.setBackground(Color.WHITE);
                c.setForeground(Color.BLACK);
            }
            return c;
        }

        public CustomTable() {
            setRowHeight(25);
            setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
            setGridColor(new java.awt.Color(235, 244, 254));
            setShowHorizontalLines(false);
            setIntercellSpacing(new Dimension(0, 0));
            JTableHeader header = getTableHeader();
            header.addMouseMotionListener(new java.awt.event.MouseAdapter(){
                @Override
                public void mouseMoved(MouseEvent e) {
                    int row = columnAtPoint(e.getPoint());
                    if (row != rollOverColumnHeader) {
                        rollOverColumnHeader = row;
                        header.repaint();
                    }
                }
            });
            header.addMouseListener(new java.awt.event.MouseAdapter(){
                @Override
                public void mouseExited(MouseEvent e) {
                    if (rollOverColumnHeader != -1) {
                        rollOverColumnHeader = -1;
                        header.repaint();
                    }
                }
            });
            header.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
            header.setDefaultRenderer(new DefaultTableCellRenderer() {
                @Override
                public Component getTableCellRendererComponent(JTable table,
                        Object value, boolean isSelected, boolean hasFocus,
                        int row, int column) {
                    JComponent c = (JComponent) super.getTableCellRendererComponent(table,
                            value, isSelected, false, row, column);
                    c.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14));
                    if (column == rollOverColumnHeader) {
                        c.setBackground(LINE_BACKGROUND_HOVER);
                        c.setBorder(BorderFactory.createCompoundBorder(
                                BorderFactory.createMatteBorder(1, rollOverColumnHeader==0 ? 1 : 0, 1, 1, LINE_HORIZONTAL_HOVER),
                                BorderFactory.createEmptyBorder(3, rollOverColumnHeader==0 ? 0 : 1, 3, 0)));
                    } else if (column == rollOverColumnHeader - 1) {
                        c.setBackground(new Color(252, 252, 252));
                        c.setBorder(BorderFactory.createCompoundBorder(
                                BorderFactory.createMatteBorder(0, 0, 0, 1, LINE_HORIZONTAL_HOVER),
                                BorderFactory.createCompoundBorder(
                                        BorderFactory.createMatteBorder(0, 0, 1, 0, table.getGridColor()),
                                        BorderFactory.createEmptyBorder(3, 1, 3, 0))));
                    } else {
                        c.setBackground(new Color(252, 252, 252));
                        c.setBorder(BorderFactory.createCompoundBorder(
                                BorderFactory.createMatteBorder(0, 0, 1, 1, table.getGridColor()),
                                BorderFactory.createEmptyBorder(3, 1, 3, 0)));
                    }
                    return c;
                }
            });
            addMouseMotionListener(new java.awt.event.MouseAdapter(){
                @Override
                public void mouseMoved(MouseEvent e) {
                    int row = rowAtPoint(e.getPoint());
                    if (row != rollOverRowIndex 
                            && !ConstantHelper.NO_RESULT_MESSAGE.equals(getValueAt(row, 1))) {
                        repaintRow(rollOverRowIndex);
                        rollOverRowIndex = row;
                        repaintRow(rollOverRowIndex);
                    }
                }
            });
            addMouseListener(new java.awt.event.MouseAdapter() {
                @Override
                public void mouseExited(MouseEvent e) {
                    if (rollOverRowIndex != -1) {
                        repaintRow(rollOverRowIndex);
                        rollOverRowIndex = -1;
                    }
                }
            });
            setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
                @Override
                public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                    return super.getTableCellRendererComponent(table, value, isSelected, false, row, column);
                }
            });
        }
    }

    public static DefaultTableModel getNonEditableTableModel(String[] titles) {
        return new DefaultTableModel(titles, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
    }

    public static void setWidthForAllColumns(JTable jTable, int[] widths) {
        TableColumnModel columnModel = jTable.getColumnModel();
        for (int i = 0; i < widths.length; i++) {
            if (i < columnModel.getColumnCount()) 
                columnModel.getColumn(i).setPreferredWidth(widths[i]);
            else break;
            
        }
    }
    
    public static int[] extractSelectedIdList(JTable jTable) {
        int[] listIds = new int[jTable.getSelectedRowCount()];
        int[] listRowIndexs = jTable.getSelectedRows();
        for (int i = 0; i < listRowIndexs.length; i++)
            listIds[i] = (int) jTable.getValueAt(listRowIndexs[i], 0);
        return listIds;
    }
    
    public static int extractSelectedId(JTable jTable) {
        return (int) jTable.getValueAt(jTable.getSelectedRow(), 0);
    }

}
