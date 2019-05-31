package com.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.mindrot.jbcrypt.BCrypt;

import com.action.LoginAction;

public class LoginService {

	public static int login(LoginAction la) {
		int flag = 0;
		Connection con = DBManager.getConnection();
		String user = la.getUser();
		// String password = la.getPassword();
		String name;
		String pass;
		try {

			String sql = "SELECT * FROM login WHERE";
			sql += " uname = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, user);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				name = rs.getString("name");
				la.setName(name);
				pass = rs.getString("password");
				if (BCrypt.checkpw(la.getPassword(), pass)) {
					flag = 1;
				} else {
					flag = 0;
				}

			}
		} catch (Exception e) {
			flag = 0;
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
				}
			}
		}
		return flag;

	}

}
