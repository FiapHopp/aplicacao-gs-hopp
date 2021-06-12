package br.com.fiap.tds.test;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.tds.dao.LocalHospedagemDao;
import br.com.fiap.tds.dao.LoginDao;
import br.com.fiap.tds.dao.PontoTuristicoDao;
import br.com.fiap.tds.dao.impl.LocalHospedagemDaoImpl;
import br.com.fiap.tds.dao.impl.LoginDaoImpl;
import br.com.fiap.tds.dao.impl.PontoTuristicoDaoImpl;
import br.com.fiap.tds.entity.LocalHospedagem;
import br.com.fiap.tds.entity.Login;
import br.com.fiap.tds.entity.PontoTuristico;
import br.com.fiap.tds.singleton.EntityManagerFactorySingleton;

public class Pesquisa {
	public static void main(String[] args) {
		
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
				
		//Pesquisa Login
		LoginDao loginDao = new LoginDaoImpl(em);
		
		List<Login> logins = loginDao.listar();
		System.out.println("Listar todos os logins");
		
		for(Login login: logins) {
			System.out.println(login.getLogin());
		}

		//Pesquisa de Local de Hospedagem
		LocalHospedagemDao localHospedagemDao = new LocalHospedagemDaoImpl(em);

		LocalHospedagem localHospedagem = localHospedagemDao.pesquisar(1);
		System.out.println("Local de hospedagem");
		System.out.println(localHospedagem.toString());

		//Pesquisa de Pontos de Turistico
		PontoTuristicoDao pontoTuristicoDao = new PontoTuristicoDaoImpl(em);

		PontoTuristico pontoTuristico = pontoTuristicoDao.pesquisar(1);

		System.out.println("Local de Pontos Turisticos");
		System.out.println(pontoTuristico.toString());

		em.close();
		EntityManagerFactorySingleton.getInstance().close();
		
	}
}
