/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ltnc.nhom3.utility;

/**
 *
 * @author admin
 */
public class DBQuery {

    /* ========= Customer ========= */
    private static final String CUSTOMER_TABLE = "customer";
    
    public static final String FIND_ALL_CUSTOMERS = "SELECT * FROM " + CUSTOMER_TABLE;
    public static final String FIND_CUSTOMER_BY_ID = FIND_ALL_CUSTOMERS + " WHERE customer_id = ?";
    public static final String CREATE_NEW_CUSTOMER = "INSERT INTO " + CUSTOMER_TABLE + " VALUES(?,?,?)";
    public static final String DELETE_CUSTOMER_BY_ID = "DELETE FROM " + CUSTOMER_TABLE 
                + " WHERE customer_id = ?";
    public static final String UPDATE_CUSTOMER = "UPDATE " + CUSTOMER_TABLE 
            + " SET fullname = ? , address = ?, phone = ? WHERE customer_id = ?";
    
    /* ============================ */
    
    /* =========== Bill =========== */
    private static final String BILL_TABLE = "customer";
    
    public static String FIND_ALL_BILLS = "";
    
    /* ============================ */
   
    
}
