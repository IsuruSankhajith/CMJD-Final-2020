/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.payroll.controller;

import com.mycompany.payroll.dao.EmployeeDAO;
import com.mycompany.payroll.dao.PayrollProcessDAO;
import com.mycompany.payroll.model.DataObj;
import com.mycompany.payroll.model.Employee;
import com.mycompany.payroll.model.PayrollTransaction;
import com.mycompany.payroll.model.PayrollTransactionDetail;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author User
 */
public class ReportController {
    
    public void printPaySlip(int employeeId, Date date) throws ClassNotFoundException, SQLException, JRException{
        
        EmployeeDAO employeeDAO = new EmployeeDAO();
        PayrollProcessDAO payrollProcessDAO = new PayrollProcessDAO();
        Employee employee = employeeDAO.findEmployeeById(employeeId);
        PayrollTransaction transaction = payrollProcessDAO.findTransactionByEmpIdAndDate(employeeId, date);
        List<PayrollTransactionDetail> transactionDetails = payrollProcessDAO.findTransactionByTransId(transaction.getTransactionId());
        List<DataObj> data = new ArrayList<>();
        
        Map<String, Object> parameters = parameters = new HashMap<>();
        parameters.put("empName", employee.getFirstName()+" "+employee.getLastName());
        parameters.put("empNic", employee.getNic());
        parameters.put("empNum", employee.getEmployeeId());
        
        DataObj obj1 = new DataObj("Basic Salary", String.valueOf(employee.getBasicSalary()));
        data.add(obj1);
        
        for (PayrollTransactionDetail transactionDetail : transactionDetails) {
            DataObj obj = new DataObj(transactionDetail.getDescription(), String.valueOf(transactionDetail.getAmount()));
            data.add(obj);
        }
        parameters.put("netSal", String.valueOf(transaction.getNetSalary()));
        
        String sourceFileName = ReportController.class.getClassLoader().getResource("PaySlip.jrxml").getPath();
        
        JRDataSource dataSource = new JRBeanCollectionDataSource(data);
        JasperReport jasperReport = JasperCompileManager.compileReport(sourceFileName);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
        JasperViewer.viewReport(jasperPrint, false);
        
    }
    
    
    
}
