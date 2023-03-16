package com.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {

	public static Connection getDbConnection() {
		   		try{
		   		 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "rootroot");

			System.out.println("DB Application");
			System.out.println("Connected to MySql....");
			return con;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

}
