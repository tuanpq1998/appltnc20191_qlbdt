/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ltnc.nhom3.service;

import com.ltnc.nhom3.dao.ProductDao;
import com.ltnc.nhom3.entity.Product;
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
    
    public List<Product> findAll() throws SQLException {
        return productDao.findAll();
    }

    public boolean deleteByIds(int[] listIds) throws SQLException {
        return productDao.deleteManyByIds(listIds);
    }

    public List<Product> findAllByName(String searchKey) throws SQLException {
        return productDao.findAllByName(searchKey);
    }

    public Product findById(int id) throws SQLException {
        return productDao.findById(id);
    }

    public boolean deleteById(int id) throws SQLException {
        return productDao.deleteById(id);
    }

    public int create(Product product) throws SQLException {
        return productDao.create(product, true);
    }

    public boolean update(Product newProduct) throws SQLException {
        return productDao.update(newProduct);
    }
}
