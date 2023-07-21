package com.jspider.jdbc_simple_crud_operation.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class StudentInsertController {

	public static void main(String[] args) {
		Connection connection=null;
		try {
			// step-1 load/Register Driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			// step-2 Create Connection
			String url = "jdbc:mysql://localhost:3306/jdbc-10am";
			String user = "root";
			String pass = "root";

			connection = DriverManager.getConnection(url, user, pass);
			//step-3 create statement
			  Statement statement = connection.createStatement();
			 
			 //step-4 executeQuery 
			 String insertStudentQuery = "insert into student (id,name,email,phone) values(40,'ankit','amit420@gmail.com',98395421)";
			 
			 statement.execute(insertStudentQuery);
			 
			 System.out.println("+++++++++Data------Stored++++++++");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				//step-5 close connection
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
