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
		Properties properties = new Properties();
		try {
			properties.load(DatabaseConnect.class.getResourceAsStream("/dbconfig.properties"));
			final String driver = properties.getProperty("driver");
			final String server = properties.getProperty("server");
			final String user = properties.getProperty("user");
			final String pass = properties.getProperty("pass");
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
