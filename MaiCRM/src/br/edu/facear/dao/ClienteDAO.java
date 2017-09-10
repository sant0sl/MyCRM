package br.edu.facear.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.facear.model.Cliente;
import br.edu.facear.util.iCRUD;

public class ClienteDAO extends GenericDAO implements iCRUD<Cliente>{

	PreparedStatement ps;
	
	@Override
	public void Create(Cliente cli) throws SQLException {
		openConnection();
		String sql = "INSERT INTO cliente(id_cliente, nome, cpf) VALUES(?,?,?)";
		ps = c.prepareStatement(sql);
		ps.setInt(1, cli.getId());
		ps.setString(2, cli.getNome());
		ps.setString(3, cli.getCpf());
		ps.execute();
		ps.close();
		closeConnection();
	}

	@Override
	public void Update(Cliente cli) throws SQLException {
		openConnection();
		String sql = "UPDATE cliente SET nome=?, cpf=? WHERE id_cliente=?";
		ps = c.prepareStatement(sql);
		ps.setString(1, cli.getCpf());
		ps.setString(2, cli.getCpf());
		ps.executeUpdate();
		ps.close();
		closeConnection();
	}

	@Override
	public List<Cliente> Read() throws SQLException {
		openConnection();
		List<Cliente> listadeclientes = new ArrayList<>();
		String sql = "SELECT * FROM cliente";
		ps = c.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		if(rs != null){
			while(rs.next()){
				Cliente cli = new Cliente(rs.getInt("id_cliente"), rs.getString("nome"), rs.getString("cpf"));
				listadeclientes.add(cli);
			}
		}
		closeConnection();
		return listadeclientes;
	}

}
