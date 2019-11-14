/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ltnc.nhom3.entity;

/**
 *
 * @author admin
 */
public class Manufacturer {
private String manufacturerID,manufacturerName,Country;

public String getManufacturerID()
    {
	return manufacturerID;
    }

public void setManufacturerID(String manufacturerID)
    {
	this.manufacturerID = manufacturerID;
    }

public String getManufacturerName()
    {
	return manufacturerName;
    }

public void setManufacturerName(String manufacturerName)
    {
	this.manufacturerName = manufacturerName;
    }

public String getCountry()
    {
	return Country;
    }

public void setCountry(String country)
    {
	Country = country;
    }
public Manufacturer(String manufacturerID, String manufacturerName, String Country)
{
    this.manufacturerID = manufacturerID;
    this.manufacturerName=manufacturerName;
    this.Country=Country;
}
}