/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.payroll.dao;

import com.mycompany.payroll.db.DBConnection;
import com.mycompany.payroll.model.EmployeeType;
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
public class EmployeeTypeDAO {

    public List<EmployeeType> findAllEmployeeType() throws ClassNotFoundException, SQLException {

        List<EmployeeType> employeeTypes = new ArrayList<>();
        Connection con = DBConnection.getInstance().getConnection();
        String sql = "select * from tb_employee_type";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);
        while (rs.next()) {
            EmployeeType e = new EmployeeType();
            e.setEmployeetypeid(rs.getInt("employee_type_id"));
            e.setTypename(rs.getString("type_name"));
            e.setLeavecount(rs.getInt("leave_count"));
            employeeTypes.add(e);

        }
        return employeeTypes;
    }

    public boolean insertEmployeeTypeDetails(EmployeeType obj) throws ClassNotFoundException, SQLException {

        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "insert into tb_employee_type(type_name,leave_count)values(?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        //preparedStatement.setInt(1,obj.getEmployeetypeid());
        preparedStatement.setString(1, obj.getTypename());
        preparedStatement.setInt(2, obj.getLeavecount());
        //return preparedStatement.executeUpdate() == 1;
        boolean isSuccess = false;
        int result = preparedStatement.executeUpdate();
        if (result == 1) {
            isSuccess = true;
        }
        return isSuccess;
    }

    public boolean updateEmployeeTypeDetails(EmployeeType obj) throws ClassNotFoundException, SQLException {

        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "UPDATE tb_employee_type SET type_name=?,leave_count=? WHERE employee_type_id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, obj.getTypename());
        preparedStatement.setInt(2, obj.getLeavecount());
        return preparedStatement.executeUpdate() == 1;

    }

    public int getEmployeeType(EmployeeType employeeType) throws ClassNotFoundException, SQLException {
        List<EmployeeType> employeeTypes = new ArrayList<>();
        Connection con = DBConnection.getInstance().getConnection();
        String sql = "select employee_type_id from tb_employee_type where type_name =?";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setString(1, employeeType.getTypename());
        preparedStatement.executeQuery();
        ResultSet rs = preparedStatement.executeQuery();
        int employeeTypeID = 0;
        while (rs.next()) {
            employeeTypeID = rs.getInt("employee_type_id");
        }
        return employeeTypeID;
    }

    public int getLeaveCountForTypeID(int typeID) throws ClassNotFoundException, SQLException {
        int leaveCount = 0;
        Connection con = DBConnection.getInstance().getConnection();
        String sql = "select * from tb_employee_type where employee_type_id = ?";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setInt(1, typeID);
        preparedStatement.executeQuery();
        ResultSet rs = preparedStatement.executeQuery();
        int employeeTypeID = 0;
        while (rs.next()) {
            employeeTypeID = rs.getInt("leave_count");
        }
        return employeeTypeID;
    }

}
