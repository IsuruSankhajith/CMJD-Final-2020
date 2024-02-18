/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.payroll.controller;

import com.mycompany.payroll.dao.HolidayDAO;
import com.mycompany.payroll.model.Holiday;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Isuru Sankajith
 */
public class HolidayController {

    public List<Holiday> findAllHoliday() throws ClassNotFoundException, SQLException {
        return new HolidayDAO().findAllHoliday();
    }

    public boolean InsertHolidayDetails(Holiday obj) throws ClassNotFoundException, SQLException {
        return new HolidayDAO().InsertHolidayDetails(obj);
    }

    public boolean UpdateHolidayDetails(Holiday obj) throws ClassNotFoundException, SQLException {
        return new HolidayDAO().InsertHolidayDetails(obj);
    }
}
