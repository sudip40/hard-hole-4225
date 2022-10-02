package com.CMS.dao;

import java.util.List;

import com.CMS.bean.CoursPlan;
import com.CMS.bean.DayWisePlanner;
import com.CMS.exceptions.CoursPlanException;
import com.CMS.exceptions.FacultyException;

public interface Facultyuserdao {
//	Login to his/her account
//	View the Course Plan
//	Fill up the day wise planner.
//	Update his/her password
    public boolean login(String un,String pass,int id);
	public List<CoursPlan> viewCoursePlan(String usrnm) throws CoursPlanException,FacultyException;
	public String fillDayWisePlanner(DayWisePlanner dwp);
	public String updatePassword(String un,String pass);
}
