/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.payroll.dao;

import com.mycompany.payroll.db.DBConnection;
import com.mycompany.payroll.model.Employee;
import com.mycompany.payroll.model.Transaction;
import com.mycompany.payroll.model.TransactionDetail;
import java.sql.Connection;
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
public class TransactionDAO {

    public List<Transaction> findAllTransaction() throws ClassNotFoundException, SQLException {
        List<Transaction> transactions = new ArrayList<>();
        Connection con = DBConnection.getInstance().getConnection();
        String sql = "select * from tb_transaction";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);
        while (rs.next()) {
            Transaction e = new Transaction();
            e.setTransaction_id(rs.getInt("transaction_id"));
            e.setEmployee_id(rs.getInt("employee_id"));
            e.setGross_salary(rs.getInt("gross_salary"));
            e.setNet_salary(rs.getInt("net_salary"));
            e.setSalary_for(rs.getDate("salary_for"));
            e.setTransaction_time(rs.getTimestamp("transaction_time"));
            e.setIs_active(rs.getInt("is_active"));
            transactions.add(e);

        }
        return transactions;
    }

    public boolean InsertTransactionDetails(Transaction obj) throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "insert into tb_transaction (transaction_id,employee_id,gross_salary,net_salary,salary_for,transaction_time,is_active) values(?,?,?,?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, obj.getTransaction_id());
        preparedStatement.setInt(2, obj.getEmployee_id());
        preparedStatement.setInt(3, obj.getGross_salary());
        preparedStatement.setInt(3, obj.getNet_salary());
        preparedStatement.setDate(4, obj.getSalary_for());
        preparedStatement.setTimestamp(5, obj.getTransaction_time());
        preparedStatement.setInt(6, obj.getIs_active());
        boolean isSuccess = false;
        int result = preparedStatement.executeUpdate();
        if (result == 1) {
            isSuccess = true;
        }
        return isSuccess;

    }

    

}
