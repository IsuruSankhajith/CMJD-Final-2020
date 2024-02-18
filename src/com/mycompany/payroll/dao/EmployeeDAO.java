/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.payroll.dao;

import com.mycompany.payroll.controller.EmployeeTypeController;
import com.mycompany.payroll.db.DBConnection;
import com.mycompany.payroll.model.Employee;
import com.mycompany.payroll.model.EmployeeCategory;
import com.mycompany.payroll.model.EmployeeType;
import com.mycompany.payroll.model.Shift;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

/**
 *
 * @author Isuru Sankajith
 */
public class EmployeeDAO {

    public List<Employee> findAllEmployee() throws ClassNotFoundException, SQLException {

        List<Employee> employees = new ArrayList<>();
        Connection con = DBConnection.getInstance().getConnection();
        String sql = "SELECT * FROM tb_employee";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);
        while (rs.next()) {
            Employee e = new Employee();
            e.setEmployeeId(rs.getInt("employee_id"));
            e.setFirstName(rs.getString("first_name"));
            e.setLastName(rs.getString("last_name"));
            e.setContact(rs.getString("contact_no"));
            e.setNic(rs.getString("nic"));
            e.setAddress(rs.getString("address"));
            employees.add(e);
        }
        return employees;
    }

    public Employee findEmployeeById(int employeeId) throws ClassNotFoundException, SQLException {

        Employee e = new Employee();
        Connection con = DBConnection.getInstance().getConnection();
        String sql = "SELECT * FROM tb_employee WHERE employee_id=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, employeeId);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            e.setEmployeeId(rs.getInt("employee_id"));
            e.setFirstName(rs.getString("first_name"));
            e.setLastName(rs.getString("last_name"));
            e.setContact(rs.getString("contact_no"));
            e.setNic(rs.getString("nic"));
            e.setAddress(rs.getString("address"));
            e.setBasicSalary(rs.getDouble("basic_salary"));
        }
        return e;
    }

    public List<Employee> findEmployeeDetailsForId(Employee employee) throws ClassNotFoundException, SQLException {

        List<Employee> employees = new ArrayList<>();
        Connection con = DBConnection.getInstance().getConnection();
        String sql = "SELECT e.employee_id, e.first_name, e.last_name, e.contact_no, e.nic, e.address, e.is_active, et.employee_type_id, et.type_name,\n"
                + "ec.employee_category_id, ec.category_name, e.basic_salary, s.shift_id, s.shift_name FROM tb_employee e\n"
                + "inner join tb_employee_category ec on ec.employee_category_id=e.employee_category\n"
                + "inner join tb_employee_type et on et.employee_type_id=e.employee_type\n"
                + "inner join tb_shift s on e.shift_id=s.shift_id where e.employee_id = ?;";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setInt(1, employee.getEmployeeId());
        preparedStatement.executeQuery();
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()) {
            Employee e = new Employee();
            e.setEmployeeId(rs.getInt("employee_id"));
            e.setFirstName(rs.getString("first_name"));
            e.setLastName(rs.getString("last_name"));
            e.setContact(rs.getString("contact_no"));
            e.setNic(rs.getString("nic"));
            e.setAddress(rs.getString("address"));
            e.setIsActive(rs.getInt("is_active"));
            e.setEmployeeType(rs.getInt("employee_type_id"));
            e.setEmployeeCategory(rs.getInt("employee_category_id"));
            e.setBasicSalary(rs.getDouble("basic_salary"));
            e.setShiftId(rs.getInt("shift_id"));
            e.setEmployeeCategoryName(rs.getString("category_name"));
            e.setEmployeeTypeName(rs.getString("type_name"));
            e.setShiftName(rs.getString("shift_name"));

            employees.add(e);
        }
        return employees;
    }

    public List<Employee> findAllEmployeeWithCategoryAndType() throws ClassNotFoundException, SQLException {

        List<Employee> employees = new ArrayList<>();
        Connection con = DBConnection.getInstance().getConnection();
        String sql = "SELECT * FROM db_payroll.tb_employee e INNER JOIN tb_employee_category ec ON e.employee_category= ec.employee_category_id \n"
                + "INNER JOIN tb_employee_type et ON e.employee_type=et.employee_type_id\n"
                + "INNER JOIN tb_shift s ON s.shift_id = e.shift_id";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);
        while (rs.next()) {
            Employee e = new Employee();
            e.setEmployeeId(rs.getInt("employee_id"));
            e.setFirstName(rs.getString("first_name"));
            e.setLastName(rs.getString("last_name"));
            e.setContact(rs.getString("contact_no"));
            e.setNic(rs.getString("nic"));
            e.setAddress(rs.getString("address"));
            e.setBasicSalary(rs.getDouble("basic_salary"));
            e.setRemainingLeave(rs.getInt("remaining_leave"));

            EmployeeType employeeType = new EmployeeType();
            employeeType.setEmployeetypeid(rs.getInt("employee_type"));
            employeeType.setTypename(rs.getString("type_name"));
            employeeType.setLeavecount(rs.getInt("leave_count"));
            e.setEmployeeTypeObj(employeeType);

            EmployeeCategory employeeCategory = new EmployeeCategory();
            employeeCategory.setEmployee_category_id(rs.getInt("employee_category"));
            employeeCategory.setCategory_name(rs.getString("category_name"));
            employeeCategory.setIs_ot_allowed(rs.getInt("is_ot_allowed"));
            e.setEmployeeCategoryObj(employeeCategory);

            Shift shift = new Shift();
            shift.setShift_id(rs.getInt("shift_id"));
            shift.setShift_name(rs.getString("shift_name"));
            e.setShiftObj(shift);
            
            employees.add(e);
        }
        return employees;
    }

    public boolean InsertEmployeeDetails(Employee obj) throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        int leaveCount = 0;
        String sql = "Insert into tb_employee(first_name,last_name,contact_no,nic,address,"
                + "is_active,employee_type,employee_category,shift_id, basic_salary, remaining_leave) values(?,?,?,?,?,?,?,?,?,?)";

        leaveCount = new EmployeeTypeController().getLeaveCountForTypeID(obj.getEmployeeType());
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        //preparedStatement.setInt(1,obj.getEmployeeId());
        preparedStatement.setString(1, obj.getFirstName());
        preparedStatement.setString(2, obj.getLastName());
        preparedStatement.setString(3, obj.getContact());
        preparedStatement.setString(4, obj.getNic());
        preparedStatement.setString(5, obj.getAddress());
        preparedStatement.setInt(6, 1);
        preparedStatement.setInt(7, obj.getEmployeeType());
        preparedStatement.setInt(8, obj.getEmployeeCategory());
        preparedStatement.setInt(9, obj.getShiftId());
        preparedStatement.setDouble(10, obj.getBasicSalary());
        preparedStatement.setInt(11, leaveCount);
        
        boolean isSuccess = false;
        int result = preparedStatement.executeUpdate();
        if (result == 1) {
            isSuccess = true;
        }
        return isSuccess;
    }

    
    public boolean updateEmployeeDetails(Employee obj) throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "update tb_employee set first_name =?,last_name=?,contact_no=?,nic=?,address=?,is_active=?,create_date_time=?,employee_type=?,employee_category=? where employee_id=?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        //preparedStatement.setInt(1,obj.getEmployeeId());
        preparedStatement.setString(1, obj.getFirstName());
        preparedStatement.setString(2, obj.getLastName());
        preparedStatement.setString(3, obj.getContact());
        preparedStatement.setString(4, obj.getNic());
        preparedStatement.setString(5, obj.getAddress());
        preparedStatement.setInt(6, obj.getIsActive());

        boolean isSuccess = false;
        int result = preparedStatement.executeUpdate();
        if (result == 1) {
            isSuccess = true;
        }
        return isSuccess;
    }

    public void updateRemainingLeave(int employeeID, int leaveTypeID) throws SQLException, ClassNotFoundException{
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "";
        switch (leaveTypeID) {
            case 1:
                sql = "update tb_employee set remaining_leave = remaining_leave - 1 where employee_id = ?";
                break;
            case 2:
                sql = "update tb_employee set remaining_leave = remaining_leave - 0.5 where employee_id = ?";
                break;
            default:
                sql = "update tb_employee set remaining_leave = remaining_leave - 0 where employee_id = ?";
                break;
        }

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        //preparedStatement.setInt(1,obj.getEmployeeId());
        preparedStatement.setInt(1, employeeID);

        boolean isSuccess = false;
        int result = preparedStatement.executeUpdate();
        if (result == 1) {
            isSuccess = true;
        }
    }
    
}
