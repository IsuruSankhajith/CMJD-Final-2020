/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.payroll.controller;

import com.mycompany.payroll.dao.LeaveDAO;
import com.mycompany.payroll.model.Leave;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author madus
 */
public class LeaveController {
    public boolean InsertLeaveForm(Leave leave) throws ClassNotFoundException,SQLException{
        return new LeaveDAO().InsertLeaveForm(leave);
    }
    
    public List<Leave> findAllLeaveDetails() throws ClassNotFoundException,SQLException{
        return new LeaveDAO().findAllLeaveDetails();
    }

    public List<Leave> findLeavedetailsForID(Leave leave) throws ClassNotFoundException, SQLException {
        return new LeaveDAO().findLeavedetailsForID(leave);
    }

    public boolean UpdateLeaveForm(Leave objLeave) throws ClassNotFoundException, SQLException {
        return new LeaveDAO().UpdateLeaveForm(objLeave);
    }
}
