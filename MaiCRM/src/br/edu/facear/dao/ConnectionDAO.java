package br.edu.facear.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDAO{
	
	private Connection c;
	private String driver, url;
	
	public ConnectionDAO(){
		this.driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
		this.url="jdbc:sqlserver://localhost:1433";
	}
	
	public Connection getConnection(String username, String password){
		try{
			Class.forName(driver);
			try{
				this.c = DriverManager.getConnection(url, username, password);
				return this.c;
			}catch(SQLException e){
				System.out.println(e.getErrorCode()+ "/n" + e.getMessage());
			}
		}catch(ClassNotFoundException e){
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	public String getCatalog(){
		try{
			return c.getCatalog();
		}catch(SQLException e){
			System.out.println(e.getErrorCode()+ "/n" + e.getMessage());
		}
		return null;
	}
	
	public void setCatalog(String databasename){
		try{
			c.setCatalog(databasename);
		}catch(SQLException e){
			System.out.println(e.getErrorCode()+ "/n" + e.getMessage());
		}
	}
	
}
