package com.robsonximenes.toptennist.business;

import javax.inject.Inject;

import org.slf4j.Logger;

import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;

import com.robsonximenes.toptennist.domain.Matricula;
import com.robsonximenes.toptennist.persistence.MatriculaDAO;

@BusinessController
public class MatriculaBC extends DelegateCrud<Matricula,Long,MatriculaDAO>{

	private static final long serialVersionUID = 1L;

	@Inject
	private Logger logger;

	@Inject	
	private ComunidadeBC comunidadeBC;
	
	@Inject	
	private UsuarioBC usuarioBC;
	
	@Override
	public void insert(Matricula bean) {
		logger.debug("Matriculando um usuario("+bean.getUsuario().getId()+") em uma comunidade("+bean.getComunidade().getId()+")");
		bean.setComunidade(comunidadeBC.load(bean.getComunidade().getId()));		
		bean.setUsuario(usuarioBC.load(bean.getUsuario().getId()));
		super.insert(bean);
	}
	
}
