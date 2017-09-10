package br.edu.facear.model;

public class Atendente {

	private Integer id, supervisor;
	private String nome, cpf, senha;
	
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getSupervisor() {
		return supervisor;
	}
	public void setSupervisor(Integer supervisor) {
		this.supervisor = supervisor;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public Atendente() {
		
	}
	
	public Atendente(Integer id, String nome, String cpf, String senha, Integer supervisor) {
		this.id=id;
		this.nome=nome;
		this.cpf=cpf;
		this.senha=senha;
		this.supervisor=supervisor;
	}
	
	@Override
	public String toString() {
		return this.id+" - Nome:"+this.nome+" - CPF:"+this.cpf+" - 0(Atendente) 1(Supervisor):"+this.supervisor;
	}
}
