/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ltnc.nhom3.dao;

import com.ltnc.nhom3.connect.DatabaseConnect;
import com.ltnc.nhom3.entity.Employee;
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
public class EmployeeDao implements CrudDao<Employee> {

    @Override
    public boolean create(Employee employee) throws SQLException {
        int count = 0;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = DatabaseConnect.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(DBQuery.CREATE_NEW_EMPLOYEE);

            preparedStatement.setString(1, employee.getFullname());
            preparedStatement.setString(2, employee.getAddress());
            preparedStatement.setString(3, employee.getPhone());
            preparedStatement.setString(4, employee.getIndentityCard());
            preparedStatement.setString(5, employee.getUsername());
            preparedStatement.setString(6, employee.getPassword());
            preparedStatement.setString(7, employee.getRole());

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
    public List<Employee> findAll() throws SQLException {
        List<Employee> employees = null;
        Connection connection = null;
        Statement statement = null;
        try {
            connection = DatabaseConnect.getInstance().getConnection();
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(DBQuery.FIND_ALL_EMPLOYEE);
            Employee employee = null;
            employees = new ArrayList<>();

            while (resultSet.next()) {
                employee = extractFromResultSet(resultSet);
                employees.add(employee);
            }
        } finally {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
        return employees;
    }

    @Override
    public Employee findById(int id) throws SQLException {
        Employee employee = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = DatabaseConnect.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(DBQuery.FIND_EMPLYEE_BY_ID);

            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                employee = extractFromResultSet(resultSet);

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

        return employee;
    }

    @Override
    public boolean update(Employee employee) throws SQLException {
        int count = 0;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = DatabaseConnect.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(DBQuery.UPDATE_EMPLOYEE);

            preparedStatement.setString(1, employee.getFullname());
            preparedStatement.setString(2, employee.getAddress());
            preparedStatement.setString(3, employee.getPhone());
            preparedStatement.setString(4, employee.getIndentityCard());
            preparedStatement.setString(5, employee.getUsername());
            preparedStatement.setString(6, employee.getPassword());
            preparedStatement.setString(7, employee.getRole());
            preparedStatement.setBoolean(8, employee.isActive());
            preparedStatement.setInt(9, employee.getId());

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
            preparedStatement = connection.prepareStatement(DBQuery.DELETE_EMPLOYEE_BY_ID);

            preparedStatement.setInt(1, id);

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
    public Employee extractFromResultSet(ResultSet resultSet) throws SQLException {
        Employee employee = new Employee();
        employee.setId(resultSet.getInt(1));
        employee.setFullname(resultSet.getString(2));
        employee.setPhone(resultSet.getString(4));
        employee.setAddress(resultSet.getString(3));
        employee.setIndentityCard(resultSet.getString(5));
        employee.setUsername(resultSet.getString(6));
        employee.setPassword(resultSet.getString(7));
        employee.setRole(resultSet.getString(8));
        employee.setActive(resultSet.getBoolean(9));
        return employee;
    }

}