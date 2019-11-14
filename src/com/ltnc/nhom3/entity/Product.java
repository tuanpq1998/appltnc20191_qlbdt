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
public class Product {
    private String productID,productName,manufacturerID,specification,description;
    private int available;
    private Date realeaseDate;
    public String getProductID()
        {
    	return productID;
        }
    public void setProductID(String productID)
        {
    	this.productID = productID;
        }
    public String getProductName()
        {
    	return productName;
        }
    public void setProductName(String productName)
        {
    	this.productName = productName;
        }
    public String getManufacturerID()
        {
    	return manufacturerID;
        }
    public void setManufacturerID(String manufacturerID)
        {
    	this.manufacturerID = manufacturerID;
        }
    public String getSpecification()
        {
    	return specification;
        }
    public void setSpecification(String specification)
        {
    	this.specification = specification;
        }
    public String getDescription()
        {
    	return description;
        }
    public void setDescription(String description)
        {
    	this.description = description;
        }
    public int getAvailable()
        {
    	return available;
        }
    public void setAvailable(int available)
        {
    	this.available = available;
        }
    public Date getRealeaseDate()
        {
    	return realeaseDate;
        }
    public void setRealeaseDate(Date realeaseDate)
        {
    	this.realeaseDate = realeaseDate;
        }
    public Product(String productID, String productName, String manufacturerID, String Specification, String description, int available, Date releaseDate)
    {
	this.productID=productID;
	this.productName=productName;
	this.manufacturerID=manufacturerID;
	this.specification=Specification;
	this.description=description;
	this.available=available;
	this.realeaseDate=releaseDate;
	
    }
}
