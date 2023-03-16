package Demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestConnection {


	

		public static void main(String[] args) {
	       		// TODO Auto-generated method stub

			// Note:Add Driver jar files

			// Oracle Server:
			// URL: jdbc:oracle:thin:@localhost:1521:test

			//Step 1:Establish Connection To DB with  help of DiriverManager
		 
		
			
			try(Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","rootroot");) 
			{
				System.out.println("DB Application");
				System.out.println("Connected to MySql....");
					//Step2:
				
				
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				//System.out.println(e.getMessage());
			}
			
			}

		}


