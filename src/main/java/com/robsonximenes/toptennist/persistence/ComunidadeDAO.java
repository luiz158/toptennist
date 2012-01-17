package com.robsonximenes.toptennist.persistence;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.Query;

import org.slf4j.Logger;

import br.gov.frameworkdemoiselle.stereotype.PersistenceController;
import br.gov.frameworkdemoiselle.template.JPACrud;

import com.robsonximenes.toptennist.domain.Comunidade;

@PersistenceController
public class ComunidadeDAO extends JPACrud<Comunidade, Long> {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	@SuppressWarnings("unused")
	private Logger logger;

	public List<Comunidade> pesquisar(String texto) {
		Query query = getEntityManager().createQuery("from Comunidade c where UPPER(c.nome) like :pnome order by c.nome");
		query.setParameter("pnome", "%"+texto.toUpperCase()+"%"); 			
		return query.getResultList();
	}
	
}
