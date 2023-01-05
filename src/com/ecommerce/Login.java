package com.ecommerce;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
/*
Author: Dattatray Bharde

*/
public class Login {
	Scanner scanner = new Scanner(System.in);
	Connection connection = null;
	ResultSet resultSet = null;
	String userName;
	String pass;
	String emails;
	String passs;
	PreparedStatement preparedstatement = null;
	///   Design method which return the connection object
	public Connection loginCustomer() throws SQLException {
		try {
			Class.forName("com.mysql.jdbc.Driver"); /// loading the Driver Class..
			connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce", "root", "D@tt@777"); /// Establish the connection.
			System.out.println("Enter emailid:");
			userName = scanner.next();
			System.out.println("Enter Password:");
			pass = scanner.next();
			preparedstatement = connection
					.prepareStatement("insert into customerlogin(customerUsername,customerPassword)values(?,?)"); /// /// using Prepared SQL Statement
			preparedstatement.setString(1, userName);
			preparedstatement.setString(2, pass);
			String sqls = "select email,pass from registrations";
			resultSet = preparedstatement.executeQuery(sqls); ///Executes the SQL query 
			while (resultSet.next()) {
				emails = resultSet.getString("email");
				passs = resultSet.getString("pass");
				if ((userName.equals(emails)) && (pass.equals(passs))) {
					preparedstatement.executeUpdate();
					System.out.println("login Successfully");
					Product product = new Product();
					Connection connection = product.getProduct();
				}
			}
			System.out.println("You are enter wrong username and password");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connection.close();
			preparedstatement.close();
		}
		return connection;  // returning connection object to method..
	}
}
