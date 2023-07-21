package com.jspider.jdbc_simple_crud_operation.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class StudentDisplayController {
	static Connection connection=null;
	public static void main(String[] args) {
		
		try {
			// step-1 Load/register driver
			// Register Driver
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);

			// step-2 create connection
			String url = "jdbc:mysql://localhost:3306/jdbc-10am";
			String user = "root";
			String pass = "root";

			connection = DriverManager.getConnection(url, user, pass);

			// step-3 create statement
			Statement statement = connection.createStatement();

			// step-4 executeQuery

			String displayAllStudentQuery = "SELECT * FROM student";

			ResultSet resultSet = statement.executeQuery(displayAllStudentQuery);

				while(resultSet.next()) {
			
				
				int id = resultSet.getInt("id");
				
				String name = resultSet.getString("name");
				
				String email = resultSet.getString("email");
				
				long phone = resultSet.getLong("phone");
				
				System.out.println("stduentId = "+id);
				System.out.println("stduentName = "+name);
				System.out.println("stduentEmail = "+email);
				System.out.println("stduentPhone = "+phone);
				System.out.println("..................................");
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}
