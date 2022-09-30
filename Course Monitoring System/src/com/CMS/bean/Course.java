package com.CMS.bean;

public class Course {
	private int coursed;
	private String courseName;
	private int fee;
	private String courseDescription;

	@Override
	public String toString() {
		return "Course [coursed=" + coursed + ", courseName=" + courseName + ", fee=" + fee + ", courseDescription="
				+ courseDescription + "]";
	}

	public Course(int coursed, String courseName, int fee, String courseDescription) {
		super();
		this.coursed = coursed;
		this.courseName = courseName;
		this.fee = fee;
		this.courseDescription = courseDescription;
	}

	public Course() {

	}

	public int getCoursed() {
		return coursed;
	}

	public void setCoursed(int coursed) {
		this.coursed = coursed;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public int getFee() {
		return fee;
	}

	public void setFee(int fee) {
		this.fee = fee;
	}

	public String getCourseDescription() {
		return courseDescription;
	}

	public void setCourseDescription(String courseDescription) {
		this.courseDescription = courseDescription;
	}

}
