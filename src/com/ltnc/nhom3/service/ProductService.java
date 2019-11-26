/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ltnc.nhom3.service;

import com.ltnc.nhom3.dao.ProductDao;
import com.ltnc.nhom3.entity.Product;
import com.ltnc.nhom3.utility.ConstantHelper;
import com.sun.corba.se.impl.orbutil.closure.Constant;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author admin
 */
public class ProductService {
    
    private ProductDao productDao;
    
    public ProductService() {
        productDao = new ProductDao();
    }
    
    public List<Product> findAll(int pageNum) throws SQLException {
        return productDao.findAll((pageNum-1) * ConstantHelper.ITEM_PER_PAGE, 
                ConstantHelper.ITEM_PER_PAGE);
    }

    public boolean deleteByIds(int[] listIds) throws SQLException {
        return productDao.deleteManyByIds(listIds);
    }

    public List<Product> findAllByName(String searchKey, int pageNum) throws SQLException {
        return productDao.findAllLikeName(searchKey, (pageNum-1) * ConstantHelper.ITEM_PER_PAGE, 
                ConstantHelper.ITEM_PER_PAGE);
    }

    public Product findById(int id) throws SQLException {
        return productDao.findById(id);
    }

    public boolean deleteById(int id) throws SQLException {
        return productDao.deleteById(id);
    }

    public int createAndReturnId(Product product) throws SQLException {
        return productDao.createAndReturnId(product, true);
    }

    public boolean update(Product newProduct) throws SQLException {
        return productDao.update(newProduct);
    }

    public int countAll() throws SQLException {
        return productDao.countAll();
    }
    
    public int countAllByName(String name) throws SQLException {
        return productDao.countAllLikeName(name);
    }
}
