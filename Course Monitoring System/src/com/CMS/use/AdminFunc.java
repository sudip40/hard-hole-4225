package com.CMS.use;

import java.util.ArrayList;
import java.util.List;

import com.CMS.bean.Batch;
import com.CMS.bean.CoursPlan;
import com.CMS.bean.Course;
import com.CMS.bean.Faculty;
import com.CMS.dao.AdminImps;
import com.CMS.exceptions.BatchException;
import com.CMS.exceptions.CoursPlanException;
import com.CMS.exceptions.CourseException;
import com.CMS.exceptions.FacultyException;

import java.util.Scanner;
public class AdminFunc {
	AdminImps a=new AdminImps();
	Scanner sc=new Scanner(System.in);
	
	
    public void createCourse() {
	 System.out.println("Enter Course Name: ");
  	 String cname=sc.next();
  	 System.out.println("Enter Course Description: ");
  	 sc.nextLine();
 	 String desc=sc.nextLine();
  	 System.out.println("Enter Course Fee: ");
  	 int fee=sc.nextInt();
  	 Course c=new Course();
  	 c.setCourseName(cname);
  	 c.setFee(fee);
  	 c.setCourseDescription(desc);
  	 String s=a.createCourse(c);
  	 System.out.println(s);
   }
	
	public void removeCourseByCourseId() {
	 System.out.println("Enter Course ID: ");
   	 int id1=sc.nextInt();
   	 String s=a.removeCourseByCourseId(id1);
   	 System.out.println(s);
	}
	public void removeCourseByCourseName() {
	 System.out.println("Enter Course Name: ");
   	 String nm=sc.next();
   	 String s=a.removeCourseByCourseName(nm);
   	 System.out.println(s);	
	}
	
	public void updateCouseNameById() {
		System.out.println("Enter New Course Name: ");
		String nm=sc.next();
		System.out.println("Enter Course ID: ");
		int cid=sc.nextInt();
		String s=a.updateCouseNameById(cid,nm);
		System.out.println(s);
	}
	public void updateCouseNameByCourseName() {
		System.out.println("Enter New Course Name: ");
		String nn=sc.next();
		System.out.println("Enter Old Course Name: ");
		String on=sc.next();
		String s=a.updateCouseNameByCourseName(on,nn);
		System.out.println(s);
	}
	
	public void updateCourseFeeByCourseName() {
		System.out.println("Enter Course Name: ");
		String nm=sc.next();
		System.out.println("Enter New Fee: ");
		int fee=sc.nextInt();
		String s=a.updateCourseFeeByCourseName(nm,fee);
		System.out.println(s);
	}
	public void updateCourseFeeByCourseId() {
		System.out.println("Enter New Fee: ");
		int fee=sc.nextInt();
		System.out.println("Enter Course ID: ");
		int cid=sc.nextInt();
		String s=a.updateCourseFeeByCourseId(cid,fee);
		System.out.println(s);	
	}
	public void updateCourseFeeByCourseFee() {
		System.out.println("Enter New Fee: ");
		int fee=sc.nextInt();
		System.out.println("Enter Old Fee: ");
		int of=sc.nextInt();
		String s=a.updateCourseFeeByCourseFee(of,fee);
		System.out.println(s);	
	}
	
	public void updateCourseDescriptionByName() {
		System.out.println("Enter Course Name: ");
		String name=sc.next();
		System.out.println("Enter New Course Description: ");
		sc.nextLine();
		String desc=sc.nextLine();
		String s=a.updateCourseDescriptionByName(name,desc);
		System.out.println(s);	
	}
	public void updateCourseDescriptionById() {
		System.out.println("Enter New Course Description: ");
		String desc=sc.nextLine();
		System.out.println("Enter Course ID: ");
		int id=sc.nextInt();
		
		String s=a.updateCourseDescriptionById(id,desc);
		System.out.println(s);
	}
	
