package br.edu.facear.model;

public class Servico {

	private Integer id;
	private String nome_servico;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome_servico() {
		return nome_servico;
	}
	public void setNome_servico(String nome_servico) {
		this.nome_servico = nome_servico;
	}
	
	public Servico() {
		
	}
	
	public Servico(Integer id, String nome_servico) {
		this.id = id;
		this.nome_servico = nome_servico;
	}
	
	@Override
	public String toString() {
		return this.id+" - Nome do Serviço:"+this.nome_servico;
	}
}
