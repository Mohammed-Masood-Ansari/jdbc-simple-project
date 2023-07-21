package com.jspider.jdbc_simple_crud_operation.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class StudentUpdateController {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter student id to update email");
		int id = scanner.nextInt();
		
		System.out.println("enter new email to update");
		String email = scanner.next();
		
		try {
			//step-1 load/Register the driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//step-2 Create conenction
			String url = "jdbc:mysql://localhost:3306/jdbc-10am";
			String user = "root";
			String pass = "root";
			
			Connection connection=DriverManager.getConnection(url, user, pass);
			
			//step-3 create statement
			Statement statement=connection.createStatement();
			
			//step-4 execute Query
			
			String updateStudentEmailQuery = "update student set email='"+email+"' WHERE id="+id;
			
			int a=statement.executeUpdate(updateStudentEmailQuery);
			
			if(a==1) {
				System.out.println("Data---Updated----");
			}else {
				System.out.println("Given id is not present");
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
