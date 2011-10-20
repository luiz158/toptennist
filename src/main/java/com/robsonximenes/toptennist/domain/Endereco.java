package com.robsonximenes.toptennist.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Endereco {

	@Column
	private String logradouro;
	
	@Column
	private String complemento;
	
	@Column
	private Long cep;

	
	public String getLogradouro() {
		return logradouro;
	}

	
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	
	public String getComplemento() {
		return complemento;
	}

	
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	
	public Long getCep() {
		return cep;
	}

	
	public void setCep(Long cep) {
		this.cep = cep;
	}
	
}
