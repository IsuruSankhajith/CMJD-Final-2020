/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.payroll.controller;

import com.mycompany.payroll.dao.EmployeeCategoryDAO;
import com.mycompany.payroll.model.EmployeeCategory;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Isuru Sankajith
 */
public class EmployeeCategoryController {

    public List<EmployeeCategory> findAllEmployeeCategory() throws ClassNotFoundException, SQLException {
        return new EmployeeCategoryDAO().findAllEmployeeCategory();

    }

    public boolean InsertEmployeeCategoryDetails(EmployeeCategory obj) throws ClassNotFoundException, SQLException {
        return new EmployeeCategoryDAO().InsertEmployeeCategoryDetails(obj);
    }

    public boolean UpdateEmployeeCategoryDetails(EmployeeCategory obj) throws ClassNotFoundException, SQLException {
        return new EmployeeCategoryDAO().InsertEmployeeCategoryDetails(obj);
    }
    
    public int getEmployeeCategoryDetails(EmployeeCategory obj) throws ClassNotFoundException,SQLException{
        return new EmployeeCategoryDAO().getEmployeeCategory(obj);
    }
}