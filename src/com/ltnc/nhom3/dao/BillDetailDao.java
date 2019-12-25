/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ltnc.nhom3.dao;

import com.ltnc.nhom3.connect.DatabaseConnect;
import com.ltnc.nhom3.entity.BillDetail;
import com.ltnc.nhom3.utility.DBQuery;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class BillDetailDao {

    private BillDetail extractFromResultSet(ResultSet resultSet) throws SQLException {
        BillDetail billDetail = new BillDetail();
        billDetail.setId(resultSet.getInt(1));
        billDetail.setBillId(resultSet.getInt(2));
        billDetail.setProductId(resultSet.getInt(3));
        billDetail.setQuantity(resultSet.getInt(4));
        billDetail.setSubTotal(resultSet.getDouble(5));
        return billDetail;
    }
    
    public List<BillDetail> findAllByBillId(int billId, int offset, int limit) throws SQLException {
        List<BillDetail> billDetails = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = DatabaseConnect.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(DBQuery.FIND_ALL_BILLDETAILS_BY_BILL_ID_OFFSET_LIMIT);
            
            preparedStatement.setInt(1, billId);
            preparedStatement.setInt(2, offset);
            preparedStatement.setInt(3, limit);
            ResultSet resultSet = preparedStatement.executeQuery();
            BillDetail billDetail = null;
            billDetails = new ArrayList<>();
            while (resultSet.next()) {
                billDetail = extractFromResultSet(resultSet);
                billDetails.add(billDetail);
            }
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
        return billDetails;
    }

    public int countAllByBillId(int billId) throws SQLException {
        int count = 0;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = DatabaseConnect.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(DBQuery.COUNT_ALL_BILLDETAILS_BY_BILL_ID);
            preparedStatement.setInt(1, billId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                count = resultSet.getInt(1);
            }
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
        return count;
    }

    public int create(BillDetail billDetail) throws SQLException {
        int count = 0;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = DatabaseConnect.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(DBQuery.CREATE_NEW_BILLDETAIL);            

            preparedStatement.setInt(1, billDetail.getBillId());
            preparedStatement.setInt(2, billDetail.getProductId());
            preparedStatement.setInt(3, billDetail.getQuantity());
            preparedStatement.setDouble(4, billDetail.getSubTotal());
            
            count = preparedStatement.executeUpdate();
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
        return count;
    }

    public int createFromList(List<BillDetail> listBillDetails) throws SQLException {
        int count = 0;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = DatabaseConnect.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(DBQuery.getQueryCreateManyBillDetails(listBillDetails.size()));            
            
            BillDetail billDetail = null;
            for (int i = 0, j = 0; i < listBillDetails.size(); i++) {
                billDetail = listBillDetails.get(i);
                preparedStatement.setInt(i*4+1, billDetail.getBillId());
                preparedStatement.setInt(i*4+2, billDetail.getProductId());
                preparedStatement.setInt(i*4+3, billDetail.getQuantity());
                preparedStatement.setDouble(i*4+4, billDetail.getSubTotal());
            }
            count = preparedStatement.executeUpdate();
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
        return count;
    }

    public int countSumQuantityByBillId(int billId) throws SQLException {
        int count = 0;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = DatabaseConnect.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(DBQuery.COUNT_SUM_QUANTITY_BY_BILL_ID);
            preparedStatement.setInt(1, billId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                count = resultSet.getInt(1);
            }
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
        return count;
    }
    
}
