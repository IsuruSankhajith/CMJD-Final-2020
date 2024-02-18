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
public class Holiday {
    private Integer holiday_id;
    private Double hours;
    private Date date;
    private String reason;

    public Integer getHoliday_id() {
        return holiday_id;
    }

    public void setHoliday_id(Integer holiday_id) {
        this.holiday_id = holiday_id;
    }

    public Double getHours() {
        return hours;
    }

    public void setHours(Double hours) {
        this.hours = hours;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
        
}
