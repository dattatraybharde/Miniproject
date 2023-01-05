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
public class Cart {
	private static final String String = null;
	Scanner scanner=new Scanner(System.in); 
	String quantity;
	int a;
	int pid;
	String pname,price,description,totals;
	long total;
	ResultSet resultSet=null;
	Connection connection=null;
	PreparedStatement preparedstatement=null;
	///   Design method which return the connection object
	public Connection addToCart() throws SQLException {   
		try {			
			 Class.forName("com.mysql.jdbc.Driver");  //// loading the Driver class
			  connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce","root","D@tt@777"); //// Establish the connection.
			  System.out.println("Enter the product Id which you want to buy:");
		      pid=scanner.nextInt();
		      System.out.println("Enter the quantity of product:");
		      quantity=scanner.next();  
		      
		       preparedstatement=connection.prepareStatement("select *from product  where productID=?"); /// using Prepared SQL Statement
		       preparedstatement.setInt(1, pid);
		     
		       resultSet=preparedstatement.executeQuery();
			    while(resultSet.next()) {
			        pname=resultSet.getString("productName");
			    	price=resultSet.getString("price");
			    	description=resultSet.getString("descriptions");
			    }
			    long l=Long.parseLong(quantity);   ///  varchar converted into long
				 long ll=Long.parseLong(price);	   /// varchar converted into long...for database purpose..
					    for(int i=0;i<l;i++){
					    	total=total+ll;
					    }
			    totals=String.valueOf(total);   /// long int String.. for database purpose..
			    preparedstatement=connection.prepareStatement("insert into cart(productname,productprice,productdesp,productquantity,totalprice)values(?,?,?,?,?)") ;
			    preparedstatement.setString(1, pname);
			    preparedstatement.setString(2, price);
			    preparedstatement.setString(3, description);
			    preparedstatement.setString(4, quantity);
			    preparedstatement.setString(5, totals);
			    preparedstatement.executeUpdate(); ///// execute the sql statement to database
			    System.out.println("Product name\t\tPrice\t\tDescription\t\tQuantity\t\tTotal Price");
			    System.out.println("==================================================================================================================");
			    System.out.println(pname+"\t\t"+price+"\t\t"+description+"\t\t"+quantity+"\t\t"+total);
			    resultSet.close();
			
		  }catch(Exception e){      
			     e.printStackTrace();
		      } 
		  finally{
			connection.close();   //// here we closing the the Resources..
			preparedstatement.close();		
		  }
		return connection;
	}
	
}


