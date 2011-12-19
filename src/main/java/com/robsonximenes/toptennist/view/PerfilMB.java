package com.robsonximenes.toptennist.view;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;

import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractEditPageBean;
import br.gov.frameworkdemoiselle.util.Faces;

import com.robsonximenes.toptennist.business.UsuarioBC;
import com.robsonximenes.toptennist.domain.Usuario;

@ViewController
@PreviousView("/home")
@SessionScoped
public class PerfilMB extends AbstractEditPageBean<Usuario,Long> {

	private static final long serialVersionUID = 1L;

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
