package com.dao;

import java.sql.Connection;
//import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.model.BookModel;
import com.model.IssueBookModel;
import com.model.StudentModel;


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
	
	public static int deleteissue(String callno,String studentid) {
		int status = 0;
		try {
			Connection con = DB.getConnection();
			PreparedStatement ps = con.prepareStatement("delete from eissuebook where callno=? and returnstatus='yes'");
			ps.setString(1, callno);
			status = ps.executeUpdate();
			PreparedStatement ps1 = con.prepareStatement("delete from ecount where studentid=? and count=0");
			ps1.setString(1, studentid);
			ps.executeUpdate();
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
		String studentid = model.getStudentid();
		try {
			Connection con =DB.getConnection();
			PreparedStatement ps4 = con.prepareStatement("insert into ecount values(?,?)");
			ps4.setString(1,studentid);
			ps4.setInt(2,0);
			ps4.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		
		boolean checkB = checkBook(studentid);
		System.out.println("Check status: " + checkstatus + checkB);
		if (checkstatus && checkB) {
			int status = 0;
			try {
				Connection con = DB.getConnection();
				PreparedStatement ps = con.prepareStatement("insert into eissuebook values(?,?,?,?,?,?,?)");
				ps.setString(1, model.getCallno());
				ps.setString(2, model.getStudentid());
				ps.setString(3, model.getStudentname());
				ps.setLong(4, model.getStudentmobile());
				java.sql.Date currentDate = new java.sql.Date(System.currentTimeMillis());
				ps.setDate(5, currentDate);
				ps.setString(6, "no");
				ps.setString(7, "no");

				status = ps.executeUpdate();
				if (status > 0) {
					PreparedStatement ps2 = con.prepareStatement("update ebook set issued=? where callno=?");
					ps2.setInt(1, getIssued(callno) + 1);
					ps2.setString(2, callno);
					status = ps2.executeUpdate();
					
					PreparedStatement ps3 = con.prepareStatement("update ecount set count=? where studentid=?");
					ps3.setInt(1, getCount(studentid) + 1);
					ps3.setString(2, studentid);
					status = ps3.executeUpdate();
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
				PreparedStatement ps3 = con.prepareStatement("update ecount set count=? where studentid=? and count>0");
				ps3.setInt(1, getCount(studentid) - 1);
				ps3.setString(2, studentid);
				status = ps3.executeUpdate();
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
				model.setIssueddate(rs.getString("issuedate"));
				model.setReturnstatus(rs.getString("returnstatus"));
				model.setOverdue(rs.getString("overdue"));
				list.add(model);
			}
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}

		return list;
	}
	
	public static List<IssueBookModel> viewIssuedBooksById(String callno) {
		List<IssueBookModel> list = new ArrayList<IssueBookModel>();
		try {
			Connection con = DB.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from eissuebook where callno=?");
			ps.setString(1, callno);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				IssueBookModel model = new IssueBookModel();
				model.setCallno(rs.getString("callno"));
				model.setStudentid(rs.getString("studentid"));
				model.setStudentname(rs.getString("studentname"));
				model.setStudentmobile(rs.getLong("studentmobile"));
				model.setIssueddate(rs.getString("issuedate"));
				model.setReturnstatus(rs.getString("returnstatus"));
				model.setOverdue(rs.getString("overdue"));
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
	
	public static List<StudentModel> viewStudentBooks(String studentid){
		List<StudentModel> list = new ArrayList<StudentModel>();
		try {
			Connection con = DB.getConnection();
			PreparedStatement ps = con.prepareStatement(" select * from ebook inner join eissuebook where eissuebook.studentid=? and eissuebook.callno=ebook.callno;");
			ps.setString(1, studentid);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				StudentModel model = new StudentModel();
				model.setCallno(rs.getString("ebook.callno"));
				model.setStudentid(rs.getString("eissuebook.studentid"));
				model.setName(rs.getString("ebook.name"));
				model.setReturnstatus(rs.getString("eissuebook.returnstatus"));
				list.add(model);
			}
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}

		return list;
		
	}
	
	public static int getCount(String studentid) {
		int count = 0;
		try {
			Connection con = DB.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from ecount where studentid=?");
			ps.setString(1, studentid);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				count = rs.getInt("count");
			}
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}

		return count;
	}
	
	public static boolean checkBook(String studentid) {
		boolean status = false;
		try {
			Connection con = DB.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from ecount where studentid=? and count<2");
			ps.setString(1, studentid);
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
}
