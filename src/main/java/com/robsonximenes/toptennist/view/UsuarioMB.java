package com.robsonximenes.toptennist.view;

import java.io.Serializable;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractEditPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import br.gov.frameworkdemoiselle.util.Faces;

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
	private UsuarioDAO dao;
	
	private Boolean lembrar;

	public UsuarioMB() {
				
	}

	@PostConstruct
	public void cargaInicial() {
		setBean(new Usuario());
		getBean().setEmail("robsonximenes@gmail.com");
		getBean().setEndereco(new Endereco());
		getBean().getEndereco().setCep("04011060");
		getBean().getEndereco().setComplemento("numero 228, ap 95");
		getBean().getEndereco().setLogradouro("Rua jose antonio coelho");
		getBean().setLogin("robsonximenes");
		getBean().setSenha("1234");
		getBean().setTelefones(new ArrayList<Telefone>());
		Telefone tel = new Telefone();
		tel.setDdd(11);
		tel.setNumero(99579907L);
		Telefone tel2 = new Telefone();
		tel2.setDdd(11);
		tel2.setNumero(26135929L);
		getBean().getTelefones().add(tel2);		
		dao.insert(getBean());
		setBean(new Usuario());
	}
	
	
	public String logar() {
		logado = dao.verificar(getBean());
		if(logado==null) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Falha no login, verifique usuario e senha."));
		}
		return null;
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
