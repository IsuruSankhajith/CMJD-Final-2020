/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.payroll.controller;

import com.mycompany.payroll.dao.TransactionDAO;
import com.mycompany.payroll.model.Transaction;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Isuru Sankajith
 */
public class TransactionController {
   public List<Transaction>findAllTransaction()throws ClassNotFoundException,SQLException{
       return new TransactionDAO().findAllTransaction();
   }
   
   public boolean InsertTransactionDetails(Transaction obj)throws ClassNotFoundException,SQLException{
       return new TransactionDAO().InsertTransactionDetails(obj);
}
}
