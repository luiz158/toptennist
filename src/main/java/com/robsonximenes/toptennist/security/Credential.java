package com.robsonximenes.toptennist.security;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class Credential implements Serializable{

	private static final long serialVersionUID = 6933074973039333481L;

	private String login;

	private String senha;

	
	public String getLogin() {
		return login;
	}

	
	public void setLogin(String login) {
		this.login = login;
	}

	
	public String getSenha() {
		return senha;
	}

	
	public void setSenha(String senha) {
		this.senha = senha;
	}


	public void clear() {
		login = null;
		senha = null;
	}


	
	
}
