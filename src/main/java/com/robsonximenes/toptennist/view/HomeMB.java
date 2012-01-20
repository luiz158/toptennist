package com.robsonximenes.toptennist.view;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;

import br.gov.frameworkdemoiselle.security.SecurityContext;
import br.gov.frameworkdemoiselle.stereotype.ViewController;

import com.robsonximenes.toptennist.business.UsuarioBC;
import com.robsonximenes.toptennist.cdi.Logado;
import com.robsonximenes.toptennist.domain.Usuario;

@ViewController
@RequestScoped
public class HomeMB implements Serializable {

	private static final long serialVersionUID = -2567884747336360053L;
	
	@Inject UsuarioBC usuarioBC;
	
	private Usuario usuario;

	@Inject SecurityContext context;
	
	@Produces @Logado
	public Usuario getUsuario() {
		if(usuario==null) {
			usuario = usuarioBC.carregarPorEmail(context.getUser().getId());
		}
		return usuario;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	
}
