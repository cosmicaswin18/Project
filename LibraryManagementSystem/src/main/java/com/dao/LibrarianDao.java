package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.model.LibrarianModel;

public class LibrarianDao {
	
	public static int save(LibrarianModel model){
		int status=0;
		try{
			Connection con=DB.getConnection();
			PreparedStatement ps=con.prepareStatement("insert into elibrarian(name,email,password,mobile) values(?,?,?,?)");
			ps.setString(1,model.getName());
			ps.setString(2,model.getEmail());
			ps.setString(3,model.getPassword());
			ps.setLong(4,model.getMobile());
			status=ps.executeUpdate();
			con.close();
			
		}catch(Exception e){System.out.println(e);}
		
		return status;
	}
	public static int update(LibrarianModel model){
		int status=0;
		try{
			Connection con=DB.getConnection();
			PreparedStatement ps=con.prepareStatement("update elibrarian set name=?,email=?,password=?,mobile=? where id=?");
			ps.setString(1,model.getName());
			ps.setString(2,model.getEmail());
			ps.setString(3,model.getPassword());
			ps.setLong(4,model.getMobile());
			ps.setInt(5,model.getId());
			status=ps.executeUpdate();
			con.close();
			
		}catch(Exception e){System.out.println(e);}
		
		return status;
	}
	public static List<LibrarianModel> view(){
		List<LibrarianModel> list=new ArrayList<LibrarianModel>();
		try{
			Connection con=DB.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from elibrarian");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				LibrarianModel model=new LibrarianModel();
				model.setId(rs.getInt("id"));
				model.setName(rs.getString("name"));
				model.setEmail(rs.getString("email"));
				model.setPassword(rs.getString("password"));
				model.setMobile(rs.getLong("mobile"));
				list.add(model);
			}
			con.close();
			
		}catch(Exception e){System.out.println(e);}
		
		return list;
	}
	public static LibrarianModel viewById(int id){
		LibrarianModel model=new LibrarianModel();
		try{
			Connection con=DB.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from elibrarian where id=?");
			ps.setInt(1,id);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				model.setId(rs.getInt(1));
				model.setName(rs.getString(2));
				model.setPassword(rs.getString(3));
				model.setEmail(rs.getString(4));
				model.setMobile(rs.getLong(5));
			}
			con.close();
			
		}catch(Exception e){System.out.println(e);}
		
		return model;
	}
	public static int delete(int id){
		int status=0;
		try{
			Connection con=DB.getConnection();
			PreparedStatement ps=con.prepareStatement("delete from elibrarian where id=?");
			ps.setInt(1,id);
			status=ps.executeUpdate();
			con.close();
			
		}catch(Exception e){System.out.println(e);}
		
		return status;
	}

	public static boolean authenticate(String email,String password){
		boolean status=false;
		try{
			Connection con=DB.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from elibrarian where email=? and password=?");
			ps.setString(1,email);
			ps.setString(2,password);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				status=true;
			}
			con.close();
			
		}catch(Exception e){System.out.println(e);}
		
		return status;
	}

}
