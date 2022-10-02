package com.CMS.use;

import java.util.Scanner;

import com.CMS.dao.FacultyImps;

public class Faculty {
	FacultyImps fi=new FacultyImps();
	FacultyFunc ff=new FacultyFunc();
	Welcome w=new Welcome();
	static String usrnm=null;
	static int facid=0;
	Scanner sc=new Scanner(System.in);

	public boolean loginf() {
		
		System.out.println("Enter your FacultyID: ");
		int fid=sc.nextInt();
		System.out.println("Enter your Username: ");
		String un=sc.next();
		System.out.println("Enter your Password: ");
		String pass=sc.next();
		
		
		boolean b=fi.login(un,pass,fid);
		if(b) {
			System.out.println("Welcome "+un);
			usrnm=un;
			facid=fid;
		}
		else {
			System.out.println("Wrong Credentials");
		}
		return b;
	 }
	
	public void facultyfuncs() {
//		•	View the Course Plan
//		•	Fill up the day wise planner.
//		•	Update his/her password.
	  System.out.println("============================================");
      System.out.println("1. View Course Plan");
      System.out.println("2. Fill up the day wise planner");
      System.out.println("3. Update password");
      System.out.println("4.Exit");
      System.out.println("================================================");
      System.out.println("Enter Your Choice: ");
      int i=sc.nextInt();
      switch(i) {
      case 1:
    	  ff.viewCoursePlan();
    	  facultyfuncs();
    	  break;
      case 2:
    	  ff.fillDayWisePlanner();
    	  facultyfuncs();
    	  break;
      case 3:
    	  ff.updatePassword();
    	  facultyfuncs();
    	  break;
      case 4:
    	  w.login();
    	  break;
      default:
    	  facultyfuncs();
      }
	 }
}
