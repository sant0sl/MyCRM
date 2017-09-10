package br.edu.facear.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.facear.model.ManutencaoBusca;
import br.edu.facear.util.iCRUD;

public class ManutencaoBuscaDAO extends GenericDAO implements iCRUD<ManutencaoBusca> {

	PreparedStatement ps;
	
	@Override
	public void Create(ManutencaoBusca obj) throws SQLException {
		//Não tem
	}

	@Override
	public void Update(ManutencaoBusca obj) throws SQLException {
		//Não tem
	}

	@Override
	public List<ManutencaoBusca> Read() throws SQLException {
		openConnection();
		List<ManutencaoBusca> listademanutencao = new ArrayList<>();
		String sql = "select manutencao.id_manutencao as id, atendente.nome as atendente, cliente.nome as cliente, manutencao.data as data, produto.nome as produto, servico.nome as servico, manutencao.status from manutencao inner join atendente on atendente_cpf=atendente.cpf inner join cliente on cliente_cpf=cliente.cpf inner join produto on produto_id=produto.id_produto inner join servico on servico_id=servico.id_servico";
		ps = c.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		if(rs != null){
			while(rs.next()){
				ManutencaoBusca m = new ManutencaoBusca();
				m.setId(rs.getInt("id"));
				m.setAtendente(rs.getString("atendente"));
				m.setCliente(rs.getString("cliente"));
				m.setData(rs.getString("data"));
				m.setProduto(rs.getString("produto"));
				m.setServico(rs.getString("servico"));
				if(rs.getInt("status")==0) {
					m.setStatus("Agendado");
				}else if(rs.getInt("status")==1) {
					m.setStatus("Realizado");
				}else if(rs.getInt("status")==2) {
					m.setStatus("Cancelado");
				}
				listademanutencao.add(m);
			}
		}
		closeConnection();
		return listademanutencao;
	}

	public List<ManutencaoBusca> FiltrarNomeCliente(String nome_cliente) throws SQLException{
		openConnection();
		List<ManutencaoBusca> listafiltrada = new ArrayList<>();
		String sql = "select manutencao.id_manutencao as id, atendente.nome as atendente, cliente.nome as cliente, manutencao.data as data, produto.nome as produto, servico.nome as servico, manutencao.status from manutencao inner join atendente on atendente_cpf=atendente.cpf inner join cliente on cliente_cpf=cliente.cpf inner join produto on produto_id=produto.id_produto inner join servico on servico_id=servico.id_servico where cliente.nome like '%"+nome_cliente+"%'";
		ps = c.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		if(rs != null){
			while(rs.next()){
				ManutencaoBusca m = new ManutencaoBusca();
				m.setId(rs.getInt("id"));
				m.setAtendente(rs.getString("atendente"));
				m.setCliente(rs.getString("cliente"));
				m.setData(rs.getString("data"));
				m.setProduto(rs.getString("produto"));
				m.setServico(rs.getString("servico"));
				if(rs.getInt("status")==0) {
					m.setStatus("Agendado");
				}else if(rs.getInt("status")==1) {
					m.setStatus("Realizado");
				}else if(rs.getInt("status")==2) {
					m.setStatus("Cancelado");
				}
				listafiltrada.add(m);
			}
		}
		closeConnection();
		return listafiltrada;
	}
	
	public List<ManutencaoBusca> FiltrarData(String data) throws SQLException{
		openConnection();
		List<ManutencaoBusca> listafiltrada = new ArrayList<>();
		String sql = "select manutencao.id_manutencao as id, atendente.nome as atendente, cliente.nome as cliente, manutencao.data as data, produto.nome as produto, servico.nome as servico, manutencao.status from manutencao inner join atendente on atendente_cpf=atendente.cpf inner join cliente on cliente_cpf=cliente.cpf inner join produto on produto_id=produto.id_produto inner join servico on servico_id=servico.id_servico where data like '%"+data+"%'";
		ps = c.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		if(rs != null){
			while(rs.next()){
				ManutencaoBusca m = new ManutencaoBusca();
				m.setId(rs.getInt("id"));
				m.setAtendente(rs.getString("atendente"));
				m.setCliente(rs.getString("cliente"));
				m.setData(rs.getString("data"));
				m.setProduto(rs.getString("produto"));
				m.setServico(rs.getString("servico"));
				if(rs.getInt("status")==0) {
					m.setStatus("Agendado");
				}else if(rs.getInt("status")==1) {
					m.setStatus("Realizado");
				}else if(rs.getInt("status")==2) {
					m.setStatus("Cancelado");
				}
				listafiltrada.add(m);
			}
		}
		closeConnection();
		return listafiltrada;
	}
	
	public List<ManutencaoBusca> FiltrarStatus(Integer status) throws SQLException{
		openConnection();
		List<ManutencaoBusca> listafiltrada = new ArrayList<>();
		String sql = "select manutencao.id_manutencao as id, atendente.nome as atendente, cliente.nome as cliente, manutencao.data as data, produto.nome as produto, servico.nome as servico, manutencao.status from manutencao inner join atendente on atendente_cpf=atendente.cpf inner join cliente on cliente_cpf=cliente.cpf inner join produto on produto_id=produto.id_produto inner join servico on servico_id=servico.id_servico where status like '%"+status+"%'";
		ps = c.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		if(rs != null){
			while(rs.next()){
				ManutencaoBusca m = new ManutencaoBusca();
				m.setId(rs.getInt("id"));
				m.setAtendente(rs.getString("atendente"));
				m.setCliente(rs.getString("cliente"));
				m.setData(rs.getString("data"));
				m.setProduto(rs.getString("produto"));
				m.setServico(rs.getString("servico"));
				if(rs.getInt("status")==0) {
					m.setStatus("Agendado");
				}else if(rs.getInt("status")==1) {
					m.setStatus("Realizado");
				}else if(rs.getInt("status")==2) {
					m.setStatus("Cancelado");
				}
				listafiltrada.add(m);
			}
		}
		closeConnection();
		return listafiltrada;
	}
}
