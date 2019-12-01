/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ltnc.nhom3.service;

import com.ltnc.nhom3.dao.EmployeeDao;
import com.ltnc.nhom3.entity.Employee;
import com.ltnc.nhom3.utility.ConstantHelper;
import java.sql.SQLException;
import java.util.List;
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
    
    public Employee findByUsername(String username) throws SQLException, SQLException {
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

    public List<Employee> findAll(int pageNum) throws SQLException {
        return employeeDao.findAll((pageNum - 1) * ConstantHelper.ITEM_PER_PAGE,
                ConstantHelper.ITEM_PER_PAGE);
    }

    public List<Employee> findAllByName(String searchKey, int pageNum) throws SQLException {
        return employeeDao.findAllLikeName(searchKey, (pageNum-1) * ConstantHelper.ITEM_PER_PAGE, 
                ConstantHelper.ITEM_PER_PAGE);
    }

    public boolean disableByIds(int[] listIds) throws SQLException {
        return employeeDao.disableManyByIds(listIds);
    }

    public int countAll() throws SQLException {
        return employeeDao.countAll();
    }

    public int countAllByName(String name) throws SQLException {
        return employeeDao.countAllLikeName(name);
    }

    public Employee findById(int employeeId) throws SQLException {
        return employeeDao.findById(employeeId);
    }

    public boolean disableById(int employeeId) throws SQLException {
        return employeeDao.disableById(employeeId);
    }

    public boolean updateInfo(Employee employee) throws SQLException {
        return employeeDao.update(employee);
    }

    public boolean create(Employee employee) throws SQLException {
        employee.setPassword(BCrypt.hashpw(employee.getPassword(), BCrypt.gensalt(12)));
        return employeeDao.create(employee);
    }
    
}
