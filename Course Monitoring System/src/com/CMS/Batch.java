package com.CMS;

public class Batch {
	private int batchId;
	private int courseId;
	private int facultyId;
	private int numberofStudents;
	private String batchstartDate;
	private String duration;

	public Batch(int batchId, int courseId, int facultyId, int numberofStudents, String batchstartDate,
			String duration) {
		super();
		this.batchId = batchId;
		this.courseId = courseId;
		this.facultyId = facultyId;
		this.numberofStudents = numberofStudents;
		this.batchstartDate = batchstartDate;
		this.duration = duration;
	}

}
