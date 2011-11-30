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
@Table(name = "comunidade_atleta")
@AssociationOverrides({ @AssociationOverride(name = "pk.comunidade", joinColumns = @JoinColumn(name = "comunidade_id")),
		@AssociationOverride(name = "pk.atleta", joinColumns = @JoinColumn(name = "atleta_id")) })
public class MatriculaComunidade {

	@EmbeddedId
	private MatriculaComunidadePK pk = new MatriculaComunidadePK();
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataCadastro;
	
	
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
    public Atleta getAtleta() {
        return getPk().getAtleta();
    }

    public void setAtleta(Atleta atleta) {
        getPk().setAtleta(atleta);
    }

	public void setPk(MatriculaComunidadePK pk) {
		this.pk = pk;
	}

	public MatriculaComunidadePK getPk() {
		return pk;
	}

}
