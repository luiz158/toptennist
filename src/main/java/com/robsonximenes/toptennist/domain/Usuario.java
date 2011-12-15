package com.robsonximenes.toptennist.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Usuario implements Serializable {

	enum Sexo{MASCULINO, FEMININO};	
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String senha;

	@Column
	private String email;
	
	@Column
	private String nome;
	
	@Temporal(TemporalType.DATE)
	@Column
	private Date dataNascimento;
	
	@Column
	private Sexo sexo;

	@Embedded
	private Endereco endereco = new Endereco();

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "usuario_telefone")
	private List<Telefone> telefones;
	
	public enum Lateralidade {
		DESTRO, CANHOTO
	};

	private Double altura;

	private Double peso;

	private Lateralidade lateralidade;

	private Integer idadeInicioTenis;

	private Integer idadeInicioProfissional;

	private String clube;

	private String historia;

	private String raquete;

	private String idolo;

	@OneToMany(mappedBy = "pk.usuario", fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	private List<Matricula> comunidades = new ArrayList<Matricula>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	
	public String getNome() {
		return nome;
	}

	
	public void setNome(String nome) {
		this.nome = nome;
	}

	
	public Date getDataNascimento() {
		return dataNascimento;
	}

	
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	
	public Sexo getSexo() {
		return sexo;
	}

	
	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	
	public Double getAltura() {
		return altura;
	}

	
	public void setAltura(Double altura) {
		this.altura = altura;
	}

	
	public Double getPeso() {
		return peso;
	}

	
	public void setPeso(Double peso) {
		this.peso = peso;
	}

	
	public Lateralidade getLateralidade() {
		return lateralidade;
	}

	
	public void setLateralidade(Lateralidade lateralidade) {
		this.lateralidade = lateralidade;
	}

	
	public Integer getIdadeInicioTenis() {
		return idadeInicioTenis;
	}

	
	public void setIdadeInicioTenis(Integer idadeInicioTenis) {
		this.idadeInicioTenis = idadeInicioTenis;
	}

	
	public Integer getIdadeInicioProfissional() {
		return idadeInicioProfissional;
	}

	
	public void setIdadeInicioProfissional(Integer idadeInicioProfissional) {
		this.idadeInicioProfissional = idadeInicioProfissional;
	}

	
	public String getClube() {
		return clube;
	}

	
	public void setClube(String clube) {
		this.clube = clube;
	}

	
	public String getHistoria() {
		return historia;
	}

	
	public void setHistoria(String historia) {
		this.historia = historia;
	}

	
	public String getRaquete() {
		return raquete;
	}

	
	public void setRaquete(String raquete) {
		this.raquete = raquete;
	}

	
	public String getIdolo() {
		return idolo;
	}

	
	public void setIdolo(String idolo) {
		this.idolo = idolo;
	}

	
	public List<Matricula> getComunidades() {
		return comunidades;
	}

	
	public void setComunidades(List<Matricula> comunidade) {
		this.comunidades = comunidade;
	}

}
