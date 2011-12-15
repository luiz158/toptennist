package com.robsonximenes.toptennist.business;

import java.util.ArrayList;
import java.util.Date;

import javax.inject.Inject;

import org.slf4j.Logger;

import br.gov.frameworkdemoiselle.annotation.Startup;
import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.transaction.Transactional;

import com.robsonximenes.toptennist.domain.Comunidade;
import com.robsonximenes.toptennist.domain.Endereco;
import com.robsonximenes.toptennist.domain.Matricula;
import com.robsonximenes.toptennist.domain.Telefone;
import com.robsonximenes.toptennist.domain.Usuario;
import com.robsonximenes.toptennist.persistence.ComunidadeDAO;
import com.robsonximenes.toptennist.persistence.UsuarioDAO;

@BusinessController
public class CargaBC {

	@Inject
	private Logger logger;
	
	@Inject
	private UsuarioDAO usuarioDAO;
		
	@Inject
	private ComunidadeDAO comunidadeDAO;
	
	@Startup
	@Transactional
	public void cadastrarUsuario() {
		logger.debug("Inserindo usuario ADM");		
		Usuario userADM = new Usuario();
		userADM.setEmail("ADM@gmail.com");
		userADM.setEndereco(new Endereco());
		userADM.getEndereco().setCep("04011060");
		userADM.getEndereco().setComplemento("numero 228, ap 95");
		userADM.getEndereco().setLogradouro("Rua jose antonio coelho");
		userADM.setSenha("1234");
		userADM.setTelefones(new ArrayList<Telefone>());
		Telefone tel = new Telefone();
		tel.setDdd(11);
		tel.setNumero(99579907L);
		userADM.getTelefones().add(tel);		
		usuarioDAO.insert(userADM);
		
		
		logger.debug("Criando uma comunidade");	
		Comunidade comunidade = new Comunidade();
		comunidade.setCriador(userADM);
		comunidade.setDataCriacao(new Date());
		comunidade.setDescricao("Comunidade de teste");
		comunidade.setNome("Testando");
		comunidadeDAO.insert(comunidade);
		
		
		logger.debug("Inserindo usuario");		
		Usuario user = new Usuario();
		user.setNome("Robson Saraiva Ximenes");
		user.setEmail("robsonximenes@gmail.com");
		user.setEndereco(new Endereco());
		user.getEndereco().setCep("04011060");
		user.getEndereco().setComplemento("numero 228, ap 95");
		user.getEndereco().setLogradouro("Rua jose antonio coelho");
		user.setSenha("1234");
		user.setTelefones(new ArrayList<Telefone>());
		Telefone t = new Telefone();
		t.setDdd(11);
		t.setNumero(99579907L);
		user.getTelefones().add(t);	
		user.setAltura(1.75);
		user.setClube("Costa verde");
		user.setHistoria("blablablabal blabalbalba blablabalba blababalba");
		user.setIdolo("Agassi");
		usuarioDAO.insert(user);
		
		logger.debug("Matriculando usuario em comunidade");
		Matricula matricula = new Matricula();
		matricula.setComunidade(comunidade);
		matricula.setUsuario(user);
		matricula.setDataCadastro(new Date());
		user.getComunidades().add(matricula);
		usuarioDAO.update(user);
		
		
		logger.debug("MODELAGEM OK!");
		
	}
	
}
