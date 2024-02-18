/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.payroll.dao;

import com.mycompany.payroll.db.DBConnection;
import com.mycompany.payroll.model.LeaveType;
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
public class LeaveTypeDAO {

    public List<LeaveType> findAllLeaveType() throws ClassNotFoundException, SQLException {
        List<LeaveType> leave = new ArrayList<>();
        Connection con = DBConnection.getInstance().getConnection();
        String sql = "select * from tb_leave_type";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);
        while (rs.next()) {
            LeaveType l = new LeaveType();
            l.setLeave_type_id(rs.getInt("leave_type_id"));
            l.setType_name(rs.getString("type_name"));
            l.setNo_of_hour(rs.getInt("no_of_hour"));
            leave.add(l);
        }
        return leave;
    }

    public boolean InsertLeaveTypeDetails(LeaveType obj) throws ClassNotFoundException, SQLException {
        boolean isSuccess = false;
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "Insert into tb_leave_type(type_Name,no_of_hour)values (?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, obj.getType_name());
        preparedStatement.setInt(2, obj.getNo_of_hour());
        int result = preparedStatement.executeUpdate();
        if (result == 1) {
            isSuccess = true;
        }
        return isSuccess;
    }

    public boolean updateLeaveType(LeaveType obj) throws ClassNotFoundException, SQLException {
        boolean isSuccess = false;
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "update tb_leave_type set type_name=?,no_of_hour=? where leave_type_id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, obj.getType_name());
        preparedStatement.setInt(2, obj.getNo_of_hour());
        int result = preparedStatement.executeUpdate();
        if (result == 1) {
            isSuccess = true;
        }
        return isSuccess;
    }

    public LeaveType getLeaveTypeIdforTypeName(LeaveType obj) throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "select * from tb_leave_type where type_name =?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, obj.getType_name());
        System.out.println(obj.getType_name());
        ResultSet rs = preparedStatement.executeQuery();
        LeaveType l = new LeaveType();
        while (rs.next()) {
            l.setLeave_type_id(rs.getInt("leave_type_id"));
            l.setType_name(rs.getString("type_name"));
            l.setNo_of_hour(rs.getInt("no_of_hour"));
        }
        return l;
    }

}
