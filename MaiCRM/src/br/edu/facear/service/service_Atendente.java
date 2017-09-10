package br.edu.facear.service;

import java.sql.SQLException;
import java.util.List;

import br.edu.facear.dao.AtendenteDAO;
import br.edu.facear.model.Atendente;

public class service_Atendente {

	private AtendenteDAO aDao;
	
	public service_Atendente() {
		aDao = new AtendenteDAO();
	}
	
	public Atendente autenticarAtendente(String cpf, String senha) throws SQLException{
		return aDao.AutenticarAtendente(cpf, senha);
	}
	
	public void cadastrarAtendente(Atendente a) throws SQLException{
		if(a!=null) {
			aDao.Create(a);
		}
	}
	
	public void alterarAtendente(Atendente a) throws SQLException{
		if(a!=null) {
			aDao.Update(a);
		}
	}
	
	public List<Atendente> listarAtendente() throws SQLException{
		return aDao.Read();
	}
	
	public Atendente ConsultaPorID(Integer id) throws SQLException{
		return aDao.ByID(id);
	}
}
