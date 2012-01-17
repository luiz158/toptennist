package com.robsonximenes.toptennist.view;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import br.gov.frameworkdemoiselle.annotation.Name;
import br.gov.frameworkdemoiselle.message.Message;
import br.gov.frameworkdemoiselle.message.SeverityType;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.util.Faces;
import br.gov.frameworkdemoiselle.util.Parameter;

import com.robsonximenes.toptennist.business.ComunidadeBC;
import com.robsonximenes.toptennist.cdi.Logado;
import com.robsonximenes.toptennist.domain.Comunidade;
import com.robsonximenes.toptennist.domain.Usuario;

@ViewController
@RequestScoped
public class ComunidadeMB implements Serializable {

	private static final long serialVersionUID = -2567884747336360053L;

	@Inject
	@Name("id")
	private Parameter<String> paramId;

	@Inject
	private ComunidadeBC bc;

	@Inject
	@Logado
	private Usuario logado;

	private Comunidade comunidade = new Comunidade();

	public String criarComunidade() {
		comunidade = new Comunidade();
		comunidade.setCriador(logado);
		comunidade.setNome("Comunidade de " + comunidade.getCriador().getNome());
		return "/comunidade_criar";
	}

	public String criar() {

		bc.criar(comunidade);

		Faces.addMessage(new Message() {

			@Override
			public String getText() {
				return "Comunidade criada: " + comunidade.getNome();
			}

			@Override
			public SeverityType getSeverity() {
				return null;
			}
		});

		return "/comunidade_editar";
	}
	
	public void salvar() {

		bc.salvar(comunidade);

		Faces.addMessage(new Message() {

			@Override
			public String getText() {
				return "Comunidade atualizada: " + comunidade.getNome();
			}

			@Override
			public SeverityType getSeverity() {
				return null;
			}
		});
	}

	public String gerenciar() {
		comunidade = bc.obter(Long.valueOf(paramId.getValue()));
		return "/comunidade_editar";		
	}
	
	public String visitar() {
		comunidade = bc.obter(Long.valueOf(paramId.getValue()));
		return "/comunidade_visitar";		
	}

	public Comunidade getComunidade() {
		return comunidade;
	}

	public void setComunidade(Comunidade comunidade) {
		this.comunidade = comunidade;
	}

}
