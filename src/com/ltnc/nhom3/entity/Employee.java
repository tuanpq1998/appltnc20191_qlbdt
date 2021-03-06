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
public class Employee {

    private int id;
    private String fullname, address, phone, indentityCard, username, password;
    private boolean admin, active, male;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getIndentityCard() {
        return indentityCard;
    }

    public void setIndentityCard(String indentityCard) {
        this.indentityCard = indentityCard;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isMale() {
        return male;
    }

    public void setMale(boolean male) {
        this.male = male;
    }

    @Override
    public String toString() {
        return "Employee{" + "id=" + id + ", fullname=" + fullname + ", address=" + address + ", phone=" + phone + ", indentityCard=" + indentityCard + ", username=" + username + ", password=" + password + ", admin=" + admin + ", active=" + active + ", male=" + male + '}';
    }

    public Employee() {
    }

    public Employee(int id, String fullname, String address, String phone, String indentityCard, String username, String password, boolean admin, boolean active, boolean male) {
        this.id = id;
        this.fullname = fullname;
        this.address = address;
        this.phone = phone;
        this.indentityCard = indentityCard;
        this.username = username;
        this.password = password;
        this.admin = admin;
        this.active = active;
        this.male = male;
    }
}
