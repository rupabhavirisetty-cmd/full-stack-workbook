package model;

import java.sql.*;

public class StudentsManager {
	String URL = "jdbc:mysql://localhost:3306/fsad";
	String userName = "root";
	String dbPwd = "Pwd@1292";
	
	//INSERT OPERATION
	public String insertData(Students S) throws Exception
	{
		//Initialize the driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		//Establish the Connection
		Connection con = DriverManager.getConnection(URL, userName, dbPwd);
		//INSERT OPERATION
		String qry = "INSERT INTO STUDENTS VALUES(?,?,?)";
		PreparedStatement ps = con.prepareStatement(qry);
		//Assign Values
		ps.setInt(1, S.getRollno());
		ps.setString(2, S.getName());
		ps.setString(3, S.getDept());
		
		ps.execute();
		
		return "Record has been inserted successfully";
	}
}
