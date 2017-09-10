package br.edu.facear.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.facear.model.Atendente;
import br.edu.facear.util.iCRUD;

public class AtendenteDAO extends GenericDAO implements iCRUD<Atendente>{

	PreparedStatement ps;
	
	@Override
	public void Create(Atendente a) throws SQLException {
		openConnection();
		String sql = "INSERT INTO atendente(id_atendente, nome, cpf, senha, supervisor) VALUES(?,?,?,?,?)";
		ps = c.prepareStatement(sql);
		ps.setInt(1, a.getId());
		ps.setString(2, a.getNome());
		ps.setString(3, a.getCpf());
		ps.setString(4, a.getCpf());
		ps.setBoolean(5, a.getSupervisor());
		ps.execute();
		ps.close();
		closeConnection();
	}

	@Override
	public void Update(Atendente a) throws SQLException {
		openConnection();
		String sql = "UPDATE atendente SET nome=?, cpf=?, senha=?, supervisor=? WHERE id_atendente=?";
		ps = c.prepareStatement(sql);
		ps.setString(1, a.getNome());
		ps.setString(2, a.getCpf());
		ps.setString(3, a.getSenha());
		ps.setBoolean(4, a.getSupervisor());
		ps.setInt(5, a.getId());
		ps.executeUpdate();
		ps.close();
		closeConnection();
	}
	
	@Override
	public List<Atendente> Read() throws SQLException {
		openConnection();
		List<Atendente> listafuncionarios = new ArrayList<>();
		String sql = "SELECT * FROM atendente";
		ps = c.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		if(rs != null){
			while(rs.next()){
				Atendente at = new Atendente(rs.getInt("id_atendente"), rs.getString("nome"), rs.getString("cpf"), rs.getString("senha"), rs.getBoolean("supervisor"));
				listafuncionarios.add(at);
			}
		}
		closeConnection();
		return listafuncionarios;
	}
	
	public Atendente AutenticarAtendente(String cpf, String senha) throws SQLException{
		Atendente atendente = null;
		openConnection();
		String sql = "SELECT * FROM atendente WHERE cpf=? and senha=?";
		ps = c.prepareStatement(sql);
		ps.setString(1, cpf);
		ps.setString(2, senha);
		ResultSet rs = ps.executeQuery();
		if(rs!=null){
			while(rs.next()){
				atendente = new Atendente(rs.getInt("id_atendente"), rs.getString("nome"), rs.getString("cpf"), rs.getString("senha") , rs.getBoolean("supervisor"));
			}
		}
		rs.close();
		ps.close();
		closeConnection();
		return atendente;
	}

}
