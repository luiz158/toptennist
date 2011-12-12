package com.robsonximenes.toptennist.view;

import java.io.Serializable;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractEditPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;

import com.robsonximenes.toptennist.business.UsuarioBC;
import com.robsonximenes.toptennist.domain.Endereco;
import com.robsonximenes.toptennist.domain.Telefone;
import com.robsonximenes.toptennist.domain.Usuario;
import com.robsonximenes.toptennist.persistence.UsuarioDAO;

@ViewController
@SessionScoped
public class UsuarioMB extends AbstractEditPageBean<Usuario, Long> implements Serializable{
	
	private static final long serialVersionUID = -5764771730331382996L;
	
	private Usuario logado = null;
	
	@Inject
	private UsuarioBC bc;;
	
	//TODO migrar para o BC
	@Inject
	private UsuarioDAO dao;
	
	private Boolean lembrar;

	public UsuarioMB() {
				
	}
	
	@Inject
	private HttpSession session;
	
	public String deslogar() {
		logado = null;
		setBean(new Usuario());
		session.invalidate();
		return "index?faces-redirect=true";
	}
	
	
	public String logar() {
		logado = dao.verificar(getBean());
		if(logado==null) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Falha no login, verifique usuario e senha."));
		}
		return null;
	}
	
	public String registrar() {		
		bc.cadastrar(getBean());		
		return "/aguardando_confirmacao_cadastro";
	}
	
	
	public Usuario getLogado() {
		return logado;
	}


	
	public void setLogado(Usuario logado) {
		this.logado = logado;
	}


	@Override
	@Transactional
	public String delete() {
		return getPreviousView();
	}

	@Override
	@Transactional
	public String insert() {
		return getPreviousView();
	}

	@Override
	@Transactional
	public String update() {
		return getPreviousView();
	}

	@Override
	protected void handleLoad() {
	}
	
	public Boolean getLembrar() {
		return lembrar;
	}

	
	public void setLembrar(Boolean lembrar) {
		this.lembrar = lembrar;
	}
}
