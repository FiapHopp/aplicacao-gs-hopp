package br.com.fiap.tds.bean;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.persistence.EntityManager;

import br.com.fiap.tds.dao.impl.PontoTuristicoDaoImpl;
import br.com.fiap.tds.entity.PontoTuristico;
import br.com.fiap.tds.singleton.EntityManagerFactorySingleton;

@Named
@RequestScoped
public class PontoTuristicoBean {

	private PontoTuristico pontoTuristico = new PontoTuristico();
	
	EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();

	public void cadastrar() {
		
		new PontoTuristicoDaoImpl(em).cadastrar(this.pontoTuristico);
		System.out.println("Salvando... " + this.pontoTuristico);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Ponto turistico cadastrado com sucesso"));
	}
	
	public void editar() {
		new PontoTuristicoDaoImpl(em).alterar(pontoTuristico);
		System.out.println("Editando... " + this.pontoTuristico);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Ponto turistico editado com sucesso"));
		}
	
	public void apagar() {
		new PontoTuristicoDaoImpl(em).remover(this.pontoTuristico.getIdPontoTuristico());
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Ponto turistico deletado com sucesso"));
	}
	
	public void listar() {
		new PontoTuristicoDaoImpl(em).pesquisar(this.pontoTuristico.getIdPontoTuristico());
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Pontos turisticos listados"));
	}
	public List<PontoTuristico> getpontosTuristicos(){
		return new PontoTuristicoDaoImpl(em).getAll();
	}

	public PontoTuristico getPontoTuristico() {
		return pontoTuristico;
	}

	public void setPontoTuristico(PontoTuristico pontoTuristico) {
		this.pontoTuristico = pontoTuristico;
	}

}
