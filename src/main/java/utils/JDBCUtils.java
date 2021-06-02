package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCUtils {
	public static Connection getConnerction() throws SQLException,
	ClassNotFoundException{
		Class.forName("com.mysql.jdbc.Driver");
		String url="jdbc:mysql://127.0.0.1:3306/javaweb_blog";
		String username="root";
		String password="root";
		Connection conn=DriverManager.getConnection(url,username,password);
		return conn;	
	}
   public static void relesae(Statement stmt,Connection conn) {
	   if(stmt!=null) {
		   try {
			   stmt.close();
		   }catch(SQLException e) {
			   e.printStackTrace();
		   }
		  stmt=null;
	   }
	   if(conn!=null) {
		   try {
			   conn.close();
		   }catch(SQLException e) {
			   e.printStackTrace();
		   }
		   conn=null;
	   }
   }
   public static void relesae(ResultSet rs,Statement stmt,Connection conn) {
	   if(rs!=null) {
		   try {
			   rs.close();
		   }catch(SQLException e) {
			   e.printStackTrace();
		   }
		   rs=null;
	   }
	   relesae(stmt,conn);
   }
}
