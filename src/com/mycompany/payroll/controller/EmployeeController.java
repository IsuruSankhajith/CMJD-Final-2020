/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.payroll.controller;

import com.mycompany.payroll.dao.EmployeeDAO;
import com.mycompany.payroll.dao.LeaveTypeDAO;
import com.mycompany.payroll.model.Employee;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Isuru Sankajith
 */
public class EmployeeController {

    public List<Employee> findAllEmployee() throws ClassNotFoundException, SQLException {
        return new EmployeeDAO().findAllEmployee();
    }
    
    public List<Employee> findAllEmployeeWithCategoryAndType() throws ClassNotFoundException, SQLException {
        return new EmployeeDAO().findAllEmployeeWithCategoryAndType();
    }
    
    public List<Employee> findEmployeeDetailsForId(Employee employee) throws ClassNotFoundException, SQLException {
        return new EmployeeDAO().findEmployeeDetailsForId(employee);
    }

    public boolean InsertEmployeeDetails(Employee employee) throws ClassNotFoundException, SQLException {
        return new EmployeeDAO().InsertEmployeeDetails(employee);
    }

    public boolean UpdateEmployeeDetails(Employee employee) throws ClassNotFoundException, SQLException {
        return new EmployeeDAO().updateEmployeeDetails(employee);
    }
    
    public void updateRemainingLeave(int employeeID, int leaveTypeID) throws ClassNotFoundException, SQLException {
        new EmployeeDAO().updateRemainingLeave(employeeID, leaveTypeID);
    }
}
