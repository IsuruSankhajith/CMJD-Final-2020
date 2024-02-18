/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.payroll.model;

/**
 *
 * @author User
 */
public class PayrollTransactionDetail {
    
    private int transactionDetailId;
    private int transactionId;
    private String description;
    private double amount;

    public PayrollTransactionDetail(String description) {
        this.description = description;
    }

    public PayrollTransactionDetail() {
    }

    public int getTransactionDetailId() {
        return transactionDetailId;
    }

    public void setTransactionDetailId(int transactionDetailId) {
        this.transactionDetailId = transactionDetailId;
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

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }
    
}
