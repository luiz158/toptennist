package com.robsonximenes.toptennist.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;

	@Column
	private String login;

	@Column
	private String senha;

	@Column
	private String email;

	@Embedded
	private Endereco endereco = new Endereco();

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "usuario_telefone")
	private List<Telefone> telefones;

	
	public Long getId() {
		return id;
	}

	
	public void setId(Long id) {
		this.id = id;
	}

	
	public String getLogin() {
		return login;
	}

	
	public void setLogin(String login) {
		this.login = login;
	}

	
	public String getSenha() {
		return senha;
	}

	
	public void setSenha(String senha) {
		this.senha = senha;
	}

	
	public String getEmail() {
		return email;
	}

	
	public void setEmail(String email) {
		this.email = email;
	}

	
	public Endereco getEndereco() {
		return endereco;
	}

	
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	
	public List<Telefone> getTelefones() {
		return telefones;
	}

	
	public void setTelefones(List<Telefone> telefones) {
		this.telefones = telefones;
	}
	
	

}
