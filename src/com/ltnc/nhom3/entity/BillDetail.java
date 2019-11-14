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
public class BillDetail {
    private int id, billId, productId, quantity;
    private float subTotal;
    private String note;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBillId() {
        return billId;
    }

    public void setBillId(int billId) {
        this.billId = billId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(float subTotal) {
        this.subTotal = subTotal;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public BillDetail() {
    }

    public BillDetail(int id, int billId, int productId, int quantity, float subTotal, String note) {
        this.id = id;
        this.billId = billId;
        this.productId = productId;
        this.quantity = quantity;
        this.subTotal = subTotal;
        this.note = note;
    }

    @Override
    public String toString() {
        return "BillDetail{" + "id=" + id + ", billId=" + billId + ", productId=" + productId + ", quantity=" + quantity + ", subTotal=" + subTotal + ", note=" + note + '}';
    }

}
