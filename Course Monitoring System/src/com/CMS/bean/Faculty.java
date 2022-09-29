package com.CMS.bean;

public class Faculty {
	private int facultyid;
	private String facultyname;
	private String facultyaddress;
	private String mobile;
	private String email;
	private String username;
	private String password;

	public Faculty(int facultyid, String facultyname, String facultyaddress, String mobile, String email,
			String username, String password) {
		super();
		this.facultyid = facultyid;
		this.facultyname = facultyname;
		this.facultyaddress = facultyaddress;
		this.mobile = mobile;
		this.email = email;
		this.username = username;
		this.password = password;
	}

}
