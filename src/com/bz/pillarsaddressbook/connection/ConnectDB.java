package com.bz.pillarsaddressbook.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {
	
	final static String baseUrl = "jdbc:mysql:";
	final static String hostUrl = "localhost:3306";
	final static String userName = "root";
	final static String password = "Lambop@12345";
	final static String dbName = "Pillars";
	
	static ConnectDB instance = new ConnectDB();
	
	private ConnectDB() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static ConnectDB getInstance() {
		return instance;
	}
	
	public static Connection getConnection() {
		StringBuilder builder = new StringBuilder();
		builder.append(baseUrl).append("//").append(hostUrl).append("/").append(dbName);
		String url = builder.toString();
		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Pillars","root","Lambop@12345");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;	
	}
	
	
}
