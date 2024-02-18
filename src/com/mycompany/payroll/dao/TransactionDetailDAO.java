/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.payroll.dao;

import com.mycompany.payroll.db.DBConnection;
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
public class TransactionDetailDAO {
    public List<TransactionDetail>findAllTransactionDetail()throws ClassNotFoundException,SQLException{
       List<TransactionDetail> transactionDetails = new ArrayList<>();
       Connection con = DBConnection.getInstance().getConnection();
        String sql = "select * from tb_transaction_detail";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);
        while (rs.next()) {
            TransactionDetail e = new TransactionDetail();
            e.setTransaction_detail_id(rs.getInt("transaction_detail_id"));
            e.setTransaction_id(rs.getInt("transaction_id"));
        }
        return transactionDetails;
        
    }
    
    public List<TransactionDetail>findTransactionDetailsForId(TransactionDetail transactionDetail) throws ClassNotFoundException, SQLException {

        List<TransactionDetail> lstTransactions = new ArrayList<>();
        Connection con = DBConnection.getInstance().getConnection();
        String sql = "select td.transaction_detail_id, td.transaction_id, td.description, td.amount from tb_transaction t\n" +
                    "inner join tb_transaction_detail td on t.transaction_id = td.transaction_id\n" +
                    "where t.transaction_id = ?";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setInt(1, transactionDetail.getTransaction_id());
        preparedStatement.executeQuery();
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()) {
            TransactionDetail e = new TransactionDetail();
            e.setTransaction_id(rs.getInt("transaction_id"));
            e.setTransaction_detail_id(rs.getInt("transaction_detail_id"));
            e.setDescription(rs.getString("description"));
            e.setAmount(rs.getDouble("amount"));
            lstTransactions.add(e);
        }
        return lstTransactions;
    }
    
}
