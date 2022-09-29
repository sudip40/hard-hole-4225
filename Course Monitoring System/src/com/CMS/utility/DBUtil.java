package com.CMS.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
public static Connection provideConnction() {
	Connection conn=null;
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
    String url="jdbc:mysql://localhost:3306/cms";
    
    try {
		conn=DriverManager.getConnection(url,"root","sudip@1234");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return conn;
}
}
