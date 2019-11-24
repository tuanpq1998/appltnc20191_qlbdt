/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ltnc.nhom3.service;

import com.ltnc.nhom3.dao.PriceDao;
import com.ltnc.nhom3.entity.Price;
import java.sql.SQLException;

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
}
