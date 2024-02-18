/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.payroll.controller;

import com.mycompany.payroll.dao.AttendanceDetailDAO;
import com.mycompany.payroll.model.Attendance;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Isuru Sankajith
 */
public class AttendanceController {
    
    public boolean InsertAttendanceDetails(Attendance obj)throws ClassNotFoundException,SQLException{
        return new AttendanceDetailDAO().InsertAttendanceDetails(obj);
    }
    
    public List<Attendance> findAllAttendance()throws ClassNotFoundException,SQLException{
        return new AttendanceDetailDAO().findAllAttendance();
                
    }
}
