package com.robsonximenes.toptennist.persistence;

import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.Query;

import org.slf4j.Logger;

import br.gov.frameworkdemoiselle.exception.ExceptionHandler;
import br.gov.frameworkdemoiselle.stereotype.PersistenceController;
import br.gov.frameworkdemoiselle.template.JPACrud;

import com.robsonximenes.toptennist.domain.Matricula;
import com.robsonximenes.toptennist.domain.Usuario;
import com.robsonximenes.toptennist.exception.MatriculaDuplicadaException;

@PersistenceController
public class MatriculaDAO extends JPACrud<Matricula, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private Logger logger;

	@Override
	public void insert(Matricula entity) {
		super.insert(entity);
		logger.debug("Inseriu "+entity.getUsuario().getId());
	}

//	@ExceptionHandler
//	public void tratador(SQLException cause) {
//		logger.debug("Tratando sqlexeception "+cause);
//		cause.printStackTrace();
//		System.out.println(cause.getErrorCode());
//		System.out.println(cause.getSQLState());
//		System.out.println(cause.getMessage());
//		throw new MatriculaDuplicadaException();
//	}

	public List<Matricula> find(Usuario usuario) {
		Query query = getEntityManager().createQuery("from Matricula m where m.usuario.id = :pUsuario order by m.comunidade.nome");
		query.setParameter("pUsuario", usuario.getId());
		return query.getResultList();
	}

}
