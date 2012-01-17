package com.robsonximenes.toptennist.business;

import java.io.Serializable;

import javax.inject.Inject;

import org.slf4j.Logger;

import antlr.CppCodeGenerator;
import br.gov.frameworkdemoiselle.annotation.Name;
import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.util.Parameter;

import com.robsonximenes.toptennist.domain.Comunidade;
import com.robsonximenes.toptennist.persistence.ComunidadeDAO;

@BusinessController
public class ComunidadeBC implements Serializable{

	private static final long serialVersionUID = 1L;

	@Inject
	private Logger logger;
	
	@Inject
	private ComunidadeDAO comunidadeDAO;
	
	public void criar(Comunidade comunidade) {
		logger.debug("regra de negócio para criar comunidade.");
		comunidadeDAO.insert(comunidade);
	}

	public Comunidade obter(Long value) {
		logger.debug("Carregando a comunidade de id: "+value);
		return comunidadeDAO.load(value);
	}

	public void salvar(Comunidade comunidade) {
		logger.debug("Atualizando comunidade de id: "+comunidade.getId());
		comunidadeDAO.update(comunidade);
	}

	
}
