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
    private int id;
    private String name;
    private String country;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Manufacturer(int id, String name, String country) {
        this.id = id;
        this.name = name;
        this.country = country;
    }

    public Manufacturer() {
    }

}
