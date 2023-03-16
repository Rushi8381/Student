package com.tester;


import java.util.Scanner;

import com.dal.StudentDal;
import com.pojo.Student;

public class TestCRUD {

	public static void main(String[] args) {
		// TODO Auto-generated method stus

		//clients
		try
		{
		StudentDal sDal=new StudentDal();
		
		System.out.println("----DAL---------");
		System.out.println("Enter s_id Fullname rollnumber email mobileno");
		
		Scanner sc=new Scanner(System.in);
		int s_id=sc.nextInt();
		String Fullname=sc.next();
		int rollnumber=sc.nextInt();
		String email=sc.next();
		int mobileno=sc.nextInt();
		
	
		Student s=new Student(s_id,Fullname,rollnumber,email,mobileno);
		
		int i=sDal.insertStudent(s);
		if(i>=0)
			System.out.println("Inserted Row:");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

}