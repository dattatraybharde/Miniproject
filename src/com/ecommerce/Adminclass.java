package com.ecommerce;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;
/*
Author: Dattatray Bharde

*/
public class Adminclass {
	Scanner scanner=new Scanner(System.in);  ///  to take input from user... 
	Connection connection=null;
	String name,pass;                        
	PreparedStatement preparedstatement=null;
	public Connection adminLogin()
	{   int a;
		try { 
			/// created .propertiesfile object to take admin username & passward..
			FileInputStream fileInputStream=new FileInputStream("C:\\Users\\Kople Computers\\Desktop\\Admin.properties"); /// copy the path of the. properties file
			Properties properties=new Properties();
			properties.load(fileInputStream);   
			String username=properties.getProperty("username"); 
			String password=properties.getProperty("password"); 
			System.out.println("Enter username:");   // input from Admin it act as a username
			 name=scanner.next();    //// name contain Admin
			 System.out.println("Enter password:");  // input from Admin it act as a passward
			 pass=scanner.next();  // pass contain passward..Admin@123
			 if((name.equals(username))&&(pass.equals(password)))  
			 {
				 System.out.println("Login successfully Completed.......");  ///if both conditions are true then  Massage print on screen
			 }
			 do {
					System.out.println("Enter your choice:\n1. user data\n2. cart data\n3. product data");
					int choice=scanner.nextInt();  // Admin make a choice..
					switch(choice){
					case 1:
						   UserData user=new UserData();
						   Connection connection=user.userLogin();
						  break;
					case 2:
						CartData cart=new CartData();
						 Connection connection1=cart.cartLogin();
						 break;
					case 3:
						ProductData product=new ProductData();
						 Connection connection2=product.productLogin();
						break;
					default:
						System.out.println("invalid Input");		
					}
					System.out.println("If you wants to continue press 0");
					 a=scanner.nextInt();
					}while(a==0);				  
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return connection;
}
}
