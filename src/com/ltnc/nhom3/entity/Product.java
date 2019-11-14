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
public class Product {
    private int id, manufacturerId;
    private String name, specifications, decription, releaseDate;
    private boolean available;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getManufacturerId() {
        return manufacturerId;
    }

    public void setManufacturerId(int manufacturerId) {
        this.manufacturerId = manufacturerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecifications() {
        return specifications;
    }

    public void setSpecifications(String specifications) {
        this.specifications = specifications;
    }

    public String getDecription() {
        return decription;
    }

    public void setDecription(String decription) {
        this.decription = decription;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public Product(int id, int manufacturerId, String name, String specifications, String decription, String releaseDate, boolean available) {
        this.id = id;
        this.manufacturerId = manufacturerId;
        this.name = name;
        this.specifications = specifications;
        this.decription = decription;
        this.releaseDate = releaseDate;
        this.available = available;
    }

    public Product() {
    }

    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", manufacturerId=" + manufacturerId + ", name=" + name + ", specifications=" + specifications + ", decription=" + decription + ", releaseDate=" + releaseDate + ", available=" + available + '}';
    }

}
