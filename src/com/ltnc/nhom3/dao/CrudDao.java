/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ltnc.nhom3.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author admin
 * @param <T>
 */
public interface CrudDao<T> {
    
    public boolean create(T t) throws SQLException;
    
    public List<T> findAll() throws SQLException;
    
    public T findById(int id) throws SQLException;
    
    public boolean update(T t) throws SQLException;
    
    public boolean deleteById(int id) throws SQLException;
    
    public T extractFromResultSet(ResultSet resultSet) throws SQLException;
}
