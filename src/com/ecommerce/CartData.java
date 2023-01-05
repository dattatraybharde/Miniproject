package com.ecommerce;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
///  Author name:- Dattatray Bharde
////class is created to show the data to only Admin.
public class CartData {
	Connection connection=null;
	PreparedStatement preparedstatement=null;
	ResultSet resultSet=null;
	///   Design method which return the connection object
	public Connection cartLogin() throws SQLException {  
		try {
			 Class.forName("com.mysql.jdbc.Driver");   //// loading the Driver class
			  connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce","root","D@tt@777");  //// Establish the connection.
			  String sql="select *from cart";  
			    preparedstatement=connection.prepareStatement(sql);  /// using Prepared SQL Statement
			    resultSet=preparedstatement.executeQuery(); //// Executes the SQL query 
			    System.out.println("Cart Id\t\tProduct name\t\tProduct price\t\tDescription\t\tquantity\t\tToal price");
			    System.out.println("============================================================================================================================================");
			    while(resultSet.next())  {
			    	int id=resultSet.getInt("cartId");   //Here we getting the data..
			    	String pname=resultSet.getString("productname");
			    	String productp=resultSet.getString("productprice");
			    	String desp=resultSet.getString("productdesp");
			    	String quantity=resultSet.getString("productquantity");
			    	String total=resultSet.getString("totalprice");
			    	System.out.println(id+"\t"+pname+"\t\t"+productp+"\t\t"+desp+"\t\t"+quantity+"\t\t"+total);
			    	System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------");
			      }
		}catch(Exception e)
		{
			e.printStackTrace();
		}
     return connection;
}
	
}

