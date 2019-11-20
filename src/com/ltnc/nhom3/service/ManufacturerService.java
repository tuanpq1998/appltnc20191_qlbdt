/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ltnc.nhom3.service;

import com.ltnc.nhom3.dao.ManufacturerDao;
import com.ltnc.nhom3.entity.Manufacturer;
import java.sql.SQLException;

/**
 *
 * @author admin
 */
public class ManufacturerService {
    private ManufacturerDao manufacturerDao;
    
    public ManufacturerService() {
        manufacturerDao = new ManufacturerDao();
    }
    
    public Manufacturer findById(int id) throws SQLException {
        return manufacturerDao.findById(id);
    }
}
