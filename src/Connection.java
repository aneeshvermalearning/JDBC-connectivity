/*
 * A simple JDBC connection for just understanding how will basic functionality be
 * This is without JSP or Servlets
 * 
 * */
import java.sql.*;
/*
 * Initially mysql is used .
 * Will be replaced by oracle in next commit
 * 
 * */
public class Connection {
	//static String url = null;
	static String user = "root"; // username of phpmyadmin .. replace username
	static String password = "toor"; // password of phpmyadmin .. replace password
	
	public static void connect() {
		String sql = "insert into test values('"+6+"' , '"+80+"' , '"+21+"' )"; // sql query
		java.sql.Connection  con = null; // java.sql.Connection because className is also Connection
										// if any other class name then 
									    // Connection  con = null;
		
		try{
			Class.forName("com.mysql.jdbc.Driver");		// mysql server
			con =  DriverManager.getConnection("jdbc:mysql://localhost:3306/new_test","root","toor");
			Statement stmt = con.createStatement();
			int res = stmt.executeUpdate(sql);
			if(res == 1){
                System.out.println("inserted successfully : "+sql);
			}
			else{
                System.out.println("insertion failed");
                con.close();
			}
		}
		catch(Exception E){
            System.err.println(E);
		}
			
	}
	public static void main(String[] args) {
		connect();
	}

}
