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
public class Customer {
    
    private int id;
    private String fullname;
    private String address;
    private String phone;

    public int getId() {
        return id;
    }

    public String getFullname() {
        return fullname;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Customer{" + "id=" + id + ", fullname=" + fullname + ", address=" + address + ", phone=" + phone + '}';
    }

    public Customer(int id, String fullname, String address, String phone) {
        this.id = id;
        this.fullname = fullname;
        this.address = address;
        this.phone = phone;
    }

    public Customer() {
    }

}
