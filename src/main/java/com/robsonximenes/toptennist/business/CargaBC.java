package com.robsonximenes.toptennist.business;

import java.util.ArrayList;
import java.util.Date;

import javax.inject.Inject;

import org.slf4j.Logger;

import br.gov.frameworkdemoiselle.annotation.Startup;
import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.transaction.Transactional;

import com.robsonximenes.toptennist.domain.Atleta;
import com.robsonximenes.toptennist.domain.Comunidade;
import com.robsonximenes.toptennist.domain.Endereco;
import com.robsonximenes.toptennist.domain.MatriculaComunidade;
import com.robsonximenes.toptennist.domain.Telefone;
import com.robsonximenes.toptennist.domain.Usuario;
import com.robsonximenes.toptennist.persistence.AtletaDAO;
import com.robsonximenes.toptennist.persistence.ComunidadeDAO;
import com.robsonximenes.toptennist.persistence.UsuarioDAO;

@BusinessController
public class CargaBC {

	@Inject
	private Logger logger;
	
	@Inject
	private UsuarioDAO usuarioDAO;
	
	@Inject
	private AtletaDAO atletaDAO;
	
	@Inject
	private ComunidadeDAO comunidadeDAO;
	
	@Startup
	@Transactional
	public void cadastrarUsuario() {
		logger.debug("Inserindo usuario ADM");		
		Usuario userADM = new Usuario();
		userADM.setEmail("ADM@gmail.com");
		userADM.setEndereco(new Endereco());
		userADM.getEndereco().setCep(82546010549L);
		userADM.getEndereco().setComplemento("numero 228, ap 95");
		userADM.getEndereco().setLogradouro("Rua jose antonio coelho");
		userADM.setLogin("adm");
		userADM.setSenha("1234");
		userADM.setTelefones(new ArrayList<Telefone>());
		Telefone tel = new Telefone();
		tel.setDdd(11);
		tel.setNumero(99579907);
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
		user.setEmail("robsonximenes@gmail.com");
		user.setEndereco(new Endereco());
		user.getEndereco().setCep(82546010549L);
		user.getEndereco().setComplemento("numero 228, ap 95");
		user.getEndereco().setLogradouro("Rua jose antonio coelho");
		user.setLogin("robsonximenes");
		user.setSenha("1234");
		user.setTelefones(new ArrayList<Telefone>());
		Telefone t = new Telefone();
		t.setDdd(11);
		t.setNumero(99579907);
		user.getTelefones().add(t);		
		usuarioDAO.insert(user);
		
		logger.debug("Transformando usuario em atleta");
		Atleta atleta = (Atleta)user;	
		atleta.setAltura(1.75);
		atleta.setClube("Costa verde");
		atleta.setHistoria("blablablabal blabalbalba blablabalba blababalba");
		atleta.setIdolo("Agassi");
		atletaDAO.insert(atleta);
		
		logger.debug("Matriculando usuario em comunidade");
		MatriculaComunidade matricula = new MatriculaComunidade();
		matricula.setComunidade(comunidade);
		matricula.setAtleta(atleta);
		matricula.setDataCadastro(new Date());
		atleta.getComunidade().add(matricula);
		atletaDAO.update(atleta);
		
		
		
	}
	
}
