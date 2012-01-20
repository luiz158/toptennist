package com.robsonximenes.toptennist.business;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
import com.robsonximenes.toptennist.domain.Usuario.Lateralidade;
import com.robsonximenes.toptennist.domain.Usuario.Sexo;
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
	
	@Inject
	private MatriculaBC matriculaBC;
	
	@Startup
	@Transactional
	public void cadastrarUsuario() {
		logger.debug("Inserindo usuario ADM");		
		Usuario userADM = new Usuario();
		userADM.setEmail("ADM@gmail.com");
		userADM.setNome("Administrador");
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
		
		logger.debug("Inserindo usuario qualquer");		
		List<Usuario> usuarios = criarUsuarios();		
		
		criandoComunidadeMisere();
		
		
		logger.debug("Criando comunidades de exemplo;");
		List<Comunidade> comunidades = criarComunidades(userADM);
		
		logger.debug("Matriculando os usuarios");
		matricular(usuarios,comunidades);
		logger.debug("MODELAGEM OK!");
		
	}


	/**
	 * 
	 */
	private void criandoComunidadeMisere() {
		logger.debug("Inserindo usuario");		
		Usuario user = criarAtleta("Robson Ximenes");		
		usuarioDAO.insert(user);		
		
		logger.debug("Criando uma comunidade");	
		Comunidade comunidade = new Comunidade();
		comunidade.setCriador(user);
		comunidade.setDataCriacao(new Date());
		comunidade.setDescricao("Associação dos maiores tenistas do mundo.");
		comunidade.setNome("Miserê Tênis Clube");
		comunidadeDAO.insert(comunidade);
		
		Matricula matricula = new Matricula();
		matricula.setComunidade(comunidade);
		matricula.setUsuario(user);
		matricula.setDataCadastro(new Date());
		user.getComunidades().add(matricula);
		matriculaBC.insert(matricula);
		
		List<Usuario> doidos = new ArrayList<Usuario>();
		doidos.add(criarAtleta("Rafael Nadal"));
		doidos.add(criarAtleta("Roger Federer"));
		doidos.add(criarAtleta("Novac Djocovik"));
		doidos.add(criarAtleta("Leytom Hewitt"));
		doidos.add(criarAtleta("Andy Roddick"));
		doidos.add(criarAtleta("Ferrero"));
		doidos.add(criarAtleta("Gilis Simon"));
		doidos.add(criarAtleta("Guga"));
		doidos.add(criarAtleta("Monfills"));
		
		
		for (Usuario doido : doidos) {
			Matricula m = new Matricula();
			m.setComunidade(comunidade);
			m.setUsuario(doido);
			m.setDataCadastro(new Date());
			user.getComunidades().add(m);
			matriculaBC.insert(m);
		}
		
	}

	private Usuario criarAtleta(String nome) {
		Usuario user = new Usuario();
		user.setNome(nome);
		user.setEmail(nome+"@gmail.com");	
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
		user.setPeso(80.0);
		user.setClube("ATP");
		user.setHistoria("sem historia");
		user.setIdolo("Robson Ximenes");
		user.setSexo(Sexo.MASCULINO);
		user.setLateralidade(Lateralidade.CANHOTO);
		usuarioDAO.insert(user);
		return user;
	}

	private void matricular(List<Usuario> usuarios, List<Comunidade> comunidades) {
		for (Comunidade comunidade : comunidades) {
			Matricula m = new Matricula();
			m.setComunidade(comunidade);
			m.setUsuario(usuarios.get(0));
			matriculaBC.insert(m);
			
			m = new Matricula();
			m.setComunidade(comunidade);
			m.setUsuario(usuarios.get(1));
			matriculaBC.insert(m);
		}
	}


	/**
	 * @return 
	 * 
	 */
	private List<Usuario> criarUsuarios() {
		List<Usuario> lista = new ArrayList<Usuario>();
		for (int i = 0; i < 10; i++) {
			Usuario u = new Usuario();
			u.setNome("user"+(i+1));
			u.setEmail(u.getNome()+"@gmail.com");
			u.setEndereco(new Endereco());
			u.getEndereco().setCep("04011060");
			u.getEndereco().setComplemento("numero 228, ap 95");
			u.getEndereco().setLogradouro("Rua jose antonio coelho");
			u.setSenha("1234");
			u.setTelefones(new ArrayList<Telefone>());
			Telefone tel1 = new Telefone();
			tel1.setDdd(11);
			tel1.setNumero(99579907L);
			u.getTelefones().add(tel1);	
			u.setAltura(1.75);
			u.setPeso(80.0+i);
			u.setClube("Costa verde");
			u.setHistoria("Jogador virtual criado apenas para testes");
			u.setIdolo("Robson Ximenes");
			u.setSexo(Sexo.MASCULINO);
			u.setLateralidade(Lateralidade.DESTRO);
			usuarioDAO.insert(u);
			lista.add(u);
		}
		return lista;
	}
	
	
	private List<Comunidade> criarComunidades(Usuario user) {
		List<Comunidade> lista = new ArrayList<Comunidade>();
		for (int i = 0; i < 10; i++) {
			Comunidade comunidade = new Comunidade();
			comunidade.setCriador(user);
			comunidade.setDataCriacao(new Date());
			comunidade.setNome("Comunidade "+(i+1));
			comunidade.setDescricao("Descricao da comunidade :"+comunidade.getNome());			
			comunidadeDAO.insert(comunidade);
			lista.add(comunidade);
		}
		return lista;
	}
	
}
