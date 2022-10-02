package com.CMS.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
import com.CMS.utility.DBUtil;

public class AdminImps implements Adminuserdao {

	@Override
	public String createCourse(Course course) {
		String messege = "Course Not Created...";
		try (Connection conn = DBUtil.provideConnction()) {
			PreparedStatement p = conn
					.prepareStatement("insert into course(courseName,fee,courseDescription) values(?,?,?)");
			p.setString(1, course.getCourseName());
			p.setInt(2, course.getFee());
			p.setString(3, course.getCourseDescription());
			int n = p.executeUpdate();
			if (n > 0) {
				messege = "Course Inserted Successfully !";
			}
		} catch (SQLException e) {
			messege = e.getMessage();
		}

		return messege;
	}

	@Override
	public String removeCourseByCourseId(int id) {
		String messege = "Course Not Removed (The Course is in use / Invalid Course Id)";
		try (Connection conn = DBUtil.provideConnction()) {
			PreparedStatement p = conn.prepareStatement("delete from course where coursed=?");
			p.setInt(1, id);
			int n = p.executeUpdate();
			if (n > 0) {
				messege = "Course Removed Successfully !";
			}
		} catch (SQLException e) {
			messege = e.getMessage();
		}

		return messege;

	}

	@Override
	public String removeCourseByCourseName(String name) {
		String messege = "Course Not Removed (The Course is in use / Invalid Course Name)";
		try (Connection conn = DBUtil.provideConnction()) {
			PreparedStatement p = conn.prepareStatement("delete from course where courseName=?");
			p.setString(1, name);
			int n = p.executeUpdate();
			if (n > 0) {
				messege = "Course Removed Successfully !";
			}
		} catch (SQLException e) {
			messege = e.getMessage();
		}

		return messege;
	}

	@Override
	public String updateCouseNameById(int id, String name) {
		String messege = "Invalid Course Id";
		try (Connection conn = DBUtil.provideConnction()) {
			PreparedStatement p = conn.prepareStatement("update course set courseName=? where coursed=?");
			p.setString(1, name);
			p.setInt(2, id);
			int n = p.executeUpdate();
			if (n > 0) {
				messege = "Course Name Updated Successfully !";
			}
		} catch (SQLException e) {
			messege = e.getMessage();
		}

		return messege;
	}

	@Override
	public String updateCouseNameByCourseName(String on, String nn) {
		String messege = "Invalid Course Name";
		try (Connection conn = DBUtil.provideConnction()) {
			PreparedStatement p = conn.prepareStatement("update course set courseName=? where courseName=?");
			p.setString(1, nn);
			p.setString(2, on);
			int n = p.executeUpdate();
			if (n > 0) {
				messege = "Course Name Updated Successfully !";
			}
		} catch (SQLException e) {
			messege = e.getMessage();
		}

		return messege;
	}

	@Override
	public String updateCourseFeeByCourseFee(int of, int fee) {
		String messege = "Invalid Course Fee";
		try (Connection conn = DBUtil.provideConnction()) {
			PreparedStatement p = conn.prepareStatement("update course set fee=? where fee=?");
			p.setInt(1, fee);
			p.setInt(2, of);
			int n = p.executeUpdate();
			if (n > 0) {
				messege = "Course Fee Updated Successfully !";
			}
		} catch (SQLException e) {
			messege = e.getMessage();
		}

		return messege;
	}

	@Override
	public String updateCourseFeeByCourseName(String name, int fee) {
		String messege = "Invalid Course Name";
		try (Connection conn = DBUtil.provideConnction()) {
			PreparedStatement p = conn.prepareStatement("update course set fee=? where courseName=?");
			p.setInt(1, fee);
			p.setString(2, name);
			int n = p.executeUpdate();
			if (n > 0) {
				messege = "Course Fee Updated Successfully !";
			}
		} catch (SQLException e) {
			messege = e.getMessage();
		}

		return messege;
	}

