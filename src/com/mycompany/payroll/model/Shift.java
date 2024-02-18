/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.payroll.model;

import com.sun.org.apache.xerces.internal.impl.dv.xs.DateTimeDV;
import java.sql.Timestamp;
import java.util.List;
import javax.print.attribute.standard.DateTimeAtCompleted;

/**
 *
 * @author Isuru Sankajith
 */
public class Shift {
    private Integer shift_id;
    private String shift_name;
    private Timestamp  start_time;
    private Timestamp  end_time;

    public Integer getShift_id() {
        return shift_id;
    }

    public void setShift_id(Integer shift_id) {
        this.shift_id = shift_id;
    }

    public String getShift_name() {
        return shift_name;
    }

    public void setShift_name(String shift_name) {
        this.shift_name = shift_name;
    }

    public Timestamp  getStart_time() {
        return start_time;
    }

    public void setStart_time(Timestamp  start_time) {
        this.start_time = start_time;
    }

    public Timestamp  getEnd_time() {
        return end_time;
    }

    public void setEnd_time(Timestamp  end_time) {
        this.end_time = end_time;
    }

    public List<Shift> findAllshiftController() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
