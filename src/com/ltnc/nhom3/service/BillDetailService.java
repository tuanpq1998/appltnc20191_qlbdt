package com.ltnc.nhom3.service;

import com.ltnc.nhom3.dao.BillDetailDao;
import com.ltnc.nhom3.entity.BillDetail;
import com.ltnc.nhom3.utility.ConstantHelper;
import java.sql.SQLException;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author admin
 */
public class BillDetailService {

    private BillDetailDao billDetailDao;
    
    public BillDetailService() {
        billDetailDao = new BillDetailDao();
    }

    public List<BillDetail> findAllByBillId(int billId, int pageNum) throws SQLException {
        return billDetailDao.findAllByBillId(billId, (pageNum-1) * ConstantHelper.ITEM_BILLDETAIL_PER_PAGE, 
                ConstantHelper.ITEM_BILLDETAIL_PER_PAGE);
    }

    public int countAllByBillId(int billId) throws SQLException {
        return billDetailDao.countAllByBillId(billId);
    }

    public void create(BillDetail billDetail) throws SQLException {
        billDetailDao.create(billDetail);
    }

    public void createFromList(List<BillDetail> listBillDetails) throws SQLException {
        billDetailDao.createFromList(listBillDetails);
    }

    public int findSumQuantityByBillId(int billId) throws SQLException {
        return billDetailDao.countSumQuantityByBillId(billId);
    }
    
    public List<BillDetail> findAllByBillId(int billId) throws SQLException {
        return billDetailDao.findAllByBillId(billId);
    }
    
}
