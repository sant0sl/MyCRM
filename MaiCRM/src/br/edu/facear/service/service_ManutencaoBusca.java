package br.edu.facear.service;

import java.sql.SQLException;
import java.util.List;

import br.edu.facear.dao.ManutencaoBuscaDAO;
import br.edu.facear.model.ManutencaoBusca;

public class service_ManutencaoBusca {

	private ManutencaoBuscaDAO mbDao;
	
	public service_ManutencaoBusca() {
		mbDao = new ManutencaoBuscaDAO();
	}
	
	public List<ManutencaoBusca> listarManutencao() throws SQLException{
		return mbDao.Read();
	}
	
	public List<ManutencaoBusca> listarManutencaoNomeCliente(String nome_cliente) throws SQLException{
		return mbDao.FiltrarNomeCliente(nome_cliente);
	}
	
	public List<ManutencaoBusca> listarManutencaoData(String data) throws SQLException{
		return mbDao.FiltrarData(data);
	}
	
	public List<ManutencaoBusca> listarManutencaoStatus(Integer status) throws SQLException{
		return mbDao.FiltrarStatus(status);
	}
	
}
