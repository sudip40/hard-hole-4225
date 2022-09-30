package com.CMS.use;

import java.util.Scanner;

public class Welcome {
	public static void login() {
	    Scanner sc=new Scanner(System.in);
	    System.out.println("Welcome to Course Monitoring System");
	    System.out.println("***************************************************");
		System.out.println("Enter Your Choice :");
		System.out.println("1.Login as an Admin");
		System.out.println("2.Login as a Faculty");
		int i=sc.nextInt();
		switch(i) {
		case 1:
			Admin a=new Admin();
			if(a.login()) {
			a.adminfuncs();
			}
			else {
				System.out.println("1.Exit");
				if(sc.nextInt()==1) {
					login();
				}
				else {
					System.out.println("Wrong Input");
				}
			}
			break;
		case 2:
			
		}
			
    }
}
