package com.ecommerce;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/*
Author: Dattatray Bharde

*/
//class is created to show customer username & passward to admin only..
public class UserData {
	Connection connection=null;
	PreparedStatement preparedstatement=null;
	ResultSet resultSet=null;
	/// Design method which return the connection object
	public Connection userLogin() throws SQLException { 
		try {
			 Class.forName("com.mysql.jdbc.Driver");   //Loading the Driver Class.
			  connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce","root","D@tt@777"); // Establish the Connection.
			  String sql="select *from customerlogin";
			    preparedstatement=connection.prepareStatement(sql); ///// using Prepared SQL Statement
			    resultSet=preparedstatement.executeQuery();  //// Executes the SQL query
			    System.out.println("Customer Id\t\tCustomer username\t\tPassword");
			    System.out.println("===================================================================================");
			    while(resultSet.next()) {
			    	int id=resultSet.getInt("custId");
			    	String cname=resultSet.getString("customerUsername");
			    	String pass=resultSet.getString("customerPassword");
			    	System.out.println(id+"\t\t"+cname+"\t\t"+pass);
			    	System.out.println("--------------------------------------------------------------------------------");
			      }
		}catch(Exception e){
			e.printStackTrace();
		}
     return connection;
}
}	

