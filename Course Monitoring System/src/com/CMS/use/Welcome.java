package com.CMS.use;

import java.util.Scanner;

public class Welcome {
	public void login() {
	    Scanner sc=new Scanner(System.in);
	    System.out.println("Welcome to Course Monitoring System");
	    System.out.println("***************************************************");
		System.out.println("Enter Your Choice :");
		System.out.println("1.Login as an Admin");
		System.out.println("2.Login as a Faculty");
		int i=sc.nextInt();
		if(i==1) {
			Admin a=new Admin();
			if(a.login()) {
			a.adminfuncs();
			}
			else {
				System.out.println("========================================");
				login();
			}
		}
		else if(i==2) {
			Faculty f=new Faculty();
			if(f.loginf()) {
			f.facultyfuncs();
			}
			else {
				System.out.println("========================================");
				login();
			}
		}
			
    }
}