	@Override
	public String updateCourseFeeByCourseId(int id, int fee) {
		String messege = "Invalid Course Id";
		try (Connection conn = DBUtil.provideConnction()) {
			PreparedStatement p = conn.prepareStatement("update course set fee=? where coursed=?");
			p.setInt(1, fee);
			p.setInt(2, id);
			int n = p.executeUpdate();
			if (n > 0) {
				messege = "Course Fee Updated Successfully !";
			}
		} catch (SQLException e) {
			messege = e.getMessage();
		}

		return messege;
	}

	@Override
	public String updateCourseDescriptionByName(String name, String desc) {
		String messege = "Invalid Course Name";
		try (Connection conn = DBUtil.provideConnction()) {
			PreparedStatement p = conn.prepareStatement("update course set courseDescription=? where courseName=?");
			p.setString(1, desc);
			p.setString(2, name);
			int n = p.executeUpdate();
			if (n > 0) {
				messege = "Course Description Updated Successfully !";
			}
		} catch (SQLException e) {
			messege = e.getMessage();
		}

		return messege;
	}

	@Override
	public String updateCourseDescriptionById(int id, String desc) {
		String messege = "Invalid Course Id";
		try (Connection conn = DBUtil.provideConnction()) {
			PreparedStatement p = conn.prepareStatement("update course set courseDescription=? where coursed=?");
			p.setString(1, desc);
			p.setInt(2, id);
			int n = p.executeUpdate();
			if (n > 0) {
				messege = "Course Description Updated Successfully !";
			}
		} catch (SQLException e) {
			messege = e.getMessage();
		}

		return messege;
	}

	@Override
	public List<Course> viewAllCourse() throws CourseException {
		List<Course> ls = new ArrayList<Course>();
		try (Connection conn = DBUtil.provideConnction()) {
			PreparedStatement p = conn.prepareStatement("select * from course");

			ResultSet rs = p.executeQuery();
			while (rs.next()) {

				int id = rs.getInt("coursed");
				String name = rs.getString("courseName");
				int fee = rs.getInt("fee");
				String desc = rs.getString("courseDescription");

				Course c = new Course(id, name, fee, desc);

				ls.add(c);
			}

		} catch (SQLException e) {
			throw new CourseException(e.getMessage());
		}
		if (ls.size() == 0) {
			throw new CourseException("No Course Found...");
		}

		return ls;

	}

	@Override
	public Course viewCourseByCourseName(String cname) throws CourseException {
		Course c = new Course();
		try (Connection conn = DBUtil.provideConnction()) {
			PreparedStatement p = conn.prepareStatement("select * from course where courseName=?");
			p.setString(1, cname);
			ResultSet rs = p.executeQuery();
			if (rs.next()) {
				int id = rs.getInt("coursed");
				String name = rs.getString("courseName");
				int fee = rs.getInt("fee");
				String desc = rs.getString("courseDescription");
				c.setCoursed(id);
				c.setCourseName(name);
				c.setFee(fee);
				c.setCourseDescription(desc);
			} else {
				throw new CourseException("Invalid Course Name");
			}

		} catch (SQLException e) {
			throw new CourseException(e.getMessage());
		}
		return c;

	}

	@Override
	public Course viewCourseByCourseID(int cid) throws CourseException {
		Course c = new Course();
		try (Connection conn = DBUtil.provideConnction()) {
			PreparedStatement p = conn.prepareStatement("select * from course where coursed=?");
			p.setInt(1, cid);
			ResultSet rs = p.executeQuery();
			if (rs.next()) {
				int id = rs.getInt("coursed");
				String name = rs.getString("courseName");
				int fee = rs.getInt("fee");
				String desc = rs.getString("courseDescription");
				c.setCoursed(id);
				c.setCourseName(name);
				c.setFee(fee);
				c.setCourseDescription(desc);
			} else {
				throw new CourseException("Invalid Course Id");
			}

		} catch (SQLException e) {
			throw new CourseException(e.getMessage());
		}
		return c;
	}

