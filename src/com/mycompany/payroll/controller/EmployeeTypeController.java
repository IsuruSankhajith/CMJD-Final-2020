/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.payroll.controller;

import com.mycompany.payroll.dao.EmployeeTypeDAO;
import com.mycompany.payroll.model.EmployeeType;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Isuru Sankajith
 */
public class EmployeeTypeController {

    public List<EmployeeType> findAllEmployeeType() throws ClassNotFoundException, SQLException {
        return new EmployeeTypeDAO().findAllEmployeeType();
    }

    public boolean InsertEmployeeTypeDetails(EmployeeType obj) throws ClassNotFoundException, SQLException {
        return new EmployeeTypeDAO().insertEmployeeTypeDetails(obj);
    }

    public boolean updateEmployeeTypeDetails(EmployeeType obj) throws ClassNotFoundException, SQLException {
        return new EmployeeTypeDAO().updateEmployeeTypeDetails(obj);
    }

    public int getEmployeeType(EmployeeType obj) throws ClassNotFoundException, SQLException {
        return new EmployeeTypeDAO().getEmployeeType(obj);
    }

    public int getLeaveCountForTypeID(int typeID) throws ClassNotFoundException, SQLException {
        return new EmployeeTypeDAO().getLeaveCountForTypeID(typeID);
    }

}
