/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.payroll.dao;

import com.mycompany.payroll.db.DBConnection;
import com.mycompany.payroll.model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author madus
 */
public class UserDAO {
    public int findUserByUserNameAndPassword(User user) throws ClassNotFoundException, SQLException{
        
        int result = 0;
        Connection con  = DBConnection.getInstance().getConnection();
        String sql = "SELECT * FROM tb_user WHERE user_name=? AND password=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, user.getUserName());
        ps.setString(2, user.getPassword());
        ResultSet rs = ps.executeQuery();
        if(rs!=null && rs.next()){
            result = 1;
        }
        return result;
    }
}
