package com.robsonximenes.toptennist.domain;

import java.util.Date;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.util.privilegedactions.GetAnnotationParameter;

@Entity
@Table
public class Matricula {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String codigo;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataCadastro;	
	
	@ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="comunidade_id")
    private Comunidade comunidade;
	
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="usuario_id")
    private Usuario usuario;

	
	public Long getId() {
		return id;
	}

	
	public void setId(Long id) {
		this.id = id;
	}

	
	public String getCodigo() {
		return codigo;
	}

	
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	
	public Date getDataCadastro() {
		return dataCadastro;
	}

	
	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	
	public Comunidade getComunidade() {
		return comunidade;
	}

	
	public void setComunidade(Comunidade comunidade) {
		this.comunidade = comunidade;
	}

	
	public Usuario getUsuario() {
		return usuario;
	}

	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
       

}
