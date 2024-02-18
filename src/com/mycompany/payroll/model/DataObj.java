/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.payroll.model;

/**
 *
 * @author User
 */
public class DataObj {
    
    private String col1;
    private String col2;

    public DataObj() {
    }

    public DataObj(String col1, String col2) {
        this.col1 = col1;
        this.col2 = col2;
    }

    public String getCol1() {
        return col1;
    }

    public void setCol1(String col1) {
        this.col1 = col1;
    }

    public String getCol2() {
        return col2;
    }

    public void setCol2(String col2) {
        this.col2 = col2;
    }
    
}
