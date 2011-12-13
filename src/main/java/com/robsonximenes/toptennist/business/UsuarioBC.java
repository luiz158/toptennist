package com.robsonximenes.toptennist.business;

import java.io.Serializable;

import javax.inject.Inject;

import org.slf4j.Logger;

import br.gov.frameworkdemoiselle.stereotype.BusinessController;

import com.robsonximenes.toptennist.domain.Usuario;
import com.robsonximenes.toptennist.persistence.UsuarioDAO;

@BusinessController
public class UsuarioBC implements Serializable{

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
		
		usuarioDAO.insert(usuario);		
		return usuario;
	}
	
	
}
