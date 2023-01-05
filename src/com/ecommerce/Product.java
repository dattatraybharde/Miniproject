package com.ecommerce;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
/*
Author: Dattatray Bharde

*/
public class Product {
	Scanner scanner=new Scanner(System.in); 
	
	ResultSet resultSet=null;
	Connection connection=null;
	PreparedStatement preparedstatement=null;
	/// Design method which return the connection object
	public Connection getProduct() throws SQLException, ClassNotFoundException {   
		try {
		Class.forName("com.mysql.jdbc.Driver");  /// Loading the Driver Class
		connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce","root","D@tt@777");// establish The connection..
		 String sql="select *from product order by productId";  
		    preparedstatement=connection.prepareStatement(sql) ;  ///// using Prepared SQL Statement
		    resultSet=preparedstatement.executeQuery();      //// Executes the SQL query
		    System.out.println("Product Id\t\tProduct name\t\tPrice\t\t\t\tDesciption\t\t\t\tQuantity");
		    System.out.println("============================================================================================================================================");
		    while(resultSet.next()) {
		    	int id=resultSet.getInt("productId");
		    	String pname=resultSet.getString("productName");
		    	String price=resultSet.getString("price");
		    	String description=resultSet.getString("descriptions");
		    	String quantity=resultSet.getString("quantity");
		    	System.out.println(id+"\t\t\t"+pname+"\t\t\t"+price+"\t\t\t"+description+"\t\t\t"+quantity);
		    	System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------");
		      }
		  Cart cart=new Cart();
		  Connection connection1=cart.addToCart();  /// to call the addcart method to add the Product.
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			connection.close();
			preparedstatement.close();
		}
		return connection;
	}
}
