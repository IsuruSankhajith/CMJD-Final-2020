/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.payroll.model;

/**
 *
 * @author Isuru Sankajith
 */
public class TransactionDetail {
    private Integer transaction_detail_id;
    private Integer transaction_id;
    private String description;
    private double amount;

    public Integer getTransaction_detail_id() {
        return transaction_detail_id;
    }

    public void setTransaction_detail_id(Integer transaction_detail_id) {
        this.transaction_detail_id = transaction_detail_id;
    }

    public Integer getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(Integer transaction_id) {
        this.transaction_id = transaction_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
    
    
}
