package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {
	private static final String URL= "jdbc:mysql://localhost:3306/homework";
	private static final String USER = "root";
	private static final String PASSWORD ="1234";
	
	public static Connection getDb() {
		Connection cn=null;
		   try {
	           Class.forName("com.mysql.cj.jdbc.Driver");
	           cn =  DriverManager.getConnection(URL,USER,PASSWORD);
		   }catch(Exception ex) {
			  System.out.println("connect() error:"+ex.getMessage());   
		   }
		return cn;
	}
	public static void main(String[] args) {
		DbConnection.getDb();
	}

}
