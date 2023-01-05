package com.ecommerce;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/*
Author: Dattatray Bharde

*/
 //// class is created to show the data to only Admin.
public class ProductData {
	ResultSet resultSet=null;
	Connection connection=null;
	PreparedStatement preparedstatement=null;
	/// Design method which return the connection object 
	public Connection productLogin() throws SQLException, ClassNotFoundException {   
		try {
		Class.forName("com.mysql.jdbc.Driver");  ///Loading The Driver Class..
		connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce","root","D@tt@777");// Establish The Connection..
		 String sql="select *from product ";  
		    preparedstatement=connection.prepareStatement(sql);///// using Prepared SQL Statement
		    resultSet=preparedstatement.executeQuery();  //// Executes the SQL query
		    System.out.println("Product Id\t\tProduct name\t\tPrice\t\tDesciption\t\tQuantity");
		    System.out.println("============================================================================================================================================");
		    while(resultSet.next()){
		    	int id=resultSet.getInt("productId");
		    	String pname=resultSet.getString("productName");
		    	String price=resultSet.getString("price");
		    	String description=resultSet.getString("descriptions");
		    	String quantity=resultSet.getString("quantity");
		    	System.out.println(id+"\t\t\t"+pname+"\t\t\t"+price+"\t\t\t"+description+"\t\t\t"+quantity);
		    	System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------");
		      }
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			connection.close();
			preparedstatement.close();
		}
		return connection;  /// returning the object to method.
	}
}