	public void viewAllCourse(){
		List<Course> ls=new ArrayList<Course>();
		try {
			ls=a.viewAllCourse();
			for(Course el:ls) {
				System.out.println("Course ID : "+el.getCoursed());
				System.out.println("Course Name : "+el.getCourseName());
				System.out.println("Course Fee : "+el.getFee());
				System.out.println("Course Description : "+el.getCourseDescription());
				System.out.println("=================================================");
			}
		} catch (CourseException e) {
			e.printStackTrace();
		}
	}
	public void viewCourseByCourseName() {
		System.out.println("Enter Course Name: ");
		String cn=sc.next();
		Course c=new Course();
		try {
			c=a.viewCourseByCourseName(cn);
		} catch (CourseException e) {
			e.printStackTrace();
		}
		System.out.println("Course ID: "+c.getCoursed());
		System.out.println("Course Name: "+c.getCourseName());
		System.out.println("Course Fee: "+c.getFee());
		System.out.println("Course Description: "+c.getCourseDescription());
	}
	public void viewCourseByCourseID() {
		System.out.println("Enter Course ID: ");
		int id=sc.nextInt();
		Course c=new Course();
		try {
			c=a.viewCourseByCourseID(id);
		} catch (CourseException e) {
			e.printStackTrace();
		}
		System.out.println("Course ID: "+c.getCoursed());
		System.out.println("Course Name: "+c.getCourseName());
		System.out.println("Course Fee: "+c.getFee());
		System.out.println("Course Description: "+c.getCourseDescription());	
	}
	
	public void createBatch() {
	System.out.println("Enter courseId: ");
	int cid=sc.nextInt();
	System.out.println("Enter facultyId:");
	int fid=sc.nextInt();
	System.out.println("Enter numberofStudents: ");
	int no=sc.nextInt();
	System.out.println("Enter batchstartDate: ");
	String d=sc.next();
	System.out.println("Enter duration: ");
	String dur=sc.next();
	
	Batch b=new Batch();
	b.setCourseId(cid);
	b.setFacultyId(fid);
	b.setNumberofStudents(no);
	b.setBatchstartDate(d);
	b.setDuration(dur);
	String s=a.createBatch(b);
	System.out.println(s);
	
	}
	public void updateBatchnumberofStudents() {
		System.out.println("Enter New Student Number: ");
		int no=sc.nextInt();
		System.out.println("Enter Batch ID: ");
		int id=sc.nextInt();
		String s=a.updateBatchnumberofStudents(id,no);
		System.out.println(s);
	}
	public void updateBatchduration() {
		System.out.println("Enter New Duration: ");
		String no=sc.next();
		System.out.println("Enter Batch ID: ");
		int id=sc.nextInt();
		String s=a.updateBatchduration(id,no);
		System.out.println(s);
	}
	public void updateBatchbatchstartDate() {
		System.out.println("Enter New Batch Start Date: ");
		String d=sc.next();
		System.out.println("Enter Batch ID: ");
		int id=sc.nextInt();
		String s=a.updateBatchbatchstartDate(id,d);
		System.out.println(s);
	}
	public void removeBatchByBatchId() {
		System.out.println("Enter Batch ID: ");
		int id=sc.nextInt();
		String s=a.removeBatchByBatchId(id);
		System.out.println(s);
	}
	
