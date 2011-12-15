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
	private Usuario usuario;

	public Comunidade getComunidade() {
		return comunidade;
	}

	public void setComunidade(Comunidade comunideade) {
		this.comunidade = comunideade;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario atleta) {
		this.usuario = atleta;
	}

	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		MatriculaPK that = (MatriculaPK) o;

		if (comunidade != null ? !comunidade.equals(that.comunidade) : that.comunidade != null)
			return false;
		if (usuario != null ? !usuario.equals(that.usuario) : that.usuario != null)
			return false;

		return true;
	}

	public int hashCode() {
		int result;
		result = (comunidade != null ? comunidade.hashCode() : 0);
		result = 31 * result + (usuario != null ? usuario.hashCode() : 0);
		return result;
	}

}
