package com.CMS.use;
import java.util.Scanner;

import com.CMS.dao.AdminImps;
public class Admin {
	AdminImps a=new AdminImps();
	
 public boolean login() {
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter your Username: ");
	String un=sc.next();
	System.out.println("Enter your Password: ");
	String pass=sc.next();
	
	
	boolean b=a.login(un, pass);
	if(b) {
		System.out.println("Welcome "+un);
	}
	else {
		System.out.println("Wrong Credentials");
	}
	return b;
	 
 }
 public void adminfuncs() {
	 
 }
}
