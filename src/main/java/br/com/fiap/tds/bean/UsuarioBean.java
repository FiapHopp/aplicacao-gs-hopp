package br.com.fiap.tds.bean;

import javax.faces.bean.RequestScoped;
import javax.inject.Named;

import br.com.fiap.tds.entity.Usuario;

@Named
@RequestScoped
public class UsuarioBean {
	
	private Usuario usuario = new Usuario();
	
	

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	

}
