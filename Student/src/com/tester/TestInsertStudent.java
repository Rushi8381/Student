package com.tester;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

import static com.util.DBUtil.getDbConnection;
public class TestInsertStudent {

	public static void main(String[] args) {
		
		
		
		try
		{
			Connection con= getDbConnection();//import static
			System.out.println("Enter s_id Fullname rollnumber email mobileno");
			Scanner sc=new Scanner(System.in);
			int s_id=sc.nextInt();
			String Fullname=sc.next();
			int rollnumber=sc.nextInt();
			String email=sc.next();
			int mobileno=sc.nextInt();
			
			String strInsert="insert into student values (?,?,?,?,?)";
			PreparedStatement pstmt=con.prepareStatement(strInsert);
			
			pstmt.setInt(1, s_id);//assign value to first parameter
			pstmt.setString(2,Fullname);//second parameter
			pstmt.setInt(3, rollnumber);//third parameter
			pstmt.setString(4, email);//forth parameter
			pstmt.setInt(5, mobileno);//fifth parameter
			//when we are using insert/upadte/delete sql
			//use executeUpdate method of statement
			
			
			int i=pstmt.executeUpdate();
			System.out.println(i+"  Row Inserted:");
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
		
	}

}
