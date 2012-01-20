package com.robsonximenes.toptennist.persistence;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.Query;

import org.slf4j.Logger;

import br.gov.frameworkdemoiselle.stereotype.PersistenceController;
import br.gov.frameworkdemoiselle.template.JPACrud;

import com.robsonximenes.toptennist.domain.Usuario;
import com.robsonximenes.toptennist.exception.FalhaNoLoginException;

@PersistenceController
public class UsuarioDAO extends JPACrud<Usuario, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	@SuppressWarnings("unused")
	private Logger logger;

	public Boolean verificarLogin(String email, String senha) {
		Query query = getEntityManager().createQuery("from Usuario u where u.email = :pEmail and u.senha = :pSenha");
		query.setParameter("pEmail", email);
		query.setParameter("pSenha", senha);
		List<Usuario> result = query.getResultList();		
		Boolean identificado = false;
		
		if(result.size()==1)
			identificado = true;
		
		return identificado;
	}

	public Usuario carregarPorEmail(String email) {
		Query query = getEntityManager().createQuery("from Usuario u where u.email = :pEmail");
		query.setParameter("pEmail", email);
		List<Usuario> result = query.getResultList();		
		Usuario usuario = null;
		
		if(!result.isEmpty())
			usuario = result.get(0);
		
		return usuario;
	}

}
