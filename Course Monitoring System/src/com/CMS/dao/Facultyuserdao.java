package com.CMS.dao;

public interface Facultyuserdao {
//	Login to his/her account
//	View the Course Plan
//	Fill up the day wise planner.
//	Update his/her password
    public boolean login(String un,String pass);
	public String viewCoursePlan();
	public String updatePassword();
}
