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
public class Price {
    private int id, productId;
    private double value;
    private String startDate, endDate;
    private boolean current;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public boolean isCurrent() {
        return current;
    }

    public void setCurrent(boolean current) {
        this.current = current;
    }
    
    public Price() {
    }

    public Price(int id, int productId, double value, String startDate, String endDate, boolean current) {
        this.id = id;
        this.productId = productId;
        this.value = value;
        this.startDate = startDate;
        this.endDate = endDate;
        this.current = current;
    }

    @Override
    public String toString() {
        return "Price{" + "id=" + id + ", productId=" + productId + ", value=" + value + ", startDate=" + startDate + ", endDate=" + endDate + ", current=" + current + '}';
    }  
    
}
