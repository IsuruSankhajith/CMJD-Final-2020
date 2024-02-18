/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.payroll.model;

import java.sql.Date;

/**
 *
 * @author Isuru Sankajith
 */
public class Employee {

    private Integer employeeId;
    private String firstName;
    private String lastName;
    private String contact;
    private String nic;
    private String address;
    private int IsActive;
    private Date createdDateTime;
    private Integer employeeType;
    private EmployeeType employeeTypeObj;
    private Integer employeeCategory;
    private EmployeeCategory employeeCategoryObj;
    private String Email;
    private int shiftId;
    private double basicSalary;
    private int remainingLeave;
    private String employeeCategoryName;
    private String employeeTypeName;
    private String shiftName;
    private Shift shiftObj; 

    public int getShiftId() {
        return shiftId;
    }

    public String getEmployeeCategoryName() {
        return employeeCategoryName;
    }

    public void setEmployeeCategoryName(String employeeCategoryName) {
        this.employeeCategoryName = employeeCategoryName;
    }

    public String getEmployeeTypeName() {
        return employeeTypeName;
    }

    public void setEmployeeTypeName(String employeeTypeName) {
        this.employeeTypeName = employeeTypeName;
    }

    public String getShiftName() {
        return shiftName;
    }

    public void setShiftName(String shiftName) {
        this.shiftName = shiftName;
    }

    public void setShiftId(int shiftId) {
        this.shiftId = shiftId;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getIsActive() {
        return IsActive;
    }

    public void setIsActive(int isActive) {
        this.IsActive = IsActive;
    }

    public Date getCreatedDateTime() {
        return createdDateTime;
    }

    public void setCreatedDateTime(Date createdDateTime) {
        this.createdDateTime = createdDateTime;
    }

    public Integer getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(Integer employeeType) {
        this.employeeType = employeeType;
    }

    public Integer getEmployeeCategory() {
        return employeeCategory;
    }

    public void setEmployeeCategory(Integer employeeCategory) {
        this.employeeCategory = employeeCategory;
    }

    
    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    
    public EmployeeType getEmployeeTypeObj() {
        return employeeTypeObj;
    }

    public void setEmployeeTypeObj(EmployeeType employeeTypeObj) {
        this.employeeTypeObj = employeeTypeObj;
    }

    public EmployeeCategory getEmployeeCategoryObj() {
        return employeeCategoryObj;
    }

    public void setEmployeeCategoryObj(EmployeeCategory employeeCategoryObj) {
        this.employeeCategoryObj = employeeCategoryObj;
    }

    public double getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(double basicSalary) {
        this.basicSalary = basicSalary;
    }

    public int getRemainingLeave() {
        return remainingLeave;
    }

    public void setRemainingLeave(int remainingLeave) {
        this.remainingLeave = remainingLeave;
    }

    public Shift getShiftObj() {
        return shiftObj;
    }

    public void setShiftObj(Shift shiftObj) {
        this.shiftObj = shiftObj;
    }

}
