package com.CMS.use;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.CMS.bean.CoursPlan;
import com.CMS.bean.DayWisePlanner;
import com.CMS.dao.FacultyImps;
import com.CMS.exceptions.CoursPlanException;
import com.CMS.exceptions.FacultyException;


public class FacultyFunc {
Scanner sc=new Scanner(System.in);
FacultyImps fi=new FacultyImps();

public void viewCoursePlan() {
List<CoursPlan> ls=new ArrayList<CoursPlan>();
try {
	ls=fi.viewCoursePlan(Faculty.usrnm);
	for(CoursPlan el:ls) {
		System.out.println("Plan ID: "+el.getPlanId());
		System.out.println("Day Number: "+el.getDaynumber());
		System.out.println("Batch ID: "+el.getBatchId());
		System.out.println("Topic: "+el.getTopic());
		System.out.println("Status: "+el.getStatus());
		System.out.println("========================================");
	}
} catch (CoursPlanException e) {
	System.out.println(e.getMessage());
} catch (FacultyException e) {
	System.out.println(e.getMessage());
}
}
public void fillDayWisePlanner() {
	System.out.println("Enter Date: ");
	String date=sc.next();
	System.out.println("Enter Mornig Plan(Batch Id): ");
	int m=sc.nextInt();
	System.out.println("Enter Afternoon Plan(Batch Id): ");
	int a=sc.nextInt();
	System.out.println("Enter Evening Plan(Batch Id): ");
	int e=sc.nextInt();
	DayWisePlanner dwp=new DayWisePlanner();
    dwp.setDate(date);
    dwp.setFacultyId(Faculty.facid);
    dwp.setMorning(m);
    dwp.setAfternoon(a);
    dwp.setEvening(e);
    String s=fi.fillDayWisePlanner(dwp);
    System.out.println(s);
}
public void updatePassword() {
	System.out.println("Enter New Password: ");
	String pass=sc.next();
	String s=fi.updatePassword(Faculty.usrnm, pass);
	System.out.println(s);
}
}
