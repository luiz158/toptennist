package com.robsonximenes.toptennist.view;

import java.io.ByteArrayInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.primefaces.model.DefaultStreamedContent;

import br.gov.frameworkdemoiselle.stereotype.ViewController;

import com.robsonximenes.toptennist.business.UsuarioBC;
import com.robsonximenes.toptennist.cdi.Logado;
import com.robsonximenes.toptennist.domain.Comunidade;
import com.robsonximenes.toptennist.domain.Usuario;

@ViewController
@SessionScoped
public class UsuarioMB implements Serializable{
	
	private static final long serialVersionUID = -5764771730331382996L;
	
	private Usuario logado = new Usuario();
	
	private DefaultStreamedContent imagem;
	
	@Inject
	private UsuarioBC bc;
		
	private Boolean lembrar;
	
	private List<Usuario> amigos = new ArrayList<Usuario>();
	
	private List<Comunidade> comunidades = new ArrayList<Comunidade>();
	
	@Inject
	private HttpSession session;
		
	public String editarPerfil(){
		return "usuario_perfil.jsf?id="+getLogado().getId();
	}
	
	public String deslogar() {
		logado = new Usuario();
		session.invalidate();
		return "index?faces-redirect=true";
	}
	
	
	public String logar() {
		logado = bc.verificar(logado);
		atualizarImagen();
		return "/home";
	}
	
	public void setImagem(DefaultStreamedContent imagem) {
		this.imagem = imagem;
	}

	public DefaultStreamedContent getImagem() {
		if(imagem == null){
			imagem = new DefaultStreamedContent();
		}
		atualizarImagen();
		return imagem;
	}
	
	private void atualizarImagen() {
		if(logado!=null && logado.getFoto()!=null) {
			setImagem(new DefaultStreamedContent(new ByteArrayInputStream(logado.getFoto())));
		}
	}

	public String registrar() {		
		bc.cadastrar(getLogado());		
		return "/aguardando_confirmacao_cadastro";
	}
	
	
	public Usuario getLogado() {
		return logado;
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
	
	@Produces @Logado @SessionScoped
	public Usuario obterUsuarioLogado() {
		return this.logado;
	}
			
	public List<Usuario> getAmigos() {
		return amigos;
	}

	
	public void setAmigos(List<Usuario> amigos) {
		this.amigos = amigos;
	}

	public void setComunidades(List<Comunidade> comunidades) {
		this.comunidades = comunidades;
	}

	public List<Comunidade> getComunidades() {
		if(comunidades.isEmpty()) {
			Comunidade c = new Comunidade();
			c.setNome("Teste");
			comunidades.add(c);
			Comunidade c2 = new Comunidade();
			c2.setNome("Teste 2");
			comunidades.add(c2);
		}
		return comunidades;
	}
	
}
