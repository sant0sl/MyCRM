package br.edu.facear.service;

import java.sql.SQLException;
import java.util.List;

import br.edu.facear.dao.ClienteDAO;
import br.edu.facear.model.Cliente;

public class service_Cliente {

	private ClienteDAO cDao;
	
	public service_Cliente() {
		cDao = new ClienteDAO();
	}
	
	public void cadastrarCliente(Cliente c) throws SQLException{
		if(c!=null) {
			cDao.Create(c);
		}
	}
	
	public void alterarCliente(Cliente c) throws SQLException{
		if(c!=null) {
			cDao.Update(c);
		}
	}
	
	public List<Cliente> listarCliente() throws SQLException{
		return cDao.Read();
	}
	
}
