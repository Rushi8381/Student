package com.tester;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestDB {

	public static void main(String[] args) {

		try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "rootroot");) {
			System.out.println("DB Application");
			System.out.println("Connected to MySql....");

			// Step2:write sql query
			// display all employees

			String sql = "select * from student ";// string---java application
													// SQL--->db side

			// step 3:associate SQL with connection

			// cerate statement obj
			Statement stmt = con.createStatement();

			// step 4:fire query
			// select:as reads data from db use method:

			ResultSet rset = stmt.executeQuery(sql);
			// step5:get the result ,display result
			while (rset.next()) { 
				System.out.println(rset.getInt(1) + "     " +rset.getInt("s_id")+"    " +rset.getString("Fullname") + "     "
						+ rset.getInt("rollnumber") + rset.getString("email")+ "    " +rset.getInt("mobileno"));
			}
			rset.close();
			System.out.println("----end -----");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			// System.out.println(e.getMessage());
		}
	}

}