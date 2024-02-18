/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.payroll.dao;

import com.mycompany.payroll.db.DBConnection;
import com.mycompany.payroll.model.Setting;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author User
 */
public class SettingsDAO {
    
    public Setting finSettingById(String key) throws ClassNotFoundException, SQLException {

        Setting s = new Setting();
        Connection con = DBConnection.getInstance().getConnection();
        String sql = "SELECT * FROM tb_settings WHERE key_=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, key);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            s.setSettingId(rs.getInt("settings_id"));
            s.setKey(rs.getString("key_"));
            s.setValue(rs.getString("value_"));
        }
        return s;
    }
    
}
