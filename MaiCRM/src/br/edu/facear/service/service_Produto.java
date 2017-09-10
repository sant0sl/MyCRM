package br.edu.facear.service;

import java.sql.SQLException;
import java.util.List;

import br.edu.facear.dao.ProdutoDAO;
import br.edu.facear.model.Produto;

public class service_Produto {

	private ProdutoDAO pDao;
	
	public service_Produto() {
		pDao = new ProdutoDAO();
	}
	
	public void cadastrarProduto(Produto p) throws SQLException{
		if(p!=null) {
			pDao.Create(p);
		}
	}
	
	public void alterarProduto(Produto p) throws SQLException{
		if(p!=null) {
			pDao.Update(p);
		}
	}
	
	public List<Produto> listarProduto() throws SQLException{
		return pDao.Read();
	}
}
