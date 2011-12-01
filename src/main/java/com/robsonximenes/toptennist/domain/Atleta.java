package com.robsonximenes.toptennist.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name="id")
public class Atleta extends Usuario {

	public enum Lateralidade {
		DESTRO, CANHOTO
	};

	private static final long serialVersionUID = 2820497787986178471L;

	private Double altura;

	private Double peso;

	private Lateralidade lateralidade;

	private Integer idadeInicioTenis;

	private Integer idadeInicioProfissional;

	private String clube;

	private String historia;

	private String raquete;

	private String idolo;

	@OneToMany(mappedBy = "pk.atleta", fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	private List<Matricula> comunidade = new ArrayList<Matricula>();

	public List<Matricula> getComunidade() {
		return comunidade;
	}

	public void setComunidade(List<Matricula> comunidade) {
		this.comunidade = comunidade;
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

}
