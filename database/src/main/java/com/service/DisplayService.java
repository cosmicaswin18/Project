package com.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.action.DisplayAction;
//import com.action.List;

public class DisplayService {

	public static ResultSet display(DisplayAction da) {

		Connection con = DBManager.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("select * from product");
			//ps.setInt(1, da.getPid());
			ResultSet rs = ps.executeQuery();

			return rs;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

}
