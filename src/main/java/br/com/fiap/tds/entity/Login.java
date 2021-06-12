package br.com.fiap.tds.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "T_LOGIN")
@SequenceGenerator(name = "seqLogin", sequenceName = "SEQ_T_LOGIN", allocationSize = 1)
public class Login {

	@Id
	@Column(name = "ID_LOGIN")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqLogin")
	private int idLogin;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="ID_USUARIO")
	private Usuario usuario;

	@Column(name = "LOGIN", length = 100)
	private String login;

	@Column(name = "SENHA", length = 12)
	private String senha;

	public Login() {
	}
	
	public Login(int idLogin,String login,String senha) {
		this.idLogin = idLogin;
		this.login = login;
		this.senha = senha;
	}

	public Login(int idLogin, Usuario usuario, String login, String senha) {
		super();
		this.idLogin = idLogin;
		this.usuario = usuario;
		this.login = login;
		this.senha = senha;
	}

	public Login(Usuario usuario, String login, String senha) {
		this.usuario = usuario;
		this.login = login;
		this.senha = senha;
	}

	public int getIdLogin() {
		return idLogin;
	}

	public void setIdLogin(int idLogin) {
		this.idLogin = idLogin;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

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

	@Override
	public String toString() {
		return "Login [idLogin=" + idLogin + ", usuario=" + usuario + ", login=" + login + ", senha=" + senha + "]";
	}
	
}
