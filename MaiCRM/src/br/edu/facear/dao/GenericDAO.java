package br.edu.facear.dao;

import java.sql.Connection;
import java.sql.SQLException;

public class GenericDAO {

	private ConnectionDAO db = new ConnectionDAO();
	protected Connection c;
	
	public void openConnection(){
		c = db.getConnection("leonardosantos", "123456");
		db.setCatalog("mycrm");
		if(c != null) {
			System.out.println("Ha, coisa lindra!");
		}else {
			System.out.println("Open failed");
		}
	}
	
	public void closeConnection(){
		if(c != null){
			try{
				c.close();
				System.out.println("Conexão Fechada!");
			}catch(SQLException e){
				System.out.println(e.getErrorCode());
				System.out.println(e.getMessage());
			}
		}
	}
	
}
