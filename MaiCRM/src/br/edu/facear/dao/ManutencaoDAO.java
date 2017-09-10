package br.edu.facear.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import br.edu.facear.model.Manutencao;
import br.edu.facear.util.iCRUD;

public class ManutencaoDAO extends GenericDAO implements iCRUD<Manutencao>{

	PreparedStatement ps;
	
	@Override
	public void Create(Manutencao m) throws SQLException {
		openConnection();
		String sql = "INSERT INTO manutencao(id_manutencao, produto_id, servico_id, status, atendente_cpf, cliente_cpf, data) VALUES(?,?,?,?,?,?,?)";
		ps = c.prepareStatement(sql);
		ps.setInt(1, m.getId());
		ps.setInt(2, m.getProduto_id());
		ps.setInt(3, m.getServico_id());
		ps.setInt(4, m.getStatus());
		ps.setString(5, m.getAtendente_cpf());
		ps.setString(6, m.getCliente_cpf());
		ps.setString(7, m.getData());
		ps.execute();
		ps.close();
		closeConnection();
	}

	@Override
	public void Update(Manutencao m) throws SQLException {
		//Tem não
	}

	@Override
	public List<Manutencao> Read() throws SQLException {
		//Não tem
		return null;
	}
	
}
