package com.robsonximenes.toptennist.security;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Alternative;
import javax.inject.Inject;

import br.gov.frameworkdemoiselle.security.Authenticator;
import br.gov.frameworkdemoiselle.security.User;

import com.robsonximenes.toptennist.business.UsuarioBC;
import com.robsonximenes.toptennist.domain.Usuario;

@Alternative
public class Autenticador implements Authenticator {

	private static final long serialVersionUID = 1509279100546462374L;

	@Inject
	private UsuarioBC userBC;

	@Inject
	private Credential credential;

	@Override
	public boolean authenticate() {
		return userBC.verificar(credential.getLogin(),credential.getSenha());
	}

	@Override
	public User getUser() {
		return new User() {

			@Override
			public String getId() {
				return credential.getLogin();
			}

			@Override
			public void setAttribute(Object key, Object value) {
			}

			@Override
			public Object getAttribute(Object key) {
				return null;
			}
		};

	}

	@Override
	public void unAuthenticate() {
		credential.clear();
	}

}
