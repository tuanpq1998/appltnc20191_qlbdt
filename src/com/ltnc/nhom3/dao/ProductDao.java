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
import java.util.List;

/**
 *
 * @author admin
 */
public class ProductDao implements CrudDao<Product> {
    
    public int createAndReturnId(Product product, boolean isReturnNewId) throws SQLException {
        int newId = 0;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = DatabaseConnect.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(DBQuery.CREATE_NEW_PRODUCT,
                    PreparedStatement.RETURN_GENERATED_KEYS);     
            preparedStatement.setString(1, product.getName());
            preparedStatement.setInt(2, product.getManufacturerId());
            preparedStatement.setString(3, product.getSpecifications());
            preparedStatement.setString(4, product.getDecription());
            preparedStatement.setString(5, product.getReleaseDate());
            preparedStatement.setBoolean(6, product.isAvailable());
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
        Product product  = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
                connection = DatabaseConnect.getInstance().getConnection();
                preparedStatement = connection.prepareStatement(DBQuery.FIND_PRODUCT_BY_ID);

                preparedStatement.setInt(1, id);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) { 
                    product = extractFromResultSet(resultSet);
                    
                    break;
                }
        } finally {
            if (preparedStatement != null) preparedStatement.close();
            if (connection != null) connection.close();
        }
        return product;
    }

    @Override
    public boolean update(Product product) throws SQLException {
        int count = 0;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = DatabaseConnect.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(DBQuery.UPDATE_PRODUCT);

            preparedStatement.setString(1, product.getName());
            preparedStatement.setInt(2, product.getManufacturerId());
            preparedStatement.setString(3, product.getSpecifications());
            preparedStatement.setString(4, product.getDecription());
            preparedStatement.setString(5, product.getReleaseDate());
            preparedStatement.setBoolean(6, product.isAvailable());
            preparedStatement.setInt(7, product.getId());
            
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

    public List<Product> findAllLikeName(String name) throws SQLException {
        List<Product> products = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = DatabaseConnect.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(DBQuery.FIND_ALL_PRODUCTS_BY_NAME);
            preparedStatement.setString(1, "%"+name+"%");
            ResultSet resultSet = preparedStatement.executeQuery();
            Product product = null;
            products = new ArrayList<>();

            while (resultSet.next()) {
                    product = extractFromResultSet(resultSet);
                    products.add(product);
            }
        } finally {            
            if (preparedStatement != null) preparedStatement.close();
            if (connection != null) connection.close();
        }
        return products;
    }

    @Override
    public boolean create(Product t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
