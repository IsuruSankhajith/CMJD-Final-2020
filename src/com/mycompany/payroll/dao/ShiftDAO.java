/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.payroll.dao;

import com.mycompany.payroll.db.DBConnection;
import com.mycompany.payroll.model.Shift;
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
public class ShiftDAO {
    
    public List<Shift> findAllShift()throws ClassNotFoundException, SQLException{
        
        List<Shift> shifts = new ArrayList<>();
        Connection con = DBConnection.getInstance().getConnection();
        String sql = "select*from tb_shift;";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);
        while(rs.next()){
            Shift e = new Shift();
            e.setShift_id(rs.getInt("shift_id"));
            e.setShift_name(rs.getString("shift_name"));
            e.setStart_time(rs.getTimestamp("start_time"));
            e.setEnd_time(rs.getTimestamp("end_time"));
            shifts.add(e);
        }
        return shifts;
    }
    

    public boolean InsertShiftDetails(Shift obj) throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "insert into tb_shift(shift_name,start_time,end_time)values(?,?,?)";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, obj.getShift_name());
        preparedStatement.setTimestamp(2, obj.getStart_time());
        preparedStatement.setTimestamp(3, obj.getEnd_time());

        boolean isSuccess = false;
        int result = preparedStatement.executeUpdate();
        if (result == 1) {
            isSuccess = true;
        }
        return isSuccess;
    }
    
    public boolean UpdateShiftDetails(Shift obj) throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "update tb_shift set shift_name=?,start_time=?,end_time=?where shift_id=?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, obj.getShift_name());
        preparedStatement.setTimestamp(2, obj.getStart_time());
        preparedStatement.setTimestamp(3, obj.getEnd_time());

        boolean isSuccess = false;
        int result = preparedStatement.executeUpdate();
        if (result == 1) {
            isSuccess = true;
        }
        return isSuccess; 
    }
    
    public int getShift(Shift shift) throws ClassNotFoundException, SQLException {
        List<Shift> shifts = new ArrayList<>();
        Connection con = DBConnection.getInstance().getConnection();
        String sql = "select shift_id from tb_shift where shift_name=?";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setString(1, shift.getShift_name());
        preparedStatement.executeQuery();
        ResultSet rs = preparedStatement.executeQuery();
        int shiftID =0;
        while(rs.next()){
            shiftID=rs.getInt("shift_id");
        }
            return shiftID;
    }
}
