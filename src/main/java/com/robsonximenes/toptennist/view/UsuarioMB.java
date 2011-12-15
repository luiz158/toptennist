package com.robsonximenes.toptennist.view;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;

import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractEditPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import br.gov.frameworkdemoiselle.util.Faces;

import com.robsonximenes.toptennist.business.UsuarioBC;
import com.robsonximenes.toptennist.domain.Usuario;
import com.robsonximenes.toptennist.persistence.UsuarioDAO;

@ViewController
@SessionScoped
public class UsuarioMB extends AbstractEditPageBean<Usuario, Long> implements Serializable{
	
	private static final long serialVersionUID = -5764771730331382996L;
	
	private Usuario logado = null;
	
	private DefaultStreamedContent imagem;
	
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
	
	
	public String editarPerfil(){
		setBean(getLogado());
		return "usuario_perfil.jsf";
	}
	
	public String deslogar() {
		logado = null;
		setBean(new Usuario());
		session.invalidate();
		return "index?faces-redirect=true";
	}
	
	
	public String logar() {
		logado = dao.verificar(getBean());
		atualizarImagen();
		return "/home";
	}
	
	private void atualizarImagen() {
		if(logado!=null && logado.getFoto()!=null)
			setImagem(new DefaultStreamedContent(new ByteArrayInputStream(logado.getFoto())));
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
	
	public void handleFileUpload(FileUploadEvent event) {
		try {
			setImagem(new DefaultStreamedContent(event.getFile()
					.getInputstream()));
			byte[] foto = event.getFile().getContents();
			this.getBean().setFoto(foto);
		} catch (IOException ex) {
			Faces.addMessage(event.getComponent().getClientId(),ex);
		}
	}

	public void setImagem(DefaultStreamedContent imagem) {
		this.imagem = imagem;
	}

	public DefaultStreamedContent getImagem() {
		if(imagem == null){
			imagem = new DefaultStreamedContent();
		}
		return imagem;
	}
	
}
