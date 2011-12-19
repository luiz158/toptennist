package com.robsonximenes.toptennist.domain;

import java.util.Date;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table
@AssociationOverrides(
		{ @AssociationOverride(name = "pk.comunidade", joinColumns = @JoinColumn(name = "comunidade_id")),
		@AssociationOverride(name = "pk.usuario", joinColumns = @JoinColumn(name = "usuario_id")) })
public class Matricula {

	@EmbeddedId
	private MatriculaPK pk = new MatriculaPK();
	
	private String codigo;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataCadastro;	
	
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

	@Transient
    public Comunidade getComunidade() {
        return getPk().getComunidade();
    }

    public void setComunidade(Comunidade comunidade) {
        getPk().setComunidade(comunidade);
    }

    @Transient
    public Usuario getUsuario() {
        return getPk().getUsuario();
    }

    public void setUsuario(Usuario atleta) {
        getPk().setUsuario(atleta);
    }

	public void setPk(MatriculaPK pk) {
		this.pk = pk;
	}

	public MatriculaPK getPk() {
		return pk;
	}

}
