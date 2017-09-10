package br.edu.facear.model;

public class Produto {

	private Integer id;
	private String nome_produto;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome_produto() {
		return nome_produto;
	}
	public void setNome_produto(String nome_produto) {
		this.nome_produto = nome_produto;
	}
	
	public Produto() {
		
	}
	
	public Produto(Integer id, String nome) {
		this.id=id;
		this.nome_produto=nome;
	}
	
	@Override
	public String toString() {
		return this.id+" - Nome do Produto:"+this.nome_produto;
	}
}
