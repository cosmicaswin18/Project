package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.model.BookModel;
import com.model.IssueBookModel;


public class BookDao {

	public static int save(BookModel model) {
		int status = 0;
		try {
			Connection con = DB.getConnection();
			PreparedStatement ps = con.prepareStatement("insert into ebook values(?,?,?,?,?,?)");
			ps.setString(1, model.getCallno());
			ps.setString(2, model.getName());
			ps.setString(3, model.getAuthor());
			ps.setString(4, model.getPublisher());
			ps.setInt(5, model.getQuantity());
			ps.setInt(6, 0);
			status = ps.executeUpdate();
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}

		return status;
	}

	public static List<BookModel> view() {
		List<BookModel> list = new ArrayList<BookModel>();
		try {
			Connection con = DB.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from ebook");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				BookModel model = new BookModel();
				model.setCallno(rs.getString("callno"));
				model.setName(rs.getString("name"));
				model.setAuthor(rs.getString("author"));
				model.setPublisher(rs.getString("publisher"));
				model.setQuantity(rs.getInt("quantity"));
				model.setIssued(rs.getInt("issued"));

				list.add(model);
			}
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}

		return list;
	}

	public static int delete(String callno) {
		int status = 0;
		try {
			Connection con = DB.getConnection();
			PreparedStatement ps = con.prepareStatement("delete from ebook where callno=?");
			ps.setString(1, callno);
			status = ps.executeUpdate();
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}

		return status;
	}
	
	public static int deleteissue(String callno) {
		int status = 0;
		try {
			Connection con = DB.getConnection();
			PreparedStatement ps = con.prepareStatement("delete from eissuebook where callno=? and returnstatus='yes'");
			ps.setString(1, callno);
			status = ps.executeUpdate();
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}

		return status;
	}

	public static int getIssued(String callno) {
		int issued = 0;
		try {
			Connection con = DB.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from ebook where callno=?");
			ps.setString(1, callno);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				issued = rs.getInt("issued");
			}
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}

		return issued;
	}

	public static boolean checkIssue(String callno) {
		boolean status = false;
		try {
			Connection con = DB.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from ebook where callno=? and quantity>issued");
			ps.setString(1, callno);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				status = true;
			}
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}

		return status;
	}

	public static int issueBook(IssueBookModel model) {
		String callno = model.getCallno();
		boolean checkstatus = checkIssue(callno);
		System.out.println("Check status: " + checkstatus);
		if (checkstatus) {
			int status = 0;
			try {
				Connection con = DB.getConnection();
				PreparedStatement ps = con.prepareStatement("insert into eissuebook values(?,?,?,?,?,?)");
				ps.setString(1, model.getCallno());
				ps.setString(2, model.getStudentid());
				ps.setString(3, model.getStudentname());
				ps.setLong(4, model.getStudentmobile());
				java.sql.Date currentDate = new java.sql.Date(System.currentTimeMillis());
				ps.setDate(5, currentDate);
				ps.setString(6, "no");

				status = ps.executeUpdate();
				if (status > 0) {
					PreparedStatement ps2 = con.prepareStatement("update ebook set issued=? where callno=?");
					ps2.setInt(1, getIssued(callno) + 1);
					ps2.setString(2, callno);
					status = ps2.executeUpdate();
				}
				con.close();

			} catch (Exception e) {
				System.out.println(e);
			}

			return status;
		} else {
			return 0;
		}
	}

	public static int returnBook(String callno, String studentid) {
		int status = 0;
		try {
			Connection con = DB.getConnection();
			PreparedStatement ps = con
					.prepareStatement("update eissuebook set returnstatus='yes' where callno=? and studentid=?");
			ps.setString(1, callno);
			ps.setString(2, studentid);

			status = ps.executeUpdate();
			if (status > 0) {
				PreparedStatement ps2 = con.prepareStatement("update ebook set issued=? where callno=? and issued>0");
				ps2.setInt(1, getIssued(callno) - 1);
				ps2.setString(2, callno);
				status = ps2.executeUpdate();
			}
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}

		return status;
	}

	public static List<IssueBookModel> viewIssuedBooks() {
		List<IssueBookModel> list = new ArrayList<IssueBookModel>();
		try {
			Connection con = DB.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from eissuebook order by issuedate desc");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				IssueBookModel model = new IssueBookModel();
				model.setCallno(rs.getString("callno"));
				model.setStudentid(rs.getString("studentid"));
				model.setStudentname(rs.getString("studentname"));
				model.setStudentmobile(rs.getLong("studentmobile"));
				model.setIssueddate(rs.getDate("issuedate"));
				model.setReturnstatus(rs.getString("returnstatus"));
				list.add(model);
			}
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}

		return list;
	}
	
	public static BookModel viewByCallno(String callno) {
		BookModel model = new BookModel();
		try {
			Connection con = DB.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from ebook where callno=?");
			ps.setString(1, callno);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				model.setCallno(rs.getString(1));
				model.setName(rs.getString(2));
				model.setAuthor(rs.getString(3));
				model.setPublisher(rs.getString(4));
				model.setQuantity(rs.getInt(5));
				model.setIssued(rs.getInt(6));
			}
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}

		return model;
	}
	
}
