package com.robsonximenes.toptennist.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.TableGenerator;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator="GEN_USUARIO")
	@TableGenerator(name="GEN_USUARIO", table="TG_USUARIO", pkColumnName="KGEN_KTBL", valueColumnName="KGEN_KVAL") 
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
