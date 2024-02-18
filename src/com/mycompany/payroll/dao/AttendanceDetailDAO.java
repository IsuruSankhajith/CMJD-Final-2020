/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.payroll.dao;

import com.mycompany.payroll.controller.EmployeeController;
import com.mycompany.payroll.db.DBConnection;
import com.mycompany.payroll.model.Attendance;
import com.mycompany.payroll.model.Employee;
import com.mycompany.payroll.model.Shift;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Isuru Sankajith
 */
public class AttendanceDetailDAO {

    public List<Attendance> findAllAttendance() throws ClassNotFoundException, SQLException {

        List<Attendance> attendances = new ArrayList<>();
        Connection con = DBConnection.getInstance().getConnection();
        String sql = "select a.*,  concat(e.first_name, ' ', e.last_name) as employeeName from tb_attendance a inner join tb_employee e on e.employee_id = a.employee_id";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);
        while (rs.next()) {
            Attendance e = new Attendance();
            
            e.setAttendance_id(rs.getInt("attendance_id"));
            e.setIn_time(rs.getTimestamp("in_time"));
            e.setOut_time(rs.getTimestamp("out_time"));
            e.setEmployee_id(rs.getInt("employee_id"));
            e.setFullName(rs.getString("employeeName"));
            //e.setAttendance_date(rs.getDate("attendance_date"));
            attendances.add(e);

        }
        return attendances;
    }
    public List<Attendance> findNotProcessAttendance(Timestamp monthStart) throws ClassNotFoundException, SQLException {

        List<Attendance> attendances = new ArrayList<>();
        Connection con = DBConnection.getInstance().getConnection();
        String sql = "select a.*, s.shift_name, s.start_time, s.end_time from tb_attendance a LEFT JOIN tb_shift s ON a.shift_id=s.shift_id WHERE out_time IS NOT NULL\n"
                + "and out_time between ? and current_timestamp()";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setTimestamp(1, monthStart);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Attendance e = new Attendance();
            e.setAttendance_id(rs.getInt("attendance_id"));
            e.setIn_time(rs.getTimestamp("in_time"));
            e.setOut_time(rs.getTimestamp("out_time"));
            e.setEmployee_id(rs.getInt("employee_id"));

            Shift shift = new Shift();
            shift.setShift_id(rs.getInt("shift_id"));
            shift.setShift_name(rs.getString("shift_name"));
            shift.setStart_time(rs.getTimestamp("start_time"));
            shift.setEnd_time(rs.getTimestamp("end_time"));
            e.setShift(shift);
            attendances.add(e);

        }
        return attendances;
    }

    public List<Attendance> findAllAttendanceByEmployeeId(int employeeId, Timestamp monthStart) throws ClassNotFoundException, SQLException {

        List<Attendance> attendances = new ArrayList<>();
        Connection con = DBConnection.getInstance().getConnection();
        String sql = "select a.*, s.shift_name, s.start_time, s.end_time from tb_attendance a LEFT JOIN tb_shift s ON a.shift_id=s.shift_id WHERE employee_id=? and out_time IS NOT NULL\n"
                + "and out_time between ? and current_timestamp()";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, employeeId);
        ps.setTimestamp(2, monthStart);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Attendance e = new Attendance();
            e.setAttendance_id(rs.getInt("attendance_id"));
            e.setIn_time(rs.getTimestamp("in_time"));
            e.setOut_time(rs.getTimestamp("out_time"));
            e.setEmployee_id(rs.getInt("employee_id"));

            Shift shift = new Shift();
            shift.setShift_id(rs.getInt("shift_id"));
            shift.setShift_name(rs.getString("shift_name"));
            shift.setStart_time(rs.getTimestamp("start_time"));
            shift.setEnd_time(rs.getTimestamp("end_time"));
            e.setShift(shift);
            attendances.add(e);

        }
        return attendances;
    }
    
    public boolean InsertAttendanceDetails(Attendance obj) throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
                
        String sql = "insert into tb_attendance(in_time,out_time,employee_id, shift_id, is_processed) values(?,?,?,?,?)";
        
        Employee empData = new Employee();
        empData.setEmployeeId(obj.getEmployee_id());
        List<Employee> lstEmployees = new EmployeeController().findEmployeeDetailsForId(empData);
        for (Employee lstEmployee : lstEmployees) {
            empData.setShiftId(lstEmployee.getShiftId());
        }
        
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setTimestamp(1, obj.getIn_time());
        preparedStatement.setTimestamp(2, obj.getOut_time());
        preparedStatement.setInt(3, obj.getEmployee_id());
        preparedStatement.setInt(4, empData.getShiftId());
        preparedStatement.setInt(5, 0);
        
        boolean isSuccess = false;
        int result = preparedStatement.executeUpdate();
        if (result == 1) {
            isSuccess = true;
        }
        return isSuccess;
    }

}

