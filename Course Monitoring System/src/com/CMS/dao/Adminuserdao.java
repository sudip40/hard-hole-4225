package com.CMS.dao;

import java.util.List;

import com.CMS.bean.Batch;
import com.CMS.bean.CoursPlan;
import com.CMS.bean.Course;
import com.CMS.bean.DayWisePlanner;
import com.CMS.bean.Faculty;
import com.CMS.exceptions.BatchException;
import com.CMS.exceptions.CoursPlanException;
import com.CMS.exceptions.CourseException;
import com.CMS.exceptions.DayWisePlannerException;
import com.CMS.exceptions.FacultyException;

public interface Adminuserdao {
//	Login to his account
//	Create, Update, View Course.
//	Create, Update, View Batch. A batch is related to a course. 
//	Create, Update, View Faculty.
//	Allocate faculty to a batch.
//	Create, Update, View Course plan.
//	View the Day wise update of every batch.
//	Generate Report for every batch.
    public boolean login(String username, String pass);
	public String createCourse(Course course);
	
	public String removeCourseByCourseId(int id);
	public String removeCourseByCourseName(String name);
	
	public String updateCouseNameById(int id,String name);
	public String updateCouseNameByCourseName(String on,String nn);
	
	public String updateCourseFeeByCourseName(String name,int fee);
	public String updateCourseFeeByCourseId(int id,int fee);
	public String updateCourseFeeByCourseFee(int of,int fee);
	
	public String updateCourseDescriptionByName(String name,String desc);
	public String updateCourseDescriptionById(int id,String desc);
	
	public List<Course> viewAllCourse() throws CourseException;
	public Course viewCourseByCourseName(String cname) throws CourseException;
	public Course viewCourseByCourseID(int cid) throws CourseException;
	public List<Course> viewCourseByBatchID(int id) throws BatchException;
	public List<Course> viewCourseByFacultyID(int fid) throws CourseException;
	
	
	public String createBatch(Batch b);
	
	public String updateBatchnumberofStudents(int id,int nos);
	public String updateBatchduration(int id,String duration);
	public String updateBatchbatchstartDate(int id,String date);
	public String removeBatchByBatchId(int id);
	
	public List<Batch> viewAllBatch() throws BatchException;
	public List<Batch> viewBatchByFacultyID(int fid) throws BatchException;
	
	public String registerFaculty(Faculty f);
	
	public String removeFacultyByFacultyID(int id);
	
	public String updateFacultyName(int id,String name);
	public String updateFacultyAddress(int id,String add);
	public String updateFacultyEmail(int id,String email);
	public String updateFacultyMobile(int id,String mob);
	public String updateFacultyUserName(int id,String un);
	public String updateFacultyPassword(int id,String pass);
	
	public List<Faculty> viewAllFaculty() throws FacultyException;
	public List<Faculty> viewFacultyByBatchID(int id) throws BatchException;
	
	
	public String allocateFaculty(int bid,int fid) throws FacultyException,BatchException;
	
	public String createCoursePlan(CoursPlan cp);
	
	public String updateCoursePlanStatus(int pid,String s);
	public String removeCoursePlanById(int pid);
	
	public List<CoursPlan> viewAllCoursePlan() throws CoursPlanException;
	public CoursPlan viewCoursePlanByPlanID(int pid) throws CoursPlanException;
	public List<DayWisePlanner> ViewDaywiseupdateofeverybatch() throws DayWisePlannerException;
	public List<CoursPlan> GenerateReportforeverybatch() throws CoursPlanException ;

}
