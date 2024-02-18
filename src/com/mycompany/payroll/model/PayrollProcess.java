/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.payroll.model;

import java.sql.Timestamp;

/**
 *
 * @author Isuru Sankajith
 */
public class PayrollProcess {
    private int month_start_end_id;
    private Timestamp month_start;
    private Timestamp month_end;
    private String lastProcessed_Month;

    public int getMonth_start_end_id() {
        return month_start_end_id;
    }

    public void setMonth_start_end_id(int month_start_end_id) {
        this.month_start_end_id = month_start_end_id;
    }

    public Timestamp getMonth_start() {
        return month_start;
    }

    public void setMonth_start(Timestamp month_start) {
        this.month_start = month_start;
    }

    public Timestamp getMonth_end() {
        return month_end;
    }

    public void setMonth_end(Timestamp month_end) {
        this.month_end = month_end;
    }

    public String getLastProcessed_Month() {
        return lastProcessed_Month;
    }

    public void setLastProcessed_Month(String lastProcessed_Month) {
        this.lastProcessed_Month = lastProcessed_Month;
    }
    
    
}
