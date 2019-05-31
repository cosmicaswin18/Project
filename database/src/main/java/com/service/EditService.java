package com.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.action.EditAction;

public class EditService {

	public static int edit(EditAction ea) {
		int flag = 0;
		Connection con = DBManager.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("update product set pid=?,pname=?,pqty=?,pprice=? where pid=?");
			ps.setInt(1, ea.getPid());
			ps.setString(2, ea.getName());
			ps.setInt(3, ea.getPqty());
			ps.setFloat(4, ea.getPprice());
			ps.setInt(5, ea.getPid());
			flag = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			flag = 0;
		}
		return flag;

	}

}
