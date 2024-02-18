/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.payroll.controller;


import com.mycompany.payroll.dao.UserDAO;
import com.mycompany.payroll.db.DBConnection;
import com.mycompany.payroll.model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Isuru Sankajith
 */
public class UserController {
    
    public int findUserByUserNameAndPassword(User user) throws ClassNotFoundException, SQLException{
       return new UserDAO().findUserByUserNameAndPassword(user);
    }
}
