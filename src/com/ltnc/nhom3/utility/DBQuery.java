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
    private static final String CUSTOMER_TABLE = "Customer";
    
    public static final String FIND_ALL_CUSTOMERS = "SELECT * FROM " + CUSTOMER_TABLE;
    public static final String FIND_CUSTOMER_BY_ID = FIND_ALL_CUSTOMERS + " WHERE customer_id = ?";
    public static final String CREATE_NEW_CUSTOMER = "INSERT INTO " + CUSTOMER_TABLE + " VALUES(NULL,?,?,?)";
    public static final String DELETE_CUSTOMER_BY_ID = "DELETE FROM " + CUSTOMER_TABLE 
                + " WHERE customer_id = ?";
    public static final String UPDATE_CUSTOMER = "UPDATE " + CUSTOMER_TABLE 
            + " SET fullname = ? , address = ?, phone = ? WHERE customer_id = ?";
    /* ============================ */
    
    /* =========== Bill =========== */
    private static final String BILL_TABLE = "Bill";
    
    public static final String FIND_ALL_BILLS = "";
    /* ============================ */
    
    /* =========== Manufacturer =========== */
    private static final String MANUFACTURER_TABLE = "Manufacturer";
    
    public static final String FIND_ALL_MANUFACTURERS = "SELECT * FROM " + MANUFACTURER_TABLE;
    public static final String CREATE_NEW_MANUFACTURER = "INSERT INTO " + MANUFACTURER_TABLE + " VALUES(NULL,?,?)";
    public static final String FIND_MANUFACTURER_BY_ID = FIND_ALL_MANUFACTURERS + " WHERE manufacturer_id = ?";
    public static final String UPDATE_MANUFACTUER = "UPDATE " + MANUFACTURER_TABLE 
            + " SET name = ? , country = ? WHERE manufacturer_id = ?";
    public static final String DELETE_MANUFACTUER_BY_ID = "DELETE FROM " + MANUFACTURER_TABLE 
                + " WHERE manufacturer_id = ?";
    public static final String FIND_MANUFACTURER_BY_NAME = FIND_ALL_MANUFACTURERS + " WHERE name = ?";

    /* ============================ */
    
    /* =========== Product =========== */
    private static final String PRODUCT_TABLE = "Product";
    
    public static final String UPDATE_PRODUCT_MANUFACTURER_ID_NULL = "UPDATE " + PRODUCT_TABLE 
            + " SET manufacturer_id = NULL WHERE manufacturer_id = ?";
    
    public static final String FIND_ALL_PRODUCTS = "SELECT * FROM " + PRODUCT_TABLE;
    public static final String FIND_ALL_PRODUCTS_OFFSET_LIMIT = FIND_ALL_PRODUCTS + " WHERE deleted=0 LIMIT ?,?";
    public static final String FIND_ALL_PRODUCTS_BY_NAME = FIND_ALL_PRODUCTS + " WHERE name LIKE ? LIMIT ?,?";
    public static final String DELETE_PRODUCT_BY_ID = "DELETE FROM " + PRODUCT_TABLE 
                + " WHERE product_id = ?";
    public static final String DELETE_MANY_PRODUCT_BY_IDS = "UPDATE " + PRODUCT_TABLE 
                + " SET deleted = 1 WHERE product_id IN (";
    public static final String FIND_PRODUCT_BY_ID = FIND_ALL_PRODUCTS
            + " WHERE product_id = ?";
    public static final String CREATE_NEW_PRODUCT = "INSERT INTO " + PRODUCT_TABLE 
            + " VALUES(NULL,?,?,?,?,?,?,0)";
    public static final String UPDATE_PRODUCT = "UPDATE " + PRODUCT_TABLE 
            + " SET name = ? , manufacturer_id = ?, specifications = ?,"
            + "description = ?, release_date =?, available = ? WHERE product_id = ?";
    public static final String COUNT_ALL_PRODUCTS = "SELECT COUNT(*) FROM " + PRODUCT_TABLE + " WHERE deleted=0";
    public static final String COUNT_ALL_PRODUCTS_BY_NAME = "SELECT COUNT(*) FROM " + PRODUCT_TABLE
            + " WHERE name LIKE ? AND deleted=0";
    
    public static String getQueryDeleteManyProductIds(int numberIds) {
        StringBuilder query = new StringBuilder(DELETE_MANY_PRODUCT_BY_IDS);
        for (int i = 1; i <= numberIds; i++ ) {
            query.append("?");
            if (i != numberIds) query.append(",");
        }
        query.append(")");
        return query.toString();
    }
    /* ============ Price ============ */
    private static final String PRICE_TABLE = "Price";
    public static final String FIND_ALL_PRICES = "SELECT * FROM " + PRICE_TABLE;
    public static final String FIND_PRICE_BY_PRODUCT_ID = FIND_ALL_PRICES + " WHERE product_id=? "
            + "AND current=1";
    public static final String CREATE_NEW_PRICE = "INSERT INTO " + PRICE_TABLE 
            + " VALUES(NULL,?,?,?,NULL,DEFAULT)";
    public static final String UPDATE_PRICE = "UPDATE " + PRICE_TABLE
            + " SET end_date = ?,  current = ? WHERE price_id = ?";
    
    /* =============================== */
    
    /* =========== Employee =========== */
    private static final String EMPLOYEE_TABLE = "Employee";
    
    public static final String FIND_ALL_EMPLOYEES = "SELECT * FROM " + EMPLOYEE_TABLE;
    public static final String FIND_ALL_EMPLOYEES_OFFSET_LIMIT = FIND_ALL_EMPLOYEES + " WHERE admin=0 LIMIT ?,?";
    public static final String FIND_ALL_EMPLOYEES_BY_NAME = FIND_ALL_EMPLOYEES + " WHERE admin=0 AND fullname LIKE ? LIMIT ?,?";
    public static final String CREATE_NEW_EMPLOYEE = "INSERT INTO " + EMPLOYEE_TABLE + " VALUES(NULL,?,?,?,?,?,?,?,1)";
    public static final String FIND_EMPLYEE_BY_ID = FIND_ALL_EMPLOYEES + " WHERE employee_id = ?";
    public static final String UPDATE_EMPLOYEE = "UPDATE " + EMPLOYEE_TABLE
            + " SET fullname = ?,  address = ?, phone= ? , identity_card= ? WHERE employee_id = ?";
    public static final String DISABLE_EMPLOYEE_BY_ID = "UPDATE " + EMPLOYEE_TABLE
            + " SET active=0 WHERE employee_id = ?";
    public static final String FIND_EMPLYEE_BY_USERNAME = FIND_ALL_EMPLOYEES + " WHERE username=?";
    public static String UPDATE_EMPLOYEE_PASSWORD_BY_ID = "UPDATE " + EMPLOYEE_TABLE
            + " SET password = ? WHERE employee_id = ?";
    public static String DISABLE_MANY_EMPLOYEE_BY_IDS = "UPDATE " + EMPLOYEE_TABLE 
            + " SET active=0 WHERE employee_id IN (";
    public static String COUNT_ALL_EMPLOYEES = "SELECT COUNT(*) FROM " + EMPLOYEE_TABLE
            + " WHERE admin = 0";
    public static String COUNT_ALL_EMPLOYEES_BY_NAME = "SELECT COUNT(*) FROM " + EMPLOYEE_TABLE
            + " WHERE admin = 0 AND fullname LIKE ?";
    public static String getQueryDisableManyEmployeeIds(int numberIds) {
        StringBuilder query = new StringBuilder(DISABLE_MANY_EMPLOYEE_BY_IDS);
        for (int i = 1; i <= numberIds; i++) {
            query.append("?");
            if (i != numberIds) query.append(",");
        }
        query.append(")");
        return query.toString();
    }
    /* ============================ */
}
