/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.payroll;

import com.mycompany.payroll.view.LoginForm;
import java.awt.Dimension;
import java.awt.Toolkit;

/**
 *
 * @author User
 */
public class Payroll {
    
    public static void main(String[] args) {
        LoginForm loginForm = new LoginForm();
        loginForm.setLocationRelativeTo(null);
        loginForm.setResizable(false);
        loginForm.setVisible(true);
    }
}
