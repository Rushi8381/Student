package com.tester;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestMysqlDB {

	public static void main(String[] args) {
		// TODO Auto-generated method stubs

		try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "rootroot");) {
			System.out.println("DB Application");
			System.out.println("Connected to Oracle....");
			// Step2:

			String sql = "select * from student ";// string---java application
			
			Statement stmt = con.createStatement();

			// step 4:fire query
			// select:as reads data from db use method:

			ResultSet rset = stmt.executeQuery(sql);
			// step5:get the result ,display result
			while (rset.next()) {
				System.out.println(rset.getInt("s_id") + "     " + rset.getString("Fullname") 	);
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