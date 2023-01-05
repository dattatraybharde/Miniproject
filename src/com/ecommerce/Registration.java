package com.ecommerce;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
/*
Author: Dattatray Bharde

*/
//class is created for customer or user registration..
public class Registration {
	   String firstname;
	   String lastname;
	   String mobileno;
	   String city;
	   String email;
	   String password;
	   Connection connection=null;
	  PreparedStatement preparedstatement=null;
	  Scanner scanner =new Scanner(System.in);
	/// Design method which return the connection object
	public Connection addRegistration()throws SQLException { 
		try {
			Class.forName("com.mysql.jdbc.Driver");  //Loading the Driver Class.
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce","root","D@tt@777");// Establish the Connection.
		      System.out.println("Enter First name:");  
		      firstname=scanner.next(); /// firstname conatin user first name.
		      System.out.println("Enter Last name:");
		      lastname=scanner.next();  /// lastname conatin user last name.
		      System.out.println("Enter mobile no:");
		      mobileno=scanner.next();  /// mobile no conatin user mobile number.
		      System.out.println("Enter City:");
		      city=scanner.next();  /// city conatin user city name.
		      System.out.println("Enter Email:");
		      email=scanner.next();  /// email conatin user email id.
		      System.out.println("Enter password:");
		      password=scanner.next();  /// passward conatin user passward.
		  ///// using Prepared SQL Statement
		      preparedstatement=connection.prepareStatement("insert into registrations(firstname,lastname,mobileno,city,email,pass)values(?,?,?,?,?,?)");
				preparedstatement.setString(1,firstname);
				preparedstatement.setString(2,lastname);
				preparedstatement.setString(3,mobileno);
				preparedstatement.setString(4,city);
				preparedstatement.setString(5,email);
				preparedstatement.setString(6,password);
				int i=preparedstatement.executeUpdate();  //// Executes the SQL query
				System.out.println("Registration Successfully go to login"+i);
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			connection.close();
			preparedstatement.close();
		}
		return connection;  ////// returning the object to method.
	}
}

