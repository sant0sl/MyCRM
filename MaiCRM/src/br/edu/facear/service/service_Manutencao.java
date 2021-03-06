package br.edu.facear.service;

import java.sql.SQLException;

import br.edu.facear.dao.ManutencaoDAO;
import br.edu.facear.model.Manutencao;

public class service_Manutencao {

	private ManutencaoDAO mDao;
	
	public service_Manutencao() {
		mDao = new ManutencaoDAO();
	}
	
	public void cadastrarManutencao(Manutencao m) throws SQLException{
		if(m!=null) {
			mDao.Create(m);
		}
	}
	
	public void alterarManutencao(Manutencao m) throws SQLException{
		if(m!=null) {
			mDao.Update(m);
		}
	}
	
	public Manutencao ConsultaPorID(Integer id) throws SQLException{
		return mDao.ByID(id);
	}
}
