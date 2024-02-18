/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.payroll.model;

import java.sql.Date;



/**
 *
 * @author User
 */
public class Leave {
   
    private int leaveId;
    private int employeeId;
    private Date leaveDate;
    private LeaveType leaveType;
    private int leave_type_id;
    private String reason;
    private String type_name; 

    public String getType_name() {
        return type_name;
    }

    public void setType_name(String type_name) {
        this.type_name = type_name;
    }
    public int getLeaveId() {
        return leaveId;
    }

    public int getLeave_type_id() {
        return leave_type_id;
    }

    public void setLeave_type_id(int leave_type_id) {
        this.leave_type_id = leave_type_id;
    }

    public void setLeaveId(int leaveId) {
        this.leaveId = leaveId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public Date getLeaveDate() {
        return leaveDate;
    }

    public void setLeaveDate(Date leaveDate) {
        this.leaveDate = leaveDate;
    }

    public LeaveType getLeaveType() {
        return leaveType;
    }

    public void setLeaveType(LeaveType leaveType) {
        this.leaveType = leaveType;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
    
}
