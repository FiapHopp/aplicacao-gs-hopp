package br.com.fiap.tds.bean;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.persistence.EntityManager;

import br.com.fiap.tds.dao.impl.LoginDaoImpl;
import br.com.fiap.tds.entity.Login;
import br.com.fiap.tds.singleton.EntityManagerFactorySingleton;

@Named
@RequestScoped
public class LoginBean {

	private Login login = new Login();

	EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();

	public List<Login> getLogins() {
		return new LoginDaoImpl(em).getAll();
	}

	public void cadastrar() {
		new LoginDaoImpl(em).cadastrar(this.login);
		System.out.println("Salvando... " + this.login);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Login Cadastrado com sucesso"));
	}

	public String login() {
		FacesContext context = FacesContext.getCurrentInstance();
		boolean exist = new LoginDaoImpl(em).exist(login);
		if (exist) {
			context.getExternalContext().getSessionMap().put("login", login);
			return "index?faces-redirect=true";
		}

		context.getExternalContext().getFlash().setKeepMessages(true);
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Login inválido", ""));
		return "login?faces-redirect=true";
	}

	public String logout() {
		FacesContext context = FacesContext.getCurrentInstance();
		context.getExternalContext().getSessionMap().remove("login");

		return "login?faces-redirect=true";

	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

}
