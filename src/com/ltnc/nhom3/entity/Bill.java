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
public class Bill {
    private int id, customerId, employeeId;
    private String createDate, note;
    private double totalMoney;

    public Bill(int id, int customerId, int employeeId, String createDate, double totalMoney, String note) {
        this.id = id;
        this.customerId = customerId;
        this.employeeId = employeeId;
        this.createDate = createDate;
        this.totalMoney = totalMoney;
        this.note = note;
    }

    public Bill() {
    }

    public int getId() {
        return id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getCreateDate() {
        return createDate;
    }

    public double getTotalMoney() {
        return totalMoney;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public void setTotalMoney(double totalMoney) {
        this.totalMoney = totalMoney;
    }

    @Override
    public String toString() {
        return "Bill{" + "id=" + id + ", customerId=" + customerId + ", employeeId=" + employeeId + ", createDate=" + createDate + ", totalMoney=" + totalMoney + '}';
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
