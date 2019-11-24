/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ltnc.nhom3.dao;

import com.ltnc.nhom3.connect.DatabaseConnect;
import com.ltnc.nhom3.entity.Price;
import com.ltnc.nhom3.utility.DBQuery;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author admin
 */
public class PriceDao implements CrudDao<Price> {

    @Override
    public boolean create(Price price) throws SQLException {
        int count = 0;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = DatabaseConnect.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(DBQuery.CREATE_NEW_PRICE);
            
            preparedStatement.setInt(1, price.getProductId());
            preparedStatement.setDouble(2, price.getValue());
            preparedStatement.setString(3, price.getStartDate());
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

    @Override
    public List<Price> findAll() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Price findById(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Price price) throws SQLException {
        int count = 0;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = DatabaseConnect.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(DBQuery.UPDATE_PRICE);
            
            preparedStatement.setString(1, price.getEndDate());
            preparedStatement.setBoolean(2, price.isCurrent());

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

    @Override
    public boolean deleteById(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Price extractFromResultSet(ResultSet resultSet) throws SQLException {
        Price price = new Price();
        price.setId(resultSet.getInt(1));
        price.setProductId(resultSet.getInt(2));
        price.setValue(resultSet.getDouble(3));
        price.setStartDate(resultSet.getString(4));
        price.setEndDate(resultSet.getString(5));
        price.setCurrent(resultSet.getBoolean(6));
        return price;
    }
    
    public Price findByProductId(int productId) throws SQLException {
        Price price  = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
                connection = DatabaseConnect.getInstance().getConnection();
                preparedStatement = connection.prepareStatement(DBQuery.FIND_PRICE_BY_PRODUCT_ID);

                preparedStatement.setInt(1, productId);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) { 
                    price = extractFromResultSet(resultSet);
                    
                    break;
                }
        } finally {
            if (preparedStatement != null) preparedStatement.close();
            if (connection != null) connection.close();
        }
        return price;
    }
}
