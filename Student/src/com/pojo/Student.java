package com.pojo;



public class Student {

	
	
	

	private int s_id,rollnumber,mobileno;
	private String Fullname,email;
	//add constr
	public Student(int s_id, String Fullname, int rollnumber, String email, int mobileno) {
		super();
		this.s_id = s_id;
		this.rollnumber = rollnumber;
		this.mobileno = mobileno;
		this.Fullname = Fullname;
		this.email = email;
	}
	
	

	public int getS_id() {
		return s_id;
	}



	public void setS_id(int s_id) {
		this.s_id = s_id;
	}



	public int getRollnumber() {
		return rollnumber;
	}



	public void setRollnumber(int rollnumber) {
		this.rollnumber = rollnumber;
	}



	public int getMobileno() {
		return mobileno;
	}



	public void setMobileno(int mobileno) {
		this.mobileno = mobileno;
	}



	public String getFullname() {
		return Fullname;
	}



	public void setFullname(String fullname) {
		Fullname = fullname;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}
	

	@Override
	public String toString() {
		return "Student [s_id=" + s_id + ", rollnumber=" + rollnumber + ", mobileno=" + mobileno + ", Fullname=" + Fullname + ", email=" + email + "]";
	}
	
}
