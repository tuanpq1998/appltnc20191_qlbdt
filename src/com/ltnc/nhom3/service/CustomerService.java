/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ltnc.nhom3.service;

import com.ltnc.nhom3.dao.CustomerDao;
import com.ltnc.nhom3.entity.Customer;
import com.ltnc.nhom3.utility.ConstantHelper;
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

    public List<Customer> findAll(int pageNum) throws SQLException {
        return customerDao.findAll((pageNum-1) * ConstantHelper.ITEM_PER_PAGE, 
                ConstantHelper.ITEM_PER_PAGE);
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

    public List<Customer> findByFullname(String searchKey) throws SQLException {
        return customerDao.findByFullname(searchKey);
    }

    public List<Customer> findByName(String searchKey, int pageNum) throws SQLException {
        return customerDao.fillAllLikeName(searchKey, (pageNum - 1) * ConstantHelper.ITEM_PER_PAGE,
                ConstantHelper.ITEM_PER_PAGE);
    }

    public int countAll() throws SQLException {
        return customerDao.countAll();
    }

    public int countAllByName(String name) throws SQLException {
        return customerDao.countAllByName(name);
    }
    
}
