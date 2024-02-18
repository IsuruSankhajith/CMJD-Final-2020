/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.payroll.dao;

import com.mycompany.payroll.controller.EmployeeController;
import com.mycompany.payroll.db.DBConnection;
import com.mycompany.payroll.model.Attendance;
import com.mycompany.payroll.model.Leave;
import com.mycompany.payroll.model.LeaveType;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class LeaveDAO {

    public List<Leave> findAllLeaveByEmployeeId(int employeeId, Timestamp monthStart) throws ClassNotFoundException, SQLException {

        List<Leave> leaves = new ArrayList<>();
        Connection con = DBConnection.getInstance().getConnection();
        String sql = "SELECT employee_leave_id, employee_id, el.leave_date, el.leave_type_id, type_name, no_of_hour FROM tb_employee_leave el\n"
                + "LEFT JOIN tb_leave_type lt ON el.leave_type_id=lt.leave_type_id WHERE employee_id=? AND leave_date BETWEEN ? AND current_timestamp()";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, employeeId);
        ps.setTimestamp(2, monthStart);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Leave l = new Leave();
            l.setEmployeeId(rs.getInt("employee_id"));
            l.setLeaveDate(rs.getDate("leave_date"));

            LeaveType leaveType = new LeaveType();
            leaveType.setLeave_type_id(rs.getInt("leave_type_id"));
            leaveType.setType_name(rs.getString("type_name"));
            leaveType.setNo_of_hour(rs.getInt("no_of_hour"));
            l.setLeaveType(leaveType);

            leaves.add(l);

        }
        return leaves;
    }

    public boolean InsertLeaveForm(Leave obj) throws ClassNotFoundException, SQLException {
        Connection con = DBConnection.getInstance().getConnection();
        String sql = "insert into tb_employee_leave (employee_id,leave_date,"
                + "leave_type_id,reason) values (?,?,?,?)";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setInt(1, obj.getEmployeeId());
        preparedStatement.setDate(2, obj.getLeaveDate());
        preparedStatement.setInt(3, obj.getLeave_type_id());
        preparedStatement.setString(4, obj.getReason());

        boolean isSuccess = false;
        int result = preparedStatement.executeUpdate();
        if (result == 1) {
            isSuccess = true;
            new EmployeeController().updateRemainingLeave(obj.getEmployeeId(), obj.getLeave_type_id());
        }
        return isSuccess;
    }

    public List<Leave> findAllLeaveDetails() throws ClassNotFoundException, SQLException {

        List<Leave> leaves = new ArrayList<>();
        Connection con = DBConnection.getInstance().getConnection();
        String sql = "select * from tb_employee_leave e "
                + "inner join tb_leave_type lt on lt.leave_type_id = e.leave_type_id";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Leave l = new Leave();
            l.setEmployeeId(rs.getInt("employee_id"));
            l.setLeaveDate(rs.getDate("leave_date"));
            l.setLeaveId(rs.getInt("employee_leave_id"));
            l.setType_name(rs.getString("type_name"));
            l.setReason(rs.getString("reason"));

            leaves.add(l);

        }
        return leaves;
    }

    public List<Leave> findLeavedetailsForID(Leave leave) throws ClassNotFoundException, SQLException {
        List<Leave> leaves = new ArrayList<>();
        Connection con = DBConnection.getInstance().getConnection();
        String sql = "select * from tb_employee_leave where employee_leave_id = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Leave l = new Leave();
            l.setEmployeeId(rs.getInt("employee_id"));
            l.setLeaveDate(rs.getDate("leave_date"));
            l.setLeaveId(rs.getInt("employee_leave_id"));
            l.setType_name(rs.getString("type_name"));
            l.setReason(rs.getString("reason"));

            leaves.add(l);

        }
        return leaves;
    }

    public boolean UpdateLeaveForm(Leave objLeave) throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "Update tb_employee_leave set employee_id = ?, leave_date=?, leave_type_id = ?, reason = ? where employee_leave_id=?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        //preparedStatement.setInt(1,obj.getEmployeeId());
        preparedStatement.setInt(1, objLeave.getEmployeeId());
        preparedStatement.setDate(2, objLeave.getLeaveDate());
        preparedStatement.setInt(3, objLeave.getLeaveId());
        preparedStatement.setString(4, objLeave.getReason());
        preparedStatement.setInt(5, objLeave.getLeaveId());

        boolean isSuccess = false;
        int result = preparedStatement.executeUpdate();
        if (result == 1) {
            isSuccess = true;
        }
        return isSuccess;
    }
}
