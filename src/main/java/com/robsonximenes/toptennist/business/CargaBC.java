package com.robsonximenes.toptennist.business;

import java.util.ArrayList;

import javax.inject.Inject;

import org.slf4j.Logger;

import br.gov.frameworkdemoiselle.stereotype.BusinessController;

import com.robsonximenes.toptennist.domain.Endereco;
import com.robsonximenes.toptennist.domain.Telefone;
import com.robsonximenes.toptennist.domain.Usuario;
import com.robsonximenes.toptennist.persistence.UsuarioDAO;

@BusinessController
public class CargaBC {

	@Inject
	private Logger logger;
	
	@Inject
	private UsuarioDAO usuarioDAO;
	
	public void cadastrarUsuario() {
		logger.debug("Inserindo usuarios aleatórios");
		
		Usuario user = new Usuario();
		user.setEmail("robsonximenes@gmail.com");
		user.setEndereco(new Endereco());
		user.getEndereco().setCep(82546010549L);
		user.getEndereco().setComplemento("numero 228, ap 95");
		user.getEndereco().setLogradouro("Rua jose antonio coelho");
		user.setLogin("robsonximenes");
		user.setSenha("1234");
		user.setTelefones(new ArrayList<Telefone>());
		Telefone tel = new Telefone();
		tel.setDdd(11);
		tel.setNumero(99579907);
		user.getTelefones().add(tel);
		
		usuarioDAO.insert(user);
		
	}
	
}
