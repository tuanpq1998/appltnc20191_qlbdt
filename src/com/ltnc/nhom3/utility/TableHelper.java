/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ltnc.nhom3.utility;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author admin
 */
public class TableHelper {

    public static DefaultTableModel getNonEditableTableModel(String[] titles) {
        return new DefaultTableModel(titles, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
    }

    public static void setWithForAllColumns(JTable jTable, int[] widths) {
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
        for(int i: listIds) System.out.println(">>"+i);
        return listIds;
    }
    
    public static int extractSelectedId(JTable jTable) {
        return (int) jTable.getValueAt(jTable.getSelectedRow(), 0);
    }

}
