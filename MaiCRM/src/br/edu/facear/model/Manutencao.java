package br.edu.facear.model;

public class Manutencao {

	private Integer id, produto_id, servico_id, status;
	private String atendente_cpf, cliente_cpf, data;
	private Produto produto;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getProduto_id() {
		return produto_id;
	}
	public void setProduto_id(Integer produto_id) {
		this.produto_id = produto_id;
	}
	public Integer getServico_id() {
		return servico_id;
	}
	public void setServico_id(Integer servico_id) {
		this.servico_id = servico_id;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getAtendente_cpf() {
		return atendente_cpf;
	}
	public void setAtendente_cpf(String atendente_cpf) {
		this.atendente_cpf = atendente_cpf;
	}
	public String getCliente_cpf() {
		return cliente_cpf;
	}
	public void setCliente_cpf(String cliente_cpf) {
		this.cliente_cpf = cliente_cpf;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	
	public Manutencao() {
		
	}
	
	public Manutencao(Integer id, Integer produto_id, Integer servico_id, Integer status, String atendente_cpf,
			String cliente_cpf, String data) {
		this.id = id;
		this.produto_id = produto_id;
		this.servico_id = servico_id;
		this.status = status;
		this.atendente_cpf = atendente_cpf;
		this.cliente_cpf = cliente_cpf;
		this.data = data;
	}
	
	@Override
	public String toString() {
		return "Manutencao [ID=" + this.id + ", ID do Produto=" + this.produto_id + ", ID do Serviço=" + this.servico_id + ", Status(0 Agendado, 1 Realizado, 2 Cancelado)="
				+ this.status + ", CPF do Operador=" + this.atendente_cpf + ", CPF do Cliente=" + this.cliente_cpf + ", Data=" + this.data + "]";
	}	
}
