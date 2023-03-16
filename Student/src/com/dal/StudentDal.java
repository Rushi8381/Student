package com.dal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.pojo.Student;
import com.util.DBUtil;

public class StudentDal {

	private static Connection con;
	static {
		System.out.println("----static block get invoked------");
		// establish connection
		con = DBUtil.getDbConnection();

	}

	public StudentDal() {
		System.out.println("------constr of StudentDAL----");
	}
	// methods for CRUD operations in StudentDAL class

	// add new student
	public int insertStudent(Student obj) throws SQLException {
		// JDBC
		PreparedStatement pstmt = con.prepareStatement("insert into student values(?,?,?,?,?)");

		pstmt.setInt(1, obj.getS_id());
		pstmt.setString(2, obj.getFullname());
		pstmt.setInt(3, obj.getRollnumber());
		pstmt.setString(4, obj.getEmail());
		pstmt.setInt(5, obj.getMobileno());

		int i = pstmt.executeUpdate();

		return i;
	}

	// update
	public int updateStudent(Student obj) throws SQLException {
		PreparedStatement pstmt = con.prepareStatement("update student set Fullname=?,mobileno=?,email=?,rollnumber=?, where  s_id=?");

		pstmt.setInt(1, obj.getS_id());
		pstmt.setString(2, obj.getFullname());
		pstmt.setInt(3, obj.getRollnumber());
		pstmt.setString(4, obj.getEmail());
		pstmt.setInt(5, obj.getMobileno());

		int i = pstmt.executeUpdate();

		return i;
	}

	// delete
	public int deleteStudent(int s_id) throws SQLException {
		// JDBC
		PreparedStatement pstmt = con.prepareStatement("delete student where  s_id=?");

		pstmt.setInt(1, s_id);

		int i = pstmt.executeUpdate();

		return i;
	}


	public ArrayList<Student> getAllStudent() throws SQLException {

		ArrayList<Student> sList1 = new ArrayList<>();

		Statement stmt = con.createStatement();

		ResultSet rset = stmt.executeQuery("select * from student");

		while (rset.next()) {
			

		Student s = new Student(rset.getInt("s_id"), rset.getString("fullname"),rset.getInt("rollnumber"), rset.getString("email"),rset.getInt("mobileno") 
					);
			sList1.add(s);

		}
		return sList1;

	}

	public ArrayList<Student> getAllStudent1() {
		// TODO Auto-generated method stub
		return null;
	}

	public Student getStudentById(int editId) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean studentExists(int editId) {
		// TODO Auto-generated method stub
		return false;
	}
}
