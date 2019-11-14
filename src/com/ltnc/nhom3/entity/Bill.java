/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ltnc.nhom3.entity;

import java.util.Date;

/**
 *
 * @author admin
 */
public class Bill {
    private String billID, customerID;
    private Date createDate;
    public String getBillID()
        {
    	return billID;
        }
    public void setBillID(String billID)
        {
    	this.billID = billID;
        }
    public String getCustomerID()
        {
    	return customerID;
        }
    public void setCustomerID(String customerID)
        {
    	this.customerID = customerID;
        }
    public Date getCreateDate()
        {
    	return createDate;
        }
    public void setCreateDate(Date createDate)
        {
    	this.createDate = createDate;
        }
    
    public Bill(String BillID, String CustomerID, Date CreateDate)
    {
	this.billID = BillID;
	this.customerID = CustomerID;
	this.createDate = CreateDate;
    }
}
