package com.ecommerce;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;
/*
Author: Dattatray Bharde

*/
public class CustomerLogin {
	  Scanner scanner=new Scanner(System.in);
	  Connection connection=null;
	///   Design method which return the connection object..
	 public Connection customerLogin() throws SQLException {  
		 int a;
		 try {
		System.out.println("If you already registered then go to login otherwise make a registration");
		do {
		System.out.println("Enter your choice:\n1. Login\n2. Registration"); 
		int choice=scanner.nextInt();    //
		switch(choice){   ///  By using Switch statement user choose can make a choice...
		case 1:
			  Login login=new Login();
			  Connection connection=login.loginCustomer();
			break;
		case 2:
			  Registration registration=new Registration();
			  Connection connection2=registration.addRegistration();
			break;
		default :
			System.out.println("Invalid Input");
		}
		System.out.println("If you wants to continue press 0");  // to continue shoping massage will be print on screen
		 a=scanner.nextInt();
		}while(a==0);
		 }catch(Exception e)
		 {
			 e.printStackTrace();
		 }
		 
		return connection;  // returning connection object to method..
	 }

}
