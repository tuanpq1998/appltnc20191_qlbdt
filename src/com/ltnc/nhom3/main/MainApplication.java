/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ltnc.nhom3.main;

import com.ltnc.nhom3.connect.DatabaseConnect;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author admin
 */
public class MainApplication {
    public static void main(String[] args) {
        try {
            System.out.println(">>>"+DatabaseConnect.getInstance().getConnection());
        } catch (SQLException ex) {
            Logger.getLogger(MainApplication.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
