package com.robsonximenes.toptennist.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
public class Comunidade implements Serializable {

	private static final long serialVersionUID = -9146948165486137873L;

	@Id
	@GeneratedValue
	private Long id;

	private String nome;

	private String descricao;
	
	@ManyToOne
	private Usuario criador;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataCriacao;
	
	@Embedded
	private Endereco endereco = new Endereco();

	@OneToMany
	private List<Telefone> telefones;

	@OneToMany(mappedBy="comunidade", cascade=CascadeType.ALL)
	private List<Matricula> atletas = new ArrayList<Matricula>();

	
	public Long getId() {
		return id;
	}

	
	public void setId(Long id) {
		this.id = id;
	}

	
	public String getNome() {
		return nome;
	}

	
	public void setNome(String nome) {
		this.nome = nome;
	}

	
	public String getDescricao() {
		return descricao;
	}

	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
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

	
	public List<Matricula> getAtletas() {
		return atletas;
	}

	
	public void setAtletas(List<Matricula> atletas) {
		this.atletas = atletas;
	}


	
	public Usuario getCriador() {
		return criador;
	}


	
	public void setCriador(Usuario criador) {
		this.criador = criador;
	}


	
	public Date getDataCriacao() {
		return dataCriacao;
	}


	
	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
	
	@Transient
	public int getTotalAtletas() {
		int t = 0;
		List<Matricula> usuarios = getAtletas();
		if(usuarios!=null) {
			t = getAtletas().size();
		}
		return t;
	}
	

}
