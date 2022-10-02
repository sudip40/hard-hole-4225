package com.CMS.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.CMS.bean.CoursPlan;
import com.CMS.bean.DayWisePlanner;
import com.CMS.exceptions.CoursPlanException;
import com.CMS.exceptions.FacultyException;
import com.CMS.use.Faculty;
import com.CMS.utility.DBUtil;
import com.CMS.use.Faculty;
public class FacultyImps implements Facultyuserdao{
	@Override
	public List<CoursPlan> viewCoursePlan(String usrnm) throws CoursPlanException,FacultyException{
		
		List<CoursPlan> ls=new ArrayList<CoursPlan>();
		try (Connection conn = DBUtil.provideConnction()) {
			PreparedStatement p = conn.prepareStatement("select cp.planId,cp.batchId,cp.daynumber,cp.topic,cp.status from Coursplan cp INNER JOIN Batch b INNER JOIN Faculty f ON f.facultyid=b.facultyid AND b.batchid=cp.batchid Where f.username=?");
			p.setString(1,usrnm);
			ResultSet rs = p.executeQuery();
				while(rs.next()) {
					CoursPlan cp = new CoursPlan();
					int id = rs.getInt("planId");
					int bid = rs.getInt("batchId");
					int dn = rs.getInt("daynumber");
					String t = rs.getString("topic");
					String s = rs.getString("status");
					cp.setPlanId(id);
					cp.setBatchId(bid);
					cp.setDaynumber(dn);
					cp.setTopic(t);
					cp.setStatus(s);
					ls.add(cp);
				}
				
		} catch (SQLException e) {
			throw new CoursPlanException(e.getMessage());
		}
		if(ls.size()>0) {
			return ls;
		}
		else {
			throw new FacultyException("No Course is Allotade For This Faculty");
		}
	}
	@Override
	public String updatePassword(String un,String pass) {
		String messege = "Invalid Faculty Username";
		try (Connection conn = DBUtil.provideConnction()) {
			PreparedStatement p = conn.prepareStatement("update faculty set password=? where username=?");
			p.setString(1, pass);
			p.setString(2, un);
			int n = p.executeUpdate();
			if (n > 0) {
				messege = "Faculty Password Updated Successfully !";
			}
		} catch (SQLException e) {
			messege = e.getMessage();
		}

		return messege;
	}

	@Override
	public boolean login(String un,String pass,int id) {
		boolean flag=false;
		try (Connection conn = DBUtil.provideConnction()) {
			PreparedStatement p = conn
					.prepareStatement("select * from faculty where username=? AND password=? AND facultyid=?");
			p.setString(1,un);
			p.setString(2,pass);
			p.setInt(3, id);
			ResultSet rs = p.executeQuery();
			if (rs.next()) {
				flag = true;
			}
		} catch (SQLException e) {
			e.getMessage();
		}

		return flag;
	}

	@Override
	public String fillDayWisePlanner(DayWisePlanner dwp) {
		String messege = "Day wise plan not inserted !";
		try (Connection conn = DBUtil.provideConnction()) {
			PreparedStatement p = conn.prepareStatement("insert into daywiseplanner values(?,?,?,?,?)");
			p.setString(1, dwp.getDate());
			p.setInt(2, dwp.getFacultyId());
			p.setInt(3, dwp.getMorning());
			p.setInt(4, dwp.getAfternoon());
			p.setInt(5, dwp.getEvening());
			int n = p.executeUpdate();
			if (n > 0) {
				messege = "Day wise plan inserted Successfully !";
			}
		} catch (SQLException e) {
			messege = e.getMessage();
		}

		return messege;
	}

}
