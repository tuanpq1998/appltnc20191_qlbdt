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
public class EmployeeDao {

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
            preparedStatement.setBoolean(4, employee.isMale());
            preparedStatement.setString(5, employee.getIndentityCard());
            preparedStatement.setString(6, employee.getUsername());
            preparedStatement.setString(7, employee.getPassword());
            preparedStatement.setBoolean(8, employee.isAdmin());

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

    public List<Employee> findAll(int offset, int limit) throws SQLException {
        List<Employee> employees = null;
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = DatabaseConnect.getInstance().getConnection();
            statement = connection.prepareStatement(DBQuery.FIND_ALL_EMPLOYEES_OFFSET_LIMIT);

            statement.setInt(1, offset);
            statement.setInt(2, limit);

            ResultSet resultSet = statement.executeQuery();
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
            preparedStatement.setBoolean(4, employee.isMale());
            preparedStatement.setString(5, employee.getIndentityCard());
            preparedStatement.setInt(6, employee.getId());

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

    public boolean disableById(int id) throws SQLException {
        int count = 0;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = DatabaseConnect.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(DBQuery.DISABLE_EMPLOYEE_BY_ID);

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

    private Employee extractFromResultSet(ResultSet resultSet) throws SQLException {
        Employee employee = new Employee();
        employee.setId(resultSet.getInt(1));
        employee.setFullname(resultSet.getString(2));
        employee.setPhone(resultSet.getString(4));
        employee.setAddress(resultSet.getString(3));
        employee.setMale(resultSet.getBoolean(5));
        employee.setIndentityCard(resultSet.getString(6));
        employee.setUsername(resultSet.getString(7));
        employee.setPassword(resultSet.getString(8));
        employee.setAdmin(resultSet.getBoolean(9));
        employee.setActive(resultSet.getBoolean(10));
        return employee;
    }

    public Employee findByUsername(String username) throws SQLException, SQLException, SQLException {
        Employee employee = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = DatabaseConnect.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(DBQuery.FIND_EMPLYEE_BY_USERNAME);

            preparedStatement.setString(1, username);
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

    public boolean updatePassword(int id, String password) throws SQLException {
        int count = 0;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = DatabaseConnect.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(DBQuery.UPDATE_EMPLOYEE_PASSWORD_BY_ID);
            preparedStatement.setInt(2, id);
            preparedStatement.setString(1, password);
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

    public List<Employee> findAllLikeName(String fullname, int offset, int limit) throws SQLException {
        List<Employee> employees = null;
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = DatabaseConnect.getInstance().getConnection();
            statement = connection.prepareStatement(DBQuery.FIND_ALL_EMPLOYEES_BY_NAME);

            statement.setString(1, "%" + fullname + "%");
            statement.setInt(2, offset);
            statement.setInt(3, limit);

            ResultSet resultSet = statement.executeQuery();
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

    public boolean disableManyByIds(int[] listIds) throws SQLException {
        int count = 0;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = DatabaseConnect.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(DBQuery.getQueryDisableManyEmployeeIds(listIds.length));

            for (int i = 0; i < listIds.length; i++) {
                preparedStatement.setInt(i + 1, listIds[i]);
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
        return count > 0;
    }

    public int countAll() throws SQLException {
        int count = 0;
        Connection connection = null;
        Statement statement = null;
        try {
            connection = DatabaseConnect.getInstance().getConnection();
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(DBQuery.COUNT_ALL_EMPLOYEES);
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

    public int countAllLikeName(String name) throws SQLException {
        int count = 0;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = DatabaseConnect.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(DBQuery.COUNT_ALL_EMPLOYEES_BY_NAME);
            preparedStatement.setString(1, "%" + name + "%");
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

    public boolean enableById(int id) throws SQLException {
        int count = 0;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = DatabaseConnect.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(DBQuery.ENABLE_EMPLOYEE_BY_ID);
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
}
