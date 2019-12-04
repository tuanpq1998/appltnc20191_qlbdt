/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ltnc.nhom3.service;

import com.ltnc.nhom3.dao.CustomerDao;
import com.ltnc.nhom3.entity.Customer;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author PhungSyLinh
 */
public class CustomerService {

    private CustomerDao customerDao;

    public CustomerService() {
        customerDao = new CustomerDao();
    }

    public List<Customer> findAll() throws SQLException {
        return customerDao.findAll();
    }

    public Customer findById(int id) throws SQLException {
        return customerDao.findById(id);
    }

    public boolean deleteById(int idSelected) throws SQLException {
        return customerDao.deleteById(idSelected);
    }

    public boolean create(Customer customer) throws SQLException {
        return customerDao.create(customer);
    }

    public boolean update(Customer customer) throws SQLException {
        return customerDao.update(customer);
    }

    public List<Customer> findByFullname(String searchKey) {
        return customerDao.findByFullname(searchKey);
    }

}
