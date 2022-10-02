package com.CMS.bean;

public class DayWisePlanner {
	private String Date;
	private int FacultyId;
	private int Morning;
	private int Afternoon;
	private int Evening;

	public DayWisePlanner(String date, int facultyId, int morning, int afternoon, int evening) {
		super();
		Date = date;
		FacultyId = facultyId;
		Morning = morning;
		Afternoon = afternoon;
		Evening = evening;
	}

	public DayWisePlanner() {

	}

	public String getDate() {
		return Date;
	}

	public void setDate(String date) {
		Date = date;
	}

	public int getFacultyId() {
		return FacultyId;
	}

	public void setFacultyId(int facultyId) {
		FacultyId = facultyId;
	}

	public int getMorning() {
		return Morning;
	}

	public void setMorning(int morning) {
		Morning = morning;
	}

	public int getAfternoon() {
		return Afternoon;
	}

	public void setAfternoon(int afternoon) {
		Afternoon = afternoon;
	}

	public int getEvening() {
		return Evening;
	}

	public void setEvening(int evening) {
		Evening = evening;
	}
}
