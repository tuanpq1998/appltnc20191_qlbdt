/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ltnc.nhom3.connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author admin
 */
public class DatabaseConnect {

    private static DatabaseConnect instance;
    private Connection connection;

    public DatabaseConnect() {
        try {
            final String driver = "com.mysql.jdbc.Driver";
            final String server = "jdbc:mysql://localhost/qlbdt?autoReconnect=true&useSSL=false&allowMultiQueries=true";
            final String user = "nhom03";
            final String pass = "Nhatduy1998@";
            Class.forName(driver);
            connection = DriverManager.getConnection(server, user, pass);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public static DatabaseConnect getInstance() throws SQLException {
        if (instance == null || instance.getConnection().isClosed()) {
            instance = new DatabaseConnect();
        }
        return instance;
    }

}
