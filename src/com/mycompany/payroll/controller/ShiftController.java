/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.payroll.controller;

import com.mycompany.payroll.dao.HolidayDAO;
import com.mycompany.payroll.dao.ShiftDAO;
import com.mycompany.payroll.model.Shift;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Isuru Sankajith
 */
public class ShiftController {

    public List<Shift> findAllShift() throws ClassNotFoundException, SQLException {
        return new ShiftDAO().findAllShift();
    }

    public boolean InsertShiftDetails(Shift obj) throws ClassNotFoundException, SQLException {
        return new ShiftDAO().InsertShiftDetails(obj);
    }

    public boolean UpdateShiftDetails(Shift obj) throws ClassNotFoundException, SQLException {
        return new ShiftDAO().InsertShiftDetails(obj);
    }
    
    public int getShiftDetails(Shift obj)throws ClassNotFoundException, SQLException{
        return new ShiftDAO().getShift(obj);
    }
}
