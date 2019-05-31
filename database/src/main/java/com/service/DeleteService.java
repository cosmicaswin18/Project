package com.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.action.DeleteAction;

public class DeleteService {
	
	public static int delete(DeleteAction da) {
		int flag = 0;
		Connection con  = DBManager.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("delete from product where pid=?");
			ps.setInt(1, da.getPid());
			flag = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			flag = 0;
		}
		return flag;

		
	}

}
