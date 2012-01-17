package com.robsonximenes.toptennist.view;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import javax.enterprise.context.SessionScoped;
import javax.faces.model.SelectItem;
import javax.inject.Inject;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;

import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractEditPageBean;
import br.gov.frameworkdemoiselle.util.Faces;

import com.robsonximenes.toptennist.business.UsuarioBC;
import com.robsonximenes.toptennist.domain.Usuario;
import com.robsonximenes.toptennist.domain.Usuario.Lateralidade;
import com.robsonximenes.toptennist.domain.Usuario.Sexo;

@ViewController
@PreviousView("/home")
@SessionScoped
public class PerfilMB extends AbstractEditPageBean<Usuario,Long> {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private UsuarioMB usuarioMB;

	@Inject 
	private UsuarioBC bc;
	
	private DefaultStreamedContent imagem;
		
	@Override
	public String delete() {
		bc.delete(getId());
		return getPreviousView();
	}

	@Override
	public String insert() {
		bc.insert(getBean());
		return getPreviousView();
	}

	@Override
	public String update() {
		bc.atualizar(getBean());
		if(usuarioMB.getLogado().getId()==getBean().getId()) {
			usuarioMB.setLogado(getBean());
		}
		return getPreviousView();
	}

	@Override
	protected void handleLoad() {
		setBean(bc.load(getId()));
	}
	
	public void handleFileUpload(FileUploadEvent event) {
		try {
			setImagem(new DefaultStreamedContent(event.getFile().getInputstream()));
			byte[] foto = event.getFile().getContents();
			this.getBean().setFoto(foto);
		} catch (IOException ex) {
			Faces.addMessage(event.getComponent().getClientId(),ex);
		}
	}
	
	public SelectItem[] getValuesSexo() {
		SelectItem[] items = new SelectItem[Sexo.values().length];
		int i = 0;
		for (Sexo g : Sexo.values()) {
			items[i++] = new SelectItem(g, g.name());
		}
		return items;
	}
	
	public SelectItem[] getValuesLateralidade() {
		SelectItem[] items = new SelectItem[Usuario.Lateralidade.values().length];
		int i = 0;
		for (Lateralidade g : Lateralidade.values()) {
			items[i++] = new SelectItem(g, g.name());
		}
		return items;
	}

	

	public void setImagem(DefaultStreamedContent imagem) {
		this.imagem = imagem;
	}

	public DefaultStreamedContent getImagem() {
		if(imagem == null){
			if(getBean().getFoto()!=null) {
				imagem = new DefaultStreamedContent(new ByteArrayInputStream(getBean().getFoto()));
			}else {
				imagem = new DefaultStreamedContent();
			}
		}
		return imagem;
	}


}