	@Override
	public String createBatch(Batch b) {
		String messege = "Batch Not Created...";
				try(Connection conn = DBUtil.provideConnction()) {
					PreparedStatement p = conn.prepareStatement(
							"insert into batch(courseId,facultyId,numberofStudents,batchstartDate,duration) values(?,?,?,?,?)");
					p.setInt(1, b.getCourseId());
					p.setInt(2, b.getFacultyId());
					p.setInt(3, b.getNumberofStudents());
					p.setString(4, b.getBatchstartDate());
					p.setString(5, b.getDuration());
					int n = p.executeUpdate();
					if (n > 0) {
						messege = "Batch Created Successfully !";
					}
				} catch (SQLException e) {
					messege = e.getMessage();
				}
		return messege;
	}

	@Override
	public String updateBatchnumberofStudents(int id, int nos) {
		String messege = "Invalid Batch Id";
		try (Connection conn = DBUtil.provideConnction()) {
			PreparedStatement p = conn.prepareStatement("update batch set numberofStudents=? where batchId=?");
			p.setInt(1, nos);
			p.setInt(2, id);
			int n = p.executeUpdate();
			if (n > 0) {
				messege = "Number of Students Updated Successfully !";
			}
		} catch (SQLException e) {
			messege = e.getMessage();
		}

		return messege;
	}

	@Override
	public String updateBatchduration(int id, String duration) {
		String messege = "Invalid Batch Id";
		try (Connection conn = DBUtil.provideConnction()) {
			PreparedStatement p = conn.prepareStatement("update batch set duration=? where batchId=?");
			p.setString(1, duration);
			p.setInt(2, id);
			int n = p.executeUpdate();
			if (n > 0) {
				messege = "Duration Updated Successfully !";
			}
		} catch (SQLException e) {
			messege = e.getMessage();
		}

		return messege;
	}

	@Override
	public String updateBatchbatchstartDate(int id, String date) {
		String messege = "Invalid Batch Id";
		try (Connection conn = DBUtil.provideConnction()) {
			PreparedStatement p = conn.prepareStatement("update batch set batchstartDate=? where batchId=?");
			p.setString(1, date);
			p.setInt(2, id);
			int n = p.executeUpdate();
			if (n > 0) {
				messege = "Batch Start Date Updated Successfully !";
			}
		} catch (SQLException e) {
			messege = e.getMessage();
		}

		return messege;
	}

	@Override
	public List<Batch> viewAllBatch() throws BatchException {
		List<Batch> ls = new ArrayList<Batch>();
		try (Connection conn = DBUtil.provideConnction()) {
			PreparedStatement p = conn.prepareStatement("select * from batch");

			ResultSet rs = p.executeQuery();
			while (rs.next()) {

				int bid = rs.getInt("batchId");
				int cid = rs.getInt("courseId");
				int fid = rs.getInt("facultyId");
				int nos = rs.getInt("numberofStudents");
				String sdate = rs.getString("batchstartDate");
				String duration = rs.getString("duration");

				Batch b = new Batch(bid, cid, fid, nos, sdate, duration);

				ls.add(b);
			}

		} catch (SQLException e) {
			throw new BatchException(e.getMessage());
		}
		if (ls.size() == 0) {
			throw new BatchException("No Course Found...");
		}

		return ls;

	}

	@Override
	public List<Course> viewCourseByBatchID(int id) throws BatchException{
		List<Course> ls = new ArrayList<Course>();
		try (Connection conn = DBUtil.provideConnction()) {
			PreparedStatement p = conn.prepareStatement("select c.coursed,c.courseName,c.fee,c.courseDescription course c INNER JOIN batch b ON c.coursed=b.courseId WHERE b.batchId=?");

			ResultSet rs = p.executeQuery();
			while (rs.next()) {

				int id1 = rs.getInt("coursed");
				String name = rs.getString("courseName");
				int fee = rs.getInt("fee");
				String desc = rs.getString("courseDescription");

				Course c = new Course(id1, name, fee, desc);

				ls.add(c);
			}

		} catch (SQLException e) {
			throw new BatchException(e.getMessage());
		}
		if (ls.size() == 0) {
			throw new BatchException("Incorrect Batch ID !");
		}

		return ls;
	}

