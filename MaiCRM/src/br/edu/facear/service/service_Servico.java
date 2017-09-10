package br.edu.facear.service;

import java.sql.SQLException;
import java.util.List;

import br.edu.facear.dao.ServicoDAO;
import br.edu.facear.model.Servico;

public class service_Servico {

	private ServicoDAO sDao;
	
	public service_Servico() {
		sDao = new ServicoDAO();
	}
	
	public void cadastrarServico(Servico s) throws SQLException{
		if(s!=null) {
			sDao.Create(s);
		}
	}
	
	public void alterarServico(Servico s) throws SQLException{
		if(s!=null) {
			sDao.Update(s);
		}
	}
	
	public List<Servico> listarServico() throws SQLException{
		return sDao.Read();
	}
}
