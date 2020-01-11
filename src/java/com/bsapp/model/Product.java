/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsapp.model;

/**
 *
 * @author BEmerson
 */
public class Product {
    
    private long id;
    private String name;
    private String description;

    /**
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * @return the prodName
     */
    public String getName() {
        return name;
    }

    /**
     * @param prodName the prodName to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the prodDescription
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param prodDescription the prodDescription to set
     */
    public void setDescription(String description) {
        this.description = description;
    }
    
}
