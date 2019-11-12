/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ltnc.nhom3.dao;

import com.ltnc.nhom3.connect.DatabaseConnect;
import com.ltnc.nhom3.entity.Customer;
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
public class CustomerDao implements CrudDao<Customer> {

    @Override
    public boolean create(Customer customer) throws SQLException {
        int count = 0;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = DatabaseConnect.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(DBQuery.CREATE_NEW_CUSTOMER);

            preparedStatement.setString(1, customer.getFullname());
            preparedStatement.setString(2, customer.getAddress());
            preparedStatement.setString(3, customer.getPhone());

            count = preparedStatement.executeUpdate();
        } finally {
            if (preparedStatement != null) preparedStatement.close();
            if (connection != null) connection.close();
        }
        return count > 0;
    }

    @Override
    public List<Customer> findAll() throws SQLException {
        List<Customer> customers = null;
        Connection connection = null;
        Statement statement = null;
        try {
            connection = DatabaseConnect.getInstance().getConnection();
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(DBQuery.FIND_ALL_CUSTOMERS);
            Customer customer = null;
            customers = new ArrayList<Customer>();

            while (resultSet.next()) {
                    customer = extractFromResultSet(resultSet);
                    customers.add(customer);
            }
        } finally {            
            if (statement != null) statement.close();
            if (connection != null) connection.close();
        }
        return customers;
    }

    @Override
    public Customer findById(int id) throws SQLException {
        Customer customer  = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
                connection = DatabaseConnect.getInstance().getConnection();
                preparedStatement = connection.prepareStatement(DBQuery.FIND_CUSTOMER_BY_ID);

                preparedStatement.setInt(1, id);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) { 
                    customer = extractFromResultSet(resultSet);
                    
                    break;
                }
        } finally {
            if (preparedStatement != null) preparedStatement.close();
            if (connection != null) connection.close();
        }
        return customer;
    }

    @Override
    public boolean update(Customer customer) throws SQLException {
        int count = 0;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = DatabaseConnect.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(DBQuery.UPDATE_CUSTOMER);

            preparedStatement.setString(1, customer.getFullname());
            preparedStatement.setString(2, customer.getAddress());
            preparedStatement.setString(3, customer.getPhone());
            preparedStatement.setInt(4, customer.getId());

            count = preparedStatement.executeUpdate();
        } finally {
            if (preparedStatement != null) preparedStatement.close();
            if (connection != null) connection.close();
        }
        return count > 0;
    }

    @Override
    public boolean deleteById(int id) throws SQLException {
        int count = 0;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = DatabaseConnect.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(DBQuery.DELETE_CUSTOMER_BY_ID);

            preparedStatement.setInt(1, id);

            count = preparedStatement.executeUpdate();
        } finally {
            if (preparedStatement != null) preparedStatement.close();
            if (connection != null) connection.close();
        }
        return count > 0;
    }

    @Override
    public Customer extractFromResultSet(ResultSet resultSet) throws SQLException {
        Customer customer = new Customer();
        customer.setId(resultSet.getInt(1));
        customer.setFullname(resultSet.getString(2));
        customer.setPhone(resultSet.getString(4));
        customer.setAddress(resultSet.getString(3));
        return customer;
    }
    
}
