/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.payroll.model;

import java.sql.Date;
import java.sql.Timestamp;

/**
 *
 * @author Isuru Sankajith
 */
public class Transaction {

    private Integer transaction_id;
    private Integer employee_id;
    private Integer gross_salary;
    private Integer net_salary;
    private Date salary_for;
    private Timestamp transaction_time;
    private Integer is_active;
  

    public Integer getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(Integer transaction_id) {
        this.transaction_id = transaction_id;
    }

    public Integer getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(Integer employee_id) {
        this.employee_id = employee_id;
    }

    public Integer getGross_salary() {
        return gross_salary;
    }

    public void setGross_salary(Integer gross_salary) {
        this.gross_salary = gross_salary;
    }

    public Integer getNet_salary() {
        return net_salary;
    }

    public void setNet_salary(Integer net_salary) {
        this.net_salary = net_salary;
    }

    public Date getSalary_for() {
        return salary_for;
    }

    public void setSalary_for(Date salary_for) {
        this.salary_for = salary_for;
    }

    public Timestamp getTransaction_time() {
        return transaction_time;
    }

    public void setTransaction_time(Timestamp transaction_time) {
        this.transaction_time = transaction_time;
    }

    public Integer getIs_active() {
        return is_active;
    }

    public void setIs_active(Integer is_active) {
        this.is_active = is_active;
    }

}
