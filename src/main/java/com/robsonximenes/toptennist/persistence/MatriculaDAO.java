package com.robsonximenes.toptennist.persistence;

import javax.inject.Inject;

import org.slf4j.Logger;

import br.gov.frameworkdemoiselle.stereotype.PersistenceController;
import br.gov.frameworkdemoiselle.template.JPACrud;

import com.robsonximenes.toptennist.domain.Matricula;

@PersistenceController
public class MatriculaDAO extends JPACrud<Matricula, Long> {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	@SuppressWarnings("unused")
	private Logger logger;
	
}
