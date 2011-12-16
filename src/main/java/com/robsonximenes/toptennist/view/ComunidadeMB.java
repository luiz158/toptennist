package com.robsonximenes.toptennist.view;

import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import br.gov.frameworkdemoiselle.stereotype.ViewController;

import com.robsonximenes.toptennist.business.ComunidadeBC;
import com.robsonximenes.toptennist.cdi.Logado;
import com.robsonximenes.toptennist.domain.Comunidade;
import com.robsonximenes.toptennist.domain.Usuario;


@ViewController
@ViewScoped
public class ComunidadeMB {

	@Inject
	private ComunidadeBC bc;
	
	@Inject @Logado
	private Usuario logado;
	
	private Comunidade comunidade;
	
	public String criarComunidade() {
		comunidade = new Comunidade();
		comunidade.setCriador(logado);
		comunidade.setNome("Comunidade de "+comunidade.getCriador().getNome());
		return "/comunidade_edit";
	}

	
	public Comunidade getComunidade() {
		return comunidade;
	}

	
	public void setComunidade(Comunidade comunidade) {
		this.comunidade = comunidade;
	}
	
	
	
	
}
