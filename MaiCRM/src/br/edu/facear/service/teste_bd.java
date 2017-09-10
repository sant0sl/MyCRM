package br.edu.facear.service;

import br.edu.facear.dao.GenericDAO;

public class teste_bd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		GenericDAO gd = new GenericDAO();
		gd.openConnection();
		gd.closeConnection();
		
	}

}
