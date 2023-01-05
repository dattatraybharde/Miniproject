package com.ecommerce;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;
/*
Author: Dattatray Bharde

*/
public class Mainclass {
	// Execution will be start from main method..
	 public static void main(String args[]) throws SQLException,NullPointerException {
	    Scanner scanner=new Scanner(System.in);  
		  int a;
	try {
		do {
		System.out.println("Enter your choice:\n1. Admin Login\n2. Customer Login");
		int choice=scanner.nextInt();  /// user can make a choice , choice contain n1 or n2
		switch(choice){   /// by using Switch Statement choose the condition..
		case 1:
			   Adminclass admin=new Adminclass();  //for admin access we make a class & object is created
			   Connection connection=admin.adminLogin();  // Method calling..
			  break;
		case 2:
			CustomerLogin customerlogin=new CustomerLogin(); //for customer access we make a class & object is created
			 Connection connection2=customerlogin.customerLogin(); // Method calling..
			break;
		default:
			System.out.println("invalid Input");	
		}
		System.out.println("If you wants to continue press 0");
		 a=scanner.nextInt();
		}while(a==0); 
	}catch(Exception e) {
			  e.printStackTrace();
		  }
	 }
}
