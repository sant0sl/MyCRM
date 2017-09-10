package br.edu.facear.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import br.edu.facear.model.Manutencao;
import br.edu.facear.util.iCRUD;

public class ManutencaoDAO extends GenericDAO implements iCRUD<Manutencao>{

	PreparedStatement ps;
	private Manutencao m;
	
	@Override
	public void Create(Manutencao m) throws SQLException {
		openConnection();
		String sql = "INSERT INTO manutencao(produto_id, servico_id, status, atendente_cpf, cliente_cpf, data) VALUES(?,?,?,?,?,?)";
		ps = c.prepareStatement(sql);
		ps.setInt(1, m.getProduto_id());
		ps.setInt(2, m.getServico_id());
		ps.setInt(3, m.getStatus());
		ps.setString(4, m.getAtendente_cpf());
		ps.setString(5, m.getCliente_cpf());
		ps.setString(6, m.getData());
		ps.execute();
		ps.close();
		closeConnection();
	}

	@Override
	public void Update(Manutencao m) throws SQLException {
		openConnection();
		String sql = "UPDATE manutencao SET produto_id=?, servico_id=?, status=?, atendente_cpf=?, cliente_cpf=?, data=? WHERE id_manutencao=?";
		ps = c.prepareStatement(sql);
		ps.setInt(1, m.getProduto_id());
		ps.setInt(2, m.getServico_id());
		ps.setInt(3, m.getStatus());
		ps.setString(4, m.getAtendente_cpf());
		ps.setString(5, m.getCliente_cpf());
		ps.setString(6, m.getData());
		ps.setInt(7, m.getId());
		ps.executeUpdate();
		ps.close();
		closeConnection();
	}
	
	public Manutencao ByID(Integer id) throws SQLException{
		openConnection();
		Manutencao m = new Manutencao();
		String sql = "SELECT * FROM manutencao WHERE id_manutencao=?";
		ps = c.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		
		if(rs!=null) {
			while(rs.next()) {
				m.setId(rs.getInt("id_manutencao"));
				m.setProduto_id(rs.getInt("produto_id"));
				m.setServico_id(rs.getInt("servico_id"));
				m.setStatus(rs.getInt("status"));
				m.setAtendente_cpf(rs.getString("atendente_cpf"));
				m.setCliente_cpf(rs.getString("cliente_cpf"));
				m.setData(rs.getString("data"));
			}
		}
		
		closeConnection();
		return m;
	}

	@Override
	public List<Manutencao> Read() throws SQLException {
		//Não tem
		return null;
	}
	
}