	@Override
	public List<Faculty> viewFacultyByBatchID(int id) throws BatchException {
		List<Faculty> ls = new ArrayList<Faculty>();
		try (Connection conn = DBUtil.provideConnction()) {
			PreparedStatement p = conn.prepareStatement("select f.facultyid,f.facultyname,f.facultyaddress,f.mobile,f.email,f.username,f.password Faculty f INNER JOIN batch b ON f.facultyid=b.facultyid WHERE b.batchId=?");

			ResultSet rs = p.executeQuery();
			while (rs.next()) {

				int id1 = rs.getInt("facultyid");
				String name = rs.getString("facultyname");
				String add = rs.getString("facultyaddress");
				String mob = rs.getString("mobile");
				String email = rs.getString("email");
				String uname = rs.getString("username");

				Faculty f=new Faculty();
				f.setFacultyid(id1);
				f.setFacultyname(name);
				f.setFacultyaddress(add);
				f.setMobile(mob);
				f.setEmail(email);
				f.setUsername(uname);
				ls.add(f);
			}

		} catch (SQLException e) {
			throw new BatchException(e.getMessage());
		}
		if (ls.size() == 0) {
			throw new BatchException("Incorrect Batch ID !");
		}

		return ls;
	}

	@Override
	public String registerFaculty(Faculty f) {
		String messege = "Faculty Not Registerd...";
		try (Connection conn = DBUtil.provideConnction()) {
			PreparedStatement p = conn
					.prepareStatement("insert into faculty(facultyname,facultyaddress,mobile,email,username,password) values(?,?,?,?,?,?)");
			p.setString(1, f.getFacultyname());
			p.setString(2, f.getFacultyaddress());
			p.setString(3,f.getMobile());
			p.setString(4, f.getEmail());
			p.setString(5, f.getUsername());
			p.setString(6,f.getPassword());
			int n = p.executeUpdate();
			if (n > 0) {
				messege = "Faculty Registerd Successfully !";
			}
		} catch (SQLException e) {
			messege = e.getMessage();
		}

		return messege;
	}


	@Override
	public List<Faculty> viewAllFaculty() throws FacultyException {
		List<Faculty> ls = new ArrayList<Faculty>();
		try (Connection conn = DBUtil.provideConnction()) {
			PreparedStatement p = conn.prepareStatement("select * from batch");

			ResultSet rs = p.executeQuery();
			while (rs.next()) {

				int fi = rs.getInt("facultyid");
				String fn = rs.getString("facultyname");
				String fa = rs.getString("facultyaddress");
				String mob = rs.getString("mobile");
				String email = rs.getString("email");
				String un = rs.getString("username");

				Faculty f = new Faculty();
				f.setFacultyid(fi);
				f.setFacultyname(fn);
				f.setFacultyaddress(fa);
				f.setMobile(mob);
				f.setEmail(email);
				f.setUsername(un);

				ls.add(f);
			}

		} catch (SQLException e) {
			throw new FacultyException(e.getMessage());
		}
		if (ls.size() == 0) {
			throw new FacultyException("No Faculty Found...");
		}

		return ls;
	}
     
	
	@Override
	public List<Course> viewCourseByFacultyID(int fid) throws CourseException {
		List<Course> ls = new ArrayList<Course>();
		try (Connection conn = DBUtil.provideConnction()) {
			PreparedStatement p = conn.prepareStatement("select c.coursed,c.courseName,c.fee,c.courseDescription from course c INNER JOIN batch b ON c.coursed=b.courseId WHERE b.facultyId=?");
            p.setInt(1,fid);
			ResultSet rs = p.executeQuery();
			while (rs.next()) {

				int id = rs.getInt("coursed");
				String name = rs.getString("courseName");
				int fee = rs.getInt("fee");
				String desc = rs.getString("courseDescription");

				Course c = new Course(id, name, fee, desc);

				ls.add(c);
			}

		} catch (SQLException e) {
			throw new CourseException(e.getMessage());
		}
		if (ls.size() == 0) {
			throw new CourseException("No Course Found...");
		}

		return ls;

	}

