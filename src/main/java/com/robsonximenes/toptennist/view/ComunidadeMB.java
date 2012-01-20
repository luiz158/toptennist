package com.robsonximenes.toptennist.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import br.gov.frameworkdemoiselle.annotation.Name;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.util.Parameter;

import com.robsonximenes.toptennist.business.ComunidadeBC;
import com.robsonximenes.toptennist.business.MatriculaBC;
import com.robsonximenes.toptennist.cdi.Logado;
import com.robsonximenes.toptennist.domain.Comunidade;
import com.robsonximenes.toptennist.domain.Matricula;
import com.robsonximenes.toptennist.domain.Usuario;

@ViewController
@RequestScoped
public class ComunidadeMB implements Serializable {

	private static final long serialVersionUID = -2567884747336360053L;

	@Inject
	@Name("id")
	private Parameter<String> paramId;
	
	private String texto;

	@Inject
	private ComunidadeBC bc;
	
	@Inject
	private MatriculaBC matriculaBC;

	@Inject
	@Logado
	private Usuario logado;

	private Comunidade comunidade = new Comunidade();
	
	private List<Comunidade> listaComunidades = new ArrayList<Comunidade>();
	
	
	public String pesquisar() {
		
		listaComunidades =  bc.pesquisar(getTexto());
		
		return "/logado/comunidade_pesquisa";
	}
	

	public String criarComunidade() {
		comunidade = new Comunidade();	
		comunidade.setId(null);
		comunidade.setCriador(logado);
		comunidade.setNome("Comunidade de " + comunidade.getCriador().getNome());
		return "/logado/comunidade_criar";
	}

	public String criar() {
		bc.insert(comunidade);
		return "/logado/comunidade_editar";
	}
	
	public void salvar() {
		bc.update(comunidade);

	}
	
	public String entrar() {
		Matricula matricula = new Matricula();
		matricula.setComunidade(comunidade);
		matricula.setUsuario(logado);
		matricula.setDataCadastro(new Date());
		matriculaBC.insert(matricula);
		return "/logado/comunidade_visitar";
	}


	public String gerenciar() {
		carregarComunidade();
		return "/logado/comunidade_editar";		
	}

	public String visitar() {
		carregarComunidade();
		return "/logado/comunidade_visitar";		
	}
	
	/**
	 * Utiliza o parametro (paramId) para carregar a comunidade
	 */
	private void carregarComunidade() {
		comunidade = bc.load(Long.valueOf(paramId.getValue()));
	}
	

	public Comunidade getComunidade() {
		return comunidade;
	}

	public void setComunidade(Comunidade comunidade) {
		this.comunidade = comunidade;
	}

	
	public String getTexto() {
		return texto;
	}

	
	public void setTexto(String texto) {
		this.texto = texto;
	}


	
	public List<Comunidade> getListaComunidades() {
		return listaComunidades;
	}


	
	public void setListaComunidades(List<Comunidade> listaComunidades) {
		this.listaComunidades = listaComunidades;
	}
	
	public int getSizeListaComunidades() {
		int t = 0;
		if(listaComunidades!=null) {
			t = listaComunidades.size();
		}
		return t;
	}

}
