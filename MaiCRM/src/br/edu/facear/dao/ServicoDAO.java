package br.edu.facear.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.facear.model.Servico;
import br.edu.facear.util.iCRUD;

public class ServicoDAO extends GenericDAO implements iCRUD<Servico> {

	PreparedStatement ps;
	
	@Override
	public void Create(Servico s) throws SQLException {
		openConnection();
		String sql = "INSERT INTO servico(nome) VALUES(?)";
		ps = c.prepareStatement(sql);
		ps.setString(1, s.getNome_servico());
		ps.execute();
		ps.close();
		closeConnection();
	}

	@Override
	public void Update(Servico s) throws SQLException {
		openConnection();
		String sql = "UPDATE servico SET nome=? WHERE id_servico=?";
		ps = c.prepareStatement(sql);
		ps.setString(1, s.getNome_servico());
		ps.setInt(2, s.getId());
		ps.executeUpdate();
		ps.close();
		closeConnection();
	}

	@Override
	public List<Servico> Read() throws SQLException {
		openConnection();
		List<Servico> listadeservico = new ArrayList<>();
		String sql = "SELECT * FROM servico";
		ps = c.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		if(rs != null){
			while(rs.next()){
				Servico s = new Servico(rs.getInt("id_servico"), rs.getString("nome"));
				listadeservico.add(s);
			}
		}
		closeConnection();
		return listadeservico;
	}

}
