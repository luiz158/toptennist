package com.robsonximenes.toptennist.view;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import br.gov.frameworkdemoiselle.annotation.Name;
import br.gov.frameworkdemoiselle.security.SecurityContext;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.util.Parameter;

import com.robsonximenes.toptennist.business.UsuarioBC;
import com.robsonximenes.toptennist.cdi.Id;
import com.robsonximenes.toptennist.cdi.Logado;
import com.robsonximenes.toptennist.domain.Usuario;
import com.robsonximenes.toptennist.security.Credential;

@ViewController
@RequestScoped
public class UsuarioMB implements Serializable{
	
	private static final long serialVersionUID = -5764771730331382996L;

    @Inject 
    private SecurityContext context; 
	
    @Inject @Logado
	private Usuario logado;
    
	private Usuario visitado = new Usuario();
		
	@Inject
	private UsuarioBC bc;
		
	private Boolean lembrar;
	
	@Inject @RequestScoped
	@Name("visitado_id")
	private Parameter<String> visitado_id;
			
	public String editarPerfil(){
		return "/logado/usuario_perfil.jsf?visitado_id="+logado.getId();
	}
	
	public String visitar() {
		visitado = bc.load(Long.valueOf(visitado_id.getValue()));
		return "/logado/usuario_visualizar";
	}

	public String registrar() {		
		bc.cadastrar(getLogado());		
		return "/aguardando_confirmacao_cadastro";
	}
	
	
	public Usuario getLogado() {
		return this.logado;
	}
	
	public void setLogado(Usuario logado) {
		this.logado = logado;
	}
	
	public Boolean getLembrar() {
		return lembrar;
	}

	
	public void setLembrar(Boolean lembrar) {
		this.lembrar = lembrar;
	}
	
			
	public List<Usuario> getAmigos() {
		//TODO alterar para exibir apenas os amigos do usuário em exibição.
		return bc.findAll();
	}

	
	public Usuario getVisitado() {
		return visitado;
	}

	
	public void setVisitado(Usuario visitado) {
		this.visitado = visitado;
	}
	
}
