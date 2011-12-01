package com.robsonximenes.toptennist.domain;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class MatriculaPK implements Serializable {

	private static final long serialVersionUID = 4594635953301535610L;

	@ManyToOne
	private Comunidade comunidade;

	@ManyToOne
	private Atleta atleta;

	public Comunidade getComunidade() {
		return comunidade;
	}

	public void setComunidade(Comunidade comunideade) {
		this.comunidade = comunideade;
	}

	public Atleta getAtleta() {
		return atleta;
	}

	public void setAtleta(Atleta atleta) {
		this.atleta = atleta;
	}

	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		MatriculaPK that = (MatriculaPK) o;

		if (comunidade != null ? !comunidade.equals(that.comunidade) : that.comunidade != null)
			return false;
		if (atleta != null ? !atleta.equals(that.atleta) : that.atleta != null)
			return false;

		return true;
	}

	public int hashCode() {
		int result;
		result = (comunidade != null ? comunidade.hashCode() : 0);
		result = 31 * result + (atleta != null ? atleta.hashCode() : 0);
		return result;
	}

}
