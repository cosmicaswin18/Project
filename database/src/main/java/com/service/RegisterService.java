package com.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.regex.Pattern;

import org.mindrot.jbcrypt.BCrypt;

import com.action.RegisterAction;
//import com.action.RegisterAction;
//import com.model.RegisterModel;


public class RegisterService {

	public static int register(RegisterAction registerAction) {
		int flag = 0, id;
		String email = registerAction.getEmail();
		String password = registerAction.getPassword();
		Connection con = DBManager.getConnection();
		if (!em(email)) {
			flag = 0;
		} else if (password.length() < 8) {
			flag = 0;
		} else {
			try {
				String pass = BCrypt.hashpw(password, BCrypt.gensalt());
				PreparedStatement ps = con.prepareStatement("insert into register values(default,?,?,?,?,?)");
				ps.setString(1, registerAction.getName());
				ps.setString(2, registerAction.getEmail());
				ps.setString(3, registerAction.getCity());
				ps.setString(4, registerAction.getUserName());
				ps.setString(5, pass);
				flag = ps.executeUpdate();

				PreparedStatement ps1 = con.prepareStatement("insert into login values(?,?,?)");
				ps1.setString(1, registerAction.getUserName());
				ps1.setString(2, pass);
				ps1.setString(3, registerAction.getName());
				ps1.executeUpdate();

				PreparedStatement ps2 = con.prepareStatement("select * from register where uname=?");
				ps2.setString(1, registerAction.getUserName());
				ResultSet rs = ps2.executeQuery();
				while (rs.next()) {
					id = rs.getInt("id");
					registerAction.setId(id);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return flag;
	}

	public static boolean em(String email) {
		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-z"
				+ "A-Z]{2,7}$";

		Pattern pat = Pattern.compile(emailRegex);
		if (email == null)
			return false;
		return pat.matcher(email).matches();
	}

}
