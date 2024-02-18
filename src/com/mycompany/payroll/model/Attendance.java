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
public class Attendance {

    private int attendance_id;
    private Timestamp in_time;
    private Timestamp out_time;
    private int employee_id;
    private Date attendance_date;
    private Shift shift;
    private String fullName;
    

    public int getAttendance_id() {
        return attendance_id;
    }

    public void setAttendance_id(int attendance_id) {
        this.attendance_id = attendance_id;
    }

    public Timestamp getIn_time() {
        return in_time;
    }

    public void setIn_time(Timestamp in_time) {
        this.in_time = in_time;
    }

    public Timestamp getOut_time() {
        return out_time;
    }

    public void setOut_time(Timestamp out_time) {
        this.out_time = out_time;
    }

    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    public Date getAttendance_date() {
        return attendance_date;
    }

    public void setAttendance_date(Date attendance_date) {
        this.attendance_date = attendance_date;
    }

    public Shift getShift() {
        return shift;
    }

    public void setShift(Shift shift) {
        this.shift = shift;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

}
