package controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import utils.DatabaseConfig;

public class DAO {
	private String className = DatabaseConfig.DATABASE_CLASS;
	private String dbName = DatabaseConfig.DATABASE_NAME;
	private String username = DatabaseConfig.USERNAME;
	private String password = DatabaseConfig.PASSWORD;
	private Connection con;
	public DAO() {
		
	}
	
	public Statement connect() {
		try {
			Class.forName(className);
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+dbName, username, password);
			Statement stm = con.createStatement();
			return stm;
			
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}
	
	public void closeConnection() {
		try {
			con.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	
}
