package com.tester;

import java.util.ArrayList;
import java.util.Scanner;

import com.dal.StudentDal;
import com.pojo.Student;

public class TestMenuCRUD {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StudentDal sDal = new StudentDal();
		try {
			System.out.println("1: Show All Students");
			System.out.println("2: Add New Student");
			System.out.println("3: Edit Student");
			System.out.println("4: Delete Student");
			System.out.println("5: Exit");
			int ch = 0;
			do {
				System.out.println("Enter Choice:");
				ch = sc.nextInt();

				switch (ch) {
				case 1:
					// read all students
					ArrayList<Student> list = null;
					try {
						list = sDal.getAllStudent();
					} catch (Exception e2) {
						e2.printStackTrace();
					}
					list.forEach(e -> System.out.println(e));
					break;
				case 2:// add new student
					System.out.println("Enter s_id, full name, roll number, email, and mobile number:");
					int s_id = sc.nextInt();
					String fullName = sc.next();
					int rollNumber = sc.nextInt();
					String email = sc.next();
					int mobileNo = sc.nextInt();
					int i = 0;
					try {
						i = sDal.insertStudent(new Student(s_id, fullName, rollNumber, email, mobileNo));
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					if (i > 0)
						System.out.println(i + " Row Inserted....");
					break;
				case 3:
					System.out.println("Enter the student id to edit:");
					int editId = sc.nextInt();

					// Check if the student exists in the database
					if(sDal.studentExists(editId)) {
					    try {
					        // Get the student object with the specified ID
					        Student editStudent = sDal.getStudentById(editId);
					        System.out.println("Enter new full name, roll number, email, and mobile number for the student:");
					        String newFullName = sc.next();
					        int newRollNumber = sc.nextInt();
					        String newEmail = sc.next();
					        int newMobileNo = sc.nextInt();
					        editStudent.setFullname(newFullName);
					        editStudent.setRollnumber(newRollNumber);
					        editStudent.setEmail(newEmail);
					        editStudent.setMobileno(newMobileNo);
					        int rowsUpdated = sDal.updateStudent(editStudent);
					        if (rowsUpdated > 0) {
					            System.out.println(rowsUpdated + " row(s) updated");
					        } else {
					            System.out.println("Update failed");
					        }
					    } catch (Exception e) {
					        e.printStackTrace();
					    }
					} else {
					    System.out.println("Student not found");
					}
				case 4:
					System.out.println("Enter the student id to delete:");
					int deleteId = sc.nextInt();
					try {
						int rowsDeleted = sDal.deleteStudent(deleteId);
						if (rowsDeleted > 0) {
							System.out.println(rowsDeleted + " row(s) deleted");
						} else {
							System.out.println("Delete failed");
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
					break;
				case 5:
					System.out.println("Exiting program...");
					break;
				default:
					System.out.println("Invalid choice!");
					break;
				}
			} while (ch != 5);//
			System.out.println("------------End------");
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

}