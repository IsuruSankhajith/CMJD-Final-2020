/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.payroll.model;

import java.util.List;

/**
 *
 * @author Isuru Sankajith
 */
public class EmployeeCategory {
    private Integer employee_category_id;
    private String category_name;
    private Integer is_ot_allowed;

    public Integer getEmployee_category_id() {
        return employee_category_id;
    }

    public void setEmployee_category_id(Integer employee_category_id) {
        this.employee_category_id = employee_category_id;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public Integer getIs_ot_allowed() {
        return is_ot_allowed;
    }

    public void setIs_ot_allowed(Integer is_ot_allowed) {
        this.is_ot_allowed = is_ot_allowed;
    }

 

   
}
