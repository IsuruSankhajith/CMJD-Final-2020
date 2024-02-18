/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.payroll.model;

/**
 *
 * @author Isuru Sankajith
 */
public class EmployeeType {

  
    private Integer employeetypeid;
    private String typename;
    private Integer leavecount;

    public Integer getEmployeetypeid() {
        return employeetypeid;
    }

    public void setEmployeetypeid(Integer employeetypeid) {
        this.employeetypeid = employeetypeid;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }

    public Integer getLeavecount() {
        return leavecount;
    }

    public void setLeavecount(Integer leavecount) {
        this.leavecount = leavecount;
    }
    
    
    
}
