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
public class BillDetail 
{
    private String BillDetailID,BillID, productID,note;
    private int quantity,subTotal;
    public String getBillDetailID()
        {
    	return BillDetailID;
        }
    public void setBillDetailID(String billDetailID)
        {
    	BillDetailID = billDetailID;
        }
    public String getBillID()
        {
    	return BillID;
        }
    public void setBillID(String billID)
        {
    	BillID = billID;
        }
    public String getProductID()
        {
    	return productID;
        }
    public void setProductID(String productID)
        {
    	this.productID = productID;
        }
    public String getNote()
        {
    	return note;
        }
    public void setNote(String note)
        {
    	this.note = note;
        }
    public int getQuantity()
        {
    	return quantity;
        }
    public void setQuantity(int quantity)
        {
    	this.quantity = quantity;
        }
    public int getSubTotal()
        {
    	return subTotal;
        }
    public void setSubTotal(int subTotal)
        {
    	this.subTotal = subTotal;
        }
    
    public BillDetail(String BillDetailID, String BillID, String productID, String note, int quantity, int subTotal)
    {
	this.BillDetailID = BillDetailID;
	this.BillID = BillID;
	this.productID = productID;
	this.note = note;
	this.quantity = quantity;
	this.subTotal = subTotal;
    }
}
