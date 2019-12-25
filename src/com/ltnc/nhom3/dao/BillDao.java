/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ltnc.nhom3.dao;

import com.ltnc.nhom3.connect.DatabaseConnect;
import com.ltnc.nhom3.entity.Bill;
import com.ltnc.nhom3.utility.DBQuery;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class BillDao {

    private Bill extractFromResultSet(ResultSet resultSet) throws SQLException {
        Bill bill = new Bill();
        bill.setId(resultSet.getInt(1));
        bill.setCustomerId(resultSet.getInt(2));
        bill.setCreateDate(resultSet.getString(3));
        bill.setEmployeeId(resultSet.getInt(4));
        bill.setTotalMoney(resultSet.getDouble(5));
        bill.setNote(resultSet.getString(6));
        return bill;
    }
    
    public List<Bill> findAll(int offset, int limit) throws SQLException {
        List<Bill> bills = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = DatabaseConnect.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(DBQuery.FIND_ALL_BILLS_OFFSET_LIMIT);
            preparedStatement.setInt(1, offset);
            preparedStatement.setInt(2, limit);
            ResultSet resultSet = preparedStatement.executeQuery();
            Bill bill = null;
            bills = new ArrayList<>();
            while (resultSet.next()) {
                bill = extractFromResultSet(resultSet);
                bills.add(bill);
            }
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
        return bills;
    }

    public int countAll() throws SQLException {
        int count = 0;
        Connection connection = null;
        Statement statement = null;
        try {
            connection = DatabaseConnect.getInstance().getConnection();
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(DBQuery.COUNT_ALL_BILLS);

            if (resultSet.next()) {
                count = resultSet.getInt(1);
            }
        } finally {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
        return count;
    }

    public Bill findById(int billId) throws SQLException {
        Bill bill = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = DatabaseConnect.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(DBQuery.FIND_BILL_BY_ID);

            preparedStatement.setInt(1, billId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                bill = extractFromResultSet(resultSet);

                break;
            }
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
        return bill;
    }

    public int create(Bill bill) throws SQLException {
        int newId = 0;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = DatabaseConnect.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(DBQuery.CREATE_NEW_BILL,
                    PreparedStatement.RETURN_GENERATED_KEYS);

            preparedStatement.setInt(1, bill.getCustomerId());
            preparedStatement.setInt(3, bill.getEmployeeId());
            preparedStatement.setString(2, bill.getCreateDate());
            preparedStatement.setDouble(4, bill.getTotalMoney());
            preparedStatement.setString(5, bill.getNote());

            preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.getGeneratedKeys();
            if (rs.next()) newId=rs.getInt(1);
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
        return newId;
    }

    public boolean update(Bill bill) throws SQLException {
        int count = 0;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = DatabaseConnect.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(DBQuery.UPDATE_BILL);

            preparedStatement.setDouble(1, bill.getTotalMoney());
            preparedStatement.setString(2, bill.getNote());
            preparedStatement.setInt(3, bill.getId());
            
            count = preparedStatement.executeUpdate();
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
        return count > 0;
    }
    
}