	@Override
	public List<Batch> viewBatchByFacultyID(int fid) throws BatchException {
		List<Batch> ls = new ArrayList<Batch>();
		try (Connection conn = DBUtil.provideConnction()) {
			PreparedStatement p = conn.prepareStatement("select batchId,courseId,numberofStudents,batchstartDate,duration from batch WHERE facultyId=?");
            p.setInt(1,fid);
			ResultSet rs = p.executeQuery();
			while (rs.next()) {

				int bid = rs.getInt("batchId");
				int cid = rs.getInt("courseId");
				int nos = rs.getInt("numberofStudents");
				String bsd = rs.getString("batchstartDate");
                String duration = rs.getString("duration");
				Batch b = new Batch(bid,cid,fid,nos,bsd,duration);

				ls.add(b);
			}

		} catch (SQLException e) {
			throw new BatchException(e.getMessage());
		}
		if (ls.size() == 0) {
			throw new BatchException("No Batch Found...");
		}

		return ls;
	}

	@Override
	public String allocateFaculty(int bid,int fid) throws FacultyException,BatchException {
		String messege = "Invalid BatchId or FacultyId";
		try (Connection conn = DBUtil.provideConnction()){
			PreparedStatement p1 = conn.prepareStatement("select * from faculty where facultyId=?");
			PreparedStatement p2 = conn.prepareStatement("select * from batch where batchId=?");
			p1.setInt(1, fid);
			p2.setInt(1, bid);
			ResultSet rs1=p1.executeQuery();
			ResultSet rs2=p2.executeQuery();
			if(rs1.next() && rs2.next()) {
				try{
					PreparedStatement p = conn.prepareStatement("update batch set facultyId=? where batchId=?");
					p.setInt(1, fid);
					p.setInt(2, bid);
					int n = p.executeUpdate();
					if (n > 0) {
						messege = "Faculty Allocated Successfully !";
					}
				} catch (SQLException e) {
					messege = e.getMessage();
				}	
			}
			else if(rs1.next()) {
				throw new BatchException("Invalid Batch ID");
			}
			else if(rs2.next()) {
				throw new FacultyException("Invalid Faculty ID");
			}
		}
		catch (SQLException e) {
			messege = e.getMessage();
		}
		 

		return messege;
	}

	@Override
	public String createCoursePlan(CoursPlan cp) {
		String messege = "Course Plan Not Created...";
				try (Connection conn = DBUtil.provideConnction()){
					PreparedStatement pc = conn
							.prepareStatement("insert into CoursPlan(batchId,daynumber,topic,status) values(?,?,?,?)");
					pc.setInt(1,cp.getBatchId());
					pc.setInt(2,cp.getDaynumber());
					pc.setString(3,cp.getTopic());
					pc.setString(4,cp.getStatus());
					int n = pc.executeUpdate();
					if (n > 0) {
						messege = "Course Plan Created Successfully !";
					}	
				}
			catch (SQLException e) {
				messege = e.getMessage();
			}
		return messege;
	}

	@Override
	public String updateCoursePlanStatus(int pid,String s) {
		String messege = "Invalid Plan Id";
		try (Connection conn = DBUtil.provideConnction()) {
			PreparedStatement p = conn.prepareStatement("update CoursPlan set status=? where planId=?");
			p.setString(1, s);
			p.setInt(2, pid);
			int n = p.executeUpdate();
			if (n > 0) {
				messege = "Status Updated Successfully !";
			}
		} catch (SQLException e) {
			messege = e.getMessage();
		}

		return messege;
	}

	@Override
	public String removeCoursePlanById(int pid) {
		String messege = "Course Plan Not Removed (Invalid Course Id)";
		try (Connection conn = DBUtil.provideConnction()) {
			PreparedStatement p = conn.prepareStatement("delete from coursplan where planId=?");
			p.setInt(1, pid);
			int n = p.executeUpdate();
			if (n > 0) {
				messege = "Course Plan Removed Successfully !";
			}
		} catch (SQLException e) {
			messege = e.getMessage();
		}

		return messege;
	}

