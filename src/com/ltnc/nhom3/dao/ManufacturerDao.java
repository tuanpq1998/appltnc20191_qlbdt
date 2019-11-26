/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ltnc.nhom3.dao;

import com.ltnc.nhom3.connect.DatabaseConnect;
import com.ltnc.nhom3.entity.Manufacturer;
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
 * @author PhungSyLinh
 */
public class ManufacturerDao { 
    public int createAndReturnId(Manufacturer manufacturer) throws SQLException {
        int newId = 0;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = DatabaseConnect.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(DBQuery.CREATE_NEW_MANUFACTURER,
                    PreparedStatement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1, manufacturer.getName());
            preparedStatement.setString(2, manufacturer.getCountry());

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

    public List<Manufacturer> findAll() throws SQLException {
        List<Manufacturer> manufacturers = null;
        Connection connection = null;
        Statement statement = null;
        try {
            connection = DatabaseConnect.getInstance().getConnection();
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(DBQuery.FIND_ALL_MANUFACTURERS);
            Manufacturer manufacturer = null;
            manufacturers = new ArrayList<>();

            while (resultSet.next()) {
                    manufacturer = extractFromResultSet(resultSet);
                    manufacturers.add(manufacturer);
            }
        } finally {            
            if (statement != null) statement.close();
            if (connection != null) connection.close();
        }
        return manufacturers;
    }

    public Manufacturer findById(int id) throws SQLException {
        Manufacturer manufacturer  = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
                connection = DatabaseConnect.getInstance().getConnection();
                preparedStatement = connection.prepareStatement(DBQuery.FIND_MANUFACTURER_BY_ID);

                preparedStatement.setInt(1, id);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) { 
                    manufacturer = extractFromResultSet(resultSet);
                    
                    break;
                }
        } finally {
            if (preparedStatement != null) preparedStatement.close();
            if (connection != null) connection.close();
        }
        return manufacturer;
    }

    public boolean update(Manufacturer manufacturer) throws SQLException {
        int count = 0;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = DatabaseConnect.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(DBQuery.UPDATE_MANUFACTUER);

            preparedStatement.setString(1, manufacturer.getName());
            preparedStatement.setString(2, manufacturer.getCountry());
            preparedStatement.setInt(3, manufacturer.getId());

            count = preparedStatement.executeUpdate();
        } finally {
            if (preparedStatement != null) preparedStatement.close();
            if (connection != null) connection.close();
        }
        return count > 0;
    }

    public boolean deleteById(int id) throws SQLException {
        int count = 0;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = DatabaseConnect.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(DBQuery.DELETE_MANUFACTUER_BY_ID);

            preparedStatement.setInt(1, id);

            count = preparedStatement.executeUpdate();
        } finally {
            if (preparedStatement != null) preparedStatement.close();
            if (connection != null) connection.close();
        }
        return count > 0; 
    }

    private Manufacturer extractFromResultSet(ResultSet resultSet) throws SQLException {
        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setId(resultSet.getInt(1));
        manufacturer.setName(resultSet.getString(2));
        manufacturer.setCountry(resultSet.getString(3));
        return manufacturer;
      
    }
    
    public Manufacturer findByName(String name) throws SQLException {
        Manufacturer manufacturer  = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
                connection = DatabaseConnect.getInstance().getConnection();
                preparedStatement = connection.prepareStatement(DBQuery.FIND_MANUFACTURER_BY_NAME);

                preparedStatement.setString(1, name);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) { 
                    manufacturer = extractFromResultSet(resultSet);
                    
                    break;
                }
        } finally {
            if (preparedStatement != null) preparedStatement.close();
            if (connection != null) connection.close();
        }
        return manufacturer;
    }

}
