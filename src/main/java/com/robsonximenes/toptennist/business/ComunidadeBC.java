package com.robsonximenes.toptennist.business;

import java.io.Serializable;

import javax.inject.Inject;

import org.slf4j.Logger;

import br.gov.frameworkdemoiselle.stereotype.BusinessController;

import com.robsonximenes.toptennist.persistence.ComunidadeDAO;

@BusinessController
public class ComunidadeBC implements Serializable{

	private static final long serialVersionUID = 1L;

	@Inject
	private Logger logger;
	
	@Inject
	private ComunidadeDAO comunidadeDAO;
	
	
	
}
