/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.payroll.controller;

import com.mycompany.payroll.dao.TransactionDAO;
import com.mycompany.payroll.dao.TransactionDetailDAO;
import com.mycompany.payroll.model.TransactionDetail;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Isuru Sankajith
 */
public class TransactionDetailController {
    public List<TransactionDetail>findAllTransactionDetail()throws ClassNotFoundException,SQLException{
       return new TransactionDetailDAO().findAllTransactionDetail();
    }
    
    public List<TransactionDetail>findTransactionDetailsForId(TransactionDetail transactionDetail)throws ClassNotFoundException,SQLException{
       return new TransactionDetailDAO().findTransactionDetailsForId(transactionDetail);
    }
}
