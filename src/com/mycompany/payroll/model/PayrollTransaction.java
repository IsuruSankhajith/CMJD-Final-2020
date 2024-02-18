/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.payroll.model;

import java.util.Date;
import java.sql.Timestamp;
import java.util.List;

/**
 *
 * @author User
 */
public class PayrollTransaction {
    
    private int transactionId;
    private int employeeId;
    private double grossSalary;
    private double netSalary;
    private String salaryFor;
    private Timestamp transactionTime;
    private int isActive;
    private List<PayrollTransactionDetail> transactionDetails;

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public double getGrossSalary() {
        return grossSalary;
    }

    public void setGrossSalary(double grossSalary) {
        this.grossSalary = grossSalary;
    }

    public double getNetSalary() {
        return netSalary;
    }

    public void setNetSalary(double netSalary) {
        this.netSalary = netSalary;
    }

    public String getSalaryFor() {
        return salaryFor;
    }

    public void setSalaryFor(String salaryFor) {
        this.salaryFor = salaryFor;
    }

    public Timestamp getTransactionTime() {
        return transactionTime;
    }

    public void setTransactionTime(Timestamp transactionTime) {
        this.transactionTime = transactionTime;
    }

    public int getIsActive() {
        return isActive;
    }

    public void setIsActive(int isActive) {
        this.isActive = isActive;
    }

    public List<PayrollTransactionDetail> getTransactionDetails() {
        return transactionDetails;
    }

    public void setTransactionDetails(List<PayrollTransactionDetail> transactionDetails) {
        this.transactionDetails = transactionDetails;
    }
    
    
    
}
