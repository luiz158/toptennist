package com.robsonximenes.toptennist.business;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.Query;

import org.slf4j.Logger;

import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;

import com.robsonximenes.toptennist.domain.Comunidade;
import com.robsonximenes.toptennist.domain.Matricula;
import com.robsonximenes.toptennist.domain.Usuario;
import com.robsonximenes.toptennist.persistence.MatriculaDAO;

@BusinessController
public class MatriculaBC extends DelegateCrud<Matricula, Long, MatriculaDAO> {

	private static final long serialVersionUID = 1L;

	@Inject
	private Logger logger;

	@Inject
	private ComunidadeBC comunidadeBC;

	@Inject
	private UsuarioBC usuarioBC;

	@Override
	public void insert(Matricula bean) {
		bean.setComunidade(comunidadeBC.load(bean.getComunidade().getId()));
		bean.setUsuario(usuarioBC.load(bean.getUsuario().getId()));
		super.insert(bean);
		logger.debug("Usuario(" + bean.getUsuario().getId() + ") matriculado na comunidade("
				+ bean.getComunidade().getId() + ")");
	}

	public List<Comunidade> obterComunidades(Usuario usuario) {
		List<Matricula> matriculas = getDelegate().find(usuario);
		List<Comunidade> comunidades = new ArrayList<Comunidade>();
		for (Matricula matricula : matriculas) {
			comunidades.add(matricula.getComunidade());
		}
		return comunidades;
	}

}
