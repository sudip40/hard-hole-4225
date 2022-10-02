package com.CMS.use;
import java.util.Scanner;

import com.CMS.dao.AdminImps;
public class Admin {
	AdminImps a=new AdminImps();
	Scanner sc=new Scanner(System.in);
	AdminFunc af=new AdminFunc();
	Welcome w=new Welcome();
 public boolean login() {
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
//	 Create, Update, View Course
	 System.out.println("========================================");
	 System.out.println("1.Create Course");
	 System.out.println("2.Update Course");
	 System.out.println("3.View Course");
	 System.out.println("4.Create Batch");
	 System.out.println("5.Update Batch");
	 System.out.println("6.View Batch");
	 System.out.println("7.Create Faculty");
	 System.out.println("8.Update Faculty");
	 System.out.println("9.View Faculty");
	 System.out.println("10.Create Course plan");
	 System.out.println("11.Update Course plan");
	 System.out.println("12.View Course plan");
	 System.out.println("13.Allocate Faculty to a Batch");
	 System.out.println("14.View the Day wise update of every Batch");
	 System.out.println("15.Generate Report for every Batch");
	 System.out.println("16.Exit");
	 System.out.println("========================================");
	 System.out.println("Enter Your Choice: ");
	 int i=sc.nextInt();
	 
	 switch(i) {
	 case 1:
		af.createCourse();
		adminfuncs();
		break;
	 case 2:
		 System.out.println("========================================");
		 System.out.println("1.Remove Course By Course Id");
		 System.out.println("2.Remove Course By Course Name");
		 System.out.println("3.Update Couse Name By Id");
		 System.out.println("4.Update Couse Name By Course Name");
		 System.out.println("5.Update Course Fee By Course Name");
		 System.out.println("6.Update Course Fee By Course Id");
		 System.out.println("7.Update Course Fee By Course Fee");
		 System.out.println("8.Update Course Description By Name");
		 System.out.println("9.Update Course Description By Id");
		 System.out.println("10.Exit");
		 System.out.println("11.Back");
		 System.out.println("========================================");
		 System.out.println("Enter Your Choice: ");
		 int j=sc.nextInt();
		 switch(j) {
		 case 1:
			 af.removeCourseByCourseId();
			 adminfuncs();
			 break;
		 case 2:
			 af.removeCourseByCourseName();
			 adminfuncs();
			 break;
		 case 3:
			 af.updateCouseNameById();
			 adminfuncs();
			 break;
		 case 4:
			 af.updateCouseNameByCourseName();
			 adminfuncs();
			 break;
		 case 5:
			 af.updateCourseFeeByCourseName();
			 adminfuncs();
			 break;
		 case 6:
			 af.updateCourseFeeByCourseId();
			 adminfuncs();
			 break;
		 case 7:
			 af.updateCourseFeeByCourseFee();
			 adminfuncs();
			 break;
		 case 8:
			 af.updateCourseDescriptionByName();
			 adminfuncs();
			 break;
		 case 9:
			 af.updateCourseDescriptionById();
			 adminfuncs();
			 break;
		 case 10:
			w.login();
			break;
		 default:
			 adminfuncs();
			 break;
		 }
		 break;
	 case 3:
		 System.out.println("========================================");
		 System.out.println("1.View All Course");
		 System.out.println("2.View Course By Course Name");
		 System.out.println("3.View Course By Course ID");
		 System.out.println("4.View Course By Batch ID");
		 System.out.println("5.View Course By Faculty ID");
		 System.out.println("6.Exit");
		 System.out.println("7.Back");
		 System.out.println("========================================");
		 System.out.println("Enter Your Choice: ");
		 int k=sc.nextInt();
		 switch(k) {
		 case 1:
			 af.viewAllCourse();
			 adminfuncs();
			 break;
		 case 2:
			 af.viewCourseByCourseName();
			 adminfuncs();
			 break;
		 case 3:
			 af.viewCourseByCourseID();
			 adminfuncs();
			 break;
		 case 4:
			 af.viewCourseByBatchID();
			 adminfuncs();
			 break;
		 case 5:
			 af.viewCourseByFacultyID();
			 adminfuncs();
			 break;
		 case 6:
			 w.login();
			 break;
		 default:
			 adminfuncs();
			 break;
		 }
		 break;
	 case 4:
		 af.createBatch();
		 adminfuncs();
		 break;
	 case 5:
		 System.out.println("========================================");
		 System.out.println("1.Update Batch Number of Students");
		 System.out.println("2.Update Batch Duration");
		 System.out.println("3.Update Batch Start Date");
		 System.out.println("4.Remove Batch By Batch Id");
		 System.out.println("5.Exit");
		 System.out.println("6.Back");
		 System.out.println("========================================");
		 System.out.println("Enter Your Choice: ");
		 int l=sc.nextInt();
		 switch(l) {
		 case 1:
			 af.updateBatchnumberofStudents();
			 adminfuncs();
			 break;
		 case 2:
			 af.updateBatchduration();
			 adminfuncs();
			 break;
		 case 3:
			 af.updateBatchbatchstartDate();
			 adminfuncs();
			 break;
		 case 4:
			 af.removeBatchByBatchId();
			 adminfuncs();
			 break;
		 case 5:
			 w.login();
			 break;
		 default:
			 adminfuncs();
			 break;
		 }
		 break;
	 case 6:
		 System.out.println("========================================");
		 System.out.println("1.View All Batch");
		 System.out.println("2.View Batch By Faculty ID");
		 System.out.println("3.Exit");
		 System.out.println("4.Back");
		 System.out.println("========================================");
		 System.out.println("Enter Your Choice: ");
		 int m=sc.nextInt();
		 switch(m) {
		 case 1:
			 af.viewAllBatch();
			 adminfuncs();
			 break;
		 case 2:
			 af.viewBatchByFacultyID();
			 adminfuncs();
			 break;
		 case 3:
			 w.login();
			 break;
		 default:
			 adminfuncs();
			 break;
		 }
		 break;
	 case 7:
		 af.registerFaculty();
		 adminfuncs();
		 break;
	 case 8:
		 System.out.println("========================================");
		 System.out.println("1.Remove Faculty By Faculty ID");
		 System.out.println("2.Update Faculty Name");
		 System.out.println("3.Update Faculty Address");
		 System.out.println("4.Update Faculty Email");
		 System.out.println("5.Update Faculty Mobile");
		 System.out.println("6.Update Faculty UserName");
		 System.out.println("7.Update Faculty Password");
		 System.out.println("8.Exit");
		 System.out.println("9.Back");
		 System.out.println("========================================");
		 System.out.println("Enter Your Choice: ");
		 int uf=sc.nextInt();
		 switch(uf) {
		 case 1:
			 af.removeFacultyByFacultyID();
			 adminfuncs();
			 break;
		 case 2:
			 af.updateFacultyName();
			 adminfuncs();
			 break;
		 case 3:
			 af.updateFacultyAddress();
			 adminfuncs();
			 break;
		 case 4:
			 af.updateFacultyEmail();
			 adminfuncs();
			 break;
		 case 5:
			 af.updateFacultyMobile();
			 adminfuncs();
			 break;
		 case 6:
			 af.updateFacultyUserName();
			 adminfuncs();
			 break;
		 case 7:
			 af.updateFacultyPassword();
			 adminfuncs();
			 break;
		 case 8:
			 w.login();
			 break;
		 default:
			 adminfuncs();
			 break;
		 }
		 break;
	 case 9:
		 System.out.println("========================================");
		 System.out.println("1.View All Faculty");
		 System.out.println("2.View Faculty By Batch ID");
		 System.out.println("3.Exit");
		 System.out.println("4.Back");
		 System.out.println("========================================");
		 System.out.println("Enter Your Choice: ");
		 int n=sc.nextInt();
		 switch(n) {
		 case 1:
			 af.viewAllFaculty();
			 adminfuncs();
			 break;
		 case 2:
			 af.viewFacultyByBatchID();
			 adminfuncs();
			 break;
		 case 3:
			 w.login();
			 break;
		 default:
			 adminfuncs();
			 break;
		 }
		 break;
	 case 10:
		 af.createCoursePlan();
		 adminfuncs();
		 break;
	 case 11:
		 System.out.println("========================================");
		 System.out.println("1.Update Course Plan Status");
		 System.out.println("2.Remove Course Plan By Id");
		 System.out.println("3.Exit");
		 System.out.println("4.Back");
		 System.out.println("========================================");
		 System.out.println("Enter Your Choice: ");
		 int cp=sc.nextInt();
		 switch(cp) {
		 case 1:
			 af.updateCoursePlanStatus();
			 adminfuncs();
			 break;
		 case 2:
			 af.removeCoursePlanById();
			 adminfuncs();
			 break;
		 case 3:
			 w.login();
			 break;
		 default:
			 adminfuncs();
			 break;
		 }
		 break;
	 case 12:
		 System.out.println("========================================");
		 System.out.println("1.View All Course Plan");
		 System.out.println("2.View Course Plan By Plan ID");
		 System.out.println("3.Exit");
		 System.out.println("4.Back");
		 System.out.println("========================================");
		 System.out.println("Enter Your Choice: ");
		 int vcp=sc.nextInt();
		 switch(vcp) {
		 case 1:
			 af.viewAllCoursePlan();
			 adminfuncs();
			 break;
		 case 2:
			 af.viewCoursePlanByPlanID();
			 adminfuncs();
			 break;
		 case 3:
			 w.login();
			 break;
		 default:
			 adminfuncs();
			 break;
		 }
		 break;
	 case 13:
		 af.allocateFaculty();
		 adminfuncs();
		 break;
	 case 14:
		 break;
	 case 15:
		 break;
	 case 16:
		 w.login();
		 break;
	 default:
		 adminfuncs();
		 break;
	 }
	 
 }
}
