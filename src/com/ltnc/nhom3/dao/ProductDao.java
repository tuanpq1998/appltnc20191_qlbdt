/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ltnc.nhom3.dao;

import com.ltnc.nhom3.connect.DatabaseConnect;
import com.ltnc.nhom3.entity.Product;
import com.ltnc.nhom3.utility.DBQuery;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author admin
 */
public class ProductDao implements CrudDao<Product> {

    @Override
    public boolean create(Product t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Product> findAll() throws SQLException {
        List<Product> products = null;
        Connection connection = null;
        Statement statement = null;
        try {
            connection = DatabaseConnect.getInstance().getConnection();
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(DBQuery.FIND_ALL_PRODUCTS);
            Product product = null;
            products = new ArrayList<>();

            while (resultSet.next()) {
                    product = extractFromResultSet(resultSet);
                    products.add(product);
            }
        } finally {            
            if (statement != null) statement.close();
            if (connection != null) connection.close();
        }
        return products;
    }

    @Override
    public Product findById(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Product t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteById(int id) throws SQLException {
        int count = 0;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = DatabaseConnect.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(DBQuery.DELETE_PRODUCT_BY_ID);

            preparedStatement.setInt(1, id);

            count = preparedStatement.executeUpdate();
        } finally {
            if (preparedStatement != null) preparedStatement.close();
            if (connection != null) connection.close();
        }
        return count > 0; 
    }

    @Override
    public Product extractFromResultSet(ResultSet resultSet) throws SQLException {
        Product product = new Product();
        product.setId(resultSet.getInt(1));
        product.setName(resultSet.getString(2));
        product.setManufacturerId(resultSet.getInt(3));
        product.setSpecifications(resultSet.getString(4));
        product.setDecription(resultSet.getString(5));
        product.setReleaseDate(resultSet.getString(6));
        product.setAvailable(resultSet.getBoolean(7));
        return product;
    }

    public boolean deleteManyByIds(int[] listIds) throws SQLException {
        int count = 0;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {            
            connection = DatabaseConnect.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(DBQuery.getQueryDeleteManyProductIds(listIds.length));
            
            for (int i = 0; i < listIds.length; i++)
                preparedStatement.setInt(i+1, listIds[i]);

            count = preparedStatement.executeUpdate();
        } finally {
            if (preparedStatement != null) preparedStatement.close();
            if (connection != null) connection.close();
        }
        return count == listIds.length; 
    }
    
    
}