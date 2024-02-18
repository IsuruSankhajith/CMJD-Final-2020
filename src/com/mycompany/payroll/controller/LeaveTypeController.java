/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.payroll.controller;

import com.mycompany.payroll.dao.LeaveTypeDAO;
import com.mycompany.payroll.model.LeaveType;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Isuru Sankajith
 */
public class LeaveTypeController {

    public List<LeaveType> findAllLeaveType() throws ClassNotFoundException, SQLException {
        return new LeaveTypeDAO().findAllLeaveType();
    }

    public boolean InsertLeaveTypeDetails(LeaveType obj) throws ClassNotFoundException, SQLException {
        return new LeaveTypeDAO().InsertLeaveTypeDetails(obj);
    }

    public boolean UpdateLeaveTypeDetails(LeaveType obj) throws ClassNotFoundException, SQLException {
        return new LeaveTypeDAO().InsertLeaveTypeDetails(obj);
    }

    public LeaveType getLeaveTypeIdforTypeName(LeaveType obj) throws ClassNotFoundException, SQLException {
        return new LeaveTypeDAO().getLeaveTypeIdforTypeName(obj);
    }

   
}
