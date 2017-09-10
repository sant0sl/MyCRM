package br.edu.facear.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.facear.model.Produto;
import br.edu.facear.util.iCRUD;

public class ProdutoDAO extends GenericDAO implements iCRUD<Produto> {

	PreparedStatement ps;
	
	@Override
	public void Create(Produto p) throws SQLException {
		openConnection();
		String sql = "INSERT INTO produto(nome) VALUES(?)";
		ps = c.prepareStatement(sql);
		ps.setString(1, p.getNome_produto());
		ps.execute();
		ps.close();
		closeConnection();
	}

	@Override
	public void Update(Produto p) throws SQLException {
		openConnection();
		String sql = "UPDATE produto SET nome=? WHERE id_produto=?";
		ps = c.prepareStatement(sql);
		ps.setString(1, p.getNome_produto());
		ps.setInt(2, p.getId());
		ps.executeUpdate();
		ps.close();
		closeConnection();
	}

	@Override
	public List<Produto> Read() throws SQLException {
		openConnection();
		List<Produto> listadeprodutos = new ArrayList<>();
		String sql = "SELECT * FROM produto";
		ps = c.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		if(rs != null){
			while(rs.next()){
				Produto p = new Produto(rs.getInt("id_produto"), rs.getString("nome"));
				listadeprodutos.add(p);
			}
		}
		closeConnection();
		return listadeprodutos;
	}

	public Produto ByID(Integer id) throws SQLException{
		openConnection();
		Produto produto = new Produto();
		String sql = "SELECT * FROM produto WHERE id_produto=?";
		ps = c.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		if(rs != null){
			while(rs.next()){
				produto.setId(rs.getInt("id_produto"));
				produto.setNome_produto(rs.getString("nome"));
			}
		}
		closeConnection();
		return produto;
	}
	
}
