package com.robsonximenes.toptennist.business;

import java.util.List;

import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;

import com.robsonximenes.toptennist.domain.Comunidade;
import com.robsonximenes.toptennist.persistence.ComunidadeDAO;

@BusinessController
public class ComunidadeBC extends DelegateCrud<Comunidade, Long, ComunidadeDAO>{

	private static final long serialVersionUID = 1L;

	
	public List<Comunidade> pesquisar(String texto) {
		return getDelegate().pesquisar(texto);
	}

	
}