	@Override
	public List<CoursPlan> viewAllCoursePlan() throws CoursPlanException {
		List<CoursPlan> ls = new ArrayList<CoursPlan>();
		try (Connection conn = DBUtil.provideConnction()) {
			PreparedStatement p = conn.prepareStatement("select * from CoursPlan");

			ResultSet rs = p.executeQuery();
			while (rs.next()) {

				int pi = rs.getInt("planId");
				int bi = rs.getInt("batchId");
				int dn = rs.getInt("daynumber");
				String t = rs.getString("topic");
				String s = rs.getString("status");

				CoursPlan cp = new CoursPlan();
				cp.setPlanId(pi);
				cp.setBatchId(bi);
				cp.setDaynumber(dn);
				cp.setTopic(t);
				cp.setStatus(s);
				

				ls.add(cp);
			}

		} catch (SQLException e) {
			throw new CoursPlanException(e.getMessage());
		}
		if (ls.size() == 0) {
			throw new CoursPlanException("No CoursPlan Found...");
		}

		return ls;
	}

	@Override
	public CoursPlan viewCoursePlanByPlanID(int pid) throws CoursPlanException {
		CoursPlan cp = new CoursPlan();
		try (Connection conn = DBUtil.provideConnction()) {
			PreparedStatement p = conn.prepareStatement("select * from CoursPlan where planId=?");
			p.setInt(1, pid);
			ResultSet rs = p.executeQuery();
			if (rs.next()) {
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
			} else {
				throw new CoursPlanException("Invalid Plan Id");
			}

		} catch (SQLException e) {
			throw new CoursPlanException(e.getMessage());
		}
		return cp;
	}

	@Override
	public String removeBatchByBatchId(int id) {
		String messege = "Batch Not Removed (The Batch is in use / Invalid Batch Id)";
		try (Connection conn = DBUtil.provideConnction()) {
			PreparedStatement p = conn.prepareStatement("delete from batch where batchId=?");
			p.setInt(1, id);
			int n = p.executeUpdate();
			if (n > 0) {
				messege = "Batch Removed Successfully !";
			}
		} catch (SQLException e) {
			messege = e.getMessage();
		}

		return messege;
	}

	@Override
	public String removeFacultyByFacultyID(int id) {
		String messege = "Faculty Not Removed (The Faculty is in use / Invalid Faculty Id)";
		try (Connection conn = DBUtil.provideConnction()) {
			PreparedStatement p = conn.prepareStatement("delete from faculty where facultyid=?");
			p.setInt(1, id);
			int n = p.executeUpdate();
			if (n > 0) {
				messege = "Faculty Removed Successfully !";
			}
		} catch (SQLException e) {
			messege = e.getMessage();
		}

		return messege;
	}

	@Override
	public String updateFacultyName(int id,String name) {
		String messege = "Invalid Faculty Id";
		try (Connection conn = DBUtil.provideConnction()) {
			PreparedStatement p = conn.prepareStatement("update faculty set facultyname=? where facultyid=?");
			p.setString(1, name);
			p.setInt(2, id);
			int n = p.executeUpdate();
			if (n > 0) {
				messege = "Faculty Name Updated Successfully !";
			}
		} catch (SQLException e) {
			messege = e.getMessage();
		}

		return messege;
	}

	@Override
	public String updateFacultyAddress(int id,String add) {
		String messege = "Invalid Faculty Id";
		try (Connection conn = DBUtil.provideConnction()) {
			PreparedStatement p = conn.prepareStatement("update faculty set facultyaddress=? where facultyid=?");
			p.setString(1, add);
			p.setInt(2, id);
			int n = p.executeUpdate();
			if (n > 0) {
				messege = "Faculty Address Updated Successfully !";
			}
		} catch (SQLException e) {
			messege = e.getMessage();
		}

		return messege;
	}

	@Override
	public String updateFacultyEmail(int id,String email) {
		String messege = "Invalid Faculty Id";
		try (Connection conn = DBUtil.provideConnction()) {
			PreparedStatement p = conn.prepareStatement("update faculty set email=? where facultyid=?");
			p.setString(1, email);
			p.setInt(2, id);
			int n = p.executeUpdate();
			if (n > 0) {
				messege = "Faculty Email Updated Successfully !";
			}
		} catch (SQLException e) {
			messege = e.getMessage();
		}

		return messege;
	}

