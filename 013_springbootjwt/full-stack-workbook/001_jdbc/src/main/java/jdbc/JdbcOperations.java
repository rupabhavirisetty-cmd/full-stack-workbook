package jdbc;

import java.sql.*;

public class JdbcOperations {

	public static void main(String[] args) throws Exception  {
		// TODO Auto-generated method stub
		//System.out.println("Hello World!");
		
		String URL = "jdbc:mysql://localhost:3306/fsad";
		String userName = "root";
		String dbPassword = "Pwd@1292";
		
		//Initialize the MySQL Driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//Create Connection
		Connection con = DriverManager.getConnection(URL, userName, dbPassword);
		
		//Perform CRUD Operations
		
		//String qry = "INSERT INTO STUDENTS VALUES(?,?,?)";
		//PreparedStatement ps = con.prepareStatement(qry);
		
		//Assign values to the Parameters
		//ps.setInt(1, 1003);
		//ps.setString(2, "XXXXXX");
		//ps.setString(3, "CSE");
		
		//UPDATE Operation
		//String qry = "UPDATE STUDENTS SET NAME=?,DEPT=? WHERE ROLLNO=?";
		//PreparedStatement ps = con.prepareStatement(qry);
		
		//Assign Values
		//ps.setString(1, "PADMANABAN K");
		//ps.setString(2, "ECE");
		//ps.setInt(3, 1001);
		
		//DELETE Operation
		//String qry = "DELETE FROM STUDENTS WHERE ROLLNO=?";
		//PreparedStatement ps = con.prepareStatement(qry);
		
		//Assign values
		//ps.setInt(1, 1001);
		
		
		//Execute the Query
		//ps.execute();
			
		//Acknowledgement
		//System.out.println("Done");
		
		//READ Operation
		String qry = "SELECT * FROM STUDENTS";
		PreparedStatement ps = con.prepareStatement(qry);
		
		ResultSet rs = ps.executeQuery();
		while(rs.next())
		{
			System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3));
		}
		
		con.close(); //Closing the connection with database
	}

}
