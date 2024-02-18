/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.payroll.dao;

import com.mycompany.payroll.db.DBConnection;
import com.mycompany.payroll.model.PayrollProcess;
import com.mycompany.payroll.model.PayrollTransaction;
import com.mycompany.payroll.model.PayrollTransactionDetail;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Isuru Sankajith
 */
public class PayrollProcessDAO {

    public List<PayrollProcess> findAllAttendance() throws ClassNotFoundException, SQLException {

        List<PayrollProcess> processList = new ArrayList<>();
        Connection con = DBConnection.getInstance().getConnection();
        String sql = "SELECT month_start_end_id, month_start, month_end, monthname(month_start) as lastProcessed_Month  "
                + "FROM tb_month_start_end";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);
        while (rs.next()) {
            PayrollProcess e = new PayrollProcess();
            e.setMonth_start_end_id(rs.getInt("month_start_end_id"));
            e.setMonth_start(rs.getTimestamp("month_start"));
            e.setMonth_end(rs.getTimestamp("month_end"));
            e.setLastProcessed_Month(rs.getString("lastProcessed_Month"));
            processList.add(e);
        }
        System.out.println(processList.size());
        return processList;
    }

    //fetch trans for report
    public PayrollTransaction findTransactionByEmpIdAndDate(int employeeId, Date date) throws ClassNotFoundException, SQLException {

        PayrollTransaction transaction = new PayrollTransaction();
        Connection con = DBConnection.getInstance().getConnection();
        String sql = "SELECT * FROM tb_transaction WHERE employee_id=? AND salary_for=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, employeeId);
        ps.setDate(2, date);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            transaction.setTransactionId(rs.getInt("transaction_id"));
            transaction.setGrossSalary(rs.getDouble("gross_salary"));
            transaction.setNetSalary(rs.getDouble("net_salary"));
        }
        return transaction;
    }
    
    //fetch trans for report
    public List<PayrollTransactionDetail> findTransactionByTransId(int transactionId) throws ClassNotFoundException, SQLException {

        List<PayrollTransactionDetail> transactionDetails = new ArrayList<>();
        Connection con = DBConnection.getInstance().getConnection();
        String sql = "SELECT * FROM tb_transaction_detail WHERE transaction_id=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, transactionId);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            PayrollTransactionDetail p = new PayrollTransactionDetail();
            p.setDescription(rs.getString("description"));
            p.setAmount(rs.getDouble("amount"));
            transactionDetails.add(p);
        }
        return transactionDetails;
    }
    
    public PayrollProcess findFinanaceMonth() throws ClassNotFoundException, SQLException {

        PayrollProcess payrollProcess = new PayrollProcess();
        Connection con = DBConnection.getInstance().getConnection();
        String sql = "SELECT month_start_end_id, month_start, month_end "
                + "FROM tb_month_start_end WHERE is_processed=0 ";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);
        while (rs.next()) {
            payrollProcess.setMonth_start_end_id(rs.getInt("month_start_end_id"));
            payrollProcess.setMonth_start(rs.getTimestamp("month_start"));
            payrollProcess.setMonth_end(rs.getTimestamp("month_end"));
        }
        return payrollProcess;
    }
    
     public int addFinanceMonth() throws ClassNotFoundException, SQLException {

        Connection con = DBConnection.getInstance().getConnection();
        String sql = "INSERT INTO tb_month_start_end (month_start_end_id, month_start, month_end, is_processed) VALUES(0,current_timestamp(),NULL,0)";
        Statement st = con.createStatement();
        return st.executeUpdate(sql);
    }

    public int updateFinanceMonth() throws ClassNotFoundException, SQLException {

        Connection con = DBConnection.getInstance().getConnection();
        String sql = "UPDATE tb_month_start_end SET month_end=current_timestamp(), is_processed='1' WHERE is_processed='0' AND month_start_end_id>0";
        Statement st = con.createStatement();
        return st.executeUpdate(sql);
    }

    public int addPayrollTransaction(PayrollTransaction payrollTransaction) throws ClassNotFoundException, SQLException {
        
        int transactionId = 0;
        Connection con = DBConnection.getInstance().getConnection();
        String sql = "INSERT INTO tb_transaction (transaction_id, employee_id, gross_salary, net_salary, salary_for, transaction_time, is_active) VALUES (?,?,?,?,?,current_timestamp(),1)";

        PreparedStatement ps = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
        ps.setInt(1, 0);
        ps.setInt(2, payrollTransaction.getEmployeeId());
        ps.setDouble(3, payrollTransaction.getGrossSalary());
        ps.setDouble(4, payrollTransaction.getNetSalary());
        ps.setString(5, payrollTransaction.getSalaryFor());
        int res = ps.executeUpdate();

        ResultSet rs = ps.getGeneratedKeys();

        if (rs.next()) {
            transactionId = rs.getInt(1);
        }
        return transactionId;
    }

    public int addPayrollTransactionDetail(PayrollTransactionDetail payrollTransactionDetail) throws ClassNotFoundException, SQLException {
        Connection con = DBConnection.getInstance().getConnection();
        String sql = "INSERT INTO tb_transaction_detail(transaction_detail_id, transaction_id, description, amount) VALUES (0,?,?,?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, payrollTransactionDetail.getTransactionId());
        ps.setString(2, payrollTransactionDetail.getDescription());
        ps.setDouble(3, payrollTransactionDetail.getAmount());
        return ps.executeUpdate();
    }

}