	public void viewAllBatch(){
		List<Batch> ls=new ArrayList<Batch>();
		try {
			ls=a.viewAllBatch();
			for(Batch el:ls) {
				System.out.println("Batch ID: "+el.getBatchId());
				System.out.println("Course ID: "+el.getCourseId());
				System.out.println("Faculty ID: "+el.getFacultyId());
				System.out.println("Batch Start Date: "+el.getBatchstartDate());
				System.out.println("No of Students: "+el.getNumberofStudents());
				System.out.println("Duration: "+el.getDuration());
				System.out.println("=============================================");
			}
		} catch (BatchException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void viewCourseByBatchID(){
		System.out.println("Enter Batch ID: ");
		int id=sc.nextInt();
		List<Course> ls=new ArrayList<Course>();
		try {
			ls=a.viewCourseByBatchID(id);
			for(Course el:ls) {
				System.out.println("Course ID : "+el.getCoursed());
				System.out.println("Course Name : "+el.getCourseName());
				System.out.println("Course Fee : "+el.getFee());
				System.out.println("Course Description : "+el.getCourseDescription());
				System.out.println("=================================================");	
			}
		} catch (BatchException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void viewFacultyByBatchID(){
		System.out.println("Enter Batch ID: ");
		int id=sc.nextInt();
		List<Faculty> ls=new ArrayList<Faculty>();
		try {
			ls=a.viewFacultyByBatchID(id);
			for(Faculty el:ls) {
				System.out.println("Faculty ID : "+el.getFacultyid());
				System.out.println("Faculty Name : "+el.getFacultyname());
				System.out.println("Faculty Address : "+el.getFacultyaddress());
				System.out.println("Faculty Mobile : "+el.getMobile());
				System.out.println("Faculty Email : "+el.getEmail());
				System.out.println("Faculty Username : "+el.getUsername());
				System.out.println("=================================================");	
			}
		} catch (BatchException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}
	
	public void registerFaculty() {
		System.out.println("Enter Faculty Name: ");
		String n=sc.next();
		System.out.println("Enter Faculty Address: ");
		String add=sc.next();
		System.out.println("Enter Faculty Mobile: ");
		String mob=sc.next();
		System.out.println("Enter Faculty Email: ");
		String email=sc.next();
		System.out.println("Enter Faculty Username: ");
		String un=sc.next();
		System.out.println("Enter Faculty Password: ");
		String pass=sc.next();
		
		Faculty f=new Faculty();
		f.setFacultyname(n);
		f.setFacultyaddress(add);
		f.setMobile(mob);
		f.setEmail(email);
		f.setUsername(un);
		f.setPassword(pass);
		
		String s=a.registerFaculty(f);
		System.out.println(s);
	}
	
	public void removeFacultyByFacultyID() {
		System.out.println("Enter Faculty ID: ");
		int id=sc.nextInt();
		String s=a.removeFacultyByFacultyID(id);
		System.out.println(s);
	}
	
	public void updateFacultyName() {
		System.out.println("Enter New Faculty Name: ");
		String n=sc.next();
		System.out.println("Enter Faculty ID: ");
		int id=sc.nextInt();
		String s=a.updateFacultyName(id, n);
		System.out.println(s);
	}
	public void updateFacultyAddress() {
		System.out.println("Enter New Faculty Address: ");
		String n=sc.next();
		System.out.println("Enter Faculty ID: ");
		int id=sc.nextInt();
		String s=a.updateFacultyAddress(id, n);
		System.out.println(s);
	}
	public void updateFacultyEmail() {
		System.out.println("Enter New Faculty Email: ");
		String n=sc.next();
		System.out.println("Enter Faculty ID: ");
		int id=sc.nextInt();
		String s=a.updateFacultyEmail(id, n);
		System.out.println(s);
	}
	public void updateFacultyMobile() {
		System.out.println("Enter New Faculty Mobile: ");
		String n=sc.next();
		System.out.println("Enter Faculty ID: ");
		int id=sc.nextInt();
		String s=a.updateFacultyMobile(id, n);
		System.out.println(s);
	}
	public void updateFacultyUserName() {
		System.out.println("Enter New Faculty Username: ");
		String n=sc.next();
		System.out.println("Enter Faculty ID: ");
		int id=sc.nextInt();
		String s=a.updateFacultyUserName(id, n);
		System.out.println(s);	
	}
	public void updateFacultyPassword() {
		System.out.println("Enter New Faculty Password: ");
		String n=sc.next();
		System.out.println("Enter Faculty ID: ");
		int id=sc.nextInt();
		String s=a.updateFacultyPassword(id, n);
		System.out.println(s);
	}
    
	
	public void viewAllFaculty(){
		List<Faculty> ls=new ArrayList<Faculty>();
		try {
			ls=a.viewAllFaculty();
			for(Faculty el:ls) {
				System.out.println("Faculty ID: "+el.getFacultyid());
				System.out.println("Faculty Name: "+el.getFacultyname());
				System.out.println("Faculty Address: "+el.getFacultyaddress());
				System.out.println("Faculty Mobile: "+el.getMobile());
				System.out.println("Faculty Email: "+el.getEmail());
				System.out.println("Faculty Username: "+el.getUsername());
				System.out.println("====================================================");
			}
		} catch (FacultyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void viewCourseByFacultyID(){
		System.out.println("Enter Faculty ID: ");
		int id=sc.nextInt();
		List<Course> ls=new ArrayList<Course>();
		try {
			ls=a.viewCourseByFacultyID(id);
			for(Course el:ls) {
				System.out.println("Course ID : "+el.getCoursed());
				System.out.println("Course Name : "+el.getCourseName());
				System.out.println("Course Fee : "+el.getFee());
				System.out.println("Course Description : "+el.getCourseDescription());
				System.out.println("=================================================");	
			}
		} catch (CourseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void viewBatchByFacultyID(){
		List<Batch> ls=new ArrayList<Batch>();
		System.out.println("Enter Faculty ID: ");
		int id=sc.nextInt();
		try {
			ls=a.viewBatchByFacultyID(id);
			for(Batch el:ls) {
				System.out.println("Batch ID: "+el.getBatchId());
				System.out.println("Course ID: "+el.getCourseId());
				System.out.println("Faculty ID: "+el.getFacultyId());
				System.out.println("Batch Start Date: "+el.getBatchstartDate());
				System.out.println("No of Students: "+el.getNumberofStudents());
				System.out.println("Duration: "+el.getDuration());
				System.out.println("=============================================");
			}
		} catch (BatchException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void allocateFaculty() {
		System.out.println("Enter Batch ID: ");
		int bid=sc.nextInt();
		System.out.println("Enter Faculty ID: ");
		int fid=sc.nextInt();
		String s;
		try {
			s = a.allocateFaculty(bid,fid);
			System.out.println(s);
		} catch (FacultyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BatchException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void createCoursePlan() {
		System.out.println("Enter Batch ID: ");
		int bid=sc.nextInt();
		System.out.println("Enter Day Number: ");
		int dn=sc.nextInt();
		System.out.println("Enter Topic: ");
		String t=sc.next();
		System.out.println("Enter Status: ");
		String st=sc.next();
		CoursPlan cp=new CoursPlan();
		cp.setBatchId(bid);
		cp.setDaynumber(dn);
		cp.setTopic(t);
		cp.setStatus(st);
		String s=a.createCoursePlan(cp);
		System.out.println(s);
	}
	public void updateCoursePlanStatus() {
		System.out.println("Enter Plan ID: ");
		int id =sc.nextInt();
		System.out.println("Enter New Status: ");
		String st=sc.next();
		String s=a.updateCoursePlanStatus(id,st);
		System.out.println(s);
	}
	public void removeCoursePlanById() {
		System.out.println("Enter Plan ID: ");
		int id =sc.nextInt();
		String s=a.removeCoursePlanById(id);
		System.out.println(s);
	}
	public void viewAllCoursePlan(){
		List<CoursPlan> ls=new ArrayList<CoursPlan>();
		try {
			ls=a.viewAllCoursePlan();
			for(CoursPlan el:ls) {
				System.out.println("Plan ID:"+el.getPlanId());
				System.out.println("Batch ID: "+el.getBatchId());
				System.out.println("Day Number: "+el.getDaynumber());
				System.out.println("Topic: "+el.getTopic());
				System.out.println("Status: "+el.getStatus());
				System.out.println("====================================");
			}
		} catch (CoursPlanException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void viewCoursePlanByPlanID() {
		System.out.println("Enter Plan ID: ");
		int id =sc.nextInt();
		try {
			CoursPlan cp=a.viewCoursePlanByPlanID(id);
			System.out.println("Plan ID:"+cp.getPlanId());
			System.out.println("Batch ID: "+cp.getBatchId());
			System.out.println("Day Number: "+cp.getDaynumber());
			System.out.println("Topic: "+cp.getTopic());
			System.out.println("Status: "+cp.getStatus());
			
		} catch (CoursPlanException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void GenerateReportforeverybatch(){
		List<CoursPlan> ls=new ArrayList<CoursPlan>();
		try {
			ls=a.GenerateReportforeverybatch();
			for(CoursPlan el:ls) {
				
				System.out.println("Batch ID: "+el.getBatchId());
				System.out.println("Plan ID:"+el.getPlanId());
				System.out.println("Day Number: "+el.getDaynumber());
				System.out.println("Topic: "+el.getTopic());
				System.out.println("Status: "+el.getStatus());
				System.out.println("====================================");
			}
		} catch (CoursPlanException e) {
			e.printStackTrace();
		}	
	}
}
