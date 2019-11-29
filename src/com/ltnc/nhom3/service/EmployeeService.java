/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ltnc.nhom3.service;

import com.ltnc.nhom3.dao.EmployeeDao;
import com.ltnc.nhom3.entity.Employee;
import java.sql.SQLException;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author admin
 */
public class EmployeeService {
    
    private EmployeeDao employeeDao;

    public EmployeeService() {
        employeeDao = new EmployeeDao();
    }
    
    public Employee findByUsername(String username) throws SQLException {
        return employeeDao.findByUsername(username);
    }

    public Employee authenticated(String username, String password) throws SQLException {
        Employee employee = findByUsername(username);
        if (employee!= null && BCrypt.checkpw(password, employee.getPassword()))
            return employee;
        return null;
    }

    public boolean isPasswordOfEmployee(int id, String currentPassword) throws SQLException {
        Employee employee = employeeDao.findById(id);
        return BCrypt.checkpw(currentPassword, employee.getPassword());
    }

    public void updatePassword(int id, String newPassword) throws SQLException {
        employeeDao.updatePassword(id, BCrypt.hashpw(newPassword, BCrypt.gensalt(12)));
    }
    
}
