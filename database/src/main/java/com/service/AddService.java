package com.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.action.AddAction;

public class AddService {

	public static int add(AddAction aa) {
		int flag = 0;
		Connection con = DBManager.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("insert into product values(?,?,?,?)");
			ps.setInt(1, aa.getPid());
			ps.setString(2, aa.getName());
			ps.setInt(3, aa.getPqty());
			ps.setFloat(4, aa.getPprice());
			flag = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			flag = 0;
		}
		return flag;

	}

}
