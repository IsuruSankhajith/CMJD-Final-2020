/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.payroll.dao;

import com.mycompany.payroll.db.DBConnection;
import com.mycompany.payroll.model.Holiday;
import java.sql.Array;
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
public class HolidayDAO {

    public List<Holiday> findAllHoliday() throws ClassNotFoundException, SQLException {
        List<Holiday> holidays = new ArrayList<>();
        Connection con = DBConnection.getInstance().getConnection();
        String sql = "select * from tb_holiday";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);
        while (rs.next()) {
            Holiday e = new Holiday();
            e.setHoliday_id(rs.getInt("holiday_id"));
            e.setHours(rs.getDouble("hours"));
            e.setDate(rs.getDate("date"));
            e.setReason(rs.getString("reason"));
            holidays.add(e);
        }
        return holidays;
    }

    public boolean InsertHolidayDetails(Holiday obj) throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "insert into tb_holiday(hours,date,reason)values(?,?,?)";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setDouble(1, obj.getHours());
        preparedStatement.setDate(2, obj.getDate());
        preparedStatement.setString(3, obj.getReason());

        boolean isSuccess = false;
        int result = preparedStatement.executeUpdate();
        if (result == 1) {
            isSuccess = true;
        }
        return isSuccess;

    }

    public boolean updateHolidayDetails(Holiday obj) throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "update tb_holiday set hours = ?,date=?,reason=?where holiday_id=?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setDouble(1, obj.getHours());
        preparedStatement.setDate(2, obj.getDate());
        preparedStatement.setString(3, obj.getReason());

        boolean isSuccess = false;
        int result = preparedStatement.executeUpdate();
        if (result == 1) {
            isSuccess = true;
        }
        return isSuccess;
    }

}