	@Override
	public String updateFacultyMobile(int id,String mob) {
		String messege = "Invalid Faculty Id";
		try (Connection conn = DBUtil.provideConnction()) {
			PreparedStatement p = conn.prepareStatement("update faculty set mobile=? where facultyid=?");
			p.setString(1, mob);
			p.setInt(2, id);
			int n = p.executeUpdate();
			if (n > 0) {
				messege = "Faculty Mobile Updated Successfully !";
			}
		} catch (SQLException e) {
			messege = e.getMessage();
		}

		return messege;
	}

	@Override
	public String updateFacultyUserName(int id,String un) {
		String messege = "Invalid Faculty Id";
		try (Connection conn = DBUtil.provideConnction()) {
			PreparedStatement p = conn.prepareStatement("update faculty set username=? where facultyid=?");
			p.setString(1, un);
			p.setInt(2, id);
			int n = p.executeUpdate();
			if (n > 0) {
				messege = "Faculty Username Updated Successfully !";
			}
		} catch (SQLException e) {
			messege = e.getMessage();
		}

		return messege;
	}

	@Override
	public String updateFacultyPassword(int id,String pass) {
		String messege = "Invalid Faculty Id";
		try (Connection conn = DBUtil.provideConnction()) {
			PreparedStatement p = conn.prepareStatement("update faculty set password=? where facultyid=?");
			p.setString(1, pass);
			p.setInt(2, id);
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
	public boolean login(String username, String pass) {
		boolean flag=false;
		try (Connection conn = DBUtil.provideConnction()) {
			PreparedStatement p = conn
					.prepareStatement("select * from admin where username=? AND password=?");
			p.setString(1,username);
			p.setString(2,pass);
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
	public List<DayWisePlanner> ViewDaywiseupdateofeverybatch() throws DayWisePlannerException {
		List<DayWisePlanner> ls=new ArrayList<DayWisePlanner>();
		try (Connection conn = DBUtil.provideConnction()) {
			PreparedStatement p = conn
					.prepareStatement("select * from daywiseplanner order by date");
			
			ResultSet rs = p.executeQuery();
			
			if (rs.next()) {
				while(rs.next()) {
					String date= rs.getString("date");
					int fid=rs.getInt("FacultyId");
					int m=rs.getInt("morning");
					int a=rs.getInt("afternoon");
					int e=rs.getInt("evening");
					DayWisePlanner dwp=new DayWisePlanner();
					dwp.setDate(date);
					dwp.setFacultyId(fid);
					dwp.setMorning(m);
					dwp.setAfternoon(a);
					dwp.setEvening(e);
					ls.add(dwp);
				}
			}
		} catch (SQLException e) {
			e.getMessage();
		}
		if(ls.size()>0) {
			return ls;
		}
		else {
			throw new DayWisePlannerException("No Result Found");
		}
	}

	@Override
	public List<CoursPlan> GenerateReportforeverybatch() throws CoursPlanException {
		List<CoursPlan> ls = new ArrayList<CoursPlan>();
		try (Connection conn = DBUtil.provideConnction()) {
			PreparedStatement p = conn.prepareStatement("select * from CoursPlan order by batchId");

			ResultSet rs = p.executeQuery();
			while (rs.next()) {

				int pi = rs.getInt("planId");
				int bi = rs.getInt("batchId");
				int dn = rs.getInt("daynumber");
				String t = rs.getString("topic");
				String s = rs.getString("status");

				CoursPlan cp = new CoursPlan();
				cp.setPlanId(pi);
				cp.setBatchId(bi);
				cp.setDaynumber(dn);
				cp.setTopic(t);
				cp.setStatus(s);
				

				ls.add(cp);
			}

		} catch (SQLException e) {
			throw new CoursPlanException(e.getMessage());
		}
		if (ls.size() == 0) {
			throw new CoursPlanException("No CoursPlan Found...");
		}

		return ls;	
	}

	
}
