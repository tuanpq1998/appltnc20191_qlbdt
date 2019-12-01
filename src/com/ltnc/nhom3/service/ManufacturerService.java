/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ltnc.nhom3.service;

import com.ltnc.nhom3.dao.ManufacturerDao;
import com.ltnc.nhom3.entity.Manufacturer;
import java.sql.SQLException;
import java.util.List;

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

    public List<Manufacturer> findAll() throws SQLException {
        return manufacturerDao.findAll();
    }
    
    public Manufacturer findByName(String name) throws SQLException {
        return manufacturerDao.findByName(name);
    }
    
    public int createAndReturnId(Manufacturer manufacturer) throws SQLException {
        return manufacturerDao.createAndReturnId(manufacturer);
    }
    
    public int getIdByName(String name) throws SQLException {
        Manufacturer m = findByName(name);
        return m == null ? -1 : m.getId();
    }

    public void update(Manufacturer manufacturer) throws SQLException {
        manufacturerDao.update(manufacturer);
    }

    public void deleteById(int id) throws SQLException {
        manufacturerDao.deleteById(id);
    }
    
}
