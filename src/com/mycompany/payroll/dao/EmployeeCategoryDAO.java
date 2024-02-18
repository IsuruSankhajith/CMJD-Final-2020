/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.payroll.dao;

import com.mycompany.payroll.db.DBConnection;
import com.mycompany.payroll.model.EmployeeCategory;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTextField;

/**
 *
 * @author Isuru Sankajith
 */
public class EmployeeCategoryDAO {

    public List<EmployeeCategory> findAllEmployeeCategory() throws ClassNotFoundException, SQLException {

        List<EmployeeCategory> employeeCategorys = new ArrayList<>();
        Connection con = DBConnection.getInstance().getConnection();
        String sql = "select * from tb_employee_category;";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);
        while (rs.next()) {
            EmployeeCategory e = new EmployeeCategory();
            e.setEmployee_category_id(rs.getInt("employee_category_id"));
            e.setCategory_name(rs.getString("Category_name"));
            e.setIs_ot_allowed(rs.getInt("Is_ot_allowed"));
            employeeCategorys.add(e);
        }
        return employeeCategorys;
    }

    public boolean InsertEmployeeCategoryDetails(EmployeeCategory obj) throws ClassNotFoundException, SQLException {

        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "INSERT into tb_employee_category(category_name,is_ot_allowed)values(?,?) ";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, obj.getCategory_name());
        preparedStatement.setInt(2, obj.getIs_ot_allowed());

        boolean isSuccess = false;
        int result = preparedStatement.executeUpdate();
        if (result == 1) {
            isSuccess = true;
        }
        return isSuccess;
    }

    public boolean updateEmployeeCategoryDetails(EmployeeCategory obj) throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "update tb_employee_category set category_name =?,is_ot_allowed =? where employee_category_id = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, obj.getCategory_name());
        preparedStatement.setInt(2, obj.getIs_ot_allowed());

        boolean isSuccess = false;
        int result = preparedStatement.executeUpdate();
        if (result == 1) {
            isSuccess = true;
        }
        return isSuccess;
    }

    
    public int getEmployeeCategory(EmployeeCategory employeeCategory) throws ClassNotFoundException, SQLException {
        List<EmployeeCategory> employeeCategorys = new ArrayList<>();
        Connection con = DBConnection.getInstance().getConnection();
        String sql = "select employee_category_id from tb_employee_category where category_name =?";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setString(1, employeeCategory.getCategory_name());
        preparedStatement.executeQuery();
        //Statement st = con.createStatement();
        ResultSet rs = preparedStatement.executeQuery();
        int employeeID = 0;
        while (rs.next()) {
           employeeID = rs.getInt("employee_category_id");
        }
        return employeeID;
    }
    

}
