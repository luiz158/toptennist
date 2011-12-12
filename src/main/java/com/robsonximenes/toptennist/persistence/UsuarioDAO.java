package com.robsonximenes.toptennist.persistence;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.Query;

import org.slf4j.Logger;

import br.gov.frameworkdemoiselle.stereotype.PersistenceController;
import br.gov.frameworkdemoiselle.template.JPACrud;

import com.robsonximenes.toptennist.domain.Usuario;

@PersistenceController
public class UsuarioDAO extends JPACrud<Usuario, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	@SuppressWarnings("unused")
	private Logger logger;

	public Usuario verificar(Usuario usuario) {
		Query query = getEntityManager().createQuery("from Usuario u where u.email = :pEmail and u.senha = :pSenha");
		query.setParameter("pEmail", usuario.getEmail());
		query.setParameter("pSenha", usuario.getSenha());
		List<Usuario> result = query.getResultList();		
		usuario = null;
		if(!result.isEmpty())
			usuario = result.get(0);
		return usuario;
	}

}
