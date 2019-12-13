/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ltnc.nhom3.service;

import com.ltnc.nhom3.dao.PriceDao;
import com.ltnc.nhom3.entity.Price;
import com.ltnc.nhom3.utility.ConstantHelper;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author admin
 */
public class PriceService {
    private PriceDao priceDao;

    public PriceService() {
        priceDao = new PriceDao();
    }
    
    public Price findPriceByProductId(int productId) throws SQLException {
        return priceDao.findByProductId(productId);
    }
    
    public boolean create(Price price) throws SQLException {
        return priceDao.create(price);
    }

    public boolean update(Price price) throws SQLException {
        return priceDao.update(price);
    }

    public List<Price> findAllByProductId(int productId, int pageNum) throws SQLException {
        return priceDao.findAllByProductId(productId, (pageNum-1) * ConstantHelper.ITEM_PER_PAGE, 
                ConstantHelper.ITEM_PER_PAGE);
    }

    public int countAllByProductId(int productId) throws SQLException {
        return priceDao.countAllByProductId(productId);
    }
}
