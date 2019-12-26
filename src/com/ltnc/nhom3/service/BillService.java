/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ltnc.nhom3.service;

import com.ltnc.nhom3.dao.BillDao;
import com.ltnc.nhom3.entity.Bill;
import com.ltnc.nhom3.utility.ConstantHelper;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author admin
 */
public class BillService {
    
    private BillDao billDao;
    
    public BillService() {
        billDao = new BillDao();
    }
    
    public List<Bill> findAll(int pageNum) throws SQLException {
        return billDao.findAll((pageNum-1) * ConstantHelper.ITEM_PER_PAGE, 
                ConstantHelper.ITEM_PER_PAGE);
    }

    public int countAll() throws SQLException {
        return billDao.countAll();
    }

    public Bill findById(int billId) throws SQLException {
        return billDao.findById(billId);
    }

    public int create(Bill bill) throws SQLException {
        return billDao.create(bill);
    }

    public void update(Bill bill) throws SQLException {
        billDao.update(bill);
    }

}
