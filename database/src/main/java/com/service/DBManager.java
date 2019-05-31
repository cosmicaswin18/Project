package com.service;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBManager {
	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/user", "root", "");
		} catch (Exception e) {
			System.out.println(e);
		}
		return con;
	}

}
