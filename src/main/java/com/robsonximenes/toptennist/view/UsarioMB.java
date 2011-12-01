package com.robsonximenes.toptennist.view;

import java.io.Serializable;
import java.util.ArrayList;

import javax.enterprise.context.SessionScoped;

import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractEditPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;

import com.robsonximenes.toptennist.domain.Endereco;
import com.robsonximenes.toptennist.domain.Telefone;
import com.robsonximenes.toptennist.domain.Usuario;

@ViewController
@SessionScoped
public class UsarioMB extends AbstractEditPageBean<Usuario, Long> implements Serializable{
	
	private static final long serialVersionUID = -5764771730331382996L;
	

	public UsarioMB() {
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
}
