package com.robsonximenes.toptennist.business;

import java.io.Serializable;

import javax.inject.Inject;

import org.slf4j.Logger;

import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;

import com.robsonximenes.toptennist.domain.Usuario;
import com.robsonximenes.toptennist.persistence.UsuarioDAO;

@BusinessController
public class UsuarioBC extends DelegateCrud<Usuario,Long,UsuarioDAO> implements Serializable{

	private static final long serialVersionUID = 1L;

	@Inject
	private Logger logger;
	
	@Inject
	private UsuarioDAO usuarioDAO;
	
	/**
	 * Deve inserir o usuario caso seu e-mail seja único!
	 * TODO Deve enviar um e-mail para o usuario para a confirmação.
	 *  
	 * @param usuario
	 * @return
	 */
	public Usuario cadastrar(Usuario usuario) {	
		logger.debug("Inserindo o usuário:"+usuario.getEmail());
		usuarioDAO.insert(usuario);		
		return usuario;
	}

	public void atualizar(Usuario usuario) {
		logger.debug("Atualizando o usuário:"+usuario.getEmail());
		usuarioDAO.update(usuario);
	}

	public Usuario verificar(Usuario bean) {
		logger.debug("Logando o usuario: "+bean.getEmail());
		Usuario logado = usuarioDAO.verificar(bean);
		logger.debug("Encontrado o usuario com ID:"+logado.getId());
		return logado;
	}
	
	
}
